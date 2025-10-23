package com.kakao.sdk.friend.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, m839d2 = {"Lcom/kakao/sdk/friend/model/DisableSelectOption;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/DisableSelectReason;", "reason", "Lcom/kakao/sdk/friend/model/DisableSelectReason;", "getReason", "()Lcom/kakao/sdk/friend/model/DisableSelectReason;", "setReason", "(Lcom/kakao/sdk/friend/model/DisableSelectReason;)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "", "uuids", "Ljava/util/List;", "getUuids", "()Ljava/util/List;", "setUuids", "(Ljava/util/List;)V", "<init>", "(Lcom/kakao/sdk/friend/model/DisableSelectReason;Ljava/lang/String;Ljava/util/List;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class DisableSelectOption implements Parcelable {
    public static final Parcelable.Creator<DisableSelectOption> CREATOR = new Creator();
    private final String message;
    private DisableSelectReason reason;
    private List<String> uuids;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<DisableSelectOption> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final DisableSelectOption createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DisableSelectOption(DisableSelectReason.valueOf(parcel.readString()), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final DisableSelectOption[] newArray(int i) {
            return new DisableSelectOption[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DisableSelectOption(DisableSelectReason reason) {
        this(reason, null, null, 6, null);
        Intrinsics.checkNotNullParameter(reason, "reason");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DisableSelectOption(DisableSelectReason reason, String str) {
        this(reason, str, null, 4, null);
        Intrinsics.checkNotNullParameter(reason, "reason");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DisableSelectOption(DisableSelectReason reason, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.reason = reason;
        this.message = str;
        this.uuids = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ DisableSelectOption(DisableSelectReason disableSelectReason, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(disableSelectReason, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DisableSelectReason getReason() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getUuids() {
        return this.uuids;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setReason(DisableSelectReason disableSelectReason) {
        Intrinsics.checkNotNullParameter(disableSelectReason, "<set-?>");
        this.reason = disableSelectReason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setUuids(List<String> list) {
        this.uuids = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.reason.name());
        parcel.writeString(this.message);
        parcel.writeStringList(this.uuids);
    }
}
