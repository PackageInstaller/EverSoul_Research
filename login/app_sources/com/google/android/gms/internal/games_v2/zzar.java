package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzar {
    private final zzav zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzar(zzav zzavVar) {
        this.zza = zzavVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzar zza(Application application) {
        return new zzar(zzax.zza(application));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Task zzb(zzaq zzaqVar) {
        zzav zzavVar = this.zza;
        zzaqVar.getClass();
        return zzavVar.zzd(new zzap(zzaqVar));
    }
}
