package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlh implements zzkp {
    private final zzkr zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkp
    public final zzkr zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkp
    public final zzlg zzb() {
        int i = this.zzd;
        return (i & 1) != 0 ? zzlg.PROTO2 : (i & 4) == 4 ? zzlg.EDITIONS : zzlg.PROTO3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzd() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlh(zzkr zzkrVar, String str, Object[] objArr) {
        this.zza = zzkrVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.zzd = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkp
    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Object[] zze() {
        return this.zzc;
    }
}
