package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzcp extends Handler {
    private static zzcr zza;
    private final Looper zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcp() {
        this.zzb = Looper.getMainLooper();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcp(Looper looper) {
        super(looper);
        this.zzb = Looper.getMainLooper();
    }
}
