package com.google.api;

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

/* loaded from: classes2.dex */
public final class BackendRule extends GeneratedMessageLite<BackendRule, Builder> implements BackendRuleOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int DEADLINE_FIELD_NUMBER = 3;
    private static final BackendRule DEFAULT_INSTANCE;
    public static final int DISABLE_AUTH_FIELD_NUMBER = 8;
    public static final int JWT_AUDIENCE_FIELD_NUMBER = 7;
    public static final int MIN_DEADLINE_FIELD_NUMBER = 4;
    public static final int OPERATION_DEADLINE_FIELD_NUMBER = 5;
    private static volatile Parser<BackendRule> PARSER = null;
    public static final int PATH_TRANSLATION_FIELD_NUMBER = 6;
    public static final int PROTOCOL_FIELD_NUMBER = 9;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private Object authentication_;
    private double deadline_;
    private double minDeadline_;
    private double operationDeadline_;
    private int pathTranslation_;
    private int authenticationCase_ = 0;
    private String selector_ = "";
    private String address_ = "";
    private String protocol_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BackendRule() {
    }

    public enum PathTranslation implements Internal.EnumLite {
        PATH_TRANSLATION_UNSPECIFIED(0),
        CONSTANT_ADDRESS(1),
        APPEND_PATH_TO_ADDRESS(2),
        UNRECOGNIZED(-1);

        public static final int APPEND_PATH_TO_ADDRESS_VALUE = 2;
        public static final int CONSTANT_ADDRESS_VALUE = 1;
        public static final int PATH_TRANSLATION_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<PathTranslation> internalValueMap = new Internal.EnumLiteMap<PathTranslation>() { // from class: com.google.api.BackendRule.PathTranslation.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PathTranslation findValueByNumber(int i) {
                return PathTranslation.forNumber(i);
            }
        };
        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public static PathTranslation valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PathTranslation forNumber(int i) {
            if (i == 0) {
                return PATH_TRANSLATION_UNSPECIFIED;
            }
            if (i == 1) {
                return CONSTANT_ADDRESS;
            }
            if (i != 2) {
                return null;
            }
            return APPEND_PATH_TO_ADDRESS;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumLiteMap<PathTranslation> internalGetValueMap() {
            return internalValueMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumVerifier internalGetVerifier() {
            return PathTranslationVerifier.INSTANCE;
        }

        private static final class PathTranslationVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PathTranslationVerifier();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private PathTranslationVerifier() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PathTranslation.forNumber(i) != null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PathTranslation(int i) {
            this.value = i;
        }
    }

    public enum AuthenticationCase {
        JWT_AUDIENCE(7),
        DISABLE_AUTH(8),
        AUTHENTICATION_NOT_SET(0);

        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AuthenticationCase(int i) {
            this.value = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public static AuthenticationCase valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AuthenticationCase forNumber(int i) {
            if (i == 0) {
                return AUTHENTICATION_NOT_SET;
            }
            if (i == 7) {
                return JWT_AUDIENCE;
            }
            if (i != 8) {
                return null;
            }
            return DISABLE_AUTH;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getNumber() {
            return this.value;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public AuthenticationCase getAuthenticationCase() {
        return AuthenticationCase.forNumber(this.authenticationCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAuthentication() {
        this.authenticationCase_ = 0;
        this.authentication_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
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
    @Override // com.google.api.BackendRuleOrBuilder
    public String getAddress() {
        return this.address_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getAddressBytes() {
        return ByteString.copyFromUtf8(this.address_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAddressBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.address_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public double getDeadline() {
        return this.deadline_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDeadline(double d) {
        this.deadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDeadline() {
        this.deadline_ = 0.0d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public double getMinDeadline() {
        return this.minDeadline_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMinDeadline(double d) {
        this.minDeadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMinDeadline() {
        this.minDeadline_ = 0.0d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public double getOperationDeadline() {
        return this.operationDeadline_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOperationDeadline(double d) {
        this.operationDeadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearOperationDeadline() {
        this.operationDeadline_ = 0.0d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public int getPathTranslationValue() {
        return this.pathTranslation_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public PathTranslation getPathTranslation() {
        PathTranslation forNumber = PathTranslation.forNumber(this.pathTranslation_);
        return forNumber == null ? PathTranslation.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPathTranslationValue(int i) {
        this.pathTranslation_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPathTranslation(PathTranslation pathTranslation) {
        this.pathTranslation_ = pathTranslation.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearPathTranslation() {
        this.pathTranslation_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public String getJwtAudience() {
        return this.authenticationCase_ == 7 ? (String) this.authentication_ : "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getJwtAudienceBytes() {
        return ByteString.copyFromUtf8(this.authenticationCase_ == 7 ? (String) this.authentication_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setJwtAudience(String str) {
        str.getClass();
        this.authenticationCase_ = 7;
        this.authentication_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearJwtAudience() {
        if (this.authenticationCase_ == 7) {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setJwtAudienceBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.authentication_ = byteString.toStringUtf8();
        this.authenticationCase_ = 7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public boolean getDisableAuth() {
        if (this.authenticationCase_ == 8) {
            return ((Boolean) this.authentication_).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDisableAuth(boolean z) {
        this.authenticationCase_ = 8;
        this.authentication_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDisableAuth() {
        if (this.authenticationCase_ == 8) {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public String getProtocol() {
        return this.protocol_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProtocol(String str) {
        str.getClass();
        this.protocol_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearProtocol() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProtocolBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.protocol_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(InputStream inputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BackendRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(BackendRule backendRule) {
        return DEFAULT_INSTANCE.createBuilder(backendRule);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C11961 c11961) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(BackendRule.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public AuthenticationCase getAuthenticationCase() {
            return ((BackendRule) this.instance).getAuthenticationCase();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAuthentication() {
            copyOnWrite();
            ((BackendRule) this.instance).clearAuthentication();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public String getSelector() {
            return ((BackendRule) this.instance).getSelector();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((BackendRule) this.instance).getSelectorBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelector(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setSelector(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSelector() {
            copyOnWrite();
            ((BackendRule) this.instance).clearSelector();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public String getAddress() {
            return ((BackendRule) this.instance).getAddress();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getAddressBytes() {
            return ((BackendRule) this.instance).getAddressBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAddress(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setAddress(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAddress() {
            copyOnWrite();
            ((BackendRule) this.instance).clearAddress();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAddressBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setAddressBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public double getDeadline() {
            return ((BackendRule) this.instance).getDeadline();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDeadline(double d) {
            copyOnWrite();
            ((BackendRule) this.instance).setDeadline(d);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearDeadline();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public double getMinDeadline() {
            return ((BackendRule) this.instance).getMinDeadline();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMinDeadline(double d) {
            copyOnWrite();
            ((BackendRule) this.instance).setMinDeadline(d);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMinDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearMinDeadline();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public double getOperationDeadline() {
            return ((BackendRule) this.instance).getOperationDeadline();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOperationDeadline(double d) {
            copyOnWrite();
            ((BackendRule) this.instance).setOperationDeadline(d);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearOperationDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearOperationDeadline();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public int getPathTranslationValue() {
            return ((BackendRule) this.instance).getPathTranslationValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPathTranslationValue(int i) {
            copyOnWrite();
            ((BackendRule) this.instance).setPathTranslationValue(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public PathTranslation getPathTranslation() {
            return ((BackendRule) this.instance).getPathTranslation();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPathTranslation(PathTranslation pathTranslation) {
            copyOnWrite();
            ((BackendRule) this.instance).setPathTranslation(pathTranslation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearPathTranslation() {
            copyOnWrite();
            ((BackendRule) this.instance).clearPathTranslation();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public String getJwtAudience() {
            return ((BackendRule) this.instance).getJwtAudience();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getJwtAudienceBytes() {
            return ((BackendRule) this.instance).getJwtAudienceBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setJwtAudience(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setJwtAudience(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearJwtAudience() {
            copyOnWrite();
            ((BackendRule) this.instance).clearJwtAudience();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setJwtAudienceBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setJwtAudienceBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public boolean getDisableAuth() {
            return ((BackendRule) this.instance).getDisableAuth();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDisableAuth(boolean z) {
            copyOnWrite();
            ((BackendRule) this.instance).setDisableAuth(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDisableAuth() {
            copyOnWrite();
            ((BackendRule) this.instance).clearDisableAuth();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public String getProtocol() {
            return ((BackendRule) this.instance).getProtocol();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getProtocolBytes() {
            return ((BackendRule) this.instance).getProtocolBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProtocol(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setProtocol(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearProtocol() {
            copyOnWrite();
            ((BackendRule) this.instance).clearProtocol();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProtocolBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setProtocolBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.BackendRule$1 */
    static /* synthetic */ class C11961 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f290xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f290xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f290xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f290xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f290xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f290xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f290xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f290xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C11961 c11961 = null;
        switch (C11961.f290xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new BackendRule();
            case 2:
                return new Builder(c11961);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0000\u0004\u0000\u0005\u0000\u0006\f\u0007Ȼ\u0000\b:\u0000\tȈ", new Object[]{"authentication_", "authenticationCase_", "selector_", "address_", "deadline_", "minDeadline_", "operationDeadline_", "pathTranslation_", "protocol_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BackendRule> parser = PARSER;
                if (parser == null) {
                    synchronized (BackendRule.class) {
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
        BackendRule backendRule = new BackendRule();
        DEFAULT_INSTANCE = backendRule;
        GeneratedMessageLite.registerDefaultInstance(BackendRule.class, backendRule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<BackendRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
