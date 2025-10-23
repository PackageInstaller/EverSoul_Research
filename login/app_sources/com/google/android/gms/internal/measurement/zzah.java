package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzah implements Iterator<zzaq> {
    private int zza = 0;
    private final /* synthetic */ zzaf zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        if (this.zza >= this.zzb.zzb()) {
            throw new NoSuchElementException("Out of bounds index: " + this.zza);
        }
        zzaf zzafVar = this.zzb;
        int i = this.zza;
        this.zza = i + 1;
        return zzafVar.zza(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzah(zzaf zzafVar) {
        this.zzb = zzafVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb.zzb();
    }
}
