package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
final class zbf extends zba {
    final /* synthetic */ zbg zba;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zbf(zbg zbgVar) {
        this.zba = zbgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbd(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zbn.zbc(this.zba.zba).zbe(this.zba.zbb, googleSignInAccount);
        }
        this.zba.setResult((zbg) new GoogleSignInResult(googleSignInAccount, status));
    }
}
