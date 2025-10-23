package com.kakao.sdk.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.talk.Constants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelRelations.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006$"}, m839d2 = {"Lcom/kakao/sdk/talk/model/Channel;", "Landroid/os/Parcelable;", "uuid", "", "encodedId", Constants.RELATION, "Lcom/kakao/sdk/talk/model/Channel$Relation;", "updatedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/talk/model/Channel$Relation;Ljava/util/Date;)V", "getEncodedId", "()Ljava/lang/String;", "getRelation", "()Lcom/kakao/sdk/talk/model/Channel$Relation;", "getUpdatedAt", "()Ljava/util/Date;", "getUuid", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Relation", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Channel implements Parcelable {
    public static final Parcelable.Creator<Channel> CREATOR = new Creator();

    @SerializedName("channel_public_id")
    private final String encodedId;
    private final Relation relation;
    private final Date updatedAt;

    @SerializedName(Constants.CHANNEL_UUID)
    private final String uuid;

    /* compiled from: ChannelRelations.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Channel> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Channel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Channel(parcel.readString(), parcel.readString(), Relation.valueOf(parcel.readString()), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Channel[] newArray(int i) {
            return new Channel[i];
        }
    }

    /* compiled from: ChannelRelations.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakao/sdk/talk/model/Channel$Relation;", "", "(Ljava/lang/String;I)V", "ADDED", "NONE", "BLOCKED", "UNKNOWN", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public enum Relation {
        ADDED,
        NONE,
        BLOCKED,
        UNKNOWN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, Relation relation, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channel.uuid;
        }
        if ((i & 2) != 0) {
            str2 = channel.encodedId;
        }
        if ((i & 4) != 0) {
            relation = channel.relation;
        }
        if ((i & 8) != 0) {
            date = channel.updatedAt;
        }
        return channel.copy(str, str2, relation, date);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.encodedId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Relation component3() {
        return this.relation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component4() {
        return this.updatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Channel copy(String uuid, String encodedId, Relation relation, Date updatedAt) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(encodedId, "encodedId");
        Intrinsics.checkNotNullParameter(relation, "relation");
        return new Channel(uuid, encodedId, relation, updatedAt);
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
        if (!(other instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) other;
        return Intrinsics.areEqual(this.uuid, channel.uuid) && Intrinsics.areEqual(this.encodedId, channel.encodedId) && this.relation == channel.relation && Intrinsics.areEqual(this.updatedAt, channel.updatedAt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((((this.uuid.hashCode() * 31) + this.encodedId.hashCode()) * 31) + this.relation.hashCode()) * 31;
        Date date = this.updatedAt;
        return hashCode + (date == null ? 0 : date.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Channel(uuid=" + this.uuid + ", encodedId=" + this.encodedId + ", relation=" + this.relation + ", updatedAt=" + this.updatedAt + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.encodedId);
        parcel.writeString(this.relation.name());
        parcel.writeSerializable(this.updatedAt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Channel(String uuid, String encodedId, Relation relation, Date date) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(encodedId, "encodedId");
        Intrinsics.checkNotNullParameter(relation, "relation");
        this.uuid = uuid;
        this.encodedId = encodedId;
        this.relation = relation;
        this.updatedAt = date;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEncodedId() {
        return this.encodedId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Relation getRelation() {
        return this.relation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }
}
