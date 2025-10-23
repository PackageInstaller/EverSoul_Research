package twitter4j;

/* loaded from: classes4.dex */
final class Log4JLoggerFactory extends LoggerFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Log4JLoggerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return new Log4JLogger(org.apache.log4j.Logger.getLogger(cls));
    }
}
