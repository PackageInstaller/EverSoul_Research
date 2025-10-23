package com.google.firebase.perf.p010v1;

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
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class PerfSession extends GeneratedMessageLite<PerfSession, Builder> implements PerfSessionOrBuilder {
    private static final PerfSession DEFAULT_INSTANCE;
    private static volatile Parser<PerfSession> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    private static final Internal.ListAdapter.Converter<Integer, SessionVerbosity> sessionVerbosity_converter_ = new Internal.ListAdapter.Converter<Integer, SessionVerbosity>() { // from class: com.google.firebase.perf.v1.PerfSession.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public SessionVerbosity convert(Integer num) {
            SessionVerbosity forNumber = SessionVerbosity.forNumber(num.intValue());
            return forNumber == null ? SessionVerbosity.SESSION_VERBOSITY_NONE : forNumber;
        }
    };
    private int bitField0_;
    private String sessionId_ = "";
    private Internal.IntList sessionVerbosity_ = emptyIntList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PerfSession() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
    public String getSessionId() {
        return this.sessionId_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSessionId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSessionIdBytes(ByteString byteString) {
        this.sessionId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        PerfSession perfSession = new PerfSession();
        DEFAULT_INSTANCE = perfSession;
        GeneratedMessageLite.registerDefaultInstance(PerfSession.class, perfSession);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
    public List<SessionVerbosity> getSessionVerbosityList() {
        return new Internal.ListAdapter(this.sessionVerbosity_, sessionVerbosity_converter_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
    public int getSessionVerbosityCount() {
        return this.sessionVerbosity_.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
    public SessionVerbosity getSessionVerbosity(int i) {
        SessionVerbosity forNumber = SessionVerbosity.forNumber(this.sessionVerbosity_.getInt(i));
        return forNumber == null ? SessionVerbosity.SESSION_VERBOSITY_NONE : forNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureSessionVerbosityIsMutable() {
        Internal.IntList intList = this.sessionVerbosity_;
        if (intList.isModifiable()) {
            return;
        }
        this.sessionVerbosity_ = GeneratedMessageLite.mutableCopy(intList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSessionVerbosity(int i, SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        ensureSessionVerbosityIsMutable();
        this.sessionVerbosity_.setInt(i, sessionVerbosity.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addSessionVerbosity(SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        ensureSessionVerbosityIsMutable();
        this.sessionVerbosity_.addInt(sessionVerbosity.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAllSessionVerbosity(Iterable<? extends SessionVerbosity> iterable) {
        ensureSessionVerbosityIsMutable();
        Iterator<? extends SessionVerbosity> it = iterable.iterator();
        while (it.hasNext()) {
            this.sessionVerbosity_.addInt(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearSessionVerbosity() {
        this.sessionVerbosity_ = emptyIntList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(InputStream inputStream) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PerfSession) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PerfSession) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(PerfSession perfSession) {
        return DEFAULT_INSTANCE.createBuilder(perfSession);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PerfSession, Builder> implements PerfSessionOrBuilder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            super(PerfSession.DEFAULT_INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
        public boolean hasSessionId() {
            return ((PerfSession) this.instance).hasSessionId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
        public String getSessionId() {
            return ((PerfSession) this.instance).getSessionId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
        public ByteString getSessionIdBytes() {
            return ((PerfSession) this.instance).getSessionIdBytes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSessionId(String str) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionId(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSessionId() {
            copyOnWrite();
            ((PerfSession) this.instance).clearSessionId();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
        public List<SessionVerbosity> getSessionVerbosityList() {
            return ((PerfSession) this.instance).getSessionVerbosityList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
        public int getSessionVerbosityCount() {
            return ((PerfSession) this.instance).getSessionVerbosityCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.p010v1.PerfSessionOrBuilder
        public SessionVerbosity getSessionVerbosity(int i) {
            return ((PerfSession) this.instance).getSessionVerbosity(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSessionVerbosity(int i, SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionVerbosity(i, sessionVerbosity);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addSessionVerbosity(SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            ((PerfSession) this.instance).addSessionVerbosity(sessionVerbosity);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAllSessionVerbosity(Iterable<? extends SessionVerbosity> iterable) {
            copyOnWrite();
            ((PerfSession) this.instance).addAllSessionVerbosity(iterable);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder clearSessionVerbosity() {
            copyOnWrite();
            ((PerfSession) this.instance).clearSessionVerbosity();
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.PerfSession$2 */
    static /* synthetic */ class C18472 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f450xa1df5c61;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f450xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f450xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f450xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f450xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f450xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f450xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f450xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C18472.f450xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new PerfSession();
            case 2:
                return new Builder();
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", new Object[]{"bitField0_", "sessionId_", "sessionVerbosity_", SessionVerbosity.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PerfSession> parser = PARSER;
                if (parser == null) {
                    synchronized (PerfSession.class) {
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
    public static PerfSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parser<PerfSession> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
