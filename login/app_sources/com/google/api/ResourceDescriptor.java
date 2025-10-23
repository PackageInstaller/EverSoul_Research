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
public final class ResourceDescriptor extends GeneratedMessageLite<ResourceDescriptor, Builder> implements ResourceDescriptorOrBuilder {
    private static final ResourceDescriptor DEFAULT_INSTANCE;
    public static final int HISTORY_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_FIELD_NUMBER = 3;
    private static volatile Parser<ResourceDescriptor> PARSER = null;
    public static final int PATTERN_FIELD_NUMBER = 2;
    public static final int PLURAL_FIELD_NUMBER = 5;
    public static final int SINGULAR_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int history_;
    private String type_ = "";
    private Internal.ProtobufList<String> pattern_ = GeneratedMessageLite.emptyProtobufList();
    private String nameField_ = "";
    private String plural_ = "";
    private String singular_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ResourceDescriptor() {
    }

    public enum History implements Internal.EnumLite {
        HISTORY_UNSPECIFIED(0),
        ORIGINALLY_SINGLE_PATTERN(1),
        FUTURE_MULTI_PATTERN(2),
        UNRECOGNIZED(-1);

        public static final int FUTURE_MULTI_PATTERN_VALUE = 2;
        public static final int HISTORY_UNSPECIFIED_VALUE = 0;
        public static final int ORIGINALLY_SINGLE_PATTERN_VALUE = 1;
        private static final Internal.EnumLiteMap<History> internalValueMap = new Internal.EnumLiteMap<History>() { // from class: com.google.api.ResourceDescriptor.History.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public History findValueByNumber(int i) {
                return History.forNumber(i);
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
        public static History valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static History forNumber(int i) {
            if (i == 0) {
                return HISTORY_UNSPECIFIED;
            }
            if (i == 1) {
                return ORIGINALLY_SINGLE_PATTERN;
            }
            if (i != 2) {
                return null;
            }
            return FUTURE_MULTI_PATTERN;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumLiteMap<History> internalGetValueMap() {
            return internalValueMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumVerifier internalGetVerifier() {
            return HistoryVerifier.INSTANCE;
        }

        private static final class HistoryVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new HistoryVerifier();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private HistoryVerifier() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return History.forNumber(i) != null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        History(int i) {
            this.value = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTypeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public List<String> getPatternList() {
        return this.pattern_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getPatternCount() {
        return this.pattern_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getPattern(int i) {
        return this.pattern_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getPatternBytes(int i) {
        return ByteString.copyFromUtf8(this.pattern_.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensurePatternIsMutable() {
        Internal.ProtobufList<String> protobufList = this.pattern_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.pattern_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPattern(int i, String str) {
        str.getClass();
        ensurePatternIsMutable();
        this.pattern_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addPattern(String str) {
        str.getClass();
        ensurePatternIsMutable();
        this.pattern_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllPattern(Iterable<String> iterable) {
        ensurePatternIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pattern_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearPattern() {
        this.pattern_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addPatternBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensurePatternIsMutable();
        this.pattern_.add(byteString.toStringUtf8());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getNameField() {
        return this.nameField_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getNameFieldBytes() {
        return ByteString.copyFromUtf8(this.nameField_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNameField(String str) {
        str.getClass();
        this.nameField_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearNameField() {
        this.nameField_ = getDefaultInstance().getNameField();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNameFieldBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.nameField_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getHistoryValue() {
        return this.history_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public History getHistory() {
        History forNumber = History.forNumber(this.history_);
        return forNumber == null ? History.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHistoryValue(int i) {
        this.history_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHistory(History history) {
        this.history_ = history.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearHistory() {
        this.history_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getPlural() {
        return this.plural_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getPluralBytes() {
        return ByteString.copyFromUtf8(this.plural_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPlural(String str) {
        str.getClass();
        this.plural_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearPlural() {
        this.plural_ = getDefaultInstance().getPlural();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPluralBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.plural_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getSingular() {
        return this.singular_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getSingularBytes() {
        return ByteString.copyFromUtf8(this.singular_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingular(String str) {
        str.getClass();
        this.singular_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSingular() {
        this.singular_ = getDefaultInstance().getSingular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingularBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.singular_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(ResourceDescriptor resourceDescriptor) {
        return DEFAULT_INSTANCE.createBuilder(resourceDescriptor);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ResourceDescriptor, Builder> implements ResourceDescriptorOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12351 c12351) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(ResourceDescriptor.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getType() {
            return ((ResourceDescriptor) this.instance).getType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((ResourceDescriptor) this.instance).getTypeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setType(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setType(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearType() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearType();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setTypeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public List<String> getPatternList() {
            return Collections.unmodifiableList(((ResourceDescriptor) this.instance).getPatternList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getPatternCount() {
            return ((ResourceDescriptor) this.instance).getPatternCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getPattern(int i) {
            return ((ResourceDescriptor) this.instance).getPattern(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getPatternBytes(int i) {
            return ((ResourceDescriptor) this.instance).getPatternBytes(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPattern(int i, String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setPattern(i, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addPattern(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).addPattern(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllPattern(Iterable<String> iterable) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).addAllPattern(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearPattern() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearPattern();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addPatternBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).addPatternBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getNameField() {
            return ((ResourceDescriptor) this.instance).getNameField();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getNameFieldBytes() {
            return ((ResourceDescriptor) this.instance).getNameFieldBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameField(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setNameField(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearNameField() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearNameField();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameFieldBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setNameFieldBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getHistoryValue() {
            return ((ResourceDescriptor) this.instance).getHistoryValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setHistoryValue(int i) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setHistoryValue(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public History getHistory() {
            return ((ResourceDescriptor) this.instance).getHistory();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setHistory(History history) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setHistory(history);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearHistory() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearHistory();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getPlural() {
            return ((ResourceDescriptor) this.instance).getPlural();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getPluralBytes() {
            return ((ResourceDescriptor) this.instance).getPluralBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPlural(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setPlural(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearPlural() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearPlural();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPluralBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setPluralBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getSingular() {
            return ((ResourceDescriptor) this.instance).getSingular();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getSingularBytes() {
            return ((ResourceDescriptor) this.instance).getSingularBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSingular(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setSingular(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSingular() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearSingular();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSingularBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setSingularBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.ResourceDescriptor$1 */
    static /* synthetic */ class C12351 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f322xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f322xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f322xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f322xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f322xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f322xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f322xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f322xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12351 c12351 = null;
        switch (C12351.f322xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ResourceDescriptor();
            case 2:
                return new Builder(c12351);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003Ȉ\u0004\f\u0005Ȉ\u0006Ȉ", new Object[]{"type_", "pattern_", "nameField_", "history_", "plural_", "singular_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ResourceDescriptor> parser = PARSER;
                if (parser == null) {
                    synchronized (ResourceDescriptor.class) {
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
        ResourceDescriptor resourceDescriptor = new ResourceDescriptor();
        DEFAULT_INSTANCE = resourceDescriptor;
        GeneratedMessageLite.registerDefaultInstance(ResourceDescriptor.class, resourceDescriptor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<ResourceDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
