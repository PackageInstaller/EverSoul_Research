package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Friend.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/FriendRelation;", "Landroid/os/Parcelable;", "talk", "Lcom/kakao/sdk/partner/talk/model/Relation;", "story", "(Lcom/kakao/sdk/partner/talk/model/Relation;Lcom/kakao/sdk/partner/talk/model/Relation;)V", "getStory", "()Lcom/kakao/sdk/partner/talk/model/Relation;", "getTalk", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FriendRelation implements Parcelable {
    public static final Parcelable.Creator<FriendRelation> CREATOR = new Creator();
    private final Relation story;
    private final Relation talk;

    /* compiled from: Friend.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<FriendRelation> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final FriendRelation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FriendRelation(parcel.readInt() == 0 ? null : Relation.valueOf(parcel.readString()), parcel.readInt() != 0 ? Relation.valueOf(parcel.readString()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final FriendRelation[] newArray(int i) {
            return new FriendRelation[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ FriendRelation copy$default(FriendRelation friendRelation, Relation relation, Relation relation2, int i, Object obj) {
        if ((i & 1) != 0) {
            relation = friendRelation.talk;
        }
        if ((i & 2) != 0) {
            relation2 = friendRelation.story;
        }
        return friendRelation.copy(relation, relation2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Relation component1() {
        return this.talk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Relation component2() {
        return this.story;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendRelation copy(Relation talk, Relation story) {
        return new FriendRelation(talk, story);
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
        if (!(other instanceof FriendRelation)) {
            return false;
        }
        FriendRelation friendRelation = (FriendRelation) other;
        return this.talk == friendRelation.talk && this.story == friendRelation.story;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Relation relation = this.talk;
        int hashCode = (relation == null ? 0 : relation.hashCode()) * 31;
        Relation relation2 = this.story;
        return hashCode + (relation2 != null ? relation2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "FriendRelation(talk=" + this.talk + ", story=" + this.story + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Relation relation = this.talk;
        if (relation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(relation.name());
        }
        Relation relation2 = this.story;
        if (relation2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(relation2.name());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FriendRelation(Relation relation, Relation relation2) {
        this.talk = relation;
        this.story = relation2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Relation getStory() {
        return this.story;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Relation getTalk() {
        return this.talk;
    }
}
