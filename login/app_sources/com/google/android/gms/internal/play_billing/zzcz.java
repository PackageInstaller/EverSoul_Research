package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzcz extends zzdw {
    private final Object zza;
    private boolean zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcz(Object obj) {
        this.zza = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final Object next() {
        if (this.zzb) {
            throw new NoSuchElementException();
        }
        this.zzb = true;
        return this.zza;
    }
}
