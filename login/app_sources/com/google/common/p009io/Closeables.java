package com.google.common.p009io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Closeables {
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Closeables() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void close(@CheckForNull Closeable closeable, boolean z) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (z) {
                logger.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
                return;
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void closeQuietly(@CheckForNull InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void closeQuietly(@CheckForNull Reader reader) {
        try {
            close(reader, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
