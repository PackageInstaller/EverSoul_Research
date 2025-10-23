package com.unity3d.player;

/* renamed from: com.unity3d.player.H */
/* loaded from: classes3.dex */
final class RunnableC2664H implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f1166a;

    /* renamed from: b */
    final /* synthetic */ PermissionFragment f1167b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2664H(PermissionFragment permissionFragment, String[] strArr) {
        this.f1167b = permissionFragment;
        this.f1166a = strArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1167b.reportAllDenied(this.f1166a);
    }
}
