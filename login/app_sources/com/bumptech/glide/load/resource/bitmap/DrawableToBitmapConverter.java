package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.liapp.y;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public void put(Bitmap bitmap) {
        }
    };
    private static final String TAG = "DrawableToBitmap";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DrawableToBitmapConverter() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Resource<Bitmap> convert(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = drawToBitmap(bitmapPool, current, i, i2);
            z = true;
        }
        if (!z) {
            bitmapPool = NO_RECYCLE_BITMAP_POOL;
        }
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bitmap drawToBitmap(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        String str = y.ۮڭڭܬި(862176435);
        String str2 = y.٬ݯح׭٩(575957566);
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(str2, 5)) {
                Log.w(str2, str + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(str2, 5)) {
                Log.w(str2, str + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
        bitmapDrawableLock.lock();
        Bitmap bitmap = bitmapPool.get(i, i2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmap;
        } finally {
            bitmapDrawableLock.unlock();
        }
    }
}
