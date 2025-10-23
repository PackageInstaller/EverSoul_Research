package com.kakao.sdk.friend.p023l;

import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.kakao.sdk.friend.l.j */
/* loaded from: classes3.dex */
public final class C2194j {

    /* renamed from: a */
    public static final C2194j f850a = new C2194j();

    /* renamed from: b */
    public static final char[] f851b = {Typography.times, 247};

    /* renamed from: c */
    public static final char[] f852c = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: d */
    public static final char[] f853d = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};

    /* renamed from: e */
    public static final char[] f854e = {' ', 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: f */
    public static final char[] f855f = {12354, 12363, 12373, 12383, 12394, 12399, 12414, 12420, 12425, 12431};

    /* renamed from: g */
    public static final char[] f856g = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: h */
    public static final char[] f857h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        char[] cArr = {65377, 65378, 65379, 65380, 65381, 65382, 65383, 65384, 65385, 65386, 65387, 65388, 65389, 65390, 65391, 65392, 65393, 65394, 65395, 65396, 65397, 65398, 65399, 65400, 65401, 65402, 65403, 65404, 65405, 65406, 65407, 65408, 65409, 65410, 65411, 65412, 65413, 65414, 65415, 65416, 65417, 65418, 65419, 65420, 65421, 65422, 65423, 65424, 65425, 65426, 65427, 65428, 65429, 65430, 65431, 65432, 65433, 65434, 65435, 65436, 65437, 65438, 65439};
        char c = cArr[0];
        char c2 = cArr[62];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: c */
    public static final String m556c(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (StringUtils.isBlank(s)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = s.charAt(i);
            boolean z = charAt <= 12447 && 12353 <= charAt;
            char charAt2 = s.charAt(i);
            if (z) {
                charAt2 = (char) (charAt2 + '`');
            }
            sb.append(charAt2);
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…   }\n        }.toString()");
        return sb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: d */
    public static final boolean m557d(char c) {
        if (c <= 12534 && 12353 <= c) {
            return true;
        }
        return c <= 65439 && 65377 <= c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final int m558a(int i) {
        return 131072 <= i && i < 173792 ? 7 : 9;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final String m559b(char c) {
        return (c == 12632 || c == 12633) ? "ㅗㅏ" : c == 12634 ? "ㅗㅣ" : c == 12637 ? "ㅜㅓ" : c == 12638 ? "ㅜㅔ" : c == 12639 ? "ㅜㅣ" : c == 12642 ? "ㅡㅣ" : c == 12594 ? "ㄱㄱ" : c == 12595 ? "ㄱㅅ" : c == 12597 ? "ㄴㅈ" : c == 12598 ? "ㄴㅎ" : c == 12600 ? "ㄷㄷ" : c == 12602 ? "ㄹㄱ" : c == 12603 ? "ㄹㅁ" : c == 12604 ? "ㄹㅂ" : c == 12605 ? "ㄹㅅ" : c == 12606 ? "ㄹㅌ" : c == 12607 ? "ㄹㅍ" : c == 12608 ? "ㄹㅎ" : c == 12611 ? "ㅂㅂ" : c == 12612 ? "ㅂㅅ" : c == 12614 ? "ㅅㅅ" : c == 12617 ? "ㅈㅈ" : String.valueOf(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final boolean m560c(char c) {
        return 44032 <= c && c < 55204;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final char m552a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringUtils.isBlank(value)) {
            return ' ';
        }
        char c = 0;
        char charAt = value.charAt(0);
        C2194j c2194j = f850a;
        if (c2194j.m560c(charAt)) {
            if (c2194j.m560c(charAt)) {
                return f852c[(charAt - 44032) / 588];
            }
            return charAt;
        }
        if (m557d(charAt)) {
            int i = charAt <= 12447 && 12353 <= charAt ? charAt - 12353 : charAt - 12449;
            if (!(i >= 0 && i < 10)) {
                if (10 <= i && i < 20) {
                    c = 1;
                } else {
                    if (20 <= i && i < 30) {
                        c = 2;
                    } else {
                        if (30 <= i && i < 41) {
                            c = 3;
                        } else {
                            if (41 <= i && i < 46) {
                                c = 4;
                            } else {
                                if (46 <= i && i < 61) {
                                    c = 5;
                                } else {
                                    if (61 <= i && i < 66) {
                                        c = 6;
                                    } else {
                                        if (66 <= i && i < 72) {
                                            c = 7;
                                        } else {
                                            if (72 <= i && i < 77) {
                                                c = '\b';
                                            } else {
                                                if (77 <= i && i < 84) {
                                                    c = '\t';
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f855f[c];
        }
        return Character.toLowerCase(charAt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: b */
    public static final String m555b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i++;
            C2194j c2194j = f850a;
            if (c2194j.m560c(charAt) && c2194j.m560c(charAt)) {
                charAt = f852c[(charAt - 44032) / 588];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c0, code lost:
    
        if ((13312 <= r5 && r5 < 19904) != false) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a7  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m561e(char r5) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p023l.C2194j.m561e(char):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final String m553a(char c) {
        StringBuilder sb = new StringBuilder();
        C2194j c2194j = f850a;
        Intrinsics.checkNotNullParameter(sb, "sb");
        if (c2194j.m560c(c)) {
            int i = c - 44032;
            int i2 = i % 28;
            int i3 = (i - i2) / 28;
            sb.append(c2194j.m559b(f852c[i3 / 21]));
            sb.append(c2194j.m559b(f853d[i3 % 21]));
            if (i2 > 0) {
                sb.append(c2194j.m559b(f854e[i2]));
            }
        } else {
            sb.append(c);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final boolean m554a(String filterKeyword, String search) {
        boolean z;
        boolean z2;
        int indexOf$default;
        Intrinsics.checkNotNullParameter(filterKeyword, "filterKeyword");
        Intrinsics.checkNotNullParameter(search, "search");
        String replace = new Regex("\\s").replace(filterKeyword, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String value = replace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(value, "this as java.lang.String).toLowerCase(locale)");
        String search2 = new Regex("\\s").replace(search, "");
        boolean z3 = true;
        if (value == null || search2 == null) {
            z = value != null || search2 == value;
        } else {
            String m555b = m555b(value);
            Intrinsics.checkNotNull(m555b);
            z = StringsKt.contains$default((CharSequence) m555b, (CharSequence) search2, false, 2, (Object) null);
        }
        if (z) {
            return true;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase = search2.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.contains$default((CharSequence) value, (CharSequence) lowerCase, false, 2, (Object) null)) {
            return true;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(search2, "search");
        String m555b2 = m555b(value);
        String m555b3 = m555b(search2);
        if (m555b2 != null && m555b3 != null && StringsKt.contains$default((CharSequence) m555b2, (CharSequence) m555b3, false, 2, (Object) null)) {
            int i = 0;
            while (i <= value.length() - search2.length() && (indexOf$default = StringsKt.indexOf$default((CharSequence) m555b2, m555b3, i, false, 4, (Object) null)) >= 0) {
                i = indexOf$default + 1;
                int i2 = 0;
                while (i2 < search2.length()) {
                    int i3 = indexOf$default + i2;
                    if (m555b2.charAt(i3) != search2.charAt(i2) && value.charAt(i3) != search2.charAt(i2)) {
                        if (i2 != search2.length() - 1) {
                            break;
                        }
                        String m553a = m553a(search2.charAt(i2));
                        String m553a2 = m553a(value.charAt(i3));
                        int i4 = i3 + 1;
                        if (StringsKt.indexOf$default((CharSequence) (i4 < value.length() ? Intrinsics.stringPlus(m553a2, Character.valueOf(m555b2.charAt(i4))) : m553a2), m553a, 0, false, 6, (Object) null) != 0) {
                            break;
                        }
                    }
                    i2++;
                }
                if (i2 == search2.length()) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            return true;
        }
        char[] s = search2.toCharArray();
        Intrinsics.checkNotNullExpressionValue(s, "this as java.lang.String).toCharArray()");
        Intrinsics.checkNotNullParameter(s, "s");
        int length = s.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z3 = false;
                break;
            }
            char c = s[i5];
            i5++;
            if (m557d(c)) {
                break;
            }
        }
        if (z3) {
            return StringUtils.contains(m556c(search2), m556c(value));
        }
        return false;
    }
}
