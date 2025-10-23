package com.kakao.sdk.auth.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.user.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessTokenResponse.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jt\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020)HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000f¨\u00065"}, m839d2 = {"Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "Landroid/os/Parcelable;", "accessToken", "", "refreshToken", "accessTokenExpiresIn", "", "refreshTokenExpiresIn", "idToken", "tokenType", "scope", Constants.SCOPES, "txId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getAccessTokenExpiresIn", "()J", "getIdToken", "getRefreshToken", "getRefreshTokenExpiresIn", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getScope", "getScopes$annotations", "()V", "getScopes", "getTokenType", "getTxId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AccessTokenResponse implements Parcelable {
    public static final Parcelable.Creator<AccessTokenResponse> CREATOR = new Creator();
    private final String accessToken;

    @SerializedName("expires_in")
    private final long accessTokenExpiresIn;
    private final String idToken;
    private final String refreshToken;
    private final Long refreshTokenExpiresIn;
    private final String scope;
    private final String scopes;
    private final String tokenType;
    private final String txId;

    /* compiled from: AccessTokenResponse.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<AccessTokenResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AccessTokenResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccessTokenResponse(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AccessTokenResponse[] newArray(int i) {
            return new AccessTokenResponse[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "해당 property는 'scope'로 대체되었습니다. ")
    public static /* synthetic */ void getScopes$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.refreshToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component3() {
        return this.accessTokenExpiresIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component4() {
        return this.refreshTokenExpiresIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.idToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component6() {
        return this.tokenType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component7() {
        return this.scope;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component8() {
        return this.scopes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component9() {
        return this.txId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AccessTokenResponse copy(String accessToken, String refreshToken, long accessTokenExpiresIn, Long refreshTokenExpiresIn, String idToken, String tokenType, String scope, String scopes, String txId) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        return new AccessTokenResponse(accessToken, refreshToken, accessTokenExpiresIn, refreshTokenExpiresIn, idToken, tokenType, scope, scopes, txId);
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
        if (!(other instanceof AccessTokenResponse)) {
            return false;
        }
        AccessTokenResponse accessTokenResponse = (AccessTokenResponse) other;
        return Intrinsics.areEqual(this.accessToken, accessTokenResponse.accessToken) && Intrinsics.areEqual(this.refreshToken, accessTokenResponse.refreshToken) && this.accessTokenExpiresIn == accessTokenResponse.accessTokenExpiresIn && Intrinsics.areEqual(this.refreshTokenExpiresIn, accessTokenResponse.refreshTokenExpiresIn) && Intrinsics.areEqual(this.idToken, accessTokenResponse.idToken) && Intrinsics.areEqual(this.tokenType, accessTokenResponse.tokenType) && Intrinsics.areEqual(this.scope, accessTokenResponse.scope) && Intrinsics.areEqual(this.scopes, accessTokenResponse.scopes) && Intrinsics.areEqual(this.txId, accessTokenResponse.txId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = this.accessToken.hashCode() * 31;
        String str = this.refreshToken;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.accessTokenExpiresIn)) * 31;
        Long l = this.refreshTokenExpiresIn;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.idToken;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.tokenType.hashCode()) * 31;
        String str3 = this.scope;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.scopes;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.txId;
        return hashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "AccessTokenResponse(accessToken=" + this.accessToken + ", refreshToken=" + ((Object) this.refreshToken) + ", accessTokenExpiresIn=" + this.accessTokenExpiresIn + ", refreshTokenExpiresIn=" + this.refreshTokenExpiresIn + ", idToken=" + ((Object) this.idToken) + ", tokenType=" + this.tokenType + ", scope=" + ((Object) this.scope) + ", scopes=" + ((Object) this.scopes) + ", txId=" + ((Object) this.txId) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accessToken);
        parcel.writeString(this.refreshToken);
        parcel.writeLong(this.accessTokenExpiresIn);
        Long l = this.refreshTokenExpiresIn;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.idToken);
        parcel.writeString(this.tokenType);
        parcel.writeString(this.scope);
        parcel.writeString(this.scopes);
        parcel.writeString(this.txId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessTokenResponse(String accessToken, String str, long j, Long l, String str2, String tokenType, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        this.accessToken = accessToken;
        this.refreshToken = str;
        this.accessTokenExpiresIn = j;
        this.refreshTokenExpiresIn = l;
        this.idToken = str2;
        this.tokenType = tokenType;
        this.scope = str3;
        this.scopes = str4;
        this.txId = str5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AccessTokenResponse(String str, String str2, long j, Long l, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3, str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getAccessTokenExpiresIn() {
        return this.accessTokenExpiresIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getRefreshTokenExpiresIn() {
        return this.refreshTokenExpiresIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdToken() {
        return this.idToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTokenType() {
        return this.tokenType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getScope() {
        return this.scope;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getScopes() {
        return this.scopes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTxId() {
        return this.txId;
    }
}
