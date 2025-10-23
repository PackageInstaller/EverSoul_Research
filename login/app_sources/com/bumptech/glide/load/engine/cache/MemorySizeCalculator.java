package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;

/* loaded from: classes.dex */
public final class MemorySizeCalculator {
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MemorySizeCalculator(Builder builder) {
        int i;
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i = builder.arrayPoolSizeBytes / 2;
        } else {
            i = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4;
        int round = Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = Math.round(widthPixels * builder.memoryCacheScreens);
        int i2 = maxSize - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f = i2 / (builder.bitmapPoolScreens + builder.memoryCacheScreens);
            this.memoryCacheSize = Math.round(builder.memoryCacheScreens * f);
            this.bitmapPoolSize = Math.round(f * builder.bitmapPoolScreens);
        }
        String str = y.֬ڱܱײٮ(-1159310871);
        if (Log.isLoggable(str, 3)) {
            Log.d(str, y.ݮڮֲڭܩ(-628999724) + toMb(this.memoryCacheSize) + y.٬ݯح׭٩(576047878) + toMb(this.bitmapPoolSize) + y.دײܮڳܯ(2052001245) + toMb(i) + y.ٲٴݴ״ٰ(1781733184) + (i3 > maxSize) + y.ۮڭڭܬި(862085139) + toMb(maxSize) + y.ۮڭڭܬި(862085283) + builder.activityManager.getMemoryClass() + y.ݮڮֲڭܩ(-628998580) + isLowMemoryDevice(builder.activityManager));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getMaxSize(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (isLowMemoryDevice(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String toMb(int i) {
        return Formatter.formatFileSize(this.context, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        float bitmapPoolScreens;
        final Context context;
        ScreenDimensions screenDimensions;
        float memoryCacheScreens = 2.0f;
        float maxSizeMultiplier = MAX_SIZE_MULTIPLIER;
        float lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        int arrayPoolSizeBytes = 4194304;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            BITMAP_POOL_TARGET_SCREENS = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(Context context) {
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.context = context;
            this.activityManager = (ActivityManager) context.getSystemService(y.֬ڱܱײٮ(-1159305015));
            this.screenDimensions = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                return;
            }
            this.bitmapPoolScreens = 0.0f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMemoryCacheScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, y.ݮڮֲڭܩ(-629012644));
            this.memoryCacheScreens = f;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBitmapPoolScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, y.دײܮڳܯ(2052011061));
            this.bitmapPoolScreens = f;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, y.֬ڱܱײٮ(-1159303943));
            this.maxSizeMultiplier = f;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLowMemoryMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, y.֬ڱܱײٮ(-1159303879));
            this.lowMemoryMaxSizeMultiplier = f;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setArrayPoolSize(int i) {
            this.arrayPoolSizeBytes = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder setActivityManager(ActivityManager activityManager) {
            this.activityManager = activityManager;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder setScreenDimensions(ScreenDimensions screenDimensions) {
            this.screenDimensions = screenDimensions;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }
    }

    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }
    }
}
