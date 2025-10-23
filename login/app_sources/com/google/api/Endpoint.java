package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    private static final Endpoint DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Endpoint> PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 101;
    private boolean allowCors_;
    private String name_ = "";
    private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> features_ = GeneratedMessageLite.emptyProtobufList();
    private String target_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Endpoint() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public String getName() {
        return this.name_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public List<String> getAliasesList() {
        return this.aliases_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public int getAliasesCount() {
        return this.aliases_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public String getAliases(int i) {
        return this.aliases_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public ByteString getAliasesBytes(int i) {
        return ByteString.copyFromUtf8(this.aliases_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureAliasesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.aliases_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.aliases_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAliases(int i, String str) {
        str.getClass();
        ensureAliasesIsMutable();
        this.aliases_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAliases(String str) {
        str.getClass();
        ensureAliasesIsMutable();
        this.aliases_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllAliases(Iterable<String> iterable) {
        ensureAliasesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.aliases_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAliases() {
        this.aliases_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAliasesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAliasesIsMutable();
        this.aliases_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public List<String> getFeaturesList() {
        return this.features_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public int getFeaturesCount() {
        return this.features_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public String getFeatures(int i) {
        return this.features_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public ByteString getFeaturesBytes(int i) {
        return ByteString.copyFromUtf8(this.features_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureFeaturesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.features_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.features_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFeatures(int i, String str) {
        str.getClass();
        ensureFeaturesIsMutable();
        this.features_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addFeatures(String str) {
        str.getClass();
        ensureFeaturesIsMutable();
        this.features_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllFeatures(Iterable<String> iterable) {
        ensureFeaturesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.features_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearFeatures() {
        this.features_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addFeaturesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureFeaturesIsMutable();
        this.features_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public String getTarget() {
        return this.target_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public ByteString getTargetBytes() {
        return ByteString.copyFromUtf8(this.target_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTarget(String str) {
        str.getClass();
        this.target_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearTarget() {
        this.target_ = getDefaultInstance().getTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTargetBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.target_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.EndpointOrBuilder
    public boolean getAllowCors() {
        return this.allowCors_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowCors(boolean z) {
        this.allowCors_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAllowCors() {
        this.allowCors_ = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Endpoint endpoint) {
        return DEFAULT_INSTANCE.createBuilder(endpoint);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12081 c12081) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Endpoint.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public String getName() {
            return ((Endpoint) this.instance).getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public ByteString getNameBytes() {
            return ((Endpoint) this.instance).getNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearName() {
            copyOnWrite();
            ((Endpoint) this.instance).clearName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).setNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public List<String> getAliasesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getAliasesList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public int getAliasesCount() {
            return ((Endpoint) this.instance).getAliasesCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public String getAliases(int i) {
            return ((Endpoint) this.instance).getAliases(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public ByteString getAliasesBytes(int i) {
            return ((Endpoint) this.instance).getAliasesBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setAliases(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setAliases(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder addAliases(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliases(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder addAllAliases(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllAliases(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder clearAliases() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAliases();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder addAliasesBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliasesBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public List<String> getFeaturesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getFeaturesList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public int getFeaturesCount() {
            return ((Endpoint) this.instance).getFeaturesCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public String getFeatures(int i) {
            return ((Endpoint) this.instance).getFeatures(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public ByteString getFeaturesBytes(int i) {
            return ((Endpoint) this.instance).getFeaturesBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setFeatures(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setFeatures(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addFeatures(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeatures(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllFeatures(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllFeatures(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearFeatures() {
            copyOnWrite();
            ((Endpoint) this.instance).clearFeatures();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addFeaturesBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeaturesBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public String getTarget() {
            return ((Endpoint) this.instance).getTarget();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public ByteString getTargetBytes() {
            return ((Endpoint) this.instance).getTargetBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTarget(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setTarget(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearTarget() {
            copyOnWrite();
            ((Endpoint) this.instance).clearTarget();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTargetBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).setTargetBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.EndpointOrBuilder
        public boolean getAllowCors() {
            return ((Endpoint) this.instance).getAllowCors();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllowCors(boolean z) {
            copyOnWrite();
            ((Endpoint) this.instance).setAllowCors(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAllowCors() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAllowCors();
            return this;
        }
    }

    /* renamed from: com.google.api.Endpoint$1 */
    static /* synthetic */ class C12081 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f300xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f300xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f300xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f300xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f300xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f300xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f300xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f300xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12081 c12081 = null;
        switch (C12081.f300xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Endpoint();
            case 2:
                return new Builder(c12081);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001e\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ț\u0004Ț\u0005\u0007eȈ", new Object[]{"name_", "aliases_", "features_", "allowCors_", "target_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Endpoint> parser = PARSER;
                if (parser == null) {
                    synchronized (Endpoint.class) {
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
        Endpoint endpoint = new Endpoint();
        DEFAULT_INSTANCE = endpoint;
        GeneratedMessageLite.registerDefaultInstance(Endpoint.class, endpoint);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Endpoint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
