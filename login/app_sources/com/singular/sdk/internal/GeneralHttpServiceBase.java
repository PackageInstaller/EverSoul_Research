package com.singular.sdk.internal;

import java.util.Map;

/* loaded from: classes3.dex */
public abstract class GeneralHttpServiceBase {
    private String baseUrl;

    public interface CompletionHandler {
        void onFailure(String str);

        void onSuccess(String str, int i);
    }

    public abstract void sendRequest(String str, Map<String, String> map, Map<String, String> map2, CompletionHandler completionHandler);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GeneralHttpServiceBase() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeneralHttpServiceBase(String str) {
        this.baseUrl = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String getBaseUrl() {
        return this.baseUrl;
    }
}
