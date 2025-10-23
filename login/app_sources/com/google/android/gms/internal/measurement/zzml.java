package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzml implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzmj zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzml(zzmj zzmjVar) {
        zzjx zzjxVar;
        this.zzb = zzmjVar;
        zzjxVar = zzmjVar.zza;
        this.zza = zzjxVar.iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
