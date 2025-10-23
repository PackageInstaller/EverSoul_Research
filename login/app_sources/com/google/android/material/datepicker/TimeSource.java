package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    private final Long fixedTimeMs;
    private final TimeZone fixedTimeZone;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TimeSource(Long l, TimeZone timeZone) {
        this.fixedTimeMs = l;
        this.fixedTimeZone = timeZone;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static TimeSource fixed(long j, TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j), timeZone);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static TimeSource fixed(long j) {
        return new TimeSource(Long.valueOf(j), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Calendar now() {
        return now(this.fixedTimeZone);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Calendar now(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.fixedTimeMs;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
