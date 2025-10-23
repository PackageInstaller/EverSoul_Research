package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> uriLoader;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(String str) {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.uriLoader = modelLoader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(String str, int i, int i2, Options options) {
        Uri parseUri = parseUri(str);
        if (parseUri == null || !this.uriLoader.handles(parseUri)) {
            return null;
        }
        return this.uriLoader.buildLoadData(parseUri, i, i2, options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Uri parseUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return toFileUri(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? toFileUri(str) : parse;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Uri toFileUri(String str) {
        return Uri.fromFile(new File(str));
    }

    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }
    }
}
