package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class Dispatcher {
    abstract void dispatch(Object obj, Iterator<Subscriber> it);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Dispatcher() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    private static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>(this) { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.ThreadLocal
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>(this) { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    return false;
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(it);
            Queue<Event> queue = this.queue.get();
            queue.offer(new Event(obj, it));
            if (this.dispatching.get().booleanValue()) {
                return;
            }
            this.dispatching.set(true);
            while (true) {
                try {
                    Event poll = queue.poll();
                    if (poll == null) {
                        return;
                    }
                    while (poll.subscribers.hasNext()) {
                        ((Subscriber) poll.subscribers.next()).dispatchEvent(poll.event);
                    }
                } finally {
                    this.dispatching.remove();
                    this.queue.remove();
                }
            }
        }

        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Event(Object obj, Iterator<Subscriber> it) {
                this.event = obj;
                this.subscribers = it;
            }
        }
    }

    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.queue.add(new EventWithSubscriber(obj, it.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.subscriber.dispatchEvent(poll.event);
                }
            }
        }

        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.event = obj;
                this.subscriber = subscriber;
            }
        }
    }

    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ImmediateDispatcher() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().dispatchEvent(obj);
            }
        }
    }
}
