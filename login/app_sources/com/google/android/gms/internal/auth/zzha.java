package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzha {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) throws zzew {
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
        throw zzew.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zze(byte b) {
        return b > -65;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzew {
        if (zze(b2) || (((b << Ascii.f339FS) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw zzew.zzb();
        }
        int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) throws zzew {
        if (b < -62 || zze(b2)) {
            throw zzew.zzb();
        }
        cArr[i] = (char) (((b & Ascii.f348US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }
}
