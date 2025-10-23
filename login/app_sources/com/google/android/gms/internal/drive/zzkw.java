package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzkw<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zztg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzkw(Iterator<Map.Entry<K, Object>> it) {
        this.zztg = it;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zztg.hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final void remove() {
        this.zztg.remove();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zztg.next();
        return next.getValue() instanceof zzkt ? new zzkv(next) : next;
    }
}
