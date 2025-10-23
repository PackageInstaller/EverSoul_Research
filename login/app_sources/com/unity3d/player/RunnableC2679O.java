package com.unity3d.player;

/* renamed from: com.unity3d.player.O */
/* loaded from: classes3.dex */
final class RunnableC2679O implements Runnable {

    /* renamed from: a */
    final long f1205a;

    /* renamed from: b */
    final long f1206b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC2679O(long j, long j2) {
        this.f1205a = j;
        this.f1206b = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f1205a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.f1206b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}
