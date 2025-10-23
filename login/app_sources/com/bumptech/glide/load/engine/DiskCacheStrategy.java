package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy NONE = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };
    public static final DiskCacheStrategy DATA = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.3
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy RESOURCE = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.4
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy AUTOMATIC = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.5
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource dataSource);

    public abstract boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
