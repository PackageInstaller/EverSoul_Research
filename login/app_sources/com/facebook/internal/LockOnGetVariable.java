package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LockOnGetVariable.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, m839d2 = {"Lcom/facebook/internal/LockOnGetVariable;", "T", "", "value", "(Ljava/lang/Object;)V", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)V", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "storedValue", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "waitOnInit", "", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class LockOnGetVariable<T> {
    private CountDownLatch initLatch;
    private T storedValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T getValue() {
        waitOnInit();
        return this.storedValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LockOnGetVariable(T t) {
        this.storedValue = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LockOnGetVariable(final Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.internal.LockOnGetVariable$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void m1089_init_$lambda0;
                m1089_init_$lambda0 = LockOnGetVariable.m1089_init_$lambda0(LockOnGetVariable.this, callable);
                return m1089_init_$lambda0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final Void m1089_init_$lambda0(LockOnGetVariable this$0, Callable callable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callable, "$callable");
        try {
            this$0.storedValue = (T) callable.call();
        } finally {
            CountDownLatch countDownLatch = this$0.initLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void waitOnInit() {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch == null) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }
}
