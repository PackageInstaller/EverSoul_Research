package twitter4j;

import org.apache.commons.logging.Log;

/* loaded from: classes4.dex */
final class CommonsLoggingLogger extends Logger {
    private final Log LOGGER;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CommonsLoggingLogger(Log log) {
        this.LOGGER = log;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isDebugEnabled() {
        return this.LOGGER.isDebugEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isInfoEnabled() {
        return this.LOGGER.isInfoEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isWarnEnabled() {
        return this.LOGGER.isWarnEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isErrorEnabled() {
        return this.LOGGER.isErrorEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void debug(String str) {
        this.LOGGER.debug(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void debug(String str, String str2) {
        this.LOGGER.debug(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void info(String str) {
        this.LOGGER.info(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void info(String str, String str2) {
        this.LOGGER.info(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str) {
        this.LOGGER.warn(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str, String str2) {
        this.LOGGER.warn(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str, Throwable th) {
        this.LOGGER.warn(str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void error(String str) {
        this.LOGGER.error(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void error(String str, Throwable th) {
        this.LOGGER.error(str, th);
    }
}
