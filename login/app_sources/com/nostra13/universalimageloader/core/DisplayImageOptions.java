package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

/* loaded from: classes3.dex */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldPreProcess() {
        return this.preProcessor != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getImageOnLoading(Resources resources) {
        int i = this.imageResOnLoading;
        return i != 0 ? resources.getDrawable(i) : this.imageOnLoading;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getImageForEmptyUri(Resources resources) {
        int i = this.imageResForEmptyUri;
        return i != 0 ? resources.getDrawable(i) : this.imageForEmptyUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getImageOnFail(Resources resources) {
        int i = this.imageResOnFail;
        return i != 0 ? resources.getDrawable(i) : this.imageOnFail;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Handler getHandler() {
        return this.handler;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;
        private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private Object extraForDownloader = null;
        private BitmapProcessor preProcessor = null;
        private BitmapProcessor postProcessor = null;
        private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        private Handler handler = null;
        private boolean isSyncLoading = false;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder showStubImage(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder showImageOnLoading(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder showImageForEmptyUri(int i) {
            this.imageResForEmptyUri = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder showImageOnFail(int i) {
            this.imageResOnFail = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder resetViewBeforeLoading(boolean z) {
            this.resetViewBeforeLoading = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder cacheInMemory(boolean z) {
            this.cacheInMemory = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder cacheOnDisc() {
            return cacheOnDisk(true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder cacheOnDisc(boolean z) {
            return cacheOnDisk(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder cacheOnDisk(boolean z) {
            this.cacheOnDisk = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder bitmapConfig(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException(y.ݮڮֲڭܩ(-628213388));
            }
            this.decodingOptions.inPreferredConfig = config;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder decodingOptions(BitmapFactory.Options options) {
            if (options == null) {
                throw new IllegalArgumentException(y.ۮڭڭܬި(862873395));
            }
            this.decodingOptions = options;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder delayBeforeLoading(int i) {
            this.delayBeforeLoading = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder extraForDownloader(Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder considerExifParams(boolean z) {
            this.considerExifParams = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer == null) {
                throw new IllegalArgumentException(y.دײܮڳܯ(2051214477));
            }
            this.displayer = bitmapDisplayer;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder syncLoading(boolean z) {
            this.isSyncLoading = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisk = displayImageOptions.cacheOnDisk;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }
}
