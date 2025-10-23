package androidx.core.os;

import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OperationCanceledException() {
        this(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OperationCanceledException(String str) {
        super(ObjectsCompat.toString(str, "The operation has been canceled."));
    }
}
