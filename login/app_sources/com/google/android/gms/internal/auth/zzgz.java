package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzgz {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzgy zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0156  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzgz.<clinit>():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzgz() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(Object obj, long j) {
        return zzf.zzi(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long zzd(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zze(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zzf(Object obj, long j) {
        return zzf.zzl(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgv());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzh(Throwable th) {
        Logger logger = Logger.getLogger(zzgz.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        zzgy zzgyVar = zzf;
        int zzi = zzgyVar.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzgyVar.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        zzgy zzgyVar = zzf;
        int i = (((int) j) & 3) << 3;
        zzgyVar.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzgyVar.zzi(obj, j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzk(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzl(Object obj, long j, double d) {
        zzf.zzd(obj, j, d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzm(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzn(Object obj, long j, int i) {
        zzf.zzm(obj, j, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzo(Object obj, long j, long j2) {
        zzf.zzn(obj, j, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzp(Object obj, long j, Object obj2) {
        zzf.zzo(obj, j, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzs(Class<?> cls) {
        int i = zzdo.zza;
        try {
            Class<?> cls2 = zzc;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzt(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzu() {
        return zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzv() {
        return zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzw(Class<?> cls) {
        if (zzh) {
            return zzf.zzg(cls);
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzx(Class<?> cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field zzy() {
        int i = zzdo.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(Buffer.class, "address");
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field zzz(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
