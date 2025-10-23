package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    HashMap<Integer, HashMap<String, KeyPosition>> keyPositions = new HashMap<>();
    private HashMap<String, WidgetState> state = new HashMap<>();
    TypedBundle mBundle = new TypedBundle();
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private Easing mEasing = null;
    private int mAutoTransition = 0;
    private int mDuration = 400;
    private float mStagger = 0.0f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$0(String str, float f) {
        return (float) Easing.getInterpolator(str).get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$1(float f) {
        return (float) Easing.getInterpolator("standard").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$2(float f) {
        return (float) Easing.getInterpolator("accelerate").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$3(float f) {
        return (float) Easing.getInterpolator("decelerate").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$4(float f) {
        return (float) Easing.getInterpolator("linear").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Interpolator getInterpolator(int i, final String str) {
        switch (i) {
            case -1:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$0(str, f);
                    }
                };
            case 0:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$1(f);
                    }
                };
            case 1:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$2(f);
                    }
                };
            case 2:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda3
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$3(f);
                    }
                };
            case 3:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda4
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$4(f);
                    }
                };
            case 4:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda7
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$7(f);
                    }
                };
            case 5:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda6
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$6(f);
                    }
                };
            case 6:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.Transition$$ExternalSyntheticLambda5
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        return Transition.lambda$getInterpolator$5(f);
                    }
                };
            default:
                return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$5(float f) {
        return (float) Easing.getInterpolator("anticipate").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$6(float f) {
        return (float) Easing.getInterpolator("overshoot").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ float lambda$getInterpolator$7(float f) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KeyPosition findPreviousPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i >= 0) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i--;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KeyPosition findNextPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i <= 100) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i++;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i2));
            if (hashMap != null && hashMap.get(widgetFrame.widget.stringId) != null) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Motion getMotion(String str) {
        return getWidgetState(str, null, 0).motionControl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i2));
            if (hashMap != null && (keyPosition = hashMap.get(widgetFrame.widget.stringId)) != null) {
                fArr[i] = keyPosition.f41x;
                fArr2[i] = keyPosition.f42y;
                fArr3[i] = keyPosition.frame;
                i++;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasPositionKeyframes() {
        return this.keyPositions.size() > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.mBundle);
        typedBundle.applyDelta(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i != 706) {
            return false;
        }
        this.mStagger = f;
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 705) {
            return false;
        }
        this.mDefaultInterpolatorString = str;
        this.mEasing = Easing.getInterpolator(str);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEmpty() {
        return this.state.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        this.state.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(String str) {
        return this.state.containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyCycle(typedBundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addKeyPosition(String str, int i, int i2, float f, float f2) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, 2);
        typedBundle.add(100, i);
        typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_X, f);
        typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_Y, f2);
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i, i2, f, f2);
        HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.keyPositions.put(Integer.valueOf(i), hashMap);
        }
        hashMap.put(str, keyPosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addCustomFloat(int i, String str, String str2, float f) {
        getWidgetState(str, null, i).getFrame(i).addCustomFloat(str2, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addCustomColor(int i, String str, String str2, int i2) {
        getWidgetState(str, null, i).getFrame(i).addCustomColor(str2, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = children.get(i2);
            getWidgetState(constraintWidget.stringId, null, i).update(constraintWidget, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void interpolate(int i, int i2, float f) {
        Easing easing = this.mEasing;
        if (easing != null) {
            f = (float) easing.get(f);
        }
        Iterator<String> it = this.state.keySet().iterator();
        while (it.hasNext()) {
            this.state.get(it.next()).interpolate(i, i2, f, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.start;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.end;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.interpolated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float[] getPath(String str) {
        float[] fArr = new float[124];
        this.state.get(str).motionControl.buildPath(fArr, 62);
        return fArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.state.get(str).motionControl.buildKeyFrames(fArr, iArr, iArr2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private WidgetState getWidgetState(String str) {
        return this.state.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.mBundle.applyDelta(widgetState.motionControl);
            this.state.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i);
            }
        }
        return widgetState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 0).start;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 1).end;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 2).interpolated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    static class WidgetState {
        Motion motionControl;
        KeyCache myKeyCache = new KeyCache();
        int myParentHeight = -1;
        int myParentWidth = -1;
        WidgetFrame start = new WidgetFrame();
        WidgetFrame end = new WidgetFrame();
        WidgetFrame interpolated = new WidgetFrame();
        MotionWidget motionWidgetStart = new MotionWidget(this.start);
        MotionWidget motionWidgetEnd = new MotionWidget(this.end);
        MotionWidget motionWidgetInterpolated = new MotionWidget(this.interpolated);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WidgetState() {
            Motion motion = new Motion(this.motionWidgetStart);
            this.motionControl = motion;
            motion.setStart(this.motionWidgetStart);
            this.motionControl.setEnd(this.motionWidgetEnd);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta(motionKeyPosition);
            this.motionControl.addKey(motionKeyPosition);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            this.motionControl.addKey(motionKeyAttributes);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta(motionKeyCycle);
            this.motionControl.addKey(motionKeyCycle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void update(ConstraintWidget constraintWidget, int i) {
            if (i == 0) {
                this.start.update(constraintWidget);
                this.motionControl.setStart(this.motionWidgetStart);
            } else if (i == 1) {
                this.end.update(constraintWidget);
                this.motionControl.setEnd(this.motionWidgetEnd);
            }
            this.myParentWidth = -1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WidgetFrame getFrame(int i) {
            if (i == 0) {
                return this.start;
            }
            if (i == 1) {
                return this.end;
            }
            return this.interpolated;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void interpolate(int i, int i2, float f, Transition transition) {
            this.myParentHeight = i2;
            this.myParentWidth = i;
            this.motionControl.setup(i, i2, 1.0f, System.nanoTime());
            WidgetFrame.interpolate(i, i2, this.interpolated, this.start, this.end, transition, f);
            this.interpolated.interpolatedPos = f;
            this.motionControl.interpolate(this.motionWidgetInterpolated, f, System.nanoTime(), this.myKeyCache);
        }
    }

    static class KeyPosition {
        int frame;
        String target;
        int type;

        /* renamed from: x */
        float f41x;

        /* renamed from: y */
        float f42y;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KeyPosition(String str, int i, int i2, float f, float f2) {
            this.target = str;
            this.frame = i;
            this.type = i2;
            this.f41x = f;
            this.f42y = f2;
        }
    }
}
