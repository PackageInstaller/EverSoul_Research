package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* loaded from: classes2.dex */
public class LogFileManager {
    private static final String LOGFILE_NAME = "userlog";
    static final int MAX_LOG_SIZE = 65536;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private FileLogStore currentLog;
    private final FileStore fileStore;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogFileManager(FileStore fileStore) {
        this.fileStore = fileStore;
        this.currentLog = NOOP_LOG_STORE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        setCurrentSession(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str == null) {
            return;
        }
        setLogFile(getWorkingFileForSession(str), 65536);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeToLog(long j, String str) {
        this.currentLog.writeToLog(j, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getBytesForLog() {
        return this.currentLog.getLogAsBytes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLogString() {
        return this.currentLog.getLogAsString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setLogFile(File file, int i) {
        this.currentLog = new QueueFileLogStore(file, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private File getWorkingFileForSession(String str) {
        return this.fileStore.getSessionFile(str, LOGFILE_NAME);
    }

    private static final class NoopLogStore implements FileLogStore {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void closeLogFile() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void deleteLogFile() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public byte[] getLogAsBytes() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public String getLogAsString() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void writeToLog(long j, String str) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NoopLogStore() {
        }
    }
}
