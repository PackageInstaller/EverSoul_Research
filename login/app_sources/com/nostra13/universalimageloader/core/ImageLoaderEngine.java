package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
class ImageLoaderEngine {
    final ImageLoaderConfiguration configuration;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private final Map<Integer, String> cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> uriLocks = new WeakHashMap();
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final AtomicBoolean networkDenied = new AtomicBoolean(false);
    private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
    private final Object pauseLock = new Object();
    private Executor taskDistributor = DefaultConfigurationFactory.createTaskDistributor();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ImageLoaderEngine(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.configuration = imageLoaderConfiguration;
        this.taskExecutor = imageLoaderConfiguration.taskExecutor;
        this.taskExecutorForCachedImages = imageLoaderConfiguration.taskExecutorForCachedImages;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void submit(final LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.taskDistributor.execute(new Runnable() { // from class: com.nostra13.universalimageloader.core.ImageLoaderEngine.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                File file = ImageLoaderEngine.this.configuration.diskCache.get(loadAndDisplayImageTask.getLoadingUri());
                boolean z = file != null && file.exists();
                ImageLoaderEngine.this.initExecutorsIfNeed();
                if (z) {
                    ImageLoaderEngine.this.taskExecutorForCachedImages.execute(loadAndDisplayImageTask);
                } else {
                    ImageLoaderEngine.this.taskExecutor.execute(loadAndDisplayImageTask);
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void submit(ProcessAndDisplayImageTask processAndDisplayImageTask) {
        initExecutorsIfNeed();
        this.taskExecutorForCachedImages.execute(processAndDisplayImageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void initExecutorsIfNeed() {
        if (!this.configuration.customExecutor && ((ExecutorService) this.taskExecutor).isShutdown()) {
            this.taskExecutor = createTaskExecutor();
        }
        if (this.configuration.customExecutorForCachedImages || !((ExecutorService) this.taskExecutorForCachedImages).isShutdown()) {
            return;
        }
        this.taskExecutorForCachedImages = createTaskExecutor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Executor createTaskExecutor() {
        return DefaultConfigurationFactory.createExecutor(this.configuration.threadPoolSize, this.configuration.threadPriority, this.configuration.tasksProcessingType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getLoadingUriForView(ImageAware imageAware) {
        return this.cacheKeysForImageAwares.get(Integer.valueOf(imageAware.getId()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void prepareDisplayTaskFor(ImageAware imageAware, String str) {
        this.cacheKeysForImageAwares.put(Integer.valueOf(imageAware.getId()), str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void cancelDisplayTaskFor(ImageAware imageAware) {
        this.cacheKeysForImageAwares.remove(Integer.valueOf(imageAware.getId()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void denyNetworkDownloads(boolean z) {
        this.networkDenied.set(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void handleSlowNetwork(boolean z) {
        this.slowNetwork.set(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void pause() {
        this.paused.set(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void resume() {
        this.paused.set(false);
        synchronized (this.pauseLock) {
            this.pauseLock.notifyAll();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void stop() {
        if (!this.configuration.customExecutor) {
            ((ExecutorService) this.taskExecutor).shutdownNow();
        }
        if (!this.configuration.customExecutorForCachedImages) {
            ((ExecutorService) this.taskExecutorForCachedImages).shutdownNow();
        }
        this.cacheKeysForImageAwares.clear();
        this.uriLocks.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void fireCallback(Runnable runnable) {
        this.taskDistributor.execute(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ReentrantLock getLockForUri(String str) {
        ReentrantLock reentrantLock = this.uriLocks.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.uriLocks.put(str, reentrantLock2);
        return reentrantLock2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AtomicBoolean getPause() {
        return this.paused;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Object getPauseLock() {
        return this.pauseLock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isNetworkDenied() {
        return this.networkDenied.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isSlowNetwork() {
        return this.slowNetwork.get();
    }
}
