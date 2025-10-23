package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgi extends ContentObserver {
    private final /* synthetic */ zzgg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgi(zzgg zzggVar, Handler handler) {
        super(null);
        this.zza = zzggVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzd();
    }
}
