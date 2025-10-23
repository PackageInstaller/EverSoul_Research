package org.apache.commons.lang3.exception;

/* loaded from: classes2.dex */
public class CloneFailedException extends RuntimeException {
    private static final long serialVersionUID = 20091223;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CloneFailedException(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CloneFailedException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CloneFailedException(String str, Throwable th) {
        super(str, th);
    }
}
