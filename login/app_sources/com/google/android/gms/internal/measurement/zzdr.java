package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzdr implements ThreadFactory {
    private ThreadFactory zza = Executors.defaultThreadFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zza.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdr(zzdf zzdfVar) {
    }
}
