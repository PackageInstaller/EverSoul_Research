package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zznl implements Supplier<zznk> {
    private static zznl zza = new zznl();
    private final Supplier<zznk> zzb = Suppliers.ofInstance(new zznn());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zza() {
        return ((zznk) zza.get()).zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznk get() {
        return this.zzb.get();
    }
}
