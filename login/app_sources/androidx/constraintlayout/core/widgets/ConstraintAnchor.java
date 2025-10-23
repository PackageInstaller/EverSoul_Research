package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
    private int mFinalValue;
    private boolean mHasFinalValue;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;
    private HashSet<ConstraintAnchor> mDependents = null;
    public int mMargin = 0;
    int mGoneMargin = Integer.MIN_VALUE;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void findDependents(int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                Grouping.findDependents(it.next().mOwner, i, arrayList, widgetGroup);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashSet<ConstraintAnchor> getDependents() {
        return this.mDependents;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        return hashSet != null && hashSet.size() > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().getOpposite().isConnected()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFinalValue(int i) {
        this.mFinalValue = i;
        this.mHasFinalValue = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getFinalValue() {
        if (this.mHasFinalValue) {
            return this.mFinalValue;
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasFinalValue() {
        return this.mHasFinalValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void copyFrom(ConstraintAnchor constraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor2 = this.mTarget;
        if (constraintAnchor2 != null && (hashSet = constraintAnchor2.mDependents) != null) {
            hashSet.remove(this);
        }
        ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
        if (constraintAnchor3 != null) {
            this.mTarget = hashMap.get(constraintAnchor.mTarget.mOwner).getAnchor(constraintAnchor3.getType());
        } else {
            this.mTarget = null;
        }
        ConstraintAnchor constraintAnchor4 = this.mTarget;
        if (constraintAnchor4 != null) {
            if (constraintAnchor4.mDependents == null) {
                constraintAnchor4.mDependents = new HashSet<>();
            }
            this.mTarget.mDependents.add(this);
        }
        this.mMargin = constraintAnchor.mMargin;
        this.mGoneMargin = constraintAnchor.mGoneMargin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resetSolverVariable(Cache cache) {
        SolverVariable solverVariable = this.mSolverVariable;
        if (solverVariable == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.reset();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Type getType() {
        return this.mType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.mGoneMargin != Integer.MIN_VALUE && (constraintAnchor = this.mTarget) != null && constraintAnchor.mOwner.getVisibility() == 8) {
            return this.mGoneMargin;
        }
        return this.mMargin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor != null && (hashSet = constraintAnchor.mDependents) != null) {
            hashSet.remove(this);
            if (this.mTarget.mDependents.size() == 0) {
                this.mTarget.mDependents = null;
            }
        }
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = Integer.MIN_VALUE;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            reset();
            return true;
        }
        if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        }
        this.mTarget = constraintAnchor;
        if (constraintAnchor.mDependents == null) {
            constraintAnchor.mDependents = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.mTarget.mDependents;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.mMargin = i;
        this.mGoneMargin = i2;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean connect(ConstraintAnchor constraintAnchor, int i) {
        return connect(constraintAnchor, i, Integer.MIN_VALUE, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isConnected() {
        return this.mTarget != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        Type type2 = this.mType;
        if (type == type2) {
            return type2 != Type.BASELINE || (constraintAnchor.getOwner().hasBaseline() && getOwner().hasBaseline());
        }
        switch (C01781.f43x6930e354[this.mType.ordinal()]) {
            case 1:
                return (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = type == Type.LEFT || type == Type.RIGHT;
                if (constraintAnchor.getOwner() instanceof Guideline) {
                    return z || type == Type.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = type == Type.TOP || type == Type.BOTTOM;
                if (constraintAnchor.getOwner() instanceof Guideline) {
                    return z2 || type == Type.CENTER_Y;
                }
                return z2;
            case 6:
                return (type == Type.LEFT || type == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintAnchor$1 */
    static /* synthetic */ class C01781 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type */
        static final /* synthetic */ int[] f43x6930e354;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Type.values().length];
            f43x6930e354 = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43x6930e354[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43x6930e354[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43x6930e354[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43x6930e354[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43x6930e354[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43x6930e354[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f43x6930e354[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f43x6930e354[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSideAnchor() {
        switch (C01781.f43x6930e354[this.mType.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        Type type = constraintAnchor.getType();
        if (type == this.mType) {
            return true;
        }
        switch (C01781.f43x6930e354[this.mType.ordinal()]) {
            case 1:
                return type != Type.BASELINE;
            case 2:
            case 3:
            case 7:
                return type == Type.LEFT || type == Type.RIGHT || type == Type.CENTER_X;
            case 4:
            case 5:
            case 6:
            case 8:
                return type == Type.TOP || type == Type.BOTTOM || type == Type.CENTER_Y || type == Type.BASELINE;
            case 9:
                return false;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMargin(int i) {
        if (isConnected()) {
            this.mMargin = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGoneMargin(int i) {
        if (isConnected()) {
            this.mGoneMargin = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isVerticalAnchor() {
        switch (C01781.f43x6930e354[this.mType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 7:
                return false;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
                return true;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.mOwner.getDebugName() + CertificateUtil.DELIMITER + this.mType.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return isConnectionAllowed(constraintWidget);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (isConnectionToMe(constraintWidget, new HashSet<>())) {
            return false;
        }
        ConstraintWidget parent = getOwner().getParent();
        return parent == constraintWidget || constraintWidget.getParent() == parent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isConnectionToMe(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == getOwner()) {
            return true;
        }
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && isConnectionToMe(constraintAnchor.getTarget().getOwner(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ConstraintAnchor getOpposite() {
        switch (C01781.f43x6930e354[this.mType.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.mOwner.mRight;
            case 3:
                return this.mOwner.mLeft;
            case 4:
                return this.mOwner.mBottom;
            case 5:
                return this.mOwner.mTop;
            default:
                throw new AssertionError(this.mType.name());
        }
    }
}
