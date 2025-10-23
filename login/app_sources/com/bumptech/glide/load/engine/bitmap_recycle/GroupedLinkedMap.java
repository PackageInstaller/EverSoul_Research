package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.liapp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head = new LinkedEntry<>();
    private final Map<K, LinkedEntry<K, V>> keyToEntry = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GroupedLinkedMap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void put(K k, V v) {
        LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k);
            makeTail(linkedEntry);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        linkedEntry.add(v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public V get(K k) {
        LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        makeHead(linkedEntry);
        return linkedEntry.removeLast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public V removeLast() {
        for (LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
            V v = (V) linkedEntry.removeLast();
            if (v != null) {
                return v;
            }
            removeEntry(linkedEntry);
            this.keyToEntry.remove(linkedEntry.key);
            ((Poolable) linkedEntry.key).offer();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(y.֬ڱܱײٮ(-1159296239));
        LinkedEntry linkedEntry = this.head.next;
        boolean z = false;
        while (!linkedEntry.equals(this.head)) {
            sb.append('{').append(linkedEntry.key).append(':').append(linkedEntry.size()).append(y.ݮڮֲڭܩ(-628956516));
            linkedEntry = linkedEntry.next;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(y.ۮڭڭܬި(862109635)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void makeHead(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.prev = this.head;
        linkedEntry.next = this.head.next;
        updateEntry(linkedEntry);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void makeTail(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.prev = this.head.prev;
        linkedEntry.next = this.head;
        updateEntry(linkedEntry);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <K, V> void updateEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.next.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.prev.next = linkedEntry.next;
        linkedEntry.next.prev = linkedEntry.prev;
    }

    private static class LinkedEntry<K, V> {
        final K key;
        LinkedEntry<K, V> next;
        LinkedEntry<K, V> prev;
        private List<V> values;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LinkedEntry() {
            this(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LinkedEntry(K k) {
            this.prev = this;
            this.next = this;
            this.key = k;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public V removeLast() {
            int size = size();
            if (size > 0) {
                return this.values.remove(size - 1);
            }
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int size() {
            List<V> list = this.values;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void add(V v) {
            if (this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(v);
        }
    }
}
