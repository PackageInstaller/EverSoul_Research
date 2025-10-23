package com.google.android.gms.games;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzl {
    private static final AtomicInteger zzf = new AtomicInteger(0);
    int zza;
    final ArrayList zzb;
    GoogleSignInAccount zzc;
    String zzd;
    com.google.android.gms.games.internal.zzl zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzl() {
        this.zza = 4368;
        this.zzb = new ArrayList();
        this.zzc = null;
        this.zzd = null;
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzl zza(String str) {
        this.zzd = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzl zzb(com.google.android.gms.games.internal.zzl zzlVar) {
        this.zze = (com.google.android.gms.games.internal.zzl) Preconditions.checkNotNull(zzlVar);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzl zzc(GoogleSignInAccount googleSignInAccount) {
        this.zzc = googleSignInAccount;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzl zzd(int i) {
        this.zza = 2101523;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzn zze() {
        return new zzn(false, true, 17, false, this.zza, null, this.zzb, false, false, false, this.zzc, null, 0, 9, this.zzd, this.zze, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzl(zzk zzkVar) {
        this.zza = 4368;
        this.zzb = new ArrayList();
        this.zzc = null;
        this.zzd = null;
        this.zze = com.google.android.gms.games.internal.zzl.zza;
    }
}
