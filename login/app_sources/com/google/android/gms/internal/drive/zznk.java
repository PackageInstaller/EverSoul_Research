package com.google.android.gms.internal.drive;

import com.kakaogame.addon.AddOnManager;

/* loaded from: classes2.dex */
final class zznk extends zznh {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zznk() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0065, code lost:
    
        return -1;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zznh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzb(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zznk.zzb(int, byte[], int, int):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zznh
    final String zzg(byte[] bArr, int i, int i2) throws zzkq {
        boolean zzd;
        boolean zzd2;
        boolean zze;
        boolean zzf;
        boolean zzd3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte zza = zznd.zza(bArr, i);
            zzd3 = zzng.zzd(zza);
            if (!zzd3) {
                break;
            }
            i++;
            zzng.zza(zza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte zza2 = zznd.zza(bArr, i);
            zzd = zzng.zzd(zza2);
            if (zzd) {
                int i7 = i5 + 1;
                zzng.zza(zza2, cArr, i5);
                while (i6 < i3) {
                    byte zza3 = zznd.zza(bArr, i6);
                    zzd2 = zzng.zzd(zza3);
                    if (!zzd2) {
                        break;
                    }
                    i6++;
                    zzng.zza(zza3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                zze = zzng.zze(zza2);
                if (!zze) {
                    zzf = zzng.zzf(zza2);
                    if (zzf) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            zzng.zza(zza2, zznd.zza(bArr, i6), zznd.zza(bArr, i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw zzkq.zzdn();
                        }
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzkq.zzdn();
                        }
                        int i9 = i6 + 1;
                        byte zza4 = zznd.zza(bArr, i6);
                        int i10 = i9 + 1;
                        zzng.zza(zza2, zza4, zznd.zza(bArr, i9), zznd.zza(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else if (i6 < i3) {
                    zzng.zza(zza2, zznd.zza(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzkq.zzdn();
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zznh
    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        char c2;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(i + i2).toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zznd.zza(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < c && j4 < j5) {
                long j6 = j4 + j;
                zznd.zza(bArr, j4, (byte) charAt2);
                j3 = j;
                j2 = j6;
                c2 = c;
            } else if (charAt2 < 2048 && j4 <= j5 - 2) {
                long j7 = j4 + j;
                zznd.zza(bArr, j4, (byte) ((charAt2 >>> 6) | 960));
                long j8 = j7 + j;
                zznd.zza(bArr, j7, (byte) ((charAt2 & '?') | 128));
                long j9 = j;
                c2 = 128;
                j2 = j8;
                j3 = j9;
            } else {
                if ((charAt2 >= 55296 && 57343 >= charAt2) || j4 > j5 - 3) {
                    if (j4 <= j5 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j10 = j4 + 1;
                                zznd.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j11 = j10 + 1;
                                c2 = 128;
                                zznd.zza(bArr, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j12 = j11 + 1;
                                zznd.zza(bArr, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j12 + 1;
                                zznd.zza(bArr, j12, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zznj(i4 - 1, length);
                    }
                    if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                        throw new zznj(i4, length);
                    }
                    throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(charAt2).append(" at index ").append(j4).toString());
                }
                long j13 = j4 + j;
                zznd.zza(bArr, j4, (byte) ((charAt2 >>> '\f') | AddOnManager.StoreResultCode.INVALID_TRANSACTION_ID));
                long j14 = j13 + j;
                zznd.zza(bArr, j13, (byte) (((charAt2 >>> 6) & 63) | 128));
                zznd.zza(bArr, j14, (byte) ((charAt2 & '?') | 128));
                j2 = j14 + 1;
                j3 = 1;
                c2 = 128;
            }
            i4++;
            c = c2;
            long j15 = j3;
            j4 = j2;
            j = j15;
        }
        return (int) j4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzay;
        int zzr;
        int zzc;
        if (i2 == 0) {
            zzay = zznf.zzay(i);
            return zzay;
        }
        if (i2 == 1) {
            zzr = zznf.zzr(i, zznd.zza(bArr, j));
            return zzr;
        }
        if (i2 == 2) {
            zzc = zznf.zzc(i, zznd.zza(bArr, j), zznd.zza(bArr, j + 1));
            return zzc;
        }
        throw new AssertionError();
    }
}
