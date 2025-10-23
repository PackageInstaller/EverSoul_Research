package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import com.liapp.y;
import com.nostra13.universalimageloader.utils.C2591L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class LimitedMemoryCache extends BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<Bitmap> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    protected abstract int getSize(Bitmap bitmap);

    protected abstract Bitmap removeNext();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LimitedMemoryCache(int i) {
        this.sizeLimit = i;
        if (i > 16777216) {
            C2591L.m724w(y.֬ڱܱײٮ(-1159043359), 16);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        boolean z;
        int size = getSize(bitmap);
        int sizeLimit = getSizeLimit();
        int i = this.cacheSize.get();
        if (size < sizeLimit) {
            while (i + size > sizeLimit) {
                Bitmap removeNext = removeNext();
                if (this.hardCache.remove(removeNext)) {
                    i = this.cacheSize.addAndGet(-getSize(removeNext));
                }
            }
            this.hardCache.add(bitmap);
            this.cacheSize.addAndGet(size);
            z = true;
        } else {
            z = false;
        }
        super.put(str, bitmap);
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null && this.hardCache.remove(bitmap)) {
            this.cacheSize.addAndGet(-getSize(bitmap));
        }
        return super.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCache
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getSizeLimit() {
        return this.sizeLimit;
    }
}
