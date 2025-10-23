package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzjc implements Iterator {
    final /* synthetic */ zzjf zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzjc(zzjf zzjfVar, zzje zzjeVar) {
        this.zza = zzjfVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        Map map;
        int i2 = this.zzb + 1;
        zzjf zzjfVar = this.zza;
        i = zzjfVar.zzb;
        if (i2 < i) {
            return true;
        }
        map = zzjfVar.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i;
        Object[] objArr;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzjf zzjfVar = this.zza;
        i = zzjfVar.zzb;
        if (i2 >= i) {
            return (Map.Entry) zza().next();
        }
        objArr = zzjfVar.zza;
        return (zzjb) objArr[i2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        int i;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i2 = this.zzb;
        zzjf zzjfVar = this.zza;
        i = zzjfVar.zzb;
        if (i2 >= i) {
            zza().remove();
        } else {
            this.zzb = i2 - 1;
            zzjfVar.zzm(i2);
        }
    }
}
