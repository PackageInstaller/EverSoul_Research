package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.C0903R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private int animState;
    private boolean animateShowBeforeLayout;
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;
    private final MotionStrategy extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;
    protected ColorStateList originalTextCsl;
    private final MotionStrategy showStrategy;
    private final MotionStrategy shrinkStrategy;
    private static final int DEF_STYLE_RES = C0903R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> WIDTH = new Property<View, Float>(Float.class, ViewHierarchyConstants.DIMENSION_WIDTH_KEY) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public void set(View view, Float f) {
            view.getLayoutParams().width = f.intValue();
            view.requestLayout();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }
    };
    static final Property<View, Float> HEIGHT = new Property<View, Float>(Float.class, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public void set(View view, Float f) {
            view.getLayoutParams().height = f.intValue();
            view.requestLayout();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }
    };
    static final Property<View, Float> PADDING_START = new Property<View, Float>(Float.class, "paddingStart") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.6
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public void set(View view, Float f) {
            ViewCompat.setPaddingRelative(view, f.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }
    };
    static final Property<View, Float> PADDING_END = new Property<View, Float>(Float.class, "paddingEnd") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.7
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public void set(View view, Float f) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }
    };

    public static abstract class OnChangedCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    interface Size {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0903R.attr.extendedFloatingActionButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExtendedFloatingActionButton(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.DEF_STYLE_RES
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.animState = r10
            com.google.android.material.floatingactionbutton.AnimatorTracker r1 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r1.<init>()
            r0.changeVisibilityTracker = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy
            r11.<init>(r1)
            r0.showStrategy = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy
            r12.<init>(r1)
            r0.hideStrategy = r12
            r13 = 1
            r0.isExtended = r13
            r0.isTransforming = r10
            r0.animateShowBeforeLayout = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.behavior = r1
            int[] r3 = com.google.android.material.C0903R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.C0903R.styleable.ExtendedFloatingActionButton_showMotionSpec
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r2)
            int r3 = com.google.android.material.C0903R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            com.google.android.material.animation.MotionSpec r3 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r3)
            int r4 = com.google.android.material.C0903R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            com.google.android.material.animation.MotionSpec r4 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r4)
            int r5 = com.google.android.material.C0903R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r5)
            int r6 = com.google.android.material.C0903R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.collapsedSize = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.extendedPaddingStart = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.extendedPaddingEnd = r6
            com.google.android.material.floatingactionbutton.AnimatorTracker r6 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1 r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.extendStrategy = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2 r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.shrinkStrategy = r10
            r11.setMotionSpec(r2)
            r12.setMotionSpec(r3)
            r15.setMotionSpec(r4)
            r10.setMotionSpec(r5)
            r1.recycle()
            com.google.android.material.shape.CornerSize r1 = com.google.android.material.shape.ShapeAppearanceModel.PILL
            r2 = r18
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.builder(r14, r2, r8, r9, r1)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.build()
            r0.setShapeAppearanceModel(r1)
            r16.saveOriginalTextCsl()
            return
            fill-array 0x00b6: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        saveOriginalTextCsl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void silentlyUpdateTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.performNow();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExtended(boolean z) {
        if (this.isExtended == z) {
            return;
        }
        MotionStrategy motionStrategy = z ? this.extendStrategy : this.shrinkStrategy;
        if (motionStrategy.shouldCancel()) {
            return;
        }
        motionStrategy.performNow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isExtended() {
        return this.isExtended;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAnimateShowBeforeLayout(boolean z) {
        this.animateShowBeforeLayout = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = i;
        this.extendedPaddingEnd = i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.showStrategy.addAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.showStrategy.removeAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.hideStrategy.addAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.hideStrategy.removeAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOnShrinkAnimationListener(Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.addAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeOnShrinkAnimationListener(Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.removeAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOnExtendAnimationListener(Animator.AnimatorListener animatorListener) {
        this.extendStrategy.addAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeOnExtendAnimationListener(Animator.AnimatorListener animatorListener) {
        this.extendStrategy.removeAnimationListener(animatorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void hide(OnChangedCallback onChangedCallback) {
        performMotion(this.hideStrategy, onChangedCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void show() {
        performMotion(this.showStrategy, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void show(OnChangedCallback onChangedCallback) {
        performMotion(this.showStrategy, onChangedCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void extend(OnChangedCallback onChangedCallback) {
        performMotion(this.extendStrategy, onChangedCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void shrink(OnChangedCallback onChangedCallback) {
        performMotion(this.shrinkStrategy, onChangedCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.showStrategy.setMotionSpec(motionSpec);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideStrategy.setMotionSpec(motionSpec);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExtendMotionSpec(MotionSpec motionSpec) {
        this.extendStrategy.setMotionSpec(motionSpec);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        this.shrinkStrategy.setMotionSpec(motionSpec);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void performMotion(final MotionStrategy motionStrategy, final OnChangedCallback onChangedCallback) {
        if (motionStrategy.shouldCancel()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            motionStrategy.performNow();
            motionStrategy.onChange(onChangedCallback);
            return;
        }
        measure(0, 0);
        AnimatorSet createAnimator = motionStrategy.createAnimator();
        createAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3
            private boolean cancelled;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                motionStrategy.onAnimationStart(animator);
                this.cancelled = false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.cancelled = true;
                motionStrategy.onAnimationCancel();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                motionStrategy.onAnimationEnd();
                if (this.cancelled) {
                    return;
                }
                motionStrategy.onChange(onChangedCallback);
            }
        });
        Iterator<Animator.AnimatorListener> it = motionStrategy.getListeners().iterator();
        while (it.hasNext()) {
            createAnimator.addListener(it.next());
        }
        createAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isOrWillBeShown() {
        return getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isOrWillBeHidden() {
        return getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean shouldAnimateVisibilityChange() {
        return (ViewCompat.isLaidOut(this) || (!isOrWillBeShown() && this.animateShowBeforeLayout)) && !isInEditMode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCollapsedSize() {
        int i = this.collapsedSize;
        return i < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;
        private OnChangedCallback internalAutoHideCallback;
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0903R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(C0903R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(C0903R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAutoHideEnabled(boolean z) {
            this.autoHideEnabled = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAutoShrinkEnabled(boolean z) {
            this.autoShrinkEnabled = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static boolean isBottomSheet(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setInternalAutoHideCallback(OnChangedCallback onChangedCallback) {
            this.internalAutoHideCallback = onChangedCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setInternalAutoShrinkCallback(OnChangedCallback onChangedCallback) {
            this.internalAutoShrinkCallback = onChangedCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean shouldUpdateVisibility(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.autoHideEnabled || this.autoShrinkEnabled) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean updateFabVisibilityForBottomSheet(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void shrinkOrHide(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.autoShrinkEnabled;
            extendedFloatingActionButton.performMotion(z ? extendedFloatingActionButton.shrinkStrategy : extendedFloatingActionButton.hideStrategy, z ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void extendOrShow(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.autoShrinkEnabled;
            extendedFloatingActionButton.performMotion(z ? extendedFloatingActionButton.extendStrategy : extendedFloatingActionButton.showStrategy, z ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (view instanceof AppBarLayout) {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }
    }

    class ChangeSizeStrategy extends BaseMotionStrategy {
        private final boolean extending;
        private final Size size;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size, boolean z) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.size = size;
            this.extending = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.this.isExtended = this.extending;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.size.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.size.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.extending) {
                onChangedCallback.onExtended(ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.onShrunken(ExtendedFloatingActionButton.this);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return this.extending ? C0903R.animator.mtrl_extended_fab_change_size_expand_motion_spec : C0903R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public AnimatorSet createAnimator() {
            MotionSpec currentMotionSpec = getCurrentMotionSpec();
            if (currentMotionSpec.hasPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                PropertyValuesHolder[] propertyValues = currentMotionSpec.getPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                propertyValues[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.size.getWidth());
                currentMotionSpec.setPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, propertyValues);
            }
            if (currentMotionSpec.hasPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                PropertyValuesHolder[] propertyValues2 = currentMotionSpec.getPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                propertyValues2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.size.getHeight());
                currentMotionSpec.setPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, propertyValues2);
            }
            if (currentMotionSpec.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = currentMotionSpec.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.size.getPaddingStart());
                currentMotionSpec.setPropertyValues("paddingStart", propertyValues3);
            }
            if (currentMotionSpec.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = currentMotionSpec.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.size.getPaddingEnd());
                currentMotionSpec.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (currentMotionSpec.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = currentMotionSpec.getPropertyValues("labelOpacity");
                boolean z = this.extending;
                propertyValues5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                currentMotionSpec.setPropertyValues("labelOpacity", propertyValues5);
            }
            return super.createAnimator(currentMotionSpec);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.isExtended = this.extending;
            ExtendedFloatingActionButton.this.isTransforming = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.isTransforming = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return this.extending == ExtendedFloatingActionButton.this.isExtended || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }
    }

    class ShowStrategy extends BaseMotionStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(ExtendedFloatingActionButton.this);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return C0903R.animator.mtrl_extended_fab_show_motion_spec;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.this.isOrWillBeShown();
        }
    }

    class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.this.isOrWillBeHidden();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return C0903R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.isCancelled = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
            if (this.isCancelled) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }
    }
}
