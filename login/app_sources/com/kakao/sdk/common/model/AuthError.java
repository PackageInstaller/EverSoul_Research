package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoSdkError.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, m839d2 = {"Lcom/kakao/sdk/common/model/AuthError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "statusCode", "", "reason", "Lcom/kakao/sdk/common/model/AuthErrorCause;", "response", "Lcom/kakao/sdk/common/model/AuthErrorResponse;", "(ILcom/kakao/sdk/common/model/AuthErrorCause;Lcom/kakao/sdk/common/model/AuthErrorResponse;)V", "getReason", "()Lcom/kakao/sdk/common/model/AuthErrorCause;", "getResponse", "()Lcom/kakao/sdk/common/model/AuthErrorResponse;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthError extends KakaoSdkError implements Parcelable {
    public static final Parcelable.Creator<AuthError> CREATOR = new Creator();
    private final AuthErrorCause reason;
    private final AuthErrorResponse response;
    private final int statusCode;

    /* compiled from: KakaoSdkError.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthError> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AuthError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthError(parcel.readInt(), AuthErrorCause.valueOf(parcel.readString()), AuthErrorResponse.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AuthError[] newArray(int i) {
            return new AuthError[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ AuthError copy$default(AuthError authError, int i, AuthErrorCause authErrorCause, AuthErrorResponse authErrorResponse, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = authError.statusCode;
        }
        if ((i2 & 2) != 0) {
            authErrorCause = authError.reason;
        }
        if ((i2 & 4) != 0) {
            authErrorResponse = authError.response;
        }
        return authError.copy(i, authErrorCause, authErrorResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.statusCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AuthErrorCause component2() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AuthErrorResponse component3() {
        return this.response;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AuthError copy(int statusCode, AuthErrorCause reason, AuthErrorResponse response) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(response, "response");
        return new AuthError(statusCode, reason, response);
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
        if (!(other instanceof AuthError)) {
            return false;
        }
        AuthError authError = (AuthError) other;
        return this.statusCode == authError.statusCode && this.reason == authError.reason && Intrinsics.areEqual(this.response, authError.response);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((Integer.hashCode(this.statusCode) * 31) + this.reason.hashCode()) * 31) + this.response.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return "AuthError(statusCode=" + this.statusCode + ", reason=" + this.reason + ", response=" + this.response + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.reason.name());
        this.response.writeToParcel(parcel, flags);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AuthErrorCause getReason() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AuthErrorResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AuthError(int r3, com.kakao.sdk.common.model.AuthErrorCause r4, com.kakao.sdk.common.model.AuthErrorResponse r5) {
        /*
            r2 = this;
            java.lang.String r0 = "reason"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r5.getErrorDescription()
            if (r0 != 0) goto L14
            java.lang.String r0 = r5.getError()
        L14:
            r1 = 0
            r2.<init>(r0, r1)
            r2.statusCode = r3
            r2.reason = r4
            r2.response = r5
            return
            fill-array 0x0020: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.common.model.AuthError.<init>(int, com.kakao.sdk.common.model.AuthErrorCause, com.kakao.sdk.common.model.AuthErrorResponse):void");
    }
}
