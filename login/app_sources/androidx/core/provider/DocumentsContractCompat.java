package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DocumentCompat() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContractApi19Impl.isDocumentUri(context, uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isTreeUri(Uri uri) {
        return DocumentsContractApi24Impl.isTreeUri(uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getDocumentId(Uri uri) {
        return DocumentsContractApi19Impl.getDocumentId(uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getTreeDocumentId(Uri uri) {
        return DocumentsContractApi21Impl.getTreeDocumentId(uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri buildDocumentUri(String str, String str2) {
        return DocumentsContractApi19Impl.buildDocumentUri(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri buildDocumentUriUsingTree(Uri uri, String str) {
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(uri, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri buildTreeDocumentUri(String str, String str2) {
        return DocumentsContractApi21Impl.buildTreeDocumentUri(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri buildChildDocumentsUri(String str, String str2) {
        return DocumentsContractApi21Impl.buildChildDocumentsUri(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri buildChildDocumentsUriUsingTree(Uri uri, String str) {
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(uri, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri createDocument(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
        return DocumentsContractApi21Impl.createDocument(contentResolver, uri, str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri renameDocument(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        return DocumentsContractApi21Impl.renameDocument(contentResolver, uri, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean removeDocument(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
        return DocumentsContractApi24Impl.removeDocument(contentResolver, uri, uri2);
    }

    private static class DocumentsContractApi19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Uri buildDocumentUri(String str, String str2) {
            return DocumentsContract.buildDocumentUri(str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isDocumentUri(Context context, Uri uri) {
            return DocumentsContract.isDocumentUri(context, uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getDocumentId(Uri uri) {
            return DocumentsContract.getDocumentId(uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean deleteDocument(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(contentResolver, uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DocumentsContractApi19Impl() {
        }
    }

    private static class DocumentsContractApi21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getTreeDocumentId(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Uri buildTreeDocumentUri(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri buildDocumentUriUsingTree(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri buildChildDocumentsUri(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri buildChildDocumentsUriUsingTree(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri createDocument(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri renameDocument(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DocumentsContractApi21Impl() {
        }
    }

    private static class DocumentsContractApi24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isTreeUri(Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean removeDocument(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DocumentsContractApi24Impl() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DocumentsContractCompat() {
    }
}
