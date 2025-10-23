package com.kakao.sdk.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageSendResult.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, m839d2 = {"Lcom/kakao/sdk/talk/model/MessageSendResult;", "Landroid/os/Parcelable;", "successfulReceiverUuids", "", "", "failureInfos", "Lcom/kakao/sdk/talk/model/MessageFailureInfo;", "(Ljava/util/List;Ljava/util/List;)V", "getFailureInfos", "()Ljava/util/List;", "getSuccessfulReceiverUuids", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MessageSendResult implements Parcelable {
    public static final Parcelable.Creator<MessageSendResult> CREATOR = new Creator();

    @SerializedName("failure_info")
    private final List<MessageFailureInfo> failureInfos;
    private final List<String> successfulReceiverUuids;

    /* compiled from: MessageSendResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<MessageSendResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final MessageSendResult createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(MessageFailureInfo.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new MessageSendResult(createStringArrayList, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final MessageSendResult[] newArray(int i) {
            return new MessageSendResult[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ MessageSendResult copy$default(MessageSendResult messageSendResult, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = messageSendResult.successfulReceiverUuids;
        }
        if ((i & 2) != 0) {
            list2 = messageSendResult.failureInfos;
        }
        return messageSendResult.copy(list, list2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> component1() {
        return this.successfulReceiverUuids;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<MessageFailureInfo> component2() {
        return this.failureInfos;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MessageSendResult copy(List<String> successfulReceiverUuids, List<MessageFailureInfo> failureInfos) {
        return new MessageSendResult(successfulReceiverUuids, failureInfos);
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
        if (!(other instanceof MessageSendResult)) {
            return false;
        }
        MessageSendResult messageSendResult = (MessageSendResult) other;
        return Intrinsics.areEqual(this.successfulReceiverUuids, messageSendResult.successfulReceiverUuids) && Intrinsics.areEqual(this.failureInfos, messageSendResult.failureInfos);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        List<String> list = this.successfulReceiverUuids;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MessageFailureInfo> list2 = this.failureInfos;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "MessageSendResult(successfulReceiverUuids=" + this.successfulReceiverUuids + ", failureInfos=" + this.failureInfos + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.successfulReceiverUuids);
        List<MessageFailureInfo> list = this.failureInfos;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<MessageFailureInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MessageSendResult(List<String> list, List<MessageFailureInfo> list2) {
        this.successfulReceiverUuids = list;
        this.failureInfos = list2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getSuccessfulReceiverUuids() {
        return this.successfulReceiverUuids;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<MessageFailureInfo> getFailureInfos() {
        return this.failureInfos;
    }
}
