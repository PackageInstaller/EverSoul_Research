package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public class GoogleSignInResult implements Result {
    private Status zba;
    private GoogleSignInAccount zbb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.zbb = googleSignInAccount;
        this.zba = status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GoogleSignInAccount getSignInAccount() {
        return this.zbb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zba;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSuccess() {
        return this.zba.isSuccess();
    }
}
