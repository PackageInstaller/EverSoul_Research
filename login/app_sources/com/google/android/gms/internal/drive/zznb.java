package com.google.android.gms.internal.drive;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class zznb implements ListIterator<String> {
    private ListIterator<String> zzvu;
    private final /* synthetic */ int zzvv;
    private final /* synthetic */ zzna zzvw;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zznb(zzna zznaVar, int i) {
        zzkz zzkzVar;
        this.zzvw = zznaVar;
        this.zzvv = i;
        zzkzVar = zznaVar.zzvt;
        this.zzvu = zzkzVar.listIterator(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzvu.hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzvu.hasPrevious();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzvu.nextIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzvu.previousIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzvu.previous();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzvu.next();
    }
}
