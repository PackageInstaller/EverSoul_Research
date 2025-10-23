package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;

/* loaded from: classes.dex */
public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(config, y.٬ݯح׭٩(576046238));
        this.width = i;
        this.height = i2;
        this.weight = i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getWidth() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getHeight() {
        return this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Bitmap.Config getConfig() {
        return this.config;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getWeight() {
        return this.weight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1159308215) + this.width + y.ۮڭڭܬި(862104747) + this.height + y.٬ݯح׭٩(576046630) + this.config + y.دײܮڳܯ(2051997725) + this.weight + '}';
    }

    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(int i) {
            this(i, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.width = i;
            this.height = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConfig(Bitmap.Config config) {
            this.config = config;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Bitmap.Config getConfig() {
            return this.config;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setWeight(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException(y.ݮڮֲڭܩ(-629001124));
            }
            this.weight = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }
    }
}
