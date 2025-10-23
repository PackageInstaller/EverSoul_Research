package com.google.firebase.crashlytics.internal.network;

/* loaded from: classes2.dex */
public class HttpResponse {
    private final String body;
    private final int code;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpResponse(int i, String str) {
        this.code = i;
        this.body = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int code() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String body() {
        return this.body;
    }
}
