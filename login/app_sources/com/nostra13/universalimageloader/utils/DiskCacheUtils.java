package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import java.io.File;

/* loaded from: classes3.dex */
public final class DiskCacheUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DiskCacheUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File findInCache(String str, DiskCache diskCache) {
        File file = diskCache.get(str);
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean removeFromCache(String str, DiskCache diskCache) {
        File file = diskCache.get(str);
        return file != null && file.exists() && file.delete();
    }
}
