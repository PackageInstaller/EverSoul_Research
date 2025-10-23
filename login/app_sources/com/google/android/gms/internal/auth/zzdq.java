package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzdq {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(byte[] bArr, int i, zzdp zzdpVar) throws zzew {
        int zzj = zzj(bArr, i, zzdpVar);
        int i2 = zzdpVar.zza;
        if (i2 < 0) {
            throw zzew.zzc();
        }
        if (i2 > bArr.length - zzj) {
            throw zzew.zzf();
        }
        if (i2 == 0) {
            zzdpVar.zzc = zzeb.zzb;
            return zzj;
        }
        zzdpVar.zzc = zzeb.zzk(bArr, zzj, i2);
        return zzj + i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(zzgb zzgbVar, byte[] bArr, int i, int i2, int i3, zzdp zzdpVar) throws IOException {
        zzft zzftVar = (zzft) zzgbVar;
        Object zzd = zzftVar.zzd();
        int zzb = zzftVar.zzb(zzd, bArr, i, i2, i3, zzdpVar);
        zzftVar.zze(zzd);
        zzdpVar.zzc = zzd;
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(zzgb zzgbVar, byte[] bArr, int i, int i2, zzdp zzdpVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zzdpVar);
            i4 = zzdpVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzew.zzf();
        }
        Object zzd = zzgbVar.zzd();
        int i6 = i4 + i5;
        zzgbVar.zzg(zzd, bArr, i5, i6, zzdpVar);
        zzgbVar.zze(zzd);
        zzdpVar.zzc = zzd;
        return i6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zze(zzgb<?> zzgbVar, int i, byte[] bArr, int i2, int i3, zzeu<?> zzeuVar, zzdp zzdpVar) throws IOException {
        int zzd = zzd(zzgbVar, bArr, i2, i3, zzdpVar);
        zzeuVar.add(zzdpVar.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzdpVar);
            if (i != zzdpVar.zza) {
                break;
            }
            zzd = zzd(zzgbVar, bArr, zzj, i3, zzdpVar);
            zzeuVar.add(zzdpVar.zzc);
        }
        return zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzf(byte[] bArr, int i, zzeu<?> zzeuVar, zzdp zzdpVar) throws IOException {
        zzer zzerVar = (zzer) zzeuVar;
        int zzj = zzj(bArr, i, zzdpVar);
        int i2 = zzdpVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzdpVar);
            zzerVar.zze(zzdpVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzew.zzf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzg(byte[] bArr, int i, zzdp zzdpVar) throws zzew {
        int zzj = zzj(bArr, i, zzdpVar);
        int i2 = zzdpVar.zza;
        if (i2 < 0) {
            throw zzew.zzc();
        }
        if (i2 == 0) {
            zzdpVar.zzc = "";
            return zzj;
        }
        zzdpVar.zzc = new String(bArr, zzj, i2, zzev.zza);
        return zzj + i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzh(byte[] bArr, int i, zzdp zzdpVar) throws zzew {
        int zzj = zzj(bArr, i, zzdpVar);
        int i2 = zzdpVar.zza;
        if (i2 < 0) {
            throw zzew.zzc();
        }
        if (i2 == 0) {
            zzdpVar.zzc = "";
            return zzj;
        }
        zzdpVar.zzc = zzhd.zzb(bArr, zzj, i2);
        return zzj + i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzi(int i, byte[] bArr, int i2, int i3, zzgq zzgqVar, zzdp zzdpVar) throws zzew {
        if ((i >>> 3) == 0) {
            throw zzew.zza();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzm = zzm(bArr, i2, zzdpVar);
            zzgqVar.zzf(i, Long.valueOf(zzdpVar.zzb));
            return zzm;
        }
        if (i4 == 1) {
            zzgqVar.zzf(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzj = zzj(bArr, i2, zzdpVar);
            int i5 = zzdpVar.zza;
            if (i5 < 0) {
                throw zzew.zzc();
            }
            if (i5 > bArr.length - zzj) {
                throw zzew.zzf();
            }
            if (i5 == 0) {
                zzgqVar.zzf(i, zzeb.zzb);
            } else {
                zzgqVar.zzf(i, zzeb.zzk(bArr, zzj, i5));
            }
            return zzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzew.zza();
            }
            zzgqVar.zzf(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzgq zzc = zzgq.zzc();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzj2 = zzj(bArr, i2, zzdpVar);
            int i8 = zzdpVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = zzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, zzj2, i3, zzc, zzdpVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzew.zzd();
        }
        zzgqVar.zzf(i, zzc);
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzj(byte[] bArr, int i, zzdp zzdpVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzdpVar);
        }
        zzdpVar.zza = b;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzk(int i, byte[] bArr, int i2, zzdp zzdpVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdpVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdpVar.zza = i5 | (b2 << Ascii.f346SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdpVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdpVar.zza = i9 | (b4 << Ascii.f339FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdpVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzl(int i, byte[] bArr, int i2, int i3, zzeu<?> zzeuVar, zzdp zzdpVar) {
        zzer zzerVar = (zzer) zzeuVar;
        int zzj = zzj(bArr, i2, zzdpVar);
        zzerVar.zze(zzdpVar.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzdpVar);
            if (i != zzdpVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzdpVar);
            zzerVar.zze(zzdpVar.zza);
        }
        return zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzm(byte[] bArr, int i, zzdp zzdpVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdpVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzdpVar.zzb = j2;
        return i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long zzn(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
