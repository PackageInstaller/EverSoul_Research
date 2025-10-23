package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getSize(Y y) {
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onItemEvicted(T t, Y y) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setSizeMultiplier(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f);
        evict();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized int getCount() {
        return this.cache.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Y get(T t) {
        return this.cache.get(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Y put(T t, Y y) {
        long size = getSize(y);
        if (size >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += size;
        }
        Y put = this.cache.put(t, y);
        if (put != null) {
            this.currentSize -= getSize(put);
            if (!put.equals(y)) {
                onItemEvicted(t, put);
            }
        }
        evict();
        return put;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Y remove(T t) {
        Y remove;
        remove = this.cache.remove(t);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMemory() {
        trimToSize(0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, Y>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void evict() {
        trimToSize(this.maxSize);
    }
}
