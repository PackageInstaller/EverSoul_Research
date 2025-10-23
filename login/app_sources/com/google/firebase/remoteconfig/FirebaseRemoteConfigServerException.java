package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int httpStatusCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigServerException(int i, String str) {
        super(str);
        this.httpStatusCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigServerException(int i, String str, Throwable th) {
        super(str, th);
        this.httpStatusCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigServerException(String str, @Nonnull FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.httpStatusCode = -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigServerException(int i, String str, @Nonnull FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.httpStatusCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigServerException(String str, Throwable th, FirebaseRemoteConfigException.Code code) {
        super(str, th, code);
        this.httpStatusCode = -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigServerException(int i, String str, Throwable th, FirebaseRemoteConfigException.Code code) {
        super(str, th, code);
        this.httpStatusCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
