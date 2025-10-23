package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class SendException extends Exception {
    public static final int ERROR_INVALID_PARAMETERS = 1;
    public static final int ERROR_SIZE = 2;
    public static final int ERROR_TOO_MANY_MESSAGES = 4;
    public static final int ERROR_TTL_EXCEEDED = 3;
    public static final int ERROR_UNKNOWN = 0;
    private final int errorCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SendException(String str) {
        super(str);
        this.errorCode = parseErrorCode(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getErrorCode() {
        return this.errorCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int parseErrorCode(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
        }
        return 0;
    }
}
