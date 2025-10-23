package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class OnSwipe {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    public static final int DRAG_ANTICLOCKWISE = 7;
    public static final int DRAG_CLOCKWISE = 6;
    public static final int DRAG_DOWN = 1;
    public static final int DRAG_END = 5;
    public static final int DRAG_LEFT = 2;
    public static final int DRAG_RIGHT = 3;
    public static final int DRAG_START = 4;
    public static final int DRAG_UP = 0;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int ON_UP_AUTOCOMPLETE = 0;
    public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
    public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
    public static final int ON_UP_DECELERATE = 4;
    public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int ON_UP_NEVER_TO_END = 7;
    public static final int ON_UP_NEVER_TO_START = 6;
    public static final int ON_UP_STOP = 3;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final int SPRING_BOUNDARY_BOUNCEBOTH = 3;
    public static final int SPRING_BOUNDARY_BOUNCEEND = 2;
    public static final int SPRING_BOUNDARY_BOUNCESTART = 1;
    public static final int SPRING_BOUNDARY_OVERSHOOT = 0;
    private int mDragDirection = 0;
    private int mTouchAnchorSide = 0;
    private int mTouchAnchorId = -1;
    private int mTouchRegionId = -1;
    private int mLimitBoundsTo = -1;
    private int mOnTouchUp = 0;
    private int mRotationCenterId = -1;
    private float mMaxVelocity = 4.0f;
    private float mMaxAcceleration = 1.2f;
    private boolean mMoveWhenScrollAtTop = true;
    private float mDragScale = 1.0f;
    private int mFlags = 0;
    private float mDragThreshold = 10.0f;
    private float mSpringDamping = Float.NaN;
    private float mSpringMass = 1.0f;
    private float mSpringStiffness = Float.NaN;
    private float mSpringStopThreshold = Float.NaN;
    private int mSpringBoundary = 0;
    private int mAutoCompleteMode = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setTouchAnchorId(int side) {
        this.mTouchAnchorId = side;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTouchAnchorId() {
        return this.mTouchAnchorId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setTouchAnchorSide(int side) {
        this.mTouchAnchorSide = side;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTouchAnchorSide() {
        return this.mTouchAnchorSide;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setDragDirection(int dragDirection) {
        this.mDragDirection = dragDirection;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDragDirection() {
        return this.mDragDirection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setMaxVelocity(int maxVelocity) {
        this.mMaxVelocity = maxVelocity;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setMaxAcceleration(int maxAcceleration) {
        this.mMaxAcceleration = maxAcceleration;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setMoveWhenScrollAtTop(boolean moveWhenScrollAtTop) {
        this.mMoveWhenScrollAtTop = moveWhenScrollAtTop;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setDragScale(int dragScale) {
        this.mDragScale = dragScale;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getDragScale() {
        return this.mDragScale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setDragThreshold(int dragThreshold) {
        this.mDragThreshold = dragThreshold;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getDragThreshold() {
        return this.mDragThreshold;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setTouchRegionId(int side) {
        this.mTouchRegionId = side;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setOnTouchUp(int mode) {
        this.mOnTouchUp = mode;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getOnTouchUp() {
        return this.mOnTouchUp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setNestedScrollFlags(int flags) {
        this.mFlags = flags;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getNestedScrollFlags() {
        return this.mFlags;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setLimitBoundsTo(int id) {
        this.mLimitBoundsTo = id;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLimitBoundsTo() {
        return this.mLimitBoundsTo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setRotateCenter(int rotationCenterId) {
        this.mRotationCenterId = rotationCenterId;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRotationCenterId() {
        return this.mRotationCenterId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setSpringDamping(float springDamping) {
        this.mSpringDamping = springDamping;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getSpringMass() {
        return this.mSpringMass;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setSpringMass(float springMass) {
        this.mSpringMass = springMass;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setSpringStiffness(float springStiffness) {
        this.mSpringStiffness = springStiffness;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setSpringStopThreshold(float springStopThreshold) {
        this.mSpringStopThreshold = springStopThreshold;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnSwipe setSpringBoundary(int springBoundary) {
        this.mSpringBoundary = springBoundary;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAutoCompleteMode(int autoCompleteMode) {
        this.mAutoCompleteMode = autoCompleteMode;
    }
}
