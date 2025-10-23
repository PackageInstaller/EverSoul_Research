package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders = new ArrayList();
    private final P primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getDurationThemeAttrResId(boolean z) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getEasingThemeAttrResId(boolean z) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected MaterialVisibility(P p, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z);
        Iterator<VisibilityAnimatorProvider> it = this.additionalAnimatorProviders.iterator();
        while (it.hasNext()) {
            addAnimatorIfNeeded(arrayList, it.next(), viewGroup, view, z);
        }
        maybeApplyThemeValues(viewGroup.getContext(), z);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void addAnimatorIfNeeded(List<Animator> list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        Animator createDisappear;
        if (visibilityAnimatorProvider == null) {
            return;
        }
        if (z) {
            createDisappear = visibilityAnimatorProvider.createAppear(viewGroup, view);
        } else {
            createDisappear = visibilityAnimatorProvider.createDisappear(viewGroup, view);
        }
        if (createDisappear != null) {
            list.add(createDisappear);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void maybeApplyThemeValues(Context context, boolean z) {
        TransitionUtils.maybeApplyThemeDuration(this, context, getDurationThemeAttrResId(z));
        TransitionUtils.maybeApplyThemeInterpolator(this, context, getEasingThemeAttrResId(z), getDefaultEasingInterpolator(z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TimeInterpolator getDefaultEasingInterpolator(boolean z) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }
}
