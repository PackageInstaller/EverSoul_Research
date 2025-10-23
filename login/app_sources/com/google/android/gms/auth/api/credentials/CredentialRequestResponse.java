package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@Deprecated
/* loaded from: classes.dex */
public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Credential getCredential() {
        return getResult().getCredential();
    }
}
