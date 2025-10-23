package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources resources;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapDrawableTranscoder(Context context) {
        this(context.getResources());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public BitmapDrawableTranscoder(Resources resources, BitmapPool bitmapPool) {
        this(resources);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapDrawableTranscoder(Resources resources) {
        this.resources = (Resources) Preconditions.checkNotNull(resources);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<BitmapDrawable> transcode(Resource<Bitmap> resource, Options options) {
        return LazyBitmapDrawableResource.obtain(this.resources, resource);
    }
}
