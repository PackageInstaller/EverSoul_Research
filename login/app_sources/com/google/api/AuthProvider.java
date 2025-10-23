package com.google.api;

import com.google.api.JwtLocation;
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
public final class AuthProvider extends GeneratedMessageLite<AuthProvider, Builder> implements AuthProviderOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 4;
    public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
    private static final AuthProvider DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISSUER_FIELD_NUMBER = 2;
    public static final int JWKS_URI_FIELD_NUMBER = 3;
    public static final int JWT_LOCATIONS_FIELD_NUMBER = 6;
    private static volatile Parser<AuthProvider> PARSER;
    private String id_ = "";
    private String issuer_ = "";
    private String jwksUri_ = "";
    private String audiences_ = "";
    private String authorizationUrl_ = "";
    private Internal.ProtobufList<JwtLocation> jwtLocations_ = emptyProtobufList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthProvider() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public String getId() {
        return this.id_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public String getIssuer() {
        return this.issuer_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getIssuerBytes() {
        return ByteString.copyFromUtf8(this.issuer_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIssuer(String str) {
        str.getClass();
        this.issuer_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearIssuer() {
        this.issuer_ = getDefaultInstance().getIssuer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIssuerBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.issuer_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public String getJwksUri() {
        return this.jwksUri_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getJwksUriBytes() {
        return ByteString.copyFromUtf8(this.jwksUri_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setJwksUri(String str) {
        str.getClass();
        this.jwksUri_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearJwksUri() {
        this.jwksUri_ = getDefaultInstance().getJwksUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setJwksUriBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.jwksUri_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public String getAudiences() {
        return this.audiences_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getAudiencesBytes() {
        return ByteString.copyFromUtf8(this.audiences_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAudiences(String str) {
        str.getClass();
        this.audiences_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAudiences() {
        this.audiences_ = getDefaultInstance().getAudiences();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAudiencesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.audiences_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public String getAuthorizationUrl() {
        return this.authorizationUrl_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getAuthorizationUrlBytes() {
        return ByteString.copyFromUtf8(this.authorizationUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAuthorizationUrl(String str) {
        str.getClass();
        this.authorizationUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAuthorizationUrl() {
        this.authorizationUrl_ = getDefaultInstance().getAuthorizationUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAuthorizationUrlBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.authorizationUrl_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public List<JwtLocation> getJwtLocationsList() {
        return this.jwtLocations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends JwtLocationOrBuilder> getJwtLocationsOrBuilderList() {
        return this.jwtLocations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public int getJwtLocationsCount() {
        return this.jwtLocations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.AuthProviderOrBuilder
    public JwtLocation getJwtLocations(int i) {
        return this.jwtLocations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JwtLocationOrBuilder getJwtLocationsOrBuilder(int i) {
        return this.jwtLocations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureJwtLocationsIsMutable() {
        Internal.ProtobufList<JwtLocation> protobufList = this.jwtLocations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.jwtLocations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setJwtLocations(int i, JwtLocation jwtLocation) {
        jwtLocation.getClass();
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.set(i, jwtLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addJwtLocations(JwtLocation jwtLocation) {
        jwtLocation.getClass();
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.add(jwtLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addJwtLocations(int i, JwtLocation jwtLocation) {
        jwtLocation.getClass();
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.add(i, jwtLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllJwtLocations(Iterable<? extends JwtLocation> iterable) {
        ensureJwtLocationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.jwtLocations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearJwtLocations() {
        this.jwtLocations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeJwtLocations(int i) {
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(InputStream inputStream) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthProvider) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(AuthProvider authProvider) {
        return DEFAULT_INSTANCE.createBuilder(authProvider);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AuthProvider, Builder> implements AuthProviderOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C11911 c11911) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(AuthProvider.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public String getId() {
            return ((AuthProvider) this.instance).getId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getIdBytes() {
            return ((AuthProvider) this.instance).getIdBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setId(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setId(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearId() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearId();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIdBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public String getIssuer() {
            return ((AuthProvider) this.instance).getIssuer();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getIssuerBytes() {
            return ((AuthProvider) this.instance).getIssuerBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIssuer(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIssuer(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearIssuer() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearIssuer();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIssuerBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIssuerBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public String getJwksUri() {
            return ((AuthProvider) this.instance).getJwksUri();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getJwksUriBytes() {
            return ((AuthProvider) this.instance).getJwksUriBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setJwksUri(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwksUri(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearJwksUri() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearJwksUri();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setJwksUriBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwksUriBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public String getAudiences() {
            return ((AuthProvider) this.instance).getAudiences();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getAudiencesBytes() {
            return ((AuthProvider) this.instance).getAudiencesBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAudiences(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAudiences(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAudiences() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearAudiences();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAudiencesBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAudiencesBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public String getAuthorizationUrl() {
            return ((AuthProvider) this.instance).getAuthorizationUrl();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getAuthorizationUrlBytes() {
            return ((AuthProvider) this.instance).getAuthorizationUrlBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAuthorizationUrl(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAuthorizationUrl(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAuthorizationUrl() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearAuthorizationUrl();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAuthorizationUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAuthorizationUrlBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public List<JwtLocation> getJwtLocationsList() {
            return Collections.unmodifiableList(((AuthProvider) this.instance).getJwtLocationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public int getJwtLocationsCount() {
            return ((AuthProvider) this.instance).getJwtLocationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.AuthProviderOrBuilder
        public JwtLocation getJwtLocations(int i) {
            return ((AuthProvider) this.instance).getJwtLocations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setJwtLocations(int i, JwtLocation jwtLocation) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwtLocations(i, jwtLocation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setJwtLocations(int i, JwtLocation.Builder builder) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwtLocations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addJwtLocations(JwtLocation jwtLocation) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(jwtLocation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addJwtLocations(int i, JwtLocation jwtLocation) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(i, jwtLocation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addJwtLocations(JwtLocation.Builder builder) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addJwtLocations(int i, JwtLocation.Builder builder) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllJwtLocations(Iterable<? extends JwtLocation> iterable) {
            copyOnWrite();
            ((AuthProvider) this.instance).addAllJwtLocations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearJwtLocations() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearJwtLocations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeJwtLocations(int i) {
            copyOnWrite();
            ((AuthProvider) this.instance).removeJwtLocations(i);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthProvider$1 */
    static /* synthetic */ class C11911 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f285xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f285xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f285xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f285xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f285xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f285xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f285xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f285xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C11911 c11911 = null;
        switch (C11911.f285xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthProvider();
            case 2:
                return new Builder(c11911);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u001b", new Object[]{"id_", "issuer_", "jwksUri_", "audiences_", "authorizationUrl_", "jwtLocations_", JwtLocation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthProvider> parser = PARSER;
                if (parser == null) {
                    synchronized (AuthProvider.class) {
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
        AuthProvider authProvider = new AuthProvider();
        DEFAULT_INSTANCE = authProvider;
        GeneratedMessageLite.registerDefaultInstance(AuthProvider.class, authProvider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AuthProvider getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<AuthProvider> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
