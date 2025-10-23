package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class UserRecoverableException extends Exception {
    private final Intent zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.zza = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
