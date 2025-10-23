package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
class NoEndIconDelegate extends EndIconDelegate {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NoEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconDrawable((Drawable) null);
        this.textInputLayout.setEndIconContentDescription((CharSequence) null);
    }
}
