package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {
    void clearAnimationCallbacks();

    void registerAnimationCallback(AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(AnimationCallback animationCallback);

    public static abstract class AnimationCallback {
        Animatable2.AnimationCallback mPlatformCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onAnimationEnd(Drawable drawable) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onAnimationStart(Drawable drawable) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new Animatable2.AnimationCallback() { // from class: androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationStart(Drawable drawable) {
                        AnimationCallback.this.onAnimationStart(drawable);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationEnd(Drawable drawable) {
                        AnimationCallback.this.onAnimationEnd(drawable);
                    }
                };
            }
            return this.mPlatformCallback;
        }
    }
}
