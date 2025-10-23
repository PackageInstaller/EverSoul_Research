package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class MessagingClientEventExtension {
    private static final MessagingClientEventExtension DEFAULT_INSTANCE = new Builder().build();
    private final MessagingClientEvent messaging_client_event_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.messaging_client_event_ = messagingClientEvent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeTo(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.encode(this, outputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Ignore
    public MessagingClientEvent getMessagingClientEvent() {
        MessagingClientEvent messagingClientEvent = this.messaging_client_event_;
        return messagingClientEvent == null ? MessagingClientEvent.getDefaultInstance() : messagingClientEvent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Field(name = "messagingClientEvent")
    public MessagingClientEvent getMessagingClientEventInternal() {
        return this.messaging_client_event_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MessagingClientEventExtension getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private MessagingClientEvent messaging_client_event_ = null;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MessagingClientEventExtension build() {
            return new MessagingClientEventExtension(this.messaging_client_event_);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMessagingClientEvent(MessagingClientEvent messagingClientEvent) {
            this.messaging_client_event_ = messagingClientEvent;
            return this;
        }
    }
}
