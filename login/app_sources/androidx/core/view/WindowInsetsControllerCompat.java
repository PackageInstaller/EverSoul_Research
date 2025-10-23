package androidx.core.view;

import android.R;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.WindowInsetsControllerCompat;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat windowInsetsControllerCompat, int i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController, this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WindowInsetsControllerCompat(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(window, this);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new Impl26(window, view);
        } else {
            this.mImpl = new Impl23(window, view);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void show(int i) {
        this.mImpl.show(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void hide(int i) {
        this.mImpl.hide(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAppearanceLightStatusBars(boolean z) {
        this.mImpl.setAppearanceLightStatusBars(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAppearanceLightNavigationBars(boolean z) {
        this.mImpl.setAppearanceLightNavigationBars(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void controlWindowInsetsAnimation(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSystemBarsBehavior(int i) {
        this.mImpl.setSystemBarsBehavior(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    private static class Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void controlWindowInsetsAnimation(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getSystemBarsBehavior() {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void hide(int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAppearanceLightNavigationBars(boolean z) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAppearanceLightStatusBars(boolean z) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setSystemBarsBehavior(int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void show(int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Impl20 extends Impl {
        private final View mView;
        protected final Window mWindow;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl20(Window window, View view) {
            this.mWindow = window;
            this.mView = view;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    showForType(i2);
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void showForType(int i) {
            if (i == 1) {
                unsetSystemUiFlag(4);
                unsetWindowFlag(1024);
                return;
            }
            if (i == 2) {
                unsetSystemUiFlag(2);
                return;
            }
            if (i != 8) {
                return;
            }
            final View view = this.mView;
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = this.mWindow.getCurrentFocus();
            }
            if (view == null) {
                view = this.mWindow.findViewById(R.id.content);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            view.post(new Runnable() { // from class: androidx.core.view.WindowInsetsControllerCompat$Impl20$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    ((InputMethodManager) r0.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            });
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    hideForType(i2);
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void hideForType(int i) {
            if (i == 1) {
                setSystemUiFlag(4);
            } else if (i == 2) {
                setSystemUiFlag(2);
            } else {
                if (i != 8) {
                    return;
                }
                ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void setSystemUiFlag(int i) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void unsetSystemUiFlag(int i) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void setWindowFlag(int i) {
            this.mWindow.addFlags(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void unsetWindowFlag(int i) {
            this.mWindow.clearFlags(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i) {
            if (i == 0) {
                unsetSystemUiFlag(6144);
                return;
            }
            if (i == 1) {
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
            } else {
                if (i != 2) {
                    return;
                }
                unsetSystemUiFlag(2048);
                setSystemUiFlag(4096);
            }
        }
    }

    private static class Impl23 extends Impl20 {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl23(Window window, View view) {
            super(window, view);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if (z) {
                unsetWindowFlag(67108864);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(8192);
                return;
            }
            unsetSystemUiFlag(8192);
        }
    }

    private static class Impl26 extends Impl23 {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl26(Window window, View view) {
            super(window, view);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if (z) {
                unsetWindowFlag(134217728);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(16);
                return;
            }
            unsetSystemUiFlag(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        protected Window mWindow;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat);
            this.mWindow = window;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i) {
            if (this.mWindow != null && (i & 8) != 0 && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).isActive();
            }
            this.mInsetsController.show(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i) {
            this.mInsetsController.hide(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mInsetsController.getSystemBarsAppearance() & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if (z) {
                if (this.mWindow != null) {
                    setSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mInsetsController.getSystemBarsAppearance() & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if (z) {
                if (this.mWindow != null) {
                    setSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.mInsetsController.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.1
                private WindowInsetsAnimationControllerCompat mCompatAnimController = null;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.WindowInsetsAnimationControlListener
                public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i2) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.mCompatAnimController = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.onReady(windowInsetsAnimationControllerCompat, i2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.WindowInsetsAnimationControlListener
                public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.mCompatAnimController);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.WindowInsetsAnimationControlListener
                public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationController == null ? null : this.mCompatAnimController);
                }
            });
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i) {
            this.mInsetsController.setSystemBarsBehavior(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
                    WindowInsetsControllerCompat.Impl30.this.m42xe96d8c51(onControllableInsetsChangedListener, windowInsetsController, i);
                }
            };
            this.mListeners.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.mInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30 */
        /* synthetic */ void m42xe96d8c51(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i) {
            if (this.mInsetsController == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.mCompatController, i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener remove = this.mListeners.remove(onControllableInsetsChangedListener);
            if (remove != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(remove);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void unsetSystemUiFlag(int i) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void setSystemUiFlag(int i) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }
    }
}
