package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* loaded from: classes.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((GifDrawable) this.drawable).getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((GifDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }
}
