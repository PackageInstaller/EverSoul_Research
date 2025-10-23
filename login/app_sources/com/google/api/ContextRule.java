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
public final class ContextRule extends GeneratedMessageLite<ContextRule, Builder> implements ContextRuleOrBuilder {
    public static final int ALLOWED_REQUEST_EXTENSIONS_FIELD_NUMBER = 4;
    public static final int ALLOWED_RESPONSE_EXTENSIONS_FIELD_NUMBER = 5;
    private static final ContextRule DEFAULT_INSTANCE;
    private static volatile Parser<ContextRule> PARSER = null;
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private String selector_ = "";
    private Internal.ProtobufList<String> requested_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> provided_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> allowedRequestExtensions_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> allowedResponseExtensions_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ContextRule() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
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
    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getRequestedList() {
        return this.requested_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public int getRequestedCount() {
        return this.requested_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public String getRequested(int i) {
        return this.requested_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getRequestedBytes(int i) {
        return ByteString.copyFromUtf8(this.requested_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureRequestedIsMutable() {
        Internal.ProtobufList<String> protobufList = this.requested_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.requested_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequested(int i, String str) {
        str.getClass();
        ensureRequestedIsMutable();
        this.requested_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRequested(String str) {
        str.getClass();
        ensureRequestedIsMutable();
        this.requested_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllRequested(Iterable<String> iterable) {
        ensureRequestedIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.requested_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRequested() {
        this.requested_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRequestedBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureRequestedIsMutable();
        this.requested_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getProvidedList() {
        return this.provided_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public int getProvidedCount() {
        return this.provided_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public String getProvided(int i) {
        return this.provided_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getProvidedBytes(int i) {
        return ByteString.copyFromUtf8(this.provided_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureProvidedIsMutable() {
        Internal.ProtobufList<String> protobufList = this.provided_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.provided_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProvided(int i, String str) {
        str.getClass();
        ensureProvidedIsMutable();
        this.provided_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProvided(String str) {
        str.getClass();
        ensureProvidedIsMutable();
        this.provided_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllProvided(Iterable<String> iterable) {
        ensureProvidedIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.provided_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearProvided() {
        this.provided_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProvidedBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureProvidedIsMutable();
        this.provided_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getAllowedRequestExtensionsList() {
        return this.allowedRequestExtensions_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedRequestExtensionsCount() {
        return this.allowedRequestExtensions_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedRequestExtensions(int i) {
        return this.allowedRequestExtensions_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedRequestExtensionsBytes(int i) {
        return ByteString.copyFromUtf8(this.allowedRequestExtensions_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureAllowedRequestExtensionsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.allowedRequestExtensions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.allowedRequestExtensions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowedRequestExtensions(int i, String str) {
        str.getClass();
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllowedRequestExtensions(String str) {
        str.getClass();
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllAllowedRequestExtensions(Iterable<String> iterable) {
        ensureAllowedRequestExtensionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.allowedRequestExtensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAllowedRequestExtensions() {
        this.allowedRequestExtensions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllowedRequestExtensionsBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getAllowedResponseExtensionsList() {
        return this.allowedResponseExtensions_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedResponseExtensionsCount() {
        return this.allowedResponseExtensions_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedResponseExtensions(int i) {
        return this.allowedResponseExtensions_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedResponseExtensionsBytes(int i) {
        return ByteString.copyFromUtf8(this.allowedResponseExtensions_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureAllowedResponseExtensionsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.allowedResponseExtensions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.allowedResponseExtensions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowedResponseExtensions(int i, String str) {
        str.getClass();
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllowedResponseExtensions(String str) {
        str.getClass();
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllAllowedResponseExtensions(Iterable<String> iterable) {
        ensureAllowedResponseExtensionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.allowedResponseExtensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAllowedResponseExtensions() {
        this.allowedResponseExtensions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllowedResponseExtensionsBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ContextRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(ContextRule contextRule) {
        return DEFAULT_INSTANCE.createBuilder(contextRule);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12021 c12021) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(ContextRule.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public String getSelector() {
            return ((ContextRule) this.instance).getSelector();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((ContextRule) this.instance).getSelectorBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelector(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setSelector(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSelector() {
            copyOnWrite();
            ((ContextRule) this.instance).clearSelector();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getRequestedList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getRequestedList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public int getRequestedCount() {
            return ((ContextRule) this.instance).getRequestedCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public String getRequested(int i) {
            return ((ContextRule) this.instance).getRequested(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getRequestedBytes(int i) {
            return ((ContextRule) this.instance).getRequestedBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRequested(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setRequested(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRequested(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addRequested(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllRequested(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllRequested(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRequested() {
            copyOnWrite();
            ((ContextRule) this.instance).clearRequested();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRequestedBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addRequestedBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getProvidedList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getProvidedList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public int getProvidedCount() {
            return ((ContextRule) this.instance).getProvidedCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public String getProvided(int i) {
            return ((ContextRule) this.instance).getProvided(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getProvidedBytes(int i) {
            return ((ContextRule) this.instance).getProvidedBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProvided(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setProvided(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProvided(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addProvided(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllProvided(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllProvided(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearProvided() {
            copyOnWrite();
            ((ContextRule) this.instance).clearProvided();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProvidedBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addProvidedBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getAllowedRequestExtensionsList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getAllowedRequestExtensionsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedRequestExtensionsCount() {
            return ((ContextRule) this.instance).getAllowedRequestExtensionsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedRequestExtensions(int i) {
            return ((ContextRule) this.instance).getAllowedRequestExtensions(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedRequestExtensionsBytes(int i) {
            return ((ContextRule) this.instance).getAllowedRequestExtensionsBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllowedRequestExtensions(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setAllowedRequestExtensions(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllowedRequestExtensions(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedRequestExtensions(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllAllowedRequestExtensions(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllAllowedRequestExtensions(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAllowedRequestExtensions() {
            copyOnWrite();
            ((ContextRule) this.instance).clearAllowedRequestExtensions();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllowedRequestExtensionsBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedRequestExtensionsBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getAllowedResponseExtensionsList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getAllowedResponseExtensionsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedResponseExtensionsCount() {
            return ((ContextRule) this.instance).getAllowedResponseExtensionsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedResponseExtensions(int i) {
            return ((ContextRule) this.instance).getAllowedResponseExtensions(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedResponseExtensionsBytes(int i) {
            return ((ContextRule) this.instance).getAllowedResponseExtensionsBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllowedResponseExtensions(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setAllowedResponseExtensions(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllowedResponseExtensions(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedResponseExtensions(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllAllowedResponseExtensions(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllAllowedResponseExtensions(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAllowedResponseExtensions() {
            copyOnWrite();
            ((ContextRule) this.instance).clearAllowedResponseExtensions();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllowedResponseExtensionsBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedResponseExtensionsBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.ContextRule$1 */
    static /* synthetic */ class C12021 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f294xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f294xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f294xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f294xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f294xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f294xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f294xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f294xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12021 c12021 = null;
        switch (C12021.f294xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ContextRule();
            case 2:
                return new Builder(c12021);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0004\u0000\u0001Ȉ\u0002Ț\u0003Ț\u0004Ț\u0005Ț", new Object[]{"selector_", "requested_", "provided_", "allowedRequestExtensions_", "allowedResponseExtensions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ContextRule> parser = PARSER;
                if (parser == null) {
                    synchronized (ContextRule.class) {
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
        ContextRule contextRule = new ContextRule();
        DEFAULT_INSTANCE = contextRule;
        GeneratedMessageLite.registerDefaultInstance(ContextRule.class, contextRule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<ContextRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
