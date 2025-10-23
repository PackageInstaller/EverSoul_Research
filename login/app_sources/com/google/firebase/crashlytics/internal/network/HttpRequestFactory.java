package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpRequestFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpGetRequest buildHttpGetRequest(String str) {
        return buildHttpGetRequest(str, Collections.emptyMap());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpGetRequest buildHttpGetRequest(String str, Map<String, String> map) {
        return new HttpGetRequest(str, map);
    }
}
