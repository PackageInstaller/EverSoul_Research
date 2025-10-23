package com.google.firebase.messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;
import java.io.OutputStream;

@Encodable
/* loaded from: classes2.dex */
public abstract class ProtoEncoderDoNotUse {
    private static final ProtobufEncoder ENCODER = ProtobufEncoder.builder().configureWith(AutoProtoEncoderDoNotUseEncoder.CONFIG).build();

    public abstract MessagingClientEventExtension getMessagingClientEventExtension();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ProtoEncoderDoNotUse() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] encode(Object obj) {
        return ENCODER.encode(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void encode(Object obj, OutputStream outputStream) throws IOException {
        ENCODER.encode(obj, outputStream);
    }
}
