package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* loaded from: classes2.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    abstract void cancelAnimatorImmediately();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected float getFractionInRange(int i, int i2, int i3) {
        return (i - i2) / i3;
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(Animatable2Compat.AnimationCallback animationCallback);

    abstract void requestCancelAnimatorAfterCurrentCycle();

    abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected IndeterminateAnimatorDelegate(int i) {
        this.segmentPositions = new float[i * 2];
        this.segmentColors = new int[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void registerDrawable(IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }
}
