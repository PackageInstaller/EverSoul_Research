package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory = NoTransition.getFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CHILD self() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CHILD dontTransition() {
        return transition(NoTransition.getFactory());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CHILD transition(int i) {
        return transition(new ViewAnimationFactory(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CHILD transition(ViewPropertyTransition.Animator animator) {
        return transition(new ViewPropertyAnimationFactory(animator));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CHILD transition(TransitionFactory<? super TranscodeType> transitionFactory) {
        this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(transitionFactory);
        return self();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m931clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }
}
