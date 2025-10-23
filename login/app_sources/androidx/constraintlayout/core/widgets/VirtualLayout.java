package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* loaded from: classes.dex */
public class VirtualLayout extends HelperWidget {
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingEnd = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;
    private boolean mNeedsCallFromSolver = false;
    private int mMeasuredWidth = 0;
    private int mMeasuredHeight = 0;
    protected BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    BasicMeasure.Measurer mMeasurer = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void measure(int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPadding(int i) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i;
        this.mPaddingRight = i;
        this.mPaddingBottom = i;
        this.mPaddingStart = i;
        this.mPaddingEnd = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaddingStart(int i) {
        this.mPaddingStart = i;
        this.mResolvedPaddingLeft = i;
        this.mResolvedPaddingRight = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaddingEnd(int i) {
        this.mPaddingEnd = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
        this.mResolvedPaddingLeft = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void applyRtl(boolean z) {
        int i = this.mPaddingStart;
        if (i > 0 || this.mPaddingEnd > 0) {
            if (z) {
                this.mResolvedPaddingLeft = this.mPaddingEnd;
                this.mResolvedPaddingRight = i;
            } else {
                this.mResolvedPaddingLeft = i;
                this.mResolvedPaddingRight = this.mPaddingEnd;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaddingTop(int i) {
        this.mPaddingTop = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
        this.mResolvedPaddingRight = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaddingBottom(int i) {
        this.mPaddingBottom = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void needsCallbackFromSolver(boolean z) {
        this.mNeedsCallFromSolver = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void captureWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMeasure(int i, int i2) {
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean measureChildren() {
        BasicMeasure.Measurer measurer = this.mParent != null ? ((ConstraintWidgetContainer) this.mParent).getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null && !(constraintWidget instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                if (!(dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight != 1)) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    this.mMeasure.horizontalBehavior = dimensionBehaviour;
                    this.mMeasure.verticalBehavior = dimensionBehaviour2;
                    this.mMeasure.horizontalDimension = constraintWidget.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget.getHeight();
                    measurer.measure(constraintWidget, this.mMeasure);
                    constraintWidget.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
            i++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.mMeasurer == null && getParent() != null) {
            this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        this.mMeasure.horizontalBehavior = dimensionBehaviour;
        this.mMeasure.verticalBehavior = dimensionBehaviour2;
        this.mMeasure.horizontalDimension = i;
        this.mMeasure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(HashSet<ConstraintWidget> hashSet) {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            if (hashSet.contains(this.mWidgets[i])) {
                return true;
            }
        }
        return false;
    }
}
