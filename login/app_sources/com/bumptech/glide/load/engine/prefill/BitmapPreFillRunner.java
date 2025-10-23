package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_DURATION_MS = 32;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;
    private static final Clock DEFAULT_CLOCK = new Clock();
    static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, Clock clock, Handler handler) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancel() {
        this.isCancelled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean allocate() {
        Bitmap createBitmap;
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            PreFillType remove = this.toPrefill.remove();
            if (!this.seenTypes.contains(remove)) {
                this.seenTypes.add(remove);
                createBitmap = this.bitmapPool.getDirty(remove.getWidth(), remove.getHeight(), remove.getConfig());
            } else {
                createBitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            }
            int bitmapByteSize = Util.getBitmapByteSize(createBitmap);
            if (getFreeMemoryCacheBytes() >= bitmapByteSize) {
                this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(createBitmap, this.bitmapPool));
            } else {
                this.bitmapPool.put(createBitmap);
            }
            String str = y.ݬֲ֮ܲت(1513041247);
            if (Log.isLoggable(str, 3)) {
                Log.d(str, y.دײܮڳܯ(2051999053) + remove.getWidth() + y.ٴسسݬߨ(1392956602) + remove.getHeight() + y.٬ݯح׭٩(576045974) + remove.getConfig() + y.٬ݯح׭٩(576046070) + bitmapByteSize);
            }
        }
        return (this.isCancelled || this.toPrefill.isEmpty()) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isGcDetected(long j) {
        return this.clock.now() - j >= 32;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getNextDelay() {
        long j = this.currentDelay;
        this.currentDelay = Math.min(4 * j, MAX_BACKOFF_MS);
        return j;
    }

    private static final class UniqueKey implements Key {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        UniqueKey() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    static class Clock {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Clock() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }
}
