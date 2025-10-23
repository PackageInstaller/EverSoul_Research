package com.kakao.sdk.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageSendResult.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, m839d2 = {"Lcom/kakao/sdk/talk/model/MessageFailureInfo;", "Landroid/os/Parcelable;", "code", "", "msg", "", "receiverUuids", "", "(ILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getReceiverUuids", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MessageFailureInfo implements Parcelable {
    public static final Parcelable.Creator<MessageFailureInfo> CREATOR = new Creator();
    private final int code;
    private final String msg;
    private final List<String> receiverUuids;

    /* compiled from: MessageSendResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<MessageFailureInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final MessageFailureInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MessageFailureInfo(parcel.readInt(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final MessageFailureInfo[] newArray(int i) {
            return new MessageFailureInfo[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ MessageFailureInfo copy$default(MessageFailureInfo messageFailureInfo, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messageFailureInfo.code;
        }
        if ((i2 & 2) != 0) {
            str = messageFailureInfo.msg;
        }
        if ((i2 & 4) != 0) {
            list = messageFailureInfo.receiverUuids;
        }
        return messageFailureInfo.copy(i, str, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.msg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> component3() {
        return this.receiverUuids;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MessageFailureInfo copy(int code, String msg, List<String> receiverUuids) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        return new MessageFailureInfo(code, msg, receiverUuids);
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
        if (!(other instanceof MessageFailureInfo)) {
            return false;
        }
        MessageFailureInfo messageFailureInfo = (MessageFailureInfo) other;
        return this.code == messageFailureInfo.code && Intrinsics.areEqual(this.msg, messageFailureInfo.msg) && Intrinsics.areEqual(this.receiverUuids, messageFailureInfo.receiverUuids);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31) + this.receiverUuids.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "MessageFailureInfo(code=" + this.code + ", msg=" + this.msg + ", receiverUuids=" + this.receiverUuids + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        parcel.writeStringList(this.receiverUuids);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MessageFailureInfo(int i, String msg, List<String> receiverUuids) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        this.code = i;
        this.msg = msg;
        this.receiverUuids = receiverUuids;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getCode() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getReceiverUuids() {
        return this.receiverUuids;
    }
}
