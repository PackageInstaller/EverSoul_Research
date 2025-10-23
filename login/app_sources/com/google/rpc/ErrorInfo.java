package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ErrorInfo extends GeneratedMessageLite<ErrorInfo, Builder> implements ErrorInfoOrBuilder {
    private static final ErrorInfo DEFAULT_INSTANCE;
    public static final int DOMAIN_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile Parser<ErrorInfo> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String reason_ = "";
    private String domain_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ErrorInfo() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public String getReason() {
        return this.reason_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public ByteString getReasonBytes() {
        return ByteString.copyFromUtf8(this.reason_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setReasonBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.reason_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public String getDomain() {
        return this.domain_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public ByteString getDomainBytes() {
        return ByteString.copyFromUtf8(this.domain_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDomain(String str) {
        str.getClass();
        this.domain_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDomain() {
        this.domain_ = getDefaultInstance().getDomain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDomainBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.domain_ = byteString.toStringUtf8();
    }

    private static final class MetadataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MetadataDefaultEntryHolder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public int getMetadataCount() {
        return internalGetMetadata().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public boolean containsMetadata(String str) {
        str.getClass();
        return internalGetMetadata().containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> internalGetMetadata = internalGetMetadata();
        return internalGetMetadata.containsKey(str) ? internalGetMetadata.get(str) : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.ErrorInfoOrBuilder
    public String getMetadataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> internalGetMetadata = internalGetMetadata();
        if (!internalGetMetadata.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetMetadata.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(InputStream inputStream) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ErrorInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ErrorInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(ErrorInfo errorInfo) {
        return DEFAULT_INSTANCE.createBuilder(errorInfo);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ErrorInfo, Builder> implements ErrorInfoOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C20651 c20651) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(ErrorInfo.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public String getReason() {
            return ((ErrorInfo) this.instance).getReason();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public ByteString getReasonBytes() {
            return ((ErrorInfo) this.instance).getReasonBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setReason(String str) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setReason(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearReason() {
            copyOnWrite();
            ((ErrorInfo) this.instance).clearReason();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setReasonBytes(ByteString byteString) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setReasonBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public String getDomain() {
            return ((ErrorInfo) this.instance).getDomain();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public ByteString getDomainBytes() {
            return ((ErrorInfo) this.instance).getDomainBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDomain(String str) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setDomain(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDomain() {
            copyOnWrite();
            ((ErrorInfo) this.instance).clearDomain();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDomainBytes(ByteString byteString) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setDomainBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public int getMetadataCount() {
            return ((ErrorInfo) this.instance).getMetadataMap().size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public boolean containsMetadata(String str) {
            str.getClass();
            return ((ErrorInfo) this.instance).getMetadataMap().containsKey(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMetadata() {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeMetadata(String str) {
            str.getClass();
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        @Deprecated
        public Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((ErrorInfo) this.instance).getMetadataMap());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public String getMetadataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metadataMap = ((ErrorInfo) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.ErrorInfoOrBuilder
        public String getMetadataOrThrow(String str) {
            str.getClass();
            Map<String, String> metadataMap = ((ErrorInfo) this.instance).getMetadataMap();
            if (!metadataMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return metadataMap.get(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putMetadata(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.rpc.ErrorInfo$1 */
    static /* synthetic */ class C20651 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f497xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f497xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f497xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f497xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f497xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f497xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f497xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f497xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C20651 c20651 = null;
        switch (C20651.f497xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ErrorInfo();
            case 2:
                return new Builder(c20651);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"reason_", "domain_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ErrorInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (ErrorInfo.class) {
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
        ErrorInfo errorInfo = new ErrorInfo();
        DEFAULT_INSTANCE = errorInfo;
        GeneratedMessageLite.registerDefaultInstance(ErrorInfo.class, errorInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<ErrorInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
