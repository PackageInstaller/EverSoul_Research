package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public final class Downsampler {
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final int MARK_POSITION = 10485760;
    static final String TAG = "Downsampler";
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory(y.دײܮڳܯ(2052017005), DecodeFormat.DEFAULT);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory(y.ݬֲ֮ܲت(1513054391), PreferredColorSpace.SRGB);

    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory(y.دײܮڳܯ(2052015877), false);
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = Option.memory(y.ݬֲ֮ܲت(1513057303), false);
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(y.دײܮڳܯ(2052015013), y.ݬֲ֮ܲت(1513056751))));
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }
    };
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean handles(InputStream inputStream) {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Preconditions.checkArgument(inputStream.markSupported(), y.ݮڮֲڭܩ(-628988028));
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i, i2, booleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int round;
        int round2;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, this.bitmapPool);
        boolean z3 = false;
        int i7 = dimensions[0];
        int i8 = dimensions[1];
        String str = options.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        if (i == Integer.MIN_VALUE) {
            i3 = i2;
            i4 = isRotationRequired(exifOrientationDegrees) ? i8 : i7;
        } else {
            i3 = i2;
            i4 = i;
        }
        if (i3 == Integer.MIN_VALUE) {
            i5 = isRotationRequired(exifOrientationDegrees) ? i7 : i8;
        } else {
            i5 = i3;
        }
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool);
        calculateScaling(type, inputStream, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i7, i8, i4, i5, options);
        calculateConfig(inputStream, decodeFormat, z4, isExifOrientationRequired, options, i4, i5);
        int i9 = options.inSampleSize;
        boolean shouldUsePool = shouldUsePool(type);
        String str2 = y.٬ݯح׭٩(576030446);
        if (shouldUsePool) {
            if (i7 < 0 || i8 < 0 || !z2) {
                float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i10 = options.inSampleSize;
                float f2 = i10;
                int ceil = (int) Math.ceil(i7 / f2);
                int ceil2 = (int) Math.ceil(i8 / f2);
                round = Math.round(ceil * f);
                round2 = Math.round(ceil2 * f);
                if (Log.isLoggable(str2, 2)) {
                    StringBuilder append = new StringBuilder(y.ݬֲ֮ܲت(1513061887)).append(round);
                    String str3 = y.ٴسسݬߨ(1392956602);
                    Log.v(str2, append.append(str3).append(round2).append(y.٬ݯح׭٩(576033598)).append(i7).append(str3).append(i8).append(y.ݮڮֲڭܩ(-628988964)).append(i10).append(y.ݮڮֲڭܩ(-628988860)).append(options.inTargetDensity).append(y.ٲٴݴ״ٰ(1781745232)).append(options.inDensity).append(y.دײܮڳܯ(2052018909)).append(f).toString());
                }
            } else {
                round = i4;
                round2 = i5;
            }
            if (round > 0 && round2 > 0) {
                setInBitmap(options, this.bitmapPool, round, round2);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap decodeStream = decodeStream(inputStream, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(str2, 2)) {
            i6 = orientation;
            logDecode(i7, i8, str, options, decodeStream, i, i2, logTime);
        } else {
            i6 = orientation;
        }
        if (decodeStream == null) {
            return null;
        }
        decodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap rotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i6);
        if (decodeStream.equals(rotateImageExif)) {
            return rotateImageExif;
        }
        this.bitmapPool.put(decodeStream);
        return rotateImageExif;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void calculateScaling(ImageHeaderParser.ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        int i6;
        int i7;
        int min;
        int floor;
        int floor2;
        String str = y.ۮڭڭܬި(862078387);
        String str2 = y.٬ݯح׭٩(576030446);
        String str3 = y.ٴسسݬߨ(1392956602);
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, y.ٴسسݬߨ(1392923882) + imageType + y.دײܮڳܯ(2052020117) + i4 + str3 + i5 + str);
                return;
            }
            return;
        }
        if (isRotationRequired(i)) {
            i7 = i2;
            i6 = i3;
        } else {
            i6 = i2;
            i7 = i3;
        }
        float scaleFactor = downsampleStrategy.getScaleFactor(i6, i7, i4, i5);
        if (scaleFactor <= 0.0f) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159329911) + scaleFactor + y.֬ڱܱײٮ(-1159330135) + downsampleStrategy + y.ٴسسݬߨ(1392925570) + i2 + str3 + i3 + y.֬ڱܱײٮ(-1159329415) + i4 + str3 + i5 + str);
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i6, i7, i4, i5);
        if (sampleSizeRounding == null) {
            throw new IllegalArgumentException(y.٬ݯح׭٩(576036254));
        }
        float f = i6;
        float f2 = i7;
        int round = i6 / round(scaleFactor * f);
        int round2 = i7 / round(scaleFactor * f2);
        if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
            min = Math.max(round, round2);
        } else {
            min = Math.min(round, round2);
        }
        int max = Math.max(1, Integer.highestOneBit(min));
        if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / scaleFactor) {
            max <<= 1;
        }
        options.inSampleSize = max;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min2 = Math.min(max, 8);
            floor = (int) Math.ceil(f / min2);
            floor2 = (int) Math.ceil(f2 / min2);
            int i8 = max / 8;
            if (i8 > 0) {
                floor /= i8;
                floor2 /= i8;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f3 = max;
            floor = (int) Math.floor(f / f3);
            floor2 = (int) Math.floor(f2 / f3);
        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
            float f4 = max;
            floor = Math.round(f / f4);
            floor2 = Math.round(f2 / f4);
        } else if (i6 % max != 0 || i7 % max != 0) {
            int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, bitmapPool);
            floor = dimensions[0];
            floor2 = dimensions[1];
        } else {
            floor = i6 / max;
            floor2 = i7 / max;
        }
        double scaleFactor2 = downsampleStrategy.getScaleFactor(floor, floor2, i4, i5);
        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
        options.inDensity = getDensityMultiplier(scaleFactor2);
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable(str2, 2)) {
            Log.v(str2, y.ݮڮֲڭܩ(-628984044) + i2 + str3 + i3 + y.٬ݯح׭٩(576034822) + i + y.ݮڮֲڭܩ(-628987724) + i4 + str3 + i5 + y.ݬֲ֮ܲت(1513060055) + floor + str3 + floor2 + y.ٲٴݴ״ٰ(1781743920) + scaleFactor + y.ٴسسݬߨ(1392926386) + max + y.ۮڭڭܬި(862074619) + scaleFactor2 + y.ٲٴݴ״ٰ(1781745584) + options.inTargetDensity + y.ٲٴݴ״ٰ(1781745232) + options.inDensity);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int adjustTargetDensityForError(double d) {
        return round((d / (r1 / r0)) * round(getDensityMultiplier(d) * d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        boolean z3;
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z3 = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
            z3 = false;
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap decodeStream(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r8, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r9) throws java.io.IOException {
        /*
            r0 = 576030446(0x225586ee, float:2.8938314E-18)
            java.lang.String r0 = com.liapp.y.٬ݯح׭٩(r0)
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto L11
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto L14
        L11:
            r8.onObtainBounds()
        L14:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.Throwable -> L35 java.lang.IllegalArgumentException -> L37
            java.util.concurrent.locks.Lock r9 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L34
            r6.reset()
        L34:
            return r8
        L35:
            r6 = move-exception
            goto L64
        L37:
            r5 = move-exception
            java.io.IOException r1 = newIoExceptionForInBitmapAssertion(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L35
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L48
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L35
        L48:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L63
            r6.reset()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L62
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L62
            r9.put(r0)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L62
            r7.inBitmap = r4     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L62
            android.graphics.Bitmap r6 = decodeStream(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L62
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r7.unlock()
            return r6
        L62:
            throw r1     // Catch: java.lang.Throwable -> L35
        L63:
            throw r1     // Catch: java.lang.Throwable -> L35
        L64:
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r7.unlock()
            throw r6
            fill-array 0x006c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isScaling(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v(TAG, y.֬ڱܱײٮ(-1159328591) + getBitmapString(bitmap) + y.ݬֲ֮ܲت(1513060935) + i + "x" + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return y.ٴسسݬߨ(1392956562) + bitmap.getWidth() + y.ٴسسݬߨ(1392956602) + bitmap.getHeight() + y.٬ݯح׭٩(576045974) + bitmap.getConfig() + (y.٬ݯح׭٩(576034142) + bitmap.getAllocationByteCount() + y.ٴسسݬߨ(1392959042));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException(y.ۮڭڭܬި(862075667) + i + y.ٲٴݴ״ٰ(1781746760) + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i, i2, config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
