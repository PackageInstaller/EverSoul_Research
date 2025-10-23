package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import com.liapp.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(y.٬ݯح׭٩(575930862), 2);
    private static final String TAG = "Request";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.requestOrigin = new RuntimeException(y.٬ݯح׭٩(575930902));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public void begin() {
        String str = y.ݮڮֲڭܩ(-628888004);
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = LogTime.getLogTime();
            if (this.model == null) {
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                return;
            }
            if (this.status == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.status == Status.COMPLETE) {
                onResourceReady(this.resource, DataSource.MEMORY_CACHE);
                return;
            }
            this.status = Status.WAITING_FOR_SIZE;
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV(str + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException(y.دײܮڳܯ(2051982709));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            if (this.status == Status.CLEARED) {
                return;
            }
            cancel();
            Resource<R> resource = this.resource;
            if (resource != null) {
                this.resource = null;
            } else {
                resource = null;
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
            if (resource != null) {
                this.engine.release(resource);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable loadDrawable(int i) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        Object obj;
        String str = y.ٲٴݴ״ٰ(1781713640);
        String str2 = y.֬ڱܱײٮ(-1159230479);
        String str3 = y.֬ڱܱײٮ(-1159230775);
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                try {
                    boolean z = IS_VERBOSE_LOGGABLE;
                    if (z) {
                        logV(str3 + LogTime.getElapsedMillis(this.startTime));
                    }
                    if (this.status == Status.WAITING_FOR_SIZE) {
                        this.status = Status.RUNNING;
                        float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                        this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (z) {
                            logV(str2 + LogTime.getElapsedMillis(this.startTime));
                        }
                        obj = obj2;
                        try {
                            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                            if (this.status != Status.RUNNING) {
                                this.loadStatus = null;
                            }
                            if (z) {
                                logV(str + LogTime.getElapsedMillis(this.startTime));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r7 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        r6.engine.release(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        if (r7 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bb, code lost:
    
        r6.engine.release(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r7, com.bumptech.glide.load.DataSource r8) {
        /*
            r6 = this;
            r0 = -628887708(0xffffffffda83ef64, float:-1.8568217E16)
            java.lang.String r0 = com.liapp.y.ݮڮֲڭܩ(r0)
            r1 = 1781713752(0x6a32cb58, float:5.4037265E25)
            java.lang.String r1 = com.liapp.y.ٲٴݴ״ٰ(r1)
            com.bumptech.glide.util.pool.StateVerifier r2 = r6.stateVerifier
            r2.throwIfRecycled()
            r2 = 0
            java.lang.Object r3 = r6.requestLock     // Catch: java.lang.Throwable -> Lc8
            monitor-enter(r3)     // Catch: java.lang.Throwable -> Lc8
            r6.loadStatus = r2     // Catch: java.lang.Throwable -> Lc5
            if (r7 != 0) goto L3a
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lc5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5
            r8.<init>(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Class<R> r0 = r6.transcodeClass     // Catch: java.lang.Throwable -> Lc5
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = " inside, but instead got null."
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lc5
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lc5
            r6.onLoadFailed(r7)     // Catch: java.lang.Throwable -> Lc5
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc5
            return
        L3a:
            java.lang.Object r1 = r7.get()     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto L67
            java.lang.Class<R> r4 = r6.transcodeClass     // Catch: java.lang.Throwable -> Lc5
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> Lc5
            boolean r4 = r4.isAssignableFrom(r5)     // Catch: java.lang.Throwable -> Lc5
            if (r4 != 0) goto L4d
            goto L67
        L4d:
            boolean r0 = r6.canSetResource()     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L62
            r6.resource = r2     // Catch: java.lang.Throwable -> Lc1
            com.bumptech.glide.request.SingleRequest$Status r8 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch: java.lang.Throwable -> Lc1
            r6.status = r8     // Catch: java.lang.Throwable -> Lc1
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc1
            if (r7 == 0) goto L61
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r7)
        L61:
            return
        L62:
            r6.onResourceReady(r7, r1, r8)     // Catch: java.lang.Throwable -> Lc5
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc5
            return
        L67:
            r6.resource = r2     // Catch: java.lang.Throwable -> Lc1
            com.bumptech.glide.load.engine.GlideException r8 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lc1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc1
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Class<R> r0 = r6.transcodeClass     // Catch: java.lang.Throwable -> Lc1
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r2 = " but instead got "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc1
            if (r1 == 0) goto L83
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.Throwable -> Lc1
            goto L85
        L83:
            java.lang.String r2 = ""
        L85:
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r2 = "{"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r2 = "} inside Resource{"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc1
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r2 = "}."
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc1
            if (r1 == 0) goto La8
            java.lang.String r1 = ""
            goto Laa
        La8:
            java.lang.String r1 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        Laa:
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc1
            r8.<init>(r0)     // Catch: java.lang.Throwable -> Lc1
            r6.onLoadFailed(r8)     // Catch: java.lang.Throwable -> Lc1
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc1
            if (r7 == 0) goto Lc0
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r7)
        Lc0:
            return
        Lc1:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto Lc6
        Lc5:
            r7 = move-exception
        Lc6:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc5
            throw r7     // Catch: java.lang.Throwable -> Lc8
        Lc8:
            r7 = move-exception
            if (r2 == 0) goto Ld0
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r2)
        Ld0:
            throw r7
            fill-array 0x00d2: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(y.ٲٴݴ״ٰ(1781554840), y.دײܮڳܯ(2051988221) + r.getClass().getSimpleName() + y.ٴسسݬߨ(1393023354) + dataSource + y.ݬֲ֮ܲت(1513026303) + this.model + y.٬ݯح׭٩(575937966) + this.width + y.ٴسسݬߨ(1392956602) + this.height + y.ݮڮֲڭܩ(-628887972) + LogTime.getElapsedMillis(this.startTime) + y.ٴسسݬߨ(1393023514));
        }
        boolean z2 = true;
        this.isCallingCallbacks = true;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                Iterator<RequestListener<R>> it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= it.next().onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource);
                }
            } else {
                z = false;
            }
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.target.onResourceReady(r, this.animationFactory.build(dataSource, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        String str = y.ٴسسݬߨ(1393024930);
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                Log.w(GLIDE_TAG, str + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    Iterator<RequestListener<R>> it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        z |= it.next().onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z = false;
                }
                RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                notifyLoadFailed();
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority = this.priority;
            List<RequestListener<R>> list = this.requestListeners;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority2 = singleRequest.priority;
            List<RequestListener<R>> list2 = singleRequest.requestListeners;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void logV(String str) {
        Log.v(y.٬ݯح׭٩(575930862), str + y.ٴسسݬߨ(1393025002) + this.tag);
    }
}
