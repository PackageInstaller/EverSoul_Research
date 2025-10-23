package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjz extends zzka {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzmo.zze(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzka
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzjy zzjyVar;
        List<L> arrayList;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzjx) {
                arrayList = new zzjy(i);
            } else if ((zzc instanceof zzld) && (zzc instanceof zzjn)) {
                arrayList = ((zzjn) zzc).zza(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzmo.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(zzc.size() + i);
            arrayList2.addAll(zzc);
            zzmo.zza(obj, j, arrayList2);
            zzjyVar = arrayList2;
        } else if (zzc instanceof zzmj) {
            zzjy zzjyVar2 = new zzjy(zzc.size() + i);
            zzjyVar2.addAll((zzmj) zzc);
            zzmo.zza(obj, j, zzjyVar2);
            zzjyVar = zzjyVar2;
        } else {
            if (!(zzc instanceof zzld) || !(zzc instanceof zzjn)) {
                return zzc;
            }
            zzjn zzjnVar = (zzjn) zzc;
            if (zzjnVar.zzc()) {
                return zzc;
            }
            zzjn zza2 = zzjnVar.zza(zzc.size() + i);
            zzmo.zza(obj, j, zza2);
            return zza2;
        }
        return zzjyVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjz() {
        super();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzka
    final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzmo.zze(obj, j);
        if (list instanceof zzjx) {
            unmodifiableList = ((zzjx) list).mo172h_();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzld) && (list instanceof zzjn)) {
                zzjn zzjnVar = (zzjn) list;
                if (zzjnVar.zzc()) {
                    zzjnVar.mo171i_();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzmo.zza(obj, j, unmodifiableList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzka
    final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzmo.zza(obj, j, zzc);
    }
}
