package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTypes() {
        return this.mImpl.getTypes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInsetsAndAlpha(Insets insets, float f, float f2) {
        this.mImpl.setInsetsAndAlpha(insets, f, f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void finish(boolean z) {
        this.mImpl.finish(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    private static class Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void finish(boolean z) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getCurrentAlpha() {
            return 0.0f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getCurrentFraction() {
            return 0.0f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getTypes() {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isCancelled() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isFinished() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setInsetsAndAlpha(Insets insets, float f, float f2) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Insets getCurrentInsets() {
            return Insets.NONE;
        }
    }

    private static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public int getTypes() {
            return this.mController.getTypes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(Insets insets, float f, float f2) {
            this.mController.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        void finish(boolean z) {
            this.mController.finish(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        boolean isFinished() {
            return this.mController.isFinished();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        boolean isCancelled() {
            return this.mController.isCancelled();
        }
    }
}
