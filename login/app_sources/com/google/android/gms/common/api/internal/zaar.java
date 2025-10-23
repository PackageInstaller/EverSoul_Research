package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {
    private final WeakReference zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaar(zaaw zaawVar) {
        this.zaa = new WeakReference(zaawVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zabi zabiVar;
        zaaw zaawVar = (zaaw) this.zaa.get();
        if (zaawVar == null) {
            return;
        }
        zabiVar = zaawVar.zaa;
        zabiVar.zal(new zaaq(this, zaawVar, zaawVar, zakVar));
    }
}
