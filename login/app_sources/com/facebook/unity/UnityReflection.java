package com.facebook.unity;

import android.app.Activity;
import android.util.Log;

/* loaded from: classes.dex */
public class UnityReflection {
    private static Class<?> unityPlayer;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void SendMessage(String str, String str2, String str3) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            unityPlayer.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(unityPlayer, str, str2, str3);
        } catch (Exception e) {
            Log.d("TODO", e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Activity GetUnityActivity() {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            Activity activity = (Activity) unityPlayer.getField("currentActivity").get(null);
            if (activity == null) {
                Log.d(C0848FB.TAG, "Current unity activity is null");
            }
            return activity;
        } catch (Exception e) {
            Log.d(C0848FB.TAG, e.toString());
            return null;
        }
    }
}
