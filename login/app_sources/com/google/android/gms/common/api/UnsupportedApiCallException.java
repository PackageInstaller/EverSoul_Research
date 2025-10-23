package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(String.valueOf(this.zza)));
    }
}
