package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class Subscriber {
    private EventBus bus;
    private final Executor executor;
    private final Method method;
    final Object target;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Subscriber create(EventBus eventBus, Object obj, Method method) {
        if (isDeclaredThreadSafe(method)) {
            return new Subscriber(eventBus, obj, method);
        }
        return new SynchronizedSubscriber(eventBus, obj, method);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Subscriber(EventBus eventBus, Object obj, Method method) {
        this.bus = eventBus;
        this.target = Preconditions.checkNotNull(obj);
        this.method = method;
        method.setAccessible(true);
        this.executor = eventBus.executor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void dispatchEvent(final Object obj) {
        this.executor.execute(new Runnable() { // from class: com.google.common.eventbus.Subscriber$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                Subscriber.this.m1160lambda$dispatchEvent$0$comgooglecommoneventbusSubscriber(obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$dispatchEvent$0$com-google-common-eventbus-Subscriber, reason: not valid java name */
    /* synthetic */ void m1160lambda$dispatchEvent$0$comgooglecommoneventbusSubscriber(Object obj) {
        try {
            invokeSubscriberMethod(obj);
        } catch (InvocationTargetException e) {
            this.bus.handleSubscriberException(e.getCause(), context(obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
        try {
            this.method.invoke(this.target, Preconditions.checkNotNull(obj));
        } catch (IllegalAccessException e) {
            String valueOf = String.valueOf(obj);
            throw new Error(new StringBuilder(String.valueOf(valueOf).length() + 28).append("Method became inaccessible: ").append(valueOf).toString(), e);
        } catch (IllegalArgumentException e2) {
            String valueOf2 = String.valueOf(obj);
            throw new Error(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Method rejected target/argument: ").append(valueOf2).toString(), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SubscriberExceptionContext context(Object obj) {
        return new SubscriberExceptionContext(this.bus, obj, this.target, this.method);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        return this.target == subscriber.target && this.method.equals(subscriber.method);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isDeclaredThreadSafe(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    static final class SynchronizedSubscriber extends Subscriber {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.eventbus.Subscriber
        void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.invokeSubscriberMethod(obj);
            }
        }
    }
}
