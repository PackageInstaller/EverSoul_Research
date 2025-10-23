package org.apache.commons.lang3.time;

import com.liapp.y;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);

    protected abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FormatCache() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        Validate.notNull(str, y.֬ڱܱײٮ(-1159594479), new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
        F f = this.cInstanceCache.get(multipartKey);
        if (f != null) {
            return f;
        }
        F createInstance = createInstance(str, timeZone, locale);
        F putIfAbsent = this.cInstanceCache.putIfAbsent(multipartKey, createInstance);
        return putIfAbsent != null ? putIfAbsent : createInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return getInstance(getPatternForStyle(num, num2, locale), timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    F getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    F getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    F getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        DateFormat dateTimeInstance;
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        ConcurrentMap<MultipartKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(multipartKey);
        if (str != null) {
            return str;
        }
        try {
            if (num == null) {
                dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
            } else if (num2 == null) {
                dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
            }
            String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
            String putIfAbsent = concurrentMap.putIfAbsent(multipartKey, pattern);
            return putIfAbsent != null ? putIfAbsent : pattern;
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1392616010) + locale);
        }
    }

    private static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            if (this.hashCode == 0) {
                int i = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        i = (i * 7) + obj.hashCode();
                    }
                }
                this.hashCode = i;
            }
            return this.hashCode;
        }
    }
}
