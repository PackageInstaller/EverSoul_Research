package com.appa.androidutil;

import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import com.liapp.y;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes.dex */
public class UtilManager {
    private String TAG = y.ٲٴݴ״ٰ(1781553792);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAndID() {
        return Settings.Secure.getString(UnityPlayer.currentActivity.getContentResolver(), y.ݮڮֲڭܩ(-629050348));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void ToastMessage(final String str, final int i) {
        Log.i(this.TAG, y.֬ڱܱײٮ(-1159390655) + str);
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.appa.androidutil.UtilManager.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                Toast makeText = Toast.makeText(UnityPlayer.currentActivity.getApplicationContext(), str, i);
                y.٬خݮ۳ݯ();
                makeText.show();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String GetCountry() {
        return UnityPlayer.currentActivity.getResources().getConfiguration().locale.getCountry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String GetISOCountryCode() {
        Log.i(this.TAG, y.֬ڱܱײٮ(-1159391039));
        TelephonyManager telephonyManager = (TelephonyManager) UnityPlayer.currentActivity.getSystemService(y.ۮڭڭܬި(862007203));
        if (telephonyManager == null) {
            return "";
        }
        Log.i(this.TAG, y.٬ݯح׭٩(576094974) + telephonyManager.getSimCountryIso());
        return telephonyManager.getSimCountryIso();
    }
}
