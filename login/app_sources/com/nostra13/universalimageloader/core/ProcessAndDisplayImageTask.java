package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.utils.C2591L;

/* loaded from: classes3.dex */
final class ProcessAndDisplayImageTask implements Runnable {
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProcessAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, Bitmap bitmap, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.bitmap = bitmap;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        C2591L.m719d(y.ٴسسݬߨ(1393192130), this.imageLoadingInfo.memoryCacheKey);
        LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE), this.imageLoadingInfo.options.isSyncLoading(), this.handler, this.engine);
    }
}
