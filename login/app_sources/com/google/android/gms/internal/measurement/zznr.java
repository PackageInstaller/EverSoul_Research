package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zznr implements Supplier<zznq> {
    private static zznr zza = new zznr();
    private final Supplier<zznq> zzb = Suppliers.ofInstance(new zznt());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznq get() {
        return this.zzb.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza() {
        return ((zznq) zza.get()).zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzb() {
        return ((zznq) zza.get()).zzb();
    }
}
