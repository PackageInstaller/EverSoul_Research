package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RequestFuture() {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:13:0x0011, B:14:0x0022, B:16:0x0026, B:18:0x002a, B:21:0x002e, B:22:0x0033, B:23:0x0034, B:24:0x003b, B:25:0x0015, B:27:0x001d, B:28:0x003c, B:29:0x0043), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:13:0x0011, B:14:0x0022, B:16:0x0026, B:18:0x002a, B:21:0x002e, B:22:0x0033, B:23:0x0034, B:24:0x003b, B:25:0x0015, B:27:0x001d, B:28:0x003c, B:29:0x0043), top: B:2:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized T doGet(java.lang.Long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.android.volley.VolleyError r0 = r4.mException     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L3c
            boolean r0 = r4.mResultReceived     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto Ld
            T r5 = r4.mResult     // Catch: java.lang.Throwable -> L44
            monitor-exit(r4)
            return r5
        Ld:
            r0 = 0
            if (r5 != 0) goto L15
        L11:
            r4.wait(r0)     // Catch: java.lang.Throwable -> L44
            goto L22
        L15:
            long r2 = r5.longValue()     // Catch: java.lang.Throwable -> L44
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L22
            long r0 = r5.longValue()     // Catch: java.lang.Throwable -> L44
            goto L11
        L22:
            com.android.volley.VolleyError r5 = r4.mException     // Catch: java.lang.Throwable -> L44
            if (r5 != 0) goto L34
            boolean r5 = r4.mResultReceived     // Catch: java.lang.Throwable -> L44
            if (r5 == 0) goto L2e
            T r5 = r4.mResult     // Catch: java.lang.Throwable -> L44
            monitor-exit(r4)
            return r5
        L2e:
            java.util.concurrent.TimeoutException r5 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> L44
            r5.<init>()     // Catch: java.lang.Throwable -> L44
            throw r5     // Catch: java.lang.Throwable -> L44
        L34:
            java.util.concurrent.ExecutionException r5 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L44
            com.android.volley.VolleyError r0 = r4.mException     // Catch: java.lang.Throwable -> L44
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L44
            throw r5     // Catch: java.lang.Throwable -> L44
        L3c:
            java.util.concurrent.ExecutionException r5 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L44
            com.android.volley.VolleyError r0 = r4.mException     // Catch: java.lang.Throwable -> L44
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L44
            throw r5     // Catch: java.lang.Throwable -> L44
        L44:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
            fill-array 0x0048: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.RequestFuture.doGet(java.lang.Long):java.lang.Object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.mRequest == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.mRequest.cancel();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public T get() {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.mRequest;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.mResultReceived && this.mException == null) {
            z = isCancelled();
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Response.Listener
    public synchronized void onResponse(T t) {
        this.mResultReceived = true;
        this.mResult = t;
        notifyAll();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequest(Request<?> request) {
        this.mRequest = request;
    }
}
