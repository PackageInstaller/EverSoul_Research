package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzkb<FieldDescriptorType extends zzkd<FieldDescriptorType>> {
    private static final zzkb zzov = new zzkb(true);
    private boolean zzot;
    private boolean zzou = false;
    final zzmi<FieldDescriptorType, Object> zzos = zzmi.zzav(16);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkb() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkb(boolean z) {
        zzbp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends zzkd<T>> zzkb<T> zzcn() {
        return zzov;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzbp() {
        if (this.zzot) {
            return;
        }
        this.zzos.zzbp();
        this.zzot = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isImmutable() {
        return this.zzot;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkb) {
            return this.zzos.equals(((zzkb) obj).zzos);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.zzos.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzou) {
            return new zzkw(this.zzos.entrySet().iterator());
        }
        return this.zzos.entrySet().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzou) {
            return new zzkw(this.zzos.zzet().iterator());
        }
        return this.zzos.zzet().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzos.get(fielddescriptortype);
        return obj instanceof zzkt ? zzkt.zzdp() : obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzcs()) {
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
                zza(fielddescriptortype.zzcq(), obj2);
            }
            obj = arrayList;
        } else {
            zza(fielddescriptortype.zzcq(), obj);
        }
        if (obj instanceof zzkt) {
            this.zzou = true;
        }
        this.zzos.zza((zzmi<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.drive.zzkn) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.drive.zzkt) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.drive.zznm r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.drive.zzkm.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.drive.zzkc.zzow
            com.google.android.gms.internal.drive.zznr r2 = r2.zzfj()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L41;
                case 2: goto L3e;
                case 3: goto L3b;
                case 4: goto L38;
                case 5: goto L35;
                case 6: goto L32;
                case 7: goto L29;
                case 8: goto L20;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzlq
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzkt
            if (r2 == 0) goto L1e
            goto L43
        L1e:
            r0 = r1
            goto L43
        L20:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzkn
            if (r2 == 0) goto L1e
            goto L43
        L29:
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzjc
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1e
            goto L43
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            r1 = r0
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
            fill-array 0x0066: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzkb.zza(com.google.android.gms.internal.drive.zznm, java.lang.Object):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isInitialized() {
        for (int i = 0; i < this.zzos.zzer(); i++) {
            if (!zzb(this.zzos.zzaw(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            if (!zzb(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzcr() == zznr.MESSAGE) {
            if (key.zzcs()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzlq) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzlq) {
                    if (!((zzlq) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzkt) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzkb<FieldDescriptorType> zzkbVar) {
        for (int i = 0; i < zzkbVar.zzos.zzer(); i++) {
            zzc(zzkbVar.zzos.zzaw(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = zzkbVar.zzos.zzes().iterator();
        while (it.hasNext()) {
            zzc(it.next());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object zze(Object obj) {
        if (obj instanceof zzlx) {
            return ((zzlx) obj).zzef();
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
    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzlq zzdf;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzkt) {
            value = zzkt.zzdp();
        }
        if (key.zzcs()) {
            Object zza = zza((zzkb<FieldDescriptorType>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zza).add(zze(it.next()));
            }
            this.zzos.zza((zzmi<FieldDescriptorType, Object>) key, (FieldDescriptorType) zza);
            return;
        }
        if (key.zzcr() == zznr.MESSAGE) {
            Object zza2 = zza((zzkb<FieldDescriptorType>) key);
            if (zza2 == null) {
                this.zzos.zza((zzmi<FieldDescriptorType, Object>) key, (FieldDescriptorType) zze(value));
                return;
            }
            if (zza2 instanceof zzlx) {
                zzdf = key.zza((zzlx) zza2, (zzlx) value);
            } else {
                zzdf = key.zza(((zzlq) zza2).zzcy(), (zzlq) value).zzdf();
            }
            this.zzos.zza((zzmi<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzdf);
            return;
        }
        this.zzos.zza((zzmi<FieldDescriptorType, Object>) key, (FieldDescriptorType) zze(value));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(zzjr zzjrVar, zznm zznmVar, int i, Object obj) throws IOException {
        if (zznmVar == zznm.zzxd) {
            zzlq zzlqVar = (zzlq) obj;
            zzkm.zzf(zzlqVar);
            zzjrVar.zzb(i, 3);
            zzlqVar.zzb(zzjrVar);
            zzjrVar.zzb(i, 4);
        }
        zzjrVar.zzb(i, zznmVar.zzfk());
        switch (zzkc.zzox[zznmVar.ordinal()]) {
            case 1:
                zzjrVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzjrVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzjrVar.zzl(((Long) obj).longValue());
                break;
            case 4:
                zzjrVar.zzl(((Long) obj).longValue());
                break;
            case 5:
                zzjrVar.zzx(((Integer) obj).intValue());
                break;
            case 6:
                zzjrVar.zzn(((Long) obj).longValue());
                break;
            case 7:
                zzjrVar.zzaa(((Integer) obj).intValue());
                break;
            case 8:
                zzjrVar.zzc(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzlq) obj).zzb(zzjrVar);
                break;
            case 10:
                zzjrVar.zzb((zzlq) obj);
                break;
            case 11:
                if (obj instanceof zzjc) {
                    zzjrVar.zza((zzjc) obj);
                    break;
                } else {
                    zzjrVar.zzl((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzjc) {
                    zzjrVar.zza((zzjc) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzjrVar.zzd(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzjrVar.zzy(((Integer) obj).intValue());
                break;
            case 14:
                zzjrVar.zzaa(((Integer) obj).intValue());
                break;
            case 15:
                zzjrVar.zzn(((Long) obj).longValue());
                break;
            case 16:
                zzjrVar.zzz(((Integer) obj).intValue());
                break;
            case 17:
                zzjrVar.zzm(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzkn) {
                    zzjrVar.zzx(((zzkn) obj).zzcp());
                    break;
                } else {
                    zzjrVar.zzx(((Integer) obj).intValue());
                    break;
                }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzco() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzos.zzer(); i2++) {
            i += zzd(this.zzos.zzaw(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            i += zzd(it.next());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzcr() == zznr.MESSAGE && !key.zzcs() && !key.zzct()) {
            if (value instanceof zzkt) {
                return zzjr.zzb(entry.getKey().zzcp(), (zzkt) value);
            }
            return zzjr.zzb(entry.getKey().zzcp(), (zzlq) value);
        }
        return zzb((zzkd<?>) key, value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(zznm zznmVar, int i, Object obj) {
        int zzab = zzjr.zzab(i);
        if (zznmVar == zznm.zzxd) {
            zzkm.zzf((zzlq) obj);
            zzab <<= 1;
        }
        return zzab + zzb(zznmVar, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzb(zznm zznmVar, Object obj) {
        switch (zzkc.zzox[zznmVar.ordinal()]) {
            case 1:
                return zzjr.zzb(((Double) obj).doubleValue());
            case 2:
                return zzjr.zzb(((Float) obj).floatValue());
            case 3:
                return zzjr.zzo(((Long) obj).longValue());
            case 4:
                return zzjr.zzp(((Long) obj).longValue());
            case 5:
                return zzjr.zzac(((Integer) obj).intValue());
            case 6:
                return zzjr.zzr(((Long) obj).longValue());
            case 7:
                return zzjr.zzaf(((Integer) obj).intValue());
            case 8:
                return zzjr.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzjr.zzd((zzlq) obj);
            case 10:
                if (obj instanceof zzkt) {
                    return zzjr.zza((zzkt) obj);
                }
                return zzjr.zzc((zzlq) obj);
            case 11:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzm((String) obj);
            case 12:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzc((byte[]) obj);
            case 13:
                return zzjr.zzad(((Integer) obj).intValue());
            case 14:
                return zzjr.zzag(((Integer) obj).intValue());
            case 15:
                return zzjr.zzs(((Long) obj).longValue());
            case 16:
                return zzjr.zzae(((Integer) obj).intValue());
            case 17:
                return zzjr.zzq(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzkn) {
                    return zzjr.zzah(((zzkn) obj).zzcp());
                }
                return zzjr.zzah(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(zzkd<?> zzkdVar, Object obj) {
        zznm zzcq = zzkdVar.zzcq();
        int zzcp = zzkdVar.zzcp();
        if (zzkdVar.zzcs()) {
            int i = 0;
            if (zzkdVar.zzct()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += zzb(zzcq, it.next());
                }
                return zzjr.zzab(zzcp) + i + zzjr.zzaj(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += zza(zzcq, zzcp, it2.next());
            }
            return i;
        }
        return zza(zzcq, zzcp, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzkb zzkbVar = new zzkb();
        for (int i = 0; i < this.zzos.zzer(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzaw = this.zzos.zzaw(i);
            zzkbVar.zza((zzkb) zzaw.getKey(), zzaw.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzos.zzes()) {
            zzkbVar.zza((zzkb) entry.getKey(), entry.getValue());
        }
        zzkbVar.zzou = this.zzou;
        return zzkbVar;
    }
}
