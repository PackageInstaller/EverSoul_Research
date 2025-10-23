package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.p010v1.TraceMetric;
import com.google.firebase.perf.util.Constants;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class FirebasePerfTraceValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final TraceMetric traceMetric;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidCounterValue(Long l) {
        return l != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FirebasePerfTraceValidator(TraceMetric traceMetric) {
        this.traceMetric = traceMetric;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (!isValidTrace(this.traceMetric, 0)) {
            logger.warn("Invalid Trace:" + this.traceMetric.getName());
            return false;
        }
        if (!hasCounters(this.traceMetric) || areCountersValid(this.traceMetric)) {
            return true;
        }
        logger.warn("Invalid Counters for Trace:" + this.traceMetric.getName());
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasCounters(TraceMetric traceMetric) {
        if (traceMetric.getCountersCount() > 0) {
            return true;
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (it.next().getCountersCount() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean areCountersValid(TraceMetric traceMetric) {
        return areCountersValid(traceMetric, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean areCountersValid(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            return false;
        }
        if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (Map.Entry<String, Long> entry : traceMetric.getCountersMap().entrySet()) {
            if (!isValidCounterId(entry.getKey())) {
                logger.warn("invalid CounterId:" + entry.getKey());
                return false;
            }
            if (!isValidCounterValue(entry.getValue())) {
                logger.warn("invalid CounterValue:" + entry.getValue());
                return false;
            }
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (!areCountersValid(it.next(), i + 1)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isScreenTrace(TraceMetric traceMetric) {
        return traceMetric.getName().startsWith(Constants.SCREEN_TRACE_PREFIX);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidScreenTrace(TraceMetric traceMetric) {
        Long l = traceMetric.getCountersMap().get(Constants.CounterNames.FRAMES_TOTAL.toString());
        return l != null && l.compareTo((Long) 0L) > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidTrace(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            logger.warn("TraceMetric is null");
            return false;
        }
        if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        if (!isValidTraceId(traceMetric.getName())) {
            logger.warn("invalid TraceId:" + traceMetric.getName());
            return false;
        }
        if (!isValidTraceDuration(traceMetric)) {
            logger.warn("invalid TraceDuration:" + traceMetric.getDurationUs());
            return false;
        }
        if (!traceMetric.hasClientStartTimeUs()) {
            logger.warn("clientStartTimeUs is null.");
            return false;
        }
        if (isScreenTrace(traceMetric) && !isValidScreenTrace(traceMetric)) {
            logger.warn("non-positive totalFrames in screen trace " + traceMetric.getName());
            return false;
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (!isValidTrace(it.next(), i + 1)) {
                return false;
            }
        }
        return areAllAttributesValid(traceMetric.getCustomAttributesMap());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidTraceId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        return !trim.isEmpty() && trim.length() <= 100;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidTraceDuration(TraceMetric traceMetric) {
        return traceMetric != null && traceMetric.getDurationUs() > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidCounterId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            logger.warn("counterId is empty");
            return false;
        }
        if (trim.length() <= 100) {
            return true;
        }
        logger.warn("counterId exceeded max length 100");
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean areAllAttributesValid(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                validateAttribute(entry.getKey(), entry.getValue());
            } catch (IllegalArgumentException e) {
                logger.warn(e.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }
}
