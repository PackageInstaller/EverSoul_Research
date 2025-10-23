package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public BitmapThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public Drawable getDrawable(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.view).getResources(), bitmap);
    }
}
