package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzca extends zzbu implements zzby {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzby
    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel m170a_ = m170a_();
        zzbw.zza(m170a_, bundle);
        Parcel zza = zza(1, m170a_);
        Bundle bundle2 = (Bundle) zzbw.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }
}
