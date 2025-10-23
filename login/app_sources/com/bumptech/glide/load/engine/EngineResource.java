package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;

/* loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource<Z> resource;

    interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EngineResource(Resource<Z> resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isMemoryCacheable = z;
        this.isRecyclable = z2;
        this.key = key;
        this.listener = (ResourceListener) Preconditions.checkNotNull(resourceListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Resource<Z> getResource() {
        return this.resource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.isRecycled = true;
        if (this.isRecyclable) {
            this.resource.recycle();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void acquire() {
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.acquired++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void release() {
        boolean z;
        synchronized (this) {
            int i = this.acquired;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.acquired = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized String toString() {
        String str;
        String str2 = y.ݮڮֲڭܩ(-628951852);
        synchronized (this) {
            str = str2 + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
        }
        return str;
    }
}
