package com.kakaogame.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.Logger;
import com.liapp.y;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AppUtil.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u001e\u0010\u0014\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/util/AppUtil;", "", "()V", "SCHEME_DELIMITER", "", "TAG", "isAppForeground", "", "context", "Landroid/content/Context;", "isInstalledWithPackageName", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "isInstalledWithUrlScheme", "urlScheme", "killAppProcess", "", "launchAndroidApp", "url", "launchApp", "launchIntent", "launchMarket", "webUrl", "launchViewer", "uri", "Landroid/net/Uri;", "terminateApp", "activity", "Landroid/app/Activity;", "terminateAppReservation", "delaySec", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AppUtil {
    public static final AppUtil INSTANCE = new AppUtil();
    private static final String SCHEME_DELIMITER = "://";
    private static final String TAG = "AppUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void launchMarket(Context context) {
        launchMarket$default(context, null, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AppUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void launchMarket$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        launchMarket(context, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void launchMarket(Context context, String webUrl) {
        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782339672), y.٬ݯح׭٩(576357878) + webUrl);
        if (context == null) {
            return;
        }
        String str = webUrl;
        boolean z = str == null || str.length() == 0;
        String str2 = y.ٲٴݴ״ٰ(1781642640);
        if (z) {
            Intent intent = new Intent(str2, Uri.parse(y.٬ݯح׭٩(576575190) + context.getPackageName()));
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        } else {
            Intent intent2 = new Intent(str2);
            intent2.setData(Uri.parse(webUrl));
            intent2.setPackage("com.android.vending");
            context.startActivity(intent2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isInstalledWithPackageName(Context context, String packageName) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(packageName, y.ٴسسݬߨ(1392791418));
        try {
            return context.getPackageManager().getPackageInfo(packageName, 1) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:6:0x002b, B:8:0x0031, B:14:0x003e, B:16:0x004c, B:17:0x005d), top: B:5:0x002b }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isInstalledWithUrlScheme(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = -628270524(0xffffffffda8d5a44, float:-1.989361E16)
            java.lang.String r0 = com.liapp.y.ݮڮֲڭܩ(r0)
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 2051032549(0x7a4045e5, float:2.4958466E35)
            java.lang.String r3 = com.liapp.y.دײܮڳܯ(r3)
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            r3 = 1782339672(0x6a3c5858, float:5.692381E25)
            java.lang.String r3 = com.liapp.y.ٲٴݴ״ٰ(r3)
            r1.m699d(r3, r2)
            r1 = 0
            if (r8 != 0) goto L2b
            return r1
        L2b:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L80
            r4 = 1
            if (r2 == 0) goto L3a
            int r2 = r2.length()     // Catch: java.lang.Exception -> L80
            if (r2 != 0) goto L38
            goto L3a
        L38:
            r2 = r1
            goto L3b
        L3a:
            r2 = r4
        L3b:
            if (r2 == 0) goto L3e
            return r1
        L3e:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L80
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> L80
            r6 = 2
            r7 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default(r2, r5, r1, r6, r7)     // Catch: java.lang.Exception -> L80
            if (r2 != 0) goto L5d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L80
            r2.<init>()     // Catch: java.lang.Exception -> L80
            java.lang.StringBuilder r9 = r2.append(r9)     // Catch: java.lang.Exception -> L80
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch: java.lang.Exception -> L80
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L80
        L5d:
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch: java.lang.Exception -> L80
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L80
            java.lang.String r2 = "android.intent.action.VIEW"
            r0.<init>(r2, r9)     // Catch: java.lang.Exception -> L80
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch: java.lang.Exception -> L80
            r9 = 65536(0x10000, float:9.1835E-41)
            java.util.List r8 = r8.queryIntentActivities(r0, r9)     // Catch: java.lang.Exception -> L80
            java.lang.String r9 = "queryIntentActivities(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch: java.lang.Exception -> L80
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Exception -> L80
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Exception -> L80
            r1 = r8 ^ 1
            goto L8c
        L80:
            r8 = move-exception
            com.kakaogame.Logger r9 = com.kakaogame.Logger.INSTANCE
            java.lang.String r0 = r8.toString()
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r9.m702e(r3, r0, r8)
        L8c:
            return r1
            fill-array 0x008e: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.util.AppUtil.isInstalledWithUrlScheme(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean launchApp(Context context, String urlScheme) {
        String str = y.ݮڮֲڭܩ(-628270524);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(urlScheme, y.ݬֲ֮ܲت(1512073887));
        Logger logger = Logger.INSTANCE;
        String str2 = y.֬ڱܱײٮ(-1159127967) + urlScheme;
        String str3 = y.ٲٴݴ״ٰ(1782339672);
        logger.m699d(str3, str2);
        try {
            if (!isInstalledWithUrlScheme(context, urlScheme)) {
                return false;
            }
            if (!StringsKt.contains$default((CharSequence) urlScheme, (CharSequence) str, false, 2, (Object) null)) {
                urlScheme = urlScheme + str;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(urlScheme));
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean launchIntent(Context context, String url) {
        String str = y.٬ݯح׭٩(576575190);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(url, 1);
            String str2 = parseUri.getPackage();
            if (str2 == null) {
                return false;
            }
            if (context.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                context.startActivity(parseUri);
            } else {
                String authority = Uri.parse(url).getAuthority();
                Intrinsics.checkNotNull(authority);
                boolean contains$default = StringsKt.contains$default((CharSequence) authority, (CharSequence) "play.app.goo.gl", false, 2, (Object) null);
                String str3 = y.ٲٴݴ״ٰ(1781642640);
                if (contains$default) {
                    if (StringsKt.startsWith$default(url, SDKConstants.PARAM_INTENT, false, 2, (Object) null)) {
                        String substring = url.substring(StringsKt.indexOf$default((CharSequence) url, "=", 0, false, 6, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) url, "#", 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        url = StringsKt.replace$default(substring, "%3D", "=", false, 4, (Object) null);
                    }
                    context.startActivity(new Intent(str3, Uri.parse(url)));
                } else {
                    Intent intent = new Intent(str3, Uri.parse(url));
                    intent.setData(Uri.parse(str + parseUri.getPackage()));
                    context.startActivity(intent);
                }
            }
            return true;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782339672), e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean launchAndroidApp(Context context, String url) {
        String str = y.٬ݯح׭٩(576575190);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(url, 2);
            PackageManager packageManager = context.getPackageManager();
            String str2 = parseUri.getPackage();
            Intrinsics.checkNotNull(str2);
            if (packageManager.getLaunchIntentForPackage(str2) != null) {
                context.startActivity(parseUri);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str + parseUri.getPackage()));
                context.startActivity(intent);
            }
            return true;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782339672), e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void launchViewer(Context context, String webUrl) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (TextUtils.isEmpty(webUrl)) {
            return;
        }
        launchViewer(context, Uri.parse(webUrl));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void launchViewer(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393115666) + uri;
        String str2 = y.ٲٴݴ״ٰ(1782339672);
        logger.m699d(str2, str);
        if (uri == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void terminateApp(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        try {
            activity.finishAffinity();
        } catch (Throwable unused) {
        }
        killAppProcess();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void terminateAppReservation(final Activity activity, final long delaySec) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.util.AppUtil$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                AppUtil.terminateAppReservation$lambda$1(delaySec, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void terminateAppReservation$lambda$1(long j, final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        try {
            new Handler().postDelayed(new Runnable() { // from class: com.kakaogame.util.AppUtil$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    AppUtil.terminateAppReservation$lambda$1$lambda$0(activity);
                }
            }, j * 1000);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782339672), e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void terminateAppReservation$lambda$1$lambda$0(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        terminateApp(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void killAppProcess() {
        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782339672), y.دײܮڳܯ(2051031557));
        Process.killProcess(Process.myPid());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isAppForeground(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> list = runningAppProcesses;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.importance == 100 && Intrinsics.areEqual(runningAppProcessInfo.processName, packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782339672), e.toString(), e);
            return false;
        }
    }
}
