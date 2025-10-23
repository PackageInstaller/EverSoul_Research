package org.apache.commons.lang3.concurrent;

import com.liapp.y;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class BasicThreadFactory implements ThreadFactory {
    private final Boolean daemon;
    private final String namingPattern;
    private final Integer priority;
    private final AtomicLong threadCounter;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final ThreadFactory wrappedFactory;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BasicThreadFactory(Builder builder) {
        if (builder.wrappedFactory == null) {
            this.wrappedFactory = Executors.defaultThreadFactory();
        } else {
            this.wrappedFactory = builder.wrappedFactory;
        }
        this.namingPattern = builder.namingPattern;
        this.priority = builder.priority;
        this.daemon = builder.daemon;
        this.uncaughtExceptionHandler = builder.exceptionHandler;
        this.threadCounter = new AtomicLong();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ThreadFactory getWrappedFactory() {
        return this.wrappedFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNamingPattern() {
        return this.namingPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getDaemonFlag() {
        return this.daemon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getPriority() {
        return this.priority;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getThreadCount() {
        return this.threadCounter.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = getWrappedFactory().newThread(runnable);
        initializeThread(newThread);
        return newThread;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initializeThread(Thread thread) {
        if (getNamingPattern() != null) {
            thread.setName(String.format(getNamingPattern(), Long.valueOf(this.threadCounter.incrementAndGet())));
        }
        if (getUncaughtExceptionHandler() != null) {
            thread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
        }
        if (getPriority() != null) {
            thread.setPriority(getPriority().intValue());
        }
        if (getDaemonFlag() != null) {
            thread.setDaemon(getDaemonFlag().booleanValue());
        }
    }

    public static class Builder implements org.apache.commons.lang3.builder.Builder<BasicThreadFactory> {
        private Boolean daemon;
        private Thread.UncaughtExceptionHandler exceptionHandler;
        private String namingPattern;
        private Integer priority;
        private ThreadFactory wrappedFactory;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder wrappedFactory(ThreadFactory threadFactory) {
            Validate.notNull(threadFactory, y.ٴسسݬߨ(1392569634), new Object[0]);
            this.wrappedFactory = threadFactory;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder namingPattern(String str) {
            Validate.notNull(str, y.ݮڮֲڭܩ(-628840788), new Object[0]);
            this.namingPattern = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder daemon(boolean z) {
            this.daemon = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder priority(int i) {
            this.priority = Integer.valueOf(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Validate.notNull(uncaughtExceptionHandler, y.ٴسسݬߨ(1392569426), new Object[0]);
            this.exceptionHandler = uncaughtExceptionHandler;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void reset() {
            this.wrappedFactory = null;
            this.exceptionHandler = null;
            this.namingPattern = null;
            this.priority = null;
            this.daemon = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.builder.Builder
        public BasicThreadFactory build() {
            BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this);
            reset();
            return basicThreadFactory;
        }
    }
}
