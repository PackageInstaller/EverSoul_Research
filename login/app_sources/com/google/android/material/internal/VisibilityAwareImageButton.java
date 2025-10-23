package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: classes2.dex */
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.userSetVisibility = getVisibility();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        internalSetVisibility(i, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void internalSetVisibility(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.userSetVisibility = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }
}
