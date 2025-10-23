package com.kakao.sdk.auth.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.partner.talk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertTokenInfo.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, m839d2 = {"Lcom/kakao/sdk/auth/model/CertTokenInfo;", "Landroid/os/Parcelable;", Constants.TOKEN, "Lcom/kakao/sdk/auth/model/OAuthToken;", "txId", "", "(Lcom/kakao/sdk/auth/model/OAuthToken;Ljava/lang/String;)V", "getToken", "()Lcom/kakao/sdk/auth/model/OAuthToken;", "getTxId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CertTokenInfo implements Parcelable {
    public static final Parcelable.Creator<CertTokenInfo> CREATOR = new Creator();
    private final OAuthToken token;
    private final String txId;

    /* compiled from: CertTokenInfo.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<CertTokenInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final CertTokenInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CertTokenInfo(OAuthToken.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final CertTokenInfo[] newArray(int i) {
            return new CertTokenInfo[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ CertTokenInfo copy$default(CertTokenInfo certTokenInfo, OAuthToken oAuthToken, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            oAuthToken = certTokenInfo.token;
        }
        if ((i & 2) != 0) {
            str = certTokenInfo.txId;
        }
        return certTokenInfo.copy(oAuthToken, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final OAuthToken component1() {
        return this.token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.txId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CertTokenInfo copy(OAuthToken token, String txId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(txId, "txId");
        return new CertTokenInfo(token, txId);
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
        if (!(other instanceof CertTokenInfo)) {
            return false;
        }
        CertTokenInfo certTokenInfo = (CertTokenInfo) other;
        return Intrinsics.areEqual(this.token, certTokenInfo.token) && Intrinsics.areEqual(this.txId, certTokenInfo.txId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.token.hashCode() * 31) + this.txId.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "CertTokenInfo(token=" + this.token + ", txId=" + this.txId + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.token.writeToParcel(parcel, flags);
        parcel.writeString(this.txId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CertTokenInfo(OAuthToken token, String txId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(txId, "txId");
        this.token = token;
        this.txId = txId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final OAuthToken getToken() {
        return this.token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTxId() {
        return this.txId;
    }
}
