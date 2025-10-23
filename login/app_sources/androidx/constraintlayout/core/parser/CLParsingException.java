package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CLParsingException(String str, CLElement cLElement) {
        this.mReason = str;
        if (cLElement != null) {
            this.mElementClass = cLElement.getStrClass();
            this.mLineNumber = cLElement.getLine();
        } else {
            this.mElementClass = "unknown";
            this.mLineNumber = 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
