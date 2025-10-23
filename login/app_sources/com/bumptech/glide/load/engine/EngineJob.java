package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final EngineResource.ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, DEFAULT_FACTORY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener;
        this.resourceListener = resourceListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized EngineJob<R> init(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = key;
        this.isCacheable = z;
        this.useUnlimitedSourceGeneratorPool = z2;
        this.useAnimationPool = z3;
        this.onlyRetrieveFromCache = z4;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void start(DecodeJob<R> decodeJob) {
        this.decodeJob = decodeJob;
        (decodeJob.willDecodeFromCache() ? this.diskCacheExecutor : getActiveSourceExecutor()).execute(decodeJob);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        this.stateVerifier.throwIfRecycled();
        this.cbs.add(resourceCallback, executor);
        boolean z = true;
        if (this.hasResource) {
            incrementPendingCallbacks(1);
            executor.execute(new CallResourceReady(resourceCallback));
        } else if (this.hasLoadFailed) {
            incrementPendingCallbacks(1);
            executor.execute(new CallLoadFailed(resourceCallback));
        } else {
            if (this.isCancelled) {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void callCallbackOnResourceReady(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void callCallbackOnLoadFailed(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.exception);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void removeCallback(ResourceCallback resourceCallback) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
            if (!this.hasResource && !this.hasLoadFailed) {
                z = false;
                if (z && this.pendingCallbacks.get() == 0) {
                    release();
                }
            }
            z = true;
            if (z) {
                release();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool) {
            return this.sourceUnlimitedExecutor;
        }
        return this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void cancel() {
        if (isDone()) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void notifyCallbacksOfResult() {
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                this.resource.recycle();
                release();
                return;
            }
            if (this.cbs.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.hasResource) {
                throw new IllegalStateException("Already have resource");
            }
            this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);
            this.hasResource = true;
            ResourceCallbacksAndExecutors copy = this.cbs.copy();
            incrementPendingCallbacks(copy.size() + 1);
            this.engineJobListener.onEngineJobComplete(this, this.key, this.engineResource);
            Iterator<ResourceCallbackAndExecutor> it = copy.iterator();
            while (it.hasNext()) {
                ResourceCallbackAndExecutor next = it.next();
                next.executor.execute(new CallResourceReady(next.f159cb));
            }
            decrementPendingCallbacks();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void incrementPendingCallbacks(int i) {
        EngineResource<?> engineResource;
        Preconditions.checkArgument(isDone(), "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i) == 0 && (engineResource = this.engineResource) != null) {
            engineResource.acquire();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void decrementPendingCallbacks() {
        EngineResource<?> engineResource;
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            Preconditions.checkArgument(isDone(), "Not yet complete!");
            int decrementAndGet = this.pendingCallbacks.decrementAndGet();
            Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource = this.engineResource;
                release();
            } else {
                engineResource = null;
            }
        }
        if (engineResource != null) {
            engineResource.release();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void release() {
        if (this.key == null) {
            throw new IllegalArgumentException();
        }
        this.cbs.clear();
        this.key = null;
        this.engineResource = null;
        this.resource = null;
        this.hasLoadFailed = false;
        this.isCancelled = false;
        this.hasResource = false;
        this.decodeJob.release(false);
        this.decodeJob = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.resource = resource;
            this.dataSource = dataSource;
        }
        notifyCallbacksOfResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.exception = glideException;
        }
        notifyCallbacksOfException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob) {
        getActiveSourceExecutor().execute(decodeJob);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void notifyCallbacksOfException() {
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                release();
                return;
            }
            if (this.cbs.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.hasLoadFailed) {
                throw new IllegalStateException("Already failed once");
            }
            this.hasLoadFailed = true;
            Key key = this.key;
            ResourceCallbacksAndExecutors copy = this.cbs.copy();
            incrementPendingCallbacks(copy.size() + 1);
            this.engineJobListener.onEngineJobComplete(this, key, null);
            Iterator<ResourceCallbackAndExecutor> it = copy.iterator();
            while (it.hasNext()) {
                ResourceCallbackAndExecutor next = it.next();
                next.executor.execute(new CallLoadFailed(next.f159cb));
            }
            decrementPendingCallbacks();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    private class CallLoadFailed implements Runnable {

        /* renamed from: cb */
        private final ResourceCallback f157cb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CallLoadFailed(ResourceCallback resourceCallback) {
            this.f157cb = resourceCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f157cb.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.cbs.contains(this.f157cb)) {
                        EngineJob.this.callCallbackOnLoadFailed(this.f157cb);
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    private class CallResourceReady implements Runnable {

        /* renamed from: cb */
        private final ResourceCallback f158cb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CallResourceReady(ResourceCallback resourceCallback) {
            this.f158cb = resourceCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f158cb.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.cbs.contains(this.f158cb)) {
                        EngineJob.this.engineResource.acquire();
                        EngineJob.this.callCallbackOnResourceReady(this.f158cb);
                        EngineJob.this.removeCallback(this.f158cb);
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.callbacksAndExecutors = list;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void add(ResourceCallback resourceCallback, Executor executor) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void remove(ResourceCallback resourceCallback) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean contains(ResourceCallback resourceCallback) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int size() {
            return this.callbacksAndExecutors.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void clear() {
            this.callbacksAndExecutors.clear();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Iterable
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }
    }

    static final class ResourceCallbackAndExecutor {

        /* renamed from: cb */
        final ResourceCallback f159cb;
        final Executor executor;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f159cb = resourceCallback;
            this.executor = executor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f159cb.equals(((ResourceCallbackAndExecutor) obj).f159cb);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.f159cb.hashCode();
        }
    }

    static class EngineResourceFactory {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        EngineResourceFactory() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public <R> EngineResource<R> build(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource<>(resource, z, true, key, resourceListener);
        }
    }
}
