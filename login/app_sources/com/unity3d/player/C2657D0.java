package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;

/* renamed from: com.unity3d.player.D0 */
/* loaded from: classes3.dex */
final class C2657D0 extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1159a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2657D0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.f1159a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        int i2;
        UnityPlayer unityPlayer = this.f1159a;
        C2692U0 c2692u0 = unityPlayer.m_MainThread;
        i2 = unityPlayer.mNaturalOrientation;
        c2692u0.f1283f = i2;
        c2692u0.f1284g = i;
        c2692u0.m760a(EnumC2688S0.f1270j);
    }
}
