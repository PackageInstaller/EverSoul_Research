package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.liapp.y;
import java.io.File;

/* loaded from: classes.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, y.ݮڮֲڭܩ(-629049964), 262144000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, y.ݮڮֲڭܩ(-629049964), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExternalPreferredCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private File getInternalCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir;
                File internalCacheDirectory = getInternalCacheDirectory();
                return ((internalCacheDirectory == null || !internalCacheDirectory.exists()) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? str != null ? new File(externalCacheDir, str) : externalCacheDir : internalCacheDirectory;
            }
        }, j);
    }
}
