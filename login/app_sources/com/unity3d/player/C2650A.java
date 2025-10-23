package com.unity3d.player;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* renamed from: com.unity3d.player.A */
/* loaded from: classes3.dex */
final class C2650A extends ConnectivityManager.NetworkCallback {

    /* renamed from: a */
    final /* synthetic */ NetworkConnectivityNougat f1145a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2650A(NetworkConnectivityNougat networkConnectivityNougat) {
        this.f1145a = networkConnectivityNougat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        NetworkConnectivityNougat networkConnectivityNougat;
        int i;
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasTransport(0)) {
            networkConnectivityNougat = this.f1145a;
            i = 1;
        } else {
            networkConnectivityNougat = this.f1145a;
            i = 2;
        }
        networkConnectivityNougat.f1203b = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        this.f1145a.f1203b = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        this.f1145a.f1203b = 0;
    }
}
