package com.google.firebase.remoteconfig;

import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigException extends FirebaseException {
    private final Code code;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigException(String str) {
        super(str);
        this.code = Code.UNKNOWN;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigException(String str, Throwable th) {
        super(str, th);
        this.code = Code.UNKNOWN;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigException(String str, Code code) {
        super(str);
        this.code = code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigException(String str, Throwable th, Code code) {
        super(str, th);
        this.code = code;
    }

    public enum Code {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);

        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Code(int i) {
            this.value = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int value() {
            return this.value;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Code getCode() {
        return this.code;
    }
}
