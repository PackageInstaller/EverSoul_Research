package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* loaded from: classes2.dex */
class AnimatorTracker {
    private Animator currentAnimator;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AnimatorTracker() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onNextAnimationStart(Animator animator) {
        cancelCurrent();
        this.currentAnimator = animator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelCurrent() {
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        this.currentAnimator = null;
    }
}
