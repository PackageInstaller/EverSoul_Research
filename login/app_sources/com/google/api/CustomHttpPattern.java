package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class CustomHttpPattern extends GeneratedMessageLite<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
    private static final CustomHttpPattern DEFAULT_INSTANCE;
    public static final int KIND_FIELD_NUMBER = 1;
    private static volatile Parser<CustomHttpPattern> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private String kind_ = "";
    private String path_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CustomHttpPattern() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.CustomHttpPatternOrBuilder
    public String getKind() {
        return this.kind_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.CustomHttpPatternOrBuilder
    public ByteString getKindBytes() {
        return ByteString.copyFromUtf8(this.kind_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setKind(String str) {
        str.getClass();
        this.kind_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearKind() {
        this.kind_ = getDefaultInstance().getKind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setKindBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.kind_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.CustomHttpPatternOrBuilder
    public String getPath() {
        return this.path_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.CustomHttpPatternOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPath(String str) {
        str.getClass();
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearPath() {
        this.path_ = getDefaultInstance().getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPathBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.path_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(InputStream inputStream) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(CustomHttpPattern customHttpPattern) {
        return DEFAULT_INSTANCE.createBuilder(customHttpPattern);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12041 c12041) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(CustomHttpPattern.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.CustomHttpPatternOrBuilder
        public String getKind() {
            return ((CustomHttpPattern) this.instance).getKind();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.CustomHttpPatternOrBuilder
        public ByteString getKindBytes() {
            return ((CustomHttpPattern) this.instance).getKindBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setKind(String str) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKind(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearKind() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearKind();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setKindBytes(ByteString byteString) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKindBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.CustomHttpPatternOrBuilder
        public String getPath() {
            return ((CustomHttpPattern) this.instance).getPath();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.CustomHttpPatternOrBuilder
        public ByteString getPathBytes() {
            return ((CustomHttpPattern) this.instance).getPathBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPath(String str) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPath(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearPath() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearPath();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPathBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.CustomHttpPattern$1 */
    static /* synthetic */ class C12041 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f296xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f296xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f296xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f296xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f296xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f296xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f296xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f296xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12041 c12041 = null;
        switch (C12041.f296xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new CustomHttpPattern();
            case 2:
                return new Builder(c12041);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"kind_", "path_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CustomHttpPattern> parser = PARSER;
                if (parser == null) {
                    synchronized (CustomHttpPattern.class) {
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
        CustomHttpPattern customHttpPattern = new CustomHttpPattern();
        DEFAULT_INSTANCE = customHttpPattern;
        GeneratedMessageLite.registerDefaultInstance(CustomHttpPattern.class, customHttpPattern);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomHttpPattern getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<CustomHttpPattern> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
