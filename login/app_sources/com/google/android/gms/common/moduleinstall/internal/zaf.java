package com.google.android.gms.common.moduleinstall.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zae(zae zaeVar, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, zaeVar);
        com.google.android.gms.internal.base.zac.zac(zaa, apiFeatureRequest);
        zac(1, zaa);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zaf(zae zaeVar, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, zaeVar);
        com.google.android.gms.internal.base.zac.zac(zaa, apiFeatureRequest);
        zac(3, zaa);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zag(zae zaeVar, ApiFeatureRequest apiFeatureRequest, zah zahVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, zaeVar);
        com.google.android.gms.internal.base.zac.zac(zaa, apiFeatureRequest);
        com.google.android.gms.internal.base.zac.zad(zaa, zahVar);
        zac(2, zaa);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zah(IStatusCallback iStatusCallback, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, iStatusCallback);
        com.google.android.gms.internal.base.zac.zac(zaa, apiFeatureRequest);
        zac(4, zaa);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zai(IStatusCallback iStatusCallback, zah zahVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, iStatusCallback);
        com.google.android.gms.internal.base.zac.zad(zaa, zahVar);
        zac(6, zaa);
    }
}
