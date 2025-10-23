package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
/* loaded from: classes.dex */
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        startAnimation(true);
        super.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        startAnimation(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startAnimation(final boolean z) {
        float f = z ? 0.0f : 1.0f;
        float f2 = z ? 1.0f : 0.0f;
        long j = z ? ENTER_ANIMATION_DURATION_MS : 150L;
        this.mContentView.setScaleX(f);
        this.mContentView.setScaleY(f);
        this.mContentView.animate().scaleX(f2).scaleY(f2).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuDialog.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                BrowserActionsFallbackMenuDialog.super.dismiss();
            }
        }).start();
    }
}
