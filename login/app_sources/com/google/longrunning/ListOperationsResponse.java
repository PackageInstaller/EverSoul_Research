package com.google.longrunning;

import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ListOperationsResponse extends GeneratedMessageLite<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
    private static final ListOperationsResponse DEFAULT_INSTANCE;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    public static final int OPERATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<ListOperationsResponse> PARSER;
    private Internal.ProtobufList<Operation> operations_ = emptyProtobufList();
    private String nextPageToken_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ListOperationsResponse() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public List<Operation> getOperationsList() {
        return this.operations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
        return this.operations_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public int getOperationsCount() {
        return this.operations_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public Operation getOperations(int i) {
        return this.operations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OperationOrBuilder getOperationsOrBuilder(int i) {
        return this.operations_.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureOperationsIsMutable() {
        Internal.ProtobufList<Operation> protobufList = this.operations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.operations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOperations(int i, Operation operation) {
        operation.getClass();
        ensureOperationsIsMutable();
        this.operations_.set(i, operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOperations(Operation operation) {
        operation.getClass();
        ensureOperationsIsMutable();
        this.operations_.add(operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addOperations(int i, Operation operation) {
        operation.getClass();
        ensureOperationsIsMutable();
        this.operations_.add(i, operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllOperations(Iterable<? extends Operation> iterable) {
        ensureOperationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.operations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearOperations() {
        this.operations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeOperations(int i) {
        ensureOperationsIsMutable();
        this.operations_.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNextPageToken(String str) {
        str.getClass();
        this.nextPageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNextPageTokenBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.nextPageToken_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListOperationsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListOperationsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(ListOperationsResponse listOperationsResponse) {
        return DEFAULT_INSTANCE.createBuilder(listOperationsResponse);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(C19791 c19791) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(ListOperationsResponse.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public List<Operation> getOperationsList() {
            return Collections.unmodifiableList(((ListOperationsResponse) this.instance).getOperationsList());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public int getOperationsCount() {
            return ((ListOperationsResponse) this.instance).getOperationsCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public Operation getOperations(int i) {
            return ((ListOperationsResponse) this.instance).getOperations(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOperations(int i, Operation operation) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setOperations(i, operation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setOperations(int i, Operation.Builder builder) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setOperations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addOperations(Operation operation) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(operation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addOperations(int i, Operation operation) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(i, operation);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addOperations(Operation.Builder builder) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addOperations(int i, Operation.Builder builder) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(i, builder.build());
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllOperations(Iterable<? extends Operation> iterable) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addAllOperations(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearOperations() {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).clearOperations();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder removeOperations(int i) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).removeOperations(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public String getNextPageToken() {
            return ((ListOperationsResponse) this.instance).getNextPageToken();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public ByteString getNextPageTokenBytes() {
            return ((ListOperationsResponse) this.instance).getNextPageTokenBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNextPageToken(String str) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setNextPageToken(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearNextPageToken() {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).clearNextPageToken();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNextPageTokenBytes(ByteString byteString) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setNextPageTokenBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.longrunning.ListOperationsResponse$1 */
    static /* synthetic */ class C19791 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f461xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f461xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f461xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f461xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f461xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f461xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f461xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f461xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C19791 c19791 = null;
        switch (C19791.f461xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ListOperationsResponse();
            case 2:
                return new Builder(c19791);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"operations_", Operation.class, "nextPageToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListOperationsResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (ListOperationsResponse.class) {
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
        ListOperationsResponse listOperationsResponse = new ListOperationsResponse();
        DEFAULT_INSTANCE = listOperationsResponse;
        GeneratedMessageLite.registerDefaultInstance(ListOperationsResponse.class, listOperationsResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ListOperationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<ListOperationsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
