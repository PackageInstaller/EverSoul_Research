package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Resource<Drawable> convertToDrawableResource(Resource<BitmapDrawable> resource) {
        return resource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(transformation, false));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Transformation
    public Resource<BitmapDrawable> transform(Context context, Resource<BitmapDrawable> resource, int i, int i2) {
        return convertToBitmapDrawableResource(this.wrapped.transform(context, convertToDrawableResource(resource), i, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Resource<BitmapDrawable> convertToBitmapDrawableResource(Resource<Drawable> resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781755944) + resource.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.wrapped.equals(((BitmapDrawableTransformation) obj).wrapped);
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
