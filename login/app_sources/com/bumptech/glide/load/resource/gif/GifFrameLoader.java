package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;
    private int width;

    public interface FrameCallback {
        void onFrameReady();
    }

    interface OnEveryFrameListener {
        void onFrameReady();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), gifDecoder, null, getRequestBuilder(Glide.with(glide.getContext()), i, i2), transformation, bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.requestManager = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler;
        this.bitmapPool = bitmapPool;
        this.handler = handler;
        this.requestBuilder = requestBuilder;
        this.gifDecoder = gifDecoder;
        setFrameTransformation(transformation, bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.transformation = (Transformation) Preconditions.checkNotNull(transformation);
        this.firstFrame = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.requestBuilder = this.requestBuilder.apply((BaseRequestOptions<?>) new RequestOptions().transform(transformation));
        this.firstFrameSize = Util.getBitmapByteSize(bitmap);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void subscribe(FrameCallback frameCallback) {
        if (this.isCleared) {
            throw new IllegalStateException(y.دײܮڳܯ(2051971477));
        }
        if (this.callbacks.contains(frameCallback)) {
            throw new IllegalStateException(y.٬ݯح׭٩(575954670));
        }
        boolean isEmpty = this.callbacks.isEmpty();
        this.callbacks.add(frameCallback);
        if (isEmpty) {
            start();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void unsubscribe(FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getWidth() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getHeight() {
        return this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getSize() {
        return this.gifDecoder.getByteSize() + this.firstFrameSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCurrentIndex() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.index;
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void stop() {
        this.isRunning = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.requestManager.clear(delayTarget);
            this.current = null;
        }
        DelayTarget delayTarget2 = this.next;
        if (delayTarget2 != null) {
            this.requestManager.clear(delayTarget2);
            this.next = null;
        }
        DelayTarget delayTarget3 = this.pendingTarget;
        if (delayTarget3 != null) {
            this.requestManager.clear(delayTarget3);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        return delayTarget != null ? delayTarget.getResource() : this.firstFrame;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void loadNextFrame() {
        if (!this.isRunning || this.isLoadPending) {
            return;
        }
        if (this.startFromFirstFrame) {
            Preconditions.checkArgument(this.pendingTarget == null, y.دײܮڳܯ(2051972533));
            this.gifDecoder.resetFrameIndex();
            this.startFromFirstFrame = false;
        }
        DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.pendingTarget = null;
            onFrameReady(delayTarget);
            return;
        }
        this.isLoadPending = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.gifDecoder.getNextDelay();
        this.gifDecoder.advance();
        this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis);
        this.requestBuilder.apply((BaseRequestOptions<?>) RequestOptions.signatureOf(getFrameSignature())).load((Object) this.gifDecoder).into((RequestBuilder<Bitmap>) this.next);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void recycleFirstFrame() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.bitmapPool.put(bitmap);
            this.firstFrame = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setNextStartFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, y.ٴسسݬߨ(1393007002));
        this.startFromFirstFrame = true;
        DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.requestManager.clear(delayTarget);
            this.pendingTarget = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setOnEveryFrameReadyListener(OnEveryFrameListener onEveryFrameListener) {
        this.onEveryFrameListener = onEveryFrameListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void onFrameReady(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.onEveryFrameListener;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.onFrameReady();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        if (!this.isRunning) {
            this.pendingTarget = delayTarget;
            return;
        }
        if (delayTarget.getResource() != null) {
            recycleFirstFrame();
            DelayTarget delayTarget2 = this.current;
            this.current = delayTarget;
            for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onFrameReady();
            }
            if (delayTarget2 != null) {
                this.handler.obtainMessage(2, delayTarget2).sendToTarget();
            }
        }
        loadNextFrame();
    }

    private class FrameLoaderCallback implements Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FrameLoaderCallback() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            }
            if (message.what != 2) {
                return false;
            }
            GifFrameLoader.this.requestManager.clear((DelayTarget) message.obj);
            return false;
        }
    }

    static class DelayTarget extends CustomTarget<Bitmap> {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DelayTarget(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.targetTime = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Bitmap getResource() {
            return this.resource;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            this.resource = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager requestManager, int i, int i2) {
        return requestManager.asBitmap().apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Key getFrameSignature() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }
}
