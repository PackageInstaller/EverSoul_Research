package com.kakaogame.idp;

import android.app.Activity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoAuthType;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.log.ErrorLogManager;
import com.kakaogame.util.NetworkUtil;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: IdpAuthManager.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J2\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J \u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J2\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u0006\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d*\u0010\u0012\u0004\u0012\u0002H\u001c\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m839d2 = {"Lcom/kakaogame/idp/IdpAuthManager;", "", "()V", "TAG", "", "authHandlerMap", "", "Lcom/kakaogame/idp/IdpAuthHandler;", "checkAuth", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "", "getIdpAuthHadler", "idpCode", "getIdpClass", "className", "idpLogin", "extras", "initialize", "", "logout", "Ljava/lang/Void;", "unregister", "filterNotNullValues", "K", "V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class IdpAuthManager {
    private static final String TAG = "IdpAuthManager";
    public static final IdpAuthManager INSTANCE = new IdpAuthManager();
    private static Map<String, ? extends IdpAuthHandler> authHandlerMap = new LinkedHashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private IdpAuthManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Map mapOf = MapsKt.mapOf(TuplesKt.m846to(KGIdpProfile.KGIdpCode.Guest.getCode(), y.دײܮڳܯ(2051510573)), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Kakao.getCode(), y.ۮڭڭܬި(862618963)), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Facebook.getCode(), y.ݮڮֲڭܩ(-628434636)), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Google.getCode(), y.ٲٴݴ״ٰ(1782313312)), TuplesKt.m846to(KGIdpProfile.KGIdpCode.SigninWithApple.getCode(), y.ٲٴݴ״ٰ(1782313056)), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Twitter.getCode(), y.٬ݯح׭٩(576531542)), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Gamania.getCode(), y.֬ڱܱײٮ(-1158761391)));
        IdpAuthManager idpAuthManager = INSTANCE;
        ArrayList arrayList = new ArrayList(mapOf.size());
        for (Map.Entry entry : mapOf.entrySet()) {
            arrayList.add(TuplesKt.m846to(entry.getKey(), INSTANCE.getIdpClass((String) entry.getValue())));
        }
        Map filterNotNullValues = idpAuthManager.filterNotNullValues(MapsKt.toMap(arrayList));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry2 : filterNotNullValues.entrySet()) {
            if (((IdpAuthHandler) entry2.getValue()).initialize(activity).isSuccess()) {
                linkedHashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        authHandlerMap = linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final IdpAuthHandler getIdpClass(String className) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158755079) + className;
        String str2 = y.دײܮڳܯ(2051511093);
        logger.m699d(str2, str);
        try {
            Class<?> cls = Class.forName(className);
            if (cls == null) {
                return null;
            }
            Object newInstance = cls.newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.kakaogame.idp.IdpAuthHandler");
            return (IdpAuthHandler) newInstance;
        } catch (Throwable unused) {
            Logger.INSTANCE.m708w(str2, y.٬ݯح׭٩(576542222) + className);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<IdpAccount> idpLogin(Activity activity, String idpCode, String extras, int traceJobId) {
        KGResult<IdpAccount> successResult;
        String str = y.ۮڭڭܬި(862511891);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٲٴݴ״ٰ(1782287848) + idpCode;
        String str3 = y.دײܮڳܯ(2051511093);
        logger.m699d(str3, str2);
        try {
            if (NetworkUtil.INSTANCE.isNotNetworkConnected(activity)) {
                return KGResult.INSTANCE.getResult(1001);
            }
            IdpAuthHandler idpAuthHandler = authHandlerMap.get(idpCode);
            if (idpAuthHandler != null) {
                KGResult<IdpAccount> idpLogin = idpAuthHandler.idpLogin(activity, extras, traceJobId);
                if (idpLogin.getCode() == 300000) {
                    BuildersKt__BuildersKt.runBlocking$default(null, new IdpAuthManager$idpLogin$1$1(null), 1, null);
                    successResult = idpAuthHandler.idpLogin(activity, KGKakaoAuthType.KakaoWeb.getAuthType(), traceJobId);
                    Logger.INSTANCE.m699d(str3, str + successResult);
                } else if (idpLogin.isNotSuccess()) {
                    ErrorLogManager.sendIdpLoginError(idpLogin.getCode(), null, null, null, null);
                    successResult = KGResult.INSTANCE.getResult(idpLogin);
                } else {
                    successResult = KGResult.INSTANCE.getSuccessResult(idpLogin.getContent());
                }
                if (successResult != null) {
                    return successResult;
                }
            }
            return KGResult.INSTANCE.getResult(3001, idpCode + " is not defined in IDPAuthManager");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult checkAuth$default(Activity activity, IdpAccount idpAccount, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        return checkAuth(activity, idpAccount, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<IdpAccount> checkAuth(Activity activity, IdpAccount authData, int traceJobId) {
        KGResult<IdpAccount> result;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(authData, y.֬ڱܱײٮ(-1158754895));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158754847) + authData;
        String str2 = y.دײܮڳܯ(2051511093);
        logger.m699d(str2, str);
        try {
            if (NetworkUtil.INSTANCE.isNotNetworkConnected(activity)) {
                return KGResult.INSTANCE.getResult(1001);
            }
            IdpAuthHandler idpAuthHandler = authHandlerMap.get(authData.getIdpCode());
            if (idpAuthHandler == null || (result = idpAuthHandler.checkAuth(activity, authData, traceJobId)) == null) {
                result = KGResult.INSTANCE.getResult(3001, authData.getIdpCode() + " handler is not registered");
            }
            if (!result.isNotSuccess() || result.getCode() == 3001 || result.getCode() == 200000) {
                return result;
            }
            ErrorLogManager.sendIdpCheckAuthError(result.getCode(), result, AuthDataManager.getLoginData(), authData, null, null);
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> logout(Activity activity, IdpAccount authData) {
        KGResult<Void> logout;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(authData, y.֬ڱܱײٮ(-1158754895));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782160784) + authData;
        String str2 = y.دײܮڳܯ(2051511093);
        logger.m699d(str2, str);
        try {
            if (NetworkUtil.INSTANCE.isNotNetworkConnected(activity)) {
                return KGResult.INSTANCE.getResult(1001);
            }
            IdpAuthHandler idpAuthHandler = authHandlerMap.get(authData.getIdpCode());
            return (idpAuthHandler == null || (logout = idpAuthHandler.logout()) == null) ? KGResult.INSTANCE.getResult(3001, authData.getIdpCode() + " handler is not registered") : logout;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> unregister(Activity activity, IdpAccount authData) {
        KGResult<Void> unregister;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(authData, y.֬ڱܱײٮ(-1158754895));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393335666) + authData;
        String str2 = y.دײܮڳܯ(2051511093);
        logger.m699d(str2, str);
        try {
            if (NetworkUtil.INSTANCE.isNotNetworkConnected(activity)) {
                return KGResult.INSTANCE.getResult(1001);
            }
            IdpAuthHandler idpAuthHandler = authHandlerMap.get(authData.getIdpCode());
            return (idpAuthHandler == null || (unregister = idpAuthHandler.unregister()) == null) ? KGResult.INSTANCE.getSuccessResult() : unregister;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAuthHandler getIdpAuthHadler(String idpCode) {
        return authHandlerMap.get(idpCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final <K, V> Map<K, V> filterNotNullValues(Map<K, ? extends V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
