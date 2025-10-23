package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzmh {
    private static final zzmh zza = new zzmh(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        int zzg;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zzg = zzio.zzg(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                zzg = zzio.zzc(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                zzg = zzio.zzc(i5, (zzhu) this.zzd[i3]);
            } else if (i6 == 3) {
                zzg = (zzio.zzi(i5) << 1) + ((zzmh) this.zzd[i3]).zza();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzjq.zza());
                }
                zzg = zzio.zzf(i5, ((Integer) this.zzd[i3]).intValue());
            }
            i2 += zzg;
        }
        this.zze = i2;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzio.zzd(this.zzc[i3] >>> 3, (zzhu) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzmh zzc() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzmh zza(zzmh zzmhVar) {
        if (zzmhVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzmhVar.zzb;
        zza(i);
        System.arraycopy(zzmhVar.zzc, 0, this.zzc, this.zzb, zzmhVar.zzb);
        System.arraycopy(zzmhVar.zzd, 0, this.zzd, this.zzb, zzmhVar.zzb);
        this.zzb = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzmh zza(zzmh zzmhVar, zzmh zzmhVar2) {
        int i = zzmhVar.zzb + zzmhVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmhVar.zzc, i);
        System.arraycopy(zzmhVar2.zzc, 0, copyOf, zzmhVar.zzb, zzmhVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmhVar.zzd, i);
        System.arraycopy(zzmhVar2.zzd, 0, copyOf2, zzmhVar.zzb, zzmhVar2.zzb);
        return new zzmh(i, copyOf, copyOf2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzmh zzd() {
        return new zzmh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzmh() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzmh(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzkw.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(zzne zzneVar) throws IOException {
        if (zzneVar.zza() == zznh.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzneVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzneVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(int i, Object obj, zzne zzneVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzneVar.zzb(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzneVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzneVar.zza(i2, (zzhu) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzneVar.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzjq.zza());
        }
        if (zzneVar.zza() == zznh.zza) {
            zzneVar.zzb(i2);
            ((zzmh) obj).zzb(zzneVar);
            zzneVar.zza(i2);
        } else {
            zzneVar.zza(i2);
            ((zzmh) obj).zzb(zzneVar);
            zzneVar.zzb(i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(zzne zzneVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzneVar.zza() == zznh.zza) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzneVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzneVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmh)) {
            return false;
        }
        zzmh zzmhVar = (zzmh) obj;
        int i = this.zzb;
        if (i == zzmhVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmhVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzmhVar.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }
}
