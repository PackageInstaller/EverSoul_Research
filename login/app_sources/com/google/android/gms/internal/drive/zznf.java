package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zznf {
    private static final zznh zzwt;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzay(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzc(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzd(byte[] bArr) {
        return zzwt.zze(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzr(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zze(byte[] bArr, int i, int i2) {
        return zzwt.zze(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzf(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return zzay(b);
        }
        if (i3 == 1) {
            return zzr(b, bArr[i]);
        }
        if (i3 == 2) {
            return zzc(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zznj(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(i3 + 4294967296L).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzwt.zzb(charSequence, bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zzg(byte[] bArr, int i, int i2) throws zzkq {
        return zzwt.zzg(bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zznh zzniVar;
        if ((zznd.zzfd() && zznd.zzfe()) && !zzix.zzbr()) {
            zzniVar = new zznk();
        } else {
            zzniVar = new zzni();
        }
        zzwt = zzniVar;
    }
}
