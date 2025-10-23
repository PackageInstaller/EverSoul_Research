package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DiskCacheWriteLocker() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void acquire(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = this.locks.get(str);
            if (writeLock == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(str, writeLock);
            }
            writeLock.interestedThreads++;
        }
        writeLock.lock.lock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void release(String str) {
        WriteLock writeLock;
        String str2 = y.ۮڭڭܬި(862082195);
        String str3 = y.دײܮڳܯ(2052013413);
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.checkNotNull(this.locks.get(str));
            if (writeLock.interestedThreads < 1) {
                throw new IllegalStateException(str3 + str + ", interestedThreads: " + writeLock.interestedThreads);
            }
            writeLock.interestedThreads--;
            if (writeLock.interestedThreads == 0) {
                WriteLock remove = this.locks.remove(str);
                if (!remove.equals(writeLock)) {
                    throw new IllegalStateException(str2 + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.writeLockPool.offer(remove);
            }
        }
        writeLock.lock.unlock();
    }

    private static class WriteLock {
        int interestedThreads;
        final Lock lock = new ReentrantLock();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        WriteLock() {
        }
    }

    private static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool = new ArrayDeque();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        WriteLockPool() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        WriteLock obtain() {
            WriteLock poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            return poll == null ? new WriteLock() : poll;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }
}
