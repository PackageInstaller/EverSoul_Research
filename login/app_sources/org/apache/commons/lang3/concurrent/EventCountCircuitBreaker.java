package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes2.dex */
public class EventCountCircuitBreaker extends AbstractCircuitBreaker<Integer> {
    private static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP = createStrategyMap();
    private final AtomicReference<CheckIntervalData> checkIntervalData;
    private final long closingInterval;
    private final int closingThreshold;
    private final long openingInterval;
    private final int openingThreshold;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2, long j2, TimeUnit timeUnit2) {
        this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0L));
        this.openingThreshold = i;
        this.openingInterval = timeUnit.toNanos(j);
        this.closingThreshold = i2;
        this.closingInterval = timeUnit2.toNanos(j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit, int i2) {
        this(i, j, timeUnit, i2, j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventCountCircuitBreaker(int i, long j, TimeUnit timeUnit) {
        this(i, j, timeUnit, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getOpeningThreshold() {
        return this.openingThreshold;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getOpeningInterval() {
        return this.openingInterval;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getClosingThreshold() {
        return this.closingThreshold;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getClosingInterval() {
        return this.closingInterval;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        return performStateCheck(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Integer num) {
        return performStateCheck(num.intValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean incrementAndCheckState() {
        return incrementAndCheckState((Integer) 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        super.open();
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        super.close();
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean performStateCheck(int i) {
        AbstractCircuitBreaker.State state;
        CheckIntervalData checkIntervalData;
        CheckIntervalData nextCheckIntervalData;
        do {
            long now = now();
            state = this.state.get();
            checkIntervalData = this.checkIntervalData.get();
            nextCheckIntervalData = nextCheckIntervalData(i, checkIntervalData, state, now);
        } while (!updateCheckIntervalData(checkIntervalData, nextCheckIntervalData));
        if (stateStrategy(state).isStateTransition(this, checkIntervalData, nextCheckIntervalData)) {
            state = state.oppositeState();
            changeStateAndStartNewCheckInterval(state);
        }
        return !isOpen(state);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
        return checkIntervalData == checkIntervalData2 || UByte$$ExternalSyntheticBackport0.m850m(this.checkIntervalData, checkIntervalData, checkIntervalData2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        changeState(state);
        this.checkIntervalData.set(new CheckIntervalData(0, now()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CheckIntervalData nextCheckIntervalData(int i, CheckIntervalData checkIntervalData, AbstractCircuitBreaker.State state, long j) {
        if (stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData, j)) {
            return new CheckIntervalData(i, j);
        }
        return checkIntervalData.increment(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    long now() {
        return System.nanoTime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static StateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        return STRATEGY_MAP.get(state);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
        EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
        enumMap.put((EnumMap) AbstractCircuitBreaker.State.CLOSED, (AbstractCircuitBreaker.State) new StateStrategyClosed());
        enumMap.put((EnumMap) AbstractCircuitBreaker.State.OPEN, (AbstractCircuitBreaker.State) new StateStrategyOpen());
        return enumMap;
    }

    private static class CheckIntervalData {
        private final long checkIntervalStart;
        private final int eventCount;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CheckIntervalData(int i, long j) {
            this.eventCount = i;
            this.checkIntervalStart = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getEventCount() {
            return this.eventCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getCheckIntervalStart() {
            return this.checkIntervalStart;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CheckIntervalData increment(int i) {
            return i == 0 ? this : new CheckIntervalData(getEventCount() + i, getCheckIntervalStart());
        }
    }

    private static abstract class StateStrategy {
        protected abstract long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker);

        public abstract boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StateStrategy() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long j) {
            return j - checkIntervalData.getCheckIntervalStart() > fetchCheckInterval(eventCountCircuitBreaker);
        }
    }

    private static class StateStrategyClosed extends StateStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StateStrategyClosed() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        protected long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getOpeningInterval();
        }
    }

    private static class StateStrategyOpen extends StateStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StateStrategyOpen() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy
        protected long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getClosingInterval();
        }
    }
}
