package com.google.android.gms.internal.games_v2;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzbr {
    private static final AtomicReference zza = new AtomicReference();
    private final Application zzb;
    private final zzau zzc;
    private final com.google.android.gms.games.internal.zzg zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzbr(Application application, zzau zzauVar, com.google.android.gms.games.internal.zzg zzgVar) {
        this.zzb = application;
        this.zzc = zzauVar;
        this.zzd = zzgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Application zza() {
        zzb();
        return ((zzbr) zza.get()).zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb() {
        Preconditions.checkState(zza.get() != null, "PlayGamesSdk has not been initialized. Ensure that PlayGamesSdk.initialize() has been called.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(Context context) {
        Preconditions.checkArgument(context != null);
        AtomicReference atomicReference = zza;
        if (((zzbr) atomicReference.get()) == null) {
            Context applicationContext = context.getApplicationContext();
            Application application = applicationContext != null ? (Application) applicationContext : (Application) context;
            zzbr zzbrVar = new zzbr(application, zzau.zza(application), com.google.android.gms.games.internal.zzg.zzb(application));
            while (!UByte$$ExternalSyntheticBackport0.m850m(atomicReference, null, zzbrVar)) {
                if (atomicReference.get() != null) {
                    return;
                }
            }
            zzbrVar.zzc.zzc();
            zzbrVar.zzd.zzh();
        }
    }
}
