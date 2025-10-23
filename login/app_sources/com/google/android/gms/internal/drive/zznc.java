package com.google.android.gms.internal.drive;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class zznc implements Iterator<String> {
    private final /* synthetic */ zzna zzvw;
    private Iterator<String> zzvx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zznc(zzna zznaVar) {
        zzkz zzkzVar;
        this.zzvw = zznaVar;
        zzkzVar = zznaVar.zzvt;
        this.zzvx = zzkzVar.iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzvx.hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzvx.next();
    }
}
