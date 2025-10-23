package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

/* loaded from: classes.dex */
public final class ContentResolverCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ContentResolverCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Object cancellationSignalObject;
        if (cancellationSignal != null) {
            try {
                cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
            } catch (Exception e) {
                if (e instanceof OperationCanceledException) {
                    throw new androidx.core.os.OperationCanceledException();
                }
                throw e;
            }
        } else {
            cancellationSignalObject = null;
        }
        return Api16Impl.query(contentResolver, uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) cancellationSignalObject);
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, android.os.CancellationSignal cancellationSignal) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
    }
}
