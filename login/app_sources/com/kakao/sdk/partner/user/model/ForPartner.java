package com.kakao.sdk.partner.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakaogame.idp.KGKakao2Auth;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerUser.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, m839d2 = {"Lcom/kakao/sdk/partner/user/model/ForPartner;", "Landroid/os/Parcelable;", "uuid", "", KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, "", "remainingGroupMsgCount", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getRemainingGroupMsgCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRemainingInviteCount", "getUuid", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakao/sdk/partner/user/model/ForPartner;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ForPartner implements Parcelable {
    public static final Parcelable.Creator<ForPartner> CREATOR = new Creator();
    private final Integer remainingGroupMsgCount;
    private final Integer remainingInviteCount;
    private final String uuid;

    /* compiled from: PartnerUser.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ForPartner> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ForPartner createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ForPartner(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ForPartner[] newArray(int i) {
            return new ForPartner[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ForPartner copy$default(ForPartner forPartner, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = forPartner.uuid;
        }
        if ((i & 2) != 0) {
            num = forPartner.remainingInviteCount;
        }
        if ((i & 4) != 0) {
            num2 = forPartner.remainingGroupMsgCount;
        }
        return forPartner.copy(str, num, num2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component2() {
        return this.remainingInviteCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component3() {
        return this.remainingGroupMsgCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ForPartner copy(String uuid, Integer remainingInviteCount, Integer remainingGroupMsgCount) {
        return new ForPartner(uuid, remainingInviteCount, remainingGroupMsgCount);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForPartner)) {
            return false;
        }
        ForPartner forPartner = (ForPartner) other;
        return Intrinsics.areEqual(this.uuid, forPartner.uuid) && Intrinsics.areEqual(this.remainingInviteCount, forPartner.remainingInviteCount) && Intrinsics.areEqual(this.remainingGroupMsgCount, forPartner.remainingGroupMsgCount);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.uuid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.remainingInviteCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.remainingGroupMsgCount;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ForPartner(uuid=" + ((Object) this.uuid) + ", remainingInviteCount=" + this.remainingInviteCount + ", remainingGroupMsgCount=" + this.remainingGroupMsgCount + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        Integer num = this.remainingInviteCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.remainingGroupMsgCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ForPartner(String str, Integer num, Integer num2) {
        this.uuid = str;
        this.remainingInviteCount = num;
        this.remainingGroupMsgCount = num2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getRemainingInviteCount() {
        return this.remainingInviteCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getRemainingGroupMsgCount() {
        return this.remainingGroupMsgCount;
    }
}
