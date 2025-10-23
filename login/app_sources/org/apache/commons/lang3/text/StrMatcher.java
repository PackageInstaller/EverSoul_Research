package org.apache.commons.lang3.text;

import com.liapp.y;
import java.util.Arrays;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: classes2.dex */
public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher(Typography.quote);
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher(y.ٴسسݬߨ(1392523954).toCharArray());
    private static final StrMatcher NONE_MATCHER = new NoMatcher();

    public abstract int isMatch(char[] cArr, int i, int i2, int i3);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher charMatcher(char c) {
        return new CharMatcher(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher charSetMatcher(char... cArr) {
        if (cArr == null || cArr.length == 0) {
            return NONE_MATCHER;
        }
        if (cArr.length == 1) {
            return new CharMatcher(cArr[0]);
        }
        return new CharSetMatcher(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher charSetMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        if (str.length() == 1) {
            return new CharMatcher(str.charAt(0));
        }
        return new CharSetMatcher(str.toCharArray());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StrMatcher stringMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        return new StringMatcher(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected StrMatcher() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int isMatch(char[] cArr, int i) {
        return isMatch(cArr, i, 0, cArr.length);
    }

    static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return Arrays.binarySearch(this.chars, cArr[i]) >= 0 ? 1 : 0;
        }
    }

    static final class CharMatcher extends StrMatcher {

        /* renamed from: ch */
        private final char f1527ch;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CharMatcher(char c) {
            this.f1527ch = c;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return this.f1527ch == cArr[i] ? 1 : 0;
        }
    }

    static final class StringMatcher extends StrMatcher {
        private final char[] chars;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            int length = this.chars.length;
            if (i + length > i3) {
                return 0;
            }
            int i4 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i4 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i4] != cArr[i]) {
                    return 0;
                }
                i4++;
                i++;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return super.toString() + ' ' + Arrays.toString(this.chars);
        }
    }

    static final class NoMatcher extends StrMatcher {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NoMatcher() {
        }
    }

    static final class TrimMatcher extends StrMatcher {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TrimMatcher() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return cArr[i] <= ' ' ? 1 : 0;
        }
    }
}
