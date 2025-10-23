package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Metric extends GeneratedMessageLite<Metric, Builder> implements MetricOrBuilder {
    private static final Metric DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 2;
    private static volatile Parser<Metric> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 3;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String type_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Metric() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    public String getType() {
        return this.type_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
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

    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LabelsDefaultEntryHolder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    public boolean containsLabels(String str) {
        str.getClass();
        return internalGetLabels().containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    public String getLabelsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> internalGetLabels = internalGetLabels();
        return internalGetLabels.containsKey(str) ? internalGetLabels.get(str) : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricOrBuilder
    public String getLabelsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> internalGetLabels = internalGetLabels();
        if (!internalGetLabels.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetLabels.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(InputStream inputStream) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Metric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Metric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Metric metric) {
        return DEFAULT_INSTANCE.createBuilder(metric);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Metric, Builder> implements MetricOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12191 c12191) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Metric.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public String getType() {
            return ((Metric) this.instance).getType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public ByteString getTypeBytes() {
            return ((Metric) this.instance).getTypeBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setType(String str) {
            copyOnWrite();
            ((Metric) this.instance).setType(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearType() {
            copyOnWrite();
            ((Metric) this.instance).clearType();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Metric) this.instance).setTypeBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public int getLabelsCount() {
            return ((Metric) this.instance).getLabelsMap().size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public boolean containsLabels(String str) {
            str.getClass();
            return ((Metric) this.instance).getLabelsMap().containsKey(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearLabels() {
            copyOnWrite();
            ((Metric) this.instance).getMutableLabelsMap().clear();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeLabels(String str) {
            str.getClass();
            copyOnWrite();
            ((Metric) this.instance).getMutableLabelsMap().remove(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((Metric) this.instance).getLabelsMap());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> labelsMap = ((Metric) this.instance).getLabelsMap();
            return labelsMap.containsKey(str) ? labelsMap.get(str) : str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricOrBuilder
        public String getLabelsOrThrow(String str) {
            str.getClass();
            Map<String, String> labelsMap = ((Metric) this.instance).getLabelsMap();
            if (!labelsMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return labelsMap.get(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putLabels(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((Metric) this.instance).getMutableLabelsMap().put(str, str2);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putAllLabels(Map<String, String> map) {
            copyOnWrite();
            ((Metric) this.instance).getMutableLabelsMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.api.Metric$1 */
    static /* synthetic */ class C12191 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f309xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f309xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f309xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f309xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f309xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f309xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f309xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f309xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12191 c12191 = null;
        switch (C12191.f309xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Metric();
            case 2:
                return new Builder(c12191);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0001\u0000\u0000\u00022\u0003Ȉ", new Object[]{"labels_", LabelsDefaultEntryHolder.defaultEntry, "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Metric> parser = PARSER;
                if (parser == null) {
                    synchronized (Metric.class) {
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
        Metric metric = new Metric();
        DEFAULT_INSTANCE = metric;
        GeneratedMessageLite.registerDefaultInstance(Metric.class, metric);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Metric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Metric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
