package twitter4j;

/* loaded from: classes4.dex */
final class SLF4JLoggerFactory extends LoggerFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SLF4JLoggerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.LoggerFactory
    public Logger getLogger(Class<?> cls) {
        return new SLF4JLogger(org.slf4j.LoggerFactory.getLogger(cls));
    }
}
