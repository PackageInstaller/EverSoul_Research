package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgy implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzgw zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzgy(zzgw zzgwVar, String str) {
        this.zzb = zzgwVar;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzj().zzg().zza(this.zza, th);
    }
}
