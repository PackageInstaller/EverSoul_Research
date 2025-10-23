package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class NetworkConnectivity extends Activity {

    /* renamed from: a */
    protected ConnectivityManager f1202a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1202a = connectivityManager;
        if (connectivityManager == null) {
            AbstractC2768z.Log(6, "NetworkConnectivity: ConnectivityManager not found");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void mo736a() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public int mo737b() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.f1202a;
        if (connectivityManager == null) {
            return 0;
        }
        if (PlatformSupport.MARSHMALLOW_SUPPORT) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = this.f1202a.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(0) ? 1 : 2;
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 0 ? 1 : 2;
            }
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.liapp.y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.liapp.y.ݯױܭ۱ݭ(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.liapp.y.ݱݬ׬۬ݨ(this);
    }
}
