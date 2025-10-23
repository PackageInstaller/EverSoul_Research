package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzgj implements Iterator<Map.Entry> {
    final /* synthetic */ zzgl zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzgj(zzgl zzglVar, zzge zzgeVar) {
        this.zza = zzglVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Iterator<Map.Entry> zza() {
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
        List list;
        Map map;
        int i = this.zzb + 1;
        list = this.zza.zzb;
        if (i < list.size()) {
            return true;
        }
        map = this.zza.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Map.Entry next() {
        List list;
        List list2;
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        list = this.zza.zzb;
        if (i >= list.size()) {
            return zza().next();
        }
        list2 = this.zza.zzb;
        return (Map.Entry) list2.get(this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        int i = this.zzb;
        list = this.zza.zzb;
        if (i >= list.size()) {
            zza().remove();
            return;
        }
        zzgl zzglVar = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 - 1;
        zzglVar.zzl(i2);
    }
}
