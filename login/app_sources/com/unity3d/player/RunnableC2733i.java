package com.unity3d.player;

/* renamed from: com.unity3d.player.i */
/* loaded from: classes3.dex */
final class RunnableC2733i implements Runnable {

    /* renamed from: a */
    private IAssetPackManagerMobileDataConfirmationCallback f1376a;

    /* renamed from: b */
    private boolean f1377b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2733i(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
        this.f1376a = iAssetPackManagerMobileDataConfirmationCallback;
        this.f1377b = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1376a.onMobileDataConfirmationResult(this.f1377b);
    }
}
