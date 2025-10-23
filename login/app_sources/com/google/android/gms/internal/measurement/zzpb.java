package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzpb implements Supplier<zzpa> {
    private static zzpb zza = new zzpb();
    private final Supplier<zzpa> zzb = Suppliers.ofInstance(new zzpd());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double zza() {
        return ((zzpa) zza.get()).zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zzb() {
        return ((zzpa) zza.get()).zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zzc() {
        return ((zzpa) zza.get()).zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpa get() {
        return this.zzb.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zzd() {
        return ((zzpa) zza.get()).zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zze() {
        return ((zzpa) zza.get()).zze();
    }
}
