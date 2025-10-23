package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    interface DecodeCallback<ResourceType> {
        Resource<ResourceType> onResourceDecoded(Resource<ResourceType> resource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i, i2, options)), options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i, int i2, Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i, i2, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, List<Throwable> list) throws GlideException {
        int size = this.decoders.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.decoders.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                String str = y.دײܮڳܯ(2052050637);
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, y.֬ڱܱײٮ(-1159294943) + resourceDecoder, e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, new ArrayList(list));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ۮڭڭܬި(862102731) + this.dataClass + y.ٲٴݴ״ٰ(1781780904) + this.decoders + y.ٴسسݬߨ(1392955258) + this.transcoder + '}';
    }
}
