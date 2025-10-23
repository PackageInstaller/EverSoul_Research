package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    private final WeakReference<View> mView;
    Runnable mStartAction = null;
    Runnable mEndAction = null;
    int mOldLayerType = -1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.mVpa = viewPropertyAnimatorCompat;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            this.mAnimEndCalled = false;
            if (this.mVpa.mOldLayerType > -1) {
                view.setLayerType(2, null);
            }
            if (this.mVpa.mStartAction != null) {
                Runnable runnable = this.mVpa.mStartAction;
                this.mVpa.mStartAction = null;
                runnable.run();
            }
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (this.mVpa.mOldLayerType > -1) {
                view.setLayerType(this.mVpa.mOldLayerType, null);
                this.mVpa.mOldLayerType = -1;
            }
            if (this.mVpa.mEndAction != null) {
                Runnable runnable = this.mVpa.mEndAction;
                this.mVpa.mEndAction = null;
                runnable.run();
            }
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.mAnimEndCalled = true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.withEndAction(view.animate(), runnable);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return Api18Impl.getInterpolator(view.animate());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: x */
    public ViewPropertyAnimatorCompat m38x(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: y */
    public ViewPropertyAnimatorCompat m39y(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZBy(view.animate(), f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZ(view.animate(), f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: z */
    public ViewPropertyAnimatorCompat m40z(float f) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.m41z(view.animate(), f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.zBy(view.animate(), f);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.withLayer(view.animate());
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.withStartAction(view.animate(), runnable);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.mView.get();
        if (view != null) {
            Api19Impl.setUpdateListener(view.animate(), viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewPropertyAnimatorUpdateListener.this.onAnimationUpdate(view);
                }
            } : null);
        }
        return this;
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator withEndAction(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator withLayer(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator withStartAction(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    static class Api18Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api18Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Interpolator getInterpolator(ViewPropertyAnimator viewPropertyAnimator) {
            return (Interpolator) viewPropertyAnimator.getInterpolator();
        }
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float f) {
            return viewPropertyAnimator.translationZBy(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float f) {
            return viewPropertyAnimator.translationZ(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: z */
        static ViewPropertyAnimator m41z(ViewPropertyAnimator viewPropertyAnimator, float f) {
            return viewPropertyAnimator.z(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float f) {
            return viewPropertyAnimator.zBy(f);
        }
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }
}
