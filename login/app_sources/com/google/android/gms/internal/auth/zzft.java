package com.google.android.gms.internal.auth;

import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzft<T> implements zzgb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfq zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfe zzl;
    private final zzgp<?, ?> zzm;
    private final zzeh<?> zzn;
    private final zzfv zzo;
    private final zzfl zzp;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzft(int[] iArr, int[] iArr2, Object[] objArr, int i, int i2, zzfq zzfqVar, boolean z, boolean z2, int[] iArr3, int i3, int i4, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i;
        this.zzh = zzfqVar;
        this.zzi = z2;
        this.zzj = iArr3;
        this.zzk = i3;
        this.zzo = i4;
        this.zzl = zzfvVar;
        this.zzm = zzfeVar;
        this.zzn = zzgpVar;
        this.zzg = i2;
        this.zzp = zzehVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field zzA(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzB(T t, T t2, int i) {
        long zzv = zzv(i) & 1048575;
        if (zzG(t2, i)) {
            Object zzf = zzgz.zzf(t, zzv);
            Object zzf2 = zzgz.zzf(t2, zzv);
            if (zzf != null && zzf2 != null) {
                zzgz.zzp(t, zzv, zzev.zzg(zzf, zzf2));
                zzD(t, i);
            } else if (zzf2 != null) {
                zzgz.zzp(t, zzv, zzf2);
                zzD(t, i);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzC(T t, T t2, int i) {
        int zzv = zzv(i);
        int i2 = this.zzc[i];
        long j = zzv & 1048575;
        if (zzJ(t2, i2, i)) {
            Object zzf = zzJ(t, i2, i) ? zzgz.zzf(t, j) : null;
            Object zzf2 = zzgz.zzf(t2, j);
            if (zzf != null && zzf2 != null) {
                zzgz.zzp(t, j, zzev.zzg(zzf, zzf2));
                zzE(t, i2, i);
            } else if (zzf2 != null) {
                zzgz.zzp(t, j, zzf2);
                zzE(t, i2, i);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzD(T t, int i) {
        int zzs = zzs(i);
        long j = 1048575 & zzs;
        if (j == 1048575) {
            return;
        }
        zzgz.zzn(t, j, (1 << (zzs >>> 20)) | zzgz.zzc(t, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzE(T t, int i, int i2) {
        zzgz.zzn(t, zzs(i2) & 1048575, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzF(T t, T t2, int i) {
        return zzG(t, i) == zzG(t2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzG(T t, int i) {
        int zzs = zzs(i);
        long j = zzs & 1048575;
        if (j != 1048575) {
            return (zzgz.zzc(t, j) & (1 << (zzs >>> 20))) != 0;
        }
        int zzv = zzv(i);
        long j2 = zzv & 1048575;
        switch (zzu(zzv)) {
            case 0:
                return zzgz.zza(t, j2) != 0.0d;
            case 1:
                return zzgz.zzb(t, j2) != 0.0f;
            case 2:
                return zzgz.zzd(t, j2) != 0;
            case 3:
                return zzgz.zzd(t, j2) != 0;
            case 4:
                return zzgz.zzc(t, j2) != 0;
            case 5:
                return zzgz.zzd(t, j2) != 0;
            case 6:
                return zzgz.zzc(t, j2) != 0;
            case 7:
                return zzgz.zzt(t, j2);
            case 8:
                Object zzf = zzgz.zzf(t, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzeb) {
                    return !zzeb.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(t, j2) != null;
            case 10:
                return !zzeb.zzb.equals(zzgz.zzf(t, j2));
            case 11:
                return zzgz.zzc(t, j2) != 0;
            case 12:
                return zzgz.zzc(t, j2) != 0;
            case 13:
                return zzgz.zzc(t, j2) != 0;
            case 14:
                return zzgz.zzd(t, j2) != 0;
            case 15:
                return zzgz.zzc(t, j2) != 0;
            case 16:
                return zzgz.zzd(t, j2) != 0;
            case 17:
                return zzgz.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzH(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzG(t, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzI(Object obj, int i, zzgb zzgbVar) {
        return zzgbVar.zzi(zzgz.zzf(obj, i & 1048575));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzJ(T t, int i, int i2) {
        return zzgz.zzc(t, (long) (zzs(i2) & 1048575)) == i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzgq zzc(Object obj) {
        zzeq zzeqVar = (zzeq) obj;
        zzgq zzgqVar = zzeqVar.zzc;
        if (zzgqVar != zzgq.zza()) {
            return zzgqVar;
        }
        zzgq zzc = zzgq.zzc();
        zzeqVar.zzc = zzc;
        return zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> zzft<T> zzj(Class<T> cls, zzfn zzfnVar, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
        if (zzfnVar instanceof zzga) {
            return zzk((zzga) zzfnVar, zzfvVar, zzfeVar, zzgpVar, zzehVar, zzflVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0261  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.android.gms.internal.auth.zzft<T> zzk(com.google.android.gms.internal.auth.zzga r34, com.google.android.gms.internal.auth.zzfv r35, com.google.android.gms.internal.auth.zzfe r36, com.google.android.gms.internal.auth.zzgp<?, ?> r37, com.google.android.gms.internal.auth.zzeh<?> r38, com.google.android.gms.internal.auth.zzfl r39) {
        /*
            Method dump skipped, instructions count: 1022
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzk(com.google.android.gms.internal.auth.zzga, com.google.android.gms.internal.auth.zzfv, com.google.android.gms.internal.auth.zzfe, com.google.android.gms.internal.auth.zzgp, com.google.android.gms.internal.auth.zzeh, com.google.android.gms.internal.auth.zzfl):com.google.android.gms.internal.auth.zzft");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> int zzl(T t, long j) {
        return ((Integer) zzgz.zzf(t, j)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final <K, V> int zzm(T t, byte[] bArr, int i, int i2, int i3, long j, zzdp zzdpVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzfk) object).zze()) {
            zzfk<K, V> zzb2 = zzfk.zza().zzb();
            zzfl.zza(zzb2, object);
            unsafe.putObject(t, j, zzb2);
        }
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzn(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdp zzdpVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(zzdq.zzn(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(zzdq.zzb(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int zzm = zzdq.zzm(bArr, i, zzdpVar);
                    unsafe.putObject(t, j, Long.valueOf(zzdpVar.zzb));
                    unsafe.putInt(t, j2, i4);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int zzj = zzdq.zzj(bArr, i, zzdpVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzdpVar.zza));
                    unsafe.putInt(t, j2, i4);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzdq.zzn(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzdq.zzb(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int zzm2 = zzdq.zzm(bArr, i, zzdpVar);
                    unsafe.putObject(t, j, Boolean.valueOf(zzdpVar.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return zzm2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int zzj2 = zzdq.zzj(bArr, i, zzdpVar);
                    int i9 = zzdpVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & DriveFile.MODE_WRITE_ONLY) != 0 && !zzhd.zzd(bArr, zzj2, zzj2 + i9)) {
                            throw zzew.zzb();
                        }
                        unsafe.putObject(t, j, new String(bArr, zzj2, i9, zzev.zza));
                        zzj2 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzj2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int zzd = zzdq.zzd(zzy(i8), bArr, i, i2, zzdpVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzdpVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzev.zzg(object, zzdpVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzd;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int zza2 = zzdq.zza(bArr, i, zzdpVar);
                    unsafe.putObject(t, j, zzdpVar.zzc);
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int zzj3 = zzdq.zzj(bArr, i, zzdpVar);
                    int i10 = zzdpVar.zza;
                    zzet zzx = zzx(i8);
                    if (zzx == null || zzx.zza()) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        zzc(t).zzf(i3, Long.valueOf(i10));
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int zzj4 = zzdq.zzj(bArr, i, zzdpVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzee.zzb(zzdpVar.zza)));
                    unsafe.putInt(t, j2, i4);
                    return zzj4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int zzm3 = zzdq.zzm(bArr, i, zzdpVar);
                    unsafe.putObject(t, j, Long.valueOf(zzee.zzc(zzdpVar.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return zzm3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int zzc = zzdq.zzc(zzy(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdpVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzdpVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzev.zzg(object2, zzdpVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x02a1, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x02a3, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r2 = r18;
        r1 = r19;
        r6 = r23;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x02b7, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x02e8, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x030b, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:60:0x0085. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzo(T r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.auth.zzdp r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 890
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzo(java.lang.Object, byte[], int, int, com.google.android.gms.internal.auth.zzdp):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzp(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzdp zzdpVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int zzj;
        int i12 = i;
        Unsafe unsafe = zzb;
        zzeu zzeuVar = (zzeu) unsafe.getObject(t, j2);
        if (!zzeuVar.zzc()) {
            int size = zzeuVar.size();
            zzeuVar = zzeuVar.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(t, j2, zzeuVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzef zzefVar = (zzef) zzeuVar;
                    int zzj2 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i13 = zzdpVar.zza + zzj2;
                    while (zzj2 < i13) {
                        zzefVar.zze(Double.longBitsToDouble(zzdq.zzn(bArr, zzj2)));
                        zzj2 += 8;
                    }
                    if (zzj2 == i13) {
                        return zzj2;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 1) {
                    zzef zzefVar2 = (zzef) zzeuVar;
                    zzefVar2.zze(Double.longBitsToDouble(zzdq.zzn(bArr, i)));
                    while (true) {
                        i8 = i12 + 8;
                        if (i8 < i2) {
                            i12 = zzdq.zzj(bArr, i8, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzefVar2.zze(Double.longBitsToDouble(zzdq.zzn(bArr, i12)));
                            }
                        }
                    }
                    return i8;
                }
                return i12;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzem zzemVar = (zzem) zzeuVar;
                    int zzj3 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i14 = zzdpVar.zza + zzj3;
                    while (zzj3 < i14) {
                        zzemVar.zze(Float.intBitsToFloat(zzdq.zzb(bArr, zzj3)));
                        zzj3 += 4;
                    }
                    if (zzj3 == i14) {
                        return zzj3;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 5) {
                    zzem zzemVar2 = (zzem) zzeuVar;
                    zzemVar2.zze(Float.intBitsToFloat(zzdq.zzb(bArr, i)));
                    while (true) {
                        i9 = i12 + 4;
                        if (i9 < i2) {
                            i12 = zzdq.zzj(bArr, i9, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzemVar2.zze(Float.intBitsToFloat(zzdq.zzb(bArr, i12)));
                            }
                        }
                    }
                    return i9;
                }
                return i12;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzff zzffVar = (zzff) zzeuVar;
                    int zzj4 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i15 = zzdpVar.zza + zzj4;
                    while (zzj4 < i15) {
                        zzj4 = zzdq.zzm(bArr, zzj4, zzdpVar);
                        zzffVar.zze(zzdpVar.zzb);
                    }
                    if (zzj4 == i15) {
                        return zzj4;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 0) {
                    zzff zzffVar2 = (zzff) zzeuVar;
                    int zzm = zzdq.zzm(bArr, i12, zzdpVar);
                    zzffVar2.zze(zzdpVar.zzb);
                    while (zzm < i2) {
                        int zzj5 = zzdq.zzj(bArr, zzm, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzm;
                        }
                        zzm = zzdq.zzm(bArr, zzj5, zzdpVar);
                        zzffVar2.zze(zzdpVar.zzb);
                    }
                    return zzm;
                }
                return i12;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzdq.zzf(bArr, i12, zzeuVar, zzdpVar);
                }
                if (i5 == 0) {
                    return zzdq.zzl(i3, bArr, i, i2, zzeuVar, zzdpVar);
                }
                return i12;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzff zzffVar3 = (zzff) zzeuVar;
                    int zzj6 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i16 = zzdpVar.zza + zzj6;
                    while (zzj6 < i16) {
                        zzffVar3.zze(zzdq.zzn(bArr, zzj6));
                        zzj6 += 8;
                    }
                    if (zzj6 == i16) {
                        return zzj6;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 1) {
                    zzff zzffVar4 = (zzff) zzeuVar;
                    zzffVar4.zze(zzdq.zzn(bArr, i));
                    while (true) {
                        i10 = i12 + 8;
                        if (i10 < i2) {
                            i12 = zzdq.zzj(bArr, i10, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzffVar4.zze(zzdq.zzn(bArr, i12));
                            }
                        }
                    }
                    return i10;
                }
                return i12;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzer zzerVar = (zzer) zzeuVar;
                    int zzj7 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i17 = zzdpVar.zza + zzj7;
                    while (zzj7 < i17) {
                        zzerVar.zze(zzdq.zzb(bArr, zzj7));
                        zzj7 += 4;
                    }
                    if (zzj7 == i17) {
                        return zzj7;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 5) {
                    zzer zzerVar2 = (zzer) zzeuVar;
                    zzerVar2.zze(zzdq.zzb(bArr, i));
                    while (true) {
                        i11 = i12 + 4;
                        if (i11 < i2) {
                            i12 = zzdq.zzj(bArr, i11, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzerVar2.zze(zzdq.zzb(bArr, i12));
                            }
                        }
                    }
                    return i11;
                }
                return i12;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzdr zzdrVar = (zzdr) zzeuVar;
                    zzj = zzdq.zzj(bArr, i12, zzdpVar);
                    int i18 = zzdpVar.zza + zzj;
                    while (zzj < i18) {
                        zzj = zzdq.zzm(bArr, zzj, zzdpVar);
                        zzdrVar.zze(zzdpVar.zzb != 0);
                    }
                    if (zzj != i18) {
                        throw zzew.zzf();
                    }
                    return zzj;
                }
                if (i5 == 0) {
                    zzdr zzdrVar2 = (zzdr) zzeuVar;
                    int zzm2 = zzdq.zzm(bArr, i12, zzdpVar);
                    zzdrVar2.zze(zzdpVar.zzb != 0);
                    while (zzm2 < i2) {
                        int zzj8 = zzdq.zzj(bArr, zzm2, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzm2;
                        }
                        zzm2 = zzdq.zzm(bArr, zzj8, zzdpVar);
                        zzdrVar2.zze(zzdpVar.zzb != 0);
                    }
                    return zzm2;
                }
                return i12;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int zzj9 = zzdq.zzj(bArr, i12, zzdpVar);
                        int i19 = zzdpVar.zza;
                        if (i19 < 0) {
                            throw zzew.zzc();
                        }
                        if (i19 == 0) {
                            zzeuVar.add("");
                        } else {
                            zzeuVar.add(new String(bArr, zzj9, i19, zzev.zza));
                            zzj9 += i19;
                        }
                        while (zzj9 < i2) {
                            int zzj10 = zzdq.zzj(bArr, zzj9, zzdpVar);
                            if (i3 != zzdpVar.zza) {
                                return zzj9;
                            }
                            zzj9 = zzdq.zzj(bArr, zzj10, zzdpVar);
                            int i20 = zzdpVar.zza;
                            if (i20 < 0) {
                                throw zzew.zzc();
                            }
                            if (i20 == 0) {
                                zzeuVar.add("");
                            } else {
                                zzeuVar.add(new String(bArr, zzj9, i20, zzev.zza));
                                zzj9 += i20;
                            }
                        }
                        return zzj9;
                    }
                    int zzj11 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i21 = zzdpVar.zza;
                    if (i21 < 0) {
                        throw zzew.zzc();
                    }
                    if (i21 == 0) {
                        zzeuVar.add("");
                    } else {
                        int i22 = zzj11 + i21;
                        if (!zzhd.zzd(bArr, zzj11, i22)) {
                            throw zzew.zzb();
                        }
                        zzeuVar.add(new String(bArr, zzj11, i21, zzev.zza));
                        zzj11 = i22;
                    }
                    while (zzj11 < i2) {
                        int zzj12 = zzdq.zzj(bArr, zzj11, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzj11;
                        }
                        zzj11 = zzdq.zzj(bArr, zzj12, zzdpVar);
                        int i23 = zzdpVar.zza;
                        if (i23 < 0) {
                            throw zzew.zzc();
                        }
                        if (i23 == 0) {
                            zzeuVar.add("");
                        } else {
                            int i24 = zzj11 + i23;
                            if (!zzhd.zzd(bArr, zzj11, i24)) {
                                throw zzew.zzb();
                            }
                            zzeuVar.add(new String(bArr, zzj11, i23, zzev.zza));
                            zzj11 = i24;
                        }
                    }
                    return zzj11;
                }
                return i12;
            case 27:
                if (i5 == 2) {
                    return zzdq.zze(zzy(i6), i3, bArr, i, i2, zzeuVar, zzdpVar);
                }
                return i12;
            case 28:
                if (i5 == 2) {
                    int zzj13 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i25 = zzdpVar.zza;
                    if (i25 < 0) {
                        throw zzew.zzc();
                    }
                    if (i25 > bArr.length - zzj13) {
                        throw zzew.zzf();
                    }
                    if (i25 == 0) {
                        zzeuVar.add(zzeb.zzb);
                    } else {
                        zzeuVar.add(zzeb.zzk(bArr, zzj13, i25));
                        zzj13 += i25;
                    }
                    while (zzj13 < i2) {
                        int zzj14 = zzdq.zzj(bArr, zzj13, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzj13;
                        }
                        zzj13 = zzdq.zzj(bArr, zzj14, zzdpVar);
                        int i26 = zzdpVar.zza;
                        if (i26 < 0) {
                            throw zzew.zzc();
                        }
                        if (i26 > bArr.length - zzj13) {
                            throw zzew.zzf();
                        }
                        if (i26 == 0) {
                            zzeuVar.add(zzeb.zzb);
                        } else {
                            zzeuVar.add(zzeb.zzk(bArr, zzj13, i26));
                            zzj13 += i26;
                        }
                    }
                    return zzj13;
                }
                return i12;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        zzj = zzdq.zzl(i3, bArr, i, i2, zzeuVar, zzdpVar);
                    }
                    return i12;
                }
                zzj = zzdq.zzf(bArr, i12, zzeuVar, zzdpVar);
                zzeq zzeqVar = (zzeq) t;
                zzgq zzgqVar = zzeqVar.zzc;
                if (zzgqVar == zzgq.zza()) {
                    zzgqVar = null;
                }
                Object zzd = zzgd.zzd(i4, zzeuVar, zzx(i6), zzgqVar, this.zzm);
                if (zzd != null) {
                    zzeqVar.zzc = (zzgq) zzd;
                    return zzj;
                }
                return zzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzer zzerVar3 = (zzer) zzeuVar;
                    int zzj15 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i27 = zzdpVar.zza + zzj15;
                    while (zzj15 < i27) {
                        zzj15 = zzdq.zzj(bArr, zzj15, zzdpVar);
                        zzerVar3.zze(zzee.zzb(zzdpVar.zza));
                    }
                    if (zzj15 == i27) {
                        return zzj15;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 0) {
                    zzer zzerVar4 = (zzer) zzeuVar;
                    int zzj16 = zzdq.zzj(bArr, i12, zzdpVar);
                    zzerVar4.zze(zzee.zzb(zzdpVar.zza));
                    while (zzj16 < i2) {
                        int zzj17 = zzdq.zzj(bArr, zzj16, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzj16;
                        }
                        zzj16 = zzdq.zzj(bArr, zzj17, zzdpVar);
                        zzerVar4.zze(zzee.zzb(zzdpVar.zza));
                    }
                    return zzj16;
                }
                return i12;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzff zzffVar5 = (zzff) zzeuVar;
                    int zzj18 = zzdq.zzj(bArr, i12, zzdpVar);
                    int i28 = zzdpVar.zza + zzj18;
                    while (zzj18 < i28) {
                        zzj18 = zzdq.zzm(bArr, zzj18, zzdpVar);
                        zzffVar5.zze(zzee.zzc(zzdpVar.zzb));
                    }
                    if (zzj18 == i28) {
                        return zzj18;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 0) {
                    zzff zzffVar6 = (zzff) zzeuVar;
                    int zzm3 = zzdq.zzm(bArr, i12, zzdpVar);
                    zzffVar6.zze(zzee.zzc(zzdpVar.zzb));
                    while (zzm3 < i2) {
                        int zzj19 = zzdq.zzj(bArr, zzm3, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzm3;
                        }
                        zzm3 = zzdq.zzm(bArr, zzj19, zzdpVar);
                        zzffVar6.zze(zzee.zzc(zzdpVar.zzb));
                    }
                    return zzm3;
                }
                return i12;
            default:
                if (i5 == 3) {
                    zzgb zzy = zzy(i6);
                    int i29 = (i3 & (-8)) | 4;
                    int zzc = zzdq.zzc(zzy, bArr, i, i2, i29, zzdpVar);
                    zzeuVar.add(zzdpVar.zzc);
                    while (zzc < i2) {
                        int zzj20 = zzdq.zzj(bArr, zzc, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return zzc;
                        }
                        zzc = zzdq.zzc(zzy, bArr, zzj20, i2, i29, zzdpVar);
                        zzeuVar.add(zzdpVar.zzc);
                    }
                    return zzc;
                }
                return i12;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzr(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzt(int i, int i2) {
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
    private static int zzu(int i) {
        return (i >>> 20) & 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> long zzw(T t, long j) {
        return ((Long) zzgz.zzf(t, j)).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzet zzx(int i) {
        int i2 = i / 3;
        return (zzet) this.zzd[i2 + i2 + 1];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzgb zzy(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgb zzgbVar = (zzgb) this.zzd[i3];
        if (zzgbVar != null) {
            return zzgbVar;
        }
        zzgb<T> zzb2 = zzfy.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final int zza(T t) {
        int i;
        int zzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzv = zzv(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzv;
            int i5 = 37;
            switch (zzu(zzv)) {
                case 0:
                    i = i2 * 53;
                    zzc = zzev.zzc(Double.doubleToLongBits(zzgz.zza(t, j)));
                    i2 = i + zzc;
                    break;
                case 1:
                    i = i2 * 53;
                    zzc = Float.floatToIntBits(zzgz.zzb(t, j));
                    i2 = i + zzc;
                    break;
                case 2:
                    i = i2 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t, j));
                    i2 = i + zzc;
                    break;
                case 3:
                    i = i2 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t, j));
                    i2 = i + zzc;
                    break;
                case 4:
                    i = i2 * 53;
                    zzc = zzgz.zzc(t, j);
                    i2 = i + zzc;
                    break;
                case 5:
                    i = i2 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t, j));
                    i2 = i + zzc;
                    break;
                case 6:
                    i = i2 * 53;
                    zzc = zzgz.zzc(t, j);
                    i2 = i + zzc;
                    break;
                case 7:
                    i = i2 * 53;
                    zzc = zzev.zza(zzgz.zzt(t, j));
                    i2 = i + zzc;
                    break;
                case 8:
                    i = i2 * 53;
                    zzc = ((String) zzgz.zzf(t, j)).hashCode();
                    i2 = i + zzc;
                    break;
                case 9:
                    Object zzf = zzgz.zzf(t, j);
                    if (zzf != null) {
                        i5 = zzf.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zzc = zzgz.zzf(t, j).hashCode();
                    i2 = i + zzc;
                    break;
                case 11:
                    i = i2 * 53;
                    zzc = zzgz.zzc(t, j);
                    i2 = i + zzc;
                    break;
                case 12:
                    i = i2 * 53;
                    zzc = zzgz.zzc(t, j);
                    i2 = i + zzc;
                    break;
                case 13:
                    i = i2 * 53;
                    zzc = zzgz.zzc(t, j);
                    i2 = i + zzc;
                    break;
                case 14:
                    i = i2 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t, j));
                    i2 = i + zzc;
                    break;
                case 15:
                    i = i2 * 53;
                    zzc = zzgz.zzc(t, j);
                    i2 = i + zzc;
                    break;
                case 16:
                    i = i2 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t, j));
                    i2 = i + zzc;
                    break;
                case 17:
                    Object zzf2 = zzgz.zzf(t, j);
                    if (zzf2 != null) {
                        i5 = zzf2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
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
                    i = i2 * 53;
                    zzc = zzgz.zzf(t, j).hashCode();
                    i2 = i + zzc;
                    break;
                case 50:
                    i = i2 * 53;
                    zzc = zzgz.zzf(t, j).hashCode();
                    i2 = i + zzc;
                    break;
                case 51:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zzc(Double.doubleToLongBits(((Double) zzgz.zzf(t, j)).doubleValue()));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = Float.floatToIntBits(((Float) zzgz.zzf(t, j)).floatValue());
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zzc(zzw(t, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zzc(zzw(t, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzl(t, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zzc(zzw(t, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzl(t, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zza(((Boolean) zzgz.zzf(t, j)).booleanValue());
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = ((String) zzgz.zzf(t, j)).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzgz.zzf(t, j).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzgz.zzf(t, j).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzl(t, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzl(t, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzl(t, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zzc(zzw(t, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzl(t, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzev.zzc(zzw(t, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzJ(t, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzgz.zzf(t, j).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return (i2 * 53) + this.zzm.zza(t).hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x0326, code lost:
    
        if (r0 != r2) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0328, code lost:
    
        r15 = r28;
        r14 = r29;
        r12 = r30;
        r13 = r32;
        r11 = r33;
        r9 = r34;
        r1 = r17;
        r2 = r19;
        r3 = r20;
        r5 = r22;
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0340, code lost:
    
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0368, code lost:
    
        if (r0 != r15) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x038c, code lost:
    
        if (r0 != r15) goto L111;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x008a. Please report as an issue. */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzb(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.auth.zzdp r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdp):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final T zzd() {
        return (T) ((zzeq) this.zzg).zzj(4, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zze(T t) {
        int i;
        int i2 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i2 >= i) {
                break;
            }
            long zzv = zzv(this.zzi[i2]) & 1048575;
            Object zzf = zzgz.zzf(t, zzv);
            if (zzf != null) {
                ((zzfk) zzf).zzc();
                zzgz.zzp(t, zzv, zzf);
            }
            i2++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(t, this.zzi[i]);
            i++;
        }
        this.zzm.zze(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzg(T t, byte[] bArr, int i, int i2, zzdp zzdpVar) throws IOException {
        if (this.zzh) {
            zzo(t, bArr, i, i2, zzdpVar);
        } else {
            zzb(t, bArr, i, i2, 0, zzdpVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzh(T t, T t2) {
        boolean zzh;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzv = zzv(i);
            long j = zzv & 1048575;
            switch (zzu(zzv)) {
                case 0:
                    if (zzF(t, t2, i) && Double.doubleToLongBits(zzgz.zza(t, j)) == Double.doubleToLongBits(zzgz.zza(t2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzF(t, t2, i) && Float.floatToIntBits(zzgz.zzb(t, j)) == Float.floatToIntBits(zzgz.zzb(t2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzF(t, t2, i) && zzgz.zzt(t, j) == zzgz.zzt(t2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
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
                    zzh = zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j));
                    break;
                case 50:
                    zzh = zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j));
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
                    long zzs = zzs(i) & 1048575;
                    if (zzgz.zzc(t, zzs) == zzgz.zzc(t2, zzs) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzh) {
                return false;
            }
        }
        return this.zzm.zza(t).equals(this.zzm.zza(t2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzi(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzj) {
            int i6 = this.zzi[i5];
            int i7 = this.zzc[i6];
            int zzv = zzv(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if ((268435456 & zzv) != 0 && !zzH(t, i6, i, i2, i10)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu == 60 || zzu == 68) {
                        if (zzJ(t, i7, i6) && !zzI(t, zzv, zzy(i6))) {
                            return false;
                        }
                    } else if (zzu != 49) {
                        if (zzu == 50 && !((zzfk) zzgz.zzf(t, zzv & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzgz.zzf(t, zzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgb zzy = zzy(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzy.zzi(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzH(t, i6, i, i2, i10) && !zzI(t, zzv, zzy(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzf(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzv = zzv(i);
            long j = 1048575 & zzv;
            int i2 = this.zzc[i];
            switch (zzu(zzv)) {
                case 0:
                    if (zzG(t2, i)) {
                        zzgz.zzl(t, j, zzgz.zza(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzG(t2, i)) {
                        zzgz.zzm(t, j, zzgz.zzb(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzG(t2, i)) {
                        zzgz.zzk(t, j, zzgz.zzt(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzG(t2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(t, t2, i);
                    break;
                case 10:
                    if (zzG(t2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(t, t2, i);
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
                    this.zzl.zzb(t, t2, j);
                    break;
                case 50:
                    zzgd.zzi(this.zzp, t, t2, j);
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
                    if (zzJ(t2, i2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzE(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzJ(t2, i2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzE(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(t, t2, i);
                    break;
            }
        }
        zzgd.zzf(this.zzm, t, t2);
    }
}
