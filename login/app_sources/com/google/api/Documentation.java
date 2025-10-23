package com.google.api;

import com.google.api.DocumentationRule;
import com.google.api.Page;
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
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {
    private static final Documentation DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    private static volatile Parser<Documentation> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private String summary_ = "";
    private Internal.ProtobufList<Page> pages_ = emptyProtobufList();
    private Internal.ProtobufList<DocumentationRule> rules_ = emptyProtobufList();
    private String documentationRootUrl_ = "";
    private String overview_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Documentation() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public String getSummary() {
        return this.summary_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getSummaryBytes() {
        return ByteString.copyFromUtf8(this.summary_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSummary(String str) {
        str.getClass();
        this.summary_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSummaryBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.summary_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public List<Page> getPagesList() {
        return this.pages_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public int getPagesCount() {
        return this.pages_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public Page getPages(int i) {
        return this.pages_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PageOrBuilder getPagesOrBuilder(int i) {
        return this.pages_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensurePagesIsMutable() {
        Internal.ProtobufList<Page> protobufList = this.pages_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.pages_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPages(int i, Page page) {
        page.getClass();
        ensurePagesIsMutable();
        this.pages_.set(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addPages(Page page) {
        page.getClass();
        ensurePagesIsMutable();
        this.pages_.add(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addPages(int i, Page page) {
        page.getClass();
        ensurePagesIsMutable();
        this.pages_.add(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllPages(Iterable<? extends Page> iterable) {
        ensurePagesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearPages() {
        this.pages_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removePages(int i) {
        ensurePagesIsMutable();
        this.pages_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public DocumentationRule getRules(int i) {
        return this.rules_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DocumentationRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureRulesIsMutable() {
        Internal.ProtobufList<DocumentationRule> protobufList = this.rules_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRules(int i, DocumentationRule documentationRule) {
        documentationRule.getClass();
        ensureRulesIsMutable();
        this.rules_.set(i, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRules(DocumentationRule documentationRule) {
        documentationRule.getClass();
        ensureRulesIsMutable();
        this.rules_.add(documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRules(int i, DocumentationRule documentationRule) {
        documentationRule.getClass();
        ensureRulesIsMutable();
        this.rules_.add(i, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllRules(Iterable<? extends DocumentationRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public String getDocumentationRootUrl() {
        return this.documentationRootUrl_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getDocumentationRootUrlBytes() {
        return ByteString.copyFromUtf8(this.documentationRootUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDocumentationRootUrl(String str) {
        str.getClass();
        this.documentationRootUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDocumentationRootUrl() {
        this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDocumentationRootUrlBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.documentationRootUrl_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public String getOverview() {
        return this.overview_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getOverviewBytes() {
        return ByteString.copyFromUtf8(this.overview_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOverview(String str) {
        str.getClass();
        this.overview_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearOverview() {
        this.overview_ = getDefaultInstance().getOverview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOverviewBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.overview_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Documentation documentation) {
        return DEFAULT_INSTANCE.createBuilder(documentation);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12061 c12061) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Documentation.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public String getSummary() {
            return ((Documentation) this.instance).getSummary();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getSummaryBytes() {
            return ((Documentation) this.instance).getSummaryBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSummary(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setSummary(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSummary() {
            copyOnWrite();
            ((Documentation) this.instance).clearSummary();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSummaryBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setSummaryBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public List<Page> getPagesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getPagesList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public int getPagesCount() {
            return ((Documentation) this.instance).getPagesCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public Page getPages(int i) {
            return ((Documentation) this.instance).getPages(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPages(int i, Page page) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(i, page);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPages(int i, Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addPages(Page page) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(page);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addPages(int i, Page page) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(i, page);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addPages(Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addPages(int i, Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllPages(Iterable<? extends Page> iterable) {
            copyOnWrite();
            ((Documentation) this.instance).addAllPages(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearPages() {
            copyOnWrite();
            ((Documentation) this.instance).clearPages();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removePages(int i) {
            copyOnWrite();
            ((Documentation) this.instance).removePages(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public List<DocumentationRule> getRulesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getRulesList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public int getRulesCount() {
            return ((Documentation) this.instance).getRulesCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public DocumentationRule getRules(int i) {
            return ((Documentation) this.instance).getRules(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRules(int i, DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(i, documentationRule);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRules(int i, DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRules(DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(documentationRule);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRules(int i, DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(i, documentationRule);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRules(DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addRules(int i, DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllRules(Iterable<? extends DocumentationRule> iterable) {
            copyOnWrite();
            ((Documentation) this.instance).addAllRules(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRules() {
            copyOnWrite();
            ((Documentation) this.instance).clearRules();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeRules(int i) {
            copyOnWrite();
            ((Documentation) this.instance).removeRules(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public String getDocumentationRootUrl() {
            return ((Documentation) this.instance).getDocumentationRootUrl();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getDocumentationRootUrlBytes() {
            return ((Documentation) this.instance).getDocumentationRootUrlBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDocumentationRootUrl(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrl(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDocumentationRootUrl() {
            copyOnWrite();
            ((Documentation) this.instance).clearDocumentationRootUrl();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDocumentationRootUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrlBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public String getOverview() {
            return ((Documentation) this.instance).getOverview();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getOverviewBytes() {
            return ((Documentation) this.instance).getOverviewBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOverview(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setOverview(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearOverview() {
            copyOnWrite();
            ((Documentation) this.instance).clearOverview();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOverviewBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setOverviewBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.Documentation$1 */
    static /* synthetic */ class C12061 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f298xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f298xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f298xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f298xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f298xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f298xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f298xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f298xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12061 c12061 = null;
        switch (C12061.f298xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Documentation();
            case 2:
                return new Builder(c12061);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004Ȉ\u0005\u001b", new Object[]{"summary_", "overview_", "rules_", DocumentationRule.class, "documentationRootUrl_", "pages_", Page.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Documentation> parser = PARSER;
                if (parser == null) {
                    synchronized (Documentation.class) {
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
        Documentation documentation = new Documentation();
        DEFAULT_INSTANCE = documentation;
        GeneratedMessageLite.registerDefaultInstance(Documentation.class, documentation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Documentation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
