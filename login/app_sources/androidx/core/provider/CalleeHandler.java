package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
class CalleeHandler {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CalleeHandler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Handler create() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
