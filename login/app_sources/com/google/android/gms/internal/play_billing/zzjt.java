package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzjt {
    public static final /* synthetic */ int zza = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        if (zzjq.zzx() && zzjq.zzy()) {
            int i = zzfy.zza;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte b = bArr[i - 1];
        if (i3 == 0) {
            if (b <= -12) {
                return b;
            }
            return -1;
        }
        if (i3 == 1) {
            byte b2 = bArr[i];
            if (b > -12 || b2 > -65) {
                return -1;
            }
            return (b2 << 8) ^ b;
        }
        if (i3 != 2) {
            throw new AssertionError();
        }
        byte b3 = bArr[i];
        byte b4 = bArr[i + 1];
        if (b > -12 || b3 > -65 || b4 > -65) {
            return -1;
        }
        return (b4 << Ascii.DLE) ^ ((b3 << 8) ^ b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00fe, code lost:
    
        return r10 + r0;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int zzb(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzjt.zzb(java.lang.String, byte[], int, int):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = str.length();
                while (i2 < length2) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) < 65536) {
                                throw new zzjs(i2, length2);
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i3 + 4294967296L));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean zzd(byte[] r5, int r6, int r7) {
        /*
        L0:
            if (r6 >= r7) goto L9
            r0 = r5[r6]
            if (r0 < 0) goto L9
            int r6 = r6 + 1
            goto L0
        L9:
            if (r6 < r7) goto Ld
            goto L7a
        Ld:
            if (r6 >= r7) goto L7a
            int r0 = r6 + 1
            r6 = r5[r6]
            if (r6 >= 0) goto L78
            r1 = -32
            r2 = -65
            if (r6 >= r1) goto L29
            if (r0 < r7) goto L1e
            goto L57
        L1e:
            r1 = -62
            if (r6 < r1) goto L76
            int r6 = r0 + 1
            r0 = r5[r0]
            if (r0 <= r2) goto Ld
            goto L76
        L29:
            r3 = -16
            if (r6 >= r3) goto L4f
            int r3 = r7 + (-1)
            if (r0 < r3) goto L36
            int r6 = zza(r5, r0, r7)
            goto L57
        L36:
            int r3 = r0 + 1
            r0 = r5[r0]
            if (r0 > r2) goto L76
            r4 = -96
            if (r6 != r1) goto L42
            if (r0 < r4) goto L76
        L42:
            r1 = -19
            if (r6 != r1) goto L48
            if (r0 >= r4) goto L76
        L48:
            int r6 = r3 + 1
            r0 = r5[r3]
            if (r0 <= r2) goto Ld
            goto L76
        L4f:
            int r1 = r7 + (-2)
            if (r0 < r1) goto L5a
            int r6 = zza(r5, r0, r7)
        L57:
            if (r6 == 0) goto L7a
            goto L76
        L5a:
            int r1 = r0 + 1
            r0 = r5[r0]
            if (r0 > r2) goto L76
            int r6 = r6 << 28
            int r0 = r0 + 112
            int r6 = r6 + r0
            int r6 = r6 >> 30
            if (r6 != 0) goto L76
            int r6 = r1 + 1
            r0 = r5[r1]
            if (r0 > r2) goto L76
            int r0 = r6 + 1
            r6 = r5[r6]
            if (r6 > r2) goto L76
            goto L78
        L76:
            r5 = 0
            return r5
        L78:
            r6 = r0
            goto Ld
        L7a:
            r5 = 1
            return r5
            fill-array 0x007c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzjt.zzd(byte[], int, int):boolean");
    }
}
