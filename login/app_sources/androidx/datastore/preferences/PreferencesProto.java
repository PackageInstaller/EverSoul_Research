package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedInputStream;
import androidx.datastore.preferences.protobuf.ExtensionRegistryLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class PreferencesProto {

    public interface PreferenceMapOrBuilder extends MessageLiteOrBuilder {
        boolean containsPreferences(String str);

        @Deprecated
        Map<String, Value> getPreferences();

        int getPreferencesCount();

        Map<String, Value> getPreferencesMap();

        Value getPreferencesOrDefault(String str, Value value);

        Value getPreferencesOrThrow(String str);
    }

    public interface StringSetOrBuilder extends MessageLiteOrBuilder {
        String getStrings(int i);

        ByteString getStringsBytes(int i);

        int getStringsCount();

        List<String> getStringsList();
    }

    public interface ValueOrBuilder extends MessageLiteOrBuilder {
        boolean getBoolean();

        double getDouble();

        float getFloat();

        int getInteger();

        long getLong();

        String getString();

        ByteString getStringBytes();

        StringSet getStringSet();

        Value.ValueCase getValueCase();

        boolean hasBoolean();

        boolean hasDouble();

        boolean hasFloat();

        boolean hasInteger();

        boolean hasLong();

        boolean hasString();

        boolean hasStringSet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PreferencesProto() {
    }

    public static final class PreferenceMap extends GeneratedMessageLite<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
        private static final PreferenceMap DEFAULT_INSTANCE;
        private static volatile Parser<PreferenceMap> PARSER = null;
        public static final int PREFERENCES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> preferences_ = MapFieldLite.emptyMapField();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PreferenceMap() {
        }

        private static final class PreferencesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private PreferencesDefaultEntryHolder() {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MapFieldLite<String, Value> internalGetPreferences() {
            return this.preferences_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MapFieldLite<String, Value> internalGetMutablePreferences() {
            if (!this.preferences_.isMutable()) {
                this.preferences_ = this.preferences_.mutableCopy();
            }
            return this.preferences_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
        public int getPreferencesCount() {
            return internalGetPreferences().size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
        public boolean containsPreferences(String str) {
            str.getClass();
            return internalGetPreferences().containsKey(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
        @Deprecated
        public Map<String, Value> getPreferences() {
            return getPreferencesMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
        public Map<String, Value> getPreferencesMap() {
            return Collections.unmodifiableMap(internalGetPreferences());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
        public Value getPreferencesOrDefault(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> internalGetPreferences = internalGetPreferences();
            return internalGetPreferences.containsKey(str) ? internalGetPreferences.get(str) : value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
        public Value getPreferencesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Value> internalGetPreferences = internalGetPreferences();
            if (!internalGetPreferences.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetPreferences.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Map<String, Value> getMutablePreferencesMap() {
            return internalGetMutablePreferences();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(InputStream inputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PreferenceMap) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(PreferenceMap preferenceMap) {
            return DEFAULT_INSTANCE.createBuilder(preferenceMap);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C02881 c02881) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(PreferenceMap.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
            public int getPreferencesCount() {
                return ((PreferenceMap) this.instance).getPreferencesMap().size();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
            public boolean containsPreferences(String str) {
                str.getClass();
                return ((PreferenceMap) this.instance).getPreferencesMap().containsKey(str);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPreferences() {
                copyOnWrite();
                ((PreferenceMap) this.instance).getMutablePreferencesMap().clear();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removePreferences(String str) {
                str.getClass();
                copyOnWrite();
                ((PreferenceMap) this.instance).getMutablePreferencesMap().remove(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
            @Deprecated
            public Map<String, Value> getPreferences() {
                return getPreferencesMap();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
            public Map<String, Value> getPreferencesMap() {
                return Collections.unmodifiableMap(((PreferenceMap) this.instance).getPreferencesMap());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
            public Value getPreferencesOrDefault(String str, Value value) {
                str.getClass();
                Map<String, Value> preferencesMap = ((PreferenceMap) this.instance).getPreferencesMap();
                return preferencesMap.containsKey(str) ? preferencesMap.get(str) : value;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.PreferenceMapOrBuilder
            public Value getPreferencesOrThrow(String str) {
                str.getClass();
                Map<String, Value> preferencesMap = ((PreferenceMap) this.instance).getPreferencesMap();
                if (!preferencesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return preferencesMap.get(str);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder putPreferences(String str, Value value) {
                str.getClass();
                value.getClass();
                copyOnWrite();
                ((PreferenceMap) this.instance).getMutablePreferencesMap().put(str, value);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder putAllPreferences(Map<String, Value> map) {
                copyOnWrite();
                ((PreferenceMap) this.instance).getMutablePreferencesMap().putAll(map);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C02881 c02881 = null;
            switch (C02881.f87xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new PreferenceMap();
                case 2:
                    return new Builder(c02881);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PreferenceMap> parser = PARSER;
                    if (parser == null) {
                        synchronized (PreferenceMap.class) {
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
            PreferenceMap preferenceMap = new PreferenceMap();
            DEFAULT_INSTANCE = preferenceMap;
            GeneratedMessageLite.registerDefaultInstance(PreferenceMap.class, preferenceMap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PreferenceMap getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<PreferenceMap> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: androidx.datastore.preferences.PreferencesProto$1 */
    static /* synthetic */ class C02881 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f87xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f87xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f87xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f87xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f87xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f87xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f87xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f87xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_FIELD_NUMBER = 1;
        private static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_FIELD_NUMBER = 7;
        public static final int FLOAT_FIELD_NUMBER = 2;
        public static final int INTEGER_FIELD_NUMBER = 3;
        public static final int LONG_FIELD_NUMBER = 4;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_FIELD_NUMBER = 5;
        public static final int STRING_SET_FIELD_NUMBER = 6;
        private int bitField0_;
        private int valueCase_ = 0;
        private Object value_;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Value() {
        }

        public enum ValueCase {
            BOOLEAN(1),
            FLOAT(2),
            INTEGER(3),
            LONG(4),
            STRING(5),
            STRING_SET(6),
            DOUBLE(7),
            VALUE_NOT_SET(0);

            private final int value;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            ValueCase(int i) {
                this.value = i;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public static ValueCase valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ValueCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return VALUE_NOT_SET;
                    case 1:
                        return BOOLEAN;
                    case 2:
                        return FLOAT;
                    case 3:
                        return INTEGER;
                    case 4:
                        return LONG;
                    case 5:
                        return STRING;
                    case 6:
                        return STRING_SET;
                    case 7:
                        return DOUBLE;
                    default:
                        return null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public int getNumber() {
                return this.value;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearValue() {
            this.valueCase_ = 0;
            this.value_ = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasBoolean() {
            return this.valueCase_ == 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean getBoolean() {
            if (this.valueCase_ == 1) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setBoolean(boolean z) {
            this.valueCase_ = 1;
            this.value_ = Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearBoolean() {
            if (this.valueCase_ == 1) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasFloat() {
            return this.valueCase_ == 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public float getFloat() {
            if (this.valueCase_ == 2) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setFloat(float f) {
            this.valueCase_ = 2;
            this.value_ = Float.valueOf(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearFloat() {
            if (this.valueCase_ == 2) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasInteger() {
            return this.valueCase_ == 3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public int getInteger() {
            if (this.valueCase_ == 3) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setInteger(int i) {
            this.valueCase_ = 3;
            this.value_ = Integer.valueOf(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearInteger() {
            if (this.valueCase_ == 3) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasLong() {
            return this.valueCase_ == 4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public long getLong() {
            if (this.valueCase_ == 4) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLong(long j) {
            this.valueCase_ = 4;
            this.value_ = Long.valueOf(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearLong() {
            if (this.valueCase_ == 4) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasString() {
            return this.valueCase_ == 5;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public String getString() {
            return this.valueCase_ == 5 ? (String) this.value_ : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public ByteString getStringBytes() {
            return ByteString.copyFromUtf8(this.valueCase_ == 5 ? (String) this.value_ : "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setString(String str) {
            str.getClass();
            this.valueCase_ = 5;
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearString() {
            if (this.valueCase_ == 5) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setStringBytes(ByteString byteString) {
            byteString.getClass();
            this.valueCase_ = 5;
            this.value_ = byteString.toStringUtf8();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasStringSet() {
            return this.valueCase_ == 6;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public StringSet getStringSet() {
            if (this.valueCase_ == 6) {
                return (StringSet) this.value_;
            }
            return StringSet.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setStringSet(StringSet stringSet) {
            stringSet.getClass();
            this.value_ = stringSet;
            this.valueCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setStringSet(StringSet.Builder builder) {
            this.value_ = builder.build();
            this.valueCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeStringSet(StringSet stringSet) {
            stringSet.getClass();
            if (this.valueCase_ == 6 && this.value_ != StringSet.getDefaultInstance()) {
                this.value_ = StringSet.newBuilder((StringSet) this.value_).mergeFrom((StringSet.Builder) stringSet).buildPartial();
            } else {
                this.value_ = stringSet;
            }
            this.valueCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearStringSet() {
            if (this.valueCase_ == 6) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public boolean hasDouble() {
            return this.valueCase_ == 7;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
        public double getDouble() {
            if (this.valueCase_ == 7) {
                return ((Double) this.value_).doubleValue();
            }
            return 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDouble(double d) {
            this.valueCase_ = 7;
            this.value_ = Double.valueOf(d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDouble() {
            if (this.valueCase_ == 7) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(Value value) {
            return DEFAULT_INSTANCE.createBuilder(value);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C02881 c02881) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public ValueCase getValueCase() {
                return ((Value) this.instance).getValueCase();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearValue() {
                copyOnWrite();
                ((Value) this.instance).clearValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasBoolean() {
                return ((Value) this.instance).hasBoolean();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean getBoolean() {
                return ((Value) this.instance).getBoolean();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setBoolean(boolean z) {
                copyOnWrite();
                ((Value) this.instance).setBoolean(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearBoolean() {
                copyOnWrite();
                ((Value) this.instance).clearBoolean();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasFloat() {
                return ((Value) this.instance).hasFloat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public float getFloat() {
                return ((Value) this.instance).getFloat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFloat(float f) {
                copyOnWrite();
                ((Value) this.instance).setFloat(f);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearFloat() {
                copyOnWrite();
                ((Value) this.instance).clearFloat();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasInteger() {
                return ((Value) this.instance).hasInteger();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public int getInteger() {
                return ((Value) this.instance).getInteger();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setInteger(int i) {
                copyOnWrite();
                ((Value) this.instance).setInteger(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearInteger() {
                copyOnWrite();
                ((Value) this.instance).clearInteger();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasLong() {
                return ((Value) this.instance).hasLong();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public long getLong() {
                return ((Value) this.instance).getLong();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setLong(long j) {
                copyOnWrite();
                ((Value) this.instance).setLong(j);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearLong() {
                copyOnWrite();
                ((Value) this.instance).clearLong();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasString() {
                return ((Value) this.instance).hasString();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public String getString() {
                return ((Value) this.instance).getString();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public ByteString getStringBytes() {
                return ((Value) this.instance).getStringBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setString(String str) {
                copyOnWrite();
                ((Value) this.instance).setString(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearString() {
                copyOnWrite();
                ((Value) this.instance).clearString();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setStringBytes(ByteString byteString) {
                copyOnWrite();
                ((Value) this.instance).setStringBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasStringSet() {
                return ((Value) this.instance).hasStringSet();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public StringSet getStringSet() {
                return ((Value) this.instance).getStringSet();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setStringSet(StringSet stringSet) {
                copyOnWrite();
                ((Value) this.instance).setStringSet(stringSet);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setStringSet(StringSet.Builder builder) {
                copyOnWrite();
                ((Value) this.instance).setStringSet(builder);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeStringSet(StringSet stringSet) {
                copyOnWrite();
                ((Value) this.instance).mergeStringSet(stringSet);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearStringSet() {
                copyOnWrite();
                ((Value) this.instance).clearStringSet();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public boolean hasDouble() {
                return ((Value) this.instance).hasDouble();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.ValueOrBuilder
            public double getDouble() {
                return ((Value) this.instance).getDouble();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDouble(double d) {
                copyOnWrite();
                ((Value) this.instance).setDouble(d);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDouble() {
                copyOnWrite();
                ((Value) this.instance).clearDouble();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C02881 c02881 = null;
            switch (C02881.f87xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new Value();
                case 2:
                    return new Builder(c02881);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", StringSet.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Value> parser = PARSER;
                    if (parser == null) {
                        synchronized (Value.class) {
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
            Value value = new Value();
            DEFAULT_INSTANCE = value;
            GeneratedMessageLite.registerDefaultInstance(Value.class, value);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<Value> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StringSet extends GeneratedMessageLite<StringSet, Builder> implements StringSetOrBuilder {
        private static final StringSet DEFAULT_INSTANCE;
        private static volatile Parser<StringSet> PARSER = null;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StringSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
        public List<String> getStringsList() {
            return this.strings_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
        public int getStringsCount() {
            return this.strings_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
        public String getStrings(int i) {
            return this.strings_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
        public ByteString getStringsBytes(int i) {
            return ByteString.copyFromUtf8(this.strings_.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureStringsIsMutable() {
            if (this.strings_.isModifiable()) {
                return;
            }
            this.strings_ = GeneratedMessageLite.mutableCopy(this.strings_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setStrings(int i, String str) {
            str.getClass();
            ensureStringsIsMutable();
            this.strings_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addStrings(String str) {
            str.getClass();
            ensureStringsIsMutable();
            this.strings_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllStrings(Iterable<String> iterable) {
            ensureStringsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.strings_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearStrings() {
            this.strings_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addStringsBytes(ByteString byteString) {
            byteString.getClass();
            ensureStringsIsMutable();
            this.strings_.add(byteString.toStringUtf8());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(InputStream inputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StringSet) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(StringSet stringSet) {
            return DEFAULT_INSTANCE.createBuilder(stringSet);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StringSet, Builder> implements StringSetOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C02881 c02881) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(StringSet.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
            public List<String> getStringsList() {
                return Collections.unmodifiableList(((StringSet) this.instance).getStringsList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
            public int getStringsCount() {
                return ((StringSet) this.instance).getStringsCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
            public String getStrings(int i) {
                return ((StringSet) this.instance).getStrings(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.PreferencesProto.StringSetOrBuilder
            public ByteString getStringsBytes(int i) {
                return ((StringSet) this.instance).getStringsBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setStrings(int i, String str) {
                copyOnWrite();
                ((StringSet) this.instance).setStrings(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addStrings(String str) {
                copyOnWrite();
                ((StringSet) this.instance).addStrings(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllStrings(Iterable<String> iterable) {
                copyOnWrite();
                ((StringSet) this.instance).addAllStrings(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearStrings() {
                copyOnWrite();
                ((StringSet) this.instance).clearStrings();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addStringsBytes(ByteString byteString) {
                copyOnWrite();
                ((StringSet) this.instance).addStringsBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C02881 c02881 = null;
            switch (C02881.f87xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new StringSet();
                case 2:
                    return new Builder(c02881);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StringSet> parser = PARSER;
                    if (parser == null) {
                        synchronized (StringSet.class) {
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
            StringSet stringSet = new StringSet();
            DEFAULT_INSTANCE = stringSet;
            GeneratedMessageLite.registerDefaultInstance(StringSet.class, stringSet);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static StringSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<StringSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
