package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class InvalidProtocolBufferException extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    private MessageLite unfinishedMessage;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvalidProtocolBufferException(String str) {
        super(str);
        this.unfinishedMessage = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvalidProtocolBufferException(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.unfinishedMessage = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvalidProtocolBufferException(String str, IOException iOException) {
        super(str, iOException);
        this.unfinishedMessage = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvalidProtocolBufferException setUnfinishedMessage(MessageLite messageLite) {
        this.unfinishedMessage = messageLite;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MessageLite getUnfinishedMessage() {
        return this.unfinishedMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IOException unwrapIOException() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException truncatedMessage() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException negativeSize() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException malformedVarint() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException invalidTag() {
        return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException invalidEndTag() {
        return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidWireTypeException invalidWireType() {
        return new InvalidWireTypeException("Protocol message tag had invalid wire type.");
    }

    public static class InvalidWireTypeException extends InvalidProtocolBufferException {
        private static final long serialVersionUID = 3283890091615336259L;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InvalidWireTypeException(String str) {
            super(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException recursionLimitExceeded() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException sizeLimitExceeded() {
        return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException parseFailure() {
        return new InvalidProtocolBufferException("Failed to parse the message.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static InvalidProtocolBufferException invalidUtf8() {
        return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }
}
