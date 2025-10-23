package org.apache.commons.lang3.builder;

import com.liapp.y;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes2.dex */
public class MultilineRecursiveToStringStyle extends RecursiveToStringStyle {
    private static final int INDENT = 2;
    private static final long serialVersionUID = 1;
    private int spaces = 2;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MultilineRecursiveToStringStyle() {
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void resetIndent() {
        setArrayStart(y.֬ڱܱײٮ(-1159674159) + System.lineSeparator() + ((Object) spacer(this.spaces)));
        String str = y.ٲٴݴ״ٰ(1781559176);
        setArraySeparator(str + System.lineSeparator() + ((Object) spacer(this.spaces)));
        setArrayEnd(System.lineSeparator() + ((Object) spacer(this.spaces - 2)) + y.ۮڭڭܬި(861939259));
        setContentStart(y.ٴسسݬߨ(1392956562) + System.lineSeparator() + ((Object) spacer(this.spaces)));
        setFieldSeparator(str + System.lineSeparator() + ((Object) spacer(this.spaces)));
        setContentEnd(System.lineSeparator() + ((Object) spacer(this.spaces - 2)) + y.ۮڭڭܬި(862078387));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StringBuilder spacer(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(y.دײܮڳܯ(2051829469));
        }
        return sb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.RecursiveToStringStyle, org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        if (!ClassUtils.isPrimitiveWrapper(obj.getClass()) && !String.class.equals(obj.getClass()) && accept(obj.getClass())) {
            this.spaces += 2;
            resetIndent();
            stringBuffer.append(ReflectionToStringBuilder.toString(obj, this));
            this.spaces -= 2;
            resetIndent();
            return;
        }
        super.appendDetail(stringBuffer, str, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, objArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        this.spaces += 2;
        resetIndent();
        super.reflectionAppendArrayDetail(stringBuffer, str, obj);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, jArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, iArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, sArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, bArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, cArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, dArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, fArr);
        this.spaces -= 2;
        resetIndent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, zArr);
        this.spaces -= 2;
        resetIndent();
    }
}
