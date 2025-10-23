package twitter4j;

/* loaded from: classes4.dex */
final class StdOutLoggerFactory extends LoggerFactory {
    private static final Logger SINGLETON = new StdOutLogger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StdOutLoggerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return SINGLETON;
    }
}
