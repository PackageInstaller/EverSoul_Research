package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzcx extends zzbu implements zzcv {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void zza(Bundle bundle) throws RemoteException {
        Parcel m170a_ = m170a_();
        zzbw.zza(m170a_, bundle);
        zzb(1, m170a_);
    }
}
