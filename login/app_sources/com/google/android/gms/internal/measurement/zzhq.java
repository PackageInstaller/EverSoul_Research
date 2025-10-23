package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhq {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(byte[] bArr, int i, zzht zzhtVar) throws zzjq {
        int zzc = zzc(bArr, i, zzhtVar);
        int i2 = zzhtVar.zza;
        if (i2 < 0) {
            throw zzjq.zzf();
        }
        if (i2 > bArr.length - zzc) {
            throw zzjq.zzh();
        }
        if (i2 == 0) {
            zzhtVar.zzc = zzhu.zza;
            return zzc;
        }
        zzhtVar.zzc = zzhu.zza(bArr, zzc, i2);
        return zzc + i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(zzlj zzljVar, byte[] bArr, int i, int i2, int i3, zzht zzhtVar) throws IOException {
        Object zza = zzljVar.zza();
        int zza2 = zza(zza, zzljVar, bArr, i, i2, i3, zzhtVar);
        zzljVar.zzc(zza);
        zzhtVar.zzc = zza;
        return zza2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(zzlj zzljVar, byte[] bArr, int i, int i2, zzht zzhtVar) throws IOException {
        Object zza = zzljVar.zza();
        int zza2 = zza(zza, zzljVar, bArr, i, i2, zzhtVar);
        zzljVar.zzc(zza);
        zzhtVar.zzc = zza;
        return zza2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(zzlj<?> zzljVar, int i, byte[] bArr, int i2, int i3, zzjn<?> zzjnVar, zzht zzhtVar) throws IOException {
        int zza = zza(zzljVar, bArr, i2, i3, zzhtVar);
        zzjnVar.add(zzhtVar.zzc);
        while (zza < i3) {
            int zzc = zzc(bArr, zza, zzhtVar);
            if (i != zzhtVar.zza) {
                break;
            }
            zza = zza(zzljVar, bArr, zzc, i3, zzhtVar);
            zzjnVar.add(zzhtVar.zzc);
        }
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(byte[] bArr, int i, zzjn<?> zzjnVar, zzht zzhtVar) throws IOException {
        zzji zzjiVar = (zzji) zzjnVar;
        int zzc = zzc(bArr, i, zzhtVar);
        int i2 = zzhtVar.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzhtVar);
            zzjiVar.zzd(zzhtVar.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzjq.zzh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(byte[] bArr, int i, zzht zzhtVar) throws zzjq {
        int zzc = zzc(bArr, i, zzhtVar);
        int i2 = zzhtVar.zza;
        if (i2 < 0) {
            throw zzjq.zzf();
        }
        if (i2 == 0) {
            zzhtVar.zzc = "";
            return zzc;
        }
        zzhtVar.zzc = zzmp.zzb(bArr, zzc, i2);
        return zzc + i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, byte[] bArr, int i2, int i3, zzmh zzmhVar, zzht zzhtVar) throws zzjq {
        if ((i >>> 3) == 0) {
            throw zzjq.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzd = zzd(bArr, i2, zzhtVar);
            zzmhVar.zza(i, Long.valueOf(zzhtVar.zzb));
            return zzd;
        }
        if (i4 == 1) {
            zzmhVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzc = zzc(bArr, i2, zzhtVar);
            int i5 = zzhtVar.zza;
            if (i5 < 0) {
                throw zzjq.zzf();
            }
            if (i5 > bArr.length - zzc) {
                throw zzjq.zzh();
            }
            if (i5 == 0) {
                zzmhVar.zza(i, zzhu.zza);
            } else {
                zzmhVar.zza(i, zzhu.zza(bArr, zzc, i5));
            }
            return zzc + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzmhVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            }
            throw zzjq.zzc();
        }
        zzmh zzd2 = zzmh.zzd();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzc2 = zzc(bArr, i2, zzhtVar);
            int i8 = zzhtVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzc2;
                break;
            }
            int zza = zza(i7, bArr, zzc2, i3, zzd2, zzhtVar);
            i7 = i8;
            i2 = zza;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzjq.zzg();
        }
        zzmhVar.zza(i, zzd2);
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(byte[] bArr, int i, zzht zzhtVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzhtVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzhtVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, byte[] bArr, int i2, zzht zzhtVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzhtVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzhtVar.zza = i5 | (b2 << Ascii.f346SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzhtVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzhtVar.zza = i9 | (b4 << Ascii.f339FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzhtVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, byte[] bArr, int i2, int i3, zzjn<?> zzjnVar, zzht zzhtVar) {
        zzji zzjiVar = (zzji) zzjnVar;
        int zzc = zzc(bArr, i2, zzhtVar);
        zzjiVar.zzd(zzhtVar.zza);
        while (zzc < i3) {
            int zzc2 = zzc(bArr, zzc, zzhtVar);
            if (i != zzhtVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzhtVar);
            zzjiVar.zzd(zzhtVar.zza);
        }
        return zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(byte[] bArr, int i, zzht zzhtVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzhtVar.zzb = j;
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
        zzhtVar.zzb = j2;
        return i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(Object obj, zzlj zzljVar, byte[] bArr, int i, int i2, int i3, zzht zzhtVar) throws IOException {
        int zza = ((zzkv) zzljVar).zza((zzkv) obj, bArr, i, i2, i3, zzhtVar);
        zzhtVar.zzc = obj;
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(Object obj, zzlj zzljVar, byte[] bArr, int i, int i2, zzht zzhtVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zza(i4, bArr, i3, zzhtVar);
            i4 = zzhtVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzjq.zzh();
        }
        int i6 = i4 + i5;
        zzljVar.zza(obj, bArr, i5, i6, zzhtVar);
        zzhtVar.zzc = obj;
        return i6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, byte[] bArr, int i2, int i3, zzht zzhtVar) throws zzjq {
        if ((i >>> 3) == 0) {
            throw zzjq.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzhtVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzhtVar) + zzhtVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzjq.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzhtVar);
            i6 = zzhtVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzhtVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzjq.zzg();
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long zzd(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
