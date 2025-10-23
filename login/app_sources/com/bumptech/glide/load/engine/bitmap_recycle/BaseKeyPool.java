package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue(20);

    abstract T create();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BaseKeyPool() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    T get() {
        T poll = this.keyPool.poll();
        return poll == null ? create() : poll;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void offer(T t) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t);
        }
    }
}
