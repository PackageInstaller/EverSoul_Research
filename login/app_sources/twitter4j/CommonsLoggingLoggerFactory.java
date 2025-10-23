package twitter4j;

import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
final class CommonsLoggingLoggerFactory extends LoggerFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CommonsLoggingLoggerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return new CommonsLoggingLogger(LogFactory.getLog(cls));
    }
}
