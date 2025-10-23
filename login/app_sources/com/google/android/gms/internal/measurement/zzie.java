package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
class zzie extends zzif {
    protected final byte[] zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int zze() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    byte zzb(int i) {
        return this.zzb[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    protected final int zzb(int i, int i2, int i3) {
        return zzjh.zza(i, this.zzb, zze(), i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public int zzb() {
        return this.zzb.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public final zzhu zza(int i, int i2) {
        int zza = zza(0, i2, zzb());
        if (zza == 0) {
            return zzhu.zza;
        }
        return new zzhy(this.zzb, zze(), zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zzb(), charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzie(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    final void zza(zzhv zzhvVar) throws IOException {
        zzhvVar.zza(this.zzb, zze(), zzb());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhu) || zzb() != ((zzhu) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (obj instanceof zzie) {
            zzie zzieVar = (zzie) obj;
            int zza = zza();
            int zza2 = zzieVar.zza();
            if (zza == 0 || zza2 == 0 || zza == zza2) {
                return zza(zzieVar, 0, zzb());
            }
            return false;
        }
        return obj.equals(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzif
    final boolean zza(zzhu zzhuVar, int i, int i2) {
        if (i2 > zzhuVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        }
        if (i2 > zzhuVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzhuVar.zzb());
        }
        if (zzhuVar instanceof zzie) {
            zzie zzieVar = (zzie) zzhuVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzieVar.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzieVar.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
        return zzhuVar.zza(0, i2).equals(zza(0, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhu
    public final boolean zzd() {
        int zze = zze();
        return zzmp.zzc(this.zzb, zze, zzb() + zze);
    }
}
