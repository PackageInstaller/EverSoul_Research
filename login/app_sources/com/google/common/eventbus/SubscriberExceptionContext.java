package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class SubscriberExceptionContext {
    private final Object event;
    private final EventBus eventBus;
    private final Object subscriber;
    private final Method subscriberMethod;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.eventBus = (EventBus) Preconditions.checkNotNull(eventBus);
        this.event = Preconditions.checkNotNull(obj);
        this.subscriber = Preconditions.checkNotNull(obj2);
        this.subscriberMethod = (Method) Preconditions.checkNotNull(method);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventBus getEventBus() {
        return this.eventBus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getEvent() {
        return this.event;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getSubscriber() {
        return this.subscriber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Method getSubscriberMethod() {
        return this.subscriberMethod;
    }
}
