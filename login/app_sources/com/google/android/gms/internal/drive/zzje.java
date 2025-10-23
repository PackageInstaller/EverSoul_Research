package com.google.android.gms.internal.drive;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class zzje implements Comparator<zzjc> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzje() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzjc zzjcVar, zzjc zzjcVar2) {
        int zza;
        int zza2;
        zzjc zzjcVar3 = zzjcVar;
        zzjc zzjcVar4 = zzjcVar2;
        zzjj zzjjVar = (zzjj) zzjcVar3.iterator();
        zzjj zzjjVar2 = (zzjj) zzjcVar4.iterator();
        while (zzjjVar.hasNext() && zzjjVar2.hasNext()) {
            zza = zzjc.zza(zzjjVar.nextByte());
            zza2 = zzjc.zza(zzjjVar2.nextByte());
            int compare = Integer.compare(zza, zza2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzjcVar3.size(), zzjcVar4.size());
    }
}
