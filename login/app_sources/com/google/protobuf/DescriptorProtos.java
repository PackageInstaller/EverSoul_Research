package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos {

    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto.ExtensionRange getExtensionRange(int i);

        int getExtensionRangeCount();

        List<DescriptorProto.ExtensionRange> getExtensionRangeList();

        FieldDescriptorProto getField(int i);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        String getName();

        ByteString getNameBytes();

        DescriptorProto getNestedType(int i);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        OneofDescriptorProto getOneofDecl(int i);

        int getOneofDeclCount();

        List<OneofDescriptorProto> getOneofDeclList();

        MessageOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        DescriptorProto.ReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<DescriptorProto.ReservedRange> getReservedRangeList();

        boolean hasName();

        boolean hasOptions();
    }

    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        EnumOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        EnumDescriptorProto.EnumReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<EnumDescriptorProto.EnumReservedRange> getReservedRangeList();

        EnumValueDescriptorProto getValue(int i);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        boolean hasName();

        boolean hasOptions();
    }

    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
        boolean getAllowAlias();

        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasAllowAlias();

        boolean hasDeprecated();
    }

    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getNumber();

        EnumValueOptions getOptions();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDefaultValue();

        ByteString getDefaultValueBytes();

        String getExtendee();

        ByteString getExtendeeBytes();

        String getJsonName();

        ByteString getJsonNameBytes();

        FieldDescriptorProto.Label getLabel();

        String getName();

        ByteString getNameBytes();

        int getNumber();

        int getOneofIndex();

        FieldOptions getOptions();

        boolean getProto3Optional();

        FieldDescriptorProto.Type getType();

        String getTypeName();

        ByteString getTypeNameBytes();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasJsonName();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOneofIndex();

        boolean hasOptions();

        boolean hasProto3Optional();

        boolean hasType();

        boolean hasTypeName();
    }

    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
        FieldOptions.CType getCtype();

        boolean getDeprecated();

        FieldOptions.JSType getJstype();

        boolean getLazy();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean getWeak();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasJstype();

        boolean hasLazy();

        boolean hasPacked();

        boolean hasWeak();
    }

    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDependency(int i);

        ByteString getDependencyBytes(int i);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto getMessageType(int i);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        String getName();

        ByteString getNameBytes();

        FileOptions getOptions();

        String getPackage();

        ByteString getPackageBytes();

        int getPublicDependency(int i);

        int getPublicDependencyCount();

        List<Integer> getPublicDependencyList();

        ServiceDescriptorProto getService(int i);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        SourceCodeInfo getSourceCodeInfo();

        String getSyntax();

        ByteString getSyntaxBytes();

        int getWeakDependency(int i);

        int getWeakDependencyCount();

        List<Integer> getWeakDependencyList();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();

        boolean hasSyntax();
    }

    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
        FileDescriptorProto getFile(int i);

        int getFileCount();

        List<FileDescriptorProto> getFileList();
    }

    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
        boolean getCcEnableArenas();

        boolean getCcGenericServices();

        String getCsharpNamespace();

        ByteString getCsharpNamespaceBytes();

        boolean getDeprecated();

        String getGoPackage();

        ByteString getGoPackageBytes();

        @Deprecated
        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        ByteString getJavaOuterClassnameBytes();

        String getJavaPackage();

        ByteString getJavaPackageBytes();

        boolean getJavaStringCheckUtf8();

        String getObjcClassPrefix();

        ByteString getObjcClassPrefixBytes();

        FileOptions.OptimizeMode getOptimizeFor();

        String getPhpClassPrefix();

        ByteString getPhpClassPrefixBytes();

        boolean getPhpGenericServices();

        String getPhpMetadataNamespace();

        ByteString getPhpMetadataNamespaceBytes();

        String getPhpNamespace();

        ByteString getPhpNamespaceBytes();

        boolean getPyGenericServices();

        String getRubyPackage();

        ByteString getRubyPackageBytes();

        String getSwiftPrefix();

        ByteString getSwiftPrefixBytes();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasCcEnableArenas();

        boolean hasCcGenericServices();

        boolean hasCsharpNamespace();

        boolean hasDeprecated();

        boolean hasGoPackage();

        @Deprecated
        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasJavaStringCheckUtf8();

        boolean hasObjcClassPrefix();

        boolean hasOptimizeFor();

        boolean hasPhpClassPrefix();

        boolean hasPhpGenericServices();

        boolean hasPhpMetadataNamespace();

        boolean hasPhpNamespace();

        boolean hasPyGenericServices();

        boolean hasRubyPackage();

        boolean hasSwiftPrefix();
    }

    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
        GeneratedCodeInfo.Annotation getAnnotation(int i);

        int getAnnotationCount();

        List<GeneratedCodeInfo.Annotation> getAnnotationList();
    }

    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
        boolean getDeprecated();

        boolean getMapEntry();

        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasMapEntry();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        boolean getClientStreaming();

        String getInputType();

        ByteString getInputTypeBytes();

        String getName();

        ByteString getNameBytes();

        MethodOptions getOptions();

        String getOutputType();

        ByteString getOutputTypeBytes();

        boolean getServerStreaming();

        boolean hasClientStreaming();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();

        boolean hasServerStreaming();
    }

    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
        boolean getDeprecated();

        MethodOptions.IdempotencyLevel getIdempotencyLevel();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasIdempotencyLevel();
    }

    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        OneofOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        MethodDescriptorProto getMethod(int i);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        String getName();

        ByteString getNameBytes();

        ServiceOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
        SourceCodeInfo.Location getLocation(int i);

        int getLocationCount();

        List<SourceCodeInfo.Location> getLocationList();
    }

    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
        String getAggregateValue();

        ByteString getAggregateValueBytes();

        double getDoubleValue();

        String getIdentifierValue();

        ByteString getIdentifierValueBytes();

        UninterpretedOption.NamePart getName(int i);

        int getNameCount();

        List<UninterpretedOption.NamePart> getNameList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DescriptorProtos() {
    }

    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        private static final FileDescriptorSet DEFAULT_INSTANCE;
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<FileDescriptorProto> file_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileDescriptorSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public FileDescriptorProto getFile(int i) {
            return this.file_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FileDescriptorProtoOrBuilder getFileOrBuilder(int i) {
            return this.file_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureFileIsMutable() {
            Internal.ProtobufList<FileDescriptorProto> protobufList = this.file_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.file_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setFile(int i, FileDescriptorProto fileDescriptorProto) {
            fileDescriptorProto.getClass();
            ensureFileIsMutable();
            this.file_.set(i, fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addFile(FileDescriptorProto fileDescriptorProto) {
            fileDescriptorProto.getClass();
            ensureFileIsMutable();
            this.file_.add(fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addFile(int i, FileDescriptorProto fileDescriptorProto) {
            fileDescriptorProto.getClass();
            ensureFileIsMutable();
            this.file_.add(i, fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
            ensureFileIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.file_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearFile() {
            this.file_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeFile(int i) {
            ensureFileIsMutable();
            this.file_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(FileDescriptorSet fileDescriptorSet) {
            return DEFAULT_INSTANCE.createBuilder(fileDescriptorSet);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(FileDescriptorSet.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public List<FileDescriptorProto> getFileList() {
                return Collections.unmodifiableList(((FileDescriptorSet) this.instance).getFileList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public int getFileCount() {
                return ((FileDescriptorSet) this.instance).getFileCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public FileDescriptorProto getFile(int i) {
                return ((FileDescriptorSet) this.instance).getFile(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFile(int i, FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).setFile(i, fileDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFile(int i, FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).setFile(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addFile(FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(fileDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addFile(int i, FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(i, fileDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addFile(FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addFile(int i, FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addAllFile(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearFile() {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).clearFile();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeFile(int i) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).removeFile(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorSet();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"file_", FileDescriptorProto.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorSet> parser = PARSER;
                    if (parser == null) {
                        synchronized (FileDescriptorSet.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            FileDescriptorSet fileDescriptorSet = new FileDescriptorSet();
            DEFAULT_INSTANCE = fileDescriptorSet;
            GeneratedMessageLite.registerDefaultInstance(FileDescriptorSet.class, fileDescriptorSet);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<FileDescriptorSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.protobuf.DescriptorProtos$1 */
    static /* synthetic */ class C19991 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f469xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f469xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f469xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f469xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f469xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f469xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f469xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f469xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        private static final FileDescriptorProto DEFAULT_INSTANCE;
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private FileOptions options_;
        private SourceCodeInfo sourceCodeInfo_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String package_ = "";
        private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.IntList publicDependency_ = emptyIntList();
        private Internal.IntList weakDependency_ = emptyIntList();
        private Internal.ProtobufList<DescriptorProto> messageType_ = emptyProtobufList();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = emptyProtobufList();
        private Internal.ProtobufList<ServiceDescriptorProto> service_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = emptyProtobufList();
        private String syntax_ = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileDescriptorProto() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasPackage() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getPackage() {
            return this.package_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getPackageBytes() {
            return ByteString.copyFromUtf8(this.package_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPackage(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.package_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPackage() {
            this.bitField0_ &= -3;
            this.package_ = getDefaultInstance().getPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPackageBytes(ByteString byteString) {
            this.package_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<String> getDependencyList() {
            return this.dependency_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getDependencyCount() {
            return this.dependency_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getDependency(int i) {
            return this.dependency_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getDependencyBytes(int i) {
            return ByteString.copyFromUtf8(this.dependency_.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureDependencyIsMutable() {
            Internal.ProtobufList<String> protobufList = this.dependency_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dependency_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDependency(int i, String str) {
            str.getClass();
            ensureDependencyIsMutable();
            this.dependency_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addDependency(String str) {
            str.getClass();
            ensureDependencyIsMutable();
            this.dependency_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllDependency(Iterable<String> iterable) {
            ensureDependencyIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDependency() {
            this.dependency_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addDependencyBytes(ByteString byteString) {
            ensureDependencyIsMutable();
            this.dependency_.add(byteString.toStringUtf8());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getPublicDependency(int i) {
            return this.publicDependency_.getInt(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensurePublicDependencyIsMutable() {
            Internal.IntList intList = this.publicDependency_;
            if (intList.isModifiable()) {
                return;
            }
            this.publicDependency_ = GeneratedMessageLite.mutableCopy(intList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPublicDependency(int i, int i2) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.setInt(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addPublicDependency(int i) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.addInt(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllPublicDependency(Iterable<? extends Integer> iterable) {
            ensurePublicDependencyIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.publicDependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPublicDependency() {
            this.publicDependency_ = emptyIntList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getWeakDependency(int i) {
            return this.weakDependency_.getInt(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureWeakDependencyIsMutable() {
            Internal.IntList intList = this.weakDependency_;
            if (intList.isModifiable()) {
                return;
            }
            this.weakDependency_ = GeneratedMessageLite.mutableCopy(intList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setWeakDependency(int i, int i2) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.setInt(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addWeakDependency(int i) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.addInt(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllWeakDependency(Iterable<? extends Integer> iterable) {
            ensureWeakDependencyIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.weakDependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearWeakDependency() {
            this.weakDependency_ = emptyIntList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public DescriptorProto getMessageType(int i) {
            return this.messageType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i) {
            return this.messageType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureMessageTypeIsMutable() {
            Internal.ProtobufList<DescriptorProto> protobufList = this.messageType_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.messageType_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMessageType(int i, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            ensureMessageTypeIsMutable();
            this.messageType_.set(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addMessageType(DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            ensureMessageTypeIsMutable();
            this.messageType_.add(descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addMessageType(int i, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            ensureMessageTypeIsMutable();
            this.messageType_.add(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
            ensureMessageTypeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.messageType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearMessageType() {
            this.messageType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeMessageType(int i) {
            ensureMessageTypeIsMutable();
            this.messageType_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int i) {
            return this.enumType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
            return this.enumType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureEnumTypeIsMutable() {
            Internal.ProtobufList<EnumDescriptorProto> protobufList = this.enumType_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.enumType_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addEnumType(EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            ensureEnumTypeIsMutable();
            this.enumType_.add(enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.enumType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearEnumType() {
            this.enumType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeEnumType(int i) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getServiceCount() {
            return this.service_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ServiceDescriptorProto getService(int i) {
            return this.service_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i) {
            return this.service_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureServiceIsMutable() {
            Internal.ProtobufList<ServiceDescriptorProto> protobufList = this.service_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.service_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setService(int i, ServiceDescriptorProto serviceDescriptorProto) {
            serviceDescriptorProto.getClass();
            ensureServiceIsMutable();
            this.service_.set(i, serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addService(ServiceDescriptorProto serviceDescriptorProto) {
            serviceDescriptorProto.getClass();
            ensureServiceIsMutable();
            this.service_.add(serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addService(int i, ServiceDescriptorProto serviceDescriptorProto) {
            serviceDescriptorProto.getClass();
            ensureServiceIsMutable();
            this.service_.add(i, serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
            ensureServiceIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.service_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearService() {
            this.service_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeService(int i) {
            ensureServiceIsMutable();
            this.service_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int i) {
            return this.extension_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
            return this.extension_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureExtensionIsMutable() {
            Internal.ProtobufList<FieldDescriptorProto> protobufList = this.extension_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.extension_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureExtensionIsMutable();
            this.extension_.set(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addExtension(FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureExtensionIsMutable();
            this.extension_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureExtensionIsMutable();
            this.extension_.add(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureExtensionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.extension_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearExtension() {
            this.extension_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeExtension(int i) {
            ensureExtensionIsMutable();
            this.extension_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(FileOptions fileOptions) {
            fileOptions.getClass();
            this.options_ = fileOptions;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(FileOptions fileOptions) {
            fileOptions.getClass();
            FileOptions fileOptions2 = this.options_;
            if (fileOptions2 != null && fileOptions2 != FileOptions.getDefaultInstance()) {
                this.options_ = ((FileOptions.Builder) FileOptions.newBuilder(this.options_).mergeFrom((FileOptions.Builder) fileOptions)).buildPartial();
            } else {
                this.options_ = fileOptions;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
            sourceCodeInfo.getClass();
            this.sourceCodeInfo_ = sourceCodeInfo;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
            sourceCodeInfo.getClass();
            SourceCodeInfo sourceCodeInfo2 = this.sourceCodeInfo_;
            if (sourceCodeInfo2 != null && sourceCodeInfo2 != SourceCodeInfo.getDefaultInstance()) {
                this.sourceCodeInfo_ = SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom((SourceCodeInfo.Builder) sourceCodeInfo).buildPartial();
            } else {
                this.sourceCodeInfo_ = sourceCodeInfo;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearSourceCodeInfo() {
            this.sourceCodeInfo_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSyntax() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getSyntax() {
            return this.syntax_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getSyntaxBytes() {
            return ByteString.copyFromUtf8(this.syntax_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSyntax(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.syntax_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = getDefaultInstance().getSyntax();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSyntaxBytes(ByteString byteString) {
            this.syntax_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(FileDescriptorProto fileDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(fileDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(FileDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((FileDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getName() {
                return ((FileDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((FileDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasPackage() {
                return ((FileDescriptorProto) this.instance).hasPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getPackage() {
                return ((FileDescriptorProto) this.instance).getPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getPackageBytes() {
                return ((FileDescriptorProto) this.instance).getPackageBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPackage(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPackage(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPackage() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearPackage();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPackageBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<String> getDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getDependencyList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getDependencyCount() {
                return ((FileDescriptorProto) this.instance).getDependencyCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getDependency(int i) {
                return ((FileDescriptorProto) this.instance).getDependency(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getDependencyBytes(int i) {
                return ((FileDescriptorProto) this.instance).getDependencyBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDependency(int i, String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setDependency(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addDependency(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addDependency(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllDependency(Iterable<String> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllDependency(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearDependency();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addDependencyBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addDependencyBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<Integer> getPublicDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getPublicDependencyList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getPublicDependencyCount() {
                return ((FileDescriptorProto) this.instance).getPublicDependencyCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getPublicDependency(int i) {
                return ((FileDescriptorProto) this.instance).getPublicDependency(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPublicDependency(int i, int i2) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPublicDependency(i, i2);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addPublicDependency(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addPublicDependency(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllPublicDependency(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllPublicDependency(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPublicDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearPublicDependency();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<Integer> getWeakDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getWeakDependencyList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getWeakDependencyCount() {
                return ((FileDescriptorProto) this.instance).getWeakDependencyCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getWeakDependency(int i) {
                return ((FileDescriptorProto) this.instance).getWeakDependency(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setWeakDependency(int i, int i2) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setWeakDependency(i, i2);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addWeakDependency(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addWeakDependency(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllWeakDependency(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllWeakDependency(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearWeakDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearWeakDependency();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<DescriptorProto> getMessageTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getMessageTypeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getMessageTypeCount() {
                return ((FileDescriptorProto) this.instance).getMessageTypeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public DescriptorProto getMessageType(int i) {
                return ((FileDescriptorProto) this.instance).getMessageType(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMessageType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setMessageType(i, descriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMessageType(int i, DescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setMessageType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMessageType(DescriptorProto descriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(descriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMessageType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(i, descriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMessageType(DescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMessageType(int i, DescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllMessageType(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMessageType() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearMessageType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeMessageType(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeMessageType(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getEnumTypeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return ((FileDescriptorProto) this.instance).getEnumTypeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int i) {
                return ((FileDescriptorProto) this.instance).getEnumType(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setEnumType(i, enumDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setEnumType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(enumDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(i, enumDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllEnumType(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearEnumType() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearEnumType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeEnumType(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeEnumType(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<ServiceDescriptorProto> getServiceList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getServiceList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getServiceCount() {
                return ((FileDescriptorProto) this.instance).getServiceCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ServiceDescriptorProto getService(int i) {
                return ((FileDescriptorProto) this.instance).getService(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setService(int i, ServiceDescriptorProto serviceDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setService(i, serviceDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setService(int i, ServiceDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setService(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addService(ServiceDescriptorProto serviceDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(serviceDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addService(int i, ServiceDescriptorProto serviceDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(i, serviceDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addService(ServiceDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addService(int i, ServiceDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllService(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearService() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearService();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeService(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeService(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getExtensionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getExtensionCount() {
                return ((FileDescriptorProto) this.instance).getExtensionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int i) {
                return ((FileDescriptorProto) this.instance).getExtension(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setExtension(i, fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setExtension(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(i, fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllExtension(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearExtension() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearExtension();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeExtension(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeExtension(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((FileDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FileOptions getOptions() {
                return ((FileDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(FileOptions fileOptions) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setOptions(fileOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(FileOptions.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setOptions((FileOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(FileOptions fileOptions) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).mergeOptions(fileOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearOptions();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSourceCodeInfo() {
                return ((FileDescriptorProto) this.instance).hasSourceCodeInfo();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public SourceCodeInfo getSourceCodeInfo() {
                return ((FileDescriptorProto) this.instance).getSourceCodeInfo();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSourceCodeInfo(sourceCodeInfo);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSourceCodeInfo(SourceCodeInfo.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSourceCodeInfo(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).mergeSourceCodeInfo(sourceCodeInfo);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearSourceCodeInfo() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearSourceCodeInfo();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSyntax() {
                return ((FileDescriptorProto) this.instance).hasSyntax();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getSyntax() {
                return ((FileDescriptorProto) this.instance).getSyntax();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getSyntaxBytes() {
                return ((FileDescriptorProto) this.instance).getSyntaxBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSyntax(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSyntax(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearSyntax() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearSyntax();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSyntaxBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSyntaxBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0007\u0005\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tဉ\u0003\n\u0016\u000b\u0016\fဈ\u0004", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "service_", ServiceDescriptorProto.class, "extension_", FieldDescriptorProto.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (FileDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            FileDescriptorProto fileDescriptorProto = new FileDescriptorProto();
            DEFAULT_INSTANCE = fileDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(FileDescriptorProto.class, fileDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<FileDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        private static final DescriptorProto DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private MessageOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<FieldDescriptorProto> field_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = emptyProtobufList();
        private Internal.ProtobufList<DescriptorProto> nestedType_ = emptyProtobufList();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = emptyProtobufList();
        private Internal.ProtobufList<ExtensionRange> extensionRange_ = emptyProtobufList();
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_ = emptyProtobufList();
        private Internal.ProtobufList<ReservedRange> reservedRange_ = emptyProtobufList();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();

        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            ExtensionRangeOptions getOptions();

            int getStart();

            boolean hasEnd();

            boolean hasOptions();

            boolean hasStart();
        }

        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DescriptorProto() {
        }

        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            private static final ExtensionRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = 2;
            private ExtensionRangeOptions options_;
            private int start_;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private ExtensionRange() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 4) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public ExtensionRangeOptions getOptions() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                return extensionRangeOptions == null ? ExtensionRangeOptions.getDefaultInstance() : extensionRangeOptions;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setOptions(ExtensionRangeOptions extensionRangeOptions) {
                extensionRangeOptions.getClass();
                this.options_ = extensionRangeOptions;
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                extensionRangeOptions.getClass();
                ExtensionRangeOptions extensionRangeOptions2 = this.options_;
                if (extensionRangeOptions2 != null && extensionRangeOptions2 != ExtensionRangeOptions.getDefaultInstance()) {
                    this.options_ = ((ExtensionRangeOptions.Builder) ExtensionRangeOptions.newBuilder(this.options_).mergeFrom((ExtensionRangeOptions.Builder) extensionRangeOptions)).buildPartial();
                } else {
                    this.options_ = extensionRangeOptions;
                }
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearOptions() {
                this.options_ = null;
                this.bitField0_ &= -5;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder(ExtensionRange extensionRange) {
                return DEFAULT_INSTANCE.createBuilder(extensionRange);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ Builder(C19991 c19991) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Builder() {
                    super(ExtensionRange.DEFAULT_INSTANCE);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasStart() {
                    return ((ExtensionRange) this.instance).hasStart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getStart() {
                    return ((ExtensionRange) this.instance).getStart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setStart(int i) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setStart(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearStart() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearStart();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasEnd() {
                    return ((ExtensionRange) this.instance).hasEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getEnd() {
                    return ((ExtensionRange) this.instance).getEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setEnd(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearEnd() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearEnd();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasOptions() {
                    return ((ExtensionRange) this.instance).hasOptions();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public ExtensionRangeOptions getOptions() {
                    return ((ExtensionRange) this.instance).getOptions();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setOptions(ExtensionRangeOptions extensionRangeOptions) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setOptions(extensionRangeOptions);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setOptions(ExtensionRangeOptions.Builder builder) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setOptions((ExtensionRangeOptions) builder.build());
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).mergeOptions(extensionRangeOptions);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearOptions() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearOptions();
                    return this;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C19991 c19991 = null;
                switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ExtensionRange();
                    case 2:
                        return new Builder(c19991);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ExtensionRange> parser = PARSER;
                        if (parser == null) {
                            synchronized (ExtensionRange.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static {
                ExtensionRange extensionRange = new ExtensionRange();
                DEFAULT_INSTANCE = extensionRange;
                GeneratedMessageLite.registerDefaultInstance(ExtensionRange.class, extensionRange);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ExtensionRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Parser<ExtensionRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            private static final ReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private ReservedRange() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder(ReservedRange reservedRange) {
                return DEFAULT_INSTANCE.createBuilder(reservedRange);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ Builder(C19991 c19991) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Builder() {
                    super(ReservedRange.DEFAULT_INSTANCE);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public boolean hasStart() {
                    return ((ReservedRange) this.instance).hasStart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public int getStart() {
                    return ((ReservedRange) this.instance).getStart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setStart(int i) {
                    copyOnWrite();
                    ((ReservedRange) this.instance).setStart(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearStart() {
                    copyOnWrite();
                    ((ReservedRange) this.instance).clearStart();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public boolean hasEnd() {
                    return ((ReservedRange) this.instance).hasEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public int getEnd() {
                    return ((ReservedRange) this.instance).getEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((ReservedRange) this.instance).setEnd(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearEnd() {
                    copyOnWrite();
                    ((ReservedRange) this.instance).clearEnd();
                    return this;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C19991 c19991 = null;
                switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ReservedRange();
                    case 2:
                        return new Builder(c19991);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ReservedRange> parser = PARSER;
                        if (parser == null) {
                            synchronized (ReservedRange.class) {
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
                ReservedRange reservedRange = new ReservedRange();
                DEFAULT_INSTANCE = reservedRange;
                GeneratedMessageLite.registerDefaultInstance(ReservedRange.class, reservedRange);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static ReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Parser<ReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getFieldCount() {
            return this.field_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getField(int i) {
            return this.field_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i) {
            return this.field_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureFieldIsMutable() {
            Internal.ProtobufList<FieldDescriptorProto> protobufList = this.field_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.field_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setField(int i, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureFieldIsMutable();
            this.field_.set(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addField(FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureFieldIsMutable();
            this.field_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addField(int i, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureFieldIsMutable();
            this.field_.add(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureFieldIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.field_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearField() {
            this.field_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeField(int i) {
            ensureFieldIsMutable();
            this.field_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int i) {
            return this.extension_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
            return this.extension_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureExtensionIsMutable() {
            Internal.ProtobufList<FieldDescriptorProto> protobufList = this.extension_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.extension_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureExtensionIsMutable();
            this.extension_.set(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addExtension(FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureExtensionIsMutable();
            this.extension_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            ensureExtensionIsMutable();
            this.extension_.add(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureExtensionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.extension_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearExtension() {
            this.extension_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeExtension(int i) {
            ensureExtensionIsMutable();
            this.extension_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public DescriptorProto getNestedType(int i) {
            return this.nestedType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i) {
            return this.nestedType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureNestedTypeIsMutable() {
            Internal.ProtobufList<DescriptorProto> protobufList = this.nestedType_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.nestedType_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNestedType(int i, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            ensureNestedTypeIsMutable();
            this.nestedType_.set(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addNestedType(DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            ensureNestedTypeIsMutable();
            this.nestedType_.add(descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addNestedType(int i, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            ensureNestedTypeIsMutable();
            this.nestedType_.add(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
            ensureNestedTypeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.nestedType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearNestedType() {
            this.nestedType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeNestedType(int i) {
            ensureNestedTypeIsMutable();
            this.nestedType_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int i) {
            return this.enumType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
            return this.enumType_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureEnumTypeIsMutable() {
            Internal.ProtobufList<EnumDescriptorProto> protobufList = this.enumType_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.enumType_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addEnumType(EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            ensureEnumTypeIsMutable();
            this.enumType_.add(enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.enumType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearEnumType() {
            this.enumType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeEnumType(int i) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ExtensionRange getExtensionRange(int i) {
            return this.extensionRange_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i) {
            return this.extensionRange_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureExtensionRangeIsMutable() {
            Internal.ProtobufList<ExtensionRange> protobufList = this.extensionRange_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.extensionRange_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setExtensionRange(int i, ExtensionRange extensionRange) {
            extensionRange.getClass();
            ensureExtensionRangeIsMutable();
            this.extensionRange_.set(i, extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addExtensionRange(ExtensionRange extensionRange) {
            extensionRange.getClass();
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addExtensionRange(int i, ExtensionRange extensionRange) {
            extensionRange.getClass();
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(i, extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
            ensureExtensionRangeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.extensionRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearExtensionRange() {
            this.extensionRange_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeExtensionRange(int i) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public OneofDescriptorProto getOneofDecl(int i) {
            return this.oneofDecl_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int i) {
            return this.oneofDecl_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureOneofDeclIsMutable() {
            Internal.ProtobufList<OneofDescriptorProto> protobufList = this.oneofDecl_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.oneofDecl_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
            oneofDescriptorProto.getClass();
            ensureOneofDeclIsMutable();
            this.oneofDecl_.set(i, oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
            oneofDescriptorProto.getClass();
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
            oneofDescriptorProto.getClass();
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(i, oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
            ensureOneofDeclIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.oneofDecl_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOneofDecl() {
            this.oneofDecl_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeOneofDecl(int i) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(MessageOptions messageOptions) {
            messageOptions.getClass();
            this.options_ = messageOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(MessageOptions messageOptions) {
            messageOptions.getClass();
            MessageOptions messageOptions2 = this.options_;
            if (messageOptions2 != null && messageOptions2 != MessageOptions.getDefaultInstance()) {
                this.options_ = ((MessageOptions.Builder) MessageOptions.newBuilder(this.options_).mergeFrom((MessageOptions.Builder) messageOptions)).buildPartial();
            } else {
                this.options_ = messageOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends ReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ReservedRange getReservedRange(int i) {
            return this.reservedRange_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
            return this.reservedRange_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureReservedRangeIsMutable() {
            Internal.ProtobufList<ReservedRange> protobufList = this.reservedRange_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.reservedRange_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setReservedRange(int i, ReservedRange reservedRange) {
            reservedRange.getClass();
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedRange(ReservedRange reservedRange) {
            reservedRange.getClass();
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedRange(int i, ReservedRange reservedRange) {
            reservedRange.getClass();
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.reservedRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearReservedRange() {
            this.reservedRange_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeReservedRange(int i) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getReservedName(int i) {
            return this.reservedName_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ByteString getReservedNameBytes(int i) {
            return ByteString.copyFromUtf8(this.reservedName_.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureReservedNameIsMutable() {
            Internal.ProtobufList<String> protobufList = this.reservedName_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.reservedName_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setReservedName(int i, String str) {
            str.getClass();
            ensureReservedNameIsMutable();
            this.reservedName_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedName(String str) {
            str.getClass();
            ensureReservedNameIsMutable();
            this.reservedName_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllReservedName(Iterable<String> iterable) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.reservedName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedNameBytes(ByteString byteString) {
            ensureReservedNameIsMutable();
            this.reservedName_.add(byteString.toStringUtf8());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(DescriptorProto descriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(descriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(DescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasName() {
                return ((DescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getName() {
                return ((DescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((DescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getFieldList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getFieldList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getFieldCount() {
                return ((DescriptorProto) this.instance).getFieldCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getField(int i) {
                return ((DescriptorProto) this.instance).getField(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setField(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setField(i, fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setField(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setField(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addField(FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addField(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(i, fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addField(FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addField(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllField(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearField() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearField();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeField(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeField(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getExtensionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionCount() {
                return ((DescriptorProto) this.instance).getExtensionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int i) {
                return ((DescriptorProto) this.instance).getExtension(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtension(i, fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtension(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(i, fieldDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllExtension(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearExtension() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearExtension();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeExtension(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeExtension(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<DescriptorProto> getNestedTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getNestedTypeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getNestedTypeCount() {
                return ((DescriptorProto) this.instance).getNestedTypeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public DescriptorProto getNestedType(int i) {
                return ((DescriptorProto) this.instance).getNestedType(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNestedType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNestedType(i, descriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNestedType(int i, Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNestedType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addNestedType(DescriptorProto descriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(descriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addNestedType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(i, descriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addNestedType(Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addNestedType(int i, Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllNestedType(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearNestedType() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearNestedType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeNestedType(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeNestedType(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getEnumTypeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return ((DescriptorProto) this.instance).getEnumTypeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int i) {
                return ((DescriptorProto) this.instance).getEnumType(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setEnumType(i, enumDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setEnumType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(enumDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(i, enumDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllEnumType(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearEnumType() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearEnumType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeEnumType(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeEnumType(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ExtensionRange> getExtensionRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getExtensionRangeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionRangeCount() {
                return ((DescriptorProto) this.instance).getExtensionRangeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ExtensionRange getExtensionRange(int i) {
                return ((DescriptorProto) this.instance).getExtensionRange(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtensionRange(int i, ExtensionRange extensionRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtensionRange(i, extensionRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtensionRange(int i, ExtensionRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtensionRange(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtensionRange(ExtensionRange extensionRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(extensionRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtensionRange(int i, ExtensionRange extensionRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(i, extensionRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtensionRange(ExtensionRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addExtensionRange(int i, ExtensionRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllExtensionRange(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearExtensionRange() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearExtensionRange();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeExtensionRange(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeExtensionRange(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<OneofDescriptorProto> getOneofDeclList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getOneofDeclList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getOneofDeclCount() {
                return ((DescriptorProto) this.instance).getOneofDeclCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public OneofDescriptorProto getOneofDecl(int i) {
                return ((DescriptorProto) this.instance).getOneofDecl(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOneofDecl(i, oneofDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOneofDecl(int i, OneofDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOneofDecl(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(oneofDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(i, oneofDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addOneofDecl(OneofDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addOneofDecl(int i, OneofDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllOneofDecl(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOneofDecl() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearOneofDecl();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeOneofDecl(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeOneofDecl(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((DescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public MessageOptions getOptions() {
                return ((DescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(MessageOptions messageOptions) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOptions(messageOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(MessageOptions.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOptions((MessageOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(MessageOptions messageOptions) {
                copyOnWrite();
                ((DescriptorProto) this.instance).mergeOptions(messageOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearOptions();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getReservedRangeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getReservedRangeCount() {
                return ((DescriptorProto) this.instance).getReservedRangeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ReservedRange getReservedRange(int i) {
                return ((DescriptorProto) this.instance).getReservedRange(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setReservedRange(int i, ReservedRange reservedRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedRange(i, reservedRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setReservedRange(int i, ReservedRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedRange(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(ReservedRange reservedRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(reservedRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(int i, ReservedRange reservedRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(i, reservedRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(ReservedRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(int i, ReservedRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllReservedRange(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearReservedRange() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearReservedRange();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeReservedRange(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeReservedRange(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getReservedNameList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getReservedNameCount() {
                return ((DescriptorProto) this.instance).getReservedNameCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getReservedName(int i) {
                return ((DescriptorProto) this.instance).getReservedName(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ByteString getReservedNameBytes(int i) {
                return ((DescriptorProto) this.instance).getReservedNameBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setReservedName(int i, String str) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedName(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedName(String str) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllReservedName(Iterable<String> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllReservedName(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearReservedName() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearReservedName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedNameBytes(ByteString byteString) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedNameBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new DescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001b\n\u001a", new Object[]{"bitField0_", "name_", "field_", FieldDescriptorProto.class, "nestedType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "extensionRange_", ExtensionRange.class, "extension_", FieldDescriptorProto.class, "options_", "oneofDecl_", OneofDescriptorProto.class, "reservedRange_", ReservedRange.class, "reservedName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (DescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            DescriptorProto descriptorProto = new DescriptorProto();
            DEFAULT_INSTANCE = descriptorProto;
            GeneratedMessageLite.registerDefaultInstance(DescriptorProto.class, descriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<DescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        private static final ExtensionRangeOptions DEFAULT_INSTANCE;
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ExtensionRangeOptions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(ExtensionRangeOptions extensionRangeOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(extensionRangeOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(ExtensionRangeOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ExtensionRangeOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((ExtensionRangeOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((ExtensionRangeOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExtensionRangeOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000ϧϧ\u0001\u0000\u0001\u0001ϧЛ", new Object[]{"uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExtensionRangeOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExtensionRangeOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions();
            DEFAULT_INSTANCE = extensionRangeOptions;
            GeneratedMessageLite.registerDefaultInstance(ExtensionRangeOptions.class, extensionRangeOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ExtensionRangeOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<ExtensionRangeOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        private static final FieldDescriptorProto DEFAULT_INSTANCE;
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private boolean proto3Optional_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int label_ = 1;
        private int type_ = 1;
        private String typeName_ = "";
        private String extendee_ = "";
        private String defaultValue_ = "";
        private String jsonName_ = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FieldDescriptorProto() {
        }

        public enum Type implements Internal.EnumLite {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);

            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Type findValueByNumber(int i) {
                    return Type.forNumber(i);
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
            public static Type valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Type forNumber(int i) {
                switch (i) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumVerifier internalGetVerifier() {
                return TypeVerifier.INSTANCE;
            }

            private static final class TypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new TypeVerifier();

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private TypeVerifier() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Type.forNumber(i) != null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            Type(int i) {
                this.value = i;
            }
        }

        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);

            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private static final Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap<Label>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Label findValueByNumber(int i) {
                    return Label.forNumber(i);
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
            public static Label valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Label forNumber(int i) {
                if (i == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i == 2) {
                    return LABEL_REQUIRED;
                }
                if (i != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumVerifier internalGetVerifier() {
                return LabelVerifier.INSTANCE;
            }

            private static final class LabelVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new LabelVerifier();

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private LabelVerifier() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Label.forNumber(i) != null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            Label(int i) {
                this.value = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasNumber() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNumber(int i) {
            this.bitField0_ |= 2;
            this.number_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasLabel() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Label getLabel() {
            Label forNumber = Label.forNumber(this.label_);
            return forNumber == null ? Label.LABEL_OPTIONAL : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLabel(Label label) {
            this.label_ = label.getNumber();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearLabel() {
            this.bitField0_ &= -5;
            this.label_ = 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Type getType() {
            Type forNumber = Type.forNumber(this.type_);
            return forNumber == null ? Type.TYPE_DOUBLE : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setType(Type type) {
            this.type_ = type.getNumber();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasTypeName() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getTypeName() {
            return this.typeName_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getTypeNameBytes() {
            return ByteString.copyFromUtf8(this.typeName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setTypeName(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.typeName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearTypeName() {
            this.bitField0_ &= -17;
            this.typeName_ = getDefaultInstance().getTypeName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setTypeNameBytes(ByteString byteString) {
            this.typeName_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasExtendee() {
            return (this.bitField0_ & 32) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getExtendee() {
            return this.extendee_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getExtendeeBytes() {
            return ByteString.copyFromUtf8(this.extendee_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setExtendee(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.extendee_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearExtendee() {
            this.bitField0_ &= -33;
            this.extendee_ = getDefaultInstance().getExtendee();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setExtendeeBytes(ByteString byteString) {
            this.extendee_ = byteString.toStringUtf8();
            this.bitField0_ |= 32;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getDefaultValue() {
            return this.defaultValue_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getDefaultValueBytes() {
            return ByteString.copyFromUtf8(this.defaultValue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDefaultValue(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.defaultValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDefaultValue() {
            this.bitField0_ &= -65;
            this.defaultValue_ = getDefaultInstance().getDefaultValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDefaultValueBytes(ByteString byteString) {
            this.defaultValue_ = byteString.toStringUtf8();
            this.bitField0_ |= 64;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOneofIndex() {
            return (this.bitField0_ & 128) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOneofIndex(int i) {
            this.bitField0_ |= 128;
            this.oneofIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOneofIndex() {
            this.bitField0_ &= -129;
            this.oneofIndex_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasJsonName() {
            return (this.bitField0_ & 256) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getJsonName() {
            return this.jsonName_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getJsonNameBytes() {
            return ByteString.copyFromUtf8(this.jsonName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJsonName(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.jsonName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJsonName() {
            this.bitField0_ &= -257;
            this.jsonName_ = getDefaultInstance().getJsonName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJsonNameBytes(ByteString byteString) {
            this.jsonName_ = byteString.toStringUtf8();
            this.bitField0_ |= 256;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 512) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(FieldOptions fieldOptions) {
            fieldOptions.getClass();
            this.options_ = fieldOptions;
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(FieldOptions fieldOptions) {
            fieldOptions.getClass();
            FieldOptions fieldOptions2 = this.options_;
            if (fieldOptions2 != null && fieldOptions2 != FieldOptions.getDefaultInstance()) {
                this.options_ = ((FieldOptions.Builder) FieldOptions.newBuilder(this.options_).mergeFrom((FieldOptions.Builder) fieldOptions)).buildPartial();
            } else {
                this.options_ = fieldOptions;
            }
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -513;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasProto3Optional() {
            return (this.bitField0_ & 1024) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean getProto3Optional() {
            return this.proto3Optional_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setProto3Optional(boolean z) {
            this.bitField0_ |= 1024;
            this.proto3Optional_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearProto3Optional() {
            this.bitField0_ &= -1025;
            this.proto3Optional_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(FieldDescriptorProto fieldDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(fieldDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(FieldDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((FieldDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getName() {
                return ((FieldDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((FieldDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return ((FieldDescriptorProto) this.instance).hasNumber();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getNumber() {
                return ((FieldDescriptorProto) this.instance).getNumber();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNumber(int i) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setNumber(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearNumber() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearNumber();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasLabel() {
                return ((FieldDescriptorProto) this.instance).hasLabel();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Label getLabel() {
                return ((FieldDescriptorProto) this.instance).getLabel();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setLabel(Label label) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setLabel(label);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearLabel() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearLabel();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasType() {
                return ((FieldDescriptorProto) this.instance).hasType();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Type getType() {
                return ((FieldDescriptorProto) this.instance).getType();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setType(Type type) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setType(type);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearType() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasTypeName() {
                return ((FieldDescriptorProto) this.instance).hasTypeName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getTypeName() {
                return ((FieldDescriptorProto) this.instance).getTypeName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getTypeNameBytes() {
                return ((FieldDescriptorProto) this.instance).getTypeNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setTypeName(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setTypeName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearTypeName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearTypeName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setTypeNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setTypeNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasExtendee() {
                return ((FieldDescriptorProto) this.instance).hasExtendee();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getExtendee() {
                return ((FieldDescriptorProto) this.instance).getExtendee();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getExtendeeBytes() {
                return ((FieldDescriptorProto) this.instance).getExtendeeBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtendee(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setExtendee(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearExtendee() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearExtendee();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setExtendeeBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setExtendeeBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasDefaultValue() {
                return ((FieldDescriptorProto) this.instance).hasDefaultValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getDefaultValue() {
                return ((FieldDescriptorProto) this.instance).getDefaultValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getDefaultValueBytes() {
                return ((FieldDescriptorProto) this.instance).getDefaultValueBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDefaultValue(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setDefaultValue(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDefaultValue() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearDefaultValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDefaultValueBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setDefaultValueBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOneofIndex() {
                return ((FieldDescriptorProto) this.instance).hasOneofIndex();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getOneofIndex() {
                return ((FieldDescriptorProto) this.instance).getOneofIndex();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOneofIndex(int i) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOneofIndex(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOneofIndex() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearOneofIndex();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasJsonName() {
                return ((FieldDescriptorProto) this.instance).hasJsonName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getJsonName() {
                return ((FieldDescriptorProto) this.instance).getJsonName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getJsonNameBytes() {
                return ((FieldDescriptorProto) this.instance).getJsonNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJsonName(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setJsonName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJsonName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearJsonName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJsonNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setJsonNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((FieldDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public FieldOptions getOptions() {
                return ((FieldDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(FieldOptions fieldOptions) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOptions(fieldOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(FieldOptions.Builder builder) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOptions((FieldOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(FieldOptions fieldOptions) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).mergeOptions(fieldOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearOptions();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasProto3Optional() {
                return ((FieldDescriptorProto) this.instance).hasProto3Optional();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean getProto3Optional() {
                return ((FieldDescriptorProto) this.instance).getProto3Optional();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setProto3Optional(boolean z) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setProto3Optional(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearProto3Optional() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearProto3Optional();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004ဌ\u0002\u0005ဌ\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", Label.internalGetVerifier(), "type_", Type.internalGetVerifier(), "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto();
            DEFAULT_INSTANCE = fieldDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(FieldDescriptorProto.class, fieldDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<FieldDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        private static final OneofDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private OneofOptions options_;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private OneofDescriptorProto() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(OneofOptions oneofOptions) {
            oneofOptions.getClass();
            this.options_ = oneofOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(OneofOptions oneofOptions) {
            oneofOptions.getClass();
            OneofOptions oneofOptions2 = this.options_;
            if (oneofOptions2 != null && oneofOptions2 != OneofOptions.getDefaultInstance()) {
                this.options_ = ((OneofOptions.Builder) OneofOptions.newBuilder(this.options_).mergeFrom((OneofOptions.Builder) oneofOptions)).buildPartial();
            } else {
                this.options_ = oneofOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(OneofDescriptorProto oneofDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(oneofDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(OneofDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((OneofDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public String getName() {
                return ((OneofDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((OneofDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((OneofDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public OneofOptions getOptions() {
                return ((OneofDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(OneofOptions oneofOptions) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setOptions(oneofOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(OneofOptions.Builder builder) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setOptions((OneofOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(OneofOptions oneofOptions) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).mergeOptions(oneofOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "name_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OneofDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (OneofDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto();
            DEFAULT_INSTANCE = oneofDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(OneofDescriptorProto.class, oneofDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<OneofDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        private static final EnumDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private EnumOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<EnumValueDescriptorProto> value_ = emptyProtobufList();
        private Internal.ProtobufList<EnumReservedRange> reservedRange_ = emptyProtobufList();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();

        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumDescriptorProto() {
        }

        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            private static final EnumReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private EnumReservedRange() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder(EnumReservedRange enumReservedRange) {
                return DEFAULT_INSTANCE.createBuilder(enumReservedRange);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ Builder(C19991 c19991) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Builder() {
                    super(EnumReservedRange.DEFAULT_INSTANCE);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public boolean hasStart() {
                    return ((EnumReservedRange) this.instance).hasStart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public int getStart() {
                    return ((EnumReservedRange) this.instance).getStart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setStart(int i) {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).setStart(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearStart() {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).clearStart();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public boolean hasEnd() {
                    return ((EnumReservedRange) this.instance).hasEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public int getEnd() {
                    return ((EnumReservedRange) this.instance).getEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).setEnd(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearEnd() {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).clearEnd();
                    return this;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C19991 c19991 = null;
                switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EnumReservedRange();
                    case 2:
                        return new Builder(c19991);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EnumReservedRange> parser = PARSER;
                        if (parser == null) {
                            synchronized (EnumReservedRange.class) {
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
                EnumReservedRange enumReservedRange = new EnumReservedRange();
                DEFAULT_INSTANCE = enumReservedRange;
                GeneratedMessageLite.registerDefaultInstance(EnumReservedRange.class, enumReservedRange);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Parser<EnumReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getValueCount() {
            return this.value_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumValueDescriptorProto getValue(int i) {
            return this.value_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int i) {
            return this.value_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureValueIsMutable() {
            Internal.ProtobufList<EnumValueDescriptorProto> protobufList = this.value_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.value_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
            enumValueDescriptorProto.getClass();
            ensureValueIsMutable();
            this.value_.set(i, enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
            enumValueDescriptorProto.getClass();
            ensureValueIsMutable();
            this.value_.add(enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
            enumValueDescriptorProto.getClass();
            ensureValueIsMutable();
            this.value_.add(i, enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
            ensureValueIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.value_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearValue() {
            this.value_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeValue(int i) {
            ensureValueIsMutable();
            this.value_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(EnumOptions enumOptions) {
            enumOptions.getClass();
            this.options_ = enumOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(EnumOptions enumOptions) {
            enumOptions.getClass();
            EnumOptions enumOptions2 = this.options_;
            if (enumOptions2 != null && enumOptions2 != EnumOptions.getDefaultInstance()) {
                this.options_ = ((EnumOptions.Builder) EnumOptions.newBuilder(this.options_).mergeFrom((EnumOptions.Builder) enumOptions)).buildPartial();
            } else {
                this.options_ = enumOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends EnumReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumReservedRange getReservedRange(int i) {
            return this.reservedRange_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
            return this.reservedRange_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureReservedRangeIsMutable() {
            Internal.ProtobufList<EnumReservedRange> protobufList = this.reservedRange_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.reservedRange_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setReservedRange(int i, EnumReservedRange enumReservedRange) {
            enumReservedRange.getClass();
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedRange(EnumReservedRange enumReservedRange) {
            enumReservedRange.getClass();
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedRange(int i, EnumReservedRange enumReservedRange) {
            enumReservedRange.getClass();
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.reservedRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearReservedRange() {
            this.reservedRange_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeReservedRange(int i) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getReservedName(int i) {
            return this.reservedName_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public ByteString getReservedNameBytes(int i) {
            return ByteString.copyFromUtf8(this.reservedName_.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureReservedNameIsMutable() {
            Internal.ProtobufList<String> protobufList = this.reservedName_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.reservedName_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setReservedName(int i, String str) {
            str.getClass();
            ensureReservedNameIsMutable();
            this.reservedName_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedName(String str) {
            str.getClass();
            ensureReservedNameIsMutable();
            this.reservedName_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllReservedName(Iterable<String> iterable) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.reservedName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addReservedNameBytes(ByteString byteString) {
            ensureReservedNameIsMutable();
            this.reservedName_.add(byteString.toStringUtf8());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(EnumDescriptorProto enumDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(enumDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(EnumDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((EnumDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getName() {
                return ((EnumDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((EnumDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumValueDescriptorProto> getValueList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getValueList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getValueCount() {
                return ((EnumDescriptorProto) this.instance).getValueCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumValueDescriptorProto getValue(int i) {
                return ((EnumDescriptorProto) this.instance).getValue(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setValue(i, enumValueDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setValue(int i, EnumValueDescriptorProto.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setValue(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(enumValueDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(i, enumValueDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addValue(EnumValueDescriptorProto.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addValue(int i, EnumValueDescriptorProto.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllValue(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearValue() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeValue(int i) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).removeValue(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((EnumDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumOptions getOptions() {
                return ((EnumDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(EnumOptions enumOptions) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setOptions(enumOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(EnumOptions.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setOptions((EnumOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(EnumOptions enumOptions) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).mergeOptions(enumOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearOptions();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getReservedRangeList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getReservedRangeCount() {
                return ((EnumDescriptorProto) this.instance).getReservedRangeCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumReservedRange getReservedRange(int i) {
                return ((EnumDescriptorProto) this.instance).getReservedRange(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setReservedRange(int i, EnumReservedRange enumReservedRange) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedRange(i, enumReservedRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setReservedRange(int i, EnumReservedRange.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedRange(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(EnumReservedRange enumReservedRange) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(enumReservedRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(int i, EnumReservedRange enumReservedRange) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(i, enumReservedRange);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(EnumReservedRange.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedRange(int i, EnumReservedRange.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllReservedRange(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearReservedRange() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearReservedRange();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeReservedRange(int i) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).removeReservedRange(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getReservedNameList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getReservedNameCount() {
                return ((EnumDescriptorProto) this.instance).getReservedNameCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getReservedName(int i) {
                return ((EnumDescriptorProto) this.instance).getReservedName(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public ByteString getReservedNameBytes(int i) {
                return ((EnumDescriptorProto) this.instance).getReservedNameBytes(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setReservedName(int i, String str) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedName(i, str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedName(String str) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllReservedName(Iterable<String> iterable) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllReservedName(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearReservedName() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearReservedName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addReservedNameBytes(ByteString byteString) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedNameBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001b\u0005\u001a", new Object[]{"bitField0_", "name_", "value_", EnumValueDescriptorProto.class, "options_", "reservedRange_", EnumReservedRange.class, "reservedName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto();
            DEFAULT_INSTANCE = enumDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(EnumDescriptorProto.class, enumDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<EnumDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        private static final EnumValueDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumValueDescriptorProto() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasNumber() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNumber(int i) {
            this.bitField0_ |= 2;
            this.number_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(EnumValueOptions enumValueOptions) {
            enumValueOptions.getClass();
            this.options_ = enumValueOptions;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(EnumValueOptions enumValueOptions) {
            enumValueOptions.getClass();
            EnumValueOptions enumValueOptions2 = this.options_;
            if (enumValueOptions2 != null && enumValueOptions2 != EnumValueOptions.getDefaultInstance()) {
                this.options_ = ((EnumValueOptions.Builder) EnumValueOptions.newBuilder(this.options_).mergeFrom((EnumValueOptions.Builder) enumValueOptions)).buildPartial();
            } else {
                this.options_ = enumValueOptions;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(EnumValueDescriptorProto enumValueDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(enumValueDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(EnumValueDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((EnumValueDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public String getName() {
                return ((EnumValueDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((EnumValueDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return ((EnumValueDescriptorProto) this.instance).hasNumber();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public int getNumber() {
                return ((EnumValueDescriptorProto) this.instance).getNumber();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNumber(int i) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setNumber(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearNumber() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearNumber();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((EnumValueDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public EnumValueOptions getOptions() {
                return ((EnumValueDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(EnumValueOptions enumValueOptions) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setOptions(enumValueOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(EnumValueOptions.Builder builder) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setOptions((EnumValueOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(EnumValueOptions enumValueOptions) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).mergeOptions(enumValueOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "number_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumValueDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumValueDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto();
            DEFAULT_INSTANCE = enumValueDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(EnumValueDescriptorProto.class, enumValueDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<EnumValueDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        private static final ServiceDescriptorProto DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private ServiceOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<MethodDescriptorProto> method_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ServiceDescriptorProto() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public int getMethodCount() {
            return this.method_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public MethodDescriptorProto getMethod(int i) {
            return this.method_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i) {
            return this.method_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureMethodIsMutable() {
            Internal.ProtobufList<MethodDescriptorProto> protobufList = this.method_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.method_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMethod(int i, MethodDescriptorProto methodDescriptorProto) {
            methodDescriptorProto.getClass();
            ensureMethodIsMutable();
            this.method_.set(i, methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addMethod(MethodDescriptorProto methodDescriptorProto) {
            methodDescriptorProto.getClass();
            ensureMethodIsMutable();
            this.method_.add(methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addMethod(int i, MethodDescriptorProto methodDescriptorProto) {
            methodDescriptorProto.getClass();
            ensureMethodIsMutable();
            this.method_.add(i, methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
            ensureMethodIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.method_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearMethod() {
            this.method_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeMethod(int i) {
            ensureMethodIsMutable();
            this.method_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(ServiceOptions serviceOptions) {
            serviceOptions.getClass();
            this.options_ = serviceOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(ServiceOptions serviceOptions) {
            serviceOptions.getClass();
            ServiceOptions serviceOptions2 = this.options_;
            if (serviceOptions2 != null && serviceOptions2 != ServiceOptions.getDefaultInstance()) {
                this.options_ = ((ServiceOptions.Builder) ServiceOptions.newBuilder(this.options_).mergeFrom((ServiceOptions.Builder) serviceOptions)).buildPartial();
            } else {
                this.options_ = serviceOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(ServiceDescriptorProto serviceDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(serviceDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(ServiceDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((ServiceDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public String getName() {
                return ((ServiceDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((ServiceDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public List<MethodDescriptorProto> getMethodList() {
                return Collections.unmodifiableList(((ServiceDescriptorProto) this.instance).getMethodList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public int getMethodCount() {
                return ((ServiceDescriptorProto) this.instance).getMethodCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public MethodDescriptorProto getMethod(int i) {
                return ((ServiceDescriptorProto) this.instance).getMethod(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMethod(int i, MethodDescriptorProto methodDescriptorProto) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setMethod(i, methodDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMethod(int i, MethodDescriptorProto.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setMethod(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMethod(MethodDescriptorProto methodDescriptorProto) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(methodDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMethod(int i, MethodDescriptorProto methodDescriptorProto) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(i, methodDescriptorProto);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMethod(MethodDescriptorProto.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addMethod(int i, MethodDescriptorProto.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addAllMethod(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMethod() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearMethod();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeMethod(int i) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).removeMethod(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((ServiceDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ServiceOptions getOptions() {
                return ((ServiceDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(ServiceOptions serviceOptions) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setOptions(serviceOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(ServiceOptions.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setOptions((ServiceOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(ServiceOptions serviceOptions) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).mergeOptions(serviceOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", MethodDescriptorProto.class, "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ServiceDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (ServiceDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto();
            DEFAULT_INSTANCE = serviceDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(ServiceDescriptorProto.class, serviceDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<ServiceDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        private static final MethodDescriptorProto DEFAULT_INSTANCE;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private MethodOptions options_;
        private boolean serverStreaming_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String inputType_ = "";
        private String outputType_ = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MethodDescriptorProto() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasInputType() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getInputType() {
            return this.inputType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getInputTypeBytes() {
            return ByteString.copyFromUtf8(this.inputType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setInputType(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.inputType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearInputType() {
            this.bitField0_ &= -3;
            this.inputType_ = getDefaultInstance().getInputType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setInputTypeBytes(ByteString byteString) {
            this.inputType_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOutputType() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getOutputType() {
            return this.outputType_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getOutputTypeBytes() {
            return ByteString.copyFromUtf8(this.outputType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOutputType(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.outputType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOutputType() {
            this.bitField0_ &= -5;
            this.outputType_ = getDefaultInstance().getOutputType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOutputTypeBytes(ByteString byteString) {
            this.outputType_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptions(MethodOptions methodOptions) {
            methodOptions.getClass();
            this.options_ = methodOptions;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void mergeOptions(MethodOptions methodOptions) {
            methodOptions.getClass();
            MethodOptions methodOptions2 = this.options_;
            if (methodOptions2 != null && methodOptions2 != MethodOptions.getDefaultInstance()) {
                this.options_ = ((MethodOptions.Builder) MethodOptions.newBuilder(this.options_).mergeFrom((MethodOptions.Builder) methodOptions)).buildPartial();
            } else {
                this.options_ = methodOptions;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasClientStreaming() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setClientStreaming(boolean z) {
            this.bitField0_ |= 16;
            this.clientStreaming_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearClientStreaming() {
            this.bitField0_ &= -17;
            this.clientStreaming_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasServerStreaming() {
            return (this.bitField0_ & 32) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setServerStreaming(boolean z) {
            this.bitField0_ |= 32;
            this.serverStreaming_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearServerStreaming() {
            this.bitField0_ &= -33;
            this.serverStreaming_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(MethodDescriptorProto methodDescriptorProto) {
            return DEFAULT_INSTANCE.createBuilder(methodDescriptorProto);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(MethodDescriptorProto.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((MethodDescriptorProto) this.instance).hasName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getName() {
                return ((MethodDescriptorProto) this.instance).getName();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((MethodDescriptorProto) this.instance).getNameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(String str) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setName(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasInputType() {
                return ((MethodDescriptorProto) this.instance).hasInputType();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getInputType() {
                return ((MethodDescriptorProto) this.instance).getInputType();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getInputTypeBytes() {
                return ((MethodDescriptorProto) this.instance).getInputTypeBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setInputType(String str) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setInputType(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearInputType() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearInputType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setInputTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setInputTypeBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOutputType() {
                return ((MethodDescriptorProto) this.instance).hasOutputType();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getOutputType() {
                return ((MethodDescriptorProto) this.instance).getOutputType();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getOutputTypeBytes() {
                return ((MethodDescriptorProto) this.instance).getOutputTypeBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOutputType(String str) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOutputType(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOutputType() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearOutputType();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOutputTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOutputTypeBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((MethodDescriptorProto) this.instance).hasOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public MethodOptions getOptions() {
                return ((MethodDescriptorProto) this.instance).getOptions();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(MethodOptions methodOptions) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOptions(methodOptions);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptions(MethodOptions.Builder builder) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOptions((MethodOptions) builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder mergeOptions(MethodOptions methodOptions) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).mergeOptions(methodOptions);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptions() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearOptions();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasClientStreaming() {
                return ((MethodDescriptorProto) this.instance).hasClientStreaming();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean getClientStreaming() {
                return ((MethodDescriptorProto) this.instance).getClientStreaming();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setClientStreaming(boolean z) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setClientStreaming(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearClientStreaming() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearClientStreaming();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasServerStreaming() {
                return ((MethodDescriptorProto) this.instance).hasServerStreaming();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean getServerStreaming() {
                return ((MethodDescriptorProto) this.instance).getServerStreaming();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setServerStreaming(boolean z) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setServerStreaming(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearServerStreaming() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearServerStreaming();
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodDescriptorProto();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MethodDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (MethodDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto();
            DEFAULT_INSTANCE = methodDescriptorProto;
            GeneratedMessageLite.registerDefaultInstance(MethodDescriptorProto.class, methodDescriptorProto);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<MethodDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        private static final FileOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
        public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean deprecated_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private boolean javaStringCheckUtf8_;
        private boolean phpGenericServices_;
        private boolean pyGenericServices_;
        private byte memoizedIsInitialized = 2;
        private String javaPackage_ = "";
        private String javaOuterClassname_ = "";
        private int optimizeFor_ = 1;
        private String goPackage_ = "";
        private boolean ccEnableArenas_ = true;
        private String objcClassPrefix_ = "";
        private String csharpNamespace_ = "";
        private String swiftPrefix_ = "";
        private String phpClassPrefix_ = "";
        private String phpNamespace_ = "";
        private String phpMetadataNamespace_ = "";
        private String rubyPackage_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileOptions() {
        }

        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);

            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap<OptimizeMode>() { // from class: com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OptimizeMode findValueByNumber(int i) {
                    return OptimizeMode.forNumber(i);
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
            public static OptimizeMode valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static OptimizeMode forNumber(int i) {
                if (i == 1) {
                    return SPEED;
                }
                if (i == 2) {
                    return CODE_SIZE;
                }
                if (i != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumVerifier internalGetVerifier() {
                return OptimizeModeVerifier.INSTANCE;
            }

            private static final class OptimizeModeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new OptimizeModeVerifier();

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private OptimizeModeVerifier() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return OptimizeMode.forNumber(i) != null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            OptimizeMode(int i) {
                this.value = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaPackage() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaPackage() {
            return this.javaPackage_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getJavaPackageBytes() {
            return ByteString.copyFromUtf8(this.javaPackage_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaPackage(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.javaPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJavaPackage() {
            this.bitField0_ &= -2;
            this.javaPackage_ = getDefaultInstance().getJavaPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaPackageBytes(ByteString byteString) {
            this.javaPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaOuterClassname() {
            return this.javaOuterClassname_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getJavaOuterClassnameBytes() {
            return ByteString.copyFromUtf8(this.javaOuterClassname_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaOuterClassname(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.javaOuterClassname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJavaOuterClassname() {
            this.bitField0_ &= -3;
            this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaOuterClassnameBytes(ByteString byteString) {
            this.javaOuterClassname_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaMultipleFiles(boolean z) {
            this.bitField0_ |= 4;
            this.javaMultipleFiles_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJavaMultipleFiles() {
            this.bitField0_ &= -5;
            this.javaMultipleFiles_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaGenerateEqualsAndHash(boolean z) {
            this.bitField0_ |= 8;
            this.javaGenerateEqualsAndHash_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJavaGenerateEqualsAndHash() {
            this.bitField0_ &= -9;
            this.javaGenerateEqualsAndHash_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaStringCheckUtf8() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaStringCheckUtf8(boolean z) {
            this.bitField0_ |= 16;
            this.javaStringCheckUtf8_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJavaStringCheckUtf8() {
            this.bitField0_ &= -17;
            this.javaStringCheckUtf8_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasOptimizeFor() {
            return (this.bitField0_ & 32) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public OptimizeMode getOptimizeFor() {
            OptimizeMode forNumber = OptimizeMode.forNumber(this.optimizeFor_);
            return forNumber == null ? OptimizeMode.SPEED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOptimizeFor(OptimizeMode optimizeMode) {
            this.optimizeFor_ = optimizeMode.getNumber();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearOptimizeFor() {
            this.bitField0_ &= -33;
            this.optimizeFor_ = 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasGoPackage() {
            return (this.bitField0_ & 64) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getGoPackage() {
            return this.goPackage_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getGoPackageBytes() {
            return ByteString.copyFromUtf8(this.goPackage_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setGoPackage(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.goPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearGoPackage() {
            this.bitField0_ &= -65;
            this.goPackage_ = getDefaultInstance().getGoPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setGoPackageBytes(ByteString byteString) {
            this.goPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 64;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 128) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setCcGenericServices(boolean z) {
            this.bitField0_ |= 128;
            this.ccGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearCcGenericServices() {
            this.bitField0_ &= -129;
            this.ccGenericServices_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 256) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJavaGenericServices(boolean z) {
            this.bitField0_ |= 256;
            this.javaGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJavaGenericServices() {
            this.bitField0_ &= -257;
            this.javaGenericServices_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPyGenericServices() {
            return (this.bitField0_ & 512) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPyGenericServices(boolean z) {
            this.bitField0_ |= 512;
            this.pyGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPyGenericServices() {
            this.bitField0_ &= -513;
            this.pyGenericServices_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpGenericServices() {
            return (this.bitField0_ & 1024) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPhpGenericServices() {
            return this.phpGenericServices_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpGenericServices(boolean z) {
            this.bitField0_ |= 1024;
            this.phpGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPhpGenericServices() {
            this.bitField0_ &= -1025;
            this.phpGenericServices_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 2048) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 2048;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -2049;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcEnableArenas() {
            return (this.bitField0_ & 4096) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setCcEnableArenas(boolean z) {
            this.bitField0_ |= 4096;
            this.ccEnableArenas_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearCcEnableArenas() {
            this.bitField0_ &= -4097;
            this.ccEnableArenas_ = true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasObjcClassPrefix() {
            return (this.bitField0_ & 8192) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getObjcClassPrefix() {
            return this.objcClassPrefix_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getObjcClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.objcClassPrefix_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setObjcClassPrefix(String str) {
            str.getClass();
            this.bitField0_ |= 8192;
            this.objcClassPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearObjcClassPrefix() {
            this.bitField0_ &= -8193;
            this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setObjcClassPrefixBytes(ByteString byteString) {
            this.objcClassPrefix_ = byteString.toStringUtf8();
            this.bitField0_ |= 8192;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCsharpNamespace() {
            return (this.bitField0_ & 16384) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getCsharpNamespace() {
            return this.csharpNamespace_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getCsharpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.csharpNamespace_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setCsharpNamespace(String str) {
            str.getClass();
            this.bitField0_ |= 16384;
            this.csharpNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearCsharpNamespace() {
            this.bitField0_ &= -16385;
            this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setCsharpNamespaceBytes(ByteString byteString) {
            this.csharpNamespace_ = byteString.toStringUtf8();
            this.bitField0_ |= 16384;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasSwiftPrefix() {
            return (this.bitField0_ & 32768) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getSwiftPrefix() {
            return this.swiftPrefix_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getSwiftPrefixBytes() {
            return ByteString.copyFromUtf8(this.swiftPrefix_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSwiftPrefix(String str) {
            str.getClass();
            this.bitField0_ |= 32768;
            this.swiftPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearSwiftPrefix() {
            this.bitField0_ &= -32769;
            this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSwiftPrefixBytes(ByteString byteString) {
            this.swiftPrefix_ = byteString.toStringUtf8();
            this.bitField0_ |= 32768;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpClassPrefix() {
            return (this.bitField0_ & 65536) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpClassPrefix() {
            return this.phpClassPrefix_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.phpClassPrefix_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpClassPrefix(String str) {
            str.getClass();
            this.bitField0_ |= 65536;
            this.phpClassPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPhpClassPrefix() {
            this.bitField0_ &= -65537;
            this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpClassPrefixBytes(ByteString byteString) {
            this.phpClassPrefix_ = byteString.toStringUtf8();
            this.bitField0_ |= 65536;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpNamespace() {
            return (this.bitField0_ & 131072) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpNamespace() {
            return this.phpNamespace_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpNamespace_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpNamespace(String str) {
            str.getClass();
            this.bitField0_ |= 131072;
            this.phpNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPhpNamespace() {
            this.bitField0_ &= -131073;
            this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpNamespaceBytes(ByteString byteString) {
            this.phpNamespace_ = byteString.toStringUtf8();
            this.bitField0_ |= 131072;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpMetadataNamespace() {
            return (this.bitField0_ & 262144) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpMetadataNamespace() {
            return this.phpMetadataNamespace_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpMetadataNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpMetadataNamespace_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpMetadataNamespace(String str) {
            str.getClass();
            this.bitField0_ |= 262144;
            this.phpMetadataNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPhpMetadataNamespace() {
            this.bitField0_ &= -262145;
            this.phpMetadataNamespace_ = getDefaultInstance().getPhpMetadataNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPhpMetadataNamespaceBytes(ByteString byteString) {
            this.phpMetadataNamespace_ = byteString.toStringUtf8();
            this.bitField0_ |= 262144;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasRubyPackage() {
            return (this.bitField0_ & 524288) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getRubyPackage() {
            return this.rubyPackage_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getRubyPackageBytes() {
            return ByteString.copyFromUtf8(this.rubyPackage_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setRubyPackage(String str) {
            str.getClass();
            this.bitField0_ |= 524288;
            this.rubyPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearRubyPackage() {
            this.bitField0_ &= -524289;
            this.rubyPackage_ = getDefaultInstance().getRubyPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setRubyPackageBytes(ByteString byteString) {
            this.rubyPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 524288;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(FileOptions fileOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(fileOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(FileOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaPackage() {
                return ((FileOptions) this.instance).hasJavaPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaPackage() {
                return ((FileOptions) this.instance).getJavaPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getJavaPackageBytes() {
                return ((FileOptions) this.instance).getJavaPackageBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaPackage(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaPackage(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJavaPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaPackage();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaPackageBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaOuterClassname() {
                return ((FileOptions) this.instance).hasJavaOuterClassname();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaOuterClassname() {
                return ((FileOptions) this.instance).getJavaOuterClassname();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getJavaOuterClassnameBytes() {
                return ((FileOptions) this.instance).getJavaOuterClassnameBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaOuterClassname(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaOuterClassname(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJavaOuterClassname() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaOuterClassname();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaOuterClassnameBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaOuterClassnameBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaMultipleFiles() {
                return ((FileOptions) this.instance).hasJavaMultipleFiles();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaMultipleFiles() {
                return ((FileOptions) this.instance).getJavaMultipleFiles();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaMultipleFiles(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaMultipleFiles(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJavaMultipleFiles() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaMultipleFiles();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            @Deprecated
            public boolean hasJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.instance).hasJavaGenerateEqualsAndHash();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            @Deprecated
            public boolean getJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.instance).getJavaGenerateEqualsAndHash();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public Builder setJavaGenerateEqualsAndHash(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaGenerateEqualsAndHash(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public Builder clearJavaGenerateEqualsAndHash() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaGenerateEqualsAndHash();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaStringCheckUtf8() {
                return ((FileOptions) this.instance).hasJavaStringCheckUtf8();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaStringCheckUtf8() {
                return ((FileOptions) this.instance).getJavaStringCheckUtf8();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaStringCheckUtf8(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaStringCheckUtf8(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJavaStringCheckUtf8() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaStringCheckUtf8();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasOptimizeFor() {
                return ((FileOptions) this.instance).hasOptimizeFor();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public OptimizeMode getOptimizeFor() {
                return ((FileOptions) this.instance).getOptimizeFor();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOptimizeFor(OptimizeMode optimizeMode) {
                copyOnWrite();
                ((FileOptions) this.instance).setOptimizeFor(optimizeMode);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearOptimizeFor() {
                copyOnWrite();
                ((FileOptions) this.instance).clearOptimizeFor();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasGoPackage() {
                return ((FileOptions) this.instance).hasGoPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getGoPackage() {
                return ((FileOptions) this.instance).getGoPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getGoPackageBytes() {
                return ((FileOptions) this.instance).getGoPackageBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setGoPackage(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setGoPackage(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearGoPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearGoPackage();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setGoPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setGoPackageBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcGenericServices() {
                return ((FileOptions) this.instance).hasCcGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcGenericServices() {
                return ((FileOptions) this.instance).getCcGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setCcGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setCcGenericServices(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearCcGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCcGenericServices();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaGenericServices() {
                return ((FileOptions) this.instance).hasJavaGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaGenericServices() {
                return ((FileOptions) this.instance).getJavaGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJavaGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaGenericServices(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJavaGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaGenericServices();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPyGenericServices() {
                return ((FileOptions) this.instance).hasPyGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPyGenericServices() {
                return ((FileOptions) this.instance).getPyGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPyGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setPyGenericServices(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPyGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPyGenericServices();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpGenericServices() {
                return ((FileOptions) this.instance).hasPhpGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPhpGenericServices() {
                return ((FileOptions) this.instance).getPhpGenericServices();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpGenericServices(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPhpGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpGenericServices();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((FileOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getDeprecated() {
                return ((FileOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((FileOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcEnableArenas() {
                return ((FileOptions) this.instance).hasCcEnableArenas();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcEnableArenas() {
                return ((FileOptions) this.instance).getCcEnableArenas();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setCcEnableArenas(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setCcEnableArenas(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearCcEnableArenas() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCcEnableArenas();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasObjcClassPrefix() {
                return ((FileOptions) this.instance).hasObjcClassPrefix();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getObjcClassPrefix() {
                return ((FileOptions) this.instance).getObjcClassPrefix();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getObjcClassPrefixBytes() {
                return ((FileOptions) this.instance).getObjcClassPrefixBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setObjcClassPrefix(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setObjcClassPrefix(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearObjcClassPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearObjcClassPrefix();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setObjcClassPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setObjcClassPrefixBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCsharpNamespace() {
                return ((FileOptions) this.instance).hasCsharpNamespace();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getCsharpNamespace() {
                return ((FileOptions) this.instance).getCsharpNamespace();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getCsharpNamespaceBytes() {
                return ((FileOptions) this.instance).getCsharpNamespaceBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setCsharpNamespace(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setCsharpNamespace(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearCsharpNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCsharpNamespace();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setCsharpNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setCsharpNamespaceBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasSwiftPrefix() {
                return ((FileOptions) this.instance).hasSwiftPrefix();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getSwiftPrefix() {
                return ((FileOptions) this.instance).getSwiftPrefix();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getSwiftPrefixBytes() {
                return ((FileOptions) this.instance).getSwiftPrefixBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSwiftPrefix(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setSwiftPrefix(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearSwiftPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearSwiftPrefix();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSwiftPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setSwiftPrefixBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpClassPrefix() {
                return ((FileOptions) this.instance).hasPhpClassPrefix();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpClassPrefix() {
                return ((FileOptions) this.instance).getPhpClassPrefix();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpClassPrefixBytes() {
                return ((FileOptions) this.instance).getPhpClassPrefixBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpClassPrefix(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpClassPrefix(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPhpClassPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpClassPrefix();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpClassPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpClassPrefixBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpNamespace() {
                return ((FileOptions) this.instance).hasPhpNamespace();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpNamespace() {
                return ((FileOptions) this.instance).getPhpNamespace();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpNamespaceBytes() {
                return ((FileOptions) this.instance).getPhpNamespaceBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpNamespace(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpNamespace(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPhpNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpNamespace();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpNamespaceBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpMetadataNamespace() {
                return ((FileOptions) this.instance).hasPhpMetadataNamespace();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpMetadataNamespace() {
                return ((FileOptions) this.instance).getPhpMetadataNamespace();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpMetadataNamespaceBytes() {
                return ((FileOptions) this.instance).getPhpMetadataNamespaceBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpMetadataNamespace(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpMetadataNamespace(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPhpMetadataNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpMetadataNamespace();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPhpMetadataNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpMetadataNamespaceBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasRubyPackage() {
                return ((FileOptions) this.instance).hasRubyPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getRubyPackage() {
                return ((FileOptions) this.instance).getRubyPackage();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getRubyPackageBytes() {
                return ((FileOptions) this.instance).getRubyPackageBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setRubyPackage(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setRubyPackage(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearRubyPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearRubyPackage();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setRubyPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setRubyPackageBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FileOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((FileOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((FileOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FileOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FileOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((FileOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((FileOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((FileOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0001\u0001ဈ\u0000\bဈ\u0001\tဌ\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\u000b\u001bဇ\u0004\u001fဇ\f$ဈ\r%ဈ\u000e'ဈ\u000f(ဈ\u0010)ဈ\u0011*ဇ\n,ဈ\u0012-ဈ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", OptimizeMode.internalGetVerifier(), "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpGenericServices_", "phpMetadataNamespace_", "rubyPackage_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (FileOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            FileOptions fileOptions = new FileOptions();
            DEFAULT_INSTANCE = fileOptions;
            GeneratedMessageLite.registerDefaultInstance(FileOptions.class, fileOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<FileOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        private static final MessageOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MessageOptions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMessageSetWireFormat(boolean z) {
            this.bitField0_ |= 1;
            this.messageSetWireFormat_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearMessageSetWireFormat() {
            this.bitField0_ &= -2;
            this.messageSetWireFormat_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNoStandardDescriptorAccessor(boolean z) {
            this.bitField0_ |= 2;
            this.noStandardDescriptorAccessor_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearNoStandardDescriptorAccessor() {
            this.bitField0_ &= -3;
            this.noStandardDescriptorAccessor_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 4;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -5;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMapEntry() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setMapEntry(boolean z) {
            this.bitField0_ |= 8;
            this.mapEntry_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearMapEntry() {
            this.bitField0_ &= -9;
            this.mapEntry_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(MessageOptions messageOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(messageOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(MessageOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMessageSetWireFormat() {
                return ((MessageOptions) this.instance).hasMessageSetWireFormat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMessageSetWireFormat() {
                return ((MessageOptions) this.instance).getMessageSetWireFormat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMessageSetWireFormat(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setMessageSetWireFormat(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMessageSetWireFormat() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearMessageSetWireFormat();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.instance).hasNoStandardDescriptorAccessor();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.instance).getNoStandardDescriptorAccessor();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNoStandardDescriptorAccessor(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setNoStandardDescriptorAccessor(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearNoStandardDescriptorAccessor() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearNoStandardDescriptorAccessor();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((MessageOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getDeprecated() {
                return ((MessageOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMapEntry() {
                return ((MessageOptions) this.instance).hasMapEntry();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMapEntry() {
                return ((MessageOptions) this.instance).getMapEntry();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMapEntry(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setMapEntry(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearMapEntry() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearMapEntry();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MessageOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((MessageOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((MessageOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MessageOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MessageOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((MessageOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((MessageOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MessageOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0001\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003ϧЛ", new Object[]{"bitField0_", "messageSetWireFormat_", "noStandardDescriptorAccessor_", "deprecated_", "mapEntry_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MessageOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (MessageOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            MessageOptions messageOptions = new MessageOptions();
            DEFAULT_INSTANCE = messageOptions;
            GeneratedMessageLite.registerDefaultInstance(MessageOptions.class, messageOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<MessageOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        private static final FieldOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private boolean packed_;
        private boolean weak_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FieldOptions() {
        }

        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);

            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private static final Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap<CType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.CType.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public CType findValueByNumber(int i) {
                    return CType.forNumber(i);
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
            public static CType valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static CType forNumber(int i) {
                if (i == 0) {
                    return STRING;
                }
                if (i == 1) {
                    return CORD;
                }
                if (i != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumVerifier internalGetVerifier() {
                return CTypeVerifier.INSTANCE;
            }

            private static final class CTypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new CTypeVerifier();

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private CTypeVerifier() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return CType.forNumber(i) != null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            CType(int i) {
                this.value = i;
            }
        }

        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);

            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private static final Internal.EnumLiteMap<JSType> internalValueMap = new Internal.EnumLiteMap<JSType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.JSType.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public JSType findValueByNumber(int i) {
                    return JSType.forNumber(i);
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
            public static JSType valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static JSType forNumber(int i) {
                if (i == 0) {
                    return JS_NORMAL;
                }
                if (i == 1) {
                    return JS_STRING;
                }
                if (i != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumLiteMap<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumVerifier internalGetVerifier() {
                return JSTypeVerifier.INSTANCE;
            }

            private static final class JSTypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new JSTypeVerifier();

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private JSTypeVerifier() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return JSType.forNumber(i) != null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            JSType(int i) {
                this.value = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasCtype() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public CType getCtype() {
            CType forNumber = CType.forNumber(this.ctype_);
            return forNumber == null ? CType.STRING : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setCtype(CType cType) {
            this.ctype_ = cType.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearCtype() {
            this.bitField0_ &= -2;
            this.ctype_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasPacked() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPacked(boolean z) {
            this.bitField0_ |= 2;
            this.packed_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPacked() {
            this.bitField0_ &= -3;
            this.packed_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasJstype() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public JSType getJstype() {
            JSType forNumber = JSType.forNumber(this.jstype_);
            return forNumber == null ? JSType.JS_NORMAL : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setJstype(JSType jSType) {
            this.jstype_ = jSType.getNumber();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearJstype() {
            this.bitField0_ &= -5;
            this.jstype_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasLazy() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getLazy() {
            return this.lazy_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLazy(boolean z) {
            this.bitField0_ |= 8;
            this.lazy_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearLazy() {
            this.bitField0_ &= -9;
            this.lazy_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 16;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -17;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasWeak() {
            return (this.bitField0_ & 32) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getWeak() {
            return this.weak_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setWeak(boolean z) {
            this.bitField0_ |= 32;
            this.weak_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearWeak() {
            this.bitField0_ &= -33;
            this.weak_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(FieldOptions fieldOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(fieldOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(FieldOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasCtype() {
                return ((FieldOptions) this.instance).hasCtype();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public CType getCtype() {
                return ((FieldOptions) this.instance).getCtype();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setCtype(CType cType) {
                copyOnWrite();
                ((FieldOptions) this.instance).setCtype(cType);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearCtype() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearCtype();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasPacked() {
                return ((FieldOptions) this.instance).hasPacked();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getPacked() {
                return ((FieldOptions) this.instance).getPacked();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPacked(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setPacked(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPacked() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearPacked();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasJstype() {
                return ((FieldOptions) this.instance).hasJstype();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public JSType getJstype() {
                return ((FieldOptions) this.instance).getJstype();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setJstype(JSType jSType) {
                copyOnWrite();
                ((FieldOptions) this.instance).setJstype(jSType);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearJstype() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearJstype();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasLazy() {
                return ((FieldOptions) this.instance).hasLazy();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getLazy() {
                return ((FieldOptions) this.instance).getLazy();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setLazy(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setLazy(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearLazy() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearLazy();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((FieldOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getDeprecated() {
                return ((FieldOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasWeak() {
                return ((FieldOptions) this.instance).hasWeak();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getWeak() {
                return ((FieldOptions) this.instance).getWeak();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setWeak(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setWeak(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearWeak() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearWeak();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FieldOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((FieldOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((FieldOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FieldOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FieldOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((FieldOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((FieldOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0004\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0005ϧЛ", new Object[]{"bitField0_", "ctype_", CType.internalGetVerifier(), "packed_", "deprecated_", "lazy_", "jstype_", JSType.internalGetVerifier(), "weak_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            FieldOptions fieldOptions = new FieldOptions();
            DEFAULT_INSTANCE = fieldOptions;
            GeneratedMessageLite.registerDefaultInstance(FieldOptions.class, fieldOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<FieldOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        private static final OneofOptions DEFAULT_INSTANCE;
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private OneofOptions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(OneofOptions oneofOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(oneofOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(OneofOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((OneofOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((OneofOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((OneofOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((OneofOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((OneofOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((OneofOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((OneofOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((OneofOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000ϧϧ\u0001\u0000\u0001\u0001ϧЛ", new Object[]{"uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OneofOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (OneofOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            OneofOptions oneofOptions = new OneofOptions();
            DEFAULT_INSTANCE = oneofOptions;
            GeneratedMessageLite.registerDefaultInstance(OneofOptions.class, oneofOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static OneofOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<OneofOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        private static final EnumOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumOptions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean hasAllowAlias() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAllowAlias(boolean z) {
            this.bitField0_ |= 1;
            this.allowAlias_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearAllowAlias() {
            this.bitField0_ &= -2;
            this.allowAlias_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 2;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -3;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(EnumOptions enumOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(enumOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(EnumOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean hasAllowAlias() {
                return ((EnumOptions) this.instance).hasAllowAlias();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean getAllowAlias() {
                return ((EnumOptions) this.instance).getAllowAlias();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setAllowAlias(boolean z) {
                copyOnWrite();
                ((EnumOptions) this.instance).setAllowAlias(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearAllowAlias() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearAllowAlias();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((EnumOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean getDeprecated() {
                return ((EnumOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((EnumOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((EnumOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((EnumOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((EnumOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((EnumOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0002ϧ\u0003\u0000\u0001\u0001\u0002ဇ\u0000\u0003ဇ\u0001ϧЛ", new Object[]{"bitField0_", "allowAlias_", "deprecated_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            EnumOptions enumOptions = new EnumOptions();
            DEFAULT_INSTANCE = enumOptions;
            GeneratedMessageLite.registerDefaultInstance(EnumOptions.class, enumOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<EnumOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        private static final EnumValueOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumValueOptions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(EnumValueOptions enumValueOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(enumValueOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(EnumValueOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((EnumValueOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public boolean getDeprecated() {
                return ((EnumValueOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((EnumValueOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumValueOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((EnumValueOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((EnumValueOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((EnumValueOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0001\u0001ဇ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumValueOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumValueOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            EnumValueOptions enumValueOptions = new EnumValueOptions();
            DEFAULT_INSTANCE = enumValueOptions;
            GeneratedMessageLite.registerDefaultInstance(EnumValueOptions.class, enumValueOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumValueOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<EnumValueOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        private static final ServiceOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ServiceOptions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(ServiceOptions serviceOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(serviceOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(ServiceOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((ServiceOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public boolean getDeprecated() {
                return ((ServiceOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((ServiceOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ServiceOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((ServiceOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((ServiceOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((ServiceOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((ServiceOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001!ϧ\u0002\u0000\u0001\u0001!ဇ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ServiceOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (ServiceOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ServiceOptions serviceOptions = new ServiceOptions();
            DEFAULT_INSTANCE = serviceOptions;
            GeneratedMessageLite.registerDefaultInstance(ServiceOptions.class, serviceOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServiceOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<ServiceOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        private static final MethodOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MethodOptions() {
        }

        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);

            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;
            private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap = new Internal.EnumLiteMap<IdempotencyLevel>() { // from class: com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public IdempotencyLevel findValueByNumber(int i) {
                    return IdempotencyLevel.forNumber(i);
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
            public static IdempotencyLevel valueOf(int i) {
                return forNumber(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static IdempotencyLevel forNumber(int i) {
                if (i == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (i == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (i != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap() {
                return internalValueMap;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Internal.EnumVerifier internalGetVerifier() {
                return IdempotencyLevelVerifier.INSTANCE;
            }

            private static final class IdempotencyLevelVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new IdempotencyLevelVerifier();

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private IdempotencyLevelVerifier() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return IdempotencyLevel.forNumber(i) != null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            IdempotencyLevel(int i) {
                this.value = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean hasIdempotencyLevel() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public IdempotencyLevel getIdempotencyLevel() {
            IdempotencyLevel forNumber = IdempotencyLevel.forNumber(this.idempotencyLevel_);
            return forNumber == null ? IdempotencyLevel.IDEMPOTENCY_UNKNOWN : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
            this.idempotencyLevel_ = idempotencyLevel.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearIdempotencyLevel() {
            this.bitField0_ &= -3;
            this.idempotencyLevel_ = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureUninterpretedOptionIsMutable() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(MethodOptions methodOptions) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(methodOptions);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(MethodOptions.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((MethodOptions) this.instance).hasDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean getDeprecated() {
                return ((MethodOptions) this.instance).getDeprecated();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((MethodOptions) this.instance).setDeprecated(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDeprecated() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearDeprecated();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean hasIdempotencyLevel() {
                return ((MethodOptions) this.instance).hasIdempotencyLevel();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public IdempotencyLevel getIdempotencyLevel() {
                return ((MethodOptions) this.instance).getIdempotencyLevel();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
                copyOnWrite();
                ((MethodOptions) this.instance).setIdempotencyLevel(idempotencyLevel);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearIdempotencyLevel() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearIdempotencyLevel();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MethodOptions) this.instance).getUninterpretedOptionList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((MethodOptions) this.instance).getUninterpretedOptionCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((MethodOptions) this.instance).getUninterpretedOption(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MethodOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MethodOptions) this.instance).setUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((MethodOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((MethodOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodOptions();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001!ϧ\u0003\u0000\u0001\u0001!ဇ\u0000\"ဌ\u0001ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", IdempotencyLevel.internalGetVerifier(), "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MethodOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (MethodOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            MethodOptions methodOptions = new MethodOptions();
            DEFAULT_INSTANCE = methodOptions;
            GeneratedMessageLite.registerDefaultInstance(MethodOptions.class, methodOptions);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MethodOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<MethodOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        private static final UninterpretedOption DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private int bitField0_;
        private double doubleValue_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<NamePart> name_ = emptyProtobufList();
        private String identifierValue_ = "";
        private ByteString stringValue_ = ByteString.EMPTY;
        private String aggregateValue_ = "";

        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            ByteString getNamePartBytes();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private UninterpretedOption() {
        }

        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            private static final NamePart DEFAULT_INSTANCE;
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = 2;
            private String namePart_ = "";

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private NamePart() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasNamePart() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public String getNamePart() {
                return this.namePart_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public ByteString getNamePartBytes() {
                return ByteString.copyFromUtf8(this.namePart_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setNamePart(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.namePart_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearNamePart() {
                this.bitField0_ &= -2;
                this.namePart_ = getDefaultInstance().getNamePart();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setNamePartBytes(ByteString byteString) {
                this.namePart_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasIsExtension() {
                return (this.bitField0_ & 2) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean getIsExtension() {
                return this.isExtension_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setIsExtension(boolean z) {
                this.bitField0_ |= 2;
                this.isExtension_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearIsExtension() {
                this.bitField0_ &= -3;
                this.isExtension_ = false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NamePart) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder(NamePart namePart) {
                return DEFAULT_INSTANCE.createBuilder(namePart);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ Builder(C19991 c19991) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Builder() {
                    super(NamePart.DEFAULT_INSTANCE);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasNamePart() {
                    return ((NamePart) this.instance).hasNamePart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public String getNamePart() {
                    return ((NamePart) this.instance).getNamePart();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public ByteString getNamePartBytes() {
                    return ((NamePart) this.instance).getNamePartBytes();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setNamePart(String str) {
                    copyOnWrite();
                    ((NamePart) this.instance).setNamePart(str);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearNamePart() {
                    copyOnWrite();
                    ((NamePart) this.instance).clearNamePart();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setNamePartBytes(ByteString byteString) {
                    copyOnWrite();
                    ((NamePart) this.instance).setNamePartBytes(byteString);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasIsExtension() {
                    return ((NamePart) this.instance).hasIsExtension();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean getIsExtension() {
                    return ((NamePart) this.instance).getIsExtension();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setIsExtension(boolean z) {
                    copyOnWrite();
                    ((NamePart) this.instance).setIsExtension(z);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearIsExtension() {
                    copyOnWrite();
                    ((NamePart) this.instance).clearIsExtension();
                    return this;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C19991 c19991 = null;
                switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NamePart();
                    case 2:
                        return new Builder(c19991);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"bitField0_", "namePart_", "isExtension_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<NamePart> parser = PARSER;
                        if (parser == null) {
                            synchronized (NamePart.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static {
                NamePart namePart = new NamePart();
                DEFAULT_INSTANCE = namePart;
                GeneratedMessageLite.registerDefaultInstance(NamePart.class, namePart);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static NamePart getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Parser<NamePart> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public List<NamePart> getNameList() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public int getNameCount() {
            return this.name_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public NamePart getName(int i) {
            return this.name_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NamePartOrBuilder getNameOrBuilder(int i) {
            return this.name_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureNameIsMutable() {
            Internal.ProtobufList<NamePart> protobufList = this.name_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.name_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setName(int i, NamePart namePart) {
            namePart.getClass();
            ensureNameIsMutable();
            this.name_.set(i, namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addName(NamePart namePart) {
            namePart.getClass();
            ensureNameIsMutable();
            this.name_.add(namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addName(int i, NamePart namePart) {
            namePart.getClass();
            ensureNameIsMutable();
            this.name_.add(i, namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllName(Iterable<? extends NamePart> iterable) {
            ensureNameIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearName() {
            this.name_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeName(int i) {
            ensureNameIsMutable();
            this.name_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getIdentifierValue() {
            return this.identifierValue_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getIdentifierValueBytes() {
            return ByteString.copyFromUtf8(this.identifierValue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setIdentifierValue(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.identifierValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearIdentifierValue() {
            this.bitField0_ &= -2;
            this.identifierValue_ = getDefaultInstance().getIdentifierValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setIdentifierValueBytes(ByteString byteString) {
            this.identifierValue_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setPositiveIntValue(long j) {
            this.bitField0_ |= 2;
            this.positiveIntValue_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearPositiveIntValue() {
            this.bitField0_ &= -3;
            this.positiveIntValue_ = 0L;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setNegativeIntValue(long j) {
            this.bitField0_ |= 4;
            this.negativeIntValue_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearNegativeIntValue() {
            this.bitField0_ &= -5;
            this.negativeIntValue_ = 0L;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasDoubleValue() {
            return (this.bitField0_ & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDoubleValue(double d) {
            this.bitField0_ |= 8;
            this.doubleValue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearDoubleValue() {
            this.bitField0_ &= -9;
            this.doubleValue_ = 0.0d;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasStringValue() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getStringValue() {
            return this.stringValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setStringValue(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.stringValue_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearStringValue() {
            this.bitField0_ &= -17;
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getAggregateValue() {
            return this.aggregateValue_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getAggregateValueBytes() {
            return ByteString.copyFromUtf8(this.aggregateValue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAggregateValue(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.aggregateValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearAggregateValue() {
            this.bitField0_ &= -33;
            this.aggregateValue_ = getDefaultInstance().getAggregateValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAggregateValueBytes(ByteString byteString) {
            this.aggregateValue_ = byteString.toStringUtf8();
            this.bitField0_ |= 32;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(UninterpretedOption uninterpretedOption) {
            return DEFAULT_INSTANCE.createBuilder(uninterpretedOption);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(UninterpretedOption.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public List<NamePart> getNameList() {
                return Collections.unmodifiableList(((UninterpretedOption) this.instance).getNameList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public int getNameCount() {
                return ((UninterpretedOption) this.instance).getNameCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public NamePart getName(int i) {
                return ((UninterpretedOption) this.instance).getName(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(int i, NamePart namePart) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setName(i, namePart);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setName(int i, NamePart.Builder builder) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setName(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addName(NamePart namePart) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(namePart);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addName(int i, NamePart namePart) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(i, namePart);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addName(NamePart.Builder builder) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addName(int i, NamePart.Builder builder) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllName(Iterable<? extends NamePart> iterable) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addAllName(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearName() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearName();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeName(int i) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).removeName(i);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasIdentifierValue() {
                return ((UninterpretedOption) this.instance).hasIdentifierValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getIdentifierValue() {
                return ((UninterpretedOption) this.instance).getIdentifierValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getIdentifierValueBytes() {
                return ((UninterpretedOption) this.instance).getIdentifierValueBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setIdentifierValue(String str) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setIdentifierValue(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearIdentifierValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearIdentifierValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setIdentifierValueBytes(ByteString byteString) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setIdentifierValueBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasPositiveIntValue() {
                return ((UninterpretedOption) this.instance).hasPositiveIntValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getPositiveIntValue() {
                return ((UninterpretedOption) this.instance).getPositiveIntValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setPositiveIntValue(long j) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setPositiveIntValue(j);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearPositiveIntValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearPositiveIntValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasNegativeIntValue() {
                return ((UninterpretedOption) this.instance).hasNegativeIntValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getNegativeIntValue() {
                return ((UninterpretedOption) this.instance).getNegativeIntValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNegativeIntValue(long j) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setNegativeIntValue(j);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearNegativeIntValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearNegativeIntValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasDoubleValue() {
                return ((UninterpretedOption) this.instance).hasDoubleValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public double getDoubleValue() {
                return ((UninterpretedOption) this.instance).getDoubleValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDoubleValue(double d) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setDoubleValue(d);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDoubleValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearDoubleValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasStringValue() {
                return ((UninterpretedOption) this.instance).hasStringValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getStringValue() {
                return ((UninterpretedOption) this.instance).getStringValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setStringValue(ByteString byteString) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setStringValue(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearStringValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearStringValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasAggregateValue() {
                return ((UninterpretedOption) this.instance).hasAggregateValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getAggregateValue() {
                return ((UninterpretedOption) this.instance).getAggregateValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getAggregateValueBytes() {
                return ((UninterpretedOption) this.instance).getAggregateValueBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setAggregateValue(String str) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setAggregateValue(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearAggregateValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearAggregateValue();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setAggregateValueBytes(ByteString byteString) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setAggregateValueBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new UninterpretedOption();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"bitField0_", "name_", NamePart.class, "identifierValue_", "positiveIntValue_", "negativeIntValue_", "doubleValue_", "stringValue_", "aggregateValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UninterpretedOption> parser = PARSER;
                    if (parser == null) {
                        synchronized (UninterpretedOption.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            UninterpretedOption uninterpretedOption = new UninterpretedOption();
            DEFAULT_INSTANCE = uninterpretedOption;
            GeneratedMessageLite.registerDefaultInstance(UninterpretedOption.class, uninterpretedOption);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static UninterpretedOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<UninterpretedOption> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        private static final SourceCodeInfo DEFAULT_INSTANCE;
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = emptyProtobufList();

        public interface LocationOrBuilder extends MessageLiteOrBuilder {
            String getLeadingComments();

            ByteString getLeadingCommentsBytes();

            String getLeadingDetachedComments(int i);

            ByteString getLeadingDetachedCommentsBytes(int i);

            int getLeadingDetachedCommentsCount();

            List<String> getLeadingDetachedCommentsList();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i);

            int getSpanCount();

            List<Integer> getSpanList();

            String getTrailingComments();

            ByteString getTrailingCommentsBytes();

            boolean hasLeadingComments();

            boolean hasTrailingComments();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SourceCodeInfo() {
        }

        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            private static final Location DEFAULT_INSTANCE;
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private int pathMemoizedSerializedSize = -1;
            private int spanMemoizedSerializedSize = -1;
            private Internal.IntList path_ = emptyIntList();
            private Internal.IntList span_ = emptyIntList();
            private String leadingComments_ = "";
            private String trailingComments_ = "";
            private Internal.ProtobufList<String> leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Location() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPath(int i) {
                return this.path_.getInt(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private void ensurePathIsMutable() {
                Internal.IntList intList = this.path_;
                if (intList.isModifiable()) {
                    return;
                }
                this.path_ = GeneratedMessageLite.mutableCopy(intList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setPath(int i, int i2) {
                ensurePathIsMutable();
                this.path_.setInt(i, i2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addPath(int i) {
                ensurePathIsMutable();
                this.path_.addInt(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addAllPath(Iterable<? extends Integer> iterable) {
                ensurePathIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.path_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearPath() {
                this.path_ = emptyIntList();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getSpanList() {
                return this.span_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpanCount() {
                return this.span_.size();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpan(int i) {
                return this.span_.getInt(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private void ensureSpanIsMutable() {
                Internal.IntList intList = this.span_;
                if (intList.isModifiable()) {
                    return;
                }
                this.span_ = GeneratedMessageLite.mutableCopy(intList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setSpan(int i, int i2) {
                ensureSpanIsMutable();
                this.span_.setInt(i, i2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addSpan(int i) {
                ensureSpanIsMutable();
                this.span_.addInt(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addAllSpan(Iterable<? extends Integer> iterable) {
                ensureSpanIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.span_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearSpan() {
                this.span_ = emptyIntList();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public boolean hasLeadingComments() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getLeadingComments() {
                return this.leadingComments_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getLeadingCommentsBytes() {
                return ByteString.copyFromUtf8(this.leadingComments_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setLeadingComments(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.leadingComments_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearLeadingComments() {
                this.bitField0_ &= -2;
                this.leadingComments_ = getDefaultInstance().getLeadingComments();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setLeadingCommentsBytes(ByteString byteString) {
                this.leadingComments_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public boolean hasTrailingComments() {
                return (this.bitField0_ & 2) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getTrailingComments() {
                return this.trailingComments_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getTrailingCommentsBytes() {
                return ByteString.copyFromUtf8(this.trailingComments_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setTrailingComments(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.trailingComments_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearTrailingComments() {
                this.bitField0_ &= -3;
                this.trailingComments_ = getDefaultInstance().getTrailingComments();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setTrailingCommentsBytes(ByteString byteString) {
                this.trailingComments_ = byteString.toStringUtf8();
                this.bitField0_ |= 2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<String> getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getLeadingDetachedComments(int i) {
                return this.leadingDetachedComments_.get(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getLeadingDetachedCommentsBytes(int i) {
                return ByteString.copyFromUtf8(this.leadingDetachedComments_.get(i));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private void ensureLeadingDetachedCommentsIsMutable() {
                Internal.ProtobufList<String> protobufList = this.leadingDetachedComments_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.leadingDetachedComments_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setLeadingDetachedComments(int i, String str) {
                str.getClass();
                ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.set(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addLeadingDetachedComments(String str) {
                str.getClass();
                ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.add(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addAllLeadingDetachedComments(Iterable<String> iterable) {
                ensureLeadingDetachedCommentsIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.leadingDetachedComments_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearLeadingDetachedComments() {
                this.leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addLeadingDetachedCommentsBytes(ByteString byteString) {
                ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.add(byteString.toStringUtf8());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Location) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder(Location location) {
                return DEFAULT_INSTANCE.createBuilder(location);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ Builder(C19991 c19991) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Builder() {
                    super(Location.DEFAULT_INSTANCE);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Location) this.instance).getPathList());
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPathCount() {
                    return ((Location) this.instance).getPathCount();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPath(int i) {
                    return ((Location) this.instance).getPath(i);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setPath(int i, int i2) {
                    copyOnWrite();
                    ((Location) this.instance).setPath(i, i2);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addPath(int i) {
                    copyOnWrite();
                    ((Location) this.instance).addPath(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    copyOnWrite();
                    ((Location) this.instance).addAllPath(iterable);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearPath() {
                    copyOnWrite();
                    ((Location) this.instance).clearPath();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(((Location) this.instance).getSpanList());
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpanCount() {
                    return ((Location) this.instance).getSpanCount();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpan(int i) {
                    return ((Location) this.instance).getSpan(i);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setSpan(int i, int i2) {
                    copyOnWrite();
                    ((Location) this.instance).setSpan(i, i2);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addSpan(int i) {
                    copyOnWrite();
                    ((Location) this.instance).addSpan(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addAllSpan(Iterable<? extends Integer> iterable) {
                    copyOnWrite();
                    ((Location) this.instance).addAllSpan(iterable);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearSpan() {
                    copyOnWrite();
                    ((Location) this.instance).clearSpan();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public boolean hasLeadingComments() {
                    return ((Location) this.instance).hasLeadingComments();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getLeadingComments() {
                    return ((Location) this.instance).getLeadingComments();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getLeadingCommentsBytes() {
                    return ((Location) this.instance).getLeadingCommentsBytes();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setLeadingComments(String str) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingComments(str);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearLeadingComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearLeadingComments();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setLeadingCommentsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingCommentsBytes(byteString);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public boolean hasTrailingComments() {
                    return ((Location) this.instance).hasTrailingComments();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getTrailingComments() {
                    return ((Location) this.instance).getTrailingComments();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getTrailingCommentsBytes() {
                    return ((Location) this.instance).getTrailingCommentsBytes();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setTrailingComments(String str) {
                    copyOnWrite();
                    ((Location) this.instance).setTrailingComments(str);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearTrailingComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearTrailingComments();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setTrailingCommentsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Location) this.instance).setTrailingCommentsBytes(byteString);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<String> getLeadingDetachedCommentsList() {
                    return Collections.unmodifiableList(((Location) this.instance).getLeadingDetachedCommentsList());
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getLeadingDetachedCommentsCount() {
                    return ((Location) this.instance).getLeadingDetachedCommentsCount();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getLeadingDetachedComments(int i) {
                    return ((Location) this.instance).getLeadingDetachedComments(i);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getLeadingDetachedCommentsBytes(int i) {
                    return ((Location) this.instance).getLeadingDetachedCommentsBytes(i);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setLeadingDetachedComments(int i, String str) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingDetachedComments(i, str);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addLeadingDetachedComments(String str) {
                    copyOnWrite();
                    ((Location) this.instance).addLeadingDetachedComments(str);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addAllLeadingDetachedComments(Iterable<String> iterable) {
                    copyOnWrite();
                    ((Location) this.instance).addAllLeadingDetachedComments(iterable);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearLeadingDetachedComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearLeadingDetachedComments();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addLeadingDetachedCommentsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Location) this.instance).addLeadingDetachedCommentsBytes(byteString);
                    return this;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C19991 c19991 = null;
                switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Location();
                    case 2:
                        return new Builder(c19991);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001'\u0002'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001a", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Location> parser = PARSER;
                        if (parser == null) {
                            synchronized (Location.class) {
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
                Location location = new Location();
                DEFAULT_INSTANCE = location;
                GeneratedMessageLite.registerDefaultInstance(Location.class, location);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Location getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Parser<Location> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public List<Location> getLocationList() {
            return this.location_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public int getLocationCount() {
            return this.location_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public Location getLocation(int i) {
            return this.location_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LocationOrBuilder getLocationOrBuilder(int i) {
            return this.location_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureLocationIsMutable() {
            Internal.ProtobufList<Location> protobufList = this.location_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.location_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLocation(int i, Location location) {
            location.getClass();
            ensureLocationIsMutable();
            this.location_.set(i, location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addLocation(Location location) {
            location.getClass();
            ensureLocationIsMutable();
            this.location_.add(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addLocation(int i, Location location) {
            location.getClass();
            ensureLocationIsMutable();
            this.location_.add(i, location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllLocation(Iterable<? extends Location> iterable) {
            ensureLocationIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.location_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearLocation() {
            this.location_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeLocation(int i) {
            ensureLocationIsMutable();
            this.location_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(SourceCodeInfo sourceCodeInfo) {
            return DEFAULT_INSTANCE.createBuilder(sourceCodeInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(SourceCodeInfo.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public List<Location> getLocationList() {
                return Collections.unmodifiableList(((SourceCodeInfo) this.instance).getLocationList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public int getLocationCount() {
                return ((SourceCodeInfo) this.instance).getLocationCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public Location getLocation(int i) {
                return ((SourceCodeInfo) this.instance).getLocation(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setLocation(int i, Location location) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).setLocation(i, location);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setLocation(int i, Location.Builder builder) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).setLocation(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addLocation(Location location) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(location);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addLocation(int i, Location location) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(i, location);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addLocation(Location.Builder builder) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addLocation(int i, Location.Builder builder) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllLocation(Iterable<? extends Location> iterable) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addAllLocation(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearLocation() {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).clearLocation();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeLocation(int i) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).removeLocation(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new SourceCodeInfo();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"location_", Location.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SourceCodeInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (SourceCodeInfo.class) {
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
            SourceCodeInfo sourceCodeInfo = new SourceCodeInfo();
            DEFAULT_INSTANCE = sourceCodeInfo;
            GeneratedMessageLite.registerDefaultInstance(SourceCodeInfo.class, sourceCodeInfo);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SourceCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<SourceCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        private static final GeneratedCodeInfo DEFAULT_INSTANCE;
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = emptyProtobufList();

        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
            int getBegin();

            int getEnd();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            String getSourceFile();

            ByteString getSourceFileBytes();

            boolean hasBegin();

            boolean hasEnd();

            boolean hasSourceFile();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private GeneratedCodeInfo() {
        }

        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            private static final Annotation DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = emptyIntList();
            private String sourceFile_ = "";

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Annotation() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getPath(int i) {
                return this.path_.getInt(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private void ensurePathIsMutable() {
                Internal.IntList intList = this.path_;
                if (intList.isModifiable()) {
                    return;
                }
                this.path_ = GeneratedMessageLite.mutableCopy(intList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setPath(int i, int i2) {
                ensurePathIsMutable();
                this.path_.setInt(i, i2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addPath(int i) {
                ensurePathIsMutable();
                this.path_.addInt(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void addAllPath(Iterable<? extends Integer> iterable) {
                ensurePathIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.path_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearPath() {
                this.path_ = emptyIntList();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasSourceFile() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public String getSourceFile() {
                return this.sourceFile_;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public ByteString getSourceFileBytes() {
                return ByteString.copyFromUtf8(this.sourceFile_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setSourceFile(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.sourceFile_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearSourceFile() {
                this.bitField0_ &= -2;
                this.sourceFile_ = getDefaultInstance().getSourceFile();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setSourceFileBytes(ByteString byteString) {
                this.sourceFile_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasBegin() {
                return (this.bitField0_ & 2) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getBegin() {
                return this.begin_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setBegin(int i) {
                this.bitField0_ |= 2;
                this.begin_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearBegin() {
                this.bitField0_ &= -3;
                this.begin_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 4) != 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getEnd() {
                return this.end_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void setEnd(int i) {
                this.bitField0_ |= 4;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void clearEnd() {
                this.bitField0_ &= -5;
                this.end_ = 0;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(InputStream inputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Annotation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Builder newBuilder(Annotation annotation) {
                return DEFAULT_INSTANCE.createBuilder(annotation);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ Builder(C19991 c19991) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Builder() {
                    super(Annotation.DEFAULT_INSTANCE);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Annotation) this.instance).getPathList());
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getPathCount() {
                    return ((Annotation) this.instance).getPathCount();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getPath(int i) {
                    return ((Annotation) this.instance).getPath(i);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setPath(int i, int i2) {
                    copyOnWrite();
                    ((Annotation) this.instance).setPath(i, i2);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addPath(int i) {
                    copyOnWrite();
                    ((Annotation) this.instance).addPath(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    copyOnWrite();
                    ((Annotation) this.instance).addAllPath(iterable);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearPath() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearPath();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasSourceFile() {
                    return ((Annotation) this.instance).hasSourceFile();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public String getSourceFile() {
                    return ((Annotation) this.instance).getSourceFile();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public ByteString getSourceFileBytes() {
                    return ((Annotation) this.instance).getSourceFileBytes();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setSourceFile(String str) {
                    copyOnWrite();
                    ((Annotation) this.instance).setSourceFile(str);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearSourceFile() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearSourceFile();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setSourceFileBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Annotation) this.instance).setSourceFileBytes(byteString);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasBegin() {
                    return ((Annotation) this.instance).hasBegin();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getBegin() {
                    return ((Annotation) this.instance).getBegin();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setBegin(int i) {
                    copyOnWrite();
                    ((Annotation) this.instance).setBegin(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearBegin() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearBegin();
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasEnd() {
                    return ((Annotation) this.instance).hasEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getEnd() {
                    return ((Annotation) this.instance).getEnd();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((Annotation) this.instance).setEnd(i);
                    return this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public Builder clearEnd() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearEnd();
                    return this;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C19991 c19991 = null;
                switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Annotation();
                    case 2:
                        return new Builder(c19991);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Annotation> parser = PARSER;
                        if (parser == null) {
                            synchronized (Annotation.class) {
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
                Annotation annotation = new Annotation();
                DEFAULT_INSTANCE = annotation;
                GeneratedMessageLite.registerDefaultInstance(Annotation.class, annotation);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Annotation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static Parser<Annotation> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public Annotation getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AnnotationOrBuilder getAnnotationOrBuilder(int i) {
            return this.annotation_.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureAnnotationIsMutable() {
            Internal.ProtobufList<Annotation> protobufList = this.annotation_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.annotation_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setAnnotation(int i, Annotation annotation) {
            annotation.getClass();
            ensureAnnotationIsMutable();
            this.annotation_.set(i, annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAnnotation(Annotation annotation) {
            annotation.getClass();
            ensureAnnotationIsMutable();
            this.annotation_.add(annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAnnotation(int i, Annotation annotation) {
            annotation.getClass();
            ensureAnnotationIsMutable();
            this.annotation_.add(i, annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addAllAnnotation(Iterable<? extends Annotation> iterable) {
            ensureAnnotationIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.annotation_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearAnnotation() {
            this.annotation_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void removeAnnotation(int i) {
            ensureAnnotationIsMutable();
            this.annotation_.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(GeneratedCodeInfo generatedCodeInfo) {
            return DEFAULT_INSTANCE.createBuilder(generatedCodeInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C19991 c19991) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(GeneratedCodeInfo.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(((GeneratedCodeInfo) this.instance).getAnnotationList());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public int getAnnotationCount() {
                return ((GeneratedCodeInfo) this.instance).getAnnotationCount();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public Annotation getAnnotation(int i) {
                return ((GeneratedCodeInfo) this.instance).getAnnotation(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setAnnotation(int i, Annotation annotation) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).setAnnotation(i, annotation);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setAnnotation(int i, Annotation.Builder builder) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).setAnnotation(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAnnotation(Annotation annotation) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(annotation);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAnnotation(int i, Annotation annotation) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(i, annotation);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAnnotation(Annotation.Builder builder) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAnnotation(int i, Annotation.Builder builder) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(i, builder.build());
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder addAllAnnotation(Iterable<? extends Annotation> iterable) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAllAnnotation(iterable);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearAnnotation() {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).clearAnnotation();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder removeAnnotation(int i) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).removeAnnotation(i);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C19991 c19991 = null;
            switch (C19991.f469xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new GeneratedCodeInfo();
                case 2:
                    return new Builder(c19991);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"annotation_", Annotation.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GeneratedCodeInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (GeneratedCodeInfo.class) {
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
            GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo();
            DEFAULT_INSTANCE = generatedCodeInfo;
            GeneratedMessageLite.registerDefaultInstance(GeneratedCodeInfo.class, generatedCodeInfo);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static GeneratedCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<GeneratedCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
