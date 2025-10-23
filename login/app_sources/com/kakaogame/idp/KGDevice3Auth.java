package com.kakaogame.idp;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGGuestProfile;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.HmacSHA256Util;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGDevice3Auth.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0003J*\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\tH\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\tH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/idp/KGDevice3Auth;", "Lcom/kakaogame/idp/IdpAuthHandler;", "Lcom/kakaogame/idp/IdpAuthExHandler;", "()V", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "checkAuth", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "", "getAccessToken", "", "idpLogin", "extras", "initialize", "Ljava/lang/Void;", FirebaseAnalytics.Event.LOGIN, "logout", "unregister", "Companion", "Settings", "idp_device_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGDevice3Auth implements IdpAuthHandler, IdpAuthExHandler {
    private static final String EXPIRY_TIME = "expiryTime";
    private static final String PREF_NAME = "KGDeviceID";
    private static final String TAG = "KGDevice3Auth";
    private static String accessToken = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> initialize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> idpLogin(Activity activity, String extras, int traceJobId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
        KGResult<IdpAccount> login = login(activity, extras, traceJobId);
        Tracer tracer = Tracer.INSTANCE;
        TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LOGIN;
        int code = login.getCode();
        String description = login.getDescription();
        if (description == null) {
            description = login.toString();
        }
        tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
        return login;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<IdpAccount> login(Activity activity, String extras, int traceJobId) {
        String str = y.دײܮڳܯ(2051393261);
        String str2 = y.֬ڱܱײٮ(-1158760631);
        String str3 = y.٬ݯح׭٩(576532326);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ٴسسݬߨ(1393486762);
        String str5 = y.ٲٴݴ״ٰ(1782315856);
        logger.m699d(str5, str4);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            linkedHashMap.put("appSecret", CoreManager.INSTANCE.getInstance().getConfiguration().getAppSecret());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ServerConstants.APP_VERSION, CoreManager.INSTANCE.getInstance().getConfiguration().getAppVersion());
            jSONObject.put(ServerConstants.SDK_VERSION, SdkManager.INSTANCE.getSdkVersion());
            jSONObject.put("os", KGSystem.getOSName());
            jSONObject.put("market", CoreManager.INSTANCE.getInstance().getConfiguration().getMarket());
            String deviceId = DeviceUtil.getDeviceId(activity);
            jSONObject.put(str, deviceId);
            jSONObject.put(ServerConstants.SERIAL_NUMBER, KGSystem.getOSName());
            jSONObject.put(ServerConstants.PRE_DEVICE_ID, DeviceUtil.getDeviceId(activity));
            jSONObject.put(ServerConstants.PRE_SERIAL_NUMBER, KGSystem.getOSName());
            if (!Intrinsics.areEqual(DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()), "")) {
                jSONObject.put(ServerConstants.ADID, DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()));
            }
            linkedHashMap.put(ServerConstants.DLS, HmacSHA256Util.getDLS(jSONObject.toJSONString()));
            KGResult<String> requestOpenApi = OpenApiService.INSTANCE.requestOpenApi(Settings.createUri, linkedHashMap, jSONObject, traceJobId);
            Logger.INSTANCE.m699d(str5, str3 + requestOpenApi);
            if (requestOpenApi.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(requestOpenApi);
            }
            String content = requestOpenApi.getContent();
            Logger.INSTANCE.m699d(str5, str2 + content);
            Object parse = JSONValue.parse(content);
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
            JSONObject jSONObject2 = (JSONObject) parse;
            accessToken = (String) jSONObject2.get((Object) "accessToken");
            Object obj = jSONObject2.get((Object) EXPIRY_TIME);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            long longValue = ((Long) obj).longValue();
            IdpAccount.Companion companion = IdpAccount.INSTANCE;
            String str6 = accessToken;
            Intrinsics.checkNotNull(str6);
            IdpAccount createDeviceAccount = companion.createDeviceAccount(deviceId, str6);
            createDeviceAccount.put(str, deviceId);
            createDeviceAccount.put(EXPIRY_TIME, Long.valueOf(longValue));
            return KGResult.INSTANCE.getSuccessResult(createDeviceAccount);
        } catch (Throwable th) {
            Logger.INSTANCE.m702e(str5, th.toString(), th);
            return KGResult.INSTANCE.getResult(4001, th.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public String getAccessToken(Activity activity) {
        return accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> checkAuth(Activity activity, IdpAccount authData, int traceJobId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158754847) + authData;
        String str2 = y.ٲٴݴ״ٰ(1782315856);
        logger.m699d(str2, str);
        try {
            return login(activity, null, traceJobId);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> logout() {
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> unregister() {
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public KGIdpProfile getLocalIdpProfile() {
        IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
        if (authData == null) {
            return null;
        }
        return new KGGuestProfile(MapsKt.mutableMapOf(TuplesKt.m846to(y.دײܮڳܯ(2051564517), y.ݮڮֲڭܩ(-628797068)), TuplesKt.m846to(y.ݮڮֲڭܩ(-628796020), authData.getIdpUserId()), TuplesKt.m846to(y.ٴسسݬߨ(1392599370), authData.getIdpAccessToken())));
    }

    /* compiled from: KGDevice3Auth.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/idp/KGDevice3Auth$Settings;", "", "()V", "createUri", "", "idp_device_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        public static final String createUri = "v4/device/accessToken/create";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }
    }
}
