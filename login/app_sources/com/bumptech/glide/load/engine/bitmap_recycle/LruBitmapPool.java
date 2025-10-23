package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.liapp.y;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    private interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = j;
        this.maxSize = j;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LruBitmapPool(long j) {
        this(j, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LruBitmapPool(long j, Set<Bitmap.Config> set) {
        this(j, getDefaultStrategy(), set);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = Math.round(this.initialMaxSize * f);
        evict();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        String str = y.ݮڮֲڭܩ(-629009428);
        String str2 = y.دײܮڳܯ(2052006421);
        synchronized (this) {
            try {
                if (bitmap == null) {
                    throw new NullPointerException("Bitmap must not be null");
                }
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Cannot pool recycled bitmap");
                }
                if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                    int size = this.strategy.getSize(bitmap);
                    this.strategy.put(bitmap);
                    this.tracker.add(bitmap);
                    this.puts++;
                    this.currentSize += size;
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, str + this.strategy.logBitmap(bitmap));
                    }
                    dump();
                    evict();
                    return;
                }
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, str2 + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig()));
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void evict() {
        trimToSize(this.maxSize);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull != null) {
            dirtyOrNull.eraseColor(0);
            return dirtyOrNull;
        }
        return createBitmap(i, i2, config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        return dirtyOrNull == null ? createBitmap(i, i2, config) : dirtyOrNull;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void assertNotHardwareConfig(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1392913818) + config + y.٬ݯح׭٩(576056070));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized Bitmap getDirtyOrNull(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        String str = y.ٴسسݬߨ(1392911930);
        String str2 = y.ݮڮֲڭܩ(-629009764);
        synchronized (this) {
            assertNotHardwareConfig(config);
            bitmap = this.strategy.get(i, i2, config != null ? config : DEFAULT_CONFIG);
            if (bitmap == null) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, str2 + this.strategy.logBitmap(i, i2, config));
                }
                this.misses++;
            } else {
                this.hits++;
                this.currentSize -= this.strategy.getSize(bitmap);
                this.tracker.remove(bitmap);
                normalize(bitmap);
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, str + this.strategy.logBitmap(i, i2, config));
            }
            dump();
        }
        return bitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        String str = y.دײܮڳܯ(2052008213);
        if (Log.isLoggable(str, 3)) {
            Log.d(str, y.ݮڮֲڭܩ(-629009660));
        }
        trimToSize(0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i) {
        String str = y.دײܮڳܯ(2052008213);
        if (Log.isLoggable(str, 3)) {
            Log.d(str, y.ݮڮֲڭܩ(-629009108) + i);
        }
        if (i >= 40 || i >= 20) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Size mismatch, resetting");
                    dumpUnchecked();
                }
                this.currentSize = 0L;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= this.strategy.getSize(removeLast);
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(removeLast));
            }
            dump();
            removeLast.recycle();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dump() {
        if (Log.isLoggable(y.دײܮڳܯ(2052008213), 2)) {
            dumpUnchecked();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dumpUnchecked() {
        Log.v(y.دײܮڳܯ(2052008213), y.ݬֲ֮ܲت(1513029703) + this.hits + y.٬ݯح׭٩(576053286) + this.misses + y.֬ڱܱײٮ(-1159300783) + this.puts + y.ٲٴݴ״ٰ(1781742496) + this.evictions + y.ݬֲ֮ܲت(1513033407) + this.currentSize + y.ݬֲ֮ܲت(1513033279) + this.maxSize + y.ٴسسݬߨ(1392911962) + this.strategy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ThrowingBitmapTracker() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                throw new IllegalStateException(y.ۮڭڭܬި(862108259) + bitmap + y.ݮڮֲڭܩ(-629008332) + bitmap.getWidth() + y.ٴسسݬߨ(1392956602) + bitmap.getHeight() + y.ۮڭڭܬި(862078387));
            }
            this.bitmaps.add(bitmap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new IllegalStateException(y.ۮڭڭܬި(862078379));
            }
            this.bitmaps.remove(bitmap);
        }
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NullBitmapTracker() {
        }
    }
}
