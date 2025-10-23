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
public final class MetricRule extends GeneratedMessageLite<MetricRule, Builder> implements MetricRuleOrBuilder {
    private static final MetricRule DEFAULT_INSTANCE;
    public static final int METRIC_COSTS_FIELD_NUMBER = 2;
    private static volatile Parser<MetricRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private MapFieldLite<String, Long> metricCosts_ = MapFieldLite.emptyMapField();
    private String selector_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MetricRule() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelector(String str) {
        str.getClass();
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelectorBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    private static final class MetricCostsDefaultEntryHolder {
        static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MetricCostsDefaultEntryHolder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, Long> internalGetMetricCosts() {
        return this.metricCosts_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite<String, Long> internalGetMutableMetricCosts() {
        if (!this.metricCosts_.isMutable()) {
            this.metricCosts_ = this.metricCosts_.mutableCopy();
        }
        return this.metricCosts_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public int getMetricCostsCount() {
        return internalGetMetricCosts().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public boolean containsMetricCosts(String str) {
        str.getClass();
        return internalGetMetricCosts().containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    @Deprecated
    public Map<String, Long> getMetricCosts() {
        return getMetricCostsMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public Map<String, Long> getMetricCostsMap() {
        return Collections.unmodifiableMap(internalGetMetricCosts());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public long getMetricCostsOrDefault(String str, long j) {
        str.getClass();
        MapFieldLite<String, Long> internalGetMetricCosts = internalGetMetricCosts();
        return internalGetMetricCosts.containsKey(str) ? internalGetMetricCosts.get(str).longValue() : j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.api.MetricRuleOrBuilder
    public long getMetricCostsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, Long> internalGetMetricCosts = internalGetMetricCosts();
        if (!internalGetMetricCosts.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetMetricCosts.get(str).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, Long> getMutableMetricCostsMap() {
        return internalGetMutableMetricCosts();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(InputStream inputStream) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(MetricRule metricRule) {
        return DEFAULT_INSTANCE.createBuilder(metricRule);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MetricRule, Builder> implements MetricRuleOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C12231 c12231) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(MetricRule.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public String getSelector() {
            return ((MetricRule) this.instance).getSelector();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((MetricRule) this.instance).getSelectorBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelector(String str) {
            copyOnWrite();
            ((MetricRule) this.instance).setSelector(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSelector() {
            copyOnWrite();
            ((MetricRule) this.instance).clearSelector();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public int getMetricCostsCount() {
            return ((MetricRule) this.instance).getMetricCostsMap().size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public boolean containsMetricCosts(String str) {
            str.getClass();
            return ((MetricRule) this.instance).getMetricCostsMap().containsKey(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMetricCosts() {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().clear();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeMetricCosts(String str) {
            str.getClass();
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().remove(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        @Deprecated
        public Map<String, Long> getMetricCosts() {
            return getMetricCostsMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public Map<String, Long> getMetricCostsMap() {
            return Collections.unmodifiableMap(((MetricRule) this.instance).getMetricCostsMap());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public long getMetricCostsOrDefault(String str, long j) {
            str.getClass();
            Map<String, Long> metricCostsMap = ((MetricRule) this.instance).getMetricCostsMap();
            return metricCostsMap.containsKey(str) ? metricCostsMap.get(str).longValue() : j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.api.MetricRuleOrBuilder
        public long getMetricCostsOrThrow(String str) {
            str.getClass();
            Map<String, Long> metricCostsMap = ((MetricRule) this.instance).getMetricCostsMap();
            if (!metricCostsMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return metricCostsMap.get(str).longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putMetricCosts(String str, long j) {
            str.getClass();
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().put(str, Long.valueOf(j));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putAllMetricCosts(Map<String, Long> map) {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.api.MetricRule$1 */
    static /* synthetic */ class C12231 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f311xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f311xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f311xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f311xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f311xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f311xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f311xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f311xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C12231 c12231 = null;
        switch (C12231.f311xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricRule();
            case 2:
                return new Builder(c12231);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001Ȉ\u00022", new Object[]{"selector_", "metricCosts_", MetricCostsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MetricRule> parser = PARSER;
                if (parser == null) {
                    synchronized (MetricRule.class) {
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
        MetricRule metricRule = new MetricRule();
        DEFAULT_INSTANCE = metricRule;
        GeneratedMessageLite.registerDefaultInstance(MetricRule.class, metricRule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetricRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<MetricRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
