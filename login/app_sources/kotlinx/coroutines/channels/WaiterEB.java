package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.Waiter;

/* compiled from: BufferedChannel.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m839d2 = {"Lkotlinx/coroutines/channels/WaiterEB;", "", "waiter", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/Waiter;)V", "toString", "", "kotlinx-coroutines-core"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
final class WaiterEB {
    public final Waiter waiter;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WaiterEB(Waiter waiter) {
        this.waiter = waiter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "WaiterEB(" + this.waiter + ')';
    }
}
