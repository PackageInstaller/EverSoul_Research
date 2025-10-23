package com.kakao.sdk.auth.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.Constants;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* compiled from: OAuthToken.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, m839d2 = {"Lcom/kakao/sdk/auth/model/OAuthToken;", "Landroid/os/Parcelable;", "accessToken", "", "accessTokenExpiresAt", "Ljava/util/Date;", "refreshToken", "refreshTokenExpiresAt", "idToken", Constants.SCOPES, "", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/List;)V", "getAccessToken", "()Ljava/lang/String;", "getAccessTokenExpiresAt", "()Ljava/util/Date;", "getIdToken", "getRefreshToken", "getRefreshTokenExpiresAt", "getScopes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OAuthToken implements Parcelable {
    private final String accessToken;
    private final Date accessTokenExpiresAt;
    private final String idToken;
    private final String refreshToken;
    private final Date refreshTokenExpiresAt;
    private final List<String> scopes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<OAuthToken> CREATOR = new Creator();

    /* compiled from: OAuthToken.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<OAuthToken> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final OAuthToken createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OAuthToken(parcel.readString(), (Date) parcel.readSerializable(), parcel.readString(), (Date) parcel.readSerializable(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final OAuthToken[] newArray(int i) {
            return new OAuthToken[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ OAuthToken copy$default(OAuthToken oAuthToken, String str, Date date, String str2, Date date2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oAuthToken.accessToken;
        }
        if ((i & 2) != 0) {
            date = oAuthToken.accessTokenExpiresAt;
        }
        Date date3 = date;
        if ((i & 4) != 0) {
            str2 = oAuthToken.refreshToken;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            date2 = oAuthToken.refreshTokenExpiresAt;
        }
        Date date4 = date2;
        if ((i & 16) != 0) {
            str3 = oAuthToken.idToken;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            list = oAuthToken.scopes;
        }
        return oAuthToken.copy(str, date3, str4, date4, str5, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component2() {
        return this.accessTokenExpiresAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.refreshToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component4() {
        return this.refreshTokenExpiresAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.idToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> component6() {
        return this.scopes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final OAuthToken copy(String accessToken, Date accessTokenExpiresAt, String refreshToken, Date refreshTokenExpiresAt, String idToken, List<String> scopes) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(accessTokenExpiresAt, "accessTokenExpiresAt");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(refreshTokenExpiresAt, "refreshTokenExpiresAt");
        return new OAuthToken(accessToken, accessTokenExpiresAt, refreshToken, refreshTokenExpiresAt, idToken, scopes);
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
        if (!(other instanceof OAuthToken)) {
            return false;
        }
        OAuthToken oAuthToken = (OAuthToken) other;
        return Intrinsics.areEqual(this.accessToken, oAuthToken.accessToken) && Intrinsics.areEqual(this.accessTokenExpiresAt, oAuthToken.accessTokenExpiresAt) && Intrinsics.areEqual(this.refreshToken, oAuthToken.refreshToken) && Intrinsics.areEqual(this.refreshTokenExpiresAt, oAuthToken.refreshTokenExpiresAt) && Intrinsics.areEqual(this.idToken, oAuthToken.idToken) && Intrinsics.areEqual(this.scopes, oAuthToken.scopes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((((((this.accessToken.hashCode() * 31) + this.accessTokenExpiresAt.hashCode()) * 31) + this.refreshToken.hashCode()) * 31) + this.refreshTokenExpiresAt.hashCode()) * 31;
        String str = this.idToken;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.scopes;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "OAuthToken(accessToken=" + this.accessToken + ", accessTokenExpiresAt=" + this.accessTokenExpiresAt + ", refreshToken=" + this.refreshToken + ", refreshTokenExpiresAt=" + this.refreshTokenExpiresAt + ", idToken=" + ((Object) this.idToken) + ", scopes=" + this.scopes + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accessToken);
        parcel.writeSerializable(this.accessTokenExpiresAt);
        parcel.writeString(this.refreshToken);
        parcel.writeSerializable(this.refreshTokenExpiresAt);
        parcel.writeString(this.idToken);
        parcel.writeStringList(this.scopes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OAuthToken(String accessToken, Date accessTokenExpiresAt, String refreshToken, Date refreshTokenExpiresAt, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(accessTokenExpiresAt, "accessTokenExpiresAt");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(refreshTokenExpiresAt, "refreshTokenExpiresAt");
        this.accessToken = accessToken;
        this.accessTokenExpiresAt = accessTokenExpiresAt;
        this.refreshToken = refreshToken;
        this.refreshTokenExpiresAt = refreshTokenExpiresAt;
        this.idToken = str;
        this.scopes = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ OAuthToken(String str, Date date, String str2, Date date2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, str2, date2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getAccessTokenExpiresAt() {
        return this.accessTokenExpiresAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getRefreshTokenExpiresAt() {
        return this.refreshTokenExpiresAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdToken() {
        return this.idToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getScopes() {
        return this.scopes;
    }

    /* compiled from: OAuthToken.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¨\u0006\b"}, m839d2 = {"Lcom/kakao/sdk/auth/model/OAuthToken$Companion;", "", "()V", "fromResponse", "Lcom/kakao/sdk/auth/model/OAuthToken;", "response", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "oldToken", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ OAuthToken fromResponse$default(Companion companion, AccessTokenResponse accessTokenResponse, OAuthToken oAuthToken, int i, Object obj) {
            if ((i & 2) != 0) {
                oAuthToken = null;
            }
            return companion.fromResponse(accessTokenResponse, oAuthToken);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final OAuthToken fromResponse(AccessTokenResponse response, OAuthToken oldToken) {
            Date refreshTokenExpiresAt;
            Intrinsics.checkNotNullParameter(response, "response");
            String accessToken = response.getAccessToken();
            Date date = new Date(new Date().getTime() + (response.getAccessTokenExpiresIn() * 1000));
            String refreshToken = response.getRefreshToken();
            if (refreshToken == null) {
                refreshToken = oldToken == null ? null : oldToken.getRefreshToken();
                if (refreshToken == null) {
                    throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found in the response.");
                }
            }
            String str = refreshToken;
            if (response.getRefreshToken() != null) {
                Long refreshTokenExpiresIn = response.getRefreshTokenExpiresIn();
                refreshTokenExpiresAt = refreshTokenExpiresIn == null ? null : new Date(new Date().getTime() + (refreshTokenExpiresIn.longValue() * 1000));
                if (refreshTokenExpiresAt == null) {
                    refreshTokenExpiresAt = new Date();
                }
            } else {
                refreshTokenExpiresAt = oldToken == null ? null : oldToken.getRefreshTokenExpiresAt();
                Intrinsics.checkNotNull(refreshTokenExpiresAt);
            }
            Date date2 = refreshTokenExpiresAt;
            String scope = response.getScope();
            List<String> split$default = scope == null ? null : StringsKt.split$default((CharSequence) scope, new String[]{StringUtils.SPACE}, false, 0, 6, (Object) null);
            return new OAuthToken(accessToken, date, str, date2, response.getIdToken(), split$default == null ? oldToken == null ? null : oldToken.getScopes() : split$default);
        }
    }
}
