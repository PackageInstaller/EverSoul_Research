package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.C2591L;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class ImageViewAware extends ViewAware {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageViewAware(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageViewAware(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? width : getImageViewFieldValue(imageView, y.ݮڮֲڭܩ(-628205652));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? height : getImageViewFieldValue(imageView, y.٬ݯح׭٩(576300974));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.viewRef.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return super.getScaleType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware
    protected void setImageDrawableInto(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware
    protected void setImageBitmapInto(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getImageViewFieldValue(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e) {
            C2591L.m721e(e);
            return 0;
        }
    }
}
