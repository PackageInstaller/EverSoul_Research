package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPreloadSizeProvider() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewPreloadSizeProvider(View view) {
        SizeViewTarget sizeViewTarget = new SizeViewTarget(view);
        this.viewTarget = sizeViewTarget;
        sizeViewTarget.getSize(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i, int i2) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        this.size = new int[]{i, i2};
        this.viewTarget = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setView(View view) {
        if (this.size == null && this.viewTarget == null) {
            SizeViewTarget sizeViewTarget = new SizeViewTarget(view);
            this.viewTarget = sizeViewTarget;
            sizeViewTarget.getSize(this);
        }
    }

    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void onResourceCleared(Drawable drawable) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SizeViewTarget(View view) {
            super(view);
        }
    }
}
