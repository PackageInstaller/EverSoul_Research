package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
final class zzab implements Continuation {
    final /* synthetic */ Collection zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzab(Collection collection) {
        this.zza = collection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zza);
        return Tasks.forResult(arrayList);
    }
}
