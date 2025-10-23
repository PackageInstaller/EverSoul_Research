package com.google.android.gms.auth;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GooglePlayServicesAvailabilityException(int i, String str, Intent intent) {
        super(str, intent);
        this.zza = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getConnectionStatusCode() {
        return this.zza;
    }
}
