package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzll implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzlj zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzll(zzlj zzljVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zzljVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzkq.zza(this.zzb.zza, this.zza);
    }
}
