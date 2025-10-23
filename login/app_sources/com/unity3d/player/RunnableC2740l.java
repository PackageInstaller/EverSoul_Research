package com.unity3d.player;

/* renamed from: com.unity3d.player.l */
/* loaded from: classes3.dex */
final class RunnableC2740l implements Runnable {

    /* renamed from: a */
    private IAssetPackManagerStatusQueryCallback f1397a;

    /* renamed from: b */
    private long f1398b;

    /* renamed from: c */
    private String[] f1399c;

    /* renamed from: d */
    private int[] f1400d;

    /* renamed from: e */
    private int[] f1401e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2740l(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j, String[] strArr, int[] iArr, int[] iArr2) {
        this.f1397a = iAssetPackManagerStatusQueryCallback;
        this.f1398b = j;
        this.f1399c = strArr;
        this.f1400d = iArr;
        this.f1401e = iArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1397a.onStatusResult(this.f1398b, this.f1399c, this.f1400d, this.f1401e);
    }
}
