package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
public final class zze implements Parcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzc();
    Messenger zza;
    IMessengerCompat zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zze(IBinder iBinder) {
        this.zza = new Messenger(iBinder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return zza().equals(((zze) obj).zza());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return zza().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zza;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzb.asBinder());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IBinder zza() {
        Messenger messenger = this.zza;
        return messenger != null ? messenger.getBinder() : this.zzb.asBinder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Message message) throws RemoteException {
        Messenger messenger = this.zza;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzb.send(message);
        }
    }
}
