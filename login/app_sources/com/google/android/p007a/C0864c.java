package com.google.android.p007a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Codecs.java */
/* renamed from: com.google.android.a.c */
/* loaded from: classes.dex */
public final class C0864c {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        C0864c.class.getClassLoader();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C0864c() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static <T extends Parcelable> T m103a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static void m104b(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public static void m105c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 1);
        }
    }
}
