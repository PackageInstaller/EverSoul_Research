package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.liapp.y;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private Key key;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setLoggingDetails(Key key, DataSource dataSource) {
        setLoggingDetails(key, dataSource, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setLoggingDetails(Key key, DataSource dataSource, Class<?> cls) {
        this.key = key;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOrigin(Exception exc) {
        this.exception = exc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Exception getOrigin() {
        return this.exception;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Throwable> getCauses() {
        return this.causes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Log.i(str, y.ۮڭڭܬި(862106779) + i2 + y.٬ݯح׭٩(575997494) + size + y.ٴسسݬߨ(1392959042), rootCauses.get(i));
            i = i2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            Iterator<Throwable> it = ((GlideException) th).getCauses().iterator();
            while (it.hasNext()) {
                addRootCauses(it.next(), list);
            }
            return;
        }
        list.add(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new IndentedAppendable(appendable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder append = new StringBuilder(71).append(this.detailMessage);
        Class<?> cls = this.dataClass;
        String str = y.ݬֲ֮ܲت(1513068719);
        StringBuilder append2 = append.append(cls != null ? str + this.dataClass : "").append(this.dataSource != null ? str + this.dataSource : "").append(this.key != null ? str + this.key : "");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return append2.toString();
        }
        if (rootCauses.size() == 1) {
            append2.append(y.ۮڭڭܬި(862104427));
        } else {
            append2.append(y.٬ݯح׭٩(575997750)).append(rootCauses.size()).append(y.ٲٴݴ״ٰ(1781783648));
        }
        for (Throwable th : rootCauses) {
            append2.append('\n').append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        append2.append(y.٬ݯح׭٩(575997942));
        return append2.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append(y.ٲٴݴ״ٰ(1781784232)).append(String.valueOf(i2)).append(y.٬ݯح׭٩(575997494)).append(String.valueOf(size)).append(y.دײܮڳܯ(2052046917));
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    private static final class IndentedAppendable implements Appendable {
        private static final String EMPTY_SEQUENCE = "";
        private static final String INDENT = "  ";
        private final Appendable appendable;
        private boolean printedNewLine = true;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CharSequence safeSequence(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        IndentedAppendable(Appendable appendable) {
            this.appendable = appendable;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append(y.دײܮڳܯ(2052047853));
            }
            this.printedNewLine = c == '\n';
            this.appendable.append(c);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence safeSequence = safeSequence(charSequence);
            return append(safeSequence, 0, safeSequence.length());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence safeSequence = safeSequence(charSequence);
            boolean z = false;
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append(y.دײܮڳܯ(2052047853));
            }
            if (safeSequence.length() > 0 && safeSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(safeSequence, i, i2);
            return this;
        }
    }
}
