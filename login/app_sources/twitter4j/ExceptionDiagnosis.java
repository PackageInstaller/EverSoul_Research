package twitter4j;

import com.liapp.y;
import java.io.Serializable;

/* loaded from: classes4.dex */
final class ExceptionDiagnosis implements Serializable {
    private static final long serialVersionUID = 8501009773274399369L;
    private String hexString;
    private int lineNumberHash;
    private int stackLineHash;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExceptionDiagnosis(Throwable th) {
        this(th, new String[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExceptionDiagnosis(Throwable th, String[] strArr) {
        this.hexString = "";
        StackTraceElement[] stackTrace = th.getStackTrace();
        this.stackLineHash = 0;
        this.lineNumberHash = 0;
        for (int length = stackTrace.length - 1; length >= 0; length--) {
            StackTraceElement stackTraceElement = stackTrace[length];
            int length2 = strArr.length;
            int i = 0;
            while (true) {
                if (i < length2) {
                    if (stackTraceElement.getClassName().startsWith(strArr[i])) {
                        this.stackLineHash = (this.stackLineHash * 31) + stackTraceElement.getClassName().hashCode() + stackTraceElement.getMethodName().hashCode();
                        this.lineNumberHash = (this.lineNumberHash * 31) + stackTraceElement.getLineNumber();
                        break;
                    }
                    i++;
                }
            }
        }
        this.hexString += toHexString(this.stackLineHash) + y.ٴسسݬߨ(1392558282) + toHexString(this.lineNumberHash);
        if (th.getCause() != null) {
            this.hexString += y.دײܮڳܯ(2051829469) + new ExceptionDiagnosis(th.getCause(), strArr).asHexString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getStackLineHash() {
        return this.stackLineHash;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getStackLineHashAsHex() {
        return toHexString(this.stackLineHash);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getLineNumberHash() {
        return this.lineNumberHash;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getLineNumberHashAsHex() {
        return toHexString(this.lineNumberHash);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String asHexString() {
        return this.hexString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String toHexString(int i) {
        String str = y.ۮڭڭܬި(862962851) + Integer.toHexString(i);
        return str.substring(str.length() - 8, str.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExceptionDiagnosis exceptionDiagnosis = (ExceptionDiagnosis) obj;
        return this.lineNumberHash == exceptionDiagnosis.lineNumberHash && this.stackLineHash == exceptionDiagnosis.stackLineHash;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.stackLineHash * 31) + this.lineNumberHash;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576219630) + this.stackLineHash + y.٬ݯح׭٩(576219846) + this.lineNumberHash + '}';
    }
}
