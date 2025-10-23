package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes5.dex */
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    WindowIdApi18(View view) {
        this.mWindowId = view.getWindowId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).mWindowId.equals(this.mWindowId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}
