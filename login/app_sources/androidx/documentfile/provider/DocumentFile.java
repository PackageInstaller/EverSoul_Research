package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.File;

/* loaded from: classes5.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public abstract String getName();

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DocumentFile fromFile(File file) {
        return new RawDocumentFile(null, file);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        return new SingleDocumentFile(null, context, uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        return new TreeDocumentFile(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DocumentFile getParentFile() {
        return this.mParent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DocumentFile findFile(String str) {
        for (DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }
}
