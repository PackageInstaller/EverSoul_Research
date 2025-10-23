package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import com.liapp.y;

/* loaded from: classes.dex */
class AttributeStrategy implements LruPoolStrategy {
    private final KeyPool keyPool = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AttributeStrategy() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i, i2, config));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(i, i2, config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1159296575) + this.groupedMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getBitmapString(int i, int i2, Bitmap.Config config) {
        return y.ٴسسݬߨ(1392956562) + i + y.ٴسسݬߨ(1392956602) + i2 + "], " + config;
    }

    static class KeyPool extends BaseKeyPool<Key> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        KeyPool() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Key get(int i, int i2, Bitmap.Config config) {
            Key key = get();
            key.init(i, i2, config);
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

    static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void init(int i, int i2, Bitmap.Config config) {
            this.width = i;
            this.height = i2;
            this.config = config;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.width == key.width && this.height == key.height && this.config == key.config;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            int i = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.config;
            return i + (config != null ? config.hashCode() : 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }
    }
}
