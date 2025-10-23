package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes3.dex */
public class BaseImageDownloader implements ImageDownloader {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaseImageDownloader(Context context) {
        this(context, DEFAULT_HTTP_CONNECT_TIMEOUT, 20000);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaseImageDownloader(Context context, int i, int i2) {
        this.context = context.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }

    /* renamed from: com.nostra13.universalimageloader.core.download.BaseImageDownloader$1 */
    static /* synthetic */ class C25891 {

        /* renamed from: $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme */
        static final /* synthetic */ int[] f1139x4730d1a3;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f1139x4730d1a3 = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1139x4730d1a3[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1139x4730d1a3[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1139x4730d1a3[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1139x4730d1a3[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1139x4730d1a3[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1139x4730d1a3[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (C25891.f1139x4730d1a3[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return getStreamFromNetwork(str, obj);
            case 3:
                return getStreamFromFile(str, obj);
            case 4:
                return getStreamFromContent(str, obj);
            case 5:
                return getStreamFromAssets(str, obj);
            case 6:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        HttpURLConnection createConnection = createConnection(str, obj);
        for (int i = 0; createConnection.getResponseCode() / 100 == 3 && i < 5; i++) {
            createConnection = createConnection(createConnection.getHeaderField(y.ٲٴݴ״ٰ(1781635520)), obj);
        }
        try {
            InputStream inputStream = createConnection.getInputStream();
            if (!shouldBeProcessed(createConnection)) {
                IoUtils.closeSilently(inputStream);
                throw new IOException(y.دײܮڳܯ(2051236589) + createConnection.getResponseCode());
            }
            return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
        } catch (IOException e) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean shouldBeProcessed(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getResponseCode() == 200;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected HttpURLConnection createConnection(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection()));
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getStreamFromFile(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        if (isVideoFileUri(str)) {
            return getVideoThumbnailStream(crop);
        }
        return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InputStream getVideoThumbnailStream(String str) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        if (createVideoThumbnail == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getStreamFromContent(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVideoContentUri(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(y.֬ڱܱײٮ(-1159054679))) {
            return getContactPhotoStream(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getContactPhotoStream(Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(this.context.getContentResolver(), uri, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getStreamFromAssets(String str, Object obj) throws IOException {
        return this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream getStreamFromOtherSource(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        return type != null && type.startsWith(y.ݬֲ֮ܲت(1512262863));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith(y.ݬֲ֮ܲت(1512262863));
    }
}
