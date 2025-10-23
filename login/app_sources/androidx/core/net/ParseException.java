package androidx.core.net;

/* loaded from: classes.dex */
public class ParseException extends RuntimeException {
    public final String response;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ParseException(String str) {
        super(str);
        this.response = str;
    }
}
