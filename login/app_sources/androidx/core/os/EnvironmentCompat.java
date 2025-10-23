package androidx.core.os;

import android.os.Environment;
import java.io.File;

/* loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getStorageState(File file) {
        return Api21Impl.getExternalStorageState(file);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EnvironmentCompat() {
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getExternalStorageState(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getStorageState(File file) {
            return Environment.getStorageState(file);
        }
    }
}
