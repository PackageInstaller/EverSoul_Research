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
public final class GaugeMetadata extends GeneratedMessageLite<GaugeMetadata, Builder> implements GaugeMetadataOrBuilder {
    public static final int CPU_CLOCK_RATE_KHZ_FIELD_NUMBER = 2;
    public static final int CPU_PROCESSOR_COUNT_FIELD_NUMBER = 6;
    private static final GaugeMetadata DEFAULT_INSTANCE;
    public static final int DEVICE_RAM_SIZE_KB_FIELD_NUMBER = 3;
    public static final int MAX_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 4;
    public static final int MAX_ENCOURAGED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 5;
    private static volatile Parser<GaugeMetadata> PARSER = null;
    public static final int PROCESS_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private int cpuClockRateKhz_;
    private int cpuProcessorCount_;
    private int deviceRamSizeKb_;
    private int maxAppJavaHeapMemoryKb_;
    private int maxEncouragedAppJavaHeapMemoryKb_;
    private String processName_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GaugeMetadata() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    @Deprecated
    public boolean hasProcessName() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    @Deprecated
    public String getProcessName() {
        return this.processName_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    @Deprecated
    public ByteString getProcessNameBytes() {
        return ByteString.copyFromUtf8(this.processName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProcessName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.processName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearProcessName() {
        this.bitField0_ &= -2;
        this.processName_ = getDefaultInstance().getProcessName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProcessNameBytes(ByteString byteString) {
        this.processName_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public boolean hasCpuClockRateKhz() {
        return (this.bitField0_ & 2) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public int getCpuClockRateKhz() {
        return this.cpuClockRateKhz_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCpuClockRateKhz(int i) {
        this.bitField0_ |= 2;
        this.cpuClockRateKhz_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearCpuClockRateKhz() {
        this.bitField0_ &= -3;
        this.cpuClockRateKhz_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public boolean hasCpuProcessorCount() {
        return (this.bitField0_ & 4) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public int getCpuProcessorCount() {
        return this.cpuProcessorCount_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCpuProcessorCount(int i) {
        this.bitField0_ |= 4;
        this.cpuProcessorCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearCpuProcessorCount() {
        this.bitField0_ &= -5;
        this.cpuProcessorCount_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public boolean hasDeviceRamSizeKb() {
        return (this.bitField0_ & 8) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public int getDeviceRamSizeKb() {
        return this.deviceRamSizeKb_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDeviceRamSizeKb(int i) {
        this.bitField0_ |= 8;
        this.deviceRamSizeKb_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDeviceRamSizeKb() {
        this.bitField0_ &= -9;
        this.deviceRamSizeKb_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public boolean hasMaxAppJavaHeapMemoryKb() {
        return (this.bitField0_ & 16) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public int getMaxAppJavaHeapMemoryKb() {
        return this.maxAppJavaHeapMemoryKb_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxAppJavaHeapMemoryKb(int i) {
        this.bitField0_ |= 16;
        this.maxAppJavaHeapMemoryKb_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMaxAppJavaHeapMemoryKb() {
        this.bitField0_ &= -17;
        this.maxAppJavaHeapMemoryKb_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
        return (this.bitField0_ & 32) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return this.maxEncouragedAppJavaHeapMemoryKb_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxEncouragedAppJavaHeapMemoryKb(int i) {
        this.bitField0_ |= 32;
        this.maxEncouragedAppJavaHeapMemoryKb_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMaxEncouragedAppJavaHeapMemoryKb() {
        this.bitField0_ &= -33;
        this.maxEncouragedAppJavaHeapMemoryKb_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(InputStream inputStream) throws IOException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GaugeMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GaugeMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GaugeMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(GaugeMetadata gaugeMetadata) {
        return DEFAULT_INSTANCE.createBuilder(gaugeMetadata);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GaugeMetadata, Builder> implements GaugeMetadataOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C18371 c18371) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(GaugeMetadata.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        @Deprecated
        public boolean hasProcessName() {
            return ((GaugeMetadata) this.instance).hasProcessName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        @Deprecated
        public String getProcessName() {
            return ((GaugeMetadata) this.instance).getProcessName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        @Deprecated
        public ByteString getProcessNameBytes() {
            return ((GaugeMetadata) this.instance).getProcessNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setProcessName(String str) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setProcessName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder clearProcessName() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearProcessName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setProcessNameBytes(ByteString byteString) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setProcessNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public boolean hasCpuClockRateKhz() {
            return ((GaugeMetadata) this.instance).hasCpuClockRateKhz();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public int getCpuClockRateKhz() {
            return ((GaugeMetadata) this.instance).getCpuClockRateKhz();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCpuClockRateKhz(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setCpuClockRateKhz(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearCpuClockRateKhz() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearCpuClockRateKhz();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public boolean hasCpuProcessorCount() {
            return ((GaugeMetadata) this.instance).hasCpuProcessorCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public int getCpuProcessorCount() {
            return ((GaugeMetadata) this.instance).getCpuProcessorCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCpuProcessorCount(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setCpuProcessorCount(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearCpuProcessorCount() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearCpuProcessorCount();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public boolean hasDeviceRamSizeKb() {
            return ((GaugeMetadata) this.instance).hasDeviceRamSizeKb();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public int getDeviceRamSizeKb() {
            return ((GaugeMetadata) this.instance).getDeviceRamSizeKb();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDeviceRamSizeKb(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setDeviceRamSizeKb(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDeviceRamSizeKb() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearDeviceRamSizeKb();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public boolean hasMaxAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).hasMaxAppJavaHeapMemoryKb();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public int getMaxAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).getMaxAppJavaHeapMemoryKb();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMaxAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setMaxAppJavaHeapMemoryKb(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMaxAppJavaHeapMemoryKb() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearMaxAppJavaHeapMemoryKb();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).hasMaxEncouragedAppJavaHeapMemoryKb();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.GaugeMetadataOrBuilder
        public int getMaxEncouragedAppJavaHeapMemoryKb() {
            return ((GaugeMetadata) this.instance).getMaxEncouragedAppJavaHeapMemoryKb();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMaxEncouragedAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            ((GaugeMetadata) this.instance).setMaxEncouragedAppJavaHeapMemoryKb(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMaxEncouragedAppJavaHeapMemoryKb() {
            copyOnWrite();
            ((GaugeMetadata) this.instance).clearMaxEncouragedAppJavaHeapMemoryKb();
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.GaugeMetadata$1 */
    static /* synthetic */ class C18371 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f445xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f445xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f445xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f445xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f445xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f445xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f445xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f445xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C18371 c18371 = null;
        switch (C18371.f445xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new GaugeMetadata();
            case 2:
                return new Builder(c18371);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0005\u0006င\u0002", new Object[]{"bitField0_", "processName_", "cpuClockRateKhz_", "deviceRamSizeKb_", "maxAppJavaHeapMemoryKb_", "maxEncouragedAppJavaHeapMemoryKb_", "cpuProcessorCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GaugeMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (GaugeMetadata.class) {
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
        GaugeMetadata gaugeMetadata = new GaugeMetadata();
        DEFAULT_INSTANCE = gaugeMetadata;
        GeneratedMessageLite.registerDefaultInstance(GaugeMetadata.class, gaugeMetadata);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GaugeMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<GaugeMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
