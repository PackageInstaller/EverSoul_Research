package androidx.tracing;

/* loaded from: classes.dex */
final class TraceApi18Impl {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TraceApi18Impl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beginSection(String str) {
        android.os.Trace.beginSection(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void endSection() {
        android.os.Trace.endSection();
    }
}
