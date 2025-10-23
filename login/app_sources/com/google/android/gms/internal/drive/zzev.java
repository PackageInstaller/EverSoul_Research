package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class zzev extends zzb implements zzeu {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzeu zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
        if (queryLocalInterface instanceof zzeu) {
            return (zzeu) queryLocalInterface;
        }
        return new zzew(iBinder);
    }
}
