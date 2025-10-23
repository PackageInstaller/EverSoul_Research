package com.unity3d.player;

import android.content.Context;
import android.net.ConnectivityManager;

/* loaded from: classes3.dex */
public class NetworkConnectivityNougat extends NetworkConnectivity {

    /* renamed from: b */
    private int f1203b;

    /* renamed from: c */
    private final ConnectivityManager.NetworkCallback f1204c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkConnectivityNougat(Context context) {
        super(context);
        this.f1203b = 0;
        C2650A c2650a = new C2650A(this);
        this.f1204c = c2650a;
        if (this.f1202a == null) {
            return;
        }
        this.f1203b = super.mo737b();
        this.f1202a.registerDefaultNetworkCallback(c2650a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.NetworkConnectivity
    /* renamed from: a */
    public final void mo736a() {
        ConnectivityManager connectivityManager = this.f1202a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.f1204c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.NetworkConnectivity
    /* renamed from: b */
    public final int mo737b() {
        return this.f1203b;
    }
}
