package com.google.firebase.perf.p010v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class CpuMetricReading extends GeneratedMessageLite<CpuMetricReading, Builder> implements CpuMetricReadingOrBuilder {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final CpuMetricReading DEFAULT_INSTANCE;
    private static volatile Parser<CpuMetricReading> PARSER = null;
    public static final int SYSTEM_TIME_US_FIELD_NUMBER = 3;
    public static final int USER_TIME_US_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private long systemTimeUs_;
    private long userTimeUs_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CpuMetricReading() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
    public boolean hasClientTimeUs() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setClientTimeUs(long j) {
        this.bitField0_ |= 1;
        this.clientTimeUs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearClientTimeUs() {
        this.bitField0_ &= -2;
        this.clientTimeUs_ = 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
    public boolean hasUserTimeUs() {
        return (this.bitField0_ & 2) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
    public long getUserTimeUs() {
        return this.userTimeUs_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUserTimeUs(long j) {
        this.bitField0_ |= 2;
        this.userTimeUs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearUserTimeUs() {
        this.bitField0_ &= -3;
        this.userTimeUs_ = 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
    public boolean hasSystemTimeUs() {
        return (this.bitField0_ & 4) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
    public long getSystemTimeUs() {
        return this.systemTimeUs_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSystemTimeUs(long j) {
        this.bitField0_ |= 4;
        this.systemTimeUs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSystemTimeUs() {
        this.bitField0_ &= -5;
        this.systemTimeUs_ = 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(InputStream inputStream) throws IOException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CpuMetricReading) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CpuMetricReading) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CpuMetricReading) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(CpuMetricReading cpuMetricReading) {
        return DEFAULT_INSTANCE.createBuilder(cpuMetricReading);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CpuMetricReading, Builder> implements CpuMetricReadingOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C18361 c18361) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(CpuMetricReading.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
        public boolean hasClientTimeUs() {
            return ((CpuMetricReading) this.instance).hasClientTimeUs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
        public long getClientTimeUs() {
            return ((CpuMetricReading) this.instance).getClientTimeUs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setClientTimeUs(long j) {
            copyOnWrite();
            ((CpuMetricReading) this.instance).setClientTimeUs(j);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearClientTimeUs() {
            copyOnWrite();
            ((CpuMetricReading) this.instance).clearClientTimeUs();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
        public boolean hasUserTimeUs() {
            return ((CpuMetricReading) this.instance).hasUserTimeUs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
        public long getUserTimeUs() {
            return ((CpuMetricReading) this.instance).getUserTimeUs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setUserTimeUs(long j) {
            copyOnWrite();
            ((CpuMetricReading) this.instance).setUserTimeUs(j);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearUserTimeUs() {
            copyOnWrite();
            ((CpuMetricReading) this.instance).clearUserTimeUs();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
        public boolean hasSystemTimeUs() {
            return ((CpuMetricReading) this.instance).hasSystemTimeUs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.CpuMetricReadingOrBuilder
        public long getSystemTimeUs() {
            return ((CpuMetricReading) this.instance).getSystemTimeUs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSystemTimeUs(long j) {
            copyOnWrite();
            ((CpuMetricReading) this.instance).setSystemTimeUs(j);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSystemTimeUs() {
            copyOnWrite();
            ((CpuMetricReading) this.instance).clearSystemTimeUs();
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.CpuMetricReading$1 */
    static /* synthetic */ class C18361 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f444xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f444xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f444xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f444xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f444xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f444xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f444xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f444xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C18361 c18361 = null;
        switch (C18361.f444xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new CpuMetricReading();
            case 2:
                return new Builder(c18361);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"bitField0_", "clientTimeUs_", "userTimeUs_", "systemTimeUs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CpuMetricReading> parser = PARSER;
                if (parser == null) {
                    synchronized (CpuMetricReading.class) {
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
        CpuMetricReading cpuMetricReading = new CpuMetricReading();
        DEFAULT_INSTANCE = cpuMetricReading;
        GeneratedMessageLite.registerDefaultInstance(CpuMetricReading.class, cpuMetricReading);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CpuMetricReading getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<CpuMetricReading> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
