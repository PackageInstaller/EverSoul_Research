package twitter4j;

/* loaded from: classes4.dex */
final class NullLoggerFactory extends LoggerFactory {
    private static final Logger SINGLETON = new NullLogger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NullLoggerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return SINGLETON;
    }
}
