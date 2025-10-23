package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import com.liapp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class RequestQueue {
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private final Cache mCache;
    private CacheDispatcher mCacheDispatcher;
    private final PriorityBlockingQueue<Request<?>> mCacheQueue;
    private final Set<Request<?>> mCurrentRequests;
    private final ResponseDelivery mDelivery;
    private NetworkDispatcher[] mDispatchers;
    private List<RequestFinishedListener> mFinishedListeners;
    private final Network mNetwork;
    private final PriorityBlockingQueue<Request<?>> mNetworkQueue;
    private AtomicInteger mSequenceGenerator;
    private final Map<String, Queue<Request<?>>> mWaitingRequests;

    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestQueue(Cache cache, Network network, int i) {
        this(cache, network, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestQueue(Cache cache, Network network, int i, ResponseDelivery responseDelivery) {
        this.mSequenceGenerator = new AtomicInteger();
        this.mWaitingRequests = new HashMap();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue<>();
        this.mNetworkQueue = new PriorityBlockingQueue<>();
        this.mFinishedListeners = new ArrayList();
        this.mCache = cache;
        this.mNetwork = network;
        this.mDispatchers = new NetworkDispatcher[i];
        this.mDelivery = responseDelivery;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker(y.ۮڭڭܬި(861996531));
        if (!request.shouldCache()) {
            this.mNetworkQueue.add(request);
            return request;
        }
        synchronized (this.mWaitingRequests) {
            String cacheKey = request.getCacheKey();
            if (this.mWaitingRequests.containsKey(cacheKey)) {
                Queue<Request<?>> queue = this.mWaitingRequests.get(cacheKey);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(request);
                this.mWaitingRequests.put(cacheKey, queue);
                if (VolleyLog.DEBUG) {
                    VolleyLog.m65v(y.ٴسسݬߨ(1392864618), cacheKey);
                }
            } else {
                this.mWaitingRequests.put(cacheKey, null);
                this.mCacheQueue.add(request);
            }
        }
        return request;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> void addRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.add(requestFinishedListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelAll(RequestFilter requestFilter) {
        synchronized (this.mCurrentRequests) {
            for (Request<?> request : this.mCurrentRequests) {
                if (requestFilter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelAll(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781559776));
        }
        cancelAll(new RequestFilter() { // from class: com.android.volley.RequestQueue.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.android.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <T> void finish(Request<T> request) {
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.remove(request);
        }
        synchronized (this.mFinishedListeners) {
            Iterator<RequestFinishedListener> it = this.mFinishedListeners.iterator();
            while (it.hasNext()) {
                it.next().onRequestFinished(request);
            }
        }
        if (request.shouldCache()) {
            synchronized (this.mWaitingRequests) {
                String cacheKey = request.getCacheKey();
                Queue<Request<?>> remove = this.mWaitingRequests.remove(cacheKey);
                if (remove != null) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.m65v(y.دײܮڳܯ(2051828341), Integer.valueOf(remove.size()), cacheKey);
                    }
                    this.mCacheQueue.addAll(remove);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Cache getCache() {
        return this.mCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.remove(requestFinishedListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void start() {
        stop();
        CacheDispatcher cacheDispatcher = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher = cacheDispatcher;
        cacheDispatcher.start();
        for (int i = 0; i < this.mDispatchers.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
            this.mDispatchers[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void stop() {
        CacheDispatcher cacheDispatcher = this.mCacheDispatcher;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        int i = 0;
        while (true) {
            NetworkDispatcher[] networkDispatcherArr = this.mDispatchers;
            if (i >= networkDispatcherArr.length) {
                return;
            }
            NetworkDispatcher networkDispatcher = networkDispatcherArr[i];
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
            i++;
        }
    }
}
