package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class Operation extends GeneratedMessageLite<Operation, Builder> implements OperationOrBuilder {
    private static final Operation DEFAULT_INSTANCE;
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Operation> PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private boolean done_;
    private Any metadata_;
    private Object result_;
    private int resultCase_ = 0;
    private String name_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Operation() {
    }

    public enum ResultCase {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);

        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResultCase(int i) {
            this.value = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ResultCase forNumber(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 4) {
                return ERROR;
            }
            if (i != 5) {
                return null;
            }
            return RESPONSE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getNumber() {
            return this.value;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public String getName() {
        return this.name_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
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
    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public Any getMetadata() {
        Any any = this.metadata_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMetadata(Any any) {
        any.getClass();
        this.metadata_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeMetadata(Any any) {
        any.getClass();
        Any any2 = this.metadata_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            this.metadata_ = Any.newBuilder(this.metadata_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.metadata_ = any;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public boolean getDone() {
        return this.done_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDone(boolean z) {
        this.done_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearDone() {
        this.done_ = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasError() {
        return this.resultCase_ == 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public Status getError() {
        if (this.resultCase_ == 4) {
            return (Status) this.result_;
        }
        return Status.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setError(Status status) {
        status.getClass();
        this.result_ = status;
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeError(Status status) {
        status.getClass();
        if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
            this.result_ = Status.newBuilder((Status) this.result_).mergeFrom((Status.Builder) status).buildPartial();
        } else {
            this.result_ = status;
        }
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearError() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasResponse() {
        return this.resultCase_ == 5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.OperationOrBuilder
    public Any getResponse() {
        if (this.resultCase_ == 5) {
            return (Any) this.result_;
        }
        return Any.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResponse(Any any) {
        any.getClass();
        this.result_ = any;
        this.resultCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeResponse(Any any) {
        any.getClass();
        if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
            this.result_ = Any.newBuilder((Any) this.result_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.result_ = any;
        }
        this.resultCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearResponse() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Operation operation) {
        return DEFAULT_INSTANCE.createBuilder(operation);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C19801 c19801) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(Operation.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public ResultCase getResultCase() {
            return ((Operation) this.instance).getResultCase();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearResult() {
            copyOnWrite();
            ((Operation) this.instance).clearResult();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public String getName() {
            return ((Operation) this.instance).getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public ByteString getNameBytes() {
            return ((Operation) this.instance).getNameBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(String str) {
            copyOnWrite();
            ((Operation) this.instance).setName(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearName() {
            copyOnWrite();
            ((Operation) this.instance).clearName();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Operation) this.instance).setNameBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasMetadata() {
            return ((Operation) this.instance).hasMetadata();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public Any getMetadata() {
            return ((Operation) this.instance).getMetadata();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMetadata(Any any) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(any);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMetadata(Any.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeMetadata(Any any) {
            copyOnWrite();
            ((Operation) this.instance).mergeMetadata(any);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearMetadata() {
            copyOnWrite();
            ((Operation) this.instance).clearMetadata();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public boolean getDone() {
            return ((Operation) this.instance).getDone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDone(boolean z) {
            copyOnWrite();
            ((Operation) this.instance).setDone(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearDone() {
            copyOnWrite();
            ((Operation) this.instance).clearDone();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasError() {
            return ((Operation) this.instance).hasError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public Status getError() {
            return ((Operation) this.instance).getError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setError(Status status) {
            copyOnWrite();
            ((Operation) this.instance).setError(status);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setError(Status.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setError(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeError(Status status) {
            copyOnWrite();
            ((Operation) this.instance).mergeError(status);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearError() {
            copyOnWrite();
            ((Operation) this.instance).clearError();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasResponse() {
            return ((Operation) this.instance).hasResponse();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.OperationOrBuilder
        public Any getResponse() {
            return ((Operation) this.instance).getResponse();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setResponse(Any any) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(any);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setResponse(Any.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder mergeResponse(Any any) {
            copyOnWrite();
            ((Operation) this.instance).mergeResponse(any);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearResponse() {
            copyOnWrite();
            ((Operation) this.instance).clearResponse();
            return this;
        }
    }

    /* renamed from: com.google.longrunning.Operation$1 */
    static /* synthetic */ class C19801 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f462xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f462xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f462xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f462xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f462xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f462xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f462xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f462xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C19801 c19801 = null;
        switch (C19801.f462xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new Operation();
            case 2:
                return new Builder(c19801);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u0007\u0004<\u0000\u0005<\u0000", new Object[]{"result_", "resultCase_", "name_", "metadata_", "done_", Status.class, Any.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Operation> parser = PARSER;
                if (parser == null) {
                    synchronized (Operation.class) {
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
        Operation operation = new Operation();
        DEFAULT_INSTANCE = operation;
        GeneratedMessageLite.registerDefaultInstance(Operation.class, operation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<Operation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
