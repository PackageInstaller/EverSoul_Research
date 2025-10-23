package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {
    private static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final String BUCKET_GIF = "Gif";
    private static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final DataRewinderRegistry dataRewinderRegistry;
    private final ResourceDecoderRegistry decoderRegistry;
    private final EncoderRegistry encoderRegistry;
    private final ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final ModelLoaderRegistry modelLoaderRegistry;
    private final ResourceEncoderRegistry resourceEncoderRegistry;
    private final Pools.Pool<List<Throwable>> throwableListPool;
    private final TranscoderRegistry transcoderRegistry;
    private final ModelToResourceClassCache modelToResourceClassCache = new ModelToResourceClassCache();
    private final LoadPathCache loadPathCache = new LoadPathCache();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Registry() {
        Pools.Pool<List<Throwable>> threadSafeList = FactoryPools.threadSafeList();
        this.throwableListPool = threadSafeList;
        this.modelLoaderRegistry = new ModelLoaderRegistry(threadSafeList);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList(y.ۮڭڭܬި(862005331), y.֬ڱܱײٮ(-1159389799), y.٬ݯح׭٩(576095446)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public <Data> Registry register(Class<Data> cls, Encoder<Data> encoder) {
        return append(cls, encoder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data> Registry append(Class<Data> cls, Encoder<Data> encoder) {
        this.encoderRegistry.append(cls, encoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data> Registry prepend(Class<Data> cls, Encoder<Data> encoder) {
        this.encoderRegistry.prepend(cls, encoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data, TResource> Registry append(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        append(y.٬ݯح׭٩(576027678), cls, cls2, resourceDecoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data, TResource> Registry append(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.append(str, resourceDecoder, cls, cls2);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data, TResource> Registry prepend(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        prepend(y.ݬֲ֮ܲت(1513067327), cls, cls2, resourceDecoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data, TResource> Registry prepend(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.prepend(str, resourceDecoder, cls, cls2);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Registry setResourceDecoderBucketPriorityList(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, y.ݬֲ֮ܲت(1513067327));
        arrayList.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(arrayList);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public <TResource> Registry register(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        return append((Class) cls, (ResourceEncoder) resourceEncoder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <TResource> Registry append(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.append(cls, resourceEncoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <TResource> Registry prepend(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.prepend(cls, resourceEncoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Registry register(DataRewinder.Factory<?> factory) {
        this.dataRewinderRegistry.register(factory);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <TResource, Transcode> Registry register(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.transcoderRegistry.register(cls, cls2, resourceTranscoder);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Registry register(ImageHeaderParser imageHeaderParser) {
        this.imageHeaderParserRegistry.add(imageHeaderParser);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Model, Data> Registry append(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.append(cls, cls2, modelLoaderFactory);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Model, Data> Registry prepend(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.prepend(cls, cls2, modelLoaderFactory);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Model, Data> Registry replace(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.modelLoaderRegistry.replace(cls, cls2, modelLoaderFactory);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath = this.loadPathCache.get(cls, cls2, cls3);
        if (this.loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath == null) {
            List<DecodePath<Data, TResource, Transcode>> decodePaths = getDecodePaths(cls, cls2, cls3);
            loadPath = decodePaths.isEmpty() ? null : new LoadPath<>(cls, cls2, cls3, decodePaths, this.throwableListPool);
            this.loadPathCache.put(cls, cls2, cls3, loadPath);
        }
        return loadPath;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.decoderRegistry.getResourceClasses(cls, cls2)) {
            for (Class cls5 : this.transcoderRegistry.getTranscodeClasses(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.decoderRegistry.getDecoders(cls, cls4), this.transcoderRegistry.get(cls4, cls5), this.throwableListPool));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> list = this.modelToResourceClassCache.get(cls, cls2, cls3);
        if (list == null) {
            list = new ArrayList<>();
            Iterator<Class<?>> it = this.modelLoaderRegistry.getDataClasses(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.decoderRegistry.getResourceClasses(it.next(), cls2)) {
                    if (!this.transcoderRegistry.getTranscodeClasses(cls4, cls3).isEmpty() && !list.contains(cls4)) {
                        list.add(cls4);
                    }
                }
            }
            this.modelToResourceClassCache.put(cls, cls2, cls3, Collections.unmodifiableList(list));
        }
        return list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <X> ResourceEncoder<X> getResultEncoder(Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new NoResultEncoderAvailableException(resource.getResourceClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <X> Encoder<X> getSourceEncoder(X x) throws NoSourceEncoderAvailableException {
        Encoder<X> encoder = this.encoderRegistry.getEncoder(x.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <X> DataRewinder<X> getRewinder(X x) {
        return this.dataRewinderRegistry.build(x);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model model) {
        List<ModelLoader<Model, ?>> modelLoaders = this.modelLoaderRegistry.getModelLoaders(model);
        if (modelLoaders.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return modelLoaders;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> parsers = this.imageHeaderParserRegistry.getParsers();
        if (parsers.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return parsers;
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NoModelLoaderAvailableException(Object obj) {
            super(y.ݬֲ֮ܲت(1513066047) + obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super(y.ݬֲ֮ܲت(1513066047) + cls + y.ٲٴݴ״ٰ(1781774360) + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NoResultEncoderAvailableException(Class<?> cls) {
            super(y.٬ݯح׭٩(576021318) + cls + y.ٴسسݬߨ(1392943434));
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super(y.ݬֲ֮ܲت(1513067831) + cls);
        }
    }

    public static class MissingComponentException extends RuntimeException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NoImageHeaderParserException() {
            super(y.֬ڱܱײٮ(-1159268031));
        }
    }
}
