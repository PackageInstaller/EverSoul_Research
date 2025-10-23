package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* loaded from: classes.dex */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DrawableTransitionOptions withCrossFade(int i) {
        return new DrawableTransitionOptions().crossFade(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder builder) {
        return new DrawableTransitionOptions().crossFade(builder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DrawableTransitionOptions with(TransitionFactory<Drawable> transitionFactory) {
        return new DrawableTransitionOptions().transition(transitionFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.Builder(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transition(drawableCrossFadeFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        return crossFade(builder.build());
    }
}
