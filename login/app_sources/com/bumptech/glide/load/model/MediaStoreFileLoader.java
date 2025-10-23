package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.liapp.y;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MediaStoreFileLoader(Context context) {
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<File> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new FilePathFetcher(this.context, uri));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return MediaStoreUtil.isMediaStoreUri(uri);
    }

    private static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = {y.ٴسسݬߨ(1392962282)};
        private final Context context;
        private final Uri uri;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FilePathFetcher(Context context, Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                dataCallback.onLoadFailed(new FileNotFoundException(y.٬ݯح׭٩(576049398) + this.uri));
            } else {
                dataCallback.onDataReady(new File(r0));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<File> getDataClass() {
            return File.class;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Factory(Context context) {
            this.context = context;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.context);
        }
    }
}
