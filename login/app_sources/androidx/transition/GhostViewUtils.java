package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes5.dex */
class GhostViewUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return GhostViewPlatform.addGhost(view, viewGroup, matrix);
        }
        return GhostViewPort.addGhost(view, viewGroup, matrix);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void removeGhost(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.removeGhost(view);
        } else {
            GhostViewPort.removeGhost(view);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GhostViewUtils() {
    }
}
