package com.android.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.liapp.y;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addTrafficStatsTag(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void parseAndDeliverNetworkError(Request<?> request, VolleyError volleyError) {
        this.mDelivery.postError(request, request.parseNetworkError(volleyError));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Request<?> take;
        String str;
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                take = this.mQueue.take();
                try {
                    take.addMarker("network-queue-take");
                } catch (VolleyError e) {
                    e.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    parseAndDeliverNetworkError(take, e);
                } catch (Exception e2) {
                    VolleyLog.m64e(e2, y.ۮڭڭܬި(862025435), e2.toString());
                    VolleyError volleyError = new VolleyError(e2);
                    volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.mDelivery.postError(take, volleyError);
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
            if (take.isCanceled()) {
                str = "network-discard-cancelled";
            } else {
                addTrafficStatsTag(take);
                NetworkResponse performRequest = this.mNetwork.performRequest(take);
                take.addMarker("network-http-complete");
                if (performRequest.notModified && take.hasHadResponseDelivered()) {
                    str = "not-modified";
                } else {
                    Response<?> parseNetworkResponse = take.parseNetworkResponse(performRequest);
                    take.addMarker("network-parse-complete");
                    if (take.shouldCache() && parseNetworkResponse.cacheEntry != null) {
                        this.mCache.put(take.getCacheKey(), parseNetworkResponse.cacheEntry);
                        take.addMarker("network-cache-written");
                    }
                    take.markDelivered();
                    this.mDelivery.postResponse(take, parseNetworkResponse);
                }
            }
            take.finish(str);
        }
    }
}
