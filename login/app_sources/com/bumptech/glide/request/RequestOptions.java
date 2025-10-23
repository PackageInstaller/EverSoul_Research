package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* loaded from: classes.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions sizeMultiplierOf(float f) {
        return new RequestOptions().sizeMultiplier(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions priorityOf(Priority priority) {
        return new RequestOptions().priority(priority);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions placeholderOf(Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions placeholderOf(int i) {
        return new RequestOptions().placeholder(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions errorOf(Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions errorOf(int i) {
        return new RequestOptions().error(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions overrideOf(int i, int i2) {
        return new RequestOptions().override(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions signatureOf(Key key) {
        return new RequestOptions().signature(key);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> RequestOptions option(Option<T> option, T t) {
        return new RequestOptions().set(option, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions decodeTypeOf(Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions formatOf(DecodeFormat decodeFormat) {
        return new RequestOptions().format(decodeFormat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions frameOf(long j) {
        return new RequestOptions().frame(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().downsample(downsampleStrategy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions timeoutOf(int i) {
        return new RequestOptions().timeout(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions encodeQualityOf(int i) {
        return new RequestOptions().encodeQuality(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }
}
