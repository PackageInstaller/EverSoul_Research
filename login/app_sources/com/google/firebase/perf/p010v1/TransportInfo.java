package com.google.firebase.perf.p010v1;

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
public final class TransportInfo extends GeneratedMessageLite<TransportInfo, Builder> implements TransportInfoOrBuilder {
    private static final TransportInfo DEFAULT_INSTANCE;
    public static final int DISPATCH_DESTINATION_FIELD_NUMBER = 1;
    private static volatile Parser<TransportInfo> PARSER;
    private int bitField0_;
    private int dispatchDestination_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TransportInfo() {
    }

    public enum DispatchDestination implements Internal.EnumLite {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);

        public static final int FL_LEGACY_V1_VALUE = 1;
        public static final int SOURCE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<DispatchDestination> internalValueMap = new Internal.EnumLiteMap<DispatchDestination>() { // from class: com.google.firebase.perf.v1.TransportInfo.DispatchDestination.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DispatchDestination findValueByNumber(int i) {
                return DispatchDestination.forNumber(i);
            }
        };
        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public static DispatchDestination valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DispatchDestination forNumber(int i) {
            if (i == 0) {
                return SOURCE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return FL_LEGACY_V1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumLiteMap<DispatchDestination> internalGetValueMap() {
            return internalValueMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumVerifier internalGetVerifier() {
            return DispatchDestinationVerifier.INSTANCE;
        }

        private static final class DispatchDestinationVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new DispatchDestinationVerifier();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private DispatchDestinationVerifier() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return DispatchDestination.forNumber(i) != null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DispatchDestination(int i) {
            this.value = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.TransportInfoOrBuilder
    public boolean hasDispatchDestination() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.TransportInfoOrBuilder
    public DispatchDestination getDispatchDestination() {
        DispatchDestination forNumber = DispatchDestination.forNumber(this.dispatchDestination_);
        return forNumber == null ? DispatchDestination.SOURCE_UNKNOWN : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDispatchDestination(DispatchDestination dispatchDestination) {
        this.dispatchDestination_ = dispatchDestination.getNumber();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDispatchDestination() {
        this.bitField0_ &= -2;
        this.dispatchDestination_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(InputStream inputStream) throws IOException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TransportInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransportInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(TransportInfo transportInfo) {
        return DEFAULT_INSTANCE.createBuilder(transportInfo);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<TransportInfo, Builder> implements TransportInfoOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C18501 c18501) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(TransportInfo.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.TransportInfoOrBuilder
        public boolean hasDispatchDestination() {
            return ((TransportInfo) this.instance).hasDispatchDestination();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.TransportInfoOrBuilder
        public DispatchDestination getDispatchDestination() {
            return ((TransportInfo) this.instance).getDispatchDestination();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDispatchDestination(DispatchDestination dispatchDestination) {
            copyOnWrite();
            ((TransportInfo) this.instance).setDispatchDestination(dispatchDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDispatchDestination() {
            copyOnWrite();
            ((TransportInfo) this.instance).clearDispatchDestination();
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.TransportInfo$1 */
    static /* synthetic */ class C18501 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f452xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f452xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f452xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f452xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f452xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f452xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f452xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f452xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C18501 c18501 = null;
        switch (C18501.f452xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new TransportInfo();
            case 2:
                return new Builder(c18501);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"bitField0_", "dispatchDestination_", DispatchDestination.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransportInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (TransportInfo.class) {
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
        TransportInfo transportInfo = new TransportInfo();
        DEFAULT_INSTANCE = transportInfo;
        GeneratedMessageLite.registerDefaultInstance(TransportInfo.class, transportInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<TransportInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
