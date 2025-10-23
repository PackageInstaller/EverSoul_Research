package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzdc extends zzbu implements zzda {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zza() throws RemoteException {
        Parcel zza = zza(2, m170a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel m170a_ = m170a_();
        m170a_.writeString(str);
        m170a_.writeString(str2);
        zzbw.zza(m170a_, bundle);
        m170a_.writeLong(j);
        zzb(1, m170a_);
    }
}
