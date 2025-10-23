package com.nostra13.universalimageloader.core.decode;

import android.graphics.BitmapFactory;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* loaded from: classes3.dex */
public class ImageDecodingInfo {
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions;
    private final ImageDownloader downloader;
    private final Object extraForDownloader;
    private final String imageKey;
    private final ImageScaleType imageScaleType;
    private final String imageUri;
    private final String originalImageUri;
    private final ImageSize targetSize;
    private final ViewScaleType viewScaleType;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageDecodingInfo(String str, String str2, String str3, ImageSize imageSize, ViewScaleType viewScaleType, ImageDownloader imageDownloader, DisplayImageOptions displayImageOptions) {
        this.imageKey = str;
        this.imageUri = str2;
        this.originalImageUri = str3;
        this.targetSize = imageSize;
        this.imageScaleType = displayImageOptions.getImageScaleType();
        this.viewScaleType = viewScaleType;
        this.downloader = imageDownloader;
        this.extraForDownloader = displayImageOptions.getExtraForDownloader();
        this.considerExifParams = displayImageOptions.isConsiderExifParams();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.decodingOptions = options;
        copyOptions(displayImageOptions.getDecodingOptions(), options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void copyOptions(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        copyOptions10(options, options2);
        copyOptions11(options, options2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void copyOptions10(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void copyOptions11(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getImageKey() {
        return this.imageKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getImageUri() {
        return this.imageUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginalImageUri() {
        return this.originalImageUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageSize getTargetSize() {
        return this.targetSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewScaleType getViewScaleType() {
        return this.viewScaleType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageDownloader getDownloader() {
        return this.downloader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldConsiderExifParams() {
        return this.considerExifParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }
}
