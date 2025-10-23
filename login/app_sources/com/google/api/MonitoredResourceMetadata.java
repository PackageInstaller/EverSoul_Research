package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MonitoredResourceMetadata extends GeneratedMessageLite<MonitoredResourceMetadata, Builder> implements MonitoredResourceMetadataOrBuilder {
    private static final MonitoredResourceMetadata DEFAULT_INSTANCE;
    private static volatile Parser<MonitoredResourceMetadata> PARSER = null;
    public static final int SYSTEM_LABELS_FIELD_NUMBER = 1;
    public static final int USER_LABELS_FIELD_NUMBER = 2;
    private Struct systemLabels_;
    private MapFieldLite<String, String> userLabels_ = MapFieldLite.emptyMapField();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MonitoredResourceMetadata() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public boolean hasSystemLabels() {
        return this.systemLabels_ != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public Struct getSystemLabels() {
        Struct struct = this.systemLabels_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSystemLabels(Struct struct) {
        struct.getClass();
        this.systemLabels_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeSystemLabels(Struct struct) {
        struct.getClass();
        Struct struct2 = this.systemLabels_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            this.systemLabels_ = Struct.newBuilder(this.systemLabels_).mergeFrom((Struct.Builder) struct).buildPartial();
        } else {
            this.systemLabels_ = struct;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSystemLabels() {
        this.systemLabels_ = null;
    }

    private static final class UserLabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private UserLabelsDefaultEntryHolder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, String> internalGetUserLabels() {
        return this.userLabels_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, String> internalGetMutableUserLabels() {
        if (!this.userLabels_.isMutable()) {
            this.userLabels_ = this.userLabels_.mutableCopy();
        }
        return this.userLabels_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public int getUserLabelsCount() {
        return internalGetUserLabels().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public boolean containsUserLabels(String str) {
        str.getClass();
        return internalGetUserLabels().containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    @Deprecated
    public Map<String, String> getUserLabels() {
        return getUserLabelsMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public Map<String, String> getUserLabelsMap() {
        return Collections.unmodifiableMap(internalGetUserLabels());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public String getUserLabelsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> internalGetUserLabels = internalGetUserLabels();
        return internalGetUserLabels.containsKey(str) ? internalGetUserLabels.get(str) : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public String getUserLabelsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> internalGetUserLabels = internalGetUserLabels();
        if (!internalGetUserLabels.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetUserLabels.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getMutableUserLabelsMap() {
        return internalGetMutableUserLabels();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(MonitoredResourceMetadata monitoredResourceMetadata) {
        return DEFAULT_INSTANCE.createBuilder(monitoredResourceMetadata);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceMetadata, Builder> implements MonitoredResourceMetadataOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12261 c12261) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(MonitoredResourceMetadata.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public boolean hasSystemLabels() {
            return ((MonitoredResourceMetadata) this.instance).hasSystemLabels();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public Struct getSystemLabels() {
            return ((MonitoredResourceMetadata) this.instance).getSystemLabels();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSystemLabels(Struct struct) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).setSystemLabels(struct);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSystemLabels(Struct.Builder builder) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).setSystemLabels(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeSystemLabels(Struct struct) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).mergeSystemLabels(struct);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSystemLabels() {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).clearSystemLabels();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public int getUserLabelsCount() {
            return ((MonitoredResourceMetadata) this.instance).getUserLabelsMap().size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public boolean containsUserLabels(String str) {
            str.getClass();
            return ((MonitoredResourceMetadata) this.instance).getUserLabelsMap().containsKey(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearUserLabels() {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().clear();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeUserLabels(String str) {
            str.getClass();
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().remove(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        @Deprecated
        public Map<String, String> getUserLabels() {
            return getUserLabelsMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public Map<String, String> getUserLabelsMap() {
            return Collections.unmodifiableMap(((MonitoredResourceMetadata) this.instance).getUserLabelsMap());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public String getUserLabelsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> userLabelsMap = ((MonitoredResourceMetadata) this.instance).getUserLabelsMap();
            return userLabelsMap.containsKey(str) ? userLabelsMap.get(str) : str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public String getUserLabelsOrThrow(String str) {
            str.getClass();
            Map<String, String> userLabelsMap = ((MonitoredResourceMetadata) this.instance).getUserLabelsMap();
            if (!userLabelsMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return userLabelsMap.get(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putUserLabels(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().put(str, str2);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putAllUserLabels(Map<String, String> map) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.api.MonitoredResourceMetadata$1 */
    static /* synthetic */ class C12261 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f314xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f314xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f314xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f314xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f314xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f314xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f314xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f314xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12261 c12261 = null;
        switch (C12261.f314xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new MonitoredResourceMetadata();
            case 2:
                return new Builder(c12261);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\t\u00022", new Object[]{"systemLabels_", "userLabels_", UserLabelsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MonitoredResourceMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (MonitoredResourceMetadata.class) {
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
        MonitoredResourceMetadata monitoredResourceMetadata = new MonitoredResourceMetadata();
        DEFAULT_INSTANCE = monitoredResourceMetadata;
        GeneratedMessageLite.registerDefaultInstance(MonitoredResourceMetadata.class, monitoredResourceMetadata);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MonitoredResourceMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<MonitoredResourceMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
