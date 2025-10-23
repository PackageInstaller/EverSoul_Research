package com.google.api;

import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
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
public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    private static final AuthenticationRule DEFAULT_INSTANCE;
    public static final int OAUTH_FIELD_NUMBER = 2;
    private static volatile Parser<AuthenticationRule> PARSER = null;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private boolean allowWithoutCredential_;
    private OAuthRequirements oauth_;
    private String selector_ = "";
    private Internal.ProtobufList<AuthRequirement> requirements_ = emptyProtobufList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthenticationRule() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelector(String str) {
        str.getClass();
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelectorBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean hasOauth() {
        return this.oauth_ != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOauth(OAuthRequirements oAuthRequirements) {
        oAuthRequirements.getClass();
        this.oauth_ = oAuthRequirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeOauth(OAuthRequirements oAuthRequirements) {
        oAuthRequirements.getClass();
        OAuthRequirements oAuthRequirements2 = this.oauth_;
        if (oAuthRequirements2 != null && oAuthRequirements2 != OAuthRequirements.getDefaultInstance()) {
            this.oauth_ = OAuthRequirements.newBuilder(this.oauth_).mergeFrom((OAuthRequirements.Builder) oAuthRequirements).buildPartial();
        } else {
            this.oauth_ = oAuthRequirements;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearOauth() {
        this.oauth_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowWithoutCredential(boolean z) {
        this.allowWithoutCredential_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAllowWithoutCredential() {
        this.allowWithoutCredential_ = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthenticationRuleOrBuilder
    public AuthRequirement getRequirements(int i) {
        return this.requirements_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthRequirementOrBuilder getRequirementsOrBuilder(int i) {
        return this.requirements_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureRequirementsIsMutable() {
        Internal.ProtobufList<AuthRequirement> protobufList = this.requirements_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.requirements_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequirements(int i, AuthRequirement authRequirement) {
        authRequirement.getClass();
        ensureRequirementsIsMutable();
        this.requirements_.set(i, authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRequirements(AuthRequirement authRequirement) {
        authRequirement.getClass();
        ensureRequirementsIsMutable();
        this.requirements_.add(authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRequirements(int i, AuthRequirement authRequirement) {
        authRequirement.getClass();
        ensureRequirementsIsMutable();
        this.requirements_.add(i, authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.requirements_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRequirements() {
        this.requirements_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeRequirements(int i) {
        ensureRequirementsIsMutable();
        this.requirements_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(AuthenticationRule authenticationRule) {
        return DEFAULT_INSTANCE.createBuilder(authenticationRule);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C11941 c11941) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(AuthenticationRule.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public String getSelector() {
            return ((AuthenticationRule) this.instance).getSelector();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((AuthenticationRule) this.instance).getSelectorBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelector(String str) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setSelector(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSelector() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearSelector();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean hasOauth() {
            return ((AuthenticationRule) this.instance).hasOauth();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public OAuthRequirements getOauth() {
            return ((AuthenticationRule) this.instance).getOauth();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOauth(OAuthRequirements oAuthRequirements) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setOauth(oAuthRequirements);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOauth(OAuthRequirements.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setOauth(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeOauth(OAuthRequirements oAuthRequirements) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).mergeOauth(oAuthRequirements);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearOauth() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearOauth();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean getAllowWithoutCredential() {
            return ((AuthenticationRule) this.instance).getAllowWithoutCredential();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllowWithoutCredential(boolean z) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setAllowWithoutCredential(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAllowWithoutCredential() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearAllowWithoutCredential();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public List<AuthRequirement> getRequirementsList() {
            return Collections.unmodifiableList(((AuthenticationRule) this.instance).getRequirementsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public int getRequirementsCount() {
            return ((AuthenticationRule) this.instance).getRequirementsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthenticationRuleOrBuilder
        public AuthRequirement getRequirements(int i) {
            return ((AuthenticationRule) this.instance).getRequirements(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRequirements(int i, AuthRequirement authRequirement) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setRequirements(i, authRequirement);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRequirements(int i, AuthRequirement.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setRequirements(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRequirements(AuthRequirement authRequirement) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(authRequirement);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRequirements(int i, AuthRequirement authRequirement) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(i, authRequirement);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRequirements(AuthRequirement.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRequirements(int i, AuthRequirement.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addAllRequirements(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRequirements() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearRequirements();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeRequirements(int i) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).removeRequirements(i);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthenticationRule$1 */
    static /* synthetic */ class C11941 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f288xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f288xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f288xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f288xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f288xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f288xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f288xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f288xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C11941 c11941 = null;
        switch (C11941.f288xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthenticationRule();
            case 2:
                return new Builder(c11941);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0007\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\t\u0005\u0007\u0007\u001b", new Object[]{"selector_", "oauth_", "allowWithoutCredential_", "requirements_", AuthRequirement.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthenticationRule> parser = PARSER;
                if (parser == null) {
                    synchronized (AuthenticationRule.class) {
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
        AuthenticationRule authenticationRule = new AuthenticationRule();
        DEFAULT_INSTANCE = authenticationRule;
        GeneratedMessageLite.registerDefaultInstance(AuthenticationRule.class, authenticationRule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<AuthenticationRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
