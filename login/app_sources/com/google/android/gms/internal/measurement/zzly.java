package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzly<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<K, V>> zzc;
    private final /* synthetic */ zzlo zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        list = this.zzd.zzb;
        if (i >= list.size()) {
            return zza().next();
        }
        list2 = this.zzd.zzb;
        return (Map.Entry) list2.get(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.zzc == null) {
            map = this.zzd.zzc;
            this.zzc = map.entrySet().iterator();
        }
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzly(zzlo zzloVar) {
        this.zzd = zzloVar;
        this.zza = -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzg();
        int i = this.zza;
        list = this.zzd.zzb;
        if (i < list.size()) {
            zzlo zzloVar = this.zzd;
            int i2 = this.zza;
            this.zza = i2 - 1;
            zzloVar.zzc(i2);
            return;
        }
        zza().remove();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.zza + 1;
        list = this.zzd.zzb;
        if (i >= list.size()) {
            map = this.zzd.zzc;
            if (map.isEmpty() || !zza().hasNext()) {
                return false;
            }
        }
        return true;
    }
}
