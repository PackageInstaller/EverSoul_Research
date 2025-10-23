package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzja implements Executor {
    private final /* synthetic */ zzio zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzja(zzio zzioVar) {
        this.zza = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzl().zzb(runnable);
    }
}
