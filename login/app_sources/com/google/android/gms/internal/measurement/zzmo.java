package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmo {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzc zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final int zzw;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    private static final class zza extends zzc {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final double zza(Object obj, long j) {
            return Double.longBitsToDouble(zze(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final float zzb(Object obj, long j) {
            return Float.intBitsToFloat(zzd(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzmo.zza) {
                zzmo.zza(obj, j, z);
            } else {
                zzmo.zzb(obj, j, z);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, byte b) {
            if (zzmo.zza) {
                zzmo.zzc(obj, j, b);
            } else {
                zzmo.zzd(obj, j, b);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final boolean zzc(Object obj, long j) {
            if (zzmo.zza) {
                return zzmo.zzf(obj, j);
            }
            return zzmo.zzg(obj, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    private static final class zzb extends zzc {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final double zza(Object obj, long j) {
            return Double.longBitsToDouble(zze(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final float zzb(Object obj, long j) {
            return Float.intBitsToFloat(zzd(obj, j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzmo.zza) {
                zzmo.zza(obj, j, z);
            } else {
                zzmo.zzb(obj, j, z);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, byte b) {
            if (zzmo.zza) {
                zzmo.zzc(obj, j, b);
            } else {
                zzmo.zzd(obj, j, b);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzmo.zzc
        public final boolean zzc(Object obj, long j) {
            if (zzmo.zza) {
                return zzmo.zzf(obj, j);
            }
            return zzmo.zzg(obj, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    private static abstract class zzc {
        Unsafe zza;

        public abstract double zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract float zzb(Object obj, long j);

        public abstract boolean zzc(Object obj, long j);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zzd(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long zze(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzc(Unsafe unsafe) {
            this.zza = unsafe;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zza() {
            Unsafe unsafe = this.zza;
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
                return true;
            } catch (Throwable th) {
                zzmo.zza(th);
                return false;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzb() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return zzmo.zze() != null;
            } catch (Throwable th) {
                zzmo.zza(th);
                return false;
            }
        }
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
    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long zzd(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T zza(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zze(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field zze() {
        Field zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress");
        if (zza2 != null) {
            return zza2;
        }
        Field zza3 = zza((Class<?>) Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Unsafe zzb() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmn());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(Throwable th) {
        Logger.getLogger(zzmo.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzb(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        /*
            sun.misc.Unsafe r0 = zzb()
            com.google.android.gms.internal.measurement.zzmo.zzb = r0
            java.lang.Class r1 = com.google.android.gms.internal.measurement.zzhr.zza()
            com.google.android.gms.internal.measurement.zzmo.zzc = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = zzd(r1)
            com.google.android.gms.internal.measurement.zzmo.zzd = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = zzd(r2)
            com.google.android.gms.internal.measurement.zzmo.zze = r2
            if (r0 == 0) goto L2e
            if (r1 == 0) goto L26
            com.google.android.gms.internal.measurement.zzmo$zza r1 = new com.google.android.gms.internal.measurement.zzmo$zza
            r1.<init>(r0)
            goto L2f
        L26:
            if (r2 == 0) goto L2e
            com.google.android.gms.internal.measurement.zzmo$zzb r1 = new com.google.android.gms.internal.measurement.zzmo$zzb
            r1.<init>(r0)
            goto L2f
        L2e:
            r1 = 0
        L2f:
            com.google.android.gms.internal.measurement.zzmo.zzf = r1
            r0 = 0
            if (r1 != 0) goto L36
            r2 = r0
            goto L3a
        L36:
            boolean r2 = r1.zzb()
        L3a:
            com.google.android.gms.internal.measurement.zzmo.zzg = r2
            if (r1 != 0) goto L40
            r2 = r0
            goto L44
        L40:
            boolean r2 = r1.zza()
        L44:
            com.google.android.gms.internal.measurement.zzmo.zzh = r2
            java.lang.Class<byte[]> r2 = byte[].class
            int r2 = zzb(r2)
            long r2 = (long) r2
            com.google.android.gms.internal.measurement.zzmo.zzi = r2
            java.lang.Class<boolean[]> r4 = boolean[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.measurement.zzmo.zzj = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzk = r4
            java.lang.Class<int[]> r4 = int[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.measurement.zzmo.zzl = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzm = r4
            java.lang.Class<long[]> r4 = long[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.measurement.zzmo.zzn = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzo = r4
            java.lang.Class<float[]> r4 = float[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.measurement.zzmo.zzp = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzq = r4
            java.lang.Class<double[]> r4 = double[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.measurement.zzmo.zzr = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzs = r4
            java.lang.Class<java.lang.Object[]> r4 = java.lang.Object[].class
            int r4 = zzb(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzt = r4
            java.lang.Class<java.lang.Object[]> r4 = java.lang.Object[].class
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.measurement.zzmo.zzu = r4
            java.lang.reflect.Field r4 = zze()
            if (r4 == 0) goto Lc1
            if (r1 != 0) goto Lba
            goto Lc1
        Lba:
            sun.misc.Unsafe r1 = r1.zza
            long r4 = r1.objectFieldOffset(r4)
            goto Lc3
        Lc1:
            r4 = -1
        Lc3:
            com.google.android.gms.internal.measurement.zzmo.zzv = r4
            r4 = 7
            long r1 = r2 & r4
            int r1 = (int) r1
            com.google.android.gms.internal.measurement.zzmo.zzw = r1
            java.nio.ByteOrder r1 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            if (r1 != r2) goto Ld5
            r0 = 1
        Ld5:
            com.google.android.gms.internal.measurement.zzmo.zza = r0
            return
            fill-array 0x00d8: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmo.<clinit>():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzmo() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzc(Object obj, long j, boolean z) {
        zzf.zza(obj, j, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(byte[] bArr, long j, byte b) {
        zzf.zza((Object) bArr, zzi + j, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int zzc2 = zzc(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzc2 & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzd(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzc(obj, j2) & (~(255 << i))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, double d) {
        zzf.zza(obj, j, d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, float f) {
        zzf.zza(obj, j, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, int i) {
        zzf.zza(obj, j, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, long j2) {
        zzf.zza(obj, j, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean zzf(Object obj, long j) {
        return ((byte) (zzc(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)))) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean zzg(Object obj, long j) {
        return ((byte) (zzc(obj, (-4) & j) >>> ((int) ((j & 3) << 3)))) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzd(Class<?> cls) {
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
    static boolean zzh(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzc() {
        return zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzd() {
        return zzg;
    }
}
