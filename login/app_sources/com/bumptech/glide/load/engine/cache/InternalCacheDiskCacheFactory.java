package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.liapp.y;
import java.io.File;

/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, y.ݮڮֲڭܩ(-629049964), 262144000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, y.ݮڮֲڭܩ(-629049964), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j);
    }
}
