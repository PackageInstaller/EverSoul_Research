package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: classes.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    protected abstract Drawable getDrawable(T t);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void setResource(T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
        Drawable drawable = getDrawable(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawable = new FixedSizeDrawable(drawable, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.view).setImageDrawable(drawable);
    }
}
