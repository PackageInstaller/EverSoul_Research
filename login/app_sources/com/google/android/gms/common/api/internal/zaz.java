package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaz implements zabz {
    final /* synthetic */ zaaa zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zaz(zaaa zaaaVar, zay zayVar) {
        this.zaa = zaaaVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.zaa.zam;
        lock.lock();
        try {
            this.zaa.zak = connectionResult;
            zaaa.zap(this.zaa);
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.zaa.zam;
        lock.lock();
        try {
            this.zaa.zak = ConnectionResult.RESULT_SUCCESS;
            zaaa.zap(this.zaa);
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        zabi zabiVar;
        lock = this.zaa.zam;
        lock.lock();
        try {
            zaaa zaaaVar = this.zaa;
            z2 = zaaaVar.zal;
            if (z2) {
                zaaaVar.zal = false;
                zaaa.zan(this.zaa, i, z);
            } else {
                zaaaVar.zal = true;
                zabiVar = this.zaa.zad;
                zabiVar.onConnectionSuspended(i);
            }
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }
}
