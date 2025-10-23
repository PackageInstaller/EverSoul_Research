package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskCacheAdapter implements DiskCache {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
    }

    public static final class Factory implements DiskCache.Factory {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }
}
