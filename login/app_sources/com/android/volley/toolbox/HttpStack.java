package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.http.HttpResponse;
import java.util.Map;

/* loaded from: classes.dex */
public interface HttpStack {
    HttpResponse performRequest(Request<?> request, Map<String, String> map);
}
