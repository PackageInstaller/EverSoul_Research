package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(int i, String str, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i, str, null, listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(int i, String str, String str2, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(int i, String str, JSONArray jSONArray, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(int i, String str, JSONObject jSONObject, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(String str, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(String str, JSONArray jSONArray, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        this(jSONArray == null ? 0 : 1, str, jSONArray, listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArrayRequest(String str, JSONObject jSONObject, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, listener, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
        ParseError parseError;
        try {
            return Response.success(new JSONArray(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            parseError = new ParseError(e);
            return Response.error(parseError);
        } catch (JSONException e2) {
            parseError = new ParseError(e2);
            return Response.error(parseError);
        }
    }
}
