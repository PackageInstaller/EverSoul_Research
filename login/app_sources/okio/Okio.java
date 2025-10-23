package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(m837bv = {1, 0, 3}, m838d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, m840k = 4, m841mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class Okio {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink appendingSink(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final BufferedSink buffer(Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final BufferedSource buffer(Source source) {
        return Okio__OkioKt.buffer(source);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink sink(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink sink(File file, boolean z) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink sink(OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink sink(Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Source source(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Source source(InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Source source(Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }
}
