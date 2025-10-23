package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.C0903R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = C0903R.style.Widget_MaterialComponents_CircularProgressIndicator;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0903R.attr.circularProgressIndicatorStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, DEF_STYLE_RES);
        initializeDrawables();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public CircularProgressIndicatorSpec createSpec(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIndicatorInset(int i) {
        if (((CircularProgressIndicatorSpec) this.spec).indicatorInset != i) {
            ((CircularProgressIndicatorSpec) this.spec).indicatorInset = i;
            invalidate();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIndicatorSize(int i) {
        int max = Math.max(i, getTrackThickness() * 2);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorSize != max) {
            ((CircularProgressIndicatorSpec) this.spec).indicatorSize = max;
            ((CircularProgressIndicatorSpec) this.spec).validateSpec();
            invalidate();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIndicatorDirection(int i) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = i;
        invalidate();
    }
}
