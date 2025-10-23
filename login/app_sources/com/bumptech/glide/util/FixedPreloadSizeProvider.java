package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader;

/* loaded from: classes.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FixedPreloadSizeProvider(int i, int i2) {
        this.size = new int[]{i, i2};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i, int i2) {
        return this.size;
    }
}
