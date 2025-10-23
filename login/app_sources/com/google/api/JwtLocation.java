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
public final class JwtLocation extends GeneratedMessageLite<JwtLocation, Builder> implements JwtLocationOrBuilder {
    private static final JwtLocation DEFAULT_INSTANCE;
    public static final int HEADER_FIELD_NUMBER = 1;
    private static volatile Parser<JwtLocation> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int VALUE_PREFIX_FIELD_NUMBER = 3;
    private Object in_;
    private int inCase_ = 0;
    private String valuePrefix_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JwtLocation() {
    }

    public enum InCase {
        HEADER(1),
        QUERY(2),
        IN_NOT_SET(0);

        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InCase(int i) {
            this.value = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public static InCase valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static InCase forNumber(int i) {
            if (i == 0) {
                return IN_NOT_SET;
            }
            if (i == 1) {
                return HEADER;
            }
            if (i != 2) {
                return null;
            }
            return QUERY;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getNumber() {
            return this.value;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public InCase getInCase() {
        return InCase.forNumber(this.inCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearIn() {
        this.inCase_ = 0;
        this.in_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public String getHeader() {
        return this.inCase_ == 1 ? (String) this.in_ : "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public ByteString getHeaderBytes() {
        return ByteString.copyFromUtf8(this.inCase_ == 1 ? (String) this.in_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHeader(String str) {
        str.getClass();
        this.inCase_ = 1;
        this.in_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearHeader() {
        if (this.inCase_ == 1) {
            this.inCase_ = 0;
            this.in_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHeaderBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.in_ = byteString.toStringUtf8();
        this.inCase_ = 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public String getQuery() {
        return this.inCase_ == 2 ? (String) this.in_ : "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public ByteString getQueryBytes() {
        return ByteString.copyFromUtf8(this.inCase_ == 2 ? (String) this.in_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setQuery(String str) {
        str.getClass();
        this.inCase_ = 2;
        this.in_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearQuery() {
        if (this.inCase_ == 2) {
            this.inCase_ = 0;
            this.in_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setQueryBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.in_ = byteString.toStringUtf8();
        this.inCase_ = 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public String getValuePrefix() {
        return this.valuePrefix_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.JwtLocationOrBuilder
    public ByteString getValuePrefixBytes() {
        return ByteString.copyFromUtf8(this.valuePrefix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValuePrefix(String str) {
        str.getClass();
        this.valuePrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearValuePrefix() {
        this.valuePrefix_ = getDefaultInstance().getValuePrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValuePrefixBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.valuePrefix_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(InputStream inputStream) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (JwtLocation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(JwtLocation jwtLocation) {
        return DEFAULT_INSTANCE.createBuilder(jwtLocation);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<JwtLocation, Builder> implements JwtLocationOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12131 c12131) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(JwtLocation.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public InCase getInCase() {
            return ((JwtLocation) this.instance).getInCase();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearIn() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearIn();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public String getHeader() {
            return ((JwtLocation) this.instance).getHeader();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public ByteString getHeaderBytes() {
            return ((JwtLocation) this.instance).getHeaderBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setHeader(String str) {
            copyOnWrite();
            ((JwtLocation) this.instance).setHeader(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearHeader() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearHeader();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setHeaderBytes(ByteString byteString) {
            copyOnWrite();
            ((JwtLocation) this.instance).setHeaderBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public String getQuery() {
            return ((JwtLocation) this.instance).getQuery();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public ByteString getQueryBytes() {
            return ((JwtLocation) this.instance).getQueryBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setQuery(String str) {
            copyOnWrite();
            ((JwtLocation) this.instance).setQuery(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearQuery() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearQuery();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setQueryBytes(ByteString byteString) {
            copyOnWrite();
            ((JwtLocation) this.instance).setQueryBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public String getValuePrefix() {
            return ((JwtLocation) this.instance).getValuePrefix();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.JwtLocationOrBuilder
        public ByteString getValuePrefixBytes() {
            return ((JwtLocation) this.instance).getValuePrefixBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setValuePrefix(String str) {
            copyOnWrite();
            ((JwtLocation) this.instance).setValuePrefix(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearValuePrefix() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearValuePrefix();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setValuePrefixBytes(ByteString byteString) {
            copyOnWrite();
            ((JwtLocation) this.instance).setValuePrefixBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.JwtLocation$1 */
    static /* synthetic */ class C12131 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f304xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f304xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f304xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f304xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f304xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f304xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f304xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f304xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12131 c12131 = null;
        switch (C12131.f304xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new JwtLocation();
            case 2:
                return new Builder(c12131);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȼ\u0000\u0002Ȼ\u0000\u0003Ȉ", new Object[]{"in_", "inCase_", "valuePrefix_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<JwtLocation> parser = PARSER;
                if (parser == null) {
                    synchronized (JwtLocation.class) {
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
        JwtLocation jwtLocation = new JwtLocation();
        DEFAULT_INSTANCE = jwtLocation;
        GeneratedMessageLite.registerDefaultInstance(JwtLocation.class, jwtLocation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JwtLocation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<JwtLocation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
