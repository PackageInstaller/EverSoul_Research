package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzu implements Parcelable.Creator<zzt> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzt createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        zzv zzvVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
                hashSet.add(1);
            } else if (fieldId == 2) {
                zzvVar = (zzv) SafeParcelReader.createParcelable(parcel, readHeader, zzv.CREATOR);
                hashSet.add(2);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
                hashSet.add(3);
            } else if (fieldId == 4) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
                hashSet.add(4);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str3 = SafeParcelReader.createString(parcel, readHeader);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzt(hashSet, i, zzvVar, str, str2, str3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
