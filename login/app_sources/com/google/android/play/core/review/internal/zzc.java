package com.google.android.play.core.review.internal;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
public final class zzc {
    private static final ClassLoader zza = zzc.class.getClassLoader();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzc() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parcelable zza(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + dataAvail);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzd(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface);
    }
}
