package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes.dex */
public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    public abstract void setProperty(View view, float t);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ViewSpline makeSpline(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    c = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    c = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
                    c = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = CharUtils.f1521CR;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
        }
        return new AlphaSet();
    }

    static class ElevationSet extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ElevationSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setElevation(get(t));
        }
    }

    static class AlphaSet extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AlphaSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setAlpha(get(t));
        }
    }

    static class RotationSet extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RotationSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setRotation(get(t));
        }
    }

    static class RotationXset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RotationXset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setRotationX(get(t));
        }
    }

    static class RotationYset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RotationYset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setRotationY(get(t));
        }
    }

    static class PivotXset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PivotXset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setPivotX(get(t));
        }
    }

    static class PivotYset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PivotYset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setPivotY(get(t));
        }
    }

    public static class PathRotate extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPathRotate(View view, float t, double dx, double dy) {
            view.setRotation(get(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    static class ScaleXset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ScaleXset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setScaleX(get(t));
        }
    }

    static class ScaleYset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ScaleYset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setScaleY(get(t));
        }
    }

    static class TranslationXset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TranslationXset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setTranslationX(get(t));
        }
    }

    static class TranslationYset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TranslationYset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setTranslationY(get(t));
        }
    }

    static class TranslationZset extends ViewSpline {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TranslationZset() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setTranslationZ(get(t));
        }
    }

    public static class CustomSet extends ViewSpline {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i = 0; i < size; i++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i);
                dArr[i] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i2 = 0;
                while (true) {
                    if (i2 < this.mTempValues.length) {
                        dArr2[i][i2] = r6[i2];
                        i2++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(curveType, dArr, dArr2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPoint(int position, ConstraintAttribute value) {
            this.mConstraintAttributeList.append(position, value);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            this.mCurveFit.getPos(t, this.mTempValues);
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mTempValues);
        }
    }

    static class ProgressSet extends ViewSpline {
        boolean mNoMethod = false;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ProgressSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(t)));
                } catch (IllegalAccessException e) {
                    Log.e(ViewSpline.TAG, "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e(ViewSpline.TAG, "unable to setProgress", e2);
                }
            }
        }
    }
}
