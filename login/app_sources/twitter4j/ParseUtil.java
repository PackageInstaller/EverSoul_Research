package twitter4j;

import com.liapp.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
final class ParseUtil {
    private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> formatMapQueue = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ParseUtil() {
        throw new AssertionError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getUnescapedString(String str, JSONObject jSONObject) {
        return HTMLEntity.unescape(getRawString(str, jSONObject));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException | Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getURLDecodedString(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null) {
            return rawString;
        }
        try {
            return URLDecoder.decode(rawString, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return rawString;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Date parseTrendsDate(String str) throws TwitterException {
        int length = str.length();
        if (length == 10) {
            return new Date(Long.parseLong(str) * 1000);
        }
        if (length == 20) {
            return getDate(str, y.٬ݯح׭٩(576364462));
        }
        return getDate(str, y.دײܮڳܯ(2051149885));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Date getDate(String str, JSONObject jSONObject) throws TwitterException {
        return getDate(str, jSONObject, y.ۮڭڭܬި(862943339));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Date getDate(String str, JSONObject jSONObject, String str2) throws TwitterException {
        String unescapedString = getUnescapedString(str, jSONObject);
        if ("null".equals(unescapedString) || unescapedString == null) {
            return null;
        }
        return getDate(unescapedString, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Date getDate(String str, String str2) throws TwitterException {
        String str3 = y.دײܮڳܯ(2051150565);
        Map<String, LinkedBlockingQueue<SimpleDateFormat>> map = formatMapQueue;
        LinkedBlockingQueue<SimpleDateFormat> linkedBlockingQueue = map.get(str2);
        if (linkedBlockingQueue == null) {
            linkedBlockingQueue = new LinkedBlockingQueue<>();
            map.put(str2, linkedBlockingQueue);
        }
        SimpleDateFormat poll = linkedBlockingQueue.poll();
        if (poll == null) {
            poll = new SimpleDateFormat(str2, Locale.US);
            poll.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        }
        try {
            try {
                return poll.parse(str);
            } catch (ParseException e) {
                throw new TwitterException(str3 + str + ") returned from twitter.com", e);
            }
        } finally {
            try {
                linkedBlockingQueue.put(poll);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getInt(String str, JSONObject jSONObject) {
        return getInt(getRawString(str, jSONObject));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getInt(String str) {
        if (str != null && !"".equals(str) && !y.ݮڮֲڭܩ(-628841308).equals(str)) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getLong(String str, JSONObject jSONObject) {
        return getLong(getRawString(str, jSONObject));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getLong(String str) {
        if (str == null || "".equals(str) || y.ݮڮֲڭܩ(-628841308).equals(str)) {
            return -1L;
        }
        if (str.endsWith(y.٬ݯح׭٩(576247302))) {
            return Long.valueOf(str.substring(0, str.length() - 1)).longValue() + 1;
        }
        return Long.valueOf(str).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double getDouble(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "".equals(rawString) || "null".equals(rawString)) {
            return -1.0d;
        }
        return Double.valueOf(rawString).doubleValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean getBoolean(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "null".equals(rawString)) {
            return false;
        }
        return Boolean.valueOf(rawString).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toAccessLevel(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return -1;
        }
        String responseHeader = httpResponse.getResponseHeader(y.֬ڱܱײٮ(-1158984175));
        if (responseHeader == null) {
            return 0;
        }
        int length = responseHeader.length();
        if (length == 4) {
            return 1;
        }
        if (length != 10) {
            return (length == 25 || length == 26) ? 3 : 0;
        }
        return 2;
    }
}
