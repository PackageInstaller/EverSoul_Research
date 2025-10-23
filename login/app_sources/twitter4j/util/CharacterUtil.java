package twitter4j.util;

/* loaded from: classes4.dex */
public final class CharacterUtil {
    public static final int MAX_TWEET_LENGTH = 280;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CharacterUtil() {
        throw new AssertionError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int count(String str) {
        return str.length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isExceedingLengthLimitation(String str) {
        return count(str) > 280;
    }
}
