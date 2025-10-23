package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzii extends zzij {
    private final byte[] zzd;
    private final boolean zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte zzv() throws IOException {
        int i = this.zzh;
        if (i == this.zzf) {
            throw zzjq.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzh = i + 1;
        return bArr[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzc() {
        return this.zzh - this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zza(int i) throws zzjq {
        if (i < 0) {
            throw zzjq.zzf();
        }
        int zzc = i + zzc();
        if (zzc < 0) {
            throw zzjq.zzg();
        }
        int i2 = this.zzk;
        if (zzc > i2) {
            throw zzjq.zzh();
        }
        this.zzk = zzc;
        zzaa();
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzd() throws IOException {
        return zzx();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zze() throws IOException {
        return zzw();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzf() throws IOException {
        return zzx();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzw() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw zzjq.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzh = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzx() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 == r0) goto L6b
            byte[] r2 = r5.zzd
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.zzh = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.zzh = r1
            return r0
        L6b:
            long r0 = r5.zzm()
            int r0 = (int) r0
            return r0
            fill-array 0x0072: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzii.zzx():int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzg() throws IOException {
        return zzw();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzh() throws IOException {
        return zze(zzx());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzj = 0;
            return 0;
        }
        int zzx = zzx();
        this.zzj = zzx;
        if ((zzx >>> 3) != 0) {
            return zzx;
        }
        throw zzjq.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final int zzj() throws IOException {
        return zzx();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final long zzk() throws IOException {
        return zzy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final long zzl() throws IOException {
        return zzz();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long zzy() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw zzjq.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzh = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L40;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzz() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzii.zzz():long");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzv() & 128) == 0) {
                return j;
            }
        }
        throw zzjq.zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final long zzn() throws IOException {
        return zzy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final long zzo() throws IOException {
        return zza(zzz());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final long zzp() throws IOException {
        return zzz();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final zzhu zzq() throws IOException {
        byte[] bArr;
        int zzx = zzx();
        if (zzx > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzx <= i - i2) {
                zzhu zza = zzhu.zza(this.zzd, i2, zzx);
                this.zzh += zzx;
                return zza;
            }
        }
        if (zzx == 0) {
            return zzhu.zza;
        }
        if (zzx > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (zzx <= i3 - i4) {
                int i5 = zzx + i4;
                this.zzh = i5;
                bArr = Arrays.copyOfRange(this.zzd, i4, i5);
                return zzhu.zza(bArr);
            }
        }
        if (zzx > 0) {
            throw zzjq.zzh();
        }
        if (zzx == 0) {
            bArr = zzjh.zzb;
            return zzhu.zza(bArr);
        }
        throw zzjq.zzf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final String zzr() throws IOException {
        int zzx = zzx();
        if (zzx > 0 && zzx <= this.zzf - this.zzh) {
            String str = new String(this.zzd, this.zzh, zzx, zzjh.zza);
            this.zzh += zzx;
            return str;
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx < 0) {
            throw zzjq.zzf();
        }
        throw zzjq.zzh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final String zzs() throws IOException {
        int zzx = zzx();
        if (zzx > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzx <= i - i2) {
                String zzb = zzmp.zzb(this.zzd, i2, zzx);
                this.zzh += zzx;
                return zzb;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx <= 0) {
            throw zzjq.zzf();
        }
        throw zzjq.zzh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzii(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzk = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
        this.zze = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final void zzb(int i) throws zzjq {
        if (this.zzj != i) {
            throw zzjq.zzb();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final void zzc(int i) {
        this.zzk = i;
        zzaa();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaa() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzjq.zzf();
        }
        throw zzjq.zzh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final boolean zzt() throws IOException {
        return this.zzh == this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final boolean zzu() throws IOException {
        return zzz() != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzij
    public final boolean zzd(int i) throws IOException {
        int zzi;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzjq.zze();
            }
            while (i3 < 10) {
                if (zzv() < 0) {
                    i3++;
                }
            }
            throw zzjq.zze();
            return true;
        }
        if (i2 == 1) {
            zzf(8);
            return true;
        }
        if (i2 == 2) {
            zzf(zzx());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzf(4);
                return true;
            }
            throw zzjq.zza();
        }
        do {
            zzi = zzi();
            if (zzi == 0) {
                break;
            }
        } while (zzd(zzi));
        zzb(((i >>> 3) << 3) | 4);
        return true;
    }
}
