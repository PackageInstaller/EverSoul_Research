package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class Response<T extends Result> {
    private Result zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Response() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Response(T t) {
        this.zza = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected T getResult() {
        return (T) this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResult(T t) {
        this.zza = t;
    }
}
