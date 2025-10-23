package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.liapp.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getOrientation(Uri uri) {
        String str = y.ٲٴݴ״ٰ(1781791040);
        String str2 = y.֬ڱܱײٮ(-1159283447);
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.contentResolver.openInputStream(uri);
                int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return orientation;
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, str2 + uri, e);
                }
                if (inputStream == null) {
                    return -1;
                }
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused2) {
                    return -1;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream open(Uri uri) throws FileNotFoundException {
        String path = getPath(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.service.get(path);
        if (!isValid(file)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(fromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException(y.ݬֲ֮ܲت(1513081727) + uri + y.ݮڮֲڭܩ(-628959956) + fromFile).initCause(e));
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0052: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:27:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getPath(android.net.Uri r7) {
        /*
            r6 = this;
            r0 = 1781791040(0x6a33f940, float:5.4393693E25)
            java.lang.String r0 = com.liapp.y.ٲٴݴ״ٰ(r0)
            r1 = -628960580(0xffffffffda82d2bc, float:-1.8411726E16)
            java.lang.String r1 = com.liapp.y.ݮڮֲڭܩ(r1)
            r2 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r3 = r6.query     // Catch: java.lang.Throwable -> L30 java.lang.SecurityException -> L32
            android.database.Cursor r3 = r3.query(r7)     // Catch: java.lang.Throwable -> L30 java.lang.SecurityException -> L32
            if (r3 == 0) goto L2a
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.SecurityException -> L28 java.lang.Throwable -> L51
            if (r4 == 0) goto L2a
            r4 = 0
            java.lang.String r7 = r3.getString(r4)     // Catch: java.lang.SecurityException -> L28 java.lang.Throwable -> L51
            if (r3 == 0) goto L27
            r3.close()
        L27:
            return r7
        L28:
            r4 = move-exception
            goto L34
        L2a:
            if (r3 == 0) goto L2f
            r3.close()
        L2f:
            return r2
        L30:
            r7 = move-exception
            goto L53
        L32:
            r4 = move-exception
            r3 = r2
        L34:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L4b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.StringBuilder r7 = r5.append(r7)     // Catch: java.lang.Throwable -> L51
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L51
            android.util.Log.d(r0, r7, r4)     // Catch: java.lang.Throwable -> L51
        L4b:
            if (r3 == 0) goto L50
            r3.close()
        L50:
            return r2
        L51:
            r7 = move-exception
            r2 = r3
        L53:
            if (r2 == 0) goto L58
            r2.close()
        L58:
            throw r7
            fill-array 0x005a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.getPath(android.net.Uri):java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValid(File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }
}
