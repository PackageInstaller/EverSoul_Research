package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzax {
    private static final AtomicReference zza = new AtomicReference();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzav zza(Application application) {
        AtomicReference atomicReference = zza;
        zzav zzavVar = (zzav) atomicReference.get();
        if (zzavVar != null) {
            return zzavVar;
        }
        zzo zza2 = zzq.zza();
        zza2.zza(9);
        zza2.zzb(application.getPackageName());
        zzq zzc = zza2.zzc();
        com.google.android.gms.games.internal.zzg zzb = com.google.android.gms.games.internal.zzg.zzb(application);
        zzbl zzblVar = new zzbl(application, zzb, com.google.android.gms.games.internal.p008v2.resolution.zzb.zza(), new zzbp(application, zzb, new zzaw(application, zzc), null), null);
        while (!UByte$$ExternalSyntheticBackport0.m850m(atomicReference, null, zzblVar) && atomicReference.get() == null) {
        }
        return (zzav) Preconditions.checkNotNull((zzav) zza.get());
    }
}
