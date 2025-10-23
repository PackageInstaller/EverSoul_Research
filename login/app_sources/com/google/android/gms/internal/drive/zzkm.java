package com.google.android.gms.internal.drive;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzkm {
    public static final byte[] zzsn;
    private static final ByteBuffer zzso;
    private static final zzjo zzsp;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zze(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzf(zzlq zzlqVar) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzu(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T checkNotNull(T t) {
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
    public static boolean zzd(byte[] bArr) {
        return zznf.zzd(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zza(Object obj, Object obj2) {
        return ((zzlq) obj).zzcy().zza((zzlq) obj2).zzde();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        byte[] bArr = new byte[0];
        zzsn = bArr;
        zzso = ByteBuffer.wrap(bArr);
        zzsp = zzjo.zza(bArr, 0, bArr.length, false);
    }
}
