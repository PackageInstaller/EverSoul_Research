package com.kakao.sdk.partner.user.network;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ExceptionWrapper;
import com.kakao.sdk.partner.user.UserApiClientKt;
import com.kakao.sdk.user.UserApiClient;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: RequiredAgeVerificationInterceptor.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakao/sdk/partner/user/network/RequiredAgeVerificationInterceptor;", "Lokhttp3/Interceptor;", "contextInfo", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "(Lcom/kakao/sdk/common/model/ApplicationContextInfo;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class RequiredAgeVerificationInterceptor implements Interceptor {
    private final ApplicationContextInfo contextInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequiredAgeVerificationInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequiredAgeVerificationInterceptor(ApplicationContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        this.contextInfo = contextInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RequiredAgeVerificationInterceptor(ApplicationContextInfo applicationContextInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        ResponseBody body = proceed.body();
        String string = body == null ? null : body.string();
        Response build = proceed.newBuilder().body(string == null ? null : ResponseBody.INSTANCE.create(string, body.contentType())).build();
        if (string != null) {
            ResponseBody.INSTANCE.create(string, body.contentType());
        }
        if (!build.isSuccessful()) {
            ApiErrorResponse apiErrorResponse = string == null ? null : (ApiErrorResponse) KakaoJson.INSTANCE.fromJson(string, ApiErrorResponse.class);
            ApiErrorCause apiErrorCause = apiErrorResponse != null ? (ApiErrorCause) KakaoJson.INSTANCE.fromJson(String.valueOf(apiErrorResponse.getCode()), ApiErrorCause.class) : null;
            if (apiErrorCause != null && new ApiError(build.code(), apiErrorCause, apiErrorResponse).getReason() == ApiErrorCause.RequiredAgeVerification) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                UserApiClientKt.verifyAge(UserApiClient.INSTANCE.getInstance(), this.contextInfo.getApplicationContext(), (r18 & 2) != 0 ? null : null, (r18 & 4) != 0 ? null : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? false : null, new Function1<Throwable, Unit>() { // from class: com.kakao.sdk.partner.user.network.RequiredAgeVerificationInterceptor$intercept$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        objectRef.element = th;
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
                Throwable th = (Throwable) objectRef.element;
                if (th != null) {
                    throw new ExceptionWrapper(th);
                }
                return chain.proceed(build.request());
            }
        }
        return build;
    }
}
