package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
class StringUtil {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StringUtil() {
        throw new AssertionError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String join(long[] jArr) {
        StringBuilder sb = new StringBuilder(jArr.length * 11);
        for (long j : jArr) {
            if (sb.length() != 0) {
                sb.append(y.ٲٴݴ״ٰ(1781559176));
            }
            sb.append(j);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String join(String[] strArr) {
        StringBuilder sb = new StringBuilder(strArr.length * 11);
        for (String str : strArr) {
            if (sb.length() != 0) {
                sb.append(y.ٲٴݴ״ٰ(1781559176));
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
