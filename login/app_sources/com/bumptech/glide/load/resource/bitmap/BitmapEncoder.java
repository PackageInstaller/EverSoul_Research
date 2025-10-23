package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.liapp.y;

/* loaded from: classes.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory(y.ٴسسݬߨ(1392929266), 90);
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory(y.ݮڮֲڭܩ(-628990036));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapEncoder(ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0083 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #5 {all -> 0x00d7, blocks: (B:3:0x0032, B:15:0x005c, B:18:0x007d, B:20:0x0083, B:46:0x00d3, B:44:0x00d6, B:38:0x0078), top: B:2:0x0032 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.Options r11) {
        /*
            r8 = this;
            r0 = 1392928282(0x5306661a, float:5.772386E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            r1 = -628993300(0xffffffffda8252ec, float:-1.834146E16)
            java.lang.String r1 = com.liapp.y.ݮڮֲڭܩ(r1)
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r2 = r8.getFormat(r9, r11)
            int r3 = r9.getWidth()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r9.getHeight()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 1392928546(0x53066722, float:5.772559E11)
            java.lang.String r5 = com.liapp.y.ٴسسݬߨ(r5)
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r5, r3, r4, r2)
            long r3 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch: java.lang.Throwable -> Ld7
            com.bumptech.glide.load.Option<java.lang.Integer> r5 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_QUALITY     // Catch: java.lang.Throwable -> Ld7
            java.lang.Object r5 = r11.get(r5)     // Catch: java.lang.Throwable -> Ld7
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> Ld7
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> Ld7
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r10 = r8.arrayPool     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            if (r10 == 0) goto L55
            com.bumptech.glide.load.data.BufferedOutputStream r10 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r8.arrayPool     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            r6 = r10
            goto L56
        L55:
            r6 = r7
        L56:
            r9.compress(r2, r5, r6)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            r6.close()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            r6.close()     // Catch: java.io.IOException -> L5f java.lang.Throwable -> Ld7
        L5f:
            r10 = 1
            goto L7c
        L61:
            r9 = move-exception
            r6 = r7
            goto Ld1
        L64:
            r10 = move-exception
            r6 = r7
            goto L6a
        L67:
            r9 = move-exception
            goto Ld1
        L69:
            r10 = move-exception
        L6a:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L67
            if (r5 == 0) goto L76
            java.lang.String r5 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r5, r10)     // Catch: java.lang.Throwable -> L67
        L76:
            if (r6 == 0) goto L7b
            r6.close()     // Catch: java.io.IOException -> L7b java.lang.Throwable -> Ld7
        L7b:
            r10 = 0
        L7c:
            r5 = 2
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> Ld7
            if (r5 == 0) goto Lcd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r1 = r5.append(r2)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r2 = " of size "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld7
            int r2 = com.bumptech.glide.util.Util.getBitmapByteSize(r9)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r2 = " in "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld7
            double r2 = com.bumptech.glide.util.LogTime.getElapsedMillis(r3)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r2 = ", options format: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ld7
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r2 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT     // Catch: java.lang.Throwable -> Ld7
            java.lang.Object r11 = r11.get(r2)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r11 = r1.append(r11)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r1 = ", hasAlpha: "
            java.lang.StringBuilder r11 = r11.append(r1)     // Catch: java.lang.Throwable -> Ld7
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r9 = r11.append(r9)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Ld7
            android.util.Log.v(r0, r9)     // Catch: java.lang.Throwable -> Ld7
        Lcd:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r10
        Ld1:
            if (r6 == 0) goto Ld6
            r6.close()     // Catch: java.io.IOException -> Ld6 java.lang.Throwable -> Ld7
        Ld6:
            throw r9     // Catch: java.lang.Throwable -> Ld7
        Ld7:
            r9 = move-exception
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r9
            fill-array 0x00dc: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
