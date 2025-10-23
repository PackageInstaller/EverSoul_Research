package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.liapp.y;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class JsonRequest<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format(y.ݬֲ֮ܲت(1512858071), y.ۮڭڭܬި(862004003));
    private Response.Listener<T> mListener;
    private final String mRequestBody;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.mRequestBody = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Request
    protected void deliverResponse(T t) {
        Response.Listener<T> listener = this.mListener;
        if (listener != null) {
            listener.onResponse(t);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Request
    public byte[] getBody() {
        String str = y.ۮڭڭܬި(862004003);
        try {
            String str2 = this.mRequestBody;
            if (str2 == null) {
                return null;
            }
            return str2.getBytes(str);
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf(y.٬ݯح׭٩(576098062), this.mRequestBody, str);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Request
    public byte[] getPostBody() {
        return getBody();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Request
    protected void onFinish() {
        super.onFinish();
        this.mListener = null;
    }

    @Override // com.android.volley.Request
    protected abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);
}
