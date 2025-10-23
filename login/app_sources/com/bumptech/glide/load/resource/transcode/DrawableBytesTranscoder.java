package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
    private final ResourceTranscoder<Bitmap, byte[]> bitmapBytesTranscoder;
    private final BitmapPool bitmapPool;
    private final ResourceTranscoder<GifDrawable, byte[]> gifDrawableBytesTranscoder;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Resource<GifDrawable> toGifDrawableResource(Resource<Drawable> resource) {
        return resource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.bitmapPool = bitmapPool;
        this.bitmapBytesTranscoder = resourceTranscoder;
        this.gifDrawableBytesTranscoder = resourceTranscoder2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> transcode(Resource<Drawable> resource, Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.bitmapBytesTranscoder.transcode(BitmapResource.obtain(((BitmapDrawable) drawable).getBitmap(), this.bitmapPool), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.gifDrawableBytesTranscoder.transcode(toGifDrawableResource(resource), options);
        }
        return null;
    }
}
