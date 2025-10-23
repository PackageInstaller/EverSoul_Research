package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfd extends zzfe {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfd() {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzfd(zzfb zzfbVar) {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfe
    final void zza(Object obj, long j) {
        ((zzeu) zzgz.zzf(obj, j)).zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfe
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzeu zzeuVar = (zzeu) zzgz.zzf(obj, j);
        zzeu zzeuVar2 = (zzeu) zzgz.zzf(obj2, j);
        int size = zzeuVar.size();
        int size2 = zzeuVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzeuVar.zzc()) {
                zzeuVar = zzeuVar.zzd(size2 + size);
            }
            zzeuVar.addAll(zzeuVar2);
        }
        if (size > 0) {
            zzeuVar2 = zzeuVar;
        }
        zzgz.zzp(obj, j, zzeuVar2);
    }
}
