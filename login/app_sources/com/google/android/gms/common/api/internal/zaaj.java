package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class zaaj implements zabf {
    private final zabi zaa;
    private boolean zab = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zaaj(zabi zabiVar) {
        this.zaa = zabiVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zab(apiMethodImpl);
        return apiMethodImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            this.zaa.zag.zai.zaa(apiMethodImpl);
            zabe zabeVar = this.zaa.zag;
            Api.Client client = (Api.Client) zabeVar.zac.get(apiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaa.zab.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.run(client);
            } else {
                apiMethodImpl.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.zaa.zal(new zaah(this, this));
        }
        return apiMethodImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zal(new zaai(this, this));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zaf() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zag.zai.zab();
            zaj();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zag(Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zai(int i) {
        this.zaa.zak(null);
        this.zaa.zah.zac(i, this.zab);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        if (this.zab) {
            return false;
        }
        Set set = this.zaa.zag.zah;
        if (set == null || set.isEmpty()) {
            this.zaa.zak(null);
            return true;
        }
        this.zab = true;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((zada) it.next()).zah();
        }
        return false;
    }
}
