package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
class JSON {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JSON() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static double checkDouble(double d) throws JSONException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new JSONException(y.ݮڮֲڭܩ(-628100564) + d);
        }
        return d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (y.دײܮڳܯ(2051939573).equalsIgnoreCase(str)) {
            return true;
        }
        return y.ٲٴݴ״ٰ(1781635312).equalsIgnoreCase(str) ? false : null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Double toDouble(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Integer toInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf((int) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Long toLong(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JSONException typeMismatch(Object obj, Object obj2, String str) throws JSONException {
        if (obj2 == null) {
            throw new JSONException(y.ݮڮֲڭܩ(-628100348) + obj + " is null.");
        }
        throw new JSONException(y.٬ݯح׭٩(576193438) + obj2 + y.ٴسسݬߨ(1393280946) + obj + y.ٴسسݬߨ(1393279042) + obj2.getClass().getName() + " cannot be converted to " + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JSONException typeMismatch(Object obj, String str) throws JSONException {
        if (obj == null) {
            throw new JSONException("Value is null.");
        }
        throw new JSONException(y.٬ݯح׭٩(576193438) + obj + y.ٴسسݬߨ(1393279042) + obj.getClass().getName() + y.ۮڭڭܬި(862955843) + str);
    }
}
