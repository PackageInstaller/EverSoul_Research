package androidx.tracing;

/* loaded from: classes.dex */
final class TraceApi29Impl {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TraceApi29Impl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beginAsyncSection(String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void endAsyncSection(String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCounter(String str, int i) {
        android.os.Trace.setCounter(str, i);
    }
}
