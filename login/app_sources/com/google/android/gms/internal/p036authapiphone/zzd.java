package com.google.android.gms.internal.p036authapiphone;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* loaded from: classes2.dex */
public abstract class zzd extends zzb implements zze {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzd() {
        super("com.google.android.gms.auth.api.phone.internal.IAutofillPermissionStateCallback");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p036authapiphone.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb((Status) zzc.zza(parcel, Status.CREATOR), parcel.readInt());
        return true;
    }
}
