package com.kakao.sdk.common.util;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* compiled from: KakaoCustomTabsClient.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0013"}, m839d2 = {"Lcom/kakao/sdk/common/util/KakaoCustomTabsClient;", "", "()V", "chromePackageNames", "", "", "[Ljava/lang/String;", "isPackageNameChrome", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, AbstractCircuitBreaker.PROPERTY_NAME, "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "openWithDefault", "Landroid/content/ServiceConnection;", "resolveCustomTabsPackage", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoCustomTabsClient {
    public static final KakaoCustomTabsClient INSTANCE = new KakaoCustomTabsClient();
    private static final String[] chromePackageNames = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoCustomTabsClient() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServiceConnection openWithDefault(final Context context, final Uri uri) throws UnsupportedOperationException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        final String resolveCustomTabsPackage = resolveCustomTabsPackage(context, uri);
        if (resolveCustomTabsPackage == null) {
            throw new UnsupportedOperationException();
        }
        SdkLog.INSTANCE.m469d("Choosing " + resolveCustomTabsPackage + " as custom tabs browser");
        CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.kakao.sdk.common.util.KakaoCustomTabsClient$openWithDefault$connection$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(client, "client");
                CustomTabsIntent.Builder showTitle = new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).setShowTitle(true);
                Intrinsics.checkNotNullExpressionValue(showTitle, "Builder().setUrlBarHidin…(true).setShowTitle(true)");
                CustomTabsIntent build = showTitle.build();
                Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
                build.intent.setData(uri);
                build.intent.setPackage(resolveCustomTabsPackage);
                context.startActivity(build.intent);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                SdkLog.INSTANCE.m469d(Intrinsics.stringPlus("onServiceDisconnected: ", name));
            }
        };
        if (CustomTabsClient.bindCustomTabsService(context, resolveCustomTabsPackage, customTabsServiceConnection)) {
            return customTabsServiceConnection;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void open(Context context, Uri uri) throws ActivityNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).setShowTitle(true).build().launchUrl(context, uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String resolveCustomTabsPackage(Context context, Uri uri) {
        ResolveInfo resolveActivity;
        List<ResolveInfo> queryIntentServices;
        ActivityInfo activityInfo;
        ActivityInfo activityInfo2;
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (Build.VERSION.SDK_INT >= 33) {
            resolveActivity = context.getPackageManager().resolveActivity(intent, PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        } else {
            resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        }
        Intent action = new Intent().setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        Intrinsics.checkNotNullExpressionValue(action, "Intent().setAction(Custo…N_CUSTOM_TABS_CONNECTION)");
        if (Build.VERSION.SDK_INT >= 33) {
            queryIntentServices = context.getPackageManager().queryIntentServices(action, PackageManager.ResolveInfoFlags.of(0L));
        } else {
            queryIntentServices = context.getPackageManager().queryIntentServices(action, 0);
        }
        Intrinsics.checkNotNullExpressionValue(queryIntentServices, "if (Build.VERSION.SDK_IN…rviceIntent, 0)\n        }");
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        String str = null;
        String str2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (str2 == null) {
                String str3 = next.serviceInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(str3, "info.serviceInfo.packageName");
                if (isPackageNameChrome(str3)) {
                    str2 = next.serviceInfo.packageName;
                }
            }
            if (Intrinsics.areEqual(next.serviceInfo.packageName, (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) ? null : activityInfo.packageName)) {
                if (resolveActivity != null && (activityInfo2 = resolveActivity.activityInfo) != null) {
                    str = activityInfo2.packageName;
                }
            }
        }
        return (str != null || str2 == null) ? str : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isPackageNameChrome(String packageName) {
        return ArraysKt.contains(chromePackageNames, packageName);
    }
}
