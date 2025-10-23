package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.android.volley.http.HttpEntity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes5.dex */
class RawDocumentFile extends DocumentFile {
    private File mFile;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.mFile = file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.mFile, str2);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        File file = new File(this.mFile, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return this.mFile.getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return this.mFile.length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return this.mFile.exists();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.mFile.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                arrayList.add(new RawDocumentFile(this, file));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        File file = new File(this.mFile.getParentFile(), str);
        if (!this.mFile.renameTo(file)) {
            return false;
        }
        this.mFile = file;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getTypeForName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return HttpEntity.APPLICATION_OCTET_STREAM;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : HttpEntity.APPLICATION_OCTET_STREAM;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }
}
