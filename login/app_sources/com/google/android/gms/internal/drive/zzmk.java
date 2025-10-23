package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class zzmk<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzvj;
    private final /* synthetic */ zzmi zzvk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzmk(zzmi zzmiVar) {
        List list;
        this.zzvk = zzmiVar;
        list = zzmiVar.zzve;
        this.pos = list.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.pos;
        if (i > 0) {
            list = this.zzvk.zzve;
            if (i <= list.size()) {
                return true;
            }
        }
        return zzew().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Iterator<Map.Entry<K, V>> zzew() {
        Map map;
        if (this.zzvj == null) {
            map = this.zzvk.zzvh;
            this.zzvj = map.entrySet().iterator();
        }
        return this.zzvj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (zzew().hasNext()) {
            return zzew().next();
        }
        list = this.zzvk.zzve;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzmk(zzmi zzmiVar, zzmj zzmjVar) {
        this(zzmiVar);
    }
}
