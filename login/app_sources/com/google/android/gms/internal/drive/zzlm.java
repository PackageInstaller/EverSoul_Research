package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzlm implements zzll {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlm() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final Map<?, ?> zzh(Object obj) {
        return (zzlk) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final zzlj<?, ?> zzm(Object obj) {
        throw new NoSuchMethodError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final Map<?, ?> zzi(Object obj) {
        return (zzlk) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final boolean zzj(Object obj) {
        return !((zzlk) obj).isMutable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final Object zzk(Object obj) {
        ((zzlk) obj).zzbp();
        return obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final Object zzl(Object obj) {
        return zzlk.zzdw().zzdx();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final Object zzb(Object obj, Object obj2) {
        zzlk zzlkVar = (zzlk) obj;
        zzlk zzlkVar2 = (zzlk) obj2;
        if (!zzlkVar2.isEmpty()) {
            if (!zzlkVar.isMutable()) {
                zzlkVar = zzlkVar.zzdx();
            }
            zzlkVar.zza(zzlkVar2);
        }
        return zzlkVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzll
    public final int zzb(int i, Object obj, Object obj2) {
        zzlk zzlkVar = (zzlk) obj;
        if (zzlkVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlkVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
