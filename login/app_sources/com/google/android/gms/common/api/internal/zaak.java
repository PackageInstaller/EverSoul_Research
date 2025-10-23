package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaak implements Runnable {
    final /* synthetic */ zaaw zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaak(zaaw zaawVar) {
        this.zaa = zaawVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        zaaw zaawVar = this.zaa;
        googleApiAvailabilityLight = zaawVar.zad;
        context = zaawVar.zac;
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}
