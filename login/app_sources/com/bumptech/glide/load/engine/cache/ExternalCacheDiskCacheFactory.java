package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.liapp.y;
import java.io.File;

@Deprecated
/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, y.ݮڮֲڭܩ(-629049964), DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, y.ݮڮֲڭܩ(-629049964), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, i);
    }
}
