package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.C2591L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class ViewAware implements ImageAware {
    public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    protected boolean checkActualViewSize;
    protected Reference<View> viewRef;

    protected abstract void setImageBitmapInto(Bitmap bitmap, View view);

    protected abstract void setImageDrawableInto(Drawable drawable, View view);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewAware(View view) {
        this(view, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewAware(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.viewRef = new WeakReference(view);
        this.checkActualViewSize = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        View view = this.viewRef.get();
        int i = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.checkActualViewSize && layoutParams != null && layoutParams.width != -2) {
            i = view.getWidth();
        }
        return (i > 0 || layoutParams == null) ? i : layoutParams.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        View view = this.viewRef.get();
        int i = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.checkActualViewSize && layoutParams != null && layoutParams.height != -2) {
            i = view.getHeight();
        }
        return (i > 0 || layoutParams == null) ? i : layoutParams.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return this.viewRef.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return this.viewRef.get() == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getId() {
        View view = this.viewRef.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.viewRef.get();
            if (view != null) {
                setImageDrawableInto(drawable, view);
                return true;
            }
        } else {
            C2591L.m724w(WARN_CANT_SET_DRAWABLE, new Object[0]);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.viewRef.get();
            if (view != null) {
                setImageBitmapInto(bitmap, view);
                return true;
            }
        } else {
            C2591L.m724w(WARN_CANT_SET_BITMAP, new Object[0]);
        }
        return false;
    }
}
