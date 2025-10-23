package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C0903R;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes2.dex */
public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = C0903R.style.Widget_MaterialComponents_MaterialDivider;
    private int color;
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialDivider(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0903R.attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialDivider(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.divider.MaterialDivider.DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            r7.dividerDrawable = r0
            int[] r2 = com.google.android.material.C0903R.styleable.MaterialDivider
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.C0903R.styleable.MaterialDivider_dividerThickness
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.C0903R.dimen.material_divider_thickness
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.thickness = r10
            int r10 = com.google.android.material.C0903R.styleable.MaterialDivider_dividerInsetStart
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.insetStart = r10
            int r10 = com.google.android.material.C0903R.styleable.MaterialDivider_dividerInsetEnd
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.insetEnd = r10
            int r10 = com.google.android.material.C0903R.styleable.MaterialDivider_dividerColor
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r9, r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
            fill-array 0x0054: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.thickness;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int i2 = z ? this.insetEnd : this.insetStart;
        if (z) {
            width = getWidth();
            i = this.insetStart;
        } else {
            width = getWidth();
            i = this.insetEnd;
        }
        this.dividerDrawable.setBounds(i2, 0, width - i, getBottom() - getTop());
        this.dividerDrawable.draw(canvas);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerThickness(int i) {
        if (this.thickness != i) {
            this.thickness = i;
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerThickness() {
        return this.thickness;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetStart(int i) {
        this.insetStart = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetEnd(int i) {
        this.insetEnd = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerColor(int i) {
        if (this.color != i) {
            this.color = i;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerColorResource(int i) {
        setDividerColor(ContextCompat.getColor(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerColor() {
        return this.color;
    }
}
