package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hsvToRgb(float f, float f2, float f3) {
        float f4 = f * 6.0f;
        int i = (int) f4;
        float f5 = f4 - i;
        float f6 = f3 * 255.0f;
        int i2 = (int) (((1.0f - f2) * f6) + 0.5f);
        int i3 = (int) (((1.0f - (f5 * f2)) * f6) + 0.5f);
        int i4 = (int) (((1.0f - ((1.0f - f5) * f2)) * f6) + 0.5f);
        int i5 = (int) (f6 + 0.5f);
        if (i == 0) {
            return ((i5 << 16) + (i4 << 8) + i2) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 1) {
            return ((i3 << 16) + (i5 << 8) + i2) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 2) {
            return ((i2 << 16) + (i5 << 8) + i4) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 3) {
            return ((i2 << 16) + (i3 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 4) {
            return ((i4 << 16) + (i2 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i != 5) {
            return 0;
        }
        return ((i5 << 16) + (i2 << 8) + i3) | ViewCompat.MEASURED_STATE_MASK;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AttributeType getType() {
        return this.mType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isContinuous() {
        int i = C01681.f20xbc2a0812[this.mType.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setColorValue(int i) {
        this.mColorValue = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int numberOfInterpolatedValues() {
        int i = C01681.f20xbc2a0812[this.mType.ordinal()];
        return (i == 4 || i == 5) ? 4 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getValueToInterpolate() {
        switch (this.mType) {
            case BOOLEAN_TYPE:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case STRING_TYPE:
                throw new RuntimeException("Cannot interpolate String");
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case INT_TYPE:
                return this.mIntegerValue;
            case FLOAT_TYPE:
                return this.mFloatValue;
            case DIMENSION_TYPE:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case BOOLEAN_TYPE:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case STRING_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i = (this.mColorValue >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                return;
            case INT_TYPE:
                fArr[0] = this.mIntegerValue;
                return;
            case FLOAT_TYPE:
                fArr[0] = this.mFloatValue;
                return;
            case DIMENSION_TYPE:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(float[] fArr) {
        switch (C01681.f20xbc2a0812[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 2:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int hsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = hsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (hsvToRgb & ViewCompat.MEASURED_SIZE_MASK);
                return;
            case 7:
                this.mFloatValue = fArr[0];
                return;
            case 8:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean diff(CustomAttribute customAttribute) {
        if (customAttribute == null || this.mType != customAttribute.mType) {
            return false;
        }
        switch (C01681.f20xbc2a0812[this.mType.ordinal()]) {
            case 1:
            case 6:
                return this.mIntegerValue == customAttribute.mIntegerValue;
            case 2:
                return this.mBooleanValue == customAttribute.mBooleanValue;
            case 3:
                return this.mIntegerValue == customAttribute.mIntegerValue;
            case 4:
            case 5:
                return this.mColorValue == customAttribute.mColorValue;
            case 7:
                return this.mFloatValue == customAttribute.mFloatValue;
            case 8:
                return this.mFloatValue == customAttribute.mFloatValue;
            default:
                return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = str;
        this.mType = attributeType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z;
        setValue(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.mName = customAttribute.mName;
        this.mType = customAttribute.mType;
        setValue(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(Object obj) {
        switch (C01681.f20xbc2a0812[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case 2:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.mStringValue = (String) obj;
                break;
            case 4:
            case 5:
                this.mColorValue = ((Integer) obj).intValue();
                break;
            case 7:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case 8:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }
}
