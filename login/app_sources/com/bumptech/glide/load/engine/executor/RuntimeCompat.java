package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import com.liapp.y;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RuntimeCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getCoreCountPre17() {
        File[] fileArr;
        String str = y.ٲٴݴ״ٰ(1781733680);
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(CPU_LOCATION);
            final Pattern compile = Pattern.compile(CPU_NAME_REGEX);
            fileArr = file.listFiles(new FilenameFilter() { // from class: com.bumptech.glide.load.engine.executor.RuntimeCompat.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    return compile.matcher(str2).matches();
                }
            });
        } catch (Throwable th) {
            try {
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
