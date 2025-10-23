package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zabo implements Runnable {
    final /* synthetic */ zabp zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zabo(zabp zabpVar) {
        this.zaa = zabpVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        Api.Client client2;
        zabq zabqVar = this.zaa.zaa;
        client = zabqVar.zac;
        client2 = zabqVar.zac;
        client.disconnect(String.valueOf(client2.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
