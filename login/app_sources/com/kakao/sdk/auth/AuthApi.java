package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.AccessTokenResponse;
import com.kakao.sdk.auth.model.AgtResponse;
import com.kakao.sdk.auth.model.PrepareResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: AuthApi.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'JX\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u000f\u001a\u00020\u0006H'JF\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u0006H'JB\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u000f\u001a\u00020\u0006H'¨\u0006\u0017"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthApi;", "", Constants.AGT, "Lretrofit2/Call;", "Lcom/kakao/sdk/auth/model/AgtResponse;", "clientId", "", "accessToken", "issueAccessToken", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "androidKeyHash", "code", "redirectUri", "codeVerifier", "approvalType", "grantType", "prepare", "Lcom/kakao/sdk/auth/model/PrepareResponse;", "settleId", "signData", "txId", "certType", "refreshToken", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface AuthApi {
    @FormUrlEncoded
    @POST(Constants.AGT_PATH)
    Call<AgtResponse> agt(@Field("client_id") String clientId, @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST(Constants.TOKEN_PATH)
    Call<AccessTokenResponse> issueAccessToken(@Field("client_id") String clientId, @Field("android_key_hash") String androidKeyHash, @Field("code") String code, @Field("redirect_uri") String redirectUri, @Field("code_verifier") String codeVerifier, @Field("approval_type") String approvalType, @Field("grant_type") String grantType);

    @FormUrlEncoded
    @POST(Constants.PREPARE_PATH)
    Call<PrepareResponse> prepare(@Field("client_id") String clientId, @Field("settle_id") String settleId, @Field("sign_data") String signData, @Field("tx_id") String txId, @Field("cert_type") String certType);

    @FormUrlEncoded
    @POST(Constants.TOKEN_PATH)
    Call<AccessTokenResponse> refreshToken(@Field("client_id") String clientId, @Field("android_key_hash") String androidKeyHash, @Field("refresh_token") String refreshToken, @Field("approval_type") String approvalType, @Field("grant_type") String grantType);

    /* compiled from: AuthApi.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call issueAccessToken$default(AuthApi authApi, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if (obj == null) {
                return authApi.issueAccessToken(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? Constants.AUTHORIZATION_CODE : str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: issueAccessToken");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call refreshToken$default(AuthApi authApi, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshToken");
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            String str6 = str4;
            if ((i & 16) != 0) {
                str5 = Constants.REFRESH_TOKEN;
            }
            return authApi.refreshToken(str, str2, str3, str6, str5);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call prepare$default(AuthApi authApi, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if (obj == null) {
                return authApi.prepare(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepare");
        }
    }
}
