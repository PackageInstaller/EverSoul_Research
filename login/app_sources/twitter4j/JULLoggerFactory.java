package twitter4j;

/* loaded from: classes4.dex */
final class JULLoggerFactory extends LoggerFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JULLoggerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return new JULLogger(java.util.logging.Logger.getLogger(cls.getName()));
    }
}
