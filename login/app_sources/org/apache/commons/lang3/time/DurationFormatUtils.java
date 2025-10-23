package org.apache.commons.lang3.time;

import com.liapp.y;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    /* renamed from: y */
    static final Object f1534y = y.ٴسسݬߨ(1392530602);

    /* renamed from: M */
    static final Object f1529M = y.٬ݯح׭٩(575902014);

    /* renamed from: d */
    static final Object f1531d = y.ݮڮֲڭܩ(-628858508);

    /* renamed from: H */
    static final Object f1528H = y.دײܮڳܯ(2051626829);

    /* renamed from: m */
    static final Object f1532m = y.ٴسسݬߨ(1392530698);

    /* renamed from: s */
    static final Object f1533s = y.ٲٴݴ״ٰ(1781877368);

    /* renamed from: S */
    static final Object f1530S = y.ݮڮֲڭܩ(-628939148);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatDurationHMS(long j) {
        return formatDuration(j, y.دײܮڳܯ(2051626205));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatDurationISO(long j) {
        return formatDuration(j, y.٬ݯح׭٩(575902510), false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, j, y.٬ݯح׭٩(575902134));
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, f1531d)) {
            long j8 = j / DateUtils.MILLIS_PER_DAY;
            j2 = j - (DateUtils.MILLIS_PER_DAY * j8);
            j3 = j8;
        } else {
            j2 = j;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f1528H)) {
            long j9 = j2 / DateUtils.MILLIS_PER_HOUR;
            j2 -= DateUtils.MILLIS_PER_HOUR * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f1532m)) {
            long j10 = j2 / DateUtils.MILLIS_PER_MINUTE;
            j2 -= DateUtils.MILLIS_PER_MINUTE * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f1533s)) {
            long j11 = j2 / 1000;
            j7 = j2 - (1000 * j11);
            j6 = j11;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return format(lexx, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, y.ٴسسݬߨ(1392529434));
        String str = y.ۮڭڭܬި(862206099);
        String str2 = y.ٲٴݴ״ٰ(1781878496);
        String str3 = y.ݬֲ֮ܲت(1512667599);
        String str4 = y.دײܮڳܯ(2051829469);
        if (z) {
            formatDuration = str4 + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, str3, "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, str, "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, str2, "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (!formatDuration.isEmpty()) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, str2, "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, str, "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, str3, "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(str4 + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, y.٬ݯح׭٩(575902510), false, TimeZone.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i = 0;
        Validate.isTrue(j <= j2, y.ۮڭڭܬި(862206891), new Object[0]);
        Token[] lexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        int i2 = calendar2.get(14) - calendar.get(14);
        int i3 = calendar2.get(13) - calendar.get(13);
        int i4 = calendar2.get(12) - calendar.get(12);
        int i5 = calendar2.get(11) - calendar.get(11);
        int i6 = calendar2.get(5) - calendar.get(5);
        int i7 = calendar2.get(2) - calendar.get(2);
        int i8 = calendar2.get(1) - calendar.get(1);
        while (i2 < 0) {
            i2 += 1000;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 24;
            i6--;
        }
        if (Token.containsTokenWithValue(lexx, f1529M)) {
            while (i6 < 0) {
                i6 += calendar.getActualMaximum(5);
                i7--;
                calendar.add(2, 1);
            }
            while (i7 < 0) {
                i7 += 12;
                i8--;
            }
            if (!Token.containsTokenWithValue(lexx, f1534y) && i8 != 0) {
                while (i8 != 0) {
                    i7 += i8 * 12;
                    i8 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(lexx, f1534y)) {
                int i9 = calendar2.get(1);
                if (i7 < 0) {
                    i9--;
                }
                while (calendar.get(1) != i9) {
                    int actualMaximum = i6 + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i6 = actualMaximum + calendar.get(6);
                }
                i8 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i6 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i7 = 0;
            while (i6 < 0) {
                i6 += calendar.getActualMaximum(5);
                i7--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(lexx, f1531d)) {
            i5 += i6 * 24;
            i6 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f1528H)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f1532m)) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f1533s)) {
            i = i3;
        } else {
            i2 += i3 * 1000;
        }
        return format(lexx, i8, i7, i6, i5, i4, i, i2, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        long j8;
        Token[] tokenArr2 = tokenArr;
        long j9 = j7;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            Token token = tokenArr2[i3];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                j8 = j9;
                i2 = length;
                i = i3;
            } else {
                if (value.equals(f1534y)) {
                    sb.append(paddedValue(j, z, count));
                } else if (value.equals(f1529M)) {
                    sb.append(paddedValue(j2, z, count));
                } else if (value.equals(f1531d)) {
                    i = i3;
                    sb.append(paddedValue(j3, z, count));
                    j8 = j9;
                    i2 = length;
                    z2 = false;
                } else {
                    i = i3;
                    if (value.equals(f1528H)) {
                        i2 = length;
                        sb.append(paddedValue(j4, z, count));
                    } else {
                        i2 = length;
                        if (value.equals(f1532m)) {
                            sb.append(paddedValue(j5, z, count));
                        } else {
                            if (value.equals(f1533s)) {
                                sb.append(paddedValue(j6, z, count));
                                j8 = j7;
                                z2 = true;
                            } else if (value.equals(f1530S)) {
                                if (z2) {
                                    j8 = j7;
                                    sb.append(paddedValue(j8, true, z ? Math.max(3, count) : 3));
                                } else {
                                    j8 = j7;
                                    sb.append(paddedValue(j8, z, count));
                                }
                                z2 = false;
                            } else {
                                j8 = j7;
                            }
                            i3 = i + 1;
                            j9 = j8;
                            length = i2;
                            tokenArr2 = tokenArr;
                        }
                    }
                    j8 = j9;
                    z2 = false;
                    i3 = i + 1;
                    j9 = j8;
                    length = i2;
                    tokenArr2 = tokenArr;
                }
                j8 = j9;
                i2 = length;
                i = i3;
                z2 = false;
            }
            i3 = i + 1;
            j9 = j8;
            length = i2;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String paddedValue(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? StringUtils.leftPad(l, i, '0') : l;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length()
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r3
            r5 = r2
            r6 = r5
        Lf:
            int r7 = r9.length()
            if (r3 >= r7) goto L9f
            char r7 = r9.charAt(r3)
            r8 = 39
            if (r4 == 0) goto L24
            if (r7 == r8) goto L24
            r5.append(r7)
            goto L9b
        L24:
            if (r7 == r8) goto L6a
            r8 = 72
            if (r7 == r8) goto L67
            r8 = 77
            if (r7 == r8) goto L64
            r8 = 83
            if (r7 == r8) goto L61
            r8 = 100
            if (r7 == r8) goto L5e
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L5b
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L58
            r8 = 121(0x79, float:1.7E-43)
            if (r7 == r8) goto L55
            if (r5 != 0) goto L51
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r8 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r8.<init>(r5)
            r0.add(r8)
        L51:
            r5.append(r7)
            goto L7e
        L55:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1534y
            goto L7f
        L58:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1533s
            goto L7f
        L5b:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1532m
            goto L7f
        L5e:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1531d
            goto L7f
        L61:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1530S
            goto L7f
        L64:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1529M
            goto L7f
        L67:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f1528H
            goto L7f
        L6a:
            if (r4 == 0) goto L70
            r4 = r1
            r5 = r2
            r7 = r5
            goto L7f
        L70:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r4 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r4.<init>(r5)
            r0.add(r4)
            r4 = 1
        L7e:
            r7 = r2
        L7f:
            if (r7 == 0) goto L9b
            if (r6 == 0) goto L91
            java.lang.Object r5 = r6.getValue()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L91
            r6.increment()
            goto L9a
        L91:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r5 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r5.<init>(r7)
            r0.add(r5)
            r6 = r5
        L9a:
            r5 = r2
        L9b:
            int r3 = r3 + 1
            goto Lf
        L9f:
            if (r4 != 0) goto Lae
            int r9 = r0.size()
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = new org.apache.commons.lang3.time.DurationFormatUtils.Token[r9]
            java.lang.Object[] r9 = r0.toArray(r9)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r9
            return r9
        Lae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = -1159597791(0xffffffffbae1f121, float:-0.0017238)
            java.lang.String r2 = com.liapp.y.֬ڱܱײٮ(r2)
            r1.<init>(r2)
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
            fill-array 0x00c8: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    static class Token {
        private int count;
        private final Object value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void increment() {
            this.count++;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getCount() {
            return this.count;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Object getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            return obj2 == token.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}
