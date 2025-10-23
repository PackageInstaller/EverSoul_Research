package org.apache.commons.lang3.time;

import com.liapp.y;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() { // from class: org.apache.commons.lang3.time.FastDateFormat.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FormatCache
        public FastDateFormat createInstance(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getInstance() {
        return cache.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getInstance(String str) {
        return cache.getInstance(str, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return cache.getInstance(str, timeZone, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getInstance(String str, Locale locale) {
        return cache.getInstance(str, null, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return cache.getInstance(str, timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateInstance(int i) {
        return cache.getDateInstance(i, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateInstance(int i, Locale locale) {
        return cache.getDateInstance(i, null, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateInstance(int i, TimeZone timeZone) {
        return cache.getDateInstance(i, timeZone, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return cache.getDateInstance(i, timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getTimeInstance(int i) {
        return cache.getTimeInstance(i, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getTimeInstance(int i, Locale locale) {
        return cache.getTimeInstance(i, null, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone) {
        return cache.getTimeInstance(i, timeZone, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return cache.getTimeInstance(i, timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateTimeInstance(int i, int i2) {
        return cache.getDateTimeInstance(i, i2, (TimeZone) null, (Locale) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        return cache.getDateTimeInstance(i, i2, (TimeZone) null, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone) {
        return getDateTimeInstance(i, i2, timeZone, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance(i, i2, timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.text.Format, org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(this.printer.format(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j) {
        return this.printer.format(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        return this.printer.format(date);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return this.printer.format(j, stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j, B b) {
        return (B) this.printer.format(j, (long) b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b) {
        return (B) this.printer.format(date, (Date) b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b) {
        return (B) this.printer.format(calendar, (Calendar) b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        return this.parser.parse(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        return this.parser.parse(str, parsePosition, calendar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.text.Format, org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.printer.getPattern();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.printer.getLocale();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj instanceof FastDateFormat) {
            return this.printer.equals(((FastDateFormat) obj).printer);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.printer.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.ݮڮֲڭܩ(-628778668)).append(this.printer.getPattern());
        String str = y.ٲٴݴ״ٰ(1781559176);
        return append.append(str).append(this.printer.getLocale()).append(str).append(this.printer.getTimeZone().getID()).append(y.ۮڭڭܬި(862078387)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }
}
