package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<RequestListener<Object>> defaultRequestListeners;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private final Handler mainHandler;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.targetTracker = new TargetTracker();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.this.lifecycle.addListener(RequestManager.this);
            }
        };
        this.addSelfToLifecycle = runnable;
        Handler handler = new Handler(Looper.getMainLooper());
        this.mainHandler = handler;
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        ConnectivityMonitor build = connectivityMonitorFactory.build(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.connectivityMonitor = build;
        if (Util.isOnBackgroundThread()) {
            handler.post(runnable);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(glide.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
        glide.registerRequestManager(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions.mo930clone().autoClone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void updateRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized RequestManager applyDefaultRequestOptions(RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized RequestManager setDefaultRequestOptions(RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isPaused() {
        return this.requestTracker.isPaused();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void pauseRequests() {
        this.requestTracker.pauseRequests();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void pauseAllRequests() {
        this.requestTracker.pauseAllRequests();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void resumeRequests() {
        this.requestTracker.resumeRequests();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        Iterator<Target<?>> it = this.targetTracker.getAll().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.clear();
        this.requestTracker.clearRequests();
        this.lifecycle.removeListener(this);
        this.lifecycle.removeListener(this.connectivityMonitor);
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
        this.glide.unregisterRequestManager(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestBuilder<Bitmap> asBitmap() {
        return m66as(Bitmap.class).apply((BaseRequestOptions<?>) DECODE_TYPE_BITMAP);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestBuilder<GifDrawable> asGif() {
        return m66as(GifDrawable.class).apply((BaseRequestOptions<?>) DECODE_TYPE_GIF);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestBuilder<Drawable> asDrawable() {
        return m66as(Drawable.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Drawable drawable) {
        return asDrawable().load(drawable);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(String str) {
        return asDrawable().load(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Uri uri) {
        return asDrawable().load(uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(File file) {
        return asDrawable().load(file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Integer num) {
        return asDrawable().load(num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder<Drawable> load(URL url) {
        return asDrawable().load(url);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(byte[] bArr) {
        return asDrawable().load(bArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Object obj) {
        return asDrawable().load(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestBuilder<File> downloadOnly() {
        return m66as(File.class).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestBuilder<File> download(Object obj) {
        return downloadOnly().load(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestBuilder<File> asFile() {
        return m66as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: as */
    public <ResourceType> RequestBuilder<ResourceType> m66as(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear(View view) {
        clear(new ClearTarget(view));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear(Target<?> target) {
        if (target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void untrackOrDelegate(Target<?> target) {
        boolean untrack = untrack(target);
        Request request = target.getRequest();
        if (untrack || this.glide.removeFromManagers(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized boolean untrack(Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearAndRemove(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest(null);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void track(Target<?> target, Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    private class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.requestTracker.restartRequests();
                }
            }
        }
    }

    private static class ClearTarget extends CustomViewTarget<View, Object> {
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
        ClearTarget(View view) {
            super(view);
        }
    }
}
