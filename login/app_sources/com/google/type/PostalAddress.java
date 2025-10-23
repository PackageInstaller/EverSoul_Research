package com.google.type;

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

/* loaded from: classes3.dex */
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    private static final PostalAddress DEFAULT_INSTANCE;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    private static volatile Parser<PostalAddress> PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private int revision_;
    private String regionCode_ = "";
    private String languageCode_ = "";
    private String postalCode_ = "";
    private String sortingCode_ = "";
    private String administrativeArea_ = "";
    private String locality_ = "";
    private String sublocality_ = "";
    private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.emptyProtobufList();
    private String organization_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PostalAddress() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public int getRevision() {
        return this.revision_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRevision(int i) {
        this.revision_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRevision() {
        this.revision_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getRegionCode() {
        return this.regionCode_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRegionCodeBytes() {
        return ByteString.copyFromUtf8(this.regionCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRegionCode(String str) {
        str.getClass();
        this.regionCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRegionCode() {
        this.regionCode_ = getDefaultInstance().getRegionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRegionCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.regionCode_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getLanguageCode() {
        return this.languageCode_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLanguageCodeBytes() {
        return ByteString.copyFromUtf8(this.languageCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLanguageCode(String str) {
        str.getClass();
        this.languageCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearLanguageCode() {
        this.languageCode_ = getDefaultInstance().getLanguageCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLanguageCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.languageCode_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getPostalCode() {
        return this.postalCode_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getPostalCodeBytes() {
        return ByteString.copyFromUtf8(this.postalCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPostalCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.postalCode_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getSortingCode() {
        return this.sortingCode_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSortingCodeBytes() {
        return ByteString.copyFromUtf8(this.sortingCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSortingCode(String str) {
        str.getClass();
        this.sortingCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSortingCode() {
        this.sortingCode_ = getDefaultInstance().getSortingCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSortingCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.sortingCode_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getAdministrativeArea() {
        return this.administrativeArea_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAdministrativeAreaBytes() {
        return ByteString.copyFromUtf8(this.administrativeArea_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAdministrativeArea(String str) {
        str.getClass();
        this.administrativeArea_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAdministrativeArea() {
        this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAdministrativeAreaBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.administrativeArea_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getLocality() {
        return this.locality_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLocalityBytes() {
        return ByteString.copyFromUtf8(this.locality_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLocality(String str) {
        str.getClass();
        this.locality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearLocality() {
        this.locality_ = getDefaultInstance().getLocality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLocalityBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.locality_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getSublocality() {
        return this.sublocality_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSublocalityBytes() {
        return ByteString.copyFromUtf8(this.sublocality_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSublocality(String str) {
        str.getClass();
        this.sublocality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSublocality() {
        this.sublocality_ = getDefaultInstance().getSublocality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSublocalityBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.sublocality_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public List<String> getAddressLinesList() {
        return this.addressLines_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getAddressLines(int i) {
        return this.addressLines_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAddressLinesBytes(int i) {
        return ByteString.copyFromUtf8(this.addressLines_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureAddressLinesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.addressLines_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.addressLines_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAddressLines(int i, String str) {
        str.getClass();
        ensureAddressLinesIsMutable();
        this.addressLines_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAddressLines(String str) {
        str.getClass();
        ensureAddressLinesIsMutable();
        this.addressLines_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllAddressLines(Iterable<String> iterable) {
        ensureAddressLinesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.addressLines_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAddressLines() {
        this.addressLines_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAddressLinesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAddressLinesIsMutable();
        this.addressLines_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public List<String> getRecipientsList() {
        return this.recipients_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getRecipients(int i) {
        return this.recipients_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRecipientsBytes(int i) {
        return ByteString.copyFromUtf8(this.recipients_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureRecipientsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.recipients_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.recipients_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRecipients(int i, String str) {
        str.getClass();
        ensureRecipientsIsMutable();
        this.recipients_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRecipients(String str) {
        str.getClass();
        ensureRecipientsIsMutable();
        this.recipients_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllRecipients(Iterable<String> iterable) {
        ensureRecipientsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.recipients_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRecipients() {
        this.recipients_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRecipientsBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureRecipientsIsMutable();
        this.recipients_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public String getOrganization() {
        return this.organization_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getOrganizationBytes() {
        return ByteString.copyFromUtf8(this.organization_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOrganization(String str) {
        str.getClass();
        this.organization_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearOrganization() {
        this.organization_ = getDefaultInstance().getOrganization();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOrganizationBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.organization_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(PostalAddress postalAddress) {
        return DEFAULT_INSTANCE.createBuilder(postalAddress);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C20841 c20841) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(PostalAddress.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public int getRevision() {
            return ((PostalAddress) this.instance).getRevision();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRevision(int i) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRevision(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRevision() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRevision();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getRegionCode() {
            return ((PostalAddress) this.instance).getRegionCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRegionCodeBytes() {
            return ((PostalAddress) this.instance).getRegionCodeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRegionCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCode(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRegionCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRegionCode();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRegionCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCodeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getLanguageCode() {
            return ((PostalAddress) this.instance).getLanguageCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLanguageCodeBytes() {
            return ((PostalAddress) this.instance).getLanguageCodeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLanguageCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCode(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearLanguageCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLanguageCode();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLanguageCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCodeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getPostalCode() {
            return ((PostalAddress) this.instance).getPostalCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getPostalCodeBytes() {
            return ((PostalAddress) this.instance).getPostalCodeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPostalCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCode(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearPostalCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearPostalCode();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPostalCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCodeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getSortingCode() {
            return ((PostalAddress) this.instance).getSortingCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSortingCodeBytes() {
            return ((PostalAddress) this.instance).getSortingCodeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSortingCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCode(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSortingCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSortingCode();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSortingCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCodeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getAdministrativeArea() {
            return ((PostalAddress) this.instance).getAdministrativeArea();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAdministrativeAreaBytes() {
            return ((PostalAddress) this.instance).getAdministrativeAreaBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAdministrativeArea(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeArea(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAdministrativeArea() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAdministrativeArea();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAdministrativeAreaBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeAreaBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getLocality() {
            return ((PostalAddress) this.instance).getLocality();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLocalityBytes() {
            return ((PostalAddress) this.instance).getLocalityBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLocality(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocality(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearLocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLocality();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLocalityBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocalityBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getSublocality() {
            return ((PostalAddress) this.instance).getSublocality();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSublocalityBytes() {
            return ((PostalAddress) this.instance).getSublocalityBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSublocality(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocality(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSublocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSublocality();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSublocalityBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocalityBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public List<String> getAddressLinesList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getAddressLinesList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public int getAddressLinesCount() {
            return ((PostalAddress) this.instance).getAddressLinesCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getAddressLines(int i) {
            return ((PostalAddress) this.instance).getAddressLines(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAddressLinesBytes(int i) {
            return ((PostalAddress) this.instance).getAddressLinesBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAddressLines(int i, String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAddressLines(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAddressLines(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLines(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllAddressLines(Iterable<String> iterable) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllAddressLines(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAddressLines() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAddressLines();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAddressLinesBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLinesBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public List<String> getRecipientsList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getRecipientsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public int getRecipientsCount() {
            return ((PostalAddress) this.instance).getRecipientsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getRecipients(int i) {
            return ((PostalAddress) this.instance).getRecipients(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRecipientsBytes(int i) {
            return ((PostalAddress) this.instance).getRecipientsBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRecipients(int i, String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRecipients(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRecipients(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipients(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllRecipients(Iterable<String> iterable) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllRecipients(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRecipients() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRecipients();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRecipientsBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipientsBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public String getOrganization() {
            return ((PostalAddress) this.instance).getOrganization();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getOrganizationBytes() {
            return ((PostalAddress) this.instance).getOrganizationBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOrganization(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganization(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearOrganization() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearOrganization();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOrganizationBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganizationBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.type.PostalAddress$1 */
    static /* synthetic */ class C20841 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f514xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f514xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f514xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f514xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f514xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f514xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f514xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f514xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C20841 c20841 = null;
        switch (C20841.f514xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new PostalAddress();
            case 2:
                return new Builder(c20841);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0002\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȚ\nȚ\u000bȈ", new Object[]{"revision_", "regionCode_", "languageCode_", "postalCode_", "sortingCode_", "administrativeArea_", "locality_", "sublocality_", "addressLines_", "recipients_", "organization_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PostalAddress> parser = PARSER;
                if (parser == null) {
                    synchronized (PostalAddress.class) {
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
        PostalAddress postalAddress = new PostalAddress();
        DEFAULT_INSTANCE = postalAddress;
        GeneratedMessageLite.registerDefaultInstance(PostalAddress.class, postalAddress);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<PostalAddress> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
