package com.google.android.gms.internal.tasks;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
public final class zza extends Handler {
    private final Looper zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza() {
        this.zza = Looper.getMainLooper();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }
}
