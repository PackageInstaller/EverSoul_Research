package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintReference implements Reference {
    private Object key;
    private float mCircularAngle;
    private float mCircularDistance;
    private ConstraintWidget mConstraintWidget;
    final State mState;
    private Object mView;
    String mTag = null;
    Facade mFacade = null;
    int mHorizontalChainStyle = 0;
    int mVerticalChainStyle = 0;
    float mHorizontalChainWeight = -1.0f;
    float mVerticalChainWeight = -1.0f;
    float mHorizontalBias = 0.5f;
    float mVerticalBias = 0.5f;
    protected int mMarginLeft = 0;
    protected int mMarginRight = 0;
    protected int mMarginStart = 0;
    protected int mMarginEnd = 0;
    int mMarginTop = 0;
    int mMarginBottom = 0;
    int mMarginLeftGone = 0;
    int mMarginRightGone = 0;
    int mMarginStartGone = 0;
    int mMarginEndGone = 0;
    int mMarginTopGone = 0;
    int mMarginBottomGone = 0;
    int mMarginBaseline = 0;
    int mMarginBaselineGone = 0;
    float mPivotX = Float.NaN;
    float mPivotY = Float.NaN;
    float mRotationX = Float.NaN;
    float mRotationY = Float.NaN;
    float mRotationZ = Float.NaN;
    float mTranslationX = Float.NaN;
    float mTranslationY = Float.NaN;
    float mTranslationZ = Float.NaN;
    float mAlpha = Float.NaN;
    float mScaleX = Float.NaN;
    float mScaleY = Float.NaN;
    int mVisibility = 0;
    protected Object mLeftToLeft = null;
    protected Object mLeftToRight = null;
    protected Object mRightToLeft = null;
    protected Object mRightToRight = null;
    protected Object mStartToStart = null;
    protected Object mStartToEnd = null;
    protected Object mEndToStart = null;
    protected Object mEndToEnd = null;
    protected Object mTopToTop = null;
    protected Object mTopToBottom = null;
    protected Object mBottomToTop = null;
    protected Object mBottomToBottom = null;
    Object mBaselineToBaseline = null;
    Object mBaselineToTop = null;
    Object mBaselineToBottom = null;
    Object mCircularConstraint = null;
    State.Constraint mLast = null;
    Dimension mHorizontalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
    Dimension mVerticalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
    private HashMap<String, Integer> mCustomColors = new HashMap<>();
    private HashMap<String, Float> mCustomFloats = new HashMap<>();

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object obj) {
        this.key = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.key;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTag(String str) {
        this.mTag = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTag() {
        return this.mTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setView(Object obj) {
        this.mView = obj;
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getView() {
        return this.mView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFacade(Facade facade) {
        this.mFacade = facade;
        if (facade != null) {
            setConstraintWidget(facade.getConstraintWidget());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return this.mFacade;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.mConstraintWidget = constraintWidget;
        constraintWidget.setCompanionWidget(this.mView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.mConstraintWidget = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.mView);
        }
        return this.mConstraintWidget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void validate() throws IncorrectConstraintException {
        ArrayList arrayList = new ArrayList();
        if (this.mLeftToLeft != null && this.mLeftToRight != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.mRightToLeft != null && this.mRightToRight != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.mStartToStart != null && this.mStartToEnd != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.mEndToStart != null && this.mEndToEnd != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.mLeftToLeft != null || this.mLeftToRight != null || this.mRightToLeft != null || this.mRightToRight != null) && (this.mStartToStart != null || this.mStartToEnd != null || this.mEndToStart != null || this.mEndToEnd != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new IncorrectConstraintException(arrayList);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof ConstraintReference) ? this.mState.reference(obj) : obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference(State state) {
        this.mState = state;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getVerticalChainStyle(int i) {
        return this.mVerticalChainStyle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getHorizontalChainWeight() {
        return this.mHorizontalChainWeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHorizontalChainWeight(float f) {
        this.mHorizontalChainWeight = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getVerticalChainWeight() {
        return this.mVerticalChainWeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVerticalChainWeight(float f) {
        this.mVerticalChainWeight = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getTranslationX() {
        return this.mTranslationX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getTranslationY() {
        return this.mTranslationY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getScaleX() {
        return this.mScaleX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getScaleY() {
        return this.mScaleY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getAlpha() {
        return this.mAlpha;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getPivotX() {
        return this.mPivotX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getPivotY() {
        return this.mPivotY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getRotationX() {
        return this.mRotationX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getRotationY() {
        return this.mRotationY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getRotationZ() {
        return this.mRotationZ;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference pivotX(float f) {
        this.mPivotX = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference pivotY(float f) {
        this.mPivotY = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference rotationX(float f) {
        this.mRotationX = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference rotationY(float f) {
        this.mRotationY = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference rotationZ(float f) {
        this.mRotationZ = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference translationX(float f) {
        this.mTranslationX = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference translationY(float f) {
        this.mTranslationY = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference translationZ(float f) {
        this.mTranslationZ = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference scaleX(float f) {
        this.mScaleX = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference scaleY(float f) {
        this.mScaleY = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference alpha(float f) {
        this.mAlpha = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference visibility(int i) {
        this.mVisibility = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference left() {
        if (this.mLeftToLeft != null) {
            this.mLast = State.Constraint.LEFT_TO_LEFT;
        } else {
            this.mLast = State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference right() {
        if (this.mRightToLeft != null) {
            this.mLast = State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference start() {
        if (this.mStartToStart != null) {
            this.mLast = State.Constraint.START_TO_START;
        } else {
            this.mLast = State.Constraint.START_TO_END;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference end() {
        if (this.mEndToStart != null) {
            this.mLast = State.Constraint.END_TO_START;
        } else {
            this.mLast = State.Constraint.END_TO_END;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference top() {
        if (this.mTopToTop != null) {
            this.mLast = State.Constraint.TOP_TO_TOP;
        } else {
            this.mLast = State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference bottom() {
        if (this.mBottomToTop != null) {
            this.mLast = State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addCustomColor(String str, int i) {
        this.mCustomColors.put(str, Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addCustomFloat(String str, float f) {
        if (this.mCustomFloats == null) {
            this.mCustomFloats = new HashMap<>();
        }
        this.mCustomFloats.put(str, Float.valueOf(f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
        this.mBaselineToTop = get(this.mBaselineToTop);
        this.mBaselineToBottom = get(this.mBaselineToBottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference leftToLeft(Object obj) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference leftToRight(Object obj) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference rightToLeft(Object obj) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference rightToRight(Object obj) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference startToStart(Object obj) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference startToEnd(Object obj) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference endToStart(Object obj) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference endToEnd(Object obj) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference topToTop(Object obj) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference topToBottom(Object obj) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference bottomToTop(Object obj) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference bottomToBottom(Object obj) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference baselineToBaseline(Object obj) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference baselineToTop(Object obj) {
        this.mLast = State.Constraint.BASELINE_TO_TOP;
        this.mBaselineToTop = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference baselineToBottom(Object obj) {
        this.mLast = State.Constraint.BASELINE_TO_BOTTOM;
        this.mBaselineToBottom = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference centerHorizontally(Object obj) {
        Object obj2 = get(obj);
        this.mStartToStart = obj2;
        this.mEndToEnd = obj2;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference centerVertically(Object obj) {
        Object obj2 = get(obj);
        this.mTopToTop = obj2;
        this.mBottomToBottom = obj2;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference circularConstraint(Object obj, float f, float f2) {
        this.mCircularConstraint = get(obj);
        this.mCircularAngle = f;
        this.mCircularDistance = f2;
        this.mLast = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference setWidth(Dimension dimension) {
        this.mHorizontalDimension = dimension;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference setHeight(Dimension dimension) {
        this.mVerticalDimension = dimension;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference margin(Object obj) {
        return margin(this.mState.convertDimension(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference marginGone(Object obj) {
        return marginGone(this.mState.convertDimension(obj));
    }

    /* renamed from: androidx.constraintlayout.core.state.ConstraintReference$1 */
    static /* synthetic */ class C01731 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Constraint;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint = iArr;
            try {
                iArr[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_TOP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference margin(int i) {
        if (this.mLast != null) {
            switch (C01731.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeft = i;
                    break;
                case 3:
                case 4:
                    this.mMarginRight = i;
                    break;
                case 5:
                case 6:
                    this.mMarginStart = i;
                    break;
                case 7:
                case 8:
                    this.mMarginEnd = i;
                    break;
                case 9:
                case 10:
                    this.mMarginTop = i;
                    break;
                case 11:
                case 12:
                    this.mMarginBottom = i;
                    break;
                case 13:
                case 14:
                case 15:
                    this.mMarginBaseline = i;
                    this.mCircularDistance = i;
                    break;
                case 16:
                    this.mCircularDistance = i;
                    break;
            }
        } else {
            this.mMarginLeft = i;
            this.mMarginRight = i;
            this.mMarginStart = i;
            this.mMarginEnd = i;
            this.mMarginTop = i;
            this.mMarginBottom = i;
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference marginGone(int i) {
        if (this.mLast != null) {
            switch (C01731.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeftGone = i;
                    break;
                case 3:
                case 4:
                    this.mMarginRightGone = i;
                    break;
                case 5:
                case 6:
                    this.mMarginStartGone = i;
                    break;
                case 7:
                case 8:
                    this.mMarginEndGone = i;
                    break;
                case 9:
                case 10:
                    this.mMarginTopGone = i;
                    break;
                case 11:
                case 12:
                    this.mMarginBottomGone = i;
                    break;
                case 13:
                case 14:
                case 15:
                    this.mMarginBaselineGone = i;
                    break;
            }
        } else {
            this.mMarginLeftGone = i;
            this.mMarginRightGone = i;
            this.mMarginStartGone = i;
            this.mMarginEndGone = i;
            this.mMarginTopGone = i;
            this.mMarginBottomGone = i;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference horizontalBias(float f) {
        this.mHorizontalBias = f;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference verticalBias(float f) {
        this.mVerticalBias = f;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference bias(float f) {
        if (this.mLast == null) {
            return this;
        }
        int i = C01731.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()];
        if (i != 17) {
            if (i != 18) {
                switch (i) {
                }
            }
            this.mVerticalBias = f;
            return this;
        }
        this.mHorizontalBias = f;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstraintReference clear() {
        if (this.mLast != null) {
            switch (C01731.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[this.mLast.ordinal()]) {
                case 1:
                case 2:
                    this.mLeftToLeft = null;
                    this.mLeftToRight = null;
                    this.mMarginLeft = 0;
                    this.mMarginLeftGone = 0;
                    break;
                case 3:
                case 4:
                    this.mRightToLeft = null;
                    this.mRightToRight = null;
                    this.mMarginRight = 0;
                    this.mMarginRightGone = 0;
                    break;
                case 5:
                case 6:
                    this.mStartToStart = null;
                    this.mStartToEnd = null;
                    this.mMarginStart = 0;
                    this.mMarginStartGone = 0;
                    break;
                case 7:
                case 8:
                    this.mEndToStart = null;
                    this.mEndToEnd = null;
                    this.mMarginEnd = 0;
                    this.mMarginEndGone = 0;
                    break;
                case 9:
                case 10:
                    this.mTopToTop = null;
                    this.mTopToBottom = null;
                    this.mMarginTop = 0;
                    this.mMarginTopGone = 0;
                    break;
                case 11:
                case 12:
                    this.mBottomToTop = null;
                    this.mBottomToBottom = null;
                    this.mMarginBottom = 0;
                    this.mMarginBottomGone = 0;
                    break;
                case 15:
                    this.mBaselineToBaseline = null;
                    break;
                case 16:
                    this.mCircularConstraint = null;
                    break;
            }
        } else {
            this.mLeftToLeft = null;
            this.mLeftToRight = null;
            this.mMarginLeft = 0;
            this.mRightToLeft = null;
            this.mRightToRight = null;
            this.mMarginRight = 0;
            this.mStartToStart = null;
            this.mStartToEnd = null;
            this.mMarginStart = 0;
            this.mEndToStart = null;
            this.mEndToEnd = null;
            this.mMarginEnd = 0;
            this.mTopToTop = null;
            this.mTopToBottom = null;
            this.mMarginTop = 0;
            this.mBottomToTop = null;
            this.mBottomToBottom = null;
            this.mMarginBottom = 0;
            this.mBaselineToBaseline = null;
            this.mCircularConstraint = null;
            this.mHorizontalBias = 0.5f;
            this.mVerticalBias = 0.5f;
            this.mMarginLeftGone = 0;
            this.mMarginRightGone = 0;
            this.mMarginStartGone = 0;
            this.mMarginEndGone = 0;
            this.mMarginTopGone = 0;
            this.mMarginBottomGone = 0;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConstraintWidget getTarget(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).getConstraintWidget();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void applyConnection(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget target = getTarget(obj);
        if (target == null) {
        }
        int i = C01731.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[constraint.ordinal()];
        switch (C01731.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[constraint.ordinal()]) {
            case 1:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginLeft, this.mMarginLeftGone, false);
                break;
            case 2:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
                break;
            case 3:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
                break;
            case 4:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginRight, this.mMarginRightGone, false);
                break;
            case 5:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginStart, this.mMarginStartGone, false);
                break;
            case 6:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
                break;
            case 7:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
                break;
            case 8:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginEnd, this.mMarginEndGone, false);
                break;
            case 9:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginTop, this.mMarginTopGone, false);
                break;
            case 10:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
                break;
            case 11:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
                break;
            case 12:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginBottom, this.mMarginBottomGone, false);
                break;
            case 13:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, target, ConstraintAnchor.Type.BOTTOM, this.mMarginBaseline, this.mMarginBaselineGone);
                break;
            case 14:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, target, ConstraintAnchor.Type.TOP, this.mMarginBaseline, this.mMarginBaselineGone);
                break;
            case 15:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, target, ConstraintAnchor.Type.BASELINE, this.mMarginBaseline, this.mMarginBaselineGone);
                break;
            case 16:
                constraintWidget.connectCircularConstraint(target, this.mCircularAngle, (int) this.mCircularDistance);
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        if (this.mConstraintWidget == null) {
            return;
        }
        Facade facade = this.mFacade;
        if (facade != null) {
            facade.apply();
        }
        this.mHorizontalDimension.apply(this.mState, this.mConstraintWidget, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
        applyConnection(this.mConstraintWidget, this.mBaselineToTop, State.Constraint.BASELINE_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBaselineToBottom, State.Constraint.BASELINE_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mCircularConstraint, State.Constraint.CIRCULAR_CONSTRAINT);
        int i = this.mHorizontalChainStyle;
        if (i != 0) {
            this.mConstraintWidget.setHorizontalChainStyle(i);
        }
        int i2 = this.mVerticalChainStyle;
        if (i2 != 0) {
            this.mConstraintWidget.setVerticalChainStyle(i2);
        }
        float f = this.mHorizontalChainWeight;
        if (f != -1.0f) {
            this.mConstraintWidget.setHorizontalWeight(f);
        }
        float f2 = this.mVerticalChainWeight;
        if (f2 != -1.0f) {
            this.mConstraintWidget.setVerticalWeight(f2);
        }
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
        this.mConstraintWidget.frame.pivotX = this.mPivotX;
        this.mConstraintWidget.frame.pivotY = this.mPivotY;
        this.mConstraintWidget.frame.rotationX = this.mRotationX;
        this.mConstraintWidget.frame.rotationY = this.mRotationY;
        this.mConstraintWidget.frame.rotationZ = this.mRotationZ;
        this.mConstraintWidget.frame.translationX = this.mTranslationX;
        this.mConstraintWidget.frame.translationY = this.mTranslationY;
        this.mConstraintWidget.frame.translationZ = this.mTranslationZ;
        this.mConstraintWidget.frame.scaleX = this.mScaleX;
        this.mConstraintWidget.frame.scaleY = this.mScaleY;
        this.mConstraintWidget.frame.alpha = this.mAlpha;
        this.mConstraintWidget.frame.visibility = this.mVisibility;
        this.mConstraintWidget.setVisibility(this.mVisibility);
        HashMap<String, Integer> hashMap = this.mCustomColors;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.mConstraintWidget.frame.setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, this.mCustomColors.get(str).intValue());
            }
        }
        HashMap<String, Float> hashMap2 = this.mCustomFloats;
        if (hashMap2 != null) {
            for (String str2 : hashMap2.keySet()) {
                this.mConstraintWidget.frame.setCustomAttribute(str2, TypedValues.Custom.TYPE_FLOAT, this.mCustomFloats.get(str2).floatValue());
            }
        }
    }
}
