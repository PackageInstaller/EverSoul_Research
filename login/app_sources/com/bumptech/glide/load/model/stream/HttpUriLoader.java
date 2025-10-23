package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.liapp.y;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class HttpUriLoader implements ModelLoader<Uri, InputStream> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(y.٬ݯح׭٩(576051006), y.٬ݯح׭٩(576050958))));
    private final ModelLoader<GlideUrl, InputStream> urlLoader;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.urlLoader = modelLoader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(Uri uri, int i, int i2, Options options) {
        return this.urlLoader.buildLoadData(new GlideUrl(uri.toString()), i, i2, options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
        }
    }
}
