package com.google.api;

import com.google.api.Advice;
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
public final class ConfigChange extends GeneratedMessageLite<ConfigChange, Builder> implements ConfigChangeOrBuilder {
    public static final int ADVICES_FIELD_NUMBER = 5;
    public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
    private static final ConfigChange DEFAULT_INSTANCE;
    public static final int ELEMENT_FIELD_NUMBER = 1;
    public static final int NEW_VALUE_FIELD_NUMBER = 3;
    public static final int OLD_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<ConfigChange> PARSER;
    private int changeType_;
    private String element_ = "";
    private String oldValue_ = "";
    private String newValue_ = "";
    private Internal.ProtobufList<Advice> advices_ = emptyProtobufList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConfigChange() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public String getElement() {
        return this.element_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getElementBytes() {
        return ByteString.copyFromUtf8(this.element_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setElement(String str) {
        str.getClass();
        this.element_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearElement() {
        this.element_ = getDefaultInstance().getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setElementBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.element_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public String getOldValue() {
        return this.oldValue_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getOldValueBytes() {
        return ByteString.copyFromUtf8(this.oldValue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOldValue(String str) {
        str.getClass();
        this.oldValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearOldValue() {
        this.oldValue_ = getDefaultInstance().getOldValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOldValueBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.oldValue_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public String getNewValue() {
        return this.newValue_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getNewValueBytes() {
        return ByteString.copyFromUtf8(this.newValue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNewValue(String str) {
        str.getClass();
        this.newValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearNewValue() {
        this.newValue_ = getDefaultInstance().getNewValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNewValueBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.newValue_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public int getChangeTypeValue() {
        return this.changeType_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public ChangeType getChangeType() {
        ChangeType forNumber = ChangeType.forNumber(this.changeType_);
        return forNumber == null ? ChangeType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChangeTypeValue(int i) {
        this.changeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChangeType(ChangeType changeType) {
        this.changeType_ = changeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearChangeType() {
        this.changeType_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public List<Advice> getAdvicesList() {
        return this.advices_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
        return this.advices_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public int getAdvicesCount() {
        return this.advices_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.ConfigChangeOrBuilder
    public Advice getAdvices(int i) {
        return this.advices_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AdviceOrBuilder getAdvicesOrBuilder(int i) {
        return this.advices_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureAdvicesIsMutable() {
        Internal.ProtobufList<Advice> protobufList = this.advices_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.advices_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAdvices(int i, Advice advice) {
        advice.getClass();
        ensureAdvicesIsMutable();
        this.advices_.set(i, advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAdvices(Advice advice) {
        advice.getClass();
        ensureAdvicesIsMutable();
        this.advices_.add(advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAdvices(int i, Advice advice) {
        advice.getClass();
        ensureAdvicesIsMutable();
        this.advices_.add(i, advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllAdvices(Iterable<? extends Advice> iterable) {
        ensureAdvicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.advices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearAdvices() {
        this.advices_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeAdvices(int i) {
        ensureAdvicesIsMutable();
        this.advices_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(InputStream inputStream) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ConfigChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(ConfigChange configChange) {
        return DEFAULT_INSTANCE.createBuilder(configChange);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ConfigChange, Builder> implements ConfigChangeOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12001 c12001) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(ConfigChange.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public String getElement() {
            return ((ConfigChange) this.instance).getElement();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getElementBytes() {
            return ((ConfigChange) this.instance).getElementBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setElement(String str) {
            copyOnWrite();
            ((ConfigChange) this.instance).setElement(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearElement() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearElement();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setElementBytes(ByteString byteString) {
            copyOnWrite();
            ((ConfigChange) this.instance).setElementBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public String getOldValue() {
            return ((ConfigChange) this.instance).getOldValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getOldValueBytes() {
            return ((ConfigChange) this.instance).getOldValueBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOldValue(String str) {
            copyOnWrite();
            ((ConfigChange) this.instance).setOldValue(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearOldValue() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearOldValue();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOldValueBytes(ByteString byteString) {
            copyOnWrite();
            ((ConfigChange) this.instance).setOldValueBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public String getNewValue() {
            return ((ConfigChange) this.instance).getNewValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getNewValueBytes() {
            return ((ConfigChange) this.instance).getNewValueBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNewValue(String str) {
            copyOnWrite();
            ((ConfigChange) this.instance).setNewValue(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearNewValue() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearNewValue();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNewValueBytes(ByteString byteString) {
            copyOnWrite();
            ((ConfigChange) this.instance).setNewValueBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public int getChangeTypeValue() {
            return ((ConfigChange) this.instance).getChangeTypeValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setChangeTypeValue(int i) {
            copyOnWrite();
            ((ConfigChange) this.instance).setChangeTypeValue(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public ChangeType getChangeType() {
            return ((ConfigChange) this.instance).getChangeType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setChangeType(ChangeType changeType) {
            copyOnWrite();
            ((ConfigChange) this.instance).setChangeType(changeType);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearChangeType() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearChangeType();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public List<Advice> getAdvicesList() {
            return Collections.unmodifiableList(((ConfigChange) this.instance).getAdvicesList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public int getAdvicesCount() {
            return ((ConfigChange) this.instance).getAdvicesCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.ConfigChangeOrBuilder
        public Advice getAdvices(int i) {
            return ((ConfigChange) this.instance).getAdvices(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAdvices(int i, Advice advice) {
            copyOnWrite();
            ((ConfigChange) this.instance).setAdvices(i, advice);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAdvices(int i, Advice.Builder builder) {
            copyOnWrite();
            ((ConfigChange) this.instance).setAdvices(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAdvices(Advice advice) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(advice);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAdvices(int i, Advice advice) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(i, advice);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAdvices(Advice.Builder builder) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAdvices(int i, Advice.Builder builder) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllAdvices(Iterable<? extends Advice> iterable) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAllAdvices(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearAdvices() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearAdvices();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeAdvices(int i) {
            copyOnWrite();
            ((ConfigChange) this.instance).removeAdvices(i);
            return this;
        }
    }

    /* renamed from: com.google.api.ConfigChange$1 */
    static /* synthetic */ class C12001 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f292xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f292xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f292xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f292xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f292xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f292xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f292xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f292xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12001 c12001 = null;
        switch (C12001.f292xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ConfigChange();
            case 2:
                return new Builder(c12001);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0005\u001b", new Object[]{"element_", "oldValue_", "newValue_", "changeType_", "advices_", Advice.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ConfigChange> parser = PARSER;
                if (parser == null) {
                    synchronized (ConfigChange.class) {
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
        ConfigChange configChange = new ConfigChange();
        DEFAULT_INSTANCE = configChange;
        GeneratedMessageLite.registerDefaultInstance(ConfigChange.class, configChange);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<ConfigChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
