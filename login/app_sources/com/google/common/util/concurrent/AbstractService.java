package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "starting()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.starting();
        }
    };
    private static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "running()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(Service.Listener listener) {
            listener.running();
        }
    };
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT = stoppingEvent(Service.State.STARTING);
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT = stoppingEvent(Service.State.RUNNING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT = terminatedEvent(Service.State.STARTING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(Service.State.RUNNING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    private final Monitor monitor = new Monitor();
    private final Monitor.Guard isStartable = new IsStartableGuard();
    private final Monitor.Guard isStoppable = new IsStoppableGuard();
    private final Monitor.Guard hasReachedRunning = new HasReachedRunningGuard();
    private final Monitor.Guard isStopped = new IsStoppedGuard();
    private final ListenerCallQueue<Service.Listener> listeners = new ListenerCallQueue<>();
    private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void doCancelStart() {
    }

    protected abstract void doStart();

    protected abstract void doStop();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ListenerCallQueue.Event<Service.Listener> terminatedEvent(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                listener.terminated(Service.State.this);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public String toString() {
                String valueOf = String.valueOf(Service.State.this);
                return new StringBuilder(String.valueOf(valueOf).length() + 21).append("terminated({from = ").append(valueOf).append("})").toString();
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ListenerCallQueue.Event<Service.Listener> stoppingEvent(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                listener.stopping(Service.State.this);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public String toString() {
                String valueOf = String.valueOf(Service.State.this);
                return new StringBuilder(String.valueOf(valueOf).length() + 19).append("stopping({from = ").append(valueOf).append("})").toString();
            }
        };
    }

    private final class IsStartableGuard extends Monitor.Guard {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        IsStartableGuard() {
            super(AbstractService.this.monitor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state() == Service.State.NEW;
        }
    }

    private final class IsStoppableGuard extends Monitor.Guard {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        IsStoppableGuard() {
            super(AbstractService.this.monitor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    private final class HasReachedRunningGuard extends Monitor.Guard {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HasReachedRunningGuard() {
            super(AbstractService.this.monitor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    private final class IsStoppedGuard extends Monitor.Guard {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        IsStoppedGuard() {
            super(AbstractService.this.monitor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbstractService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable)) {
            try {
                this.snapshot = new StateSnapshot(Service.State.STARTING);
                enqueueStartingEvent();
                doStart();
            } finally {
                try {
                    return this;
                } finally {
                }
            }
            return this;
        }
        String valueOf = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Service ").append(valueOf).append(" has already been started").toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable)) {
            try {
                Service.State state = state();
                switch (C16486.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                    case 1:
                        this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                        enqueueTerminatedEvent(Service.State.NEW);
                        break;
                    case 2:
                        this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);
                        enqueueStoppingEvent(Service.State.STARTING);
                        doCancelStart();
                        break;
                    case 3:
                        this.snapshot = new StateSnapshot(Service.State.STOPPING);
                        enqueueStoppingEvent(Service.State.RUNNING);
                        doStop();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        String valueOf = String.valueOf(state);
                        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 45).append("isStoppable is incorrectly implemented, saw: ").append(valueOf).toString());
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return this;
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$6 */
    static /* synthetic */ class C16486 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Service.State.values().length];
            $SwitchMap$com$google$common$util$concurrent$Service$State = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            checkCurrentState(Service.State.RUNNING);
        } finally {
            this.monitor.leave();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, j, timeUnit)) {
            try {
                checkCurrentState(Service.State.RUNNING);
                return;
            } finally {
                this.monitor.leave();
            }
        }
        String valueOf = String.valueOf(this);
        throw new TimeoutException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Timed out waiting for ").append(valueOf).append(" to reach the RUNNING state.").toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            checkCurrentState(Service.State.TERMINATED);
        } finally {
            this.monitor.leave();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, j, timeUnit)) {
            try {
                checkCurrentState(Service.State.TERMINATED);
            } finally {
                this.monitor.leave();
            }
        } else {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(state());
            throw new TimeoutException(new StringBuilder(String.valueOf(valueOf).length() + 65 + String.valueOf(valueOf2).length()).append("Timed out waiting for ").append(valueOf).append(" to reach a terminal state. Current state: ").append(valueOf2).toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkCurrentState(Service.State state) {
        Service.State state2 = state();
        if (state2 != state) {
            if (state2 == Service.State.FAILED) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(state);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length()).append("Expected the service ").append(valueOf).append(" to be ").append(valueOf2).append(", but the service has FAILED").toString(), failureCause());
            }
            String valueOf3 = String.valueOf(this);
            String valueOf4 = String.valueOf(state);
            String valueOf5 = String.valueOf(state2);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf3).length() + 38 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length()).append("Expected the service ").append(valueOf3).append(" to be ").append(valueOf4).append(", but was ").append(valueOf5).toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.state != Service.State.STARTING) {
                String valueOf = String.valueOf(this.snapshot.state);
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Cannot notifyStarted() when the service is ").append(valueOf).toString());
                notifyFailed(illegalStateException);
                throw illegalStateException;
            }
            if (this.snapshot.shutdownWhenStartupFinishes) {
                this.snapshot = new StateSnapshot(Service.State.STOPPING);
                doStop();
            } else {
                this.snapshot = new StateSnapshot(Service.State.RUNNING);
                enqueueRunningEvent();
            }
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void notifyStopped() {
        this.monitor.enter();
        try {
            Service.State state = state();
            switch (C16486.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    String valueOf = String.valueOf(state);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Cannot notifyStopped() when the service is ").append(valueOf).toString());
                case 2:
                case 3:
                case 4:
                    this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                    enqueueTerminatedEvent(state);
                    break;
            }
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void notifyFailed(Throwable th) {
        Preconditions.checkNotNull(th);
        this.monitor.enter();
        try {
            Service.State state = state();
            int i = C16486.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3 || i == 4) {
                    this.snapshot = new StateSnapshot(Service.State.FAILED, false, th);
                    enqueueFailedEvent(state, th);
                } else if (i != 5) {
                }
                return;
            }
            String valueOf = String.valueOf(state);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Failed while in state:").append(valueOf).toString(), th);
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return state() == Service.State.RUNNING;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.snapshot.externalState();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.listeners.addListener(listener, executor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String simpleName = getClass().getSimpleName();
        String valueOf = String.valueOf(state());
        return new StringBuilder(String.valueOf(simpleName).length() + 3 + String.valueOf(valueOf).length()).append(simpleName).append(" [").append(valueOf).append("]").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dispatchListenerEvents() {
        if (this.monitor.isOccupiedByCurrentThread()) {
            return;
        }
        this.listeners.dispatch();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void enqueueStartingEvent() {
        this.listeners.enqueue(STARTING_EVENT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void enqueueRunningEvent() {
        this.listeners.enqueue(RUNNING_EVENT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void enqueueStoppingEvent(Service.State state) {
        if (state == Service.State.STARTING) {
            this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
        } else {
            if (state == Service.State.RUNNING) {
                this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
                return;
            }
            throw new AssertionError();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void enqueueTerminatedEvent(Service.State state) {
        switch (C16486.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
            case 1:
                this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
                return;
            case 2:
                this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
                return;
            case 3:
                this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
                return;
            case 4:
                this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void enqueueFailedEvent(final Service.State state, final Throwable th) {
        this.listeners.enqueue(new ListenerCallQueue.Event<Service.Listener>(this) { // from class: com.google.common.util.concurrent.AbstractService.5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                listener.failed(state, th);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public String toString() {
                String valueOf = String.valueOf(state);
                String valueOf2 = String.valueOf(th);
                return new StringBuilder(String.valueOf(valueOf).length() + 27 + String.valueOf(valueOf2).length()).append("failed({from = ").append(valueOf).append(", cause = ").append(valueOf2).append("})").toString();
            }
        });
    }

    private static final class StateSnapshot {

        @CheckForNull
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StateSnapshot(Service.State state) {
            this(state, false, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StateSnapshot(Service.State state, boolean z, @CheckForNull Throwable th) {
            Preconditions.checkArgument(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.checkArgument((th != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.state = state;
            this.shutdownWhenStartupFinishes = z;
            this.failure = th;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Service.State externalState() {
            if (this.shutdownWhenStartupFinishes && this.state == Service.State.STARTING) {
                return Service.State.STOPPING;
            }
            return this.state;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Throwable failureCause() {
            Preconditions.checkState(this.state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", this.state);
            return (Throwable) Objects.requireNonNull(this.failure);
        }
    }
}
