package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    private Priority priority = Priority.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private Key signature = EmptySignature.obtain();
    private boolean isTransformationAllowed = true;
    private Options options = new Options();
    private Map<Class<?>, Transformation<?>> transformations = new CachedHashCodeArrayMap();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isSet(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private T self() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T sizeMultiplier(float f) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().sizeMultiplier(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1392948642));
        }
        this.sizeMultiplier = f;
        this.fields |= 2;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T priority(Priority priority) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().priority(priority);
        }
        this.priority = (Priority) Preconditions.checkNotNull(priority);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i = this.fields | 64;
        this.placeholderId = 0;
        this.fields = i & (-129);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T placeholder(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().placeholder(i);
        }
        this.placeholderId = i;
        int i2 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = i2 & (-65);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = i & (-16385);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T fallback(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().fallback(i);
        }
        this.fallbackId = i;
        int i2 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = i2 & (-8193);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i = this.fields | 16;
        this.errorId = 0;
        this.fields = i & (-33);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T error(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().error(i);
        }
        this.errorId = i;
        int i2 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = i2 & (-17);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T override(int i, int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().override(i, i2);
        }
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T override(int i) {
        return override(i, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T signature(Key key) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().signature(key);
        }
        this.signature = (Key) Preconditions.checkNotNull(key);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // 
    /* renamed from: clone */
    public T mo930clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.options = options;
            options.putAll(this.options);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.transformations = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Y> T set(Option<Y> option, Y y) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().set(option, y);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(y);
        this.options.set(option, y);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().decode(cls);
        }
        this.resourceClass = (Class) Preconditions.checkNotNull(cls);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isLocked() {
        return this.isLocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T encodeFormat(Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T encodeQuality(int i) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T frame(long j) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T format(DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return (T) set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T downsample(DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T timeout(int i) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T optionalCenterCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T centerCrop() {
        return transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T optionalFitCenter() {
        return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T fitCenter() {
        return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T optionalCenterInside() {
        return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T centerInside() {
        return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T optionalCircleCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T circleCrop() {
        return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final T optionalTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final T transform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private T scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private T optionalScaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private T scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation, boolean z) {
        T optionalTransform;
        if (z) {
            optionalTransform = transform(downsampleStrategy, transformation);
        } else {
            optionalTransform = optionalTransform(downsampleStrategy, transformation);
        }
        optionalTransform.isScaleOnlyOrNoTransform = true;
        return optionalTransform;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T transform(Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T transform(Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return transform(transformationArr[0]);
        }
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public T transforms(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T optionalTransform(Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    T transform(Transformation<Bitmap> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().transform(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        transform(Bitmap.class, transformation, z);
        transform(Drawable.class, drawableTransformation, z);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Y> T optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return transform(cls, transformation, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <Y> T transform(Class<Y> cls, Transformation<Y> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().transform(cls, transformation, z);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(cls, transformation);
        int i = this.fields | 2048;
        this.isTransformationAllowed = true;
        int i2 = i | 65536;
        this.fields = i2;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields = i2 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Y> T transform(Class<Y> cls, Transformation<Y> transformation) {
        return transform(cls, transformation, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().dontTransform();
        }
        this.transformations.clear();
        int i = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (i & (-131073)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T apply(BaseRequestOptions<?> baseRequestOptions) {
        if (this.isAutoCloneEnabled) {
            return (T) mo930clone().apply(baseRequestOptions);
        }
        if (isSet(baseRequestOptions.fields, 2)) {
            this.sizeMultiplier = baseRequestOptions.sizeMultiplier;
        }
        if (isSet(baseRequestOptions.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = baseRequestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(baseRequestOptions.fields, 1048576)) {
            this.useAnimationPool = baseRequestOptions.useAnimationPool;
        }
        if (isSet(baseRequestOptions.fields, 4)) {
            this.diskCacheStrategy = baseRequestOptions.diskCacheStrategy;
        }
        if (isSet(baseRequestOptions.fields, 8)) {
            this.priority = baseRequestOptions.priority;
        }
        if (isSet(baseRequestOptions.fields, 16)) {
            this.errorPlaceholder = baseRequestOptions.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(baseRequestOptions.fields, 32)) {
            this.errorId = baseRequestOptions.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(baseRequestOptions.fields, 64)) {
            this.placeholderDrawable = baseRequestOptions.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(baseRequestOptions.fields, 128)) {
            this.placeholderId = baseRequestOptions.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(baseRequestOptions.fields, 256)) {
            this.isCacheable = baseRequestOptions.isCacheable;
        }
        if (isSet(baseRequestOptions.fields, 512)) {
            this.overrideWidth = baseRequestOptions.overrideWidth;
            this.overrideHeight = baseRequestOptions.overrideHeight;
        }
        if (isSet(baseRequestOptions.fields, 1024)) {
            this.signature = baseRequestOptions.signature;
        }
        if (isSet(baseRequestOptions.fields, 4096)) {
            this.resourceClass = baseRequestOptions.resourceClass;
        }
        if (isSet(baseRequestOptions.fields, 8192)) {
            this.fallbackDrawable = baseRequestOptions.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(baseRequestOptions.fields, 16384)) {
            this.fallbackId = baseRequestOptions.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(baseRequestOptions.fields, 32768)) {
            this.theme = baseRequestOptions.theme;
        }
        if (isSet(baseRequestOptions.fields, 65536)) {
            this.isTransformationAllowed = baseRequestOptions.isTransformationAllowed;
        }
        if (isSet(baseRequestOptions.fields, 131072)) {
            this.isTransformationRequired = baseRequestOptions.isTransformationRequired;
        }
        if (isSet(baseRequestOptions.fields, 2048)) {
            this.transformations.putAll(baseRequestOptions.transformations);
            this.isScaleOnlyOrNoTransform = baseRequestOptions.isScaleOnlyOrNoTransform;
        }
        if (isSet(baseRequestOptions.fields, 524288)) {
            this.onlyRetrieveFromCache = baseRequestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i = this.fields & (-2049);
            this.isTransformationRequired = false;
            this.fields = i & (-131073);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= baseRequestOptions.fields;
        this.options.putAll(baseRequestOptions.options);
        return selfOrThrowIfLocked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        return Float.compare(baseRequestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == baseRequestOptions.errorId && Util.bothNullOrEqual(this.errorPlaceholder, baseRequestOptions.errorPlaceholder) && this.placeholderId == baseRequestOptions.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, baseRequestOptions.placeholderDrawable) && this.fallbackId == baseRequestOptions.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, baseRequestOptions.fallbackDrawable) && this.isCacheable == baseRequestOptions.isCacheable && this.overrideHeight == baseRequestOptions.overrideHeight && this.overrideWidth == baseRequestOptions.overrideWidth && this.isTransformationRequired == baseRequestOptions.isTransformationRequired && this.isTransformationAllowed == baseRequestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == baseRequestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == baseRequestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(baseRequestOptions.diskCacheStrategy) && this.priority == baseRequestOptions.priority && this.options.equals(baseRequestOptions.options) && this.transformations.equals(baseRequestOptions.transformations) && this.resourceClass.equals(baseRequestOptions.resourceClass) && Util.bothNullOrEqual(this.signature, baseRequestOptions.signature) && Util.bothNullOrEqual(this.theme, baseRequestOptions.theme);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T lock() {
        this.isLocked = true;
        return self();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException(y.֬ڱܱײٮ(-1159228303));
        }
        this.isAutoCloneEnabled = true;
        return lock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException(y.֬ڱܱײٮ(-1159228703));
        }
        return self();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Options getOptions() {
        return this.options;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getErrorId() {
        return this.errorId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getFallbackId() {
        return this.fallbackId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Resources.Theme getTheme() {
        return this.theme;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Key getSignature() {
        return this.signature;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPrioritySet() {
        return isSet(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Priority getPriority() {
        return this.priority;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isSet(int i) {
        return isSet(this.fields, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }
}
