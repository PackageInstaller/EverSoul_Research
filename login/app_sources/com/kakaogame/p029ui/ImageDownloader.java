package com.kakaogame.p029ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.Logger;
import com.liapp.y;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageDownloader.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/ui/ImageDownloader;", "", "()V", "TAG", "", "configBuilder", "Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "getOptions", "()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "displayImage", "", "imageUri", "imageView", "Landroid/widget/ImageView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;", "downloadImage", "", "downloadImageSync", "Landroid/graphics/Bitmap;", "initialize", "context", "Landroid/content/Context;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ImageDownloader {
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    private static final String TAG = "ImageDownloader";
    private static ImageLoaderConfiguration.Builder configBuilder;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ImageDownloader() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        configBuilder = new ImageLoaderConfiguration.Builder(context);
        File cacheDir = context.getCacheDir();
        if (cacheDir != null && !cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        ImageLoaderConfiguration.Builder builder = configBuilder;
        Intrinsics.checkNotNull(builder);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);
        String str = y.٬ݯح׭٩(576367854);
        Log.d(str, "memoryCacheSize: 1048576");
        Log.d(str, "diskCacheSize: 10485760");
        ImageLoaderConfiguration.Builder builder2 = configBuilder;
        Intrinsics.checkNotNull(builder2);
        builder2.threadPoolSize(3);
        ImageLoaderConfiguration.Builder builder3 = configBuilder;
        Intrinsics.checkNotNull(builder3);
        builder3.threadPriority(4);
        ImageLoaderConfiguration.Builder builder4 = configBuilder;
        Intrinsics.checkNotNull(builder4);
        builder4.memoryCache(new LRULimitedMemoryCache(1048576));
        ImageLoaderConfiguration.Builder builder5 = configBuilder;
        Intrinsics.checkNotNull(builder5);
        builder5.memoryCacheSize(1048576);
        ImageLoaderConfiguration.Builder builder6 = configBuilder;
        Intrinsics.checkNotNull(builder6);
        builder6.memoryCacheSizePercentage(13);
        ImageLoaderConfiguration.Builder builder7 = configBuilder;
        Intrinsics.checkNotNull(builder7);
        builder7.diskCacheSize(10485760);
        ImageLoaderConfiguration.Builder builder8 = configBuilder;
        Intrinsics.checkNotNull(builder8);
        builder8.diskCacheFileCount(100);
        ImageLoaderConfiguration.Builder builder9 = configBuilder;
        Intrinsics.checkNotNull(builder9);
        ImageLoader.getInstance().init(builder9.build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bitmap downloadImageSync(String imageUri) {
        if (TextUtils.isEmpty(imageUri)) {
            return null;
        }
        return ImageLoader.getInstance().loadImageSync(imageUri, getOptions());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void downloadImage(String imageUri, ImageLoadingListener listener) {
        Intrinsics.checkNotNullParameter(imageUri, y.ۮڭڭܬި(862302395));
        Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
        ImageLoader.getInstance().loadImage(imageUri, INSTANCE.getOptions(), listener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Throwable displayImage(String imageUri, ImageView imageView, ImageLoadingListener listener) {
        Intrinsics.checkNotNullParameter(imageView, y.ݮڮֲڭܩ(-628269996));
        String str = y.ٲٴݴ״ٰ(1782347592) + imageUri;
        String str2 = y.٬ݯح׭٩(576367854);
        Log.v(str2, str);
        if (TextUtils.isEmpty(imageUri)) {
            return null;
        }
        try {
            ImageLoader.getInstance().displayImage(imageUri, imageView, INSTANCE.getOptions(), listener);
            return null;
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            String exc = e.toString();
            Exception exc2 = e;
            logger.m702e(str2, exc, exc2);
            return exc2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final DisplayImageOptions getOptions() {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.resetViewBeforeLoading(true);
        builder.considerExifParams(true);
        builder.cacheOnDisk(true);
        builder.cacheInMemory(false);
        builder.resetViewBeforeLoading(false);
        DisplayImageOptions build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, y.٬ݯح׭٩(576535150));
        return build;
    }
}
