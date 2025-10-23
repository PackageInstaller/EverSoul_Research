package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CheckReturnValue
/* loaded from: classes3.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Protobuf getInstance() {
        return INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> void writeTo(T t, Writer writer) throws IOException {
        schemaFor((Protobuf) t).writeTo(t, writer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> void mergeFrom(T t, Reader reader) throws IOException {
        mergeFrom(t, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor((Protobuf) t).mergeFrom(t, reader, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> void makeImmutable(T t) {
        schemaFor((Protobuf) t).makeImmutable(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <T> boolean isInitialized(T t) {
        return schemaFor((Protobuf) t).isInitialized(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schema = (Schema) this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema<T> createSchema = this.schemaFactory.createSchema(cls);
        Schema<T> schema2 = (Schema<T>) registerSchema(cls, createSchema);
        return schema2 != null ? schema2 : createSchema;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> Schema<T> schemaFor(T t) {
        return schemaFor((Class) t.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Protobuf() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getTotalSchemaSize() {
        int i = 0;
        for (Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                i += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return i;
    }
}
