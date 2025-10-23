package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.kakao.sdk.share.Constants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class EventBus {
    private static final Logger logger = Logger.getLogger(EventBus.class.getName());
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventBus() {
        this(Constants.VALIDATION_DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this(Constants.VALIDATION_DEFAULT, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), subscriberExceptionHandler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EventBus(String str, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscribers = new SubscriberRegistry(this);
        this.identifier = (String) Preconditions.checkNotNull(str);
        this.executor = (Executor) Preconditions.checkNotNull(executor);
        this.dispatcher = (Dispatcher) Preconditions.checkNotNull(dispatcher);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String identifier() {
        return this.identifier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Executor executor() {
        return this.executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void handleSubscriberException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.checkNotNull(th);
        Preconditions.checkNotNull(subscriberExceptionContext);
        try {
            this.exceptionHandler.handleException(th, subscriberExceptionContext);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, th), th2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void register(Object obj) {
        this.subscribers.register(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregister(Object obj) {
        this.subscribers.unregister(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void post(Object obj) {
        Iterator<Subscriber> subscribers = this.subscribers.getSubscribers(obj);
        if (subscribers.hasNext()) {
            this.dispatcher.dispatch(obj, subscribers);
        } else {
            if (obj instanceof DeadEvent) {
                return;
            }
            post(new DeadEvent(this, obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.identifier).toString();
    }

    static final class LoggingHandler implements SubscriberExceptionHandler {
        static final LoggingHandler INSTANCE = new LoggingHandler();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LoggingHandler() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            Logger logger = logger(subscriberExceptionContext);
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, message(subscriberExceptionContext), th);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static Logger logger(SubscriberExceptionContext subscriberExceptionContext) {
            String name = EventBus.class.getName();
            String identifier = subscriberExceptionContext.getEventBus().identifier();
            return Logger.getLogger(new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(identifier).length()).append(name).append(".").append(identifier).toString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static String message(SubscriberExceptionContext subscriberExceptionContext) {
            Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            String name = subscriberMethod.getName();
            String name2 = subscriberMethod.getParameterTypes()[0].getName();
            String valueOf = String.valueOf(subscriberExceptionContext.getSubscriber());
            String valueOf2 = String.valueOf(subscriberExceptionContext.getEvent());
            return new StringBuilder(String.valueOf(name).length() + 80 + String.valueOf(name2).length() + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length()).append("Exception thrown by subscriber method ").append(name).append('(').append(name2).append(") on subscriber ").append(valueOf).append(" when dispatching event: ").append(valueOf2).toString();
        }
    }
}
