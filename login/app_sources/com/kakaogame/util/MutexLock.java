package com.kakaogame.util;

import com.kakaogame.Logger;
import com.liapp.y;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MutexLock.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J\u0015\u0010\u0015\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/util/MutexLock;", "T", "", "()V", "TAG", "", "<set-?>", "content", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "", "isLock", "()Z", "isTimeout", "latch", "Ljava/util/concurrent/CountDownLatch;", "lock", "", "timeout", "", "setContent", "(Ljava/lang/Object;)V", "unlock", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class MutexLock<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInteger LOCK_ID = new AtomicInteger();
    private final String TAG;
    private T content;
    private boolean isLock;
    private boolean isTimeout;
    private final CountDownLatch latch;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ MutexLock(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> MutexLock<T> createLock() {
        return INSTANCE.createLock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void lock() {
        lock$default(this, 0L, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MutexLock() {
        this.TAG = y.ۮڭڭܬި(862900843) + LOCK_ID.getAndIncrement();
        this.latch = new CountDownLatch(1);
        this.isLock = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isLock() {
        return this.isLock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isTimeout() {
        return this.isTimeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T getContent() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void lock$default(MutexLock mutexLock, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        mutexLock.lock(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void lock(long timeout) {
        Logger.INSTANCE.m706v(this.TAG, y.٬ݯح׭٩(576290702) + timeout);
        if (this.isLock) {
            try {
                if (timeout > 0) {
                    this.isTimeout = !this.latch.await(timeout, TimeUnit.MILLISECONDS);
                } else {
                    this.latch.await();
                }
            } catch (InterruptedException e) {
                Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
            }
        } else {
            Logger.INSTANCE.m708w(this.TAG, y.֬ڱܱײٮ(-1159010007));
        }
        if (this.isTimeout) {
            Logger.INSTANCE.m708w(this.TAG, y.ݬֲ֮ܲت(1512284031));
        }
        Logger.INSTANCE.m706v(this.TAG, y.ݬֲ֮ܲت(1512283895) + timeout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void unlock() {
        Logger.INSTANCE.m706v(this.TAG, y.ٲٴݴ״ٰ(1782556680));
        if (this.isLock) {
            this.isLock = false;
            this.latch.countDown();
        } else {
            Logger.INSTANCE.m708w(this.TAG, y.֬ڱܱײٮ(-1159010007));
        }
        Logger.INSTANCE.m706v(this.TAG, y.֬ڱܱײٮ(-1159009719));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setContent(T content) {
        Logger.INSTANCE.m706v(this.TAG, y.֬ڱܱײٮ(-1159010063));
        if (this.content == null) {
            this.content = content;
        } else {
            Logger.INSTANCE.m701e(this.TAG, y.٬ݯح׭٩(576287262) + this.content + y.ݮڮֲڭܩ(-628756788) + content);
        }
    }

    /* compiled from: MutexLock.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/util/MutexLock$Companion;", "", "()V", "LOCK_ID", "Ljava/util/concurrent/atomic/AtomicInteger;", "createLock", "Lcom/kakaogame/util/MutexLock;", "T", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> MutexLock<T> createLock() {
            return new MutexLock<>(null);
        }
    }
}
