package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;
import com.liapp.y;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    static final boolean IS_BITMAP_FACTORY_SCALING_SUPPORTED;
    public static final DownsampleStrategy NONE;
    public static final Option<DownsampleStrategy> OPTION;
    public static final DownsampleStrategy AT_LEAST = new AtLeast();
    public static final DownsampleStrategy AT_MOST = new AtMost();
    public static final DownsampleStrategy FIT_CENTER = new FitCenter();
    public static final DownsampleStrategy CENTER_INSIDE = new CenterInside();

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4);

    public abstract float getScaleFactor(int i, int i2, int i3, int i4);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        CenterOutside centerOutside = new CenterOutside();
        CENTER_OUTSIDE = centerOutside;
        NONE = new None();
        DEFAULT = centerOutside;
        OPTION = Option.memory(y.֬ڱܱײٮ(-1159326751), centerOutside);
        IS_BITMAP_FACTORY_SCALING_SUPPORTED = true;
    }

    private static class FitCenter extends DownsampleStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FitCenter() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i, int i2, int i3, int i4) {
            if (IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
                return Math.min(i3 / i, i4 / i2);
            }
            if (Math.max(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            if (IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class CenterOutside extends DownsampleStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CenterOutside() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class AtLeast extends DownsampleStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AtLeast() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i, int i2, int i3, int i4) {
            if (Math.min(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class AtMost extends DownsampleStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AtMost() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class None extends DownsampleStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        None() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class CenterInside extends DownsampleStrategy {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CenterInside() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, FIT_CENTER.getScaleFactor(i, i2, i3, i4));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            if (getScaleFactor(i, i2, i3, i4) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return FIT_CENTER.getSampleSizeRounding(i, i2, i3, i4);
        }
    }
}
