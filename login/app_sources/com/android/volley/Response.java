package com.android.volley;

import com.android.volley.Cache;

/* loaded from: classes.dex */
public class Response<T> {
    public final Cache.Entry cacheEntry;
    public final VolleyError error;
    public boolean intermediate;
    public final T result;

    public interface ErrorListener {
        void onErrorResponse(VolleyError volleyError);
    }

    public interface Listener<T> {
        void onResponse(T t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Response(VolleyError volleyError) {
        this.intermediate = false;
        this.result = null;
        this.cacheEntry = null;
        this.error = volleyError;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Response(T t, Cache.Entry entry) {
        this.intermediate = false;
        this.result = t;
        this.cacheEntry = entry;
        this.error = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> error(VolleyError volleyError) {
        return new Response<>(volleyError);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> success(T t, Cache.Entry entry) {
        return new Response<>(t, entry);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSuccess() {
        return this.error == null;
    }
}
