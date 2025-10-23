package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzip<T> implements zzix<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzjq.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzim zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzjj zzl;
    private final zzgx zzm;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzip(int[] iArr, Object[] objArr, int i, int i2, zzim zzimVar, boolean z, int[] iArr2, int i3, int i4, zzir zzirVar, zzhz zzhzVar, zzjj zzjjVar, zzgx zzgxVar, zzih zzihVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzgxVar != null && (zzimVar instanceof zzhh)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzjjVar;
        this.zzm = zzgxVar;
        this.zzg = zzimVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzix zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzix zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzjq.zzq(obj, j, (1 << (zzp >>> 20)) | zzjq.zzc(obj, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzE(Object obj, int i, int i2) {
        zzjq.zzq(obj, zzp(i2) & 1048575, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzjq.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzjq.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzjq.zzb(obj, j2)) != 0;
            case 2:
                return zzjq.zzd(obj, j2) != 0;
            case 3:
                return zzjq.zzd(obj, j2) != 0;
            case 4:
                return zzjq.zzc(obj, j2) != 0;
            case 5:
                return zzjq.zzd(obj, j2) != 0;
            case 6:
                return zzjq.zzc(obj, j2) != 0;
            case 7:
                return zzjq.zzw(obj, j2);
            case 8:
                Object zzf = zzjq.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzgk) {
                    return !zzgk.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzjq.zzf(obj, j2) != null;
            case 10:
                return !zzgk.zzb.equals(zzjq.zzf(obj, j2));
            case 11:
                return zzjq.zzc(obj, j2) != 0;
            case 12:
                return zzjq.zzc(obj, j2) != 0;
            case 13:
                return zzjq.zzc(obj, j2) != 0;
            case 14:
                return zzjq.zzd(obj, j2) != 0;
            case 15:
                return zzjq.zzc(obj, j2) != 0;
            case 16:
                return zzjq.zzd(obj, j2) != 0;
            case 17:
                return zzjq.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzK(Object obj, int i, zzix zzixVar) {
        return zzixVar.zzk(zzjq.zzf(obj, i & 1048575));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzhk) {
            return ((zzhk) obj).zzA();
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzM(Object obj, int i, int i2) {
        return zzjq.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzjq.zzf(obj, j)).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final void zzO(int i, Object obj, zzjw zzjwVar) throws IOException {
        if (obj instanceof String) {
            zzjwVar.zzG(i, (String) obj);
        } else {
            zzjwVar.zzd(i, (zzgk) obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjk zzd(Object obj) {
        zzhk zzhkVar = (zzhk) obj;
        zzjk zzjkVar = zzhkVar.zzc;
        if (zzjkVar != zzjk.zzc()) {
            return zzjkVar;
        }
        zzjk zzf = zzjk.zzf();
        zzhkVar.zzc = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0268  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.play_billing.zzip zzl(java.lang.Class r34, com.google.android.gms.internal.play_billing.zzij r35, com.google.android.gms.internal.play_billing.zzir r36, com.google.android.gms.internal.play_billing.zzhz r37, com.google.android.gms.internal.play_billing.zzjj r38, com.google.android.gms.internal.play_billing.zzgx r39, com.google.android.gms.internal.play_billing.zzih r40) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzij, com.google.android.gms.internal.play_billing.zzir, com.google.android.gms.internal.play_billing.zzhz, com.google.android.gms.internal.play_billing.zzjj, com.google.android.gms.internal.play_billing.zzgx, com.google.android.gms.internal.play_billing.zzih):com.google.android.gms.internal.play_billing.zzip");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static double zzm(Object obj, long j) {
        return ((Double) zzjq.zzf(obj, j)).doubleValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float zzn(Object obj, long j) {
        return ((Float) zzjq.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzo(Object obj, long j) {
        return ((Integer) zzjq.zzf(obj, j)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzq(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static long zzt(Object obj, long j) {
        return ((Long) zzjq.zzf(obj, j)).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzhm zzu(int i) {
        int i2 = i / 3;
        return (zzhm) this.zzd[i2 + i2 + 1];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzix zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzix zzixVar = (zzix) objArr[i3];
        if (zzixVar != null) {
            return zzixVar;
        }
        zzix zzb2 = zziu.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zzx(Object obj, int i) {
        zzix zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zzy(Object obj, int i, int i2) {
        zzix zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v263, types: [int] */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zza(Object obj) {
        int i;
        int i2;
        ?? r5;
        int zzz;
        int zzz2;
        int zzz3;
        int zzA;
        int zzz4;
        int zzz5;
        int zzd;
        int zzz6;
        ?? zzg;
        int size;
        int zzz7;
        int zzy;
        int zzy2;
        ?? r3;
        int zzx;
        ?? r1;
        ?? r0;
        int zze;
        int zzz8;
        int zzz9;
        ?? r4;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i3 = 1048575;
        ?? r12 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzc.length) {
            int zzs = zzs(i4);
            int zzr = zzr(zzs);
            int[] iArr = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i3;
            if (zzr <= 17) {
                if (i9 != i6) {
                    r12 = i9 == i3 ? z : unsafe.getInt(obj, i9);
                    i6 = i9;
                }
                i = i6;
                i2 = r12;
                r5 = 1 << (i8 >>> 20);
            } else {
                i = i6;
                i2 = r12;
                r5 = z;
            }
            int i10 = zzs & i3;
            if (zzr >= zzhc.DOUBLE_LIST_PACKED.zza()) {
                zzhc.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz = zzgr.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 1:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz2 = zzgr.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 2:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(j2);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 3:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(j3);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 4:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(j4);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 5:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz = zzgr.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 6:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz2 = zzgr.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 7:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz4 = zzgr.zzz(i7 << 3);
                        r0 = zzz4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 8:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgk) {
                            zzz5 = zzgr.zzz(i11);
                            zzd = ((zzgk) object).zzd();
                            zzz6 = zzgr.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzz3 = zzgr.zzz(i11);
                            zzA = zzgr.zzy((String) object);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 9:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        r0 = zziz.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 10:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzgk zzgkVar = (zzgk) unsafe.getObject(obj, j);
                        zzz5 = zzgr.zzz(i7 << 3);
                        zzd = zzgkVar.zzd();
                        zzz6 = zzgr.zzz(zzd);
                        r0 = zzz5 + zzz6 + zzd;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 11:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzz(i12);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 12:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(j5);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 13:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz2 = zzgr.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 14:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz = zzgr.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 15:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzz((i13 >> 31) ^ (i13 + i13));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 16:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA((j6 >> 63) ^ (j6 + j6));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 17:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        r0 = zzgr.zzw(i7, (zzim) unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 18:
                    r0 = zziz.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 19:
                    r0 = zziz.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zziz.zza;
                    if (list.size() != 0) {
                        zzg = zziz.zzg(list) + (list.size() * zzgr.zzz(i7 << 3));
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zziz.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzz3 = zziz.zzl(list2);
                        zzz7 = zzgr.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zziz.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzz3 = zziz.zzf(list3);
                        zzz7 = zzgr.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 23:
                    r0 = zziz.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 24:
                    r0 = zziz.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zziz.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r0 = size2 * (zzgr.zzz(i7 << 3) + 1);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 26:
                    ?? r02 = (List) unsafe.getObject(obj, j);
                    int i18 = zziz.zza;
                    int size3 = r02.size();
                    if (size3 != 0) {
                        int zzz10 = zzgr.zzz(i7 << 3) * size3;
                        if (r02 instanceof zzhy) {
                            zzhy zzhyVar = (zzhy) r02;
                            zzg = zzz10;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object zzc = zzhyVar.zzc();
                                if (zzc instanceof zzgk) {
                                    int zzd2 = ((zzgk) zzc).zzd();
                                    zzy2 = zzg + zzgr.zzz(zzd2) + zzd2;
                                } else {
                                    zzy2 = zzg + zzgr.zzy((String) zzc);
                                }
                                zzg = zzy2;
                            }
                        } else {
                            zzg = zzz10;
                            for (?? r33 = z; r33 < size3; r33++) {
                                Object obj2 = r02.get(r33);
                                if (obj2 instanceof zzgk) {
                                    int zzd3 = ((zzgk) obj2).zzd();
                                    zzy = zzg + zzgr.zzz(zzd3) + zzd3;
                                } else {
                                    zzy = zzg + zzgr.zzy((String) obj2);
                                }
                                zzg = zzy;
                            }
                        }
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 27:
                    ?? r03 = (List) unsafe.getObject(obj, j);
                    zzix zzv = zzv(i4);
                    int i19 = zziz.zza;
                    int size4 = r03.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        r3 = zzgr.zzz(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r03.get(r42);
                            if (obj3 instanceof zzhx) {
                                int zza2 = ((zzhx) obj3).zza();
                                zzx = (r3 == true ? 1 : 0) + zzgr.zzz(zza2) + zza2;
                            } else {
                                zzx = (r3 == true ? 1 : 0) + zzgr.zzx((zzim) obj3, zzv);
                            }
                            r3 = zzx;
                        }
                    }
                    i5 += r3;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 28:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    int i20 = zziz.zza;
                    int size5 = r04.size();
                    if (size5 == 0) {
                        r1 = z;
                    } else {
                        r1 = size5 * zzgr.zzz(i7 << 3);
                        for (?? r2 = z; r2 < r04.size(); r2++) {
                            int zzd4 = ((zzgk) r04.get(r2)).zzd();
                            r1 += zzgr.zzz(zzd4) + zzd4;
                        }
                    }
                    i5 += r1;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zziz.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzz3 = zziz.zzk(list5);
                        zzz7 = zzgr.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zziz.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzz3 = zziz.zza(list6);
                        zzz7 = zzgr.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 31:
                    r0 = zziz.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 32:
                    r0 = zziz.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zziz.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzz3 = zziz.zzi(list7);
                        zzz7 = zzgr.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zziz.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzz3 = zziz.zzj(list8);
                        zzz7 = zzgr.zzz(i7 << 3);
                        zzA = size * zzz7;
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 35:
                    zze = zziz.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 36:
                    zze = zziz.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 37:
                    zze = zziz.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 38:
                    zze = zziz.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 39:
                    zze = zziz.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 40:
                    zze = zziz.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 41:
                    zze = zziz.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zziz.zza;
                    zze = list9.size();
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 43:
                    zze = zziz.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 44:
                    zze = zziz.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 45:
                    zze = zziz.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 46:
                    zze = zziz.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 47:
                    zze = zziz.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 48:
                    zze = zziz.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzgr.zzz(i7 << 3);
                        zzz9 = zzgr.zzz(zze);
                        r1 = zzz8 + zzz9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 49:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    zzix zzv2 = zzv(i4);
                    int i26 = zziz.zza;
                    int size6 = r05.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        ?? r34 = z2;
                        while (r34 < size6) {
                            int zzw = zzgr.zzw(i7, (zzim) r05.get(r34), zzv2);
                            r34++;
                            r4 = (r4 == true ? 1 : 0) + zzw;
                        }
                    }
                    i5 += r4;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 50:
                    zzig zzigVar = (zzig) unsafe.getObject(obj, j);
                    if (zzigVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzigVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 51:
                    if (zzM(obj, i7, i4)) {
                        zzz = zzgr.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 52:
                    if (zzM(obj, i7, i4)) {
                        zzz2 = zzgr.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 53:
                    if (zzM(obj, i7, i4)) {
                        long zzt = zzt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(zzt);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 54:
                    if (zzM(obj, i7, i4)) {
                        long zzt2 = zzt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(zzt2);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 55:
                    if (zzM(obj, i7, i4)) {
                        long zzo = zzo(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(zzo);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 56:
                    if (zzM(obj, i7, i4)) {
                        zzz = zzgr.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 57:
                    if (zzM(obj, i7, i4)) {
                        zzz2 = zzgr.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 58:
                    if (zzM(obj, i7, i4)) {
                        zzz4 = zzgr.zzz(i7 << 3);
                        r0 = zzz4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 59:
                    if (zzM(obj, i7, i4)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgk) {
                            zzz5 = zzgr.zzz(i27);
                            zzd = ((zzgk) object2).zzd();
                            zzz6 = zzgr.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzz3 = zzgr.zzz(i27);
                            zzA = zzgr.zzy((String) object2);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 60:
                    if (zzM(obj, i7, i4)) {
                        r0 = zziz.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 61:
                    if (zzM(obj, i7, i4)) {
                        zzgk zzgkVar2 = (zzgk) unsafe.getObject(obj, j);
                        zzz5 = zzgr.zzz(i7 << 3);
                        zzd = zzgkVar2.zzd();
                        zzz6 = zzgr.zzz(zzd);
                        r0 = zzz5 + zzz6 + zzd;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 62:
                    if (zzM(obj, i7, i4)) {
                        int zzo2 = zzo(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzz(zzo2);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 63:
                    if (zzM(obj, i7, i4)) {
                        long zzo3 = zzo(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA(zzo3);
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 64:
                    if (zzM(obj, i7, i4)) {
                        zzz2 = zzgr.zzz(i7 << 3);
                        r0 = zzz2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 65:
                    if (zzM(obj, i7, i4)) {
                        zzz = zzgr.zzz(i7 << 3);
                        r0 = zzz + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 66:
                    if (zzM(obj, i7, i4)) {
                        int zzo4 = zzo(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzz((zzo4 >> 31) ^ (zzo4 + zzo4));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 67:
                    if (zzM(obj, i7, i4)) {
                        long zzt3 = zzt(obj, j);
                        zzz3 = zzgr.zzz(i7 << 3);
                        zzA = zzgr.zzA((zzt3 >> 63) ^ (zzt3 + zzt3));
                        r0 = zzz3 + zzA;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 68:
                    if (zzM(obj, i7, i4)) {
                        r0 = zzgr.zzw(i7, (zzim) unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                default:
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
            }
        }
        int zza3 = i5 + ((zzhk) obj).zzc.zza();
        if (!this.zzh) {
            return zza3;
        }
        zzhb zzhbVar = ((zzhh) obj).zzb;
        int zzc2 = zzhbVar.zza.zzc();
        int i28 = 0;
        for (int i29 = 0; i29 < zzc2; i29++) {
            Map.Entry zzg2 = zzhbVar.zza.zzg(i29);
            i28 += zzhb.zzb((zzha) ((zzjb) zzg2).zza(), zzg2.getValue());
        }
        for (Map.Entry entry2 : zzhbVar.zza.zzd()) {
            i28 += zzhb.zzb((zzha) entry2.getKey(), entry2.getValue());
        }
        return zza3 + i28;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zzr) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzjq.zza(obj, j));
                    byte[] bArr = zzhp.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzjq.zzb(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr2 = zzhp.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr3 = zzhp.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr4 = zzhp.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zzhp.zza(zzjq.zzw(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzjq.zzf(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzf = zzjq.zzf(obj, j);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr5 = zzhp.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzjq.zzd(obj, j);
                    byte[] bArr6 = zzhp.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzf2 = zzjq.zzf(obj, j);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzjq.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzhp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzhp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzhp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzhp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhp.zza(zzN(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzjq.zzf(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzjq.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzjq.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzhp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzhp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzjq.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + ((zzhk) obj).zzc.hashCode();
        return this.zzh ? (hashCode * 53) + ((zzhh) obj).zzb.zza.hashCode() : hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0dc9, code lost:
    
        if (r6 == r2) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0dcb, code lost:
    
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0dd1, code lost:
    
        r2 = r7.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0dd5, code lost:
    
        if (r2 >= r7.zzk) goto L704;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0dd7, code lost:
    
        r3 = r7.zzi;
        r5 = r7.zzc;
        r3 = r3[r2];
        r5 = r5[r3];
        r5 = com.google.android.gms.internal.play_billing.zzjq.zzf(r12, r7.zzs(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0dec, code lost:
    
        if (r5 != null) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0df3, code lost:
    
        if (r7.zzu(r3) != null) goto L703;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0dfc, code lost:
    
        r5 = (com.google.android.gms.internal.play_billing.zzig) r5;
        r0 = (com.google.android.gms.internal.play_billing.zzif) r7.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0e04, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0df5, code lost:
    
        r3 = (com.google.android.gms.internal.play_billing.zzjk) null;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0e07, code lost:
    
        if (r0 != 0) goto L599;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0e0b, code lost:
    
        if (r1 != r41) goto L597;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0e13, code lost:
    
        throw new com.google.android.gms.internal.play_billing.zzhr("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0e1a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0e16, code lost:
    
        if (r1 > r41) goto L603;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0e18, code lost:
    
        if (r4 != r0) goto L603;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0e20, code lost:
    
        throw new com.google.android.gms.internal.play_billing.zzhr("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0aa0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0ab1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0d69  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0d36 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0d4c A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(java.lang.Object r38, byte[] r39, int r40, int r41, int r42, com.google.android.gms.internal.play_billing.zzfz r43) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzfz):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final Object zze() {
        return ((zzhk) this.zzg).zzp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzhk) {
                zzhk zzhkVar = (zzhk) obj;
                zzhkVar.zzy(Integer.MAX_VALUE);
                zzhkVar.zza = 0;
                zzhkVar.zzw();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zzho) zzjq.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzig) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = i2;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzjq.zzo(obj, j, zzjq.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzjq.zzp(obj, j, zzjq.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzjq.zzm(obj, j, zzjq.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzjq.zzq(obj, j, zzjq.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzjq.zzr(obj, j, zzjq.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzho zzhoVar = (zzho) zzjq.zzf(obj, j);
                    zzho zzhoVar2 = (zzho) zzjq.zzf(obj2, j);
                    int size = zzhoVar.size();
                    int size2 = zzhoVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzhoVar.zzc()) {
                            zzhoVar = zzhoVar.zzd(size2 + size);
                        }
                        zzhoVar.addAll(zzhoVar2);
                    }
                    if (size > 0) {
                        zzhoVar2 = zzhoVar;
                    }
                    zzjq.zzs(obj, j, zzhoVar2);
                    break;
                case 50:
                    int i4 = zziz.zza;
                    zzjq.zzs(obj, j, zzih.zza(zzjq.zzf(obj, j), zzjq.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i3, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzjq.zzs(obj, j, zzjq.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zziz.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zziz.zzo(this.zzm, obj, obj2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzfz zzfzVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzfzVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:237:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r20, com.google.android.gms.internal.play_billing.zzjw r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1694
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzip.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzjw):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzjq.zza(obj, j)) == Double.doubleToLongBits(zzjq.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzjq.zzb(obj, j)) == Float.floatToIntBits(zzjq.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzjq.zzd(obj, j) == zzjq.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzjq.zzd(obj, j) == zzjq.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzjq.zzc(obj, j) == zzjq.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzjq.zzd(obj, j) == zzjq.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzjq.zzc(obj, j) == zzjq.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzjq.zzw(obj, j) == zzjq.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzjq.zzc(obj, j) == zzjq.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzjq.zzc(obj, j) == zzjq.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzjq.zzc(obj, j) == zzjq.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzjq.zzd(obj, j) == zzjq.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzjq.zzc(obj, j) == zzjq.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzjq.zzd(obj, j) == zzjq.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzE = zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j));
                    break;
                case 50:
                    zzE = zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzp = zzp(i) & 1048575;
                    if (zzjq.zzc(obj, zzp) == zzjq.zzc(obj2, zzp) && zziz.zzE(zzjq.zzf(obj, j), zzjq.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
                return false;
            }
        }
        if (!((zzhk) obj).zzc.equals(((zzhk) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzhh) obj).zzb.equals(((zzhh) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i7, i6) && !zzK(obj, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzig) zzjq.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzjq.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzix zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i6, i, i2, i10) && !zzK(obj, zzs, zzv(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.zzh || ((zzhh) obj).zzb.zzh();
    }
}
