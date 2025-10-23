package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.liapp.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final ThumbnailStreamOpener opener;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return build(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return build(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ThumbFetcher build(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.get(context).getRegistry().getImageHeaderParsers(), thumbnailQuery, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream openThumbInputStream = openThumbInputStream();
            this.inputStream = openThumbInputStream;
            dataCallback.onDataReady(openThumbInputStream);
        } catch (FileNotFoundException e) {
            String str = y.ٲٴݴ״ٰ(1781791624);
            if (Log.isLoggable(str, 3)) {
                Log.d(str, y.ݮڮֲڭܩ(-628961012), e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InputStream openThumbInputStream() throws FileNotFoundException {
        InputStream open = this.opener.open(this.mediaStoreImageUri);
        int orientation = open != null ? this.opener.getOrientation(this.mediaStoreImageUri) : -1;
        return orientation != -1 ? new ExifOrientationStream(open, orientation) : open;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {y.ٴسسݬߨ(1392962282)};
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final ContentResolver contentResolver;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, y.ٴسسݬߨ(1392962458), new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {y.ٴسسݬߨ(1392962282)};
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final ContentResolver contentResolver;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, y.٬ݯح׭٩(576007902), new String[]{uri.getLastPathSegment()}, null);
        }
    }
}
