package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;
    private boolean verticalOffsetEnabled = true;
    private boolean horizontalOffsetEnabled = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void applyOffsets() {
        View view = this.view;
        ViewCompat.offsetTopAndBottom(view, this.offsetTop - (view.getTop() - this.layoutTop));
        View view2 = this.view;
        ViewCompat.offsetLeftAndRight(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setTopAndBottomOffset(int i) {
        if (!this.verticalOffsetEnabled || this.offsetTop == i) {
            return false;
        }
        this.offsetTop = i;
        applyOffsets();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setLeftAndRightOffset(int i) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == i) {
            return false;
        }
        this.offsetLeft = i;
        applyOffsets();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLayoutTop() {
        return this.layoutTop;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVerticalOffsetEnabled(boolean z) {
        this.verticalOffsetEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHorizontalOffsetEnabled(boolean z) {
        this.horizontalOffsetEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }
}
