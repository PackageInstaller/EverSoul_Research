package org.apache.commons.lang3.text.translate;

import com.liapp.y;

@Deprecated
/* loaded from: classes2.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JavaUnicodeEscaper above(int i) {
        return outsideOf(0, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JavaUnicodeEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JavaUnicodeEscaper between(int i, int i2) {
        return new JavaUnicodeEscaper(i, i2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JavaUnicodeEscaper outsideOf(int i, int i2) {
        return new JavaUnicodeEscaper(i, i2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JavaUnicodeEscaper(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    protected String toUtf16Escape(int i) {
        char[] chars = Character.toChars(i);
        String str = y.ݮڮֲڭܩ(-628940484);
        return str + hex(chars[0]) + str + hex(chars[1]);
    }
}
