package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import com.liapp.y;
import java.io.IOException;

/* loaded from: classes.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    protected Resource<Bitmap> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        String str = y.٬ݯح׭٩(576037934);
        if (Log.isLoggable(str, 2)) {
            StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1159316095)).append(decodeBitmap.getWidth());
            String str2 = y.ٴسسݬߨ(1392956602);
            Log.v(str, append.append(str2).append(decodeBitmap.getHeight()).append(y.٬ݯح׭٩(576038182)).append(i).append(str2).append(i2).append("]").toString());
        }
        return new BitmapResource(decodeBitmap, this.bitmapPool);
    }
}
