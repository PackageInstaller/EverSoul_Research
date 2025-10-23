package com.kakao.sdk.partner.auth;

import com.kakao.sdk.auth.model.AccessTokenResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: PartnerAuthApi.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\n\u001a\u00020\u0006H'¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/partner/auth/PartnerAuthApi;", "", "issueAccessToken", "Lretrofit2/Call;", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "groupRefreshToken", "", "clientId", "androidKeyHash", "approvalType", "grantType", "partner-auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface PartnerAuthApi {
    @FormUrlEncoded
    @POST(com.kakao.sdk.auth.Constants.TOKEN_PATH)
    Call<AccessTokenResponse> issueAccessToken(@Field("group_refresh_token") String groupRefreshToken, @Field("client_id") String clientId, @Field("android_key_hash") String androidKeyHash, @Field("approval_type") String approvalType, @Field("grant_type") String grantType);

    /* compiled from: PartnerAuthApi.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call issueAccessToken$default(PartnerAuthApi partnerAuthApi, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: issueAccessToken");
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            String str6 = str4;
            if ((i & 16) != 0) {
                str5 = Constants.GROUP_REFRESH_TOKEN;
            }
            return partnerAuthApi.issueAccessToken(str, str2, str3, str6, str5);
        }
    }
}
