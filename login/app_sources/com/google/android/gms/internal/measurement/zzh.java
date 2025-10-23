package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzh {
    private final zzh zza;
    private zzbb zzb;
    private Map<String, zzaq> zzc = new HashMap();
    private Map<String, Boolean> zzd = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzh zza() {
        return new zzh(this, this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza(zzaq zzaqVar) {
        return this.zzb.zza(this, zzaqVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza(zzaf zzafVar) {
        zzaq zzaqVar = zzaq.zzc;
        Iterator<Integer> zzg = zzafVar.zzg();
        while (zzg.hasNext()) {
            zzaqVar = this.zzb.zza(this, zzafVar.zza(zzg.next().intValue()));
            if (zzaqVar instanceof zzaj) {
                break;
            }
        }
        return zzaqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza(String str) {
        zzh zzhVar = this;
        while (!zzhVar.zzc.containsKey(str)) {
            zzhVar = zzhVar.zza;
            if (zzhVar == null) {
                throw new IllegalArgumentException(String.format("%s is not defined", str));
            }
        }
        return zzhVar.zzc.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzh(zzh zzhVar, zzbb zzbbVar) {
        this.zza = zzhVar;
        this.zzb = zzbbVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, zzaq zzaqVar) {
        if (this.zzd.containsKey(str)) {
            return;
        }
        if (zzaqVar == null) {
            this.zzc.remove(str);
        } else {
            this.zzc.put(str, zzaqVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(String str, zzaq zzaqVar) {
        zza(str, zzaqVar);
        this.zzd.put(str, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(String str, zzaq zzaqVar) {
        zzh zzhVar;
        zzh zzhVar2 = this;
        while (!zzhVar2.zzc.containsKey(str) && (zzhVar = zzhVar2.zza) != null && zzhVar.zzb(str)) {
            zzhVar2 = zzhVar2.zza;
        }
        if (zzhVar2.zzd.containsKey(str)) {
            return;
        }
        if (zzaqVar == null) {
            zzhVar2.zzc.remove(str);
        } else {
            zzhVar2.zzc.put(str, zzaqVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzb(String str) {
        zzh zzhVar = this;
        while (!zzhVar.zzc.containsKey(str)) {
            zzhVar = zzhVar.zza;
            if (zzhVar == null) {
                return false;
            }
        }
        return true;
    }
}
