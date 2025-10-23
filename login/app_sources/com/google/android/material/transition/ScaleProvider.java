package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScaleProvider() {
        this(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScaleProvider(boolean z) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isGrowing() {
        return this.growing;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGrowing(boolean z) {
        this.growing = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setScaleOnDisappear(boolean z) {
        this.scaleOnDisappear = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOutgoingStartScale(float f) {
        this.outgoingStartScale = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOutgoingEndScale(float f) {
        this.outgoingEndScale = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIncomingStartScale(float f) {
        this.incomingStartScale = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIncomingEndScale(float f) {
        this.incomingEndScale = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view) {
        if (this.growing) {
            return createScaleAnimator(view, this.incomingStartScale, this.incomingEndScale);
        }
        return createScaleAnimator(view, this.outgoingEndScale, this.outgoingStartScale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view) {
        if (!this.scaleOnDisappear) {
            return null;
        }
        if (this.growing) {
            return createScaleAnimator(view, this.outgoingStartScale, this.outgoingEndScale);
        }
        return createScaleAnimator(view, this.incomingEndScale, this.incomingStartScale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Animator createScaleAnimator(final View view, float f, float f2) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f, scaleX * f2), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f * scaleY, f2 * scaleY));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.ScaleProvider.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
            }
        });
        return ofPropertyValuesHolder;
    }
}
