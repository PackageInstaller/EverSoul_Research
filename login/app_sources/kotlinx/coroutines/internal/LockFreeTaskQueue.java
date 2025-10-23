package kotlinx.coroutines.internal;

import com.kakaogame.server.ServerConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* compiled from: LockFreeTaskQueue.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001cR\u001f\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0082\u0004R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m839d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", ServerConstants.SIZE, "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class LockFreeTaskQueue<E> {
    private static final AtomicReferenceFieldUpdater _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");

    @Volatile
    private volatile Object _cur;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LockFreeTaskQueue(boolean z) {
        this._cur = new LockFreeTaskQueueCore(8, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getSize() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void close() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore.close()) {
                return;
            } else {
                UByte$$ExternalSyntheticBackport0.m852m(_cur$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean addLast(E element) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            int addLast = lockFreeTaskQueueCore.addLast(element);
            if (addLast == 0) {
                return true;
            }
            if (addLast == 1) {
                UByte$$ExternalSyntheticBackport0.m852m(_cur$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            } else if (addLast == 2) {
                return false;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final E removeFirstOrNull() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            E e = (E) lockFreeTaskQueueCore.removeFirstOrNull();
            if (e != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e;
            }
            UByte$$ExternalSyntheticBackport0.m852m(_cur$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).map(transform);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).isClosed();
    }
}
