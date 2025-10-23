package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzbc implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzaz zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbc(zzaz zzazVar) {
        Bundle bundle;
        this.zzb = zzazVar;
        bundle = zzazVar.zza;
        this.zza = bundle.keySet().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
