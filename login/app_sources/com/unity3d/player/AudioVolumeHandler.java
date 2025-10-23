package com.unity3d.player;

import android.content.Context;

/* loaded from: classes3.dex */
public class AudioVolumeHandler implements InterfaceC2748p {

    /* renamed from: a */
    private C2750q f1147a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AudioVolumeHandler(Context context) {
        C2750q c2750q = new C2750q(context);
        this.f1147a = c2750q;
        c2750q.m813a(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m727a() {
        this.f1147a.m812a();
        this.f1147a = null;
    }

    @Override // com.unity3d.player.InterfaceC2748p
    public final native void onAudioVolumeChanged(int i);
}
