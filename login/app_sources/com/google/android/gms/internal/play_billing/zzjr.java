package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzjr {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (zze(b2) || (((b << Ascii.f339FS) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw new zzhr("Protocol message had invalid UTF-8.");
        }
        int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zze(b2)) {
            throw new zzhr("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & Ascii.f348US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zze(byte b) {
        return b > -65;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ void zzb(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                cArr[i] = (char) (((b & Ascii.f345SI) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw new zzhr("Protocol message had invalid UTF-8.");
    }
}
