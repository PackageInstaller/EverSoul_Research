package androidx.core.os;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Handler.kt */
@Metadata(m838d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m839d2 = {"<anonymous>", "", "run"}, m840k = 3, m841mv = {1, 8, 0}, m843xi = 176)
/* loaded from: classes.dex */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ Function0<Unit> $action;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HandlerKt$postAtTime$runnable$1(Function0<Unit> function0) {
        this.$action = function0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
