package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzqa implements Supplier<zzqd> {
    private static zzqa zza = new zzqa();
    private final Supplier<zzqd> zzb = Suppliers.ofInstance(new zzqc());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqd get() {
        return this.zzb.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza() {
        return ((zzqd) zza.get()).zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzb() {
        return ((zzqd) zza.get()).zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzc() {
        return ((zzqd) zza.get()).zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzd() {
        return ((zzqd) zza.get()).zzd();
    }
}
