package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LimitedAgeMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Map<String, Long> loadingDates = Collections.synchronizedMap(new HashMap());
    private final long maxAge;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LimitedAgeMemoryCache(MemoryCache memoryCache, long j) {
        this.cache = memoryCache;
        this.maxAge = j * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        boolean put = this.cache.put(str, bitmap);
        if (put) {
            this.loadingDates.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return put;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap get(String str) {
        Long l = this.loadingDates.get(str);
        if (l != null && System.currentTimeMillis() - l.longValue() > this.maxAge) {
            this.cache.remove(str);
            this.loadingDates.remove(str);
        }
        return this.cache.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        this.loadingDates.remove(str);
        return this.cache.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        return this.cache.keys();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public void clear() {
        this.cache.clear();
        this.loadingDates.clear();
    }
}
