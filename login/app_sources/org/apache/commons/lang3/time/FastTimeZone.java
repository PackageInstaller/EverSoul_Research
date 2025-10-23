package org.apache.commons.lang3.time;

import com.liapp.y;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FastTimeZone {
    private static final Pattern GMT_PATTERN = Pattern.compile(y.֬ڱܱײٮ(-1159594583));
    private static final TimeZone GREENWICH = new GmtTimeZone(false, 0, 0);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TimeZone getGmtTimeZone() {
        return GREENWICH;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TimeZone getGmtTimeZone(String str) {
        if (y.֬ڱܱײٮ(-1159246623).equals(str) || y.ݬֲ֮ܲت(1512606327).equals(str)) {
            return GREENWICH;
        }
        Matcher matcher = GMT_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        int parseInt = parseInt(matcher.group(2));
        int parseInt2 = parseInt(matcher.group(4));
        if (parseInt == 0 && parseInt2 == 0) {
            return GREENWICH;
        }
        return new GmtTimeZone(parseSign(matcher.group(1)), parseInt, parseInt2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TimeZone getTimeZone(String str) {
        TimeZone gmtTimeZone = getGmtTimeZone(str);
        return gmtTimeZone != null ? gmtTimeZone : TimeZone.getTimeZone(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int parseInt(String str) {
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean parseSign(String str) {
        return str != null && str.charAt(0) == '-';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FastTimeZone() {
    }
}
