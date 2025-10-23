package org.apache.commons.lang3.concurrent;

import com.liapp.y;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes2.dex */
public abstract class AbstractCircuitBreaker<T> implements CircuitBreaker<T> {
    public static final String PROPERTY_NAME = "open";
    protected final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    protected enum State {
        CLOSED { // from class: org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return OPEN;
            }
        },
        OPEN { // from class: org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return CLOSED;
            }
        };

        public abstract State oppositeState();
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public abstract boolean checkState();

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public abstract boolean incrementAndCheckState(T t);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean isOpen() {
        return isOpen(this.state.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean isClosed() {
        return !isOpen();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        changeState(State.CLOSED);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        changeState(State.OPEN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static boolean isOpen(State state) {
        return state == State.OPEN;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void changeState(State state) {
        if (UByte$$ExternalSyntheticBackport0.m850m(this.state, state.oppositeState(), state)) {
            this.changeSupport.firePropertyChange(y.ٴسسݬߨ(1392546450), !isOpen(state), isOpen(state));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.removePropertyChangeListener(propertyChangeListener);
    }
}
