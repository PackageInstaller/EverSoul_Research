package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
class zzdz extends zzdy {
    protected final byte[] zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdz(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeb) || zzd() != ((zzeb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzdz)) {
            return obj.equals(this);
        }
        zzdz zzdzVar = (zzdz) obj;
        int zzj = zzj();
        int zzj2 = zzdzVar.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzdzVar.zzd()) {
            int zzd2 = zzd();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(zzd);
            sb.append(zzd2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (zzd > zzdzVar.zzd()) {
            int zzd3 = zzdzVar.zzd();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(zzd);
            sb2.append(", ");
            sb2.append(zzd3);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzdzVar instanceof zzdz)) {
            return zzdzVar.zzf(0, zzd).equals(zzf(0, zzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzdzVar.zza;
        zzdzVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < zzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    byte zzb(int i) {
        return this.zza[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int zzc() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    public int zzd() {
        return this.zza.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    protected final int zze(int i, int i2, int i3) {
        return zzev.zzd(i, this.zza, 0, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    public final zzeb zzf(int i, int i2) {
        int zzi = zzi(0, i2, zzd());
        return zzi == 0 ? zzeb.zzb : new zzdw(this.zza, 0, zzi);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeb
    public final boolean zzh() {
        return zzhd.zzd(this.zza, 0, zzd());
    }
}
