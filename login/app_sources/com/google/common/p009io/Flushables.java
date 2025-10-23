package com.google.common.p009io;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Flushables {
    private static final Logger logger = Logger.getLogger(Flushables.class.getName());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Flushables() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void flush(Flushable flushable, boolean z) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e) {
            if (z) {
                logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e);
                return;
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void flushQuietly(Flushable flushable) {
        try {
            flush(flushable, true);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e);
        }
    }
}
