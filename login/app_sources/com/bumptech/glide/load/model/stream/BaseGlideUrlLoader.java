package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<Model, GlideUrl> modelCache;

    protected abstract String getUrl(Model model, int i, int i2, Options options);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<Model, GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(Model model, int i, int i2, Options options) {
        ModelCache<Model, GlideUrl> modelCache = this.modelCache;
        GlideUrl glideUrl = modelCache != null ? modelCache.get(model, i, i2) : null;
        if (glideUrl == null) {
            String url = getUrl(model, i, i2, options);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(model, i, i2, options));
            ModelCache<Model, GlideUrl> modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(model, i, i2, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List<String> alternateUrls = getAlternateUrls(model, i, i2, options);
        ModelLoader.LoadData<InputStream> buildLoadData = this.concreteLoader.buildLoadData(glideUrl, i, i2, options);
        return (buildLoadData == null || alternateUrls.isEmpty()) ? buildLoadData : new ModelLoader.LoadData<>(buildLoadData.sourceKey, getAlternateKeys(alternateUrls), buildLoadData.fetcher);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static List<Key> getAlternateKeys(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new GlideUrl(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected List<String> getAlternateUrls(Model model, int i, int i2, Options options) {
        return Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Headers getHeaders(Model model, int i, int i2, Options options) {
        return Headers.DEFAULT;
    }
}
