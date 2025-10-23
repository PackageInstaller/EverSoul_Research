package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhx extends zzhz {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzhu zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzia
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhx(zzhu zzhuVar) {
        this.zzc = zzhuVar;
        this.zzb = zzhuVar.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}
