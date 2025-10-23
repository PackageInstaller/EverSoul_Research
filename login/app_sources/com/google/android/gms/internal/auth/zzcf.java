package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzcf extends ContentObserver {
    final /* synthetic */ zzcg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcf(zzcg zzcgVar, Handler handler) {
        super(null);
        this.zza = zzcgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zze();
    }
}
