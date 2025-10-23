package com.kakao.sdk.talk;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: AppKeyTalkApi.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H'¨\u0006\b"}, m839d2 = {"Lcom/kakao/sdk/talk/AppKeyTalkApi;", "", "validate", "Lretrofit2/Call;", "", com.kakao.sdk.user.Constants.PROPERTIES, "", "", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface AppKeyTalkApi {
    @FormUrlEncoded
    @POST(Constants.V1_CHANNEL_VALIDATE_PATH)
    Call<Unit> validate(@Field("quota_properties") Map<String, String> properties);
}
