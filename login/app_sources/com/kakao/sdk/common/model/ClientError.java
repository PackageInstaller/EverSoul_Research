package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoSdkError.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, m839d2 = {"Lcom/kakao/sdk/common/model/ClientError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "reason", "Lcom/kakao/sdk/common/model/ClientErrorCause;", "msg", "", "(Lcom/kakao/sdk/common/model/ClientErrorCause;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getReason", "()Lcom/kakao/sdk/common/model/ClientErrorCause;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ClientError extends KakaoSdkError implements Parcelable {
    public static final Parcelable.Creator<ClientError> CREATOR = new Creator();
    private final String msg;
    private final ClientErrorCause reason;

    /* compiled from: KakaoSdkError.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ClientError> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ClientError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClientError(ClientErrorCause.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ClientError[] newArray(int i) {
            return new ClientError[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ClientError copy$default(ClientError clientError, ClientErrorCause clientErrorCause, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            clientErrorCause = clientError.reason;
        }
        if ((i & 2) != 0) {
            str = clientError.getMsg();
        }
        return clientError.copy(clientErrorCause, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ClientErrorCause component1() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return getMsg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ClientError copy(ClientErrorCause reason, String msg) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new ClientError(reason, msg);
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
        if (!(other instanceof ClientError)) {
            return false;
        }
        ClientError clientError = (ClientError) other;
        return this.reason == clientError.reason && Intrinsics.areEqual(getMsg(), clientError.getMsg());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.reason.hashCode() * 31) + getMsg().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return "ClientError(reason=" + this.reason + ", msg=" + getMsg() + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.reason.name());
        parcel.writeString(this.msg);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ClientError(com.kakao.sdk.common.model.ClientErrorCause r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L25
            java.lang.Class r2 = r1.getClass()
            java.lang.String r3 = r1.name()
            java.lang.reflect.Field r2 = r2.getField(r3)
            java.lang.Class<com.kakao.sdk.common.model.Description> r3 = com.kakao.sdk.common.model.Description.class
            java.lang.annotation.Annotation r2 = r2.getAnnotation(r3)
            com.kakao.sdk.common.model.Description r2 = (com.kakao.sdk.common.model.Description) r2
            java.lang.String r3 = "Client-side error"
            if (r2 != 0) goto L1e
        L1c:
            r2 = r3
            goto L25
        L1e:
            java.lang.String r2 = r2.value()
            if (r2 != 0) goto L25
            goto L1c
        L25:
            r0.<init>(r1, r2)
            return
            fill-array 0x002a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.common.model.ClientError.<init>(com.kakao.sdk.common.model.ClientErrorCause, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ClientErrorCause getReason() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.KakaoSdkError
    public String getMsg() {
        return this.msg;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ClientError(ClientErrorCause reason, String msg) {
        super(msg, null);
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.reason = reason;
        this.msg = msg;
    }
}
