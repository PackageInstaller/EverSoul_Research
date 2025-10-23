package org.apache.commons.lang3.time;

import com.liapp.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes2.dex */
public class FastDateParser implements DateParser, Serializable {
    private static final Strategy ABBREVIATED_YEAR_STRATEGY;
    private static final Strategy DAY_OF_MONTH_STRATEGY;
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY;
    private static final Strategy DAY_OF_WEEK_STRATEGY;
    private static final Strategy DAY_OF_YEAR_STRATEGY;
    private static final Strategy HOUR12_STRATEGY;
    private static final Strategy HOUR24_OF_DAY_STRATEGY;
    private static final Strategy HOUR_OF_DAY_STRATEGY;
    private static final Strategy HOUR_STRATEGY;
    static final Locale JAPANESE_IMPERIAL;
    private static final Strategy LITERAL_YEAR_STRATEGY;
    private static final Comparator<String> LONGER_FIRST_LOWERCASE;
    private static final Strategy MILLISECOND_STRATEGY;
    private static final Strategy MINUTE_STRATEGY;
    private static final Strategy NUMBER_MONTH_STRATEGY;
    private static final Strategy SECOND_STRATEGY;
    private static final Strategy WEEK_OF_MONTH_STRATEGY;
    private static final Strategy WEEK_OF_YEAR_STRATEGY;
    private static final ConcurrentMap<Locale, Strategy>[] caches;
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isFormatLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String str = y.ݮڮֲڭܩ(-628777260);
        String str2 = y.ٲٴݴ״ٰ(1781839280);
        JAPANESE_IMPERIAL = new Locale(str, str2, str2);
        LONGER_FIRST_LOWERCASE = new Comparator<String>() { // from class: org.apache.commons.lang3.time.FastDateParser.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.Comparator
            public int compare(String str3, String str4) {
                return str4.compareTo(str3);
            }
        };
        caches = new ConcurrentMap[17];
        ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: org.apache.commons.lang3.time.FastDateParser.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            int modify(FastDateParser fastDateParser, int i) {
                return i < 100 ? fastDateParser.adjustYear(i) : i;
            }
        };
        NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: org.apache.commons.lang3.time.FastDateParser.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            int modify(FastDateParser fastDateParser, int i) {
                return i - 1;
            }
        };
        LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
        WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
        WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
        DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
        DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
        DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) { // from class: org.apache.commons.lang3.time.FastDateParser.4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            int modify(FastDateParser fastDateParser, int i) {
                if (i == 7) {
                    return 1;
                }
                return 1 + i;
            }
        };
        DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
        HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
        HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: org.apache.commons.lang3.time.FastDateParser.5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            int modify(FastDateParser fastDateParser, int i) {
                if (i == 24) {
                    return 0;
                }
                return i;
            }
        };
        HOUR12_STRATEGY = new NumberStrategy(10) { // from class: org.apache.commons.lang3.time.FastDateParser.6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            int modify(FastDateParser fastDateParser, int i) {
                if (i == 12) {
                    return 0;
                }
                return i;
            }
        };
        HOUR_STRATEGY = new NumberStrategy(10);
        MINUTE_STRATEGY = new NumberStrategy(12);
        SECOND_STRATEGY = new NumberStrategy(13);
        MILLISECOND_STRATEGY = new NumberStrategy(14);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FastDateParser(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i;
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            calendar.setTime(new Date());
            i = calendar.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(calendar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy == null) {
                return;
            } else {
                this.patterns.add(nextStrategy);
            }
        }
    }

    private static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StrategyAndWidth(Strategy strategy, int i) {
            this.strategy = strategy;
            this.width = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy = listIterator.next().strategy;
            listIterator.previous();
            if (strategy.isNumber()) {
                return this.width;
            }
            return 0;
        }
    }

    private class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StrategyParser(Calendar calendar) {
            this.definingCalendar = calendar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
            if (FastDateParser.isFormatLetter(charAt)) {
                return letterPattern(charAt);
            }
            return literal();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StrategyAndWidth letterPattern(char c) {
            int i = this.currentIdx;
            do {
                int i2 = this.currentIdx + 1;
                this.currentIdx = i2;
                if (i2 >= FastDateParser.this.pattern.length()) {
                    break;
                }
            } while (FastDateParser.this.pattern.charAt(this.currentIdx) == c);
            int i3 = this.currentIdx - i;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c, i3, this.definingCalendar), i3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StrategyAndWidth literal() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!z && FastDateParser.isFormatLetter(charAt)) {
                    break;
                }
                if (charAt == '\'') {
                    int i = this.currentIdx + 1;
                    this.currentIdx = i;
                    if (i == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'') {
                        z = !z;
                    }
                }
                this.currentIdx++;
                sb.append(charAt);
            }
            if (z) {
                throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512604463));
            }
            String sb2 = sb.toString();
            return new StrategyAndWidth(new CopyQuotedStrategy(sb2), sb2.length());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.ٴسسݬߨ(1392617042)).append(this.pattern);
        String str = y.ٲٴݴ״ٰ(1781559176);
        return append.append(str).append(this.locale).append(str).append(this.timeZone.getID()).append(y.ۮڭڭܬި(862078387)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException(y.ٴسسݬߨ(1392618314) + this.locale + y.֬ڱܱײٮ(-1159596431) + str, parsePosition.getErrorIndex());
        }
        throw new ParseException(y.ݬֲ֮ܲت(1512607479) + str, parsePosition.getErrorIndex());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        if (parse(str, parsePosition, calendar)) {
            return calendar.getTime();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '$' && charAt != '.' && charAt != '?' && charAt != '^' && charAt != '[' && charAt != '\\' && charAt != '{' && charAt != '|') {
                switch (charAt) {
                }
                sb.append(charAt);
            }
            sb.append('\\');
            sb.append(charAt);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('?');
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int i, StringBuilder sb) {
        HashMap hashMap = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i, 0, locale);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale);
            if (treeSet.add(lowerCase)) {
                hashMap.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb, (String) it.next()).append('|');
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int adjustYear(int i) {
        int i2 = this.century + i;
        return i >= this.startYear ? i2 : i2 + 100;
    }

    private static abstract class Strategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isNumber() {
            return false;
        }

        abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Strategy() {
        }
    }

    private static abstract class PatternStrategy extends Strategy {
        private Pattern pattern;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean isNumber() {
            return false;
        }

        abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PatternStrategy() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void createPattern(StringBuilder sb) {
            createPattern(sb.toString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Strategy getStrategy(char c, int i, Calendar calendar) {
        if (c != 'y') {
            if (c != 'z') {
                switch (c) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'M':
                                return i >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                            case 'S':
                                return MILLISECOND_STRATEGY;
                            case 'a':
                                return getLocaleSpecificStrategy(9, calendar);
                            case 'd':
                                return DAY_OF_MONTH_STRATEGY;
                            case 'h':
                                return HOUR12_STRATEGY;
                            case 'k':
                                return HOUR24_OF_DAY_STRATEGY;
                            case 'm':
                                return MINUTE_STRATEGY;
                            case 's':
                                return SECOND_STRATEGY;
                            case 'u':
                                return DAY_OF_WEEK_STRATEGY;
                            case 'w':
                                return WEEK_OF_YEAR_STRATEGY;
                            default:
                                switch (c) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return ISO8601TimeZoneStrategy.getStrategy(i);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i == 2) {
                                            return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException(y.ݮڮֲڭܩ(-628777324) + c + "' not supported");
                                }
                        }
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        return i > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ConcurrentMap<Locale, Strategy> getCache(int i) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[i] == null) {
                concurrentMapArr[i] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[i];
        }
        return concurrentMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Strategy getLocaleSpecificStrategy(int i, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i);
        Strategy strategy = cache.get(this.locale);
        if (strategy == null) {
            strategy = i == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i, calendar, this.locale);
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    private static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean isNumber() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            for (int i2 = 0; i2 < this.formatField.length(); i2++) {
                int index = parsePosition.getIndex() + i2;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                if (this.formatField.charAt(i2) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
            return true;
        }
    }

    private static class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        final Locale locale;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CaseInsensitiveTextStrategy(int i, Calendar calendar, Locale locale) {
            super();
            this.field = i;
            this.locale = locale;
            StringBuilder sb = new StringBuilder();
            sb.append(y.֬ڱܱײٮ(-1159597903));
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale, i, sb);
            sb.setLength(sb.length() - 1);
            sb.append(")");
            createPattern(sb);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.locale);
            Integer num = this.lKeyValues.get(lowerCase);
            if (num == null) {
                num = this.lKeyValues.get(lowerCase + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            calendar.set(this.field, num.intValue());
        }
    }

    private static class NumberStrategy extends Strategy {
        private final int field;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean isNumber() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int modify(FastDateParser fastDateParser, int i) {
            return i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NumberStrategy(int i) {
            super();
            this.field = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i2 = i + index;
                if (length > i2) {
                    length = i2;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, parseInt));
            return true;
        }
    }

    static class TimeZoneStrategy extends PatternStrategy {
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";

        /* renamed from: ID */
        private static final int f1535ID = 0;
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames;

        private static class TzInfo {
            int dstOffset;
            TimeZone zone;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            TzInfo(TimeZone timeZone, boolean z) {
                this.zone = timeZone;
                this.dstOffset = z ? timeZone.getDSTSavings() : 0;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TimeZoneStrategy(Locale locale) {
            super();
            this.tzNames = new HashMap();
            this.locale = locale;
            StringBuilder sb = new StringBuilder();
            sb.append(y.ۮڭڭܬި(862306403));
            TreeSet treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase(y.֬ڱܱײٮ(-1159379423))) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i = 1; i < strArr.length; i++) {
                        if (i == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i == 5) {
                            tzInfo2 = tzInfo;
                        }
                        String str2 = strArr[i];
                        if (str2 != null) {
                            String lowerCase = str2.toLowerCase(locale);
                            if (treeSet.add(lowerCase)) {
                                this.tzNames.put(lowerCase, tzInfo2);
                            }
                        }
                    }
                }
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                FastDateParser.simpleQuote(sb.append('|'), (String) it.next());
            }
            sb.append(")");
            createPattern(sb);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone(str);
            if (gmtTimeZone != null) {
                calendar.setTimeZone(gmtTimeZone);
                return;
            }
            String lowerCase = str.toLowerCase(this.locale);
            TzInfo tzInfo = this.tzNames.get(lowerCase);
            if (tzInfo == null) {
                tzInfo = this.tzNames.get(lowerCase + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            calendar.set(16, tzInfo.dstOffset);
            calendar.set(15, tzInfo.zone.getRawOffset());
        }
    }

    private static class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy(y.֬ڱܱײٮ(-1159597839));
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy(y.دײܮڳܯ(2051582997));
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy(y.ٴسسݬߨ(1392619386));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(str));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Strategy getStrategy(int i) {
            if (i == 1) {
                return ISO_8601_1_STRATEGY;
            }
            if (i == 2) {
                return ISO_8601_2_STRATEGY;
            }
            if (i == 3) {
                return ISO_8601_3_STRATEGY;
            }
            throw new IllegalArgumentException(y.ۮڭڭܬި(862306619));
        }
    }
}
