package com.bumptech.glide;

import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* loaded from: classes.dex */
public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new GenericTransitionOptions().dontTransition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int i) {
        return new GenericTransitionOptions().transition(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator animator) {
        return new GenericTransitionOptions().transition(animator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(TransitionFactory<? super TranscodeType> transitionFactory) {
        return new GenericTransitionOptions().transition(transitionFactory);
    }
}
