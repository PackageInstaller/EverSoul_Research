package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* compiled from: DebugStrings.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, m839d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DebugStringsKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String toDebugString(Continuation<?> continuation) {
        Object m1440constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m1440constructorimpl = Result.m1440constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m1440constructorimpl = Result.m1440constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1443exceptionOrNullimpl(m1440constructorimpl) != null) {
            m1440constructorimpl = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) m1440constructorimpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
