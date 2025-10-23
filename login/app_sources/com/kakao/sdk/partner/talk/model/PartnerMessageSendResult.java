package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerMessageSendResult.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/PartnerMessageSendResult;", "Landroid/os/Parcelable;", "successfulReceiverIds", "", "", "failureInfos", "Lcom/kakao/sdk/partner/talk/model/PartnerMessageFailureInfo;", "(Ljava/util/List;Ljava/util/List;)V", "getFailureInfos", "()Ljava/util/List;", "getSuccessfulReceiverIds", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PartnerMessageSendResult implements Parcelable {
    public static final Parcelable.Creator<PartnerMessageSendResult> CREATOR = new Creator();

    @SerializedName("failure_info")
    private final List<PartnerMessageFailureInfo> failureInfos;
    private final List<String> successfulReceiverIds;

    /* compiled from: PartnerMessageSendResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<PartnerMessageSendResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerMessageSendResult createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(PartnerMessageFailureInfo.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PartnerMessageSendResult(createStringArrayList, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerMessageSendResult[] newArray(int i) {
            return new PartnerMessageSendResult[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ PartnerMessageSendResult copy$default(PartnerMessageSendResult partnerMessageSendResult, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = partnerMessageSendResult.successfulReceiverIds;
        }
        if ((i & 2) != 0) {
            list2 = partnerMessageSendResult.failureInfos;
        }
        return partnerMessageSendResult.copy(list, list2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> component1() {
        return this.successfulReceiverIds;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<PartnerMessageFailureInfo> component2() {
        return this.failureInfos;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerMessageSendResult copy(List<String> successfulReceiverIds, List<PartnerMessageFailureInfo> failureInfos) {
        return new PartnerMessageSendResult(successfulReceiverIds, failureInfos);
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
        if (!(other instanceof PartnerMessageSendResult)) {
            return false;
        }
        PartnerMessageSendResult partnerMessageSendResult = (PartnerMessageSendResult) other;
        return Intrinsics.areEqual(this.successfulReceiverIds, partnerMessageSendResult.successfulReceiverIds) && Intrinsics.areEqual(this.failureInfos, partnerMessageSendResult.failureInfos);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        List<String> list = this.successfulReceiverIds;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<PartnerMessageFailureInfo> list2 = this.failureInfos;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PartnerMessageSendResult(successfulReceiverIds=" + this.successfulReceiverIds + ", failureInfos=" + this.failureInfos + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.successfulReceiverIds);
        List<PartnerMessageFailureInfo> list = this.failureInfos;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<PartnerMessageFailureInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerMessageSendResult(List<String> list, List<PartnerMessageFailureInfo> list2) {
        this.successfulReceiverIds = list;
        this.failureInfos = list2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<PartnerMessageFailureInfo> getFailureInfos() {
        return this.failureInfos;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getSuccessfulReceiverIds() {
        return this.successfulReceiverIds;
    }
}
