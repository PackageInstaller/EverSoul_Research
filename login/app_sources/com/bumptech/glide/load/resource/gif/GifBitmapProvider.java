package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GifBitmapProvider(BitmapPool bitmapPool) {
        this(bitmapPool, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap obtain(int i, int i2, Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public byte[] obtainByteArray(int i) {
        ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool.get(i, byte[].class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(byte[] bArr) {
        ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public int[] obtainIntArray(int i) {
        ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return new int[i];
        }
        return (int[]) arrayPool.get(i, int[].class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(int[] iArr) {
        ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(iArr);
    }
}
