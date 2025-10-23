package com.google.android.gms.internal.drive;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class zznd {
    private static final Logger logger = Logger.getLogger(zznd.class.getName());
    private static final Class<?> zzni;
    private static final boolean zzog;
    private static final Unsafe zzuc;
    private static final boolean zzvy;
    private static final boolean zzvz;
    private static final zzd zzwa;
    private static final boolean zzwb;
    private static final long zzwc;
    private static final long zzwd;
    private static final long zzwe;
    private static final long zzwf;
    private static final long zzwg;
    private static final long zzwh;
    private static final long zzwi;
    private static final long zzwj;
    private static final long zzwk;
    private static final long zzwl;
    private static final long zzwm;
    private static final long zzwn;
    private static final long zzwo;
    private static final long zzwp;
    private static final int zzwq;
    static final boolean zzwr;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zznd() {
    }

    static final class zza extends zzd {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzp(obj, j);
            }
            return zznd.zzq(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zznd.zzwr) {
                zznd.zza(obj, j, b);
            } else {
                zznd.zzb(obj, j, b);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzr(obj, j);
            }
            return zznd.zzs(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j, z);
            } else {
                zznd.zzc(obj, j, z);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzd {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzp(obj, j);
            }
            return zznd.zzq(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zznd.zzwr) {
                zznd.zza(obj, j, b);
            } else {
                zznd.zzb(obj, j, b);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzr(obj, j);
            }
            return zznd.zzs(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j, z);
            } else {
                zznd.zzc(obj, j, z);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzc extends zzd {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j) {
            return this.zzws.getByte(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzws.putByte(obj, j, b);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j) {
            return this.zzws.getBoolean(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzws.putBoolean(obj, j, z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j) {
            return this.zzws.getFloat(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzws.putFloat(obj, j, f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j) {
            return this.zzws.getDouble(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzws.putDouble(obj, j, d);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzfd() {
        return zzog;
    }

    static abstract class zzd {
        Unsafe zzws;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzd(Unsafe unsafe) {
            this.zzws = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zzj(Object obj, long j) {
            return this.zzws.getInt(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(Object obj, long j, int i) {
            this.zzws.putInt(obj, j, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long zzk(Object obj, long j) {
            return this.zzws.getLong(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(Object obj, long j, long j2) {
            this.zzws.putLong(obj, j, j2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzfe() {
        return zzwb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzuc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzi(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzj(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzj(Object obj, long j) {
        return zzwa.zzj(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, int i) {
        zzwa.zza(obj, j, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long zzk(Object obj, long j) {
        return zzwa.zzk(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, long j2) {
        zzwa.zza(obj, j, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzl(Object obj, long j) {
        return zzwa.zzl(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, boolean z) {
        zzwa.zza(obj, j, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static float zzm(Object obj, long j) {
        return zzwa.zzm(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, float f) {
        zzwa.zza(obj, j, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static double zzn(Object obj, long j) {
        return zzwa.zzn(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, double d) {
        zzwa.zza(obj, j, d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zzo(Object obj, long j) {
        return zzwa.zzws.getObject(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, Object obj2) {
        zzwa.zzws.putObject(obj, j, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static byte zza(byte[] bArr, long j) {
        return zzwa.zzx(bArr, zzwc + j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(byte[] bArr, long j, byte b) {
        zzwa.zze(bArr, zzwc + j, b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Unsafe zzff() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzne());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzfg() {
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzix.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzfh() {
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzfi() == null) {
                return false;
            }
            if (zzix.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzk(Class<?> cls) {
        if (!zzix.zzbr()) {
            return false;
        }
        try {
            Class<?> cls2 = zzni;
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
    private static Field zzfi() {
        Field zzb2;
        if (zzix.zzbr() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int zzj = zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Unsafe zzff = zzff();
        zzuc = zzff;
        zzni = zzix.zzbs();
        boolean zzk = zzk(Long.TYPE);
        zzvy = zzk;
        boolean zzk2 = zzk(Integer.TYPE);
        zzvz = zzk2;
        zzd zzdVar = null;
        if (zzff != null) {
            if (!zzix.zzbr()) {
                zzdVar = new zzc(zzff);
            } else if (zzk) {
                zzdVar = new zzb(zzff);
            } else if (zzk2) {
                zzdVar = new zza(zzff);
            }
        }
        zzwa = zzdVar;
        zzwb = zzfh();
        zzog = zzfg();
        long zzi = zzi(byte[].class);
        zzwc = zzi;
        zzwd = zzi(boolean[].class);
        zzwe = zzj(boolean[].class);
        zzwf = zzi(int[].class);
        zzwg = zzj(int[].class);
        zzwh = zzi(long[].class);
        zzwi = zzj(long[].class);
        zzwj = zzi(float[].class);
        zzwk = zzj(float[].class);
        zzwl = zzi(double[].class);
        zzwm = zzj(double[].class);
        zzwn = zzi(Object[].class);
        zzwo = zzj(Object[].class);
        Field zzfi = zzfi();
        zzwp = (zzfi == null || zzdVar == null) ? -1L : zzdVar.zzws.objectFieldOffset(zzfi);
        zzwq = (int) (zzi & 7);
        zzwr = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
