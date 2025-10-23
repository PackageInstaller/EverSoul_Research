package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseMemoryCache implements MemoryCache {
    private final Map<String, Reference<Bitmap>> softMap = Collections.synchronizedMap(new HashMap());

    protected abstract Reference<Bitmap> createReference(Bitmap bitmap);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap get(String str) {
        Reference<Bitmap> reference = this.softMap.get(str);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        this.softMap.put(str, createReference(bitmap));
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        Reference<Bitmap> remove = this.softMap.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public void clear() {
        this.softMap.clear();
    }
}
