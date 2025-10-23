package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes5.dex */
class AnimatorUtils {

    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void addPauseListener(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void pause(Animator animator) {
        animator.pause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void resume(Animator animator) {
        animator.resume();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AnimatorUtils() {
    }
}
