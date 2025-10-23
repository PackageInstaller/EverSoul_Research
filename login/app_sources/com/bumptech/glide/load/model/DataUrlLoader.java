package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.liapp.y;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final DataDecoder<Data> dataDecoder;

    public interface DataDecoder<Data> {
        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;

        Class<Data> getDataClass();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.dataDecoder = dataDecoder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(Model model, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.dataDecoder));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Model model) {
        return model.toString().startsWith(y.֬ڱܱײٮ(-1159315343));
    }

    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        private Data data;
        private final String dataUri;
        private final DataDecoder<Data> reader;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.dataUri = str;
            this.reader = dataDecoder;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data decode = this.reader.decode(this.dataUri);
                this.data = decode;
                dataCallback.onDataReady(decode);
            } catch (IllegalArgumentException e) {
                dataCallback.onLoadFailed(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            try {
                this.reader.close(this.data);
            } catch (IOException unused) {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return this.reader.getDataClass();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
        private final DataDecoder<InputStream> opener = new DataDecoder<InputStream>() { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public InputStream decode(String str) {
                if (!str.startsWith(y.֬ڱܱײٮ(-1159315343))) {
                    throw new IllegalArgumentException(y.ݮڮֲڭܩ(-629003372));
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException(y.دײܮڳܯ(2052005013));
                }
                if (!str.substring(0, indexOf).endsWith(y.٬ݯح׭٩(576051614))) {
                    throw new IllegalArgumentException(y.ۮڭڭܬި(862090435));
                }
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        };

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Model, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.opener);
        }
    }
}
