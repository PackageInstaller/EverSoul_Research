package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
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
public final class Monitoring extends GeneratedMessageLite<Monitoring, Builder> implements MonitoringOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Monitoring DEFAULT_INSTANCE;
    private static volatile Parser<Monitoring> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<MonitoringDestination> producerDestinations_ = emptyProtobufList();
    private Internal.ProtobufList<MonitoringDestination> consumerDestinations_ = emptyProtobufList();

    public interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Monitoring() {
    }

    public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
        private static final MonitoringDestination DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<MonitoringDestination> PARSER;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MonitoringDestination() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMonitoredResource(String str) {
            str.getClass();
            this.monitoredResource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearMonitoredResource() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMonitoredResourceBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.monitoredResource_ = byteString.toStringUtf8();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public List<String> getMetricsList() {
            return this.metrics_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMetrics(int i) {
            return this.metrics_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMetricsBytes(int i) {
            return ByteString.copyFromUtf8(this.metrics_.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureMetricsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.metrics_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.metrics_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMetrics(int i, String str) {
            str.getClass();
            ensureMetricsIsMutable();
            this.metrics_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addMetrics(String str) {
            str.getClass();
            ensureMetricsIsMutable();
            this.metrics_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllMetrics(Iterable<String> iterable) {
            ensureMetricsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.metrics_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearMetrics() {
            this.metrics_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addMetricsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureMetricsIsMutable();
            this.metrics_.add(byteString.toStringUtf8());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(MonitoringDestination monitoringDestination) {
            return DEFAULT_INSTANCE.createBuilder(monitoringDestination);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C12271 c12271) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(MonitoringDestination.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMonitoredResource() {
                return ((MonitoringDestination) this.instance).getMonitoredResource();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((MonitoringDestination) this.instance).getMonitoredResourceBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMonitoredResource(String str) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMonitoredResource(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMonitoredResource() {
                copyOnWrite();
                ((MonitoringDestination) this.instance).clearMonitoredResource();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMonitoredResourceBytes(ByteString byteString) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMonitoredResourceBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((MonitoringDestination) this.instance).getMetricsList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public int getMetricsCount() {
                return ((MonitoringDestination) this.instance).getMetricsCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMetrics(int i) {
                return ((MonitoringDestination) this.instance).getMetrics(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMetricsBytes(int i) {
                return ((MonitoringDestination) this.instance).getMetricsBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMetrics(int i, String str) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMetrics(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMetrics(String str) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addMetrics(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllMetrics(Iterable<String> iterable) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addAllMetrics(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMetrics() {
                copyOnWrite();
                ((MonitoringDestination) this.instance).clearMetrics();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMetricsBytes(ByteString byteString) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addMetricsBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C12271 c12271 = null;
            switch (C12271.f315xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MonitoringDestination();
                case 2:
                    return new Builder(c12271);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"monitoredResource_", "metrics_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MonitoringDestination> parser = PARSER;
                    if (parser == null) {
                        synchronized (MonitoringDestination.class) {
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
            MonitoringDestination monitoringDestination = new MonitoringDestination();
            DEFAULT_INSTANCE = monitoringDestination;
            GeneratedMessageLite.registerDefaultInstance(MonitoringDestination.class, monitoringDestination);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MonitoringDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<MonitoringDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Monitoring$1 */
    static /* synthetic */ class C12271 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f315xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f315xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f315xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f315xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f315xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f315xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f315xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f315xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoringOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getProducerDestinations(int i) {
        return this.producerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i) {
        return this.producerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureProducerDestinationsIsMutable() {
        Internal.ProtobufList<MonitoringDestination> protobufList = this.producerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.producerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProducerDestinations(int i, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProducerDestinations(MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProducerDestinations(int i, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.producerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearProducerDestinations() {
        this.producerDestinations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeProducerDestinations(int i) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoringOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureConsumerDestinationsIsMutable() {
        Internal.ProtobufList<MonitoringDestination> protobufList = this.consumerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addConsumerDestinations(MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearConsumerDestinations() {
        this.consumerDestinations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeConsumerDestinations(int i) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(InputStream inputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Monitoring) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Monitoring monitoring) {
        return DEFAULT_INSTANCE.createBuilder(monitoring);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12271 c12271) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Monitoring.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.instance).getProducerDestinationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoringOrBuilder
        public int getProducerDestinationsCount() {
            return ((Monitoring) this.instance).getProducerDestinationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getProducerDestinations(int i) {
            return ((Monitoring) this.instance).getProducerDestinations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProducerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).setProducerDestinations(i, monitoringDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProducerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).setProducerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(monitoringDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(i, monitoringDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            copyOnWrite();
            ((Monitoring) this.instance).addAllProducerDestinations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearProducerDestinations() {
            copyOnWrite();
            ((Monitoring) this.instance).clearProducerDestinations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeProducerDestinations(int i) {
            copyOnWrite();
            ((Monitoring) this.instance).removeProducerDestinations(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.instance).getConsumerDestinationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoringOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Monitoring) this.instance).getConsumerDestinationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getConsumerDestinations(int i) {
            return ((Monitoring) this.instance).getConsumerDestinations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).setConsumerDestinations(i, monitoringDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConsumerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).setConsumerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(monitoringDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(i, monitoringDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            copyOnWrite();
            ((Monitoring) this.instance).addAllConsumerDestinations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Monitoring) this.instance).clearConsumerDestinations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeConsumerDestinations(int i) {
            copyOnWrite();
            ((Monitoring) this.instance).removeConsumerDestinations(i);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12271 c12271 = null;
        switch (C12271.f315xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Monitoring();
            case 2:
                return new Builder(c12271);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"producerDestinations_", MonitoringDestination.class, "consumerDestinations_", MonitoringDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Monitoring> parser = PARSER;
                if (parser == null) {
                    synchronized (Monitoring.class) {
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
        Monitoring monitoring = new Monitoring();
        DEFAULT_INSTANCE = monitoring;
        GeneratedMessageLite.registerDefaultInstance(Monitoring.class, monitoring);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Monitoring getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Monitoring> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
