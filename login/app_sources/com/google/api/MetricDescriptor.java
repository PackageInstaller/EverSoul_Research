package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    private static final MetricDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<MetricDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private int launchStage_;
    private MetricDescriptorMetadata metadata_;
    private int metricKind_;
    private int valueType_;
    private String name_ = "";
    private String type_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
    private String unit_ = "";
    private String description_ = "";
    private String displayName_ = "";

    public interface MetricDescriptorMetadataOrBuilder extends MessageLiteOrBuilder {
        Duration getIngestDelay();

        @Deprecated
        LaunchStage getLaunchStage();

        @Deprecated
        int getLaunchStageValue();

        Duration getSamplePeriod();

        boolean hasIngestDelay();

        boolean hasSamplePeriod();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MetricDescriptor() {
    }

    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);

        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = new Internal.EnumLiteMap<MetricKind>() { // from class: com.google.api.MetricDescriptor.MetricKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MetricKind findValueByNumber(int i) {
                return MetricKind.forNumber(i);
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
        public static MetricKind valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricKind forNumber(int i) {
            if (i == 0) {
                return METRIC_KIND_UNSPECIFIED;
            }
            if (i == 1) {
                return GAUGE;
            }
            if (i == 2) {
                return DELTA;
            }
            if (i != 3) {
                return null;
            }
            return CUMULATIVE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumVerifier internalGetVerifier() {
            return MetricKindVerifier.INSTANCE;
        }

        private static final class MetricKindVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new MetricKindVerifier();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private MetricKindVerifier() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return MetricKind.forNumber(i) != null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MetricKind(int i) {
            this.value = i;
        }
    }

    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = new Internal.EnumLiteMap<ValueType>() { // from class: com.google.api.MetricDescriptor.ValueType.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ValueType findValueByNumber(int i) {
                return ValueType.forNumber(i);
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
        public static ValueType valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ValueType forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Internal.EnumVerifier internalGetVerifier() {
            return ValueTypeVerifier.INSTANCE;
        }

        private static final class ValueTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ValueTypeVerifier();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private ValueTypeVerifier() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ValueType.forNumber(i) != null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ValueType(int i) {
            this.value = i;
        }
    }

    public static final class MetricDescriptorMetadata extends GeneratedMessageLite<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
        private static final MetricDescriptorMetadata DEFAULT_INSTANCE;
        public static final int INGEST_DELAY_FIELD_NUMBER = 3;
        public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
        private static volatile Parser<MetricDescriptorMetadata> PARSER = null;
        public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
        private Duration ingestDelay_;
        private int launchStage_;
        private Duration samplePeriod_;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MetricDescriptorMetadata() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public int getLaunchStageValue() {
            return this.launchStage_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public LaunchStage getLaunchStage() {
            LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
            return forNumber == null ? LaunchStage.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLaunchStageValue(int i) {
            this.launchStage_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLaunchStage(LaunchStage launchStage) {
            this.launchStage_ = launchStage.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearLaunchStage() {
            this.launchStage_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public boolean hasSamplePeriod() {
            return this.samplePeriod_ != null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public Duration getSamplePeriod() {
            Duration duration = this.samplePeriod_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSamplePeriod(Duration duration) {
            duration.getClass();
            this.samplePeriod_ = duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeSamplePeriod(Duration duration) {
            duration.getClass();
            Duration duration2 = this.samplePeriod_;
            if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
                this.samplePeriod_ = Duration.newBuilder(this.samplePeriod_).mergeFrom((Duration.Builder) duration).buildPartial();
            } else {
                this.samplePeriod_ = duration;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearSamplePeriod() {
            this.samplePeriod_ = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public boolean hasIngestDelay() {
            return this.ingestDelay_ != null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public Duration getIngestDelay() {
            Duration duration = this.ingestDelay_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setIngestDelay(Duration duration) {
            duration.getClass();
            this.ingestDelay_ = duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeIngestDelay(Duration duration) {
            duration.getClass();
            Duration duration2 = this.ingestDelay_;
            if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
                this.ingestDelay_ = Duration.newBuilder(this.ingestDelay_).mergeFrom((Duration.Builder) duration).buildPartial();
            } else {
                this.ingestDelay_ = duration;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearIngestDelay() {
            this.ingestDelay_ = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(MetricDescriptorMetadata metricDescriptorMetadata) {
            return DEFAULT_INSTANCE.createBuilder(metricDescriptorMetadata);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C12201 c12201) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(MetricDescriptorMetadata.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public int getLaunchStageValue() {
                return ((MetricDescriptorMetadata) this.instance).getLaunchStageValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public Builder setLaunchStageValue(int i) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setLaunchStageValue(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public LaunchStage getLaunchStage() {
                return ((MetricDescriptorMetadata) this.instance).getLaunchStage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public Builder setLaunchStage(LaunchStage launchStage) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setLaunchStage(launchStage);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public Builder clearLaunchStage() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearLaunchStage();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public boolean hasSamplePeriod() {
                return ((MetricDescriptorMetadata) this.instance).hasSamplePeriod();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public Duration getSamplePeriod() {
                return ((MetricDescriptorMetadata) this.instance).getSamplePeriod();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSamplePeriod(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setSamplePeriod(duration);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSamplePeriod(Duration.Builder builder) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setSamplePeriod(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeSamplePeriod(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).mergeSamplePeriod(duration);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearSamplePeriod() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearSamplePeriod();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public boolean hasIngestDelay() {
                return ((MetricDescriptorMetadata) this.instance).hasIngestDelay();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public Duration getIngestDelay() {
                return ((MetricDescriptorMetadata) this.instance).getIngestDelay();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setIngestDelay(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setIngestDelay(duration);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setIngestDelay(Duration.Builder builder) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setIngestDelay(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeIngestDelay(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).mergeIngestDelay(duration);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearIngestDelay() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearIngestDelay();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C12201 c12201 = null;
            switch (C12201.f310xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MetricDescriptorMetadata();
                case 2:
                    return new Builder(c12201);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"launchStage_", "samplePeriod_", "ingestDelay_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MetricDescriptorMetadata> parser = PARSER;
                    if (parser == null) {
                        synchronized (MetricDescriptorMetadata.class) {
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
            MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptorMetadata();
            DEFAULT_INSTANCE = metricDescriptorMetadata;
            GeneratedMessageLite.registerDefaultInstance(MetricDescriptorMetadata.class, metricDescriptorMetadata);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MetricDescriptorMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<MetricDescriptorMetadata> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.MetricDescriptor$1 */
    static /* synthetic */ class C12201 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f310xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f310xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f310xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f310xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f310xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f310xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f310xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f310xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getName() {
        return this.name_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
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
        checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
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
    @Override // com.google.api.MetricDescriptorOrBuilder
    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLabelsCount() {
        return this.labels_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public LabelDescriptor getLabels(int i) {
        return this.labels_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i) {
        return this.labels_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureLabelsIsMutable() {
        Internal.ProtobufList<LabelDescriptor> protobufList = this.labels_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.labels_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLabels(int i, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.set(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addLabels(LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.add(labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addLabels(int i, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.add(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
        ensureLabelsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.labels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearLabels() {
        this.labels_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeLabels(int i) {
        ensureLabelsIsMutable();
        this.labels_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getMetricKindValue() {
        return this.metricKind_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricKind getMetricKind() {
        MetricKind forNumber = MetricKind.forNumber(this.metricKind_);
        return forNumber == null ? MetricKind.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMetricKindValue(int i) {
        this.metricKind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMetricKind(MetricKind metricKind) {
        this.metricKind_ = metricKind.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMetricKind() {
        this.metricKind_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getValueTypeValue() {
        return this.valueType_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public ValueType getValueType() {
        ValueType forNumber = ValueType.forNumber(this.valueType_);
        return forNumber == null ? ValueType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValueTypeValue(int i) {
        this.valueType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValueType(ValueType valueType) {
        this.valueType_ = valueType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearValueType() {
        this.valueType_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getUnit() {
        return this.unit_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUnit(String str) {
        str.getClass();
        this.unit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUnitBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.unit_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDescription() {
        return this.description_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDescriptionBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDisplayNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricDescriptorMetadata getMetadata() {
        MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
        return metricDescriptorMetadata == null ? MetricDescriptorMetadata.getDefaultInstance() : metricDescriptorMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        this.metadata_ = metricDescriptorMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
        if (metricDescriptorMetadata2 != null && metricDescriptorMetadata2 != MetricDescriptorMetadata.getDefaultInstance()) {
            this.metadata_ = MetricDescriptorMetadata.newBuilder(this.metadata_).mergeFrom((MetricDescriptorMetadata.Builder) metricDescriptorMetadata).buildPartial();
        } else {
            this.metadata_ = metricDescriptorMetadata;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLaunchStageValue() {
        return this.launchStage_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricDescriptorOrBuilder
    public LaunchStage getLaunchStage() {
        LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
        return forNumber == null ? LaunchStage.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLaunchStageValue(int i) {
        this.launchStage_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLaunchStage(LaunchStage launchStage) {
        this.launchStage_ = launchStage.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearLaunchStage() {
        this.launchStage_ = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(MetricDescriptor metricDescriptor) {
        return DEFAULT_INSTANCE.createBuilder(metricDescriptor);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12201 c12201) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getName() {
            return ((MetricDescriptor) this.instance).getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getNameBytes() {
            return ((MetricDescriptor) this.instance).getNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getType() {
            return ((MetricDescriptor) this.instance).getType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((MetricDescriptor) this.instance).getTypeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setType(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setType(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearType();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setTypeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MetricDescriptor) this.instance).getLabelsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLabelsCount() {
            return ((MetricDescriptor) this.instance).getLabelsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public LabelDescriptor getLabels(int i) {
            return ((MetricDescriptor) this.instance).getLabels(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLabels(int i, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(i, labelDescriptor);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLabels(int i, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addLabels(LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(labelDescriptor);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addLabels(int i, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(i, labelDescriptor);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addLabels(LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addLabels(int i, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addAllLabels(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearLabels() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLabels();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeLabels(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).removeLabels(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getMetricKindValue() {
            return ((MetricDescriptor) this.instance).getMetricKindValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMetricKindValue(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKindValue(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricKind getMetricKind() {
            return ((MetricDescriptor) this.instance).getMetricKind();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMetricKind(MetricKind metricKind) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKind(metricKind);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMetricKind() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetricKind();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getValueTypeValue() {
            return ((MetricDescriptor) this.instance).getValueTypeValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setValueTypeValue(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueTypeValue(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public ValueType getValueType() {
            return ((MetricDescriptor) this.instance).getValueType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setValueType(ValueType valueType) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueType(valueType);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearValueType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearValueType();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getUnit() {
            return ((MetricDescriptor) this.instance).getUnit();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getUnitBytes() {
            return ((MetricDescriptor) this.instance).getUnitBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setUnit(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnit(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearUnit() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearUnit();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setUnitBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnitBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDescription() {
            return ((MetricDescriptor) this.instance).getDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDescriptionBytes() {
            return ((MetricDescriptor) this.instance).getDescriptionBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDescription(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescription(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDescription() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDescription();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDisplayName() {
            return ((MetricDescriptor) this.instance).getDisplayName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((MetricDescriptor) this.instance).getDisplayNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDisplayName(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDisplayName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDisplayName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDisplayNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public boolean hasMetadata() {
            return ((MetricDescriptor) this.instance).hasMetadata();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricDescriptorMetadata getMetadata() {
            return ((MetricDescriptor) this.instance).getMetadata();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetadata(metricDescriptorMetadata);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMetadata(MetricDescriptorMetadata.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetadata(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).mergeMetadata(metricDescriptorMetadata);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMetadata() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetadata();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLaunchStageValue() {
            return ((MetricDescriptor) this.instance).getLaunchStageValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLaunchStageValue(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLaunchStageValue(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricDescriptorOrBuilder
        public LaunchStage getLaunchStage() {
            return ((MetricDescriptor) this.instance).getLaunchStage();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLaunchStage(LaunchStage launchStage) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLaunchStage(launchStage);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearLaunchStage() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLaunchStage();
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12201 c12201 = null;
        switch (C12201.f310xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return new Builder(c12201);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\f\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\n\t\f\f", new Object[]{"name_", "labels_", LabelDescriptor.class, "metricKind_", "valueType_", "unit_", "description_", "displayName_", "type_", "metadata_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MetricDescriptor> parser = PARSER;
                if (parser == null) {
                    synchronized (MetricDescriptor.class) {
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
        MetricDescriptor metricDescriptor = new MetricDescriptor();
        DEFAULT_INSTANCE = metricDescriptor;
        GeneratedMessageLite.registerDefaultInstance(MetricDescriptor.class, metricDescriptor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<MetricDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
