package com.google.android.gms.dynamite;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zza extends Thread {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zza(ThreadGroup threadGroup, String str) {
        super(threadGroup, "GmsDynamite");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(19);
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }
}
