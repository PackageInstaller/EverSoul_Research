package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Struct extends GeneratedMessageLite<Struct, Builder> implements StructOrBuilder {
    private static final Struct DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile Parser<Struct> PARSER;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Struct() {
    }

    private static final class FieldsDefaultEntryHolder {
        static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FieldsDefaultEntryHolder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, Value> internalGetFields() {
        return this.fields_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, Value> internalGetMutableFields() {
        if (!this.fields_.isMutable()) {
            this.fields_ = this.fields_.mutableCopy();
        }
        return this.fields_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return internalGetFields().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String str) {
        str.getClass();
        return internalGetFields().containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.StructOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.StructOrBuilder
    public Map<String, Value> getFieldsMap() {
        return Collections.unmodifiableMap(internalGetFields());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrDefault(String str, Value value) {
        str.getClass();
        MapFieldLite<String, Value> internalGetFields = internalGetFields();
        return internalGetFields.containsKey(str) ? internalGetFields.get(str) : value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, Value> internalGetFields = internalGetFields();
        if (!internalGetFields.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetFields.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, Value> getMutableFieldsMap() {
        return internalGetMutableFields();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Struct) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Struct struct) {
        return DEFAULT_INSTANCE.createBuilder(struct);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Struct, Builder> implements StructOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C20421 c20421) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Struct.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.StructOrBuilder
        public int getFieldsCount() {
            return ((Struct) this.instance).getFieldsMap().size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(String str) {
            str.getClass();
            return ((Struct) this.instance).getFieldsMap().containsKey(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearFields() {
            copyOnWrite();
            ((Struct) this.instance).getMutableFieldsMap().clear();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeFields(String str) {
            str.getClass();
            copyOnWrite();
            ((Struct) this.instance).getMutableFieldsMap().remove(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.StructOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.StructOrBuilder
        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((Struct) this.instance).getFieldsMap());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrDefault(String str, Value value) {
            str.getClass();
            Map<String, Value> fieldsMap = ((Struct) this.instance).getFieldsMap();
            return fieldsMap.containsKey(str) ? fieldsMap.get(str) : value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrThrow(String str) {
            str.getClass();
            Map<String, Value> fieldsMap = ((Struct) this.instance).getFieldsMap();
            if (!fieldsMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return fieldsMap.get(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putFields(String str, Value value) {
            str.getClass();
            value.getClass();
            copyOnWrite();
            ((Struct) this.instance).getMutableFieldsMap().put(str, value);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putAllFields(Map<String, Value> map) {
            copyOnWrite();
            ((Struct) this.instance).getMutableFieldsMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Struct$1 */
    static /* synthetic */ class C20421 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f488xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f488xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f488xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f488xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f488xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f488xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f488xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f488xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C20421 c20421 = null;
        switch (C20421.f488xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Struct();
            case 2:
                return new Builder(c20421);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", FieldsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Struct> parser = PARSER;
                if (parser == null) {
                    synchronized (Struct.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Struct struct = new Struct();
        DEFAULT_INSTANCE = struct;
        GeneratedMessageLite.registerDefaultInstance(Struct.class, struct);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Struct> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
