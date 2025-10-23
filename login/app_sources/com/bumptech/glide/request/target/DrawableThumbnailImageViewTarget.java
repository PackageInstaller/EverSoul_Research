package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class DrawableThumbnailImageViewTarget extends ThumbnailImageViewTarget<Drawable> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public Drawable getDrawable(Drawable drawable) {
        return drawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public DrawableThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
