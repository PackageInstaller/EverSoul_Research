package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    public Bitmap getBitmap(Bitmap bitmap) {
        return bitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        super(transitionFactory);
    }
}
