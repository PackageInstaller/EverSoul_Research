package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class FuzzyKeyMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Comparator<String> keyComparator;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FuzzyKeyMemoryCache(MemoryCache memoryCache, Comparator<String> comparator) {
        this.cache = memoryCache;
        this.keyComparator = comparator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        String str2;
        synchronized (this.cache) {
            Iterator<String> it = this.cache.keys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                str2 = it.next();
                if (this.keyComparator.compare(str, str2) == 0) {
                    break;
                }
            }
            if (str2 != null) {
                this.cache.remove(str2);
            }
        }
        return this.cache.put(str, bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap get(String str) {
        return this.cache.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        return this.cache.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public void clear() {
        this.cache.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        return this.cache.keys();
    }
}
