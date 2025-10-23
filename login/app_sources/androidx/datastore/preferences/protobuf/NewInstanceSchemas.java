package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class NewInstanceSchemas {
    private static final NewInstanceSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final NewInstanceSchema LITE_SCHEMA = new NewInstanceSchemaLite();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NewInstanceSchemas() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static NewInstanceSchema full() {
        return FULL_SCHEMA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static NewInstanceSchema lite() {
        return LITE_SCHEMA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static NewInstanceSchema loadSchemaForFullRuntime() {
        try {
            return (NewInstanceSchema) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
