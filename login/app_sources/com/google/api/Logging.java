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
public final class Logging extends GeneratedMessageLite<Logging, Builder> implements LoggingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Logging DEFAULT_INSTANCE;
    private static volatile Parser<Logging> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<LoggingDestination> producerDestinations_ = emptyProtobufList();
    private Internal.ProtobufList<LoggingDestination> consumerDestinations_ = emptyProtobufList();

    public interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getLogs(int i);

        ByteString getLogsBytes(int i);

        int getLogsCount();

        List<String> getLogsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Logging() {
    }

    public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
        private static final LoggingDestination DEFAULT_INSTANCE;
        public static final int LOGS_FIELD_NUMBER = 1;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
        private static volatile Parser<LoggingDestination> PARSER;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> logs_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LoggingDestination() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
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
        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public List<String> getLogsList() {
            return this.logs_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public int getLogsCount() {
            return this.logs_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public String getLogs(int i) {
            return this.logs_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public ByteString getLogsBytes(int i) {
            return ByteString.copyFromUtf8(this.logs_.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureLogsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.logs_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.logs_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLogs(int i, String str) {
            str.getClass();
            ensureLogsIsMutable();
            this.logs_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addLogs(String str) {
            str.getClass();
            ensureLogsIsMutable();
            this.logs_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllLogs(Iterable<String> iterable) {
            ensureLogsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.logs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearLogs() {
            this.logs_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addLogsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureLogsIsMutable();
            this.logs_.add(byteString.toStringUtf8());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(InputStream inputStream) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LoggingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoggingDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(LoggingDestination loggingDestination) {
            return DEFAULT_INSTANCE.createBuilder(loggingDestination);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C12181 c12181) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(LoggingDestination.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public String getMonitoredResource() {
                return ((LoggingDestination) this.instance).getMonitoredResource();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((LoggingDestination) this.instance).getMonitoredResourceBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMonitoredResource(String str) {
                copyOnWrite();
                ((LoggingDestination) this.instance).setMonitoredResource(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMonitoredResource() {
                copyOnWrite();
                ((LoggingDestination) this.instance).clearMonitoredResource();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMonitoredResourceBytes(ByteString byteString) {
                copyOnWrite();
                ((LoggingDestination) this.instance).setMonitoredResourceBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public List<String> getLogsList() {
                return Collections.unmodifiableList(((LoggingDestination) this.instance).getLogsList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public int getLogsCount() {
                return ((LoggingDestination) this.instance).getLogsCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public String getLogs(int i) {
                return ((LoggingDestination) this.instance).getLogs(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public ByteString getLogsBytes(int i) {
                return ((LoggingDestination) this.instance).getLogsBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setLogs(int i, String str) {
                copyOnWrite();
                ((LoggingDestination) this.instance).setLogs(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addLogs(String str) {
                copyOnWrite();
                ((LoggingDestination) this.instance).addLogs(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllLogs(Iterable<String> iterable) {
                copyOnWrite();
                ((LoggingDestination) this.instance).addAllLogs(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearLogs() {
                copyOnWrite();
                ((LoggingDestination) this.instance).clearLogs();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addLogsBytes(ByteString byteString) {
                copyOnWrite();
                ((LoggingDestination) this.instance).addLogsBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C12181 c12181 = null;
            switch (C12181.f308xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new LoggingDestination();
                case 2:
                    return new Builder(c12181);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001Ț\u0003Ȉ", new Object[]{"logs_", "monitoredResource_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LoggingDestination> parser = PARSER;
                    if (parser == null) {
                        synchronized (LoggingDestination.class) {
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
            LoggingDestination loggingDestination = new LoggingDestination();
            DEFAULT_INSTANCE = loggingDestination;
            GeneratedMessageLite.registerDefaultInstance(LoggingDestination.class, loggingDestination);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoggingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<LoggingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Logging$1 */
    static /* synthetic */ class C12181 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f308xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f308xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f308xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f308xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f308xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f308xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f308xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f308xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.LoggingOrBuilder
    public List<LoggingDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.LoggingOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.LoggingOrBuilder
    public LoggingDestination getProducerDestinations(int i) {
        return this.producerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int i) {
        return this.producerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureProducerDestinationsIsMutable() {
        Internal.ProtobufList<LoggingDestination> protobufList = this.producerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.producerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProducerDestinations(int i, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProducerDestinations(LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProducerDestinations(int i, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
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
    @Override // com.google.api.LoggingOrBuilder
    public List<LoggingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.LoggingOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.LoggingOrBuilder
    public LoggingDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureConsumerDestinationsIsMutable() {
        Internal.ProtobufList<LoggingDestination> protobufList = this.consumerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConsumerDestinations(int i, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addConsumerDestinations(LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addConsumerDestinations(int i, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
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
    public static Logging parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(InputStream inputStream) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Logging) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Logging) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Logging) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Logging logging) {
        return DEFAULT_INSTANCE.createBuilder(logging);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12181 c12181) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Logging.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.LoggingOrBuilder
        public List<LoggingDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.instance).getProducerDestinationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.LoggingOrBuilder
        public int getProducerDestinationsCount() {
            return ((Logging) this.instance).getProducerDestinationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.LoggingOrBuilder
        public LoggingDestination getProducerDestinations(int i) {
            return ((Logging) this.instance).getProducerDestinations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProducerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            ((Logging) this.instance).setProducerDestinations(i, loggingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProducerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            ((Logging) this.instance).setProducerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(LoggingDestination loggingDestination) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(loggingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(i, loggingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(LoggingDestination.Builder builder) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addProducerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            ((Logging) this.instance).addProducerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
            copyOnWrite();
            ((Logging) this.instance).addAllProducerDestinations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearProducerDestinations() {
            copyOnWrite();
            ((Logging) this.instance).clearProducerDestinations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeProducerDestinations(int i) {
            copyOnWrite();
            ((Logging) this.instance).removeProducerDestinations(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.LoggingOrBuilder
        public List<LoggingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.instance).getConsumerDestinationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.LoggingOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Logging) this.instance).getConsumerDestinationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.LoggingOrBuilder
        public LoggingDestination getConsumerDestinations(int i) {
            return ((Logging) this.instance).getConsumerDestinations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConsumerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            ((Logging) this.instance).setConsumerDestinations(i, loggingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConsumerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            ((Logging) this.instance).setConsumerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(LoggingDestination loggingDestination) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(loggingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(int i, LoggingDestination loggingDestination) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(i, loggingDestination);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(LoggingDestination.Builder builder) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addConsumerDestinations(int i, LoggingDestination.Builder builder) {
            copyOnWrite();
            ((Logging) this.instance).addConsumerDestinations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
            copyOnWrite();
            ((Logging) this.instance).addAllConsumerDestinations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Logging) this.instance).clearConsumerDestinations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeConsumerDestinations(int i) {
            copyOnWrite();
            ((Logging) this.instance).removeConsumerDestinations(i);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12181 c12181 = null;
        switch (C12181.f308xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Logging();
            case 2:
                return new Builder(c12181);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"producerDestinations_", LoggingDestination.class, "consumerDestinations_", LoggingDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Logging> parser = PARSER;
                if (parser == null) {
                    synchronized (Logging.class) {
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
        Logging logging = new Logging();
        DEFAULT_INSTANCE = logging;
        GeneratedMessageLite.registerDefaultInstance(Logging.class, logging);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logging getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Logging> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
