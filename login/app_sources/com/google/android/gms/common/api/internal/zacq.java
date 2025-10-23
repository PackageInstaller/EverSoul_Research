package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zacq implements Runnable {
    final /* synthetic */ zact zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zacq(zact zactVar) {
        this.zaa = zactVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zacs zacsVar;
        zacsVar = this.zaa.zah;
        zacsVar.zae(new ConnectionResult(4));
    }
}
