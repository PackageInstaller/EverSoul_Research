package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmr {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zza(byte b) {
        return b > -65;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (zza(b2) || (((b << Ascii.f339FS) + (b2 + 112)) >> 30) != 0 || zza(b3) || zza(b4)) {
            throw zzjq.zzd();
        }
        int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (zza(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || zza(b3)))) {
            throw zzjq.zzd();
        }
        cArr[i] = (char) (((b & Ascii.f345SI) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zza(b2)) {
            throw zzjq.zzd();
        }
        cArr[i] = (char) (((b & Ascii.f348US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }
}
