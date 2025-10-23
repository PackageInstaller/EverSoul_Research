package com.google.android.gms.internal.auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzev {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzee zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        int i = zzee.zza;
        zzed zzedVar = new zzed(bArr, 0, 0, false, null);
        try {
            zzedVar.zza(0);
            zze = zzedVar;
        } catch (zzew e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zze(T t) {
        t.getClass();
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zzf(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zzg(Object obj, Object obj2) {
        return ((zzfq) obj).zze().zzc((zzfq) obj2).zzg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zzh(byte[] bArr) {
        return new String(bArr, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzi(byte[] bArr) {
        return zzhd.zzc(bArr);
    }
}
