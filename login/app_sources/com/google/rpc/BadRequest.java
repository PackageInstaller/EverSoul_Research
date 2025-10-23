package com.google.rpc;

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

/* loaded from: classes3.dex */
public final class BadRequest extends GeneratedMessageLite<BadRequest, Builder> implements BadRequestOrBuilder {
    private static final BadRequest DEFAULT_INSTANCE;
    public static final int FIELD_VIOLATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<BadRequest> PARSER;
    private Internal.ProtobufList<FieldViolation> fieldViolations_ = emptyProtobufList();

    public interface FieldViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getField();

        ByteString getFieldBytes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BadRequest() {
    }

    public static final class FieldViolation extends GeneratedMessageLite<FieldViolation, Builder> implements FieldViolationOrBuilder {
        private static final FieldViolation DEFAULT_INSTANCE;
        public static final int DESCRIPTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<FieldViolation> PARSER;
        private String field_ = "";
        private String description_ = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FieldViolation() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public String getField() {
            return this.field_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public ByteString getFieldBytes() {
            return ByteString.copyFromUtf8(this.field_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setField(String str) {
            str.getClass();
            this.field_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clearField() {
            this.field_ = getDefaultInstance().getField();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setFieldBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.field_ = byteString.toStringUtf8();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public String getDescription() {
            return this.description_;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
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
        public static FieldViolation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(InputStream inputStream) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldViolation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldViolation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder(FieldViolation fieldViolation) {
            return DEFAULT_INSTANCE.createBuilder(fieldViolation);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, Builder> implements FieldViolationOrBuilder {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(C20621 c20621) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                super(FieldViolation.DEFAULT_INSTANCE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public String getField() {
                return ((FieldViolation) this.instance).getField();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public ByteString getFieldBytes() {
                return ((FieldViolation) this.instance).getFieldBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setField(String str) {
                copyOnWrite();
                ((FieldViolation) this.instance).setField(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearField() {
                copyOnWrite();
                ((FieldViolation) this.instance).clearField();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFieldBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldViolation) this.instance).setFieldBytes(byteString);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public String getDescription() {
                return ((FieldViolation) this.instance).getDescription();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public ByteString getDescriptionBytes() {
                return ((FieldViolation) this.instance).getDescriptionBytes();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDescription(String str) {
                copyOnWrite();
                ((FieldViolation) this.instance).setDescription(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder clearDescription() {
                copyOnWrite();
                ((FieldViolation) this.instance).clearDescription();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setDescriptionBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldViolation) this.instance).setDescriptionBytes(byteString);
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C20621 c20621 = null;
            switch (C20621.f494xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldViolation();
                case 2:
                    return new Builder(c20621);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"field_", "description_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldViolation> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldViolation.class) {
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
            FieldViolation fieldViolation = new FieldViolation();
            DEFAULT_INSTANCE = fieldViolation;
            GeneratedMessageLite.registerDefaultInstance(FieldViolation.class, fieldViolation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FieldViolation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Parser<FieldViolation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.rpc.BadRequest$1 */
    static /* synthetic */ class C20621 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f494xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f494xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f494xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f494xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f494xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f494xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f494xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f494xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.BadRequestOrBuilder
    public List<FieldViolation> getFieldViolationsList() {
        return this.fieldViolations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
        return this.fieldViolations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.BadRequestOrBuilder
    public int getFieldViolationsCount() {
        return this.fieldViolations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.rpc.BadRequestOrBuilder
    public FieldViolation getFieldViolations(int i) {
        return this.fieldViolations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FieldViolationOrBuilder getFieldViolationsOrBuilder(int i) {
        return this.fieldViolations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureFieldViolationsIsMutable() {
        Internal.ProtobufList<FieldViolation> protobufList = this.fieldViolations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.fieldViolations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFieldViolations(int i, FieldViolation fieldViolation) {
        fieldViolation.getClass();
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.set(i, fieldViolation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addFieldViolations(FieldViolation fieldViolation) {
        fieldViolation.getClass();
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(fieldViolation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addFieldViolations(int i, FieldViolation fieldViolation) {
        fieldViolation.getClass();
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(i, fieldViolation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllFieldViolations(Iterable<? extends FieldViolation> iterable) {
        ensureFieldViolationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.fieldViolations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearFieldViolations() {
        this.fieldViolations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeFieldViolations(int i) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(InputStream inputStream) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BadRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BadRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(BadRequest badRequest) {
        return DEFAULT_INSTANCE.createBuilder(badRequest);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<BadRequest, Builder> implements BadRequestOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C20621 c20621) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(BadRequest.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequestOrBuilder
        public List<FieldViolation> getFieldViolationsList() {
            return Collections.unmodifiableList(((BadRequest) this.instance).getFieldViolationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequestOrBuilder
        public int getFieldViolationsCount() {
            return ((BadRequest) this.instance).getFieldViolationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.rpc.BadRequestOrBuilder
        public FieldViolation getFieldViolations(int i) {
            return ((BadRequest) this.instance).getFieldViolations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setFieldViolations(int i, FieldViolation fieldViolation) {
            copyOnWrite();
            ((BadRequest) this.instance).setFieldViolations(i, fieldViolation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setFieldViolations(int i, FieldViolation.Builder builder) {
            copyOnWrite();
            ((BadRequest) this.instance).setFieldViolations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addFieldViolations(FieldViolation fieldViolation) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(fieldViolation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addFieldViolations(int i, FieldViolation fieldViolation) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(i, fieldViolation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addFieldViolations(FieldViolation.Builder builder) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addFieldViolations(int i, FieldViolation.Builder builder) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllFieldViolations(Iterable<? extends FieldViolation> iterable) {
            copyOnWrite();
            ((BadRequest) this.instance).addAllFieldViolations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearFieldViolations() {
            copyOnWrite();
            ((BadRequest) this.instance).clearFieldViolations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeFieldViolations(int i) {
            copyOnWrite();
            ((BadRequest) this.instance).removeFieldViolations(i);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C20621 c20621 = null;
        switch (C20621.f494xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new BadRequest();
            case 2:
                return new Builder(c20621);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"fieldViolations_", FieldViolation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BadRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (BadRequest.class) {
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
        BadRequest badRequest = new BadRequest();
        DEFAULT_INSTANCE = badRequest;
        GeneratedMessageLite.registerDefaultInstance(BadRequest.class, badRequest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BadRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<BadRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
