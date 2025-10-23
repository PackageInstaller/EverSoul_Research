package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
final class zzad extends com.google.android.gms.internal.cloudmessaging.zzf {
    final /* synthetic */ Rpc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzad(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Rpc.zzc(this.zza, message);
    }
}
