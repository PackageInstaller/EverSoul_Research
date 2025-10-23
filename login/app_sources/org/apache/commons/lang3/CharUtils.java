package org.apache.commons.lang3;

import com.liapp.y;

/* loaded from: classes2.dex */
public class CharUtils {

    /* renamed from: CR */
    public static final char f1521CR = '\r';

    /* renamed from: LF */
    public static final char f1522LF = '\n';
    public static final char NUL = 0;
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int compare(char c, char c2) {
        return c - c2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAscii(char c) {
        return c < 128;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiAlphaLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiAlphaUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiControl(char c) {
        return c < ' ' || c == 127;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiPrintable(char c) {
        return c >= ' ' && c < 127;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        char c = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c >= strArr.length) {
                return;
            }
            strArr[c] = String.valueOf(c);
            c = (char) (c + 1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static Character toCharacterObject(char c) {
        return Character.valueOf(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char toChar(Character ch) {
        Validate.isTrue(ch != null, y.֬ڱܱײٮ(-1159248447), new Object[0]);
        return ch.charValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char toChar(Character ch, char c) {
        return ch == null ? c : ch.charValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char toChar(String str) {
        Validate.isTrue(StringUtils.isNotEmpty(str), y.ٴسسݬߨ(1392974242), new Object[0]);
        return str.charAt(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char toChar(String str, char c) {
        return StringUtils.isEmpty(str) ? c : str.charAt(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toIntValue(char c) {
        if (isAsciiNumeric(c)) {
            return c - '0';
        }
        throw new IllegalArgumentException(y.ۮڭڭܬި(862155739) + c + y.֬ڱܱײٮ(-1159248303));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toIntValue(char c, int i) {
        return !isAsciiNumeric(c) ? i : c - '0';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toIntValue(Character ch) {
        Validate.isTrue(ch != null, y.٬ݯح׭٩(575983710), new Object[0]);
        return toIntValue(ch.charValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toIntValue(Character ch, int i) {
        return ch == null ? i : toIntValue(ch.charValue(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(char c) {
        if (c < 128) {
            return CHAR_STRING_ARRAY[c];
        }
        return new String(new char[]{c});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String unicodeEscaped(char c) {
        StringBuilder sb = new StringBuilder(y.ݮڮֲڭܩ(-628940484));
        char[] cArr = HEX_DIGITS;
        return sb.append(cArr[(c >> '\f') & 15]).append(cArr[(c >> '\b') & 15]).append(cArr[(c >> 4) & 15]).append(cArr[c & 15]).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiAlpha(char c) {
        return isAsciiAlphaUpper(c) || isAsciiAlphaLower(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsciiAlphanumeric(char c) {
        return isAsciiAlpha(c) || isAsciiNumeric(c);
    }
}
