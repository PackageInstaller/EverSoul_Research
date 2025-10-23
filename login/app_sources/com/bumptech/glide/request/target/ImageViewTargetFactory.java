package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.liapp.y;

/* loaded from: classes.dex */
public class ImageViewTargetFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Z> ViewTarget<ImageView, Z> buildTarget(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        throw new IllegalArgumentException(y.٬ݯح׭٩(575990758) + cls + y.ۮڭڭܬި(862142811));
    }
}
