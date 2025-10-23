package twitter4j;

import com.liapp.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes4.dex */
public class JSONTokener {

    /* renamed from: in */
    private final String f1565in;
    private int pos;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (c < 'A' || c > 'F') {
            c2 = 'a';
            if (c < 'a' || c > 'f') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONTokener(String str) {
        if (str != null && str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        this.f1565in = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONTokener(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[102400];
            int read = reader.read(cArr);
            while (read >= 0) {
                sb.append(cArr, 0, read);
                read = reader.read(cArr);
            }
            this.f1565in = sb.toString();
            this.pos = 0;
        } catch (IOException e) {
            throw new JSONException(y.دײܮڳܯ(2051156989), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONTokener(InputStream inputStream) {
        this(new InputStreamReader(inputStream, Charset.forName(y.֬ڱܱײٮ(-1158974367))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object nextValue() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            throw syntaxError(y.ٴسسݬߨ(1393238906));
        }
        if (nextCleanInternal == 34 || nextCleanInternal == 39) {
            return nextString((char) nextCleanInternal);
        }
        if (nextCleanInternal == 91) {
            return readArray();
        }
        if (nextCleanInternal == 123) {
            return readObject();
        }
        this.pos--;
        return readLiteral();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int nextCleanInternal() throws JSONException {
        while (this.pos < this.f1565in.length()) {
            String str = this.f1565in;
            int i = this.pos;
            this.pos = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                if (charAt != '#') {
                    if (charAt != '/' || this.pos == this.f1565in.length()) {
                        return charAt;
                    }
                    char charAt2 = this.f1565in.charAt(this.pos);
                    if (charAt2 == '*') {
                        int i2 = this.pos + 1;
                        this.pos = i2;
                        int indexOf = this.f1565in.indexOf(y.ݬֲ֮ܲت(1512178127), i2);
                        if (indexOf == -1) {
                            throw syntaxError(y.֬ڱܱײٮ(-1158973623));
                        }
                        this.pos = indexOf + 2;
                    } else {
                        if (charAt2 != '/') {
                            return charAt;
                        }
                        this.pos++;
                        skipToEndOfLine();
                    }
                } else {
                    skipToEndOfLine();
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void skipToEndOfLine() {
        while (this.pos < this.f1565in.length()) {
            char charAt = this.f1565in.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n') {
                this.pos++;
            } else {
                this.pos++;
                return;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String nextString(char c) throws JSONException {
        int i = this.pos;
        StringBuilder sb = null;
        while (this.pos < this.f1565in.length()) {
            String str = this.f1565in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt == c) {
                if (sb == null) {
                    return new String(this.f1565in.substring(i, this.pos - 1));
                }
                sb.append((CharSequence) this.f1565in, i, this.pos - 1);
                return sb.toString();
            }
            if (charAt == '\\') {
                if (this.pos == this.f1565in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.f1565in, i, this.pos - 1);
                sb.append(readEscapeCharacter());
                i = this.pos;
            }
        }
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private char readEscapeCharacter() throws JSONException {
        String str = this.f1565in;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt == 'b') {
            return '\b';
        }
        if (charAt == 'f') {
            return '\f';
        }
        if (charAt == 'n') {
            return '\n';
        }
        if (charAt == 'r') {
            return CharUtils.f1521CR;
        }
        if (charAt == 't') {
            return '\t';
        }
        if (charAt != 'u') {
            return charAt;
        }
        if (this.pos + 4 > this.f1565in.length()) {
            throw syntaxError(y.ݮڮֲڭܩ(-628158260));
        }
        String str2 = this.f1565in;
        int i2 = this.pos;
        String substring = str2.substring(i2, i2 + 4);
        this.pos += 4;
        try {
            return (char) Integer.parseInt(substring, 16);
        } catch (NumberFormatException unused) {
            throw syntaxError(y.ٲٴݴ״ٰ(1782461648) + substring);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object readLiteral() throws JSONException {
        String substring;
        int i;
        String nextToInternal = nextToInternal("{}[]/\\:,=;# \t\f");
        if (nextToInternal.length() == 0) {
            throw syntaxError(y.ٲٴݴ״ٰ(1782463128));
        }
        if (y.ݮڮֲڭܩ(-628841308).equalsIgnoreCase(nextToInternal)) {
            return JSONObject.NULL;
        }
        if (y.دײܮڳܯ(2051939573).equalsIgnoreCase(nextToInternal)) {
            return Boolean.TRUE;
        }
        if (y.ٲٴݴ״ٰ(1781635312).equalsIgnoreCase(nextToInternal)) {
            return Boolean.FALSE;
        }
        if (nextToInternal.indexOf(46) == -1) {
            if (nextToInternal.startsWith(y.دײܮڳܯ(2051829341)) || nextToInternal.startsWith(y.ݮڮֲڭܩ(-628820740))) {
                substring = nextToInternal.substring(2);
                i = 16;
            } else if (!nextToInternal.startsWith(y.دײܮڳܯ(2051900013)) || nextToInternal.length() <= 1) {
                i = 10;
                substring = nextToInternal;
            } else {
                substring = nextToInternal.substring(1);
                i = 8;
            }
            try {
                long parseLong = Long.parseLong(substring, i);
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return Integer.valueOf((int) parseLong);
                }
                return Long.valueOf(parseLong);
            } catch (NumberFormatException unused) {
            }
        }
        try {
            return Double.valueOf(nextToInternal);
        } catch (NumberFormatException unused2) {
            return new String(nextToInternal);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String nextToInternal(String str) {
        int i = this.pos;
        while (this.pos < this.f1565in.length()) {
            char charAt = this.f1565in.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n' && str.indexOf(charAt) == -1) {
                this.pos++;
            } else {
                return this.f1565in.substring(i, this.pos);
            }
        }
        return this.f1565in.substring(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JSONObject readObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return jSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            if (!(nextValue instanceof String)) {
                if (nextValue == null) {
                    throw syntaxError(y.ٲٴݴ״ٰ(1782462808));
                }
                throw syntaxError(y.֬ڱܱײٮ(-1158972479) + nextValue + y.֬ڱܱײٮ(-1158972711) + nextValue.getClass().getName());
            }
            int nextCleanInternal2 = nextCleanInternal();
            if (nextCleanInternal2 != 58 && nextCleanInternal2 != 61) {
                throw syntaxError(y.٬ݯح׭٩(576250982) + nextValue);
            }
            if (this.pos < this.f1565in.length() && this.f1565in.charAt(this.pos) == '>') {
                this.pos++;
            }
            jSONObject.put((String) nextValue, nextValue());
            int nextCleanInternal3 = nextCleanInternal();
            if (nextCleanInternal3 != 44 && nextCleanInternal3 != 59) {
                if (nextCleanInternal3 == 125) {
                    return jSONObject;
                }
                throw syntaxError(y.ۮڭڭܬި(862931403));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JSONArray readArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            String str = y.֬ڱܱײٮ(-1158973927);
            if (nextCleanInternal == -1) {
                throw syntaxError(str);
            }
            if (nextCleanInternal == 44 || nextCleanInternal == 59) {
                jSONArray.put((Object) null);
            } else {
                if (nextCleanInternal == 93) {
                    if (z) {
                        jSONArray.put((Object) null);
                    }
                    return jSONArray;
                }
                this.pos--;
                jSONArray.put(nextValue());
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 != 44 && nextCleanInternal2 != 59) {
                    if (nextCleanInternal2 == 93) {
                        return jSONArray;
                    }
                    throw syntaxError(str);
                }
            }
            z = true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONException syntaxError(String str) {
        return new JSONException(str + this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ۮڭڭܬި(862931619) + this.pos + y.٬ݯح׭٩(575997494) + this.f1565in;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean more() {
        return this.pos < this.f1565in.length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char next() {
        if (this.pos >= this.f1565in.length()) {
            return (char) 0;
        }
        String str = this.f1565in;
        int i = this.pos;
        this.pos = i + 1;
        return str.charAt(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char next(char c) throws JSONException {
        char next = next();
        if (next == c) {
            return next;
        }
        throw syntaxError(y.ٲٴݴ״ٰ(1781558056) + c + y.ٴسسݬߨ(1393238522) + next);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char nextClean() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            return (char) 0;
        }
        return (char) nextCleanInternal;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String next(int i) throws JSONException {
        if (this.pos + i > this.f1565in.length()) {
            throw syntaxError(i + y.֬ڱܱײٮ(-1158972223));
        }
        String str = this.f1565in;
        int i2 = this.pos;
        String substring = str.substring(i2, i2 + i);
        this.pos += i;
        return substring;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String nextTo(String str) {
        if (str == null) {
            throw new NullPointerException(y.֬ڱܱײٮ(-1158971479));
        }
        return nextToInternal(str).trim();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String nextTo(char c) {
        return nextToInternal(String.valueOf(c)).trim();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void skipPast(String str) {
        int indexOf = this.f1565in.indexOf(str, this.pos);
        this.pos = indexOf == -1 ? this.f1565in.length() : str.length() + indexOf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char skipTo(char c) {
        int indexOf = this.f1565in.indexOf(c, this.pos);
        if (indexOf == -1) {
            return (char) 0;
        }
        this.pos = indexOf;
        return c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void back() {
        int i = this.pos - 1;
        this.pos = i;
        if (i == -1) {
            this.pos = 0;
        }
    }
}
