package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.util.NavigableMap;

/* loaded from: classes.dex */
final class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final KeyPool keyPool = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final NavigableMap<Integer, Integer> sortedSizes = new PrettyPrintTreeMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SizeStrategy() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(key, bitmap);
        Integer num = (Integer) this.sortedSizes.get(Integer.valueOf(key.size));
        this.sortedSizes.put(Integer.valueOf(key.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        int bitmapByteSize = Util.getBitmapByteSize(i, i2, config);
        Key key = this.keyPool.get(bitmapByteSize);
        Integer ceilingKey = this.sortedSizes.ceilingKey(Integer.valueOf(bitmapByteSize));
        if (ceilingKey != null && ceilingKey.intValue() != bitmapByteSize && ceilingKey.intValue() <= bitmapByteSize * 8) {
            this.keyPool.offer(key);
            key = this.keyPool.get(ceilingKey.intValue());
        }
        Bitmap bitmap = this.groupedMap.get(key);
        if (bitmap != null) {
            bitmap.reconfigure(i, i2, config);
            decrementBitmapOfSize(ceilingKey);
        }
        return bitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)));
        }
        return removeLast;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void decrementBitmapOfSize(Integer num) {
        Integer num2 = (Integer) this.sortedSizes.get(num);
        if (num2.intValue() == 1) {
            this.sortedSizes.remove(num);
        } else {
            this.sortedSizes.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(Util.getBitmapByteSize(i, i2, config));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1159306839) + this.groupedMap + y.ݮڮֲڭܩ(-629012108) + this.sortedSizes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getBitmapString(int i) {
        return y.ٴسسݬߨ(1392956562) + i + y.ۮڭڭܬި(862078387);
    }

    static class KeyPool extends BaseKeyPool<Key> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        KeyPool() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Key get(int i) {
            Key key = (Key) super.get();
            key.init(i);
            return key;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void init(int i) {
            this.size = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            return (obj instanceof Key) && this.size == ((Key) obj).size;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.size;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }
    }
}
