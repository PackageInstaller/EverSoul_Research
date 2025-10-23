package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.liapp.y;

/* loaded from: classes.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapResource obtain(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.bitmap = (Bitmap) Preconditions.checkNotNull(bitmap, y.ݬֲ֮ܲت(1513048775));
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool, "BitmapPool must not be null");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Bitmap get() {
        return this.bitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.bitmap.prepareToDraw();
    }
}
