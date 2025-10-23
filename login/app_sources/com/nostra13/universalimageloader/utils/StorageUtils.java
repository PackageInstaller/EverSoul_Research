package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import com.liapp.y;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StorageUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getCacheDirectory(Context context, boolean z) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        File externalCacheDir = (z && "mounted".equals(str) && hasExternalStoragePermission(context)) ? getExternalCacheDir(context) : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        String str2 = y.٬ݯح׭٩(576305254) + context.getPackageName() + "/cache/";
        C2591L.m724w(y.دײܮڳܯ(2051243725), str2);
        return new File(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getIndividualCacheDirectory(Context context) {
        return getIndividualCacheDirectory(context, y.ۮڭڭܬި(862871523));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getIndividualCacheDirectory(Context context, String str) {
        File cacheDirectory = getCacheDirectory(context);
        File file = new File(cacheDirectory, str);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getOwnCacheDirectory(Context context, String str) {
        File file = (y.٬ݯح׭٩(576305918).equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) ? new File(Environment.getExternalStorageDirectory(), str) : null;
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getOwnCacheDirectory(Context context, String str, boolean z) {
        File file = (z && "mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) ? new File(Environment.getExternalStorageDirectory(), str) : null;
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), y.ݮڮֲڭܩ(-628208940)), y.دײܮڳܯ(2051550101)), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                C2591L.m724w("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                C2591L.m723i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission(y.دײܮڳܯ(2051243365)) == 0;
    }
}
