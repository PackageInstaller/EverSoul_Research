package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgs implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzgn zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgs(zzgn zzgnVar) {
        this.zza = zzgnVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) {
        int i = zzgu.zza[zzsVar.ordinal()];
        zzfr zzn = i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.zza.zzj().zzn() : this.zza.zzj().zzp() : z ? this.zza.zzj().zzw() : !z2 ? this.zza.zzj().zzv() : this.zza.zzj().zzu() : z ? this.zza.zzj().zzm() : !z2 ? this.zza.zzj().zzh() : this.zza.zzj().zzg() : this.zza.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzn.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzn.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzn.zza(str);
        } else {
            zzn.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
