package com.gamania.beanfunsdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.gamania.beanfunsdk.p006a.C0859b;

/* loaded from: classes.dex */
public class beanfunSDKApi {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beanfunLogin(Activity activity, String str) {
        C0859b.m85b(activity, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beanfunLogout(Context context, LogoutCallback logoutCallback) {
        C0859b.m86b(context, logoutCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkAccessToken(String str, CheckTokenCallback checkTokenCallback) {
        C0859b.m87b(str, checkTokenCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getRestoreAccessToken(Context context) {
        return C0859b.m77a(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getSDKVersion() {
        return C0859b.m88c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void initSDK(Context context) {
        C0859b.m81a(context, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void initSDK(Context context, boolean z) {
        C0859b.m81a(context, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void onActivityResult(int i, int i2, Intent intent, AccessCallback accessCallback) {
        C0859b.m78a(i, i2, intent, accessCallback);
    }
}
