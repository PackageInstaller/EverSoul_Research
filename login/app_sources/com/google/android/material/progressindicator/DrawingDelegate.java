package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* loaded from: classes2.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    abstract void adjustCanvas(Canvas canvas, float f);

    abstract void fillIndicator(Canvas canvas, Paint paint, float f, float f2, int i);

    abstract void fillTrack(Canvas canvas, Paint paint);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawingDelegate(S s) {
        this.spec = s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void registerDrawable(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        this.drawable = drawableWithAnimatedVisibilityChange;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void validateSpecAndAdjustCanvas(Canvas canvas, float f) {
        this.spec.validateSpec();
        adjustCanvas(canvas, f);
    }
}
