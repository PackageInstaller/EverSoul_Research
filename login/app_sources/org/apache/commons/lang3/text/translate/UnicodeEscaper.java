package org.apache.commons.lang3.text.translate;

import com.liapp.y;
import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes2.dex */
public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected UnicodeEscaper(int i, int i2, boolean z) {
        this.below = i;
        this.above = i2;
        this.between = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnicodeEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnicodeEscaper above(int i) {
        return outsideOf(0, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnicodeEscaper outsideOf(int i, int i2) {
        return new UnicodeEscaper(i, i2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnicodeEscaper between(int i, int i2) {
        return new UnicodeEscaper(i, i2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i, Writer writer) throws IOException {
        if (this.between) {
            if (i < this.below || i > this.above) {
                return false;
            }
        } else if (i >= this.below && i <= this.above) {
            return false;
        }
        if (i > 65535) {
            writer.write(toUtf16Escape(i));
            return true;
        }
        writer.write(y.ݮڮֲڭܩ(-628940484));
        writer.write(HEX_DIGITS[(i >> 12) & 15]);
        writer.write(HEX_DIGITS[(i >> 8) & 15]);
        writer.write(HEX_DIGITS[(i >> 4) & 15]);
        writer.write(HEX_DIGITS[i & 15]);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String toUtf16Escape(int i) {
        return y.ݮڮֲڭܩ(-628940484) + hex(i);
    }
}
