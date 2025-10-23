package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzel<T extends zzek<T>> {
    private static final zzel zzb = new zzel(true);
    final zzgl<T, Object> zza = new zzge(16);
    private boolean zzc;
    private boolean zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzel() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends zzek<T>> zzel<T> zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(T r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.auth.zzhe r0 = r4.zzb()
            com.google.android.gms.internal.auth.zzev.zze(r5)
            com.google.android.gms.internal.auth.zzhe r1 = com.google.android.gms.internal.auth.zzhe.DOUBLE
            com.google.android.gms.internal.auth.zzhf r1 = com.google.android.gms.internal.auth.zzhf.INT
            com.google.android.gms.internal.auth.zzhf r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.android.gms.internal.auth.zzfq
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.auth.zzex
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.auth.zzes
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.android.gms.internal.auth.zzeb
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r2 = r4.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            com.google.android.gms.internal.auth.zzhe r4 = r4.zzb()
            com.google.android.gms.internal.auth.zzhf r4 = r4.zza()
            r2 = 1
            r1[r2] = r4
            java.lang.Class r4 = r5.getClass()
            java.lang.String r4 = r4.getName()
            r5 = 2
            r1[r5] = r4
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
            fill-array 0x008c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzel.zzd(com.google.android.gms.internal.auth.zzek, java.lang.Object):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzel zzelVar = new zzel();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<T, Object> zzg = this.zza.zzg(i);
            zzelVar.zzc(zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            zzelVar.zzc(entry.getKey(), entry.getValue());
        }
        zzelVar.zzd = this.zzd;
        return zzelVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzel) {
            return this.zza.equals(((zzel) obj).zza);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb() {
        if (this.zzc) {
            return;
        }
        this.zza.zza();
        this.zzc = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzex) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzel(boolean z) {
        zzb();
        zzb();
    }
}
