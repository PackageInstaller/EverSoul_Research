package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.liapp.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private static long sCounter;
    private Cache.Entry mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private Response.ErrorListener mErrorListener;
    private final VolleyLog.MarkerLog mEventLog;
    private String mIdentifier;
    private final int mMethod;
    private String mRedirectUrl;
    private RequestQueue mRequestQueue;
    private boolean mResponseDelivered;
    private RetryPolicy mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private Object mTag;
    private final String mUrl;

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Request(int i, String str, Response.ErrorListener errorListener) {
        this.mEventLog = VolleyLog.MarkerLog.ENABLED ? new VolleyLog.MarkerLog() : null;
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mIdentifier = createIdentifier(i, str);
        this.mErrorListener = errorListener;
        setRetryPolicy(new DefaultRetryPolicy());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Request(String str, Response.ErrorListener errorListener) {
        this(-1, str, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String createIdentifier(int i, String str) {
        StringBuilder append = new StringBuilder(y.ٴسسݬߨ(1392840810)).append(i);
        String str2 = y.ݬֲ֮ܲت(1512942399);
        StringBuilder append2 = append.append(str2).append(str).append(str2).append(System.currentTimeMillis()).append(str2);
        long j = sCounter;
        sCounter = 1 + j;
        return InternalUtils.sha1Hash(append2.append(j).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] encodeParameters(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append(Typography.amp);
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(y.֬ڱܱײٮ(-1159377479) + str, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int findDefaultTrafficStatsTag(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addMarker(String str) {
        if (VolleyLog.MarkerLog.ENABLED) {
            this.mEventLog.add(str, Thread.currentThread().getId());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancel() {
        this.mCanceled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        return priority == priority2 ? this.mSequence.intValue() - request.mSequence.intValue() : priority2.ordinal() - priority.ordinal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void deliverError(VolleyError volleyError) {
        Response.ErrorListener errorListener = this.mErrorListener;
        if (errorListener != null) {
            errorListener.onErrorResponse(volleyError);
        }
    }

    protected abstract void deliverResponse(T t);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void finish(final String str) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.finish(this);
            onFinish();
        }
        if (VolleyLog.MarkerLog.ENABLED) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.android.volley.Request.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.mEventLog.add(str, id);
                        Request.this.mEventLog.finish(toString());
                    }
                });
            } else {
                this.mEventLog.add(str, id);
                this.mEventLog.finish(toString());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getBody() {
        Map<String, String> params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return encodeParameters(params, getParamsEncoding());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getBodyContentType() {
        return y.دײܮڳܯ(2051805989) + getParamsEncoding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Cache.Entry getCacheEntry() {
        return this.mCacheEntry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getCacheKey() {
        return this.mMethod + y.ݬֲ֮ܲت(1512942399) + this.mUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Response.ErrorListener getErrorListener() {
        return this.mErrorListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getIdentifier() {
        return this.mIdentifier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMethod() {
        return this.mMethod;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginUrl() {
        return this.mUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Map<String, String> getParams() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String getParamsEncoding() {
        return y.٬ݯح׭٩(576116366);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public byte[] getPostBody() {
        Map<String, String> postParams = getPostParams();
        if (postParams == null || postParams.size() <= 0) {
            return null;
        }
        return encodeParameters(postParams, getPostParamsEncoding());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected Map<String, String> getPostParams() {
        return getParams();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Priority getPriority() {
        return Priority.NORMAL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RetryPolicy getRetryPolicy() {
        return this.mRetryPolicy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getSequence() {
        Integer num = this.mSequence;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(y.ۮڭڭܬި(862026691));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getTag() {
        return this.mTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTimeoutMs() {
        return this.mRetryPolicy.getCurrentTimeout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUrl() {
        String str = this.mRedirectUrl;
        return str != null ? str : this.mUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasHadResponseDelivered() {
        return this.mResponseDelivered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCanceled() {
        return this.mCanceled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void markDelivered() {
        this.mResponseDelivered = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onFinish() {
        this.mErrorListener = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return volleyError;
    }

    protected abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Request<?> setCacheEntry(Cache.Entry entry) {
        this.mCacheEntry = entry;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRedirectUrl(String str) {
        this.mRedirectUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.mRequestQueue = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        this.mRetryPolicy = retryPolicy;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Request<?> setSequence(int i) {
        this.mSequence = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Request<?> setShouldCache(boolean z) {
        this.mShouldCache = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Request<?> setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String str = y.دײܮڳܯ(2051829341) + Integer.toHexString(getTrafficStatsTag());
        StringBuilder append = new StringBuilder().append(this.mCanceled ? y.ٴسسݬߨ(1392864274) : y.֬ڱܱײٮ(-1159384767)).append(getUrl());
        String str2 = y.دײܮڳܯ(2051829469);
        return append.append(str2).append(str).append(str2).append(getPriority()).append(str2).append(this.mSequence).toString();
    }
}
