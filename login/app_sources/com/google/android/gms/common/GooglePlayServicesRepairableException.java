package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.zza = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getConnectionStatusCode() {
        return this.zza;
    }
}
