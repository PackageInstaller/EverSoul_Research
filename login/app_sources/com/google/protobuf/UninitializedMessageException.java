package com.google.protobuf;

import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UninitializedMessageException(List<String> list) {
        super(buildDescription(list));
        this.missingFields = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String buildDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
