package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zza implements Runnable {
    private final Runnable zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.zza.run();
    }
}
