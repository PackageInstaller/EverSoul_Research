package bolts;

import com.liapp.y;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AggregateException extends Exception {
    private static final String DEFAULT_MESSAGE = "There were multiple errors.";
    private static final long serialVersionUID = 1;
    private List<Throwable> innerThrowables;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AggregateException(String str, Throwable[] thArr) {
        this(str, (List<? extends Throwable>) Arrays.asList(thArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.size() <= 0) ? null : list.get(0));
        this.innerThrowables = Collections.unmodifiableList(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AggregateException(List<? extends Throwable> list) {
        this(y.ݬֲ֮ܲت(1512933207), list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Throwable> getInnerThrowables() {
        return this.innerThrowables;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i = -1;
        for (Throwable th : this.innerThrowables) {
            String str = y.ٲٴݴ״ٰ(1781641888);
            printStream.append((CharSequence) str);
            printStream.append((CharSequence) y.ݮڮֲڭܩ(-629106276));
            i++;
            printStream.append((CharSequence) Integer.toString(i));
            printStream.append((CharSequence) y.ݬֲ֮ܲت(1512932847));
            th.printStackTrace(printStream);
            printStream.append((CharSequence) str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i = -1;
        for (Throwable th : this.innerThrowables) {
            String str = y.ٲٴݴ״ٰ(1781641888);
            printWriter.append((CharSequence) str);
            printWriter.append((CharSequence) y.ݮڮֲڭܩ(-629106276));
            i++;
            printWriter.append((CharSequence) Integer.toString(i));
            printWriter.append((CharSequence) y.ݬֲ֮ܲت(1512932847));
            th.printStackTrace(printWriter);
            printWriter.append((CharSequence) str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public List<Exception> getErrors() {
        ArrayList arrayList = new ArrayList();
        List<Throwable> list = this.innerThrowables;
        if (list == null) {
            return arrayList;
        }
        for (Throwable th : list) {
            if (th instanceof Exception) {
                arrayList.add((Exception) th);
            } else {
                arrayList.add(new Exception(th));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Throwable[] getCauses() {
        List<Throwable> list = this.innerThrowables;
        return (Throwable[]) list.toArray(new Throwable[list.size()]);
    }
}
