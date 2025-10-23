package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzjh {
    public static final byte[] zzb;
    private static final ByteBuffer zze;
    private static final zzij zzf;
    private static final Charset zzc = Charset.forName(CharEncoding.US_ASCII);
    static final Charset zza = Charset.forName("UTF-8");
    private static final Charset zzd = Charset.forName("ISO-8859-1");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zze = ByteBuffer.wrap(bArr);
        zzf = zzij.zza(bArr, 0, bArr.length, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zza(zzkr zzkrVar) {
        if (!(zzkrVar instanceof zzhm)) {
            return false;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzc(byte[] bArr) {
        return zzmp.zza(bArr);
    }
}
