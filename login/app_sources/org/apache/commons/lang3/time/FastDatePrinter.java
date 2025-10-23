package org.apache.commons.lang3.time;

import com.liapp.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* loaded from: classes2.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    private interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i) throws IOException;
    }

    private interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i;
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v21, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v10, types: [org.apache.commons.lang3.time.FastDatePrinter$StringLiteral] */
    /* JADX WARN: Type inference failed for: r9v11, types: [org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral] */
    /* JADX WARN: Type inference failed for: r9v13, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v15, types: [org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField] */
    /* JADX WARN: Type inference failed for: r9v16, types: [org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField] */
    /* JADX WARN: Type inference failed for: r9v17, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v18, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v20, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v21, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v23, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v24, types: [org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField] */
    /* JADX WARN: Type inference failed for: r9v25, types: [org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField] */
    /* JADX WARN: Type inference failed for: r9v27, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v29, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v30, types: [org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField] */
    /* JADX WARN: Type inference failed for: r9v32, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v36, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v41, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v42, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v44, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v45, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v46, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v49, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v5, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /* JADX WARN: Type inference failed for: r9v50, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v51, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v6, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected List<Rule> parsePattern() {
        NumberRule numberRule;
        ?? stringLiteral;
        NumberRule numberRule2;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            iArr[i] = i2;
            String parseToken = parseToken(this.mPattern, iArr);
            int i3 = iArr[i];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(i);
            if (charAt != 'y') {
                if (charAt != 'z') {
                    switch (charAt) {
                        case '\'':
                            String substring = parseToken.substring(1);
                            if (substring.length() == 1) {
                                stringLiteral = new CharacterLiteral(substring.charAt(0));
                            } else {
                                stringLiteral = new StringLiteral(substring);
                            }
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'K':
                            stringLiteral = selectNumberRule(10, length2);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'M':
                            if (length2 >= 4) {
                                stringLiteral = new TextField(2, months);
                            } else if (length2 == 3) {
                                stringLiteral = new TextField(2, shortMonths);
                            } else if (length2 == 2) {
                                stringLiteral = TwoDigitMonthField.INSTANCE;
                            } else {
                                stringLiteral = UnpaddedMonthField.INSTANCE;
                            }
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'S':
                            stringLiteral = selectNumberRule(14, length2);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'a':
                            stringLiteral = new TextField(9, amPmStrings);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'd':
                            stringLiteral = selectNumberRule(5, length2);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'h':
                            stringLiteral = new TwelveHourField(selectNumberRule(10, length2));
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'k':
                            stringLiteral = new TwentyFourHourField(selectNumberRule(11, length2));
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'm':
                            stringLiteral = selectNumberRule(12, length2);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 's':
                            stringLiteral = selectNumberRule(13, length2);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'u':
                            stringLiteral = new DayInWeekField(selectNumberRule(7, length2));
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        case 'w':
                            stringLiteral = selectNumberRule(3, length2);
                            numberRule2 = stringLiteral;
                            numberRule = numberRule2;
                            i = 0;
                            break;
                        default:
                            switch (charAt) {
                                case 'D':
                                    stringLiteral = selectNumberRule(6, length2);
                                    numberRule2 = stringLiteral;
                                    numberRule = numberRule2;
                                    i = 0;
                                    break;
                                case 'E':
                                    numberRule2 = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    numberRule = numberRule2;
                                    i = 0;
                                    break;
                                case 'F':
                                    stringLiteral = selectNumberRule(8, length2);
                                    numberRule2 = stringLiteral;
                                    numberRule = numberRule2;
                                    i = 0;
                                    break;
                                case 'G':
                                    i = 0;
                                    numberRule = new TextField(0, eras);
                                    break;
                                case 'H':
                                    stringLiteral = selectNumberRule(11, length2);
                                    numberRule2 = stringLiteral;
                                    numberRule = numberRule2;
                                    i = 0;
                                    break;
                                default:
                                    switch (charAt) {
                                        case 'W':
                                            stringLiteral = selectNumberRule(4, length2);
                                            break;
                                        case 'X':
                                            stringLiteral = Iso8601_Rule.getRule(length2);
                                            break;
                                        case 'Y':
                                            break;
                                        case 'Z':
                                            if (length2 != 1) {
                                                if (length2 == 2) {
                                                    stringLiteral = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                                    break;
                                                } else {
                                                    stringLiteral = TimeZoneNumberRule.INSTANCE_COLON;
                                                    break;
                                                }
                                            } else {
                                                stringLiteral = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                                break;
                                            }
                                        default:
                                            throw new IllegalArgumentException(y.ٴسسݬߨ(1392617282) + parseToken);
                                    }
                                    numberRule2 = stringLiteral;
                                    numberRule = numberRule2;
                                    i = 0;
                                    break;
                            }
                    }
                } else if (length2 >= 4) {
                    numberRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                    i = 0;
                } else {
                    numberRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                    i = 0;
                }
                arrayList.add(numberRule);
                i2 = i3 + 1;
            }
            i = 0;
            if (length2 == 2) {
                numberRule = TwoDigitYearField.INSTANCE;
            } else {
                if (length2 < 4) {
                    length2 = 4;
                }
                numberRule = selectNumberRule(1, length2);
            }
            if (charAt == 'Y') {
                numberRule = new WeekYear(numberRule);
                continue;
            }
            arrayList.add(numberRule);
            i2 = i3 + 1;
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 != '\'') {
                    if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    sb.append(charAt2);
                } else {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i = i3;
                    }
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected NumberRule selectNumberRule(int i, int i2) {
        if (i2 == 1) {
            return new UnpaddedNumberField(i);
        }
        if (i2 == 2) {
            return new TwoDigitNumberField(i);
        }
        return new PaddedNumberField(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        throw new IllegalArgumentException(y.ݮڮֲڭܩ(-628780348) + (obj == null ? "<null>" : obj.getClass().getName()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        throw new IllegalArgumentException(y.ݮڮֲڭܩ(-628780348) + (obj == null ? "<null>" : obj.getClass().getName()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRulesToString(newCalendar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar, (Calendar) b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            for (Rule rule : this.mRules) {
                rule.appendTo(b, calendar);
            }
        } catch (IOException e) {
            ExceptionUtils.rethrow(e);
        }
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.ٲٴݴ״ٰ(1781841680)).append(this.mPattern);
        String str = y.ٲٴݴ״ٰ(1781559176);
        return append.append(str).append(this.mLocale).append(str).append(this.mTimeZone.getID()).append(y.ۮڭڭܬި(862078387)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void appendDigits(Appendable appendable, int i) throws IOException {
        appendable.append((char) ((i / 10) + 48));
        appendable.append((char) ((i % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void appendFullDigits(Appendable appendable, int i, int i2) throws IOException {
        if (i < 10000) {
            int i3 = i < 1000 ? i < 100 ? i < 10 ? 1 : 2 : 3 : 4;
            for (int i4 = i2 - i3; i4 > 0; i4--) {
                appendable.append('0');
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return;
                        }
                        appendable.append((char) ((i / 1000) + 48));
                        i %= 1000;
                    }
                    if (i >= 100) {
                        appendable.append((char) ((i / 100) + 48));
                        i %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i >= 10) {
                    appendable.append((char) ((i / 10) + 48));
                    i %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i + 48));
            return;
        }
        char[] cArr = new char[10];
        int i5 = 0;
        while (i != 0) {
            cArr[i5] = (char) ((i % 10) + 48);
            i /= 10;
            i5++;
        }
        while (i5 < i2) {
            appendable.append('0');
            i2--;
        }
        while (true) {
            i5--;
            if (i5 < 0) {
                return;
            } else {
                appendable.append(cArr[i5]);
            }
        }
    }

    private static class CharacterLiteral implements Rule {
        private final char mValue;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CharacterLiteral(char c) {
            this.mValue = c;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }
    }

    private static class StringLiteral implements Rule {
        private final String mValue;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StringLiteral(String str) {
            this.mValue = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }
    }

    private static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }
    }

    private static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        UnpaddedNumberField(int i) {
            this.mField = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 1);
            }
        }
    }

    private static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        UnpaddedMonthField() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i >= 10) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                appendable.append((char) (i + 48));
            }
        }
    }

    private static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = i;
            this.mSize = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i, this.mSize);
        }
    }

    private static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TwoDigitNumberField(int i) {
            this.mField = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 2);
            }
        }
    }

    private static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TwoDigitYearField() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    private static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TwoDigitMonthField() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    private static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    private static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    private static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(7);
            this.mRule.appendTo(appendable, i != 1 ? i - 1 : 7);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    private static class WeekYear implements NumberRule {
        private final NumberRule mRule;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            this.mRule.appendTo(appendable, calendar.getWeekYear());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i, locale);
        String putIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    private static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TimeZoneNameRule(TimeZone timeZone, Locale locale, int i) {
            this.mLocale = locale;
            this.mStyle = i;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }
    }

    private static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }
    }

    private static class Iso8601_Rule implements Rule {
        final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Iso8601_Rule getRule(int i) {
            if (i == 1) {
                return ISO8601_HOURS;
            }
            if (i == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException(y.ۮڭڭܬި(862306619));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Iso8601_Rule(int i) {
            this.length = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i == 0) {
                appendable.append("Z");
                return;
            }
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            int i3 = this.length;
            if (i3 < 5) {
                return;
            }
            if (i3 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }
    }

    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            if (z) {
                this.mStyle = Integer.MIN_VALUE | i;
            } else {
                this.mStyle = i;
            }
            this.mLocale = locale;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }
    }
}
