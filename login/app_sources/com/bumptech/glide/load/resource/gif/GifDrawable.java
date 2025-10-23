package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final GifState state;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i, i2, bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.get(context), gifDecoder, i, i2, transformation, bitmap)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GifDrawable(GifState gifState) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (GifState) Preconditions.checkNotNull(gifState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GifDrawable(GifFrameLoader gifFrameLoader, Paint paint) {
        this(new GifState(gifFrameLoader));
        this.paint = paint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.state.frameLoader.setFrameTransformation(transformation, bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void resetLoopCount() {
        this.loopCount = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, y.ݮڮֲڭܩ(-628905348));
        this.state.frameLoader.setNextStartFromFirstFrame();
        start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startRunning() {
        Preconditions.checkArgument(!this.isRecycled, y.֬ڱܱײٮ(-1159211823));
        if (this.state.frameLoader.getFrameCount() == 1) {
            invalidateSelf();
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            this.state.frameLoader.subscribe(this);
            invalidateSelf();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.checkArgument(!this.isRecycled, y.٬ݯح׭٩(575948166));
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setIsRunning(boolean z) {
        this.isRunning = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
            this.applyGravity = false;
        }
        canvas.drawBitmap(this.state.frameLoader.getCurrentFrame(), (Rect) null, getDestRect(), getPaint());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Rect getDestRect() {
        if (this.destRect == null) {
            this.destRect = new Rect();
        }
        return this.destRect;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Paint getPaint() {
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable.Callback findCallback() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void onFrameReady() {
        if (findCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.loopCount++;
        }
        int i = this.maxLoopCount;
        if (i == -1 || this.loopCount < i) {
            return;
        }
        notifyAnimationEndToListeners();
        stop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void notifyAnimationEndToListeners() {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.animationCallbacks.get(i).onAnimationEnd(this);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isRecycled() {
        return this.isRecycled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLoopCount(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1393002066));
        }
        if (i == 0) {
            int loopCount = this.state.frameLoader.getLoopCount();
            this.maxLoopCount = loopCount != 0 ? loopCount : -1;
        } else {
            this.maxLoopCount = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        this.animationCallbacks.add(animationCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null) {
            list.clear();
        }
    }

    static final class GifState extends Drawable.ConstantState {
        final GifFrameLoader frameLoader;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        GifState(GifFrameLoader gifFrameLoader) {
            this.frameLoader = gifFrameLoader;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }
}
