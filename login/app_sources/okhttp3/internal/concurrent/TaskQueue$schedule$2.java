package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TaskQueue.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m839d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ Function0 $block;
    final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TaskQueue$schedule$2(Function0 function0, String str, String str2) {
        super(str2, false, 2, null);
        this.$block = function0;
        this.$name = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return ((Number) this.$block.invoke()).longValue();
    }
}
