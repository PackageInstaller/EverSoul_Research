package org.apache.commons.lang3.builder;

import com.liapp.y;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class ToStringBuilder implements Builder<String> {
    private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
    private final StringBuffer buffer;
    private final Object object;
    private final ToStringStyle style;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ToStringStyle getDefaultStyle() {
        return defaultStyle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setDefaultStyle(ToStringStyle toStringStyle) {
        Validate.isTrue(toStringStyle != null, y.دײܮڳܯ(2051641957), new Object[0]);
        defaultStyle = toStringStyle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String reflectionToString(Object obj) {
        return ReflectionToStringBuilder.toString(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String reflectionToString(Object obj, ToStringStyle toStringStyle) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle, z, false, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> String reflectionToString(T t, ToStringStyle toStringStyle, boolean z, Class<? super T> cls) {
        return ReflectionToStringBuilder.toString(t, toStringStyle, z, false, cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder(Object obj) {
        this(obj, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        this(obj, toStringStyle, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        toStringStyle = toStringStyle == null ? getDefaultStyle() : toStringStyle;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.buffer = stringBuffer;
        this.style = toStringStyle;
        this.object = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(boolean z) {
        this.style.append(this.buffer, (String) null, z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(boolean[] zArr) {
        this.style.append(this.buffer, (String) null, zArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(byte b) {
        this.style.append(this.buffer, (String) null, b);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(byte[] bArr) {
        this.style.append(this.buffer, (String) null, bArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(char c) {
        this.style.append(this.buffer, (String) null, c);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(char[] cArr) {
        this.style.append(this.buffer, (String) null, cArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(double d) {
        this.style.append(this.buffer, (String) null, d);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(double[] dArr) {
        this.style.append(this.buffer, (String) null, dArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(float f) {
        this.style.append(this.buffer, (String) null, f);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(float[] fArr) {
        this.style.append(this.buffer, (String) null, fArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(int i) {
        this.style.append(this.buffer, (String) null, i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(int[] iArr) {
        this.style.append(this.buffer, (String) null, iArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(long j) {
        this.style.append(this.buffer, (String) null, j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(long[] jArr) {
        this.style.append(this.buffer, (String) null, jArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(Object obj) {
        this.style.append(this.buffer, (String) null, obj, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(Object[] objArr) {
        this.style.append(this.buffer, (String) null, objArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(short s) {
        this.style.append(this.buffer, (String) null, s);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(short[] sArr) {
        this.style.append(this.buffer, (String) null, sArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, boolean z) {
        this.style.append(this.buffer, str, z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, boolean[] zArr) {
        this.style.append(this.buffer, str, zArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, boolean[] zArr, boolean z) {
        this.style.append(this.buffer, str, zArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, byte b) {
        this.style.append(this.buffer, str, b);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, byte[] bArr) {
        this.style.append(this.buffer, str, bArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, byte[] bArr, boolean z) {
        this.style.append(this.buffer, str, bArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, char c) {
        this.style.append(this.buffer, str, c);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, char[] cArr) {
        this.style.append(this.buffer, str, cArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, char[] cArr, boolean z) {
        this.style.append(this.buffer, str, cArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, double d) {
        this.style.append(this.buffer, str, d);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, double[] dArr) {
        this.style.append(this.buffer, str, dArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, double[] dArr, boolean z) {
        this.style.append(this.buffer, str, dArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, float f) {
        this.style.append(this.buffer, str, f);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, float[] fArr) {
        this.style.append(this.buffer, str, fArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, float[] fArr, boolean z) {
        this.style.append(this.buffer, str, fArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, int i) {
        this.style.append(this.buffer, str, i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, int[] iArr) {
        this.style.append(this.buffer, str, iArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, int[] iArr, boolean z) {
        this.style.append(this.buffer, str, iArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, long j) {
        this.style.append(this.buffer, str, j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, long[] jArr) {
        this.style.append(this.buffer, str, jArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, long[] jArr, boolean z) {
        this.style.append(this.buffer, str, jArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, Object obj) {
        this.style.append(this.buffer, str, obj, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, Object obj, boolean z) {
        this.style.append(this.buffer, str, obj, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, Object[] objArr) {
        this.style.append(this.buffer, str, objArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, Object[] objArr, boolean z) {
        this.style.append(this.buffer, str, objArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, short s) {
        this.style.append(this.buffer, str, s);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, short[] sArr) {
        this.style.append(this.buffer, str, sArr, (Boolean) null);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder append(String str, short[] sArr, boolean z) {
        this.style.append(this.buffer, str, sArr, Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder appendAsObjectToString(Object obj) {
        ObjectUtils.identityToString(getStringBuffer(), obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder appendSuper(String str) {
        if (str != null) {
            this.style.appendSuper(this.buffer, str);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringBuilder appendToString(String str) {
        if (str != null) {
            this.style.appendToString(this.buffer, str);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getObject() {
        return this.object;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StringBuffer getStringBuffer() {
        return this.buffer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringStyle getStyle() {
        return this.style;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        if (getObject() == null) {
            getStringBuffer().append(getStyle().getNullText());
        } else {
            this.style.appendEnd(getStringBuffer(), getObject());
        }
        return getStringBuffer().toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.Builder
    public String build() {
        return toString();
    }
}
