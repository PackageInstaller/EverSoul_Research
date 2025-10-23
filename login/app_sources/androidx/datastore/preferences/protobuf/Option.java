package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Any;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Option extends GeneratedMessageLite<Option, Builder> implements OptionOrBuilder {
    private static final Option DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Option> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String name_ = "";
    private Any value_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Option() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
    public String getName() {
        return this.name_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
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
        byteString.getClass();
        checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
    public boolean hasValue() {
        return this.value_ != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
    public Any getValue() {
        Any any = this.value_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(Any any) {
        any.getClass();
        this.value_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(Any.Builder builder) {
        this.value_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeValue(Any any) {
        any.getClass();
        Any any2 = this.value_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            this.value_ = Any.newBuilder(this.value_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.value_ = any;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearValue() {
        this.value_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Option) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Option option) {
        return DEFAULT_INSTANCE.createBuilder(option);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Option, Builder> implements OptionOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C03351 c03351) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Option.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
        public String getName() {
            return ((Option) this.instance).getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
        public ByteString getNameBytes() {
            return ((Option) this.instance).getNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(String str) {
            copyOnWrite();
            ((Option) this.instance).setName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearName() {
            copyOnWrite();
            ((Option) this.instance).clearName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Option) this.instance).setNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
        public boolean hasValue() {
            return ((Option) this.instance).hasValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.OptionOrBuilder
        public Any getValue() {
            return ((Option) this.instance).getValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setValue(Any any) {
            copyOnWrite();
            ((Option) this.instance).setValue(any);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setValue(Any.Builder builder) {
            copyOnWrite();
            ((Option) this.instance).setValue(builder);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeValue(Any any) {
            copyOnWrite();
            ((Option) this.instance).mergeValue(any);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearValue() {
            copyOnWrite();
            ((Option) this.instance).clearValue();
            return this;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.Option$1 */
    static /* synthetic */ class C03351 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f107xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f107xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f107xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f107xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f107xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f107xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f107xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f107xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C03351 c03351 = null;
        switch (C03351.f107xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Option();
            case 2:
                return new Builder(c03351);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Option> parser = PARSER;
                if (parser == null) {
                    synchronized (Option.class) {
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
        Option option = new Option();
        DEFAULT_INSTANCE = option;
        GeneratedMessageLite.registerDefaultInstance(Option.class, option);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Option> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
