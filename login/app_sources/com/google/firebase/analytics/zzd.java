package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzdf;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzd implements Callable<Long> {
    private final /* synthetic */ FirebaseAnalytics zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        zzdf zzdfVar;
        zzdfVar = this.zza.zzb;
        return zzdfVar.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzd(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }
}
