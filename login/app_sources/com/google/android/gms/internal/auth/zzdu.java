package com.google.android.gms.internal.auth;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzdu implements Comparator<zzeb> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdu() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzeb zzebVar, zzeb zzebVar2) {
        zzeb zzebVar3 = zzebVar;
        zzeb zzebVar4 = zzebVar2;
        zzds zzdsVar = new zzds(zzebVar3);
        zzds zzdsVar2 = new zzds(zzebVar4);
        while (zzdsVar.hasNext() && zzdsVar2.hasNext()) {
            int zza = zzdt.zza(zzdsVar.zza() & 255, zzdsVar2.zza() & 255);
            if (zza != 0) {
                return zza;
            }
        }
        return zzdt.zza(zzebVar3.zzd(), zzebVar4.zzd());
    }
}
