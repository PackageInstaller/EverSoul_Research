package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DiskLruCacheFactory(final String str, long j) {
        this(new CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str);
            }
        }, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DiskLruCacheFactory(final String str, final String str2, long j) {
        this(new CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str, str2);
            }
        }, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.diskCacheSize = j;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.create(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }
}
