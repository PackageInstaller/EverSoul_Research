package com.google.android.gms.auth;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.zza = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent getIntent() {
        Intent intent = this.zza;
        if (intent == null) {
            return null;
        }
        return new Intent(intent);
    }
}
