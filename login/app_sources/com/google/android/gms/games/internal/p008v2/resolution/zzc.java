package com.google.android.gms.games.internal.p008v2.resolution;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzc {
    private final boolean zza;
    private final Intent zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzc(boolean z, Intent intent) {
        this.zza = z;
        this.zzb = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzc zzb(Intent intent) {
        return new zzc(false, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzc zzc(Intent intent) {
        return new zzc(true, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zza() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzd() {
        return this.zza;
    }
}
