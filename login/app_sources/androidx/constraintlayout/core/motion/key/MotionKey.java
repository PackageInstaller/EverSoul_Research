package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class MotionKey implements TypedValues {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String ROTATION = "rotationZ";
    public static final String ROTATION_X = "rotationX";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public HashMap<String, CustomVariable> mCustom;
    public int mFramePosition;
    int mTargetId;
    String mTargetString;
    public int mType;

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract MotionKey mo912clone();

    public abstract void getAttributeNames(HashSet<String> hashSet);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionKey() {
        int i = UNSET;
        this.mFramePosition = i;
        this.mTargetId = i;
        this.mTargetString = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean matches(String str) {
        String str2 = this.mTargetString;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float toFloat(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int toInt(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean toBoolean(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionKey copy(MotionKey motionKey) {
        this.mFramePosition = motionKey.mFramePosition;
        this.mTargetId = motionKey.mTargetId;
        this.mTargetString = motionKey.mTargetString;
        this.mType = motionKey.mType;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionKey setViewId(int i) {
        this.mTargetId = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFramePosition(int i) {
        this.mFramePosition = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getFramePosition() {
        return this.mFramePosition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i != 100) {
            return false;
        }
        this.mFramePosition = i2;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 101) {
            return false;
        }
        this.mTargetString = str;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomAttribute(String str, int i, float f) {
        this.mCustom.put(str, new CustomVariable(str, i, f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomAttribute(String str, int i, int i2) {
        this.mCustom.put(str, new CustomVariable(str, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomAttribute(String str, int i, boolean z) {
        this.mCustom.put(str, new CustomVariable(str, i, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomAttribute(String str, int i, String str2) {
        this.mCustom.put(str, new CustomVariable(str, i, str2));
    }
}
