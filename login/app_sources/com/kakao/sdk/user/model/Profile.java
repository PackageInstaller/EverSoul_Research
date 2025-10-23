package com.kakao.sdk.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakaogame.idp.KGKakao2Auth;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: User.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006!"}, m839d2 = {"Lcom/kakao/sdk/user/model/Profile;", "Landroid/os/Parcelable;", "nickname", "", "profileImageUrl", KGKakao2Auth.KEY_THUMBNAIL_IMAGE_URL, "isDefaultImage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNickname", "()Ljava/lang/String;", "getProfileImageUrl", "getThumbnailImageUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/kakao/sdk/user/model/Profile;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Creator();
    private final Boolean isDefaultImage;
    private final String nickname;
    private final String profileImageUrl;
    private final String thumbnailImageUrl;

    /* compiled from: User.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Profile> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Profile createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Profile(readString, readString2, readString3, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Profile[] newArray(int i) {
            return new Profile[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Profile copy$default(Profile profile, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profile.nickname;
        }
        if ((i & 2) != 0) {
            str2 = profile.profileImageUrl;
        }
        if ((i & 4) != 0) {
            str3 = profile.thumbnailImageUrl;
        }
        if ((i & 8) != 0) {
            bool = profile.isDefaultImage;
        }
        return profile.copy(str, str2, str3, bool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.profileImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.thumbnailImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component4() {
        return this.isDefaultImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Profile copy(String nickname, String profileImageUrl, String thumbnailImageUrl, Boolean isDefaultImage) {
        return new Profile(nickname, profileImageUrl, thumbnailImageUrl, isDefaultImage);
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
        if (!(other instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) other;
        return Intrinsics.areEqual(this.nickname, profile.nickname) && Intrinsics.areEqual(this.profileImageUrl, profile.profileImageUrl) && Intrinsics.areEqual(this.thumbnailImageUrl, profile.thumbnailImageUrl) && Intrinsics.areEqual(this.isDefaultImage, profile.isDefaultImage);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.nickname;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.profileImageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnailImageUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isDefaultImage;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Profile(nickname=" + ((Object) this.nickname) + ", profileImageUrl=" + ((Object) this.profileImageUrl) + ", thumbnailImageUrl=" + ((Object) this.thumbnailImageUrl) + ", isDefaultImage=" + this.isDefaultImage + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int i;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.nickname);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.thumbnailImageUrl);
        Boolean bool = this.isDefaultImage;
        if (bool == null) {
            i = 0;
        } else {
            parcel.writeInt(1);
            i = bool.booleanValue();
        }
        parcel.writeInt(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Profile(String str, String str2, String str3, Boolean bool) {
        this.nickname = str;
        this.profileImageUrl = str2;
        this.thumbnailImageUrl = str3;
        this.isDefaultImage = bool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getThumbnailImageUrl() {
        return this.thumbnailImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isDefaultImage() {
        return this.isDefaultImage;
    }
}
