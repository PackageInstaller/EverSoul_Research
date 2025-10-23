package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.user.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoSdkError.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, m839d2 = {"Lcom/kakao/sdk/common/model/ApiError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "statusCode", "", "reason", "Lcom/kakao/sdk/common/model/ApiErrorCause;", "response", "Lcom/kakao/sdk/common/model/ApiErrorResponse;", "(ILcom/kakao/sdk/common/model/ApiErrorCause;Lcom/kakao/sdk/common/model/ApiErrorResponse;)V", "getReason", "()Lcom/kakao/sdk/common/model/ApiErrorCause;", "getResponse", "()Lcom/kakao/sdk/common/model/ApiErrorResponse;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApiError extends KakaoSdkError implements Parcelable {
    private final ApiErrorCause reason;
    private final ApiErrorResponse response;
    private final int statusCode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ApiError> CREATOR = new Creator();

    /* compiled from: KakaoSdkError.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ApiError> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ApiError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ApiError(parcel.readInt(), ApiErrorCause.valueOf(parcel.readString()), ApiErrorResponse.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ApiError[] newArray(int i) {
            return new ApiError[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ApiError copy$default(ApiError apiError, int i, ApiErrorCause apiErrorCause, ApiErrorResponse apiErrorResponse, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = apiError.statusCode;
        }
        if ((i2 & 2) != 0) {
            apiErrorCause = apiError.reason;
        }
        if ((i2 & 4) != 0) {
            apiErrorResponse = apiError.response;
        }
        return apiError.copy(i, apiErrorCause, apiErrorResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.statusCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApiErrorCause component2() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApiErrorResponse component3() {
        return this.response;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApiError copy(int statusCode, ApiErrorCause reason, ApiErrorResponse response) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(response, "response");
        return new ApiError(statusCode, reason, response);
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
        if (!(other instanceof ApiError)) {
            return false;
        }
        ApiError apiError = (ApiError) other;
        return this.statusCode == apiError.statusCode && this.reason == apiError.reason && Intrinsics.areEqual(this.response, apiError.response);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((Integer.hashCode(this.statusCode) * 31) + this.reason.hashCode()) * 31) + this.response.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return "ApiError(statusCode=" + this.statusCode + ", reason=" + this.reason + ", response=" + this.response + ')';
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
    public final ApiErrorCause getReason() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApiErrorResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApiError(int i, ApiErrorCause reason, ApiErrorResponse response) {
        super(response.getMsg(), null);
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(response, "response");
        this.statusCode = i;
        this.reason = reason;
        this.response = response;
    }

    /* compiled from: KakaoSdkError.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, m839d2 = {"Lcom/kakao/sdk/common/model/ApiError$Companion;", "", "()V", "fromScopes", "Lcom/kakao/sdk/common/model/ApiError;", Constants.SCOPES, "", "", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ApiError fromScopes(List<String> scopes) {
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            return new ApiError(403, ApiErrorCause.InsufficientScope, new ApiErrorResponse(ApiErrorCause.InsufficientScope.getErrorCode(), "", null, scopes, null, 20, null));
        }
    }
}
