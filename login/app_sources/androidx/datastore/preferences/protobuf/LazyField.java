package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.defaultInstance = messageLite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.LazyFieldLite
    public boolean containsDefaultInstance() {
        return super.containsDefaultInstance() || this.value == this.defaultInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.LazyFieldLite
    public int hashCode() {
        return getValue().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return getValue().toString();
    }

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LazyEntry(Map.Entry<K, LazyField> entry) {
            this.entry = entry;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LazyField getField() {
            return this.entry.getValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (!(obj instanceof MessageLite)) {
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            }
            return this.entry.getValue().setValue((MessageLite) obj);
        }
    }

    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.iterator = it;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.iterator.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next) : next;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }
}
