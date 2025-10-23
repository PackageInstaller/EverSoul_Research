package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class UncaughtExceptionHandlers {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UncaughtExceptionHandlers() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }

    static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final Logger logger = Logger.getLogger(Exiter.class.getName());
        private final Runtime runtime;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Exiter(Runtime runtime) {
            this.runtime = runtime;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
