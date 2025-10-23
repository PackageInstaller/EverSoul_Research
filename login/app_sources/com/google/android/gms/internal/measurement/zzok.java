package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzok implements Supplier<zzon> {
    private static zzok zza = new zzok();
    private final Supplier<zzon> zzb = Suppliers.ofInstance(new zzom());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzon get() {
        return this.zzb.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza() {
        return ((zzon) zza.get()).zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzb() {
        return ((zzon) zza.get()).zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzc() {
        return ((zzon) zza.get()).zzc();
    }
}
