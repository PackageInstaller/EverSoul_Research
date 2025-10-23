package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class PreJava9DateFormatProvider {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DateFormat getUSDateFormat(int i) {
        return new SimpleDateFormat(getDateFormatPattern(i), Locale.US);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DateFormat getUSDateTimeFormat(int i, int i2) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i) + StringUtils.SPACE + getTimePartOfDateTimePattern(i2), Locale.US);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getDateFormatPattern(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i == 1) {
            return "MMMM d, y";
        }
        if (i == 2) {
            return "MMM d, y";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getDatePartOfDateTimePattern(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i == 1) {
            return "MMMM d, yyyy";
        }
        if (i == 2) {
            return "MMM d, yyyy";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getTimePartOfDateTimePattern(int i) {
        if (i == 0 || i == 1) {
            return "h:mm:ss a z";
        }
        if (i == 2) {
            return "h:mm:ss a";
        }
        if (i == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
    }
}
