package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LruArrayPool(int i) {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(key.size));
            Integer valueOf = Integer.valueOf(key.size);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, Class<T> cls) {
        return (T) getForKey(this.keyPool.get(i, cls), cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, Class<T> cls) {
        Key key;
        Integer ceilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i));
        if (mayFillRequest(i, ceilingKey)) {
            key = this.keyPool.get(ceilingKey.intValue(), cls);
        } else {
            key = this.keyPool.get(i, cls);
        }
        return (T) getForKey(key, cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> T getForKey(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T t = (T) getArrayForKey(key);
        if (t != null) {
            this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(adapterFromType.getTag(), 2)) {
            Log.v(adapterFromType.getTag(), y.ݮڮֲڭܩ(-628955484) + key.size + y.ٲٴݴ״ٰ(1781557784));
        }
        return adapterFromType.newArray(key.size);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> T getArrayForKey(Key key) {
        return (T) this.groupedMap.get(key);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean mayFillRequest(int i, Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        try {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                evictToSize(this.maxSize / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void evict() {
        evictToSize(this.maxSize);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void evictToSize(int i) {
        while (this.currentSize > i) {
            Object removeLast = this.groupedMap.removeLast();
            Preconditions.checkNotNull(removeLast);
            ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
            this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
            if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                Log.v(adapterFromObject.getTag(), y.دײܮڳܯ(2052051893) + adapterFromObject.getArrayLength(removeLast));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void decrementArrayOfSize(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException(y.֬ڱܱײٮ(-1159295743) + i + y.٬ݯح׭٩(576001350) + this);
        }
        if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i));
        } else {
            sizesForAdapter.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = (ArrayAdapterInterface) this.adapters.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159295199) + cls.getSimpleName());
            }
            this.adapters.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCurrentSize() {
        int i = 0;
        for (Class<?> cls : this.sortedSizes.keySet()) {
            for (Integer num : this.sortedSizes.get(cls).keySet()) {
                i += num.intValue() * ((Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return i;
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        KeyPool() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Key get(int i, Class<?> cls) {
            Key key = get();
            key.init(i, cls);
            return key;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    private static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void init(int i, Class<?> cls) {
            this.size = i;
            this.arrayClass = cls;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.size == key.size && this.arrayClass == key.arrayClass;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.֬ڱܱײٮ(-1159296359) + this.size + y.ٲٴݴ״ٰ(1781778664) + this.arrayClass + '}';
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            int i = this.size * 31;
            Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
