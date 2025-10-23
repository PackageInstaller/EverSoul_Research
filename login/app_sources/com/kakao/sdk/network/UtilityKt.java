package com.kakao.sdk.network;

import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.util.KakaoJson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Utility.kt */
@Metadata(m838d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001aR\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000428\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m839d2 = {"proceedApiError", "Lokhttp3/Response;", "Lokhttp3/Interceptor$Chain;", "request", "Lokhttp3/Request;", "errorHandler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "response", "Lcom/kakao/sdk/common/model/ApiError;", "error", "proceedBodyString", "bodyHandler", "", "bodyString", "network_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UtilityKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Response proceedBodyString(Interceptor.Chain chain, Request request, Function2<? super Response, ? super String, Response> bodyHandler) {
        Intrinsics.checkNotNullParameter(chain, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bodyHandler, "bodyHandler");
        Response proceed = chain.proceed(request);
        ResponseBody body = proceed.body();
        String string = body == null ? null : body.string();
        Response build = proceed.newBuilder().body(string != null ? ResponseBody.INSTANCE.create(string, body.contentType()) : null).build();
        if (string != null) {
            ResponseBody.INSTANCE.create(string, body.contentType());
        }
        return bodyHandler.invoke(build, string);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Response proceedApiError(Interceptor.Chain chain, Request request, Function2<? super Response, ? super ApiError, Response> errorHandler) {
        Intrinsics.checkNotNullParameter(chain, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Response proceed = chain.proceed(request);
        ResponseBody body = proceed.body();
        String string = body == null ? null : body.string();
        Response build = proceed.newBuilder().body(string == null ? null : ResponseBody.INSTANCE.create(string, body.contentType())).build();
        if (string != null) {
            ResponseBody.INSTANCE.create(string, body.contentType());
        }
        if (build.isSuccessful()) {
            return build;
        }
        ApiErrorResponse apiErrorResponse = string == null ? null : (ApiErrorResponse) KakaoJson.INSTANCE.fromJson(string, ApiErrorResponse.class);
        ApiErrorCause apiErrorCause = apiErrorResponse != null ? (ApiErrorCause) KakaoJson.INSTANCE.fromJson(String.valueOf(apiErrorResponse.getCode()), ApiErrorCause.class) : null;
        return apiErrorCause != null ? errorHandler.invoke(build, new ApiError(build.code(), apiErrorCause, apiErrorResponse)) : build;
    }
}
