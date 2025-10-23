package com.kakao.sdk.network;

import androidx.core.app.NotificationCompat;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/* compiled from: ApiCallback.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0015B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J!\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J$\u0010\u0012\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/network/ApiCallback;", "T", "Lretrofit2/Callback;", "logging", "", "(Z)V", "getLogging", "()Z", "onComplete", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "error", "", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "onFailure", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "t", "onResponse", "response", "Lretrofit2/Response;", "Companion", "network_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public abstract class ApiCallback<T> implements Callback<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean logging;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApiCallback() {
        this(false, 1, null);
    }

    public abstract void onComplete(T model, Throwable error);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApiCallback(boolean z) {
        this.logging = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ApiCallback(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getLogging() {
        return this.logging;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Throwable origin = ExceptionWrapperKt.getOrigin(t);
        if (getLogging()) {
            SdkLog.INSTANCE.m470e(origin);
        }
        onComplete(null, origin);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        T body = response.body();
        if (body != null) {
            if (this.logging) {
                SdkLog.INSTANCE.m471i(body);
            }
            onComplete(body, null);
            return;
        }
        onFailure(call, INSTANCE.translateError(new HttpException(response)));
    }

    /* compiled from: ApiCallback.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m839d2 = {"Lcom/kakao/sdk/network/ApiCallback$Companion;", "", "()V", "translateError", "", "t", "network_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Throwable translateError(Throwable t) {
            ResponseBody errorBody;
            Intrinsics.checkNotNullParameter(t, "t");
            try {
                if (!(t instanceof HttpException)) {
                    return t;
                }
                Response<?> response = ((HttpException) t).response();
                String str = null;
                if (response != null && (errorBody = response.errorBody()) != null) {
                    str = errorBody.string();
                }
                KakaoJson kakaoJson = KakaoJson.INSTANCE;
                Intrinsics.checkNotNull(str);
                ApiErrorResponse apiErrorResponse = (ApiErrorResponse) kakaoJson.fromJson(str, ApiErrorResponse.class);
                ApiErrorCause apiErrorCause = (ApiErrorCause) KakaoJson.INSTANCE.fromJson(String.valueOf(apiErrorResponse.getCode()), ApiErrorCause.class);
                if (apiErrorCause == null) {
                    apiErrorCause = ApiErrorCause.Unknown;
                }
                return new ApiError(((HttpException) t).code(), apiErrorCause, apiErrorResponse);
            } catch (Throwable th) {
                return th;
            }
        }
    }
}
