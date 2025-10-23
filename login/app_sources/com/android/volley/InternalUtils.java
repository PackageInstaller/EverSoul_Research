package com.android.volley;

import com.liapp.y;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class InternalUtils {
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private static final char[] HEX_CHARS = y.ۮڭڭܬި(862024307).toCharArray();
    private static final String[] DEFAULT_PATTERNS = {y.ݮڮֲڭܩ(-629071404), y.֬ڱܱײٮ(-1159379223), y.ٴسسݬߨ(1392841954)};

    static final class DateFormatHolder {
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>() { // from class: com.android.volley.InternalUtils.DateFormatHolder.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.ThreadLocal
            public SoftReference<Map<String, SimpleDateFormat>> initialValue() {
                return new SoftReference<>(new HashMap());
            }
        };

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DateFormatHolder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void clearThreadLocal() {
            THREADLOCAL_FORMATS.remove();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SimpleDateFormat formatFor(String str) {
            ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> threadLocal = THREADLOCAL_FORMATS;
            Map<String, SimpleDateFormat> map = threadLocal.get().get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(new SoftReference<>(map));
            }
            SimpleDateFormat simpleDateFormat = map.get(str);
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(y.֬ڱܱײٮ(-1159379423)));
            map.put(str, simpleDateFormat2);
            return simpleDateFormat2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String convertToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = HEX_CHARS;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatDate(Date date) {
        return new SimpleDateFormat(y.ݮڮֲڭܩ(-629071316), Locale.US).format(date);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Date parseDate(String str) {
        String[] strArr = DEFAULT_PATTERNS;
        Date date = new Date();
        if (str.length() > 1) {
            String str2 = y.دײܮڳܯ(2051806557);
            if (str.startsWith(str2) && str.endsWith(str2)) {
                str = str.substring(1, str.length() - 1);
            }
        }
        for (String str3 : strArr) {
            SimpleDateFormat formatFor = DateFormatHolder.formatFor(str3);
            formatFor.set2DigitYearStart(date);
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = formatFor.parse(str, parsePosition);
            if (parsePosition.getIndex() != 0) {
                return parse;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String sha1Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
