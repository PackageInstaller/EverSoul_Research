package twitter4j;

import java.util.logging.Level;

/* loaded from: classes4.dex */
final class JULLogger extends Logger {
    private final java.util.logging.Logger LOGGER;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JULLogger(java.util.logging.Logger logger) {
        this.LOGGER = logger;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isDebugEnabled() {
        return this.LOGGER.isLoggable(Level.FINE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isInfoEnabled() {
        return this.LOGGER.isLoggable(Level.INFO);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isWarnEnabled() {
        return this.LOGGER.isLoggable(Level.WARNING);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isErrorEnabled() {
        return this.LOGGER.isLoggable(Level.SEVERE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void debug(String str) {
        this.LOGGER.fine(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void debug(String str, String str2) {
        this.LOGGER.fine(str + str2);
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
        this.LOGGER.warning(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str, String str2) {
        this.LOGGER.warning(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str, Throwable th) {
        this.LOGGER.warning(str + th.getMessage());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void error(String str) {
        this.LOGGER.severe(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void error(String str, Throwable th) {
        this.LOGGER.severe(str + th.getMessage());
    }
}
