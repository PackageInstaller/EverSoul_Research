package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/Me;", "Landroid/os/Parcelable;", "", "id", "J", "a", "()J", "", "uuid", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "profileNickname", "b", "profileThumbnailImage", "c", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.network.model.Me */
/* loaded from: classes3.dex */
public final /* data */ class C2225Me implements Parcelable {
    public static final Parcelable.Creator<C2225Me> CREATOR = new Creator();
    private final long id;
    private final String profileNickname;
    private final String profileThumbnailImage;
    private final String uuid;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2225Me(long j, String uuid, String str, String str2) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.id = j;
        this.uuid = uuid;
        this.profileNickname = str;
        this.profileThumbnailImage = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final long m621a() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final String m622b() {
        return this.profileNickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final String m623c() {
        return this.profileThumbnailImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final String m624d() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2225Me)) {
            return false;
        }
        C2225Me c2225Me = (C2225Me) obj;
        return this.id == c2225Me.id && Intrinsics.areEqual(this.uuid, c2225Me.uuid) && Intrinsics.areEqual(this.profileNickname, c2225Me.profileNickname) && Intrinsics.areEqual(this.profileThumbnailImage, c2225Me.profileThumbnailImage);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.uuid.hashCode()) * 31;
        String str = this.profileNickname;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.profileThumbnailImage;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Me(id=" + this.id + ", uuid=" + this.uuid + ", profileNickname=" + ((Object) this.profileNickname) + ", profileThumbnailImage=" + ((Object) this.profileThumbnailImage) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.id);
        out.writeString(this.uuid);
        out.writeString(this.profileNickname);
        out.writeString(this.profileThumbnailImage);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    /* renamed from: com.kakao.sdk.friend.network.model.Me$Creator */
    public static final class Creator implements Parcelable.Creator<C2225Me> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public C2225Me createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new C2225Me(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public C2225Me[] newArray(int i) {
            return new C2225Me[i];
        }
    }
}
