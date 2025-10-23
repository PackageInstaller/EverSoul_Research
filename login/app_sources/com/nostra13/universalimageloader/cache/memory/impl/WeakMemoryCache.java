package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.BaseMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class WeakMemoryCache extends BaseMemoryCache {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache
    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
