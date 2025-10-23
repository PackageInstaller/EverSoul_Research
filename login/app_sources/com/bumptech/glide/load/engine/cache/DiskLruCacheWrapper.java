package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.liapp.y;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();
    private final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, j);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DiskCache create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.directory = file;
        this.maxSize = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        String str = y.ݬֲ֮ܲت(1513034551);
        if (Log.isLoggable(str, 2)) {
            Log.v(str, y.ٲٴݴ״ٰ(1781736816) + safeKey + y.ٴسسݬߨ(1392917170) + key);
        }
        try {
            DiskLruCache.Value value = getDiskCache().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, y.ٴسسݬߨ(1392917298), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache diskCache;
        String str = y.ݬֲ֮ܲت(1513034551);
        String str2 = y.٬ݯح׭٩(576057430);
        String str3 = y.ٲٴݴ״ٰ(1781738104);
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(safeKey);
        try {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, str3 + safeKey + " for for Key: " + key);
            }
            try {
                diskCache = getDiskCache();
            } catch (IOException e) {
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Unable to put to disk cache", e);
                }
            }
            if (diskCache.get(safeKey) != null) {
                return;
            }
            DiskLruCache.Editor edit = diskCache.edit(safeKey);
            if (edit == null) {
                throw new IllegalStateException(str2 + safeKey);
            }
            try {
                if (writer.write(edit.getFile(0))) {
                    edit.commit();
                }
                edit.abortUnlessCommitted();
            } catch (Throwable th) {
                edit.abortUnlessCommitted();
                throw th;
            }
        } finally {
            this.writeLocker.release(safeKey);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException e) {
            String str = y.ݬֲ֮ܲت(1513034551);
            if (Log.isLoggable(str, 5)) {
                Log.w(str, y.ݬֲ֮ܲت(1513034447), e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            try {
                getDiskCache().delete();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);
                }
            }
        } finally {
            resetDiskCache();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }
}
