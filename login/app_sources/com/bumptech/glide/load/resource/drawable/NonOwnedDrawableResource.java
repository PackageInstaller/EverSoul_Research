package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Resource<Drawable> newInstance(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }
}
