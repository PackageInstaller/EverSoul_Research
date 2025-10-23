package _COROUTINE;

import com.liapp.y;
import kotlin.Metadata;

/* compiled from: CoroutineDebugging.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m839d2 = {"L_COROUTINE/ArtificialStackFrames;", "", "()V", "coroutineBoundary", "Ljava/lang/StackTraceElement;", "coroutineCreation", "kotlinx-coroutines-core"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes.dex */
public final class ArtificialStackFrames {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final StackTraceElement coroutineCreation() {
        StackTraceElement artificialFrame;
        artificialFrame = CoroutineDebuggingKt.artificialFrame(new Exception(), y.ݬֲ֮ܲت(1512933319));
        return artificialFrame;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final StackTraceElement coroutineBoundary() {
        StackTraceElement artificialFrame;
        artificialFrame = CoroutineDebuggingKt.artificialFrame(new Exception(), y.ۮڭڭܬި(861979955));
        return artificialFrame;
    }
}
