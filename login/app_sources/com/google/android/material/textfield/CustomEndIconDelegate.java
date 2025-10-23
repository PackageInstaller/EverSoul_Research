package com.google.android.material.textfield;

/* loaded from: classes2.dex */
class CustomEndIconDelegate extends EndIconDelegate {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CustomEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconDrawable(this.customEndIcon);
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
