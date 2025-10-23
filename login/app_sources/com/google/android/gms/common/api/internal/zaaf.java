package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaaf {
    private final ApiKey zaa;
    private final TaskCompletionSource zab = new TaskCompletionSource();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zaaf(ApiKey apiKey) {
        this.zaa = apiKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApiKey zaa() {
        return this.zaa;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TaskCompletionSource zab() {
        return this.zab;
    }
}
