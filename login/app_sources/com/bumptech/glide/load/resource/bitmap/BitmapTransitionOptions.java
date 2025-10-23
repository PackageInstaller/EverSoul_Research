package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* loaded from: classes.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapTransitionOptions withCrossFade(int i) {
        return new BitmapTransitionOptions().crossFade(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder builder) {
        return new BitmapTransitionOptions().crossFade(builder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapTransitionOptions withWrapped(TransitionFactory<Drawable> transitionFactory) {
        return new BitmapTransitionOptions().transitionUsing(transitionFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BitmapTransitionOptions with(TransitionFactory<Bitmap> transitionFactory) {
        return new BitmapTransitionOptions().transition(transitionFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.Builder(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transitionUsing(drawableCrossFadeFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapTransitionOptions transitionUsing(TransitionFactory<Drawable> transitionFactory) {
        return transition(new BitmapTransitionFactory(transitionFactory));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        return transitionUsing(builder.build());
    }
}
