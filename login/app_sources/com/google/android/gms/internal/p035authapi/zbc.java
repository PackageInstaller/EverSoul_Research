package com.google.android.gms.internal.p035authapi;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
public final class zbc {
    private static final ClassLoader zba = zbc.class.getClassLoader();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zbc() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parcelable zba(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zbb(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + dataAvail);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zbc(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zbd(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
