package com.android.volley;

import android.os.Process;
import com.android.volley.Cache;
import com.liapp.y;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = VolleyLog.DEBUG;
    private final Cache mCache;
    private final BlockingQueue<Request<?>> mCacheQueue;
    private final ResponseDelivery mDelivery;
    private final BlockingQueue<Request<?>> mNetworkQueue;
    private volatile boolean mQuit = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG) {
            VolleyLog.m65v(y.ۮڭڭܬި(862025227), new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                final Request<?> take = this.mCacheQueue.take();
                try {
                    take.addMarker("cache-queue-take");
                    if (take.isCanceled()) {
                        take.finish("cache-discard-canceled");
                    } else {
                        Cache.Entry entry = this.mCache.get(take.getCacheKey());
                        if (entry == null) {
                            take.addMarker("cache-miss");
                        } else if (entry.isExpired()) {
                            take.addMarker("cache-hit-expired");
                            take.setCacheEntry(entry);
                        } else {
                            take.addMarker("cache-hit");
                            Response<?> parseNetworkResponse = take.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
                            take.addMarker("cache-hit-parsed");
                            if (entry.refreshNeeded()) {
                                take.addMarker("cache-hit-refresh-needed");
                                take.setCacheEntry(entry);
                                parseNetworkResponse.intermediate = true;
                                this.mDelivery.postResponse(take, parseNetworkResponse, new Runnable() { // from class: com.android.volley.CacheDispatcher.1
                                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            CacheDispatcher.this.mNetworkQueue.put(take);
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                });
                            } else {
                                this.mDelivery.postResponse(take, parseNetworkResponse);
                            }
                        }
                        this.mNetworkQueue.put(take);
                    }
                } catch (Exception e) {
                    VolleyLog.m64e(e, y.ۮڭڭܬި(862025435), e.toString());
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }
}
