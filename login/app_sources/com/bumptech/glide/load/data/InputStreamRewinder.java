package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private static final int MARK_LIMIT = 5242880;
    private final RecyclableBufferedInputStream bufferedStream;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.bufferedStream = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(MARK_LIMIT);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataRewinder
    public InputStream rewindAndGet() throws IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.release();
    }

    public static final class Factory implements DataRewinder.Factory<InputStream> {
        private final ArrayPool byteArrayPool;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Factory(ArrayPool arrayPool) {
            this.byteArrayPool = arrayPool;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.byteArrayPool);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }
}
