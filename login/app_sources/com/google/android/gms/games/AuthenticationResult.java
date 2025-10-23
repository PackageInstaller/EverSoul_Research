package com.google.android.gms.games;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class AuthenticationResult {
    public static final AuthenticationResult zza = new AuthenticationResult(true);
    public static final AuthenticationResult zzb = new AuthenticationResult(false);
    private final boolean zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthenticationResult(boolean z) {
        this.zzc = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAuthenticated() {
        return this.zzc;
    }
}
