package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes2.dex */
final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzt(zzu zzuVar, zzx zzxVar, CharSequence charSequence) {
        super(zzxVar, charSequence);
        this.zza = zzuVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.common.zzw
    final int zzc(int i) {
        return i + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.common.zzw
    final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzs.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            zzu zzuVar = this.zza;
            if (zzuVar.zza.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
