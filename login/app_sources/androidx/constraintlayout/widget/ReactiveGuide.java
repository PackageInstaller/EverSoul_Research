package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

/* loaded from: classes.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange;
    private boolean mApplyToAllConstraintSets;
    private int mApplyToConstraintSetId;
    private int mAttributeId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setVisibility(int visibility) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReactiveGuide(Context context) {
        super(context);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReactiveGuide(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(attrs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReactiveGuide(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(attrs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReactiveGuide(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(attrs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C0207R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0207R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.mAttributeId = obtainStyledAttributes.getResourceId(index, this.mAttributeId);
                } else if (index == C0207R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.mAnimateChange = obtainStyledAttributes.getBoolean(index, this.mAnimateChange);
                } else if (index == C0207R.styleable.f68x2694048c) {
                    this.mApplyToConstraintSetId = obtainStyledAttributes.getResourceId(index, this.mApplyToConstraintSetId);
                } else if (index == C0207R.styleable.f67xfdeff96) {
                    this.mApplyToAllConstraintSets = obtainStyledAttributes.getBoolean(index, this.mApplyToAllConstraintSets);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mAttributeId != -1) {
            ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAttributeId() {
        return this.mAttributeId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAttributeId(int id) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i = this.mAttributeId;
        if (i != -1) {
            sharedValues.removeListener(i, this);
        }
        this.mAttributeId = id;
        if (id != -1) {
            sharedValues.addListener(id, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setApplyToConstraintSetId(int id) {
        this.mApplyToConstraintSetId = id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAnimateChange(boolean animate) {
        this.mAnimateChange = animate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGuidelineBegin(int margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = margin;
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGuidelineEnd(int margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = margin;
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = ratio;
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int key, int newValue, int oldValue) {
        setGuidelineBegin(newValue);
        int id = getId();
        if (id > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i = this.mApplyToConstraintSetId;
            if (i != 0) {
                currentState = i;
            }
            int i2 = 0;
            if (this.mAnimateChange) {
                if (this.mApplyToAllConstraintSets) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i2 < constraintSetIds.length) {
                        int i3 = constraintSetIds[i2];
                        if (i3 != currentState) {
                            changeValue(newValue, id, motionLayout, i3);
                        }
                        i2++;
                    }
                }
                ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
                cloneConstraintSet.setGuidelineEnd(id, newValue);
                motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
                return;
            }
            if (this.mApplyToAllConstraintSets) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i2 < constraintSetIds2.length) {
                    changeValue(newValue, id, motionLayout, constraintSetIds2[i2]);
                    i2++;
                }
                return;
            }
            changeValue(newValue, id, motionLayout, currentState);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void changeValue(int newValue, int id, MotionLayout motionLayout, int currentState) {
        ConstraintSet constraintSet = motionLayout.getConstraintSet(currentState);
        constraintSet.setGuidelineEnd(id, newValue);
        motionLayout.updateState(currentState, constraintSet);
    }
}
