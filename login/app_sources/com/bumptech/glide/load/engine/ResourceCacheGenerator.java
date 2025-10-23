package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.liapp.y;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;

    /* renamed from: cb */
    private final DataFetcherGenerator.FetcherReadyCallback f160cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private Key sourceKey;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f160cb = fetcherReadyCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        List<Key> cacheKeys = this.helper.getCacheKeys();
        boolean z = false;
        if (cacheKeys.isEmpty()) {
            return false;
        }
        List<Class<?>> registeredResourceClasses = this.helper.getRegisteredResourceClasses();
        if (registeredResourceClasses.isEmpty()) {
            if (File.class.equals(this.helper.getTranscodeClass())) {
                return false;
            }
            throw new IllegalStateException(y.ٲٴݴ״ٰ(1781776888) + this.helper.getModelClass() + y.ݮڮֲڭܩ(-628954020) + this.helper.getTranscodeClass());
        }
        while (true) {
            if (this.modelLoaders == null || !hasNextModelLoader()) {
                int i = this.resourceClassIndex + 1;
                this.resourceClassIndex = i;
                if (i >= registeredResourceClasses.size()) {
                    int i2 = this.sourceIdIndex + 1;
                    this.sourceIdIndex = i2;
                    if (i2 >= cacheKeys.size()) {
                        return false;
                    }
                    this.resourceClassIndex = 0;
                }
                Key key = cacheKeys.get(this.sourceIdIndex);
                Class<?> cls = registeredResourceClasses.get(this.resourceClassIndex);
                this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), key, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(cls), cls, this.helper.getOptions());
                File file = this.helper.getDiskCache().get(this.currentKey);
                this.cacheFile = file;
                if (file != null) {
                    this.sourceKey = key;
                    this.modelLoaders = this.helper.getModelLoaders(file);
                    this.modelLoaderIndex = 0;
                }
            } else {
                this.loadData = null;
                while (!z && hasNextModelLoader()) {
                    List<ModelLoader<File, ?>> list = this.modelLoaders;
                    int i3 = this.modelLoaderIndex;
                    this.modelLoaderIndex = i3 + 1;
                    this.loadData = list.get(i3).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.f160cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception exc) {
        this.f160cb.onDataFetcherFailed(this.currentKey, exc, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
