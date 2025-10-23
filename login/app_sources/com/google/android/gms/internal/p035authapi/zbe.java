package com.google.android.gms.internal.p035authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
public final class zbe implements CredentialRequestResult {
    private final Status zba;
    private final Credential zbb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zbe(Status status, Credential credential) {
        this.zba = status;
        this.zbb = credential;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.credentials.CredentialRequestResult
    public final Credential getCredential() {
        return this.zbb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zba;
    }
}
