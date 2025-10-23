package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public final class zbn {
    private static zbn zbd;
    final Storage zba;
    GoogleSignInAccount zbb;
    GoogleSignInOptions zbc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zbn(Context context) {
        Storage storage = Storage.getInstance(context);
        this.zba = storage;
        this.zbb = storage.getSavedDefaultGoogleSignInAccount();
        this.zbc = storage.getSavedDefaultGoogleSignInOptions();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized zbn zbc(Context context) {
        zbn zbf;
        synchronized (zbn.class) {
            zbf = zbf(context.getApplicationContext());
        }
        return zbf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized zbn zbf(Context context) {
        synchronized (zbn.class) {
            zbn zbnVar = zbd;
            if (zbnVar != null) {
                return zbnVar;
            }
            zbn zbnVar2 = new zbn(context);
            zbd = zbnVar2;
            return zbnVar2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized GoogleSignInAccount zba() {
        return this.zbb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized GoogleSignInOptions zbb() {
        return this.zbc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zbd() {
        this.zba.clear();
        this.zbb = null;
        this.zbc = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zbe(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zba.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zbb = googleSignInAccount;
        this.zbc = googleSignInOptions;
    }
}
