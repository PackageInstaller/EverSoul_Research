package androidx.constraintlayout.motion.utils;

import android.view.View;

/* loaded from: classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getState(View v) {
        this.left = v.getLeft();
        this.top = v.getTop();
        this.right = v.getRight();
        this.bottom = v.getBottom();
        this.rotation = v.getRotation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int width() {
        return this.right - this.left;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int height() {
        return this.bottom - this.top;
    }
}
