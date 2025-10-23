package twitter4j;

import com.liapp.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class JSONStringer {
    private final String indent;
    final StringBuilder out;
    private final List<Scope> stack;

    enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer() {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        this.indent = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JSONStringer(int i) {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        this.indent = new String(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer array() throws JSONException {
        return open(Scope.EMPTY_ARRAY, y.ٴسسݬߨ(1392956562));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer endArray() throws JSONException {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, y.ۮڭڭܬި(862078387));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer object() throws JSONException {
        return open(Scope.EMPTY_OBJECT, y.֬ڱܱײٮ(-1159674159));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer endObject() throws JSONException {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, y.ۮڭڭܬި(861939259));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JSONStringer open(Scope scope, String str) throws JSONException {
        if (this.stack.isEmpty() && this.out.length() > 0) {
            throw new JSONException("Nesting problem: multiple top-level roots");
        }
        beforeValue();
        this.stack.add(scope);
        this.out.append(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JSONStringer close(Scope scope, Scope scope2, String str) throws JSONException {
        Scope peek = peek();
        if (peek != scope2 && peek != scope) {
            throw new JSONException("Nesting problem");
        }
        this.stack.remove(r3.size() - 1);
        if (peek == scope2) {
            newline();
        }
        this.out.append(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Scope peek() throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException(y.ݬֲ֮ܲت(1512178447));
        }
        return this.stack.get(r0.size() - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void replaceTop(Scope scope) {
        this.stack.set(r0.size() - 1, scope);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer value(Object obj) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException(y.ݬֲ֮ܲت(1512178447));
        }
        if (obj instanceof JSONArray) {
            ((JSONArray) obj).writeTo(this);
            return this;
        }
        if (obj instanceof JSONObject) {
            ((JSONObject) obj).writeTo(this);
            return this;
        }
        beforeValue();
        if (obj == null || (obj instanceof Boolean) || obj == JSONObject.NULL) {
            this.out.append(obj);
        } else if (obj instanceof Number) {
            this.out.append(JSONObject.numberToString((Number) obj));
        } else {
            string(obj.toString());
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer value(boolean z) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException(y.ݬֲ֮ܲت(1512178447));
        }
        beforeValue();
        this.out.append(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer value(double d) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        this.out.append(JSONObject.numberToString(Double.valueOf(d)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer value(long j) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        this.out.append(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void string(String str) {
        StringBuilder sb = this.out;
        String str2 = y.دײܮڳܯ(2051949821);
        sb.append(str2);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt == '\"' || charAt == '/' || charAt == '\\') {
                        this.out.append('\\').append(charAt);
                    } else {
                        switch (charAt) {
                            case '\b':
                                this.out.append(y.دײܮڳܯ(2051623837));
                                break;
                            case '\t':
                                this.out.append(y.֬ڱܱײٮ(-1159719047));
                                break;
                            case '\n':
                                this.out.append(y.ݬֲ֮ܲت(1512661399));
                                break;
                            default:
                                if (charAt <= 31) {
                                    this.out.append(String.format(y.ٲٴݴ״ٰ(1782461960), Integer.valueOf(charAt)));
                                    break;
                                } else {
                                    this.out.append(charAt);
                                    break;
                                }
                        }
                    }
                } else {
                    this.out.append(y.٬ݯح׭٩(575901358));
                }
            } else {
                this.out.append(y.ۮڭڭܬި(862200659));
            }
        }
        this.out.append(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.out.append(y.ٲٴݴ״ٰ(1781641888));
        for (int i = 0; i < this.stack.size(); i++) {
            this.out.append(this.indent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONStringer key(String str) throws JSONException {
        if (str == null) {
            throw new JSONException(y.֬ڱܱײٮ(-1158970551));
        }
        beforeKey();
        string(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void beforeKey() throws JSONException {
        Scope peek = peek();
        if (peek == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (peek != Scope.EMPTY_OBJECT) {
            throw new JSONException(y.ݬֲ֮ܲت(1512178447));
        }
        newline();
        replaceTop(Scope.DANGLING_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void beforeValue() throws JSONException {
        if (this.stack.isEmpty()) {
            return;
        }
        Scope peek = peek();
        if (peek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } else if (peek == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            newline();
        } else if (peek == Scope.DANGLING_KEY) {
            this.out.append(this.indent == null ? y.ݬֲ֮ܲت(1512942399) : y.ݬֲ֮ܲت(1512932847));
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (peek != Scope.NULL) {
            throw new JSONException(y.ݬֲ֮ܲت(1512178447));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        if (this.out.length() == 0) {
            return null;
        }
        return this.out.toString();
    }
}
