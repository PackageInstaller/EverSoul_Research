package com.singular.sdk.internal.InstallReferrer;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class SLDigitalTurbineReferrer implements SLInstallReferrerService {
    private static final SingularLog logger = SingularLog.getLogger("SLDigitalTurbineReferrer");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerService
    public void fetchReferrer(Context context, SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        if (context == null) {
            sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
            return;
        }
        HashMap hashMap = new HashMap();
        String readContentProviderIntentAction = readContentProviderIntentAction(context, "android.permission.INSTALL_PACKAGES");
        if (readContentProviderIntentAction != null) {
            hashMap.put(Constants.DT_INSTALL_REFERRER_KEY, readContentProviderIntentAction);
            sLInstallReferrerCompletionHandler.onInstallReferrerReceived(hashMap);
        } else {
            sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String readContentProvider(Context context, String str, ContentProviderClient contentProviderClient) {
        Cursor query;
        try {
            Uri parse = Uri.parse(str);
            String[] strArr = {"encrypted_data"};
            String[] strArr2 = {context.getPackageName()};
            if (contentProviderClient != null) {
                query = contentProviderClient.query(parse, strArr, "package_name=?", strArr2, null);
            } else {
                query = context.getContentResolver().query(parse, strArr, null, null, null);
            }
            if (query == null) {
                logger.debug("Read content provider cursor null content uri [%s]", str);
                return null;
            }
            if (!query.moveToFirst()) {
                logger.debug("Read content provider cursor empty content uri [%s]", str);
                query.close();
                return null;
            }
            String string = query.getString(0);
            logger.debug("Read Content Provider Payload is " + string);
            query.close();
            return string;
        } catch (Throwable th) {
            logger.error("Exception read content provider uri [%s] error [%s]", str, th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String readContentProviderIntentAction(Context context, String str) {
        List<ResolveInfo> queryIntentContentProviders;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent(Constants.DT_CONTENT_PROVIDER_INTENT_ACTION_NAME), PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_URI));
            } else {
                queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent(Constants.DT_CONTENT_PROVIDER_INTENT_ACTION_NAME), 131072);
            }
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentContentProviders) {
                if (checkIfPackageReadingPermissionIsGranted(context, str, resolveInfo)) {
                    String fetchContentFromProvider = fetchContentFromProvider(context, resolveInfo);
                    if (!Utils.isEmptyOrNull(fetchContentFromProvider)) {
                        arrayList.add(fetchContentFromProvider);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                logger.debug("Payload read successfully from URI: " + arrayList);
                return (String) arrayList.get(0);
            }
        } catch (Throwable unused) {
        }
        logger.debug("No payloads found in content providers.");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String readContentProviderWithClient(Context context, String str) {
        try {
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(str);
            String readContentProvider = readContentProvider(context, formatURIString(str, Constants.PREINSTALL_CONTENT_URI_PATH), acquireUnstableContentProviderClient);
            acquireUnstableContentProviderClient.release();
            return readContentProvider;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String formatURIString(String str, String str2) {
        return String.format("content://%s/%s", str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean checkIfPackageReadingPermissionIsGranted(Context context, String str, ResolveInfo resolveInfo) {
        return str != null && context.getPackageManager().checkPermission(str, resolveInfo.providerInfo.packageName) == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String fetchContentFromProvider(Context context, ResolveInfo resolveInfo) {
        String str = resolveInfo.providerInfo.authority;
        if (Utils.isEmptyOrNull(str)) {
            return null;
        }
        return readContentProviderWithClient(context, str);
    }
}
