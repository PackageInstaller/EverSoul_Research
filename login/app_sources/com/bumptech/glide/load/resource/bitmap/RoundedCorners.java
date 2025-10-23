package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class RoundedCorners extends BitmapTransformation {

    /* renamed from: ID */
    private static final String f169ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = y.٬ݯح׭٩(575956750).getBytes(CHARSET);
    private final int roundingRadius;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RoundedCorners(int i) {
        Preconditions.checkArgument(i > 0, y.دײܮڳܯ(2051980941));
        this.roundingRadius = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.roundingRadius);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.roundingRadius == ((RoundedCorners) obj).roundingRadius;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-569625254, Util.hashCode(this.roundingRadius));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
