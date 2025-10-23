package com.unity3d.player;

/* renamed from: com.unity3d.player.x0 */
/* loaded from: classes3.dex */
final class C2765x0 extends AbstractRunnableC2694V0 {

    /* renamed from: b */
    final /* synthetic */ int f1487b;

    /* renamed from: c */
    final /* synthetic */ int f1488c;

    /* renamed from: d */
    final /* synthetic */ UnityPlayer f1489d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2765x0(UnityPlayer unityPlayer, int i, int i2) {
        super(unityPlayer);
        this.f1489d = unityPlayer;
        this.f1487b = i;
        this.f1488c = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractRunnableC2694V0
    /* renamed from: a */
    public final void mo761a() {
        this.f1489d.nativeSetInputSelection(this.f1487b, this.f1488c);
    }
}
