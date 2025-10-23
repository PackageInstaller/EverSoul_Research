package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.wrapped = transformation;
        this.isRequired = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Transformation
    public Resource<Drawable> transform(Context context, Resource<Drawable> resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = resource.get();
        Resource<Bitmap> convert = DrawableToBitmapConverter.convert(bitmapPool, drawable, i, i2);
        if (convert == null) {
            if (this.isRequired) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return resource;
        }
        Resource<Bitmap> transform = this.wrapped.transform(context, convert, i, i2);
        if (transform.equals(convert)) {
            transform.recycle();
            return resource;
        }
        return newDrawableResource(context, transform);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Resource<Drawable> newDrawableResource(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.wrapped.equals(((DrawableTransformation) obj).wrapped);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
