package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.p010v1.GaugeMetric;

/* loaded from: classes2.dex */
final class FirebasePerfGaugeMetricValidator extends PerfMetricValidator {
    private final GaugeMetric gaugeMetric;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FirebasePerfGaugeMetricValidator(GaugeMetric gaugeMetric) {
        this.gaugeMetric = gaugeMetric;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        return this.gaugeMetric.hasSessionId() && (this.gaugeMetric.getCpuMetricReadingsCount() > 0 || this.gaugeMetric.getAndroidMemoryReadingsCount() > 0 || (this.gaugeMetric.hasGaugeMetadata() && this.gaugeMetric.getGaugeMetadata().hasMaxAppJavaHeapMemoryKb()));
    }
}
