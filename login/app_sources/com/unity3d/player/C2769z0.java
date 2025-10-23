package com.unity3d.player;

/* renamed from: com.unity3d.player.z0 */
/* loaded from: classes3.dex */
final class C2769z0 extends AbstractRunnableC2694V0 {

    /* renamed from: b */
    final /* synthetic */ boolean f1493b;

    /* renamed from: c */
    final /* synthetic */ UnityPlayer f1494c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2769z0(UnityPlayer unityPlayer, boolean z) {
        super(unityPlayer);
        this.f1494c = unityPlayer;
        this.f1493b = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractRunnableC2694V0
    /* renamed from: a */
    public final void mo761a() {
        this.f1494c.nativeSetKeyboardIsVisible(this.f1493b);
    }
}
