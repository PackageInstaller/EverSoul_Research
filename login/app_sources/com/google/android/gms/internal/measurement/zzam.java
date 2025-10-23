package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzam implements Iterator<zzaq> {
    private final /* synthetic */ Iterator zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        return new zzas((String) this.zza.next());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzam(Iterator it) {
        this.zza = it;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
