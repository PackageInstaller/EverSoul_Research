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
public final class Billing extends GeneratedMessageLite<Billing, Builder> implements BillingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 8;
    private static final Billing DEFAULT_INSTANCE;
    private static volatile Parser<Billing> PARSER;
    private Internal.ProtobufList<BillingDestination> consumerDestinations_ = emptyProtobufList();

    public interface BillingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Billing() {
    }

    public static final class BillingDestination extends GeneratedMessageLite<BillingDestination, Builder> implements BillingDestinationOrBuilder {
        private static final BillingDestination DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<BillingDestination> PARSER;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private BillingDestination() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Billing.BillingDestinationOrBuilder
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
        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public List<String> getMetricsList() {
            return this.metrics_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public String getMetrics(int i) {
            return this.metrics_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Billing.BillingDestinationOrBuilder
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
        public static BillingDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(InputStream inputStream) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BillingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BillingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BillingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(BillingDestination billingDestination) {
            return DEFAULT_INSTANCE.createBuilder(billingDestination);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<BillingDestination, Builder> implements BillingDestinationOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C11981 c11981) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(BillingDestination.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public String getMonitoredResource() {
                return ((BillingDestination) this.instance).getMonitoredResource();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((BillingDestination) this.instance).getMonitoredResourceBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMonitoredResource(String str) {
                copyOnWrite();
                ((BillingDestination) this.instance).setMonitoredResource(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMonitoredResource() {
                copyOnWrite();
                ((BillingDestination) this.instance).clearMonitoredResource();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMonitoredResourceBytes(ByteString byteString) {
                copyOnWrite();
                ((BillingDestination) this.instance).setMonitoredResourceBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((BillingDestination) this.instance).getMetricsList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public int getMetricsCount() {
                return ((BillingDestination) this.instance).getMetricsCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public String getMetrics(int i) {
                return ((BillingDestination) this.instance).getMetrics(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public ByteString getMetricsBytes(int i) {
                return ((BillingDestination) this.instance).getMetricsBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMetrics(int i, String str) {
                copyOnWrite();
                ((BillingDestination) this.instance).setMetrics(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMetrics(String str) {
                copyOnWrite();
                ((BillingDestination) this.instance).addMetrics(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllMetrics(Iterable<String> iterable) {
                copyOnWrite();
                ((BillingDestination) this.instance).addAllMetrics(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMetrics() {
                copyOnWrite();
                ((BillingDestination) this.instance).clearMetrics();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMetricsBytes(ByteString byteString) {
                copyOnWrite();
                ((BillingDestination) this.instance).addMetricsBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C11981 c11981 = null;
            switch (C11981.f291xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new BillingDestination();
                case 2:
                    return new Builder(c11981);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"monitoredResource_", "metrics_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BillingDestination> parser = PARSER;
                    if (parser == null) {
                        synchronized (BillingDestination.class) {
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
            BillingDestination billingDestination = new BillingDestination();
            DEFAULT_INSTANCE = billingDestination;
            GeneratedMessageLite.registerDefaultInstance(BillingDestination.class, billingDestination);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static BillingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<BillingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Billing$1 */
    static /* synthetic */ class C11981 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f291xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f291xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f291xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f291xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f291xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f291xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f291xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f291xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BillingOrBuilder
    public List<BillingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BillingOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.BillingOrBuilder
    public BillingDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureConsumerDestinationsIsMutable() {
        Internal.ProtobufList<BillingDestination> protobufList = this.consumerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConsumerDestinations(int i, BillingDestination billingDestination) {
        billingDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, billingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addConsumerDestinations(BillingDestination billingDestination) {
        billingDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(billingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addConsumerDestinations(int i, BillingDestination billingDestination) {
        billingDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, billingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllConsumerDestinations(Iterable<? extends BillingDestination> iterable) {
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
    public static Billing parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(InputStream inputStream) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Billing) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Billing) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Billing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Billing billing) {
        return DEFAULT_INSTANCE.createBuilder(billing);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Billing, Builder> implements BillingOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C11981 c11981) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Billing.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BillingOrBuilder
        public List<BillingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Billing) this.instance).getConsumerDestinationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BillingOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Billing) this.instance).getConsumerDestinationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.BillingOrBuilder
        public BillingDestination getConsumerDestinations(int i) {
            return ((Billing) this.instance).getConsumerDestinations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConsumerDestinations(int i, BillingDestination billingDestination) {
            copyOnWrite();
            ((Billing) this.instance).setConsumerDestinations(i, billingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConsumerDestinations(int i, BillingDestination.Builder builder) {
            copyOnWrite();
            ((Billing) this.instance).setConsumerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(BillingDestination billingDestination) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(billingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(int i, BillingDestination billingDestination) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(i, billingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(BillingDestination.Builder builder) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(int i, BillingDestination.Builder builder) {
            copyOnWrite();
            ((Billing) this.instance).addConsumerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllConsumerDestinations(Iterable<? extends BillingDestination> iterable) {
            copyOnWrite();
            ((Billing) this.instance).addAllConsumerDestinations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Billing) this.instance).clearConsumerDestinations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeConsumerDestinations(int i) {
            copyOnWrite();
            ((Billing) this.instance).removeConsumerDestinations(i);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C11981 c11981 = null;
        switch (C11981.f291xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Billing();
            case 2:
                return new Builder(c11981);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\b\b\u0001\u0000\u0001\u0000\b\u001b", new Object[]{"consumerDestinations_", BillingDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Billing> parser = PARSER;
                if (parser == null) {
                    synchronized (Billing.class) {
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
        Billing billing = new Billing();
        DEFAULT_INSTANCE = billing;
        GeneratedMessageLite.registerDefaultInstance(Billing.class, billing);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Billing getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Billing> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
