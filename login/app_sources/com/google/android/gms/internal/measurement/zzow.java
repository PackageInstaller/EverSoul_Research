package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzow implements Supplier<zzoz> {
    private static zzow zza = new zzow();
    private final Supplier<zzoz> zzb = Suppliers.ofInstance(new zzoy());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoz get() {
        return this.zzb.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza() {
        return ((zzoz) zza.get()).zza();
    }
}
