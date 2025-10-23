package com.google.common.base;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;

    /* renamed from: BS */
    public static final byte f335BS = 8;
    public static final byte CAN = 24;
    private static final char CASE_MASK = ' ';

    /* renamed from: CR */
    public static final byte f336CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final byte DLE = 16;

    /* renamed from: EM */
    public static final byte f337EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;

    /* renamed from: FF */
    public static final byte f338FF = 12;

    /* renamed from: FS */
    public static final byte f339FS = 28;

    /* renamed from: GS */
    public static final byte f340GS = 29;

    /* renamed from: HT */
    public static final byte f341HT = 9;

    /* renamed from: LF */
    public static final byte f342LF = 10;
    public static final char MAX = 127;
    public static final char MIN = 0;
    public static final byte NAK = 21;

    /* renamed from: NL */
    public static final byte f343NL = 10;
    public static final byte NUL = 0;

    /* renamed from: RS */
    public static final byte f344RS = 30;

    /* renamed from: SI */
    public static final byte f345SI = 15;

    /* renamed from: SO */
    public static final byte f346SO = 14;
    public static final byte SOH = 1;

    /* renamed from: SP */
    public static final byte f347SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;

    /* renamed from: US */
    public static final byte f348US = 31;

    /* renamed from: VT */
    public static final byte f349VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getAlphaIndex(char c) {
        return (char) ((c | CASE_MASK) - 97);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Ascii() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toLowerCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char) (c ^ CASE_MASK);
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toLowerCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = toLowerCase(charSequence.charAt(i));
        }
        return String.valueOf(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c ^ CASE_MASK) : c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toUpperCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isLowerCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isLowerCase(c)) {
                        charArray[i] = (char) (c ^ CASE_MASK);
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toUpperCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = toUpperCase(charSequence.charAt(i));
        }
        return String.valueOf(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c ^ CASE_MASK) : c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String truncate(CharSequence charSequence, int i, String str) {
        Preconditions.checkNotNull(charSequence);
        int length = i - str.length();
        Preconditions.checkArgument(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i, str.length());
        int length2 = charSequence.length();
        String str2 = charSequence;
        if (length2 <= i) {
            String obj = charSequence.toString();
            int length3 = obj.length();
            str2 = obj;
            if (length3 <= i) {
                return obj;
            }
        }
        return new StringBuilder(i).append((CharSequence) str2, 0, length).append(str).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int alphaIndex;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2 && ((alphaIndex = getAlphaIndex(charAt)) >= 26 || alphaIndex != getAlphaIndex(charAt2))) {
                return false;
            }
        }
        return true;
    }
}
