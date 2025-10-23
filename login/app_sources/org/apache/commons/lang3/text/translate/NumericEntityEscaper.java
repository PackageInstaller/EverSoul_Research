package org.apache.commons.lang3.text.translate;

import com.liapp.y;
import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes2.dex */
public class NumericEntityEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NumericEntityEscaper(int i, int i2, boolean z) {
        this.below = i;
        this.above = i2;
        this.between = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NumericEntityEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NumericEntityEscaper above(int i) {
        return outsideOf(0, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NumericEntityEscaper between(int i, int i2) {
        return new NumericEntityEscaper(i, i2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NumericEntityEscaper outsideOf(int i, int i2) {
        return new NumericEntityEscaper(i, i2, false);
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
        writer.write(y.֬ڱܱײٮ(-1159719039));
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}
