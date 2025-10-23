package org.apache.commons.lang3;

import com.liapp.y;
import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class BooleanUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBoolean(int i) {
        return i != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toInteger(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toInteger(boolean z, int i, int i2) {
        return z ? i : i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Integer toIntegerObject(boolean z, Integer num, Integer num2) {
        return z ? num : num2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(boolean z, String str, String str2) {
        return z ? str : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isNotTrue(Boolean bool) {
        return !isTrue(bool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isNotFalse(Boolean bool) {
        return !isFalse(bool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean toBooleanObject(int i) {
        return i == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBoolean(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        if (i == i3) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else {
            if (num.equals(num2)) {
                return true;
            }
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean toBooleanObject(int i, int i2, int i3, int i4) {
        if (i == i2) {
            return Boolean.TRUE;
        }
        if (i == i3) {
            return Boolean.FALSE;
        }
        if (i == i4) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else {
            if (num.equals(num2)) {
                return Boolean.TRUE;
            }
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Integer toIntegerObject(boolean z) {
        return z ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toInteger(Boolean bool, int i, int i2, int i3) {
        return bool == null ? i3 : bool.booleanValue() ? i : i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        return bool == null ? num3 : bool.booleanValue() ? num : num2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean toBooleanObject(String str) {
        if (str == y.دײܮڳܯ(2051939573)) {
            return Boolean.TRUE;
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 1) {
            char charAt = str.charAt(0);
            if (charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') {
                return Boolean.TRUE;
            }
            if (charAt == 'n' || charAt == 'N' || charAt == 'f' || charAt == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 2) {
            char charAt2 = str.charAt(0);
            char charAt3 = str.charAt(1);
            if ((charAt2 == 'o' || charAt2 == 'O') && (charAt3 == 'n' || charAt3 == 'N')) {
                return Boolean.TRUE;
            }
            if (charAt2 != 'n' && charAt2 != 'N') {
                return null;
            }
            if (charAt3 == 'o' || charAt3 == 'O') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 3) {
            char charAt4 = str.charAt(0);
            char charAt5 = str.charAt(1);
            char charAt6 = str.charAt(2);
            if ((charAt4 == 'y' || charAt4 == 'Y') && ((charAt5 == 'e' || charAt5 == 'E') && (charAt6 == 's' || charAt6 == 'S'))) {
                return Boolean.TRUE;
            }
            if (charAt4 != 'o' && charAt4 != 'O') {
                return null;
            }
            if (charAt5 != 'f' && charAt5 != 'F') {
                return null;
            }
            if (charAt6 == 'f' || charAt6 == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 4) {
            char charAt7 = str.charAt(0);
            char charAt8 = str.charAt(1);
            char charAt9 = str.charAt(2);
            char charAt10 = str.charAt(3);
            if (charAt7 != 't' && charAt7 != 'T') {
                return null;
            }
            if (charAt8 != 'r' && charAt8 != 'R') {
                return null;
            }
            if (charAt9 != 'u' && charAt9 != 'U') {
                return null;
            }
            if (charAt10 == 'e' || charAt10 == 'E') {
                return Boolean.TRUE;
            }
            return null;
        }
        if (length != 5) {
            return null;
        }
        char charAt11 = str.charAt(0);
        char charAt12 = str.charAt(1);
        char charAt13 = str.charAt(2);
        char charAt14 = str.charAt(3);
        char charAt15 = str.charAt(4);
        if (charAt11 != 'f' && charAt11 != 'F') {
            return null;
        }
        if (charAt12 != 'a' && charAt12 != 'A') {
            return null;
        }
        if (charAt13 != 'l' && charAt13 != 'L') {
            return null;
        }
        if (charAt14 != 's' && charAt14 != 'S') {
            return null;
        }
        if (charAt15 == 'e' || charAt15 == 'E') {
            return Boolean.FALSE;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else {
            if (str.equals(str2)) {
                return Boolean.TRUE;
            }
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBoolean(String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == str2) {
            return true;
        }
        if (str == str3) {
            return false;
        }
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, y.دײܮڳܯ(2051939573), y.ٲٴݴ״ٰ(1781635312), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringOnOff(Boolean bool) {
        return toString(bool, y.ݬֲ֮ܲت(1512977735), y.ݮڮֲڭܩ(-628938012), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringYesNo(Boolean bool) {
        return toString(bool, y.ۮڭڭܬި(862156747), y.ٲٴݴ״ٰ(1781636896), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Boolean bool, String str, String str2, String str3) {
        return bool == null ? str3 : bool.booleanValue() ? str : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringTrueFalse(boolean z) {
        return toString(z, y.دײܮڳܯ(2051939573), y.ٲٴݴ״ٰ(1781635312));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringOnOff(boolean z) {
        return toString(z, y.ݬֲ֮ܲت(1512977735), y.ݮڮֲڭܩ(-628938012));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringYesNo(boolean z) {
        return toString(z, y.ۮڭڭܬި(862156747), y.ٲٴݴ״ٰ(1781636896));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean and(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159249767));
        }
        if (zArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051940181));
        }
        for (boolean z : zArr) {
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean and(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159249767));
        }
        if (boolArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051940181));
        }
        try {
            return and(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
        } catch (NullPointerException unused) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159242103));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    public static boolean m882or(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159249767));
        }
        if (zArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051940181));
        }
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    public static Boolean m881or(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159249767));
        }
        if (boolArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051940181));
        }
        try {
            return m882or(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
        } catch (NullPointerException unused) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159242103));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean xor(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159249767));
        }
        if (zArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051940181));
        }
        boolean z = false;
        for (boolean z2 : zArr) {
            z ^= z2;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean xor(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159249767));
        }
        if (boolArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051940181));
        }
        try {
            return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
        } catch (NullPointerException unused) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159242103));
        }
    }
}
