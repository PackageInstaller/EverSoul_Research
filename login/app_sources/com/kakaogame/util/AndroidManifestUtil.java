package com.kakaogame.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.Logger;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidManifestUtil.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004J\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, m839d2 = {"Lcom/kakaogame/util/AndroidManifestUtil;", "", "()V", "TAG", "", "checkActivities", "", "context", "Landroid/content/Context;", "activities", "", "checkActivity", "activity", "checkBroadcastReceiver", "receiver", "checkBroadcastReceiverIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "checkBroadcastReceivers", "receivers", "checkMetaData", "metadataName", "checkPermission", "permission", "checkPermissions", "permissions", "checkService", NotificationCompat.CATEGORY_SERVICE, "checkServices", "services", "getAppName", "getMetaData", "key", "getPackageName", "getTargetSdkVersion", "", "getVersionCode", "", "getVersionName", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AndroidManifestUtil {
    public static final AndroidManifestUtil INSTANCE = new AndroidManifestUtil();
    private static final String TAG = "AndroidManifestUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AndroidManifestUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862791243), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getPackageName(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            String packageName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            return packageName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862791243), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getTargetSdkVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862791243), e.toString(), e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long getVersionCode(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return 0L;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862791243), e.toString(), e);
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862791243), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object getMetaData(Context context, String key) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.get(key);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862791243), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean checkMetaData(Context context, String metadataName) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        return INSTANCE.getMetaData(context, metadataName) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(permission, y.֬ڱܱײٮ(-1159616063));
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862791243), y.ۮڭڭܬި(862782131) + permission);
        ArrayList arrayList = new ArrayList();
        arrayList.add(permission);
        return checkPermissions(context, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean checkPermissions(Context context, List<String> permissions) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(permissions, y.دײܮڳܯ(2051593325));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782338976) + permissions;
        String str2 = y.ۮڭڭܬި(862791243);
        logger.m706v(str2, str);
        PackageManager packageManager = context.getPackageManager();
        for (String str3 : permissions) {
            try {
                Logger.INSTANCE.m706v(str2, "Check permission : " + str3 + " protection level : " + packageManager.getPermissionInfo(str3, 128).protectionLevel);
                if (context.checkCallingOrSelfPermission(str3) != 0) {
                    Logger.INSTANCE.m701e(str2, "Not granted permission : " + str3);
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.INSTANCE.m701e(str2, y.دײܮڳܯ(2051033389) + str3);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean checkActivity(Context context, String activity) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862791243), y.ۮڭڭܬި(862790123) + activity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(activity);
        return checkActivities(context, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean checkActivities(Context context, List<String> activities) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(activities, y.ٴسسݬߨ(1393118754));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051034285) + activities;
        String str2 = y.ۮڭڭܬި(862791243);
        logger.m699d(str2, str);
        PackageManager packageManager = context.getPackageManager();
        for (String str3 : activities) {
            try {
                packageManager.getActivityInfo(new ComponentName(context, str3), 128);
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.INSTANCE.m701e(str2, y.ݮڮֲڭܩ(-628261772) + str3);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkService(Context context, String service) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(service, y.֬ڱܱײٮ(-1159128135));
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862791243), y.ٲٴݴ״ٰ(1782340056) + service);
        ArrayList arrayList = new ArrayList();
        arrayList.add(service);
        return checkServices(context, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean checkServices(Context context, List<String> services) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393116282) + services;
        String str2 = y.ۮڭڭܬި(862791243);
        logger.m699d(str2, str);
        PackageManager packageManager = context.getPackageManager();
        for (String str3 : services) {
            try {
                packageManager.getServiceInfo(new ComponentName(context, str3), 128);
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.INSTANCE.m701e(str2, y.ٲٴݴ״ٰ(1782340512) + str3);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkBroadcastReceiver(Context context, String receiver) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(receiver, y.ݬֲ֮ܲت(1512075007));
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862791243), y.دײܮڳܯ(2051033029) + receiver);
        ArrayList arrayList = new ArrayList();
        arrayList.add(receiver);
        return checkBroadcastReceivers(context, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean checkBroadcastReceivers(Context context, List<String> receivers) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159130023) + receivers;
        String str2 = y.ۮڭڭܬި(862791243);
        logger.m699d(str2, str);
        PackageManager packageManager = context.getPackageManager();
        for (String str3 : receivers) {
            try {
                packageManager.getReceiverInfo(new ComponentName(context, str3), 128);
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.INSTANCE.m701e(str2, y.ٴسسݬߨ(1393117602) + str3);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkBroadcastReceiverIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(intent, y.ݬֲ֮ܲت(1512852487));
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862791243), y.֬ڱܱײٮ(-1159130023) + intent);
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryBroadcastReceivers, "queryBroadcastReceivers(...)");
        return queryBroadcastReceivers.size() != 0;
    }
}
