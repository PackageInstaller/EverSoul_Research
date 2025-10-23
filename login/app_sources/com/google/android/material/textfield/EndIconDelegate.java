package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes2.dex */
abstract class EndIconDelegate {
    Context context;
    final int customEndIcon;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    abstract void initialize();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void onSuffixVisibilityChanged(boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean shouldTintIconOnError() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EndIconDelegate(TextInputLayout textInputLayout, int i) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
        this.customEndIcon = i;
    }
}
