package com.kakao.sdk.user;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.kakao.sdk.common.json.IntDate;
import com.kakao.sdk.user.model.AccessTokenInfo;
import com.kakao.sdk.user.model.ScopeInfo;
import com.kakao.sdk.user.model.User;
import com.kakao.sdk.user.model.UserRevokedServiceTerms;
import com.kakao.sdk.user.model.UserServiceTerms;
import com.kakao.sdk.user.model.UserShippingAddresses;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: UserApi.kt */
@Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\fH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\fH'J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\fH'J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\fH'J7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u001dH'¢\u0006\u0002\u0010\u001eJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0016\b\u0003\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010 H'J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 H'¨\u0006#"}, m839d2 = {"Lcom/kakao/sdk/user/UserApi;", "", "accessTokenInfo", "Lretrofit2/Call;", "Lcom/kakao/sdk/user/model/AccessTokenInfo;", "logout", "", TournamentShareDialogURIBuilder.me, "Lcom/kakao/sdk/user/model/User;", "secureResource", "", Constants.PROPERTIES, "", "revokeScopes", "Lcom/kakao/sdk/user/model/ScopeInfo;", Constants.SCOPES, "revokeServiceTerms", "Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", Constants.TAGS, "serviceTerms", "Lcom/kakao/sdk/user/model/UserServiceTerms;", "result", "shippingAddresses", "Lcom/kakao/sdk/user/model/UserShippingAddresses;", "addressId", "", "fromUpdatedAt", "Ljava/util/Date;", "pageSize", "", "(Ljava/lang/Long;Ljava/util/Date;Ljava/lang/Integer;)Lretrofit2/Call;", "signup", "", "unlink", "updateProfile", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface UserApi {
    @GET(Constants.V1_ACCESS_TOKEN_INFO_PATH)
    Call<AccessTokenInfo> accessTokenInfo();

    @POST(Constants.V1_LOGOUT_PATH)
    Call<Unit> logout();

    @GET(Constants.V2_ME_PATH)
    /* renamed from: me */
    Call<User> m693me(@Query("secure_resource") boolean secureResource, @Query("property_keys") String properties);

    @FormUrlEncoded
    @POST(Constants.V2_REVOKE_SCOPE)
    Call<ScopeInfo> revokeScopes(@Field("scopes") String scopes);

    @FormUrlEncoded
    @POST(Constants.V2_REVOKE_SERVICE_TERMS_PATH)
    Call<UserRevokedServiceTerms> revokeServiceTerms(@Field("tags") String tags);

    @GET(Constants.V2_SCOPES)
    Call<ScopeInfo> scopes(@Query("scopes") String scopes);

    @GET(Constants.V2_SERVICE_TERMS_PATH)
    Call<UserServiceTerms> serviceTerms(@Query("tags") String tags, @Query("result") String result);

    @GET(Constants.V1_SHIPPING_ADDRESSES_PATH)
    Call<UserShippingAddresses> shippingAddresses(@Query("address_id") Long addressId, @IntDate @Query("from_updated_at") Date fromUpdatedAt, @Query("page_size") Integer pageSize);

    @FormUrlEncoded
    @POST(Constants.V1_SIGNUP_PATH)
    Call<Unit> signup(@Field("properties") Map<String, String> properties);

    @POST(Constants.V1_UNLINK_PATH)
    Call<Unit> unlink();

    @FormUrlEncoded
    @POST(Constants.V1_UPDATE_PROFILE_PATH)
    Call<Unit> updateProfile(@Field("properties") Map<String, String> properties);

    /* compiled from: UserApi.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call me$default(UserApi userApi, boolean z, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: me");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return userApi.m693me(z, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call signup$default(UserApi userApi, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signup");
            }
            if ((i & 1) != 0) {
                map = null;
            }
            return userApi.signup(map);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call shippingAddresses$default(UserApi userApi, Long l, Date date, Integer num, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shippingAddresses");
            }
            if ((i & 1) != 0) {
                l = null;
            }
            if ((i & 2) != 0) {
                date = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            return userApi.shippingAddresses(l, date, num);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call scopes$default(UserApi userApi, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scopes");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return userApi.scopes(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call serviceTerms$default(UserApi userApi, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: serviceTerms");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return userApi.serviceTerms(str, str2);
        }
    }
}
