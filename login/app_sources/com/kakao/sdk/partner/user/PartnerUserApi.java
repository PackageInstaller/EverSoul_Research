package com.kakao.sdk.partner.user;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.kakao.sdk.partner.user.model.AgeAuthInfo;
import com.kakao.sdk.partner.user.model.AgeCriteria;
import com.kakao.sdk.partner.user.model.PartnerUser;
import com.kakao.sdk.user.model.ScopeInfo;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: PartnerUserApi.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nH'¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u000f\u001a\u00020\u0010H'J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\b2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\bH'¨\u0006\u0015"}, m839d2 = {"Lcom/kakao/sdk/partner/user/PartnerUserApi;", "", "ageAuthInfo", "Lretrofit2/Call;", "Lcom/kakao/sdk/partner/user/model/AgeAuthInfo;", "ageLimit", "", "propertyKeys", "", "ageCriteria", "Lcom/kakao/sdk/partner/user/model/AgeCriteria;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/kakao/sdk/partner/user/model/AgeCriteria;)Lretrofit2/Call;", TournamentShareDialogURIBuilder.me, "Lcom/kakao/sdk/partner/user/model/PartnerUser;", com.kakao.sdk.user.Constants.PROPERTIES, "secureResource", "", "upgradeScopes", "Lcom/kakao/sdk/user/model/ScopeInfo;", com.kakao.sdk.user.Constants.SCOPES, "guardianToken", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface PartnerUserApi {
    @GET(Constants.V2_AGE_AUTH_PATH)
    Call<AgeAuthInfo> ageAuthInfo(@Query("age_limit") Integer ageLimit, @Query("property_keys") String propertyKeys, @Query("age_criteria") AgeCriteria ageCriteria);

    @GET(com.kakao.sdk.user.Constants.V2_ME_PATH)
    /* renamed from: me */
    Call<PartnerUser> m692me(@Query("property_keys") String properties, @Query("secure_resource") boolean secureResource);

    @POST(Constants.V2_UPGRADE_SCOPES_PATH)
    Call<ScopeInfo> upgradeScopes(@Query("scopes") String scopes, @Query("guardian_token") String guardianToken);

    /* compiled from: PartnerUserApi.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call me$default(PartnerUserApi partnerUserApi, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: me");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return partnerUserApi.m692me(str, z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call ageAuthInfo$default(PartnerUserApi partnerUserApi, Integer num, String str, AgeCriteria ageCriteria, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ageAuthInfo");
            }
            if ((i & 1) != 0) {
                num = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                ageCriteria = null;
            }
            return partnerUserApi.ageAuthInfo(num, str, ageCriteria);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call upgradeScopes$default(PartnerUserApi partnerUserApi, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upgradeScopes");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return partnerUserApi.upgradeScopes(str, str2);
        }
    }
}
