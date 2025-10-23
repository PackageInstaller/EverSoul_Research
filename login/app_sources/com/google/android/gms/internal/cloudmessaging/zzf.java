package com.google.android.gms.internal.cloudmessaging;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes2.dex */
public class zzf extends Handler {
    private final Looper zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzf() {
        this.zza = Looper.getMainLooper();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzf(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzf(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zza = Looper.getMainLooper();
    }
}
