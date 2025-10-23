package org.apache.commons.lang3;

/* loaded from: classes2.dex */
public class NotImplementedException extends UnsupportedOperationException {
    private static final long serialVersionUID = 20131021;
    private final String code;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotImplementedException(String str) {
        this(str, (String) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotImplementedException(Throwable th) {
        this(th, (String) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotImplementedException(String str, Throwable th) {
        this(str, th, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotImplementedException(String str, String str2) {
        super(str);
        this.code = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotImplementedException(Throwable th, String str) {
        super(th);
        this.code = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotImplementedException(String str, Throwable th, String str2) {
        super(str, th);
        this.code = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getCode() {
        return this.code;
    }
}
