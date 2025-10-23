package com.kakao.sdk.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.talk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TalkProfile.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, m839d2 = {"Lcom/kakao/sdk/talk/model/TalkProfile;", "Landroid/os/Parcelable;", "nickname", "", "profileImageUrl", "thumbnailUrl", Constants.COUNTRY_ISO, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryISO", "()Ljava/lang/String;", "getNickname", "getProfileImageUrl", "getThumbnailUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TalkProfile implements Parcelable {
    public static final Parcelable.Creator<TalkProfile> CREATOR = new Creator();

    @SerializedName(Constants.COUNTRY_ISO)
    private final String countryISO;

    @SerializedName(Constants.NICKNAME)
    private final String nickname;

    @SerializedName(Constants.PROFILE_IMAGE_URL)
    private final String profileImageUrl;

    @SerializedName(Constants.THUMBNAIL_URL)
    private final String thumbnailUrl;

    /* compiled from: TalkProfile.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<TalkProfile> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final TalkProfile createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TalkProfile(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final TalkProfile[] newArray(int i) {
            return new TalkProfile[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ TalkProfile copy$default(TalkProfile talkProfile, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = talkProfile.nickname;
        }
        if ((i & 2) != 0) {
            str2 = talkProfile.profileImageUrl;
        }
        if ((i & 4) != 0) {
            str3 = talkProfile.thumbnailUrl;
        }
        if ((i & 8) != 0) {
            str4 = talkProfile.countryISO;
        }
        return talkProfile.copy(str, str2, str3, str4);
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
        return this.thumbnailUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.countryISO;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TalkProfile copy(String nickname, String profileImageUrl, String thumbnailUrl, String countryISO) {
        return new TalkProfile(nickname, profileImageUrl, thumbnailUrl, countryISO);
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
        if (!(other instanceof TalkProfile)) {
            return false;
        }
        TalkProfile talkProfile = (TalkProfile) other;
        return Intrinsics.areEqual(this.nickname, talkProfile.nickname) && Intrinsics.areEqual(this.profileImageUrl, talkProfile.profileImageUrl) && Intrinsics.areEqual(this.thumbnailUrl, talkProfile.thumbnailUrl) && Intrinsics.areEqual(this.countryISO, talkProfile.countryISO);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.nickname;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.profileImageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnailUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.countryISO;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "TalkProfile(nickname=" + ((Object) this.nickname) + ", profileImageUrl=" + ((Object) this.profileImageUrl) + ", thumbnailUrl=" + ((Object) this.thumbnailUrl) + ", countryISO=" + ((Object) this.countryISO) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.nickname);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.countryISO);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TalkProfile(String str, String str2, String str3, String str4) {
        this.nickname = str;
        this.profileImageUrl = str2;
        this.thumbnailUrl = str3;
        this.countryISO = str4;
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
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCountryISO() {
        return this.countryISO;
    }
}
