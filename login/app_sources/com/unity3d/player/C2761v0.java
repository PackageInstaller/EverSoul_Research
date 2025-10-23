package com.unity3d.player;

/* renamed from: com.unity3d.player.v0 */
/* loaded from: classes3.dex */
final class C2761v0 extends AbstractRunnableC2694V0 {

    /* renamed from: b */
    final /* synthetic */ boolean f1452b;

    /* renamed from: c */
    final /* synthetic */ String f1453c;

    /* renamed from: d */
    final /* synthetic */ int f1454d;

    /* renamed from: e */
    final /* synthetic */ UnityPlayer f1455e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2761v0(UnityPlayer unityPlayer, boolean z, String str, int i) {
        super(unityPlayer);
        this.f1455e = unityPlayer;
        this.f1452b = z;
        this.f1453c = str;
        this.f1454d = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractRunnableC2694V0
    /* renamed from: a */
    public final void mo761a() {
        if (this.f1452b) {
            this.f1455e.nativeSoftInputCanceled();
        } else {
            String str = this.f1453c;
            if (str != null) {
                this.f1455e.nativeSetInputString(str);
            }
        }
        if (this.f1454d == 1) {
            this.f1455e.nativeSoftInputClosed();
        }
    }
}
