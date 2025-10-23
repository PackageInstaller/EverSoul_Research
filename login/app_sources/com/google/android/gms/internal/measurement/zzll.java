package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzll {
    private static final Class<?> zza = zzd();
    private static final zzmi<?, ?> zzb = zzc();
    private static final zzmi<?, ?> zzc = new zzmk();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzio.zzb(i, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(List<?> list) {
        return list.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, List<zzhu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzi = size * zzio.zzi(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzi += zzio.zzb(list.get(i2));
        }
        return zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzji) {
            zzji zzjiVar = (zzji) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzd(zzjiVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzd(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzio.zzf(i, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzio.zzc(i, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, List<zzkr> list, zzlj zzljVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzio.zzb(i, list.get(i3), zzljVar);
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzji) {
            zzji zzjiVar = (zzji) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzf(zzjiVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzd(zzkgVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, Object obj, zzlj zzljVar) {
        if (obj instanceof zzjv) {
            return zzio.zzb(i, (zzjv) obj);
        }
        return zzio.zzc(i, (zzkr) obj, zzljVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(int i, List<?> list, zzlj zzljVar) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzi = zzio.zzi(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzjv) {
                zza2 = zzio.zza((zzjv) obj);
            } else {
                zza2 = zzio.zza((zzkr) obj, zzljVar);
            }
            zzi += zza2;
        }
        return zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzji) {
            zzji zzjiVar = (zzji) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzh(zzjiVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzh(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzf(zzkgVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(int i, List<?> list) {
        int zzb2;
        int zzb3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzi = zzio.zzi(i) * size;
        if (list instanceof zzjx) {
            zzjx zzjxVar = (zzjx) list;
            while (i2 < size) {
                Object zzb4 = zzjxVar.zzb(i2);
                if (zzb4 instanceof zzhu) {
                    zzb3 = zzio.zzb((zzhu) zzb4);
                } else {
                    zzb3 = zzio.zzb((String) zzb4);
                }
                zzi += zzb3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzhu) {
                    zzb2 = zzio.zzb((zzhu) obj);
                } else {
                    zzb2 = zzio.zzb((String) obj);
                }
                zzi += zzb2;
                i2++;
            }
        }
        return zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzji) {
            zzji zzjiVar = (zzji) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzj(zzjiVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzio.zzi(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzj(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            i = 0;
            while (i2 < size) {
                i += zzio.zzg(zzkgVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzio.zzg(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzmi<?, ?> zzc() {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzmi) zze.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzmi<?, ?> zza() {
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzmi<?, ?> zzb() {
        return zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzjm zzjmVar, UB ub, zzmi<UT, UB> zzmiVar) {
        if (zzjmVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzjmVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, intValue, ub, zzmiVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzjmVar.zza(intValue2)) {
                    ub = (UB) zza(obj, i, intValue2, ub, zzmiVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzmi<UT, UB> zzmiVar) {
        if (ub == null) {
            ub = zzmiVar.zzc(obj);
        }
        zzmiVar.zzb(ub, i, i2);
        return ub;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T, FT extends zzja<FT>> void zza(zziu<FT> zziuVar, T t, T t2) {
        zziy<FT> zza2 = zziuVar.zza(t2);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zziuVar.zzb(t).zza(zza2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> void zza(zzko zzkoVar, T t, T t2, long j) {
        zzmo.zza(t, j, zzkoVar.zza(zzmo.zze(t, j), zzmo.zze(t2, j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T, UT, UB> void zza(zzmi<UT, UB> zzmiVar, T t, T t2) {
        zzmiVar.zzc(t, zzmiVar.zza(zzmiVar.zzd(t), zzmiVar.zzd(t2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzjf.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(int i, List<Boolean> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zza(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(int i, List<zzhu> list, zzne zzneVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zza(i, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(int i, List<Double> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzb(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(int i, List<Integer> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzc(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzd(int i, List<Integer> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzd(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zze(int i, List<Long> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zze(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzf(int i, List<Float> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzf(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(int i, List<?> list, zzne zzneVar, zzlj zzljVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zza(i, list, zzljVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzg(int i, List<Integer> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzg(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzh(int i, List<Long> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzh(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(int i, List<?> list, zzne zzneVar, zzlj zzljVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzb(i, list, zzljVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzi(int i, List<Integer> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzi(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzj(int i, List<Long> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzj(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzk(int i, List<Integer> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzk(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzl(int i, List<Long> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzl(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(int i, List<String> list, zzne zzneVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzb(i, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzm(int i, List<Integer> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzm(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzn(int i, List<Long> list, zzne zzneVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzneVar.zzn(i, list, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
