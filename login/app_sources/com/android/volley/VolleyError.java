package com.android.volley;

/* loaded from: classes.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VolleyError() {
        this.networkResponse = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VolleyError(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VolleyError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VolleyError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setNetworkTimeMs(long j) {
        this.networkTimeMs = j;
    }
}
