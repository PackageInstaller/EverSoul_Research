package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> queue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ConsumingQueueIterator(Queue<T> queue) {
        this.queue = (Queue) Preconditions.checkNotNull(queue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.AbstractIterator
    @CheckForNull
    public T computeNext() {
        if (this.queue.isEmpty()) {
            return endOfData();
        }
        return this.queue.remove();
    }
}
