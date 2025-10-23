package kotlin.p031io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Console.kt */
@Metadata(m838d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\t\u0010\r\u001a\u00020\u0001H\u0087\b\u001a\u0013\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\b\u0010\u0010\u001a\u00020\u000fH\u0007\u001a\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0012"}, m839d2 = {"print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "readln", "readlnOrNull", "kotlin-stdlib"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ConsoleKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(Object obj) {
        System.out.print(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(int i) {
        System.out.print(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(long j) {
        System.out.print(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(short s) {
        System.out.print(Short.valueOf(s));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(char c) {
        System.out.print(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(boolean z) {
        System.out.print(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(float f) {
        System.out.print(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(double d) {
        System.out.print(d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void print(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.print(message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(Object obj) {
        System.out.println(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(int i) {
        System.out.println(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(long j) {
        System.out.println(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(short s) {
        System.out.println(Short.valueOf(s));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(char c) {
        System.out.println(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(boolean z) {
        System.out.println(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(float f) {
        System.out.println(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(double d) {
        System.out.println(d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.println(message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void println() {
        System.out.println();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String readln() {
        String readlnOrNull = readlnOrNull();
        if (readlnOrNull != null) {
            return readlnOrNull;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String readlnOrNull() {
        return readLine();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }
}
