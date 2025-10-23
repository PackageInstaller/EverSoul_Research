package com.unity3d.player;

import android.telephony.PhoneStateListener;

/* renamed from: com.unity3d.player.R0 */
/* loaded from: classes3.dex */
final class C2686R0 extends PhoneStateListener {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1249a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C2686R0(UnityPlayer unityPlayer) {
        this.f1249a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        this.f1249a.nativeMuteMasterAudio(i == 1);
    }
}
