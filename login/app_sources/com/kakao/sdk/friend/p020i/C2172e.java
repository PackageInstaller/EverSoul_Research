package com.kakao.sdk.friend.p020i;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.ViewAppearance;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.i.e */
/* loaded from: classes3.dex */
public final class C2172e implements Parcelable {
    public static final Parcelable.Creator<C2172e> CREATOR = new a();

    /* renamed from: a */
    public final ViewAppearance f803a;

    /* renamed from: b */
    public final PickerOrientation f804b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2172e(ViewAppearance viewAppearance, PickerOrientation pickerOrientation) {
        this.f803a = viewAppearance;
        this.f804b = pickerOrientation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        ViewAppearance viewAppearance = this.f803a;
        if (viewAppearance == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(viewAppearance.name());
        }
        PickerOrientation pickerOrientation = this.f804b;
        if (pickerOrientation == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(pickerOrientation.name());
        }
    }

    /* renamed from: com.kakao.sdk.friend.i.e$a */
    public static final class a implements Parcelable.Creator<C2172e> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public C2172e createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new C2172e(parcel.readInt() == 0 ? null : ViewAppearance.valueOf(parcel.readString()), parcel.readInt() != 0 ? PickerOrientation.valueOf(parcel.readString()) : null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public C2172e[] newArray(int i) {
            return new C2172e[i];
        }
    }
}
