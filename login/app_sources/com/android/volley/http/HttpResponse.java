package com.android.volley.http;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class HttpResponse {
    public static final int SC_FORBIDDEN = 403;
    public static final int SC_MOVED_PERMANENTLY = 301;
    public static final int SC_MOVED_TEMPORARILY = 302;
    public static final int SC_NOT_MODIFIED = 304;
    public static final int SC_OK = 200;
    public static final int SC_UNAUTHORIZED = 401;
    private HttpEntity entityFromConnection;
    private Map<String, String> httpHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private int responseCode;
    private String responseMessage;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpResponse(int i, String str) {
        setResponseCode(i);
        setResponseMessage(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addHeader(String str, String str2) {
        this.httpHeaders.put(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getAllHeaders() {
        return this.httpHeaders;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpEntity getEntity() {
        return this.entityFromConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getResponseCode() {
        return this.responseCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getResponseMessage() {
        return this.responseMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEntity(HttpEntity httpEntity) {
        this.entityFromConnection = httpEntity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }
}
