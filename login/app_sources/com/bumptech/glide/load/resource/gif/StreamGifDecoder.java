package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.liapp.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder<ByteBuffer, GifDrawable> byteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.parsers = list;
        this.byteBufferDecoder = resourceDecoder;
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) throws IOException {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool) == ImageHeaderParser.ImageType.GIF;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<GifDrawable> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        if (inputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(inputStreamToBytes), i, i2, options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            String str = y.ٴسسݬߨ(1393004826);
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, y.֬ڱܱײٮ(-1159275887), e);
            return null;
        }
    }
}
