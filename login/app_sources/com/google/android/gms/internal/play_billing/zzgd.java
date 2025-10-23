package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzgd extends zzge {
    final /* synthetic */ zzgk zza;
    private int zzb = 0;
    private final int zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgd(zzgk zzgkVar) {
        this.zza = zzgkVar;
        this.zzc = zzgkVar.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzgg
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
