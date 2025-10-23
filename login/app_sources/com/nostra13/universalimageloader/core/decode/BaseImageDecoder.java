package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.C2591L;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaseImageDecoder(boolean z) {
        this.loggingEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.decode.ImageDecoder
    public Bitmap decode(ImageDecodingInfo imageDecodingInfo) throws IOException {
        InputStream imageStream = getImageStream(imageDecodingInfo);
        if (imageStream == null) {
            C2591L.m720e(ERROR_NO_IMAGE_STREAM, imageDecodingInfo.getImageKey());
            return null;
        }
        try {
            ImageFileInfo defineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
            imageStream = resetStream(imageStream, imageDecodingInfo);
            Bitmap decodeStream = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(defineImageSizeAndRotation.imageSize, imageDecodingInfo));
            if (decodeStream != null) {
                return considerExactScaleAndOrientatiton(decodeStream, imageDecodingInfo, defineImageSizeAndRotation.exif.rotation, defineImageSizeAndRotation.exif.flipHorizontal);
            }
            C2591L.m720e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
            return decodeStream;
        } finally {
            IoUtils.closeSilently(imageStream);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) throws IOException {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        ExifInfo exifInfo;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        if (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) {
            exifInfo = defineExifOrientation(imageUri);
        } else {
            exifInfo = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifInfo.rotation), exifInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canDefineExifParams(String str, String str2) {
        return y.ٴسسݬߨ(1393189970).equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ExifInfo defineExifOrientation(String str) {
        int i;
        boolean z = true;
        int i2 = 0;
        try {
        } catch (IOException unused) {
            C2591L.m724w("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt("Orientation", 1)) {
            case 1:
            default:
                z = false;
                break;
            case 2:
                break;
            case 3:
                z = false;
                i = 180;
                i2 = i;
                break;
            case 4:
                i = 180;
                i2 = i;
                break;
            case 5:
                i = 270;
                i2 = i;
                break;
            case 6:
                z = false;
                i = 90;
                i2 = i;
                break;
            case 7:
                i = 90;
                i2 = i;
                break;
            case 8:
                z = false;
                i = 270;
                i2 = i;
                break;
        }
        return new ExifInfo(i2, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        int computeImageSampleSize;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            computeImageSampleSize = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            computeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            computeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (computeImageSampleSize > 1 && this.loggingEnabled) {
            C2591L.m719d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(computeImageSampleSize), Integer.valueOf(computeImageSampleSize), imageDecodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = computeImageSampleSize;
        return decodingOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        IoUtils.closeSilently(inputStream);
        return getImageStream(imageDecodingInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            float computeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(computeImageScale, 1.0f) != 0) {
                matrix.setScale(computeImageScale, computeImageScale);
                if (this.loggingEnabled) {
                    C2591L.m719d(y.֬ڱܱײٮ(-1159055023), imageSize, imageSize.scale(computeImageScale), Float.valueOf(computeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                C2591L.m719d(y.دײܮڳܯ(2051236885), imageDecodingInfo.getImageKey());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.loggingEnabled) {
                C2591L.m719d(LOG_ROTATE_IMAGE, Integer.valueOf(i), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected ExifInfo(int i, boolean z) {
            this.rotation = i;
            this.flipHorizontal = z;
        }
    }

    protected static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }
}
