package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Mixin extends GeneratedMessageLite<Mixin, Builder> implements MixinOrBuilder {
    private static final Mixin DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Mixin> PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;
    private String name_ = "";
    private String root_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Mixin() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
    public String getName() {
        return this.name_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
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
    @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
    public String getRoot() {
        return this.root_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
    public ByteString getRootBytes() {
        return ByteString.copyFromUtf8(this.root_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRoot(String str) {
        str.getClass();
        this.root_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRoot() {
        this.root_ = getDefaultInstance().getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRootBytes(ByteString byteString) {
        byteString.getClass();
        checkByteStringIsUtf8(byteString);
        this.root_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(InputStream inputStream) throws IOException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Mixin) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Mixin) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Mixin mixin) {
        return DEFAULT_INSTANCE.createBuilder(mixin);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Mixin, Builder> implements MixinOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C03311 c03311) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Mixin.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
        public String getName() {
            return ((Mixin) this.instance).getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
        public ByteString getNameBytes() {
            return ((Mixin) this.instance).getNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(String str) {
            copyOnWrite();
            ((Mixin) this.instance).setName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearName() {
            copyOnWrite();
            ((Mixin) this.instance).clearName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Mixin) this.instance).setNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
        public String getRoot() {
            return ((Mixin) this.instance).getRoot();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.MixinOrBuilder
        public ByteString getRootBytes() {
            return ((Mixin) this.instance).getRootBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRoot(String str) {
            copyOnWrite();
            ((Mixin) this.instance).setRoot(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearRoot() {
            copyOnWrite();
            ((Mixin) this.instance).clearRoot();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRootBytes(ByteString byteString) {
            copyOnWrite();
            ((Mixin) this.instance).setRootBytes(byteString);
            return this;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.Mixin$1 */
    static /* synthetic */ class C03311 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f105xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f105xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f105xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f105xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f105xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f105xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f105xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f105xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C03311 c03311 = null;
        switch (C03311.f105xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Mixin();
            case 2:
                return new Builder(c03311);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "root_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Mixin> parser = PARSER;
                if (parser == null) {
                    synchronized (Mixin.class) {
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
        Mixin mixin = new Mixin();
        DEFAULT_INSTANCE = mixin;
        GeneratedMessageLite.registerDefaultInstance(Mixin.class, mixin);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Mixin> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
