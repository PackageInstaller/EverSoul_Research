package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzja;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zziy<T extends zzja<T>> {
    private static final zziy zzb = new zziy(true);
    final zzlo<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(zzmv zzmvVar, int i, Object obj) {
        int zzi = zzio.zzi(i);
        if (zzmvVar == zzmv.zzj) {
            zzjh.zza((zzkr) obj);
            zzi <<= 1;
        }
        return zzi + zza(zzmvVar, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zza(zzmv zzmvVar, Object obj) {
        switch (zzix.zzb[zzmvVar.ordinal()]) {
            case 1:
                return zzio.zza(((Double) obj).doubleValue());
            case 2:
                return zzio.zza(((Float) obj).floatValue());
            case 3:
                return zzio.zzd(((Long) obj).longValue());
            case 4:
                return zzio.zzg(((Long) obj).longValue());
            case 5:
                return zzio.zzf(((Integer) obj).intValue());
            case 6:
                return zzio.zzc(((Long) obj).longValue());
            case 7:
                return zzio.zze(((Integer) obj).intValue());
            case 8:
                return zzio.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzio.zzb((zzkr) obj);
            case 10:
                if (obj instanceof zzjr) {
                    return zzio.zza((zzjr) obj);
                }
                return zzio.zzc((zzkr) obj);
            case 11:
                if (obj instanceof zzhu) {
                    return zzio.zzb((zzhu) obj);
                }
                return zzio.zzb((String) obj);
            case 12:
                if (obj instanceof zzhu) {
                    return zzio.zzb((zzhu) obj);
                }
                return zzio.zza((byte[]) obj);
            case 13:
                return zzio.zzj(((Integer) obj).intValue());
            case 14:
                return zzio.zzg(((Integer) obj).intValue());
            case 15:
                return zzio.zze(((Long) obj).longValue());
            case 16:
                return zzio.zzh(((Integer) obj).intValue());
            case 17:
                return zzio.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzjk) {
                    return zzio.zzd(((zzjk) obj).zza());
                }
                return zzio.zzd(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(zzja<?> zzjaVar, Object obj) {
        zzmv zzb2 = zzjaVar.zzb();
        int zza = zzjaVar.zza();
        if (zzjaVar.zze()) {
            List list = (List) obj;
            int i = 0;
            if (zzjaVar.zzd()) {
                if (list.isEmpty()) {
                    return 0;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i += zza(zzb2, it.next());
                }
                return zzio.zzi(zza) + i + zzio.zzj(i);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                i += zza(zzb2, zza, it2.next());
            }
            return i;
        }
        return zza(zzb2, zza, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zza((Map.Entry) this.zza.zzb(i2));
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i += zza((Map.Entry) it.next());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zznf.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzjr) {
                return zzio.zza(entry.getKey().zza(), (zzjr) value);
            }
            return zzio.zzb(entry.getKey().zza(), (zzkr) value);
        }
        return zza((zzja<?>) key, value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends zzja<T>> zziy<T> zzb() {
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zziy zziyVar = new zziy();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zziyVar.zzb(zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            zziyVar.zzb(entry.getKey(), entry.getValue());
        }
        zziyVar.zzd = this.zzd;
        return zziyVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object zza(Object obj) {
        if (obj instanceof zzla) {
            return ((zzla) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzjr)) {
            return obj;
        }
        return zzjr.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zzd) {
            return new zzjw(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzd) {
            return new zzjw(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zziy() {
        this.zza = zzlo.zza(16);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zziy(zzlo<T, Object> zzloVar) {
        this.zza = zzloVar;
        zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zziy(boolean z) {
        this(zzlo.zza(0));
        zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zze() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            if (zzb2.getValue() instanceof zzjf) {
                ((zzjf) zzb2.getValue()).zzcg();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zziy<T> zziyVar) {
        for (int i = 0; i < zziyVar.zza.zzb(); i++) {
            zzb((Map.Entry) zziyVar.zza.zzb(i));
        }
        Iterator<Map.Entry<T, Object>> it = zziyVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzb(Map.Entry<T, Object> entry) {
        zzkr zzah;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzjr;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zza = zza((zziy<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zza).add(zza(it.next()));
            }
            this.zza.zza((zzlo<T, Object>) key, (T) zza);
            return;
        }
        if (key.zzc() != zznf.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.zza((zzlo<T, Object>) key, (T) zza(value));
            return;
        }
        Object zza2 = zza((zziy<T>) key);
        if (zza2 == null) {
            this.zza.zza((zzlo<T, Object>) key, (T) zza(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            value = zzjr.zza();
        }
        if (zza2 instanceof zzla) {
            zzah = key.zza((zzla) zza2, (zzla) value);
        } else {
            zzah = key.zza(((zzkr) zza2).zzce(), (zzkr) value).zzah();
        }
        this.zza.zza((zzlo<T, Object>) key, (T) zzah);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzb(T t, Object obj) {
        if (t.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zzc(t, obj2);
            }
            obj = arrayList;
        } else {
            zzc(t, obj);
        }
        if (obj instanceof zzjr) {
            this.zzd = true;
        }
        this.zza.zza((zzlo<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzjr) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzjk) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if ((r6 instanceof byte[]) == false) goto L4;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.measurement.zzmv r0 = r5.zzb()
            com.google.android.gms.internal.measurement.zzjh.zza(r6)
            int[] r1 = com.google.android.gms.internal.measurement.zzix.zza
            com.google.android.gms.internal.measurement.zznf r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = r2
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzkr
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzjr
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzjk
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzhu
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
        L34:
            r0 = r1
            goto L47
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.measurement.zzmv r5 = r5.zzb()
            com.google.android.gms.internal.measurement.zznf r5 = r5.zzb()
            r3[r1] = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r6 = 2
            r3[r6] = r5
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
            fill-array 0x008e: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziy.zzc(com.google.android.gms.internal.measurement.zzja, java.lang.Object):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(zzio zzioVar, zzmv zzmvVar, int i, Object obj) throws IOException {
        if (zzmvVar == zzmv.zzj) {
            zzkr zzkrVar = (zzkr) obj;
            zzjh.zza(zzkrVar);
            zzioVar.zzc(i, 3);
            zzkrVar.zza(zzioVar);
            zzioVar.zzc(i, 4);
        }
        zzioVar.zzc(i, zzmvVar.zza());
        switch (zzix.zzb[zzmvVar.ordinal()]) {
            case 1:
                zzioVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzioVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzioVar.zzb(((Long) obj).longValue());
                break;
            case 4:
                zzioVar.zzb(((Long) obj).longValue());
                break;
            case 5:
                zzioVar.zzb(((Integer) obj).intValue());
                break;
            case 6:
                zzioVar.zza(((Long) obj).longValue());
                break;
            case 7:
                zzioVar.zza(((Integer) obj).intValue());
                break;
            case 8:
                zzioVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzkr) obj).zza(zzioVar);
                break;
            case 10:
                zzioVar.zza((zzkr) obj);
                break;
            case 11:
                if (obj instanceof zzhu) {
                    zzioVar.zza((zzhu) obj);
                    break;
                } else {
                    zzioVar.zza((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzhu) {
                    zzioVar.zza((zzhu) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzioVar.zzb(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzioVar.zzc(((Integer) obj).intValue());
                break;
            case 14:
                zzioVar.zza(((Integer) obj).intValue());
                break;
            case 15:
                zzioVar.zza(((Long) obj).longValue());
                break;
            case 16:
                zzioVar.zzk(((Integer) obj).intValue());
                break;
            case 17:
                zzioVar.zzh(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzjk) {
                    zzioVar.zzb(((zzjk) obj).zza());
                    break;
                } else {
                    zzioVar.zzb(((Integer) obj).intValue());
                    break;
                }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zziy) {
            return this.zza.equals(((zziy) obj).zza);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzf() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzg() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzc(this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzc(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T extends zzja<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zznf.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                if (!zzb(it.next())) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzb(Object obj) {
        if (obj instanceof zzkt) {
            return ((zzkt) obj).zzci();
        }
        if (obj instanceof zzjr) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
