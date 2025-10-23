package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfc extends zzfe {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfc() {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzfc(zzfb zzfbVar) {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfe
    final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzgz.zzf(obj, j);
        if (list instanceof zzfa) {
            unmodifiableList = ((zzfa) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzfx) && (list instanceof zzeu)) {
                zzeu zzeuVar = (zzeu) list;
                if (zzeuVar.zzc()) {
                    zzeuVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzgz.zzp(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfe
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzez zzezVar;
        List list = (List) zzgz.zzf(obj2, j);
        int size = list.size();
        List list2 = (List) zzgz.zzf(obj, j);
        if (list2.isEmpty()) {
            list2 = list2 instanceof zzfa ? new zzez(size) : ((list2 instanceof zzfx) && (list2 instanceof zzeu)) ? ((zzeu) list2).zzd(size) : new ArrayList(size);
            zzgz.zzp(obj, j, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzgz.zzp(obj, j, arrayList);
                zzezVar = arrayList;
            } else if (list2 instanceof zzgu) {
                zzez zzezVar2 = new zzez(list2.size() + size);
                zzezVar2.addAll(zzezVar2.size(), (zzgu) list2);
                zzgz.zzp(obj, j, zzezVar2);
                zzezVar = zzezVar2;
            } else if ((list2 instanceof zzfx) && (list2 instanceof zzeu)) {
                zzeu zzeuVar = (zzeu) list2;
                if (!zzeuVar.zzc()) {
                    list2 = zzeuVar.zzd(list2.size() + size);
                    zzgz.zzp(obj, j, list2);
                }
            }
            list2 = zzezVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzgz.zzp(obj, j, list);
    }
}
