package com.kakaogame.auth.agreement;

import com.kakao.sdk.user.Constants;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgreementService.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J$\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bH\u0007J&\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n2\u0016\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementService;", "", "()V", "KEY_AGREEMENT", "", "KEY_VERSION", "TAG", "VALUE_NO", "VALUE_YES", "getAgreements", "Lcom/kakaogame/KGResult;", "", "appId", "playerId", "getValueString", "value", "", "setAgreement", "Ljava/lang/Void;", "agreements", "setPrivateProperties", Constants.PROPERTIES, "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AgreementService {
    public static final AgreementService INSTANCE = new AgreementService();
    private static final String KEY_AGREEMENT = "agreement";
    public static final String KEY_VERSION = "version";
    private static final String TAG = "AgreementService";
    public static final String VALUE_NO = "n";
    public static final String VALUE_YES = "y";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getValueString(boolean value) {
        return value ? VALUE_YES : VALUE_NO;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AgreementService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> setPrivateProperties(Map<String, String> properties) {
        String str = y.٬ݯح׭٩(576715966);
        Intrinsics.checkNotNullParameter(properties, y.دײܮڳܯ(2051766413));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ۮڭڭܬި(862475067) + properties;
        String str3 = y.ݬֲ֮ܲت(1512379111);
        logger.m699d(str3, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSetPrivatePropertiesUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("agreement", properties);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            Logger.INSTANCE.m699d(str3, str + requestServer$default);
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> setAgreement(Map<String, String> agreements) {
        String str = y.٬ݯح׭٩(576715966);
        Intrinsics.checkNotNullParameter(agreements, y.٬ݯح׭٩(576716078));
        Logger logger = Logger.INSTANCE;
        String str2 = y.٬ݯح׭٩(575823054) + agreements;
        String str3 = y.ݬֲ֮ܲت(1512379111);
        logger.m699d(str3, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSetAgreementUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("agreement", agreements);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            Logger.INSTANCE.m699d(str3, str + requestServer$default);
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Map<String, String>> getAgreements(String appId, String playerId) {
        String str = y.ݬֲ֮ܲت(1512379111);
        String str2 = y.٬ݯح׭٩(576715966);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetAgreementUri());
            serverRequest.putBody("appId", appId);
            serverRequest.putBody("playerId", playerId);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            Logger.INSTANCE.m699d(str, str2 + requestServer$default);
            if (requestServer$default.isSuccess()) {
                JSONObject content = requestServer$default.getContent();
                if (content == null) {
                    return KGResult.INSTANCE.getResult(2003, requestServer$default.toString());
                }
                Map map = (Map) content.get((Object) "agreement");
                if (map == null) {
                    return KGResult.INSTANCE.getResult(2003, requestServer$default.toString());
                }
                if (((String) map.get("version")) == null) {
                    return KGResult.INSTANCE.getResult(2003, requestServer$default.toString());
                }
                return KGResult.INSTANCE.getSuccessResult(map);
            }
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: AgreementService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementService$Settings;", "", "()V", "API_DEPRECATED", "", "getAgreementUri", "getGetAgreementUri", "()Ljava/lang/String;", "setGetAgreementUri", "(Ljava/lang/String;)V", "setAgreementUri", "getSetAgreementUri", "setSetAgreementUri", "setPrivatePropertiesUri", "getSetPrivatePropertiesUri", "setSetPrivatePropertiesUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        private static final String API_DEPRECATED = "DEPRECATED";
        public static final Settings INSTANCE = new Settings();
        private static String setPrivatePropertiesUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862472715), y.دײܮڳܯ(2051358461));
        private static String setAgreementUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512380279), y.ݮڮֲڭܩ(-628618836));
        private static String getAgreementUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393311458), y.ٴسسݬߨ(1393311634));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSetPrivatePropertiesUri() {
            return setPrivatePropertiesUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSetPrivatePropertiesUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            setPrivatePropertiesUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSetAgreementUri() {
            return setAgreementUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSetAgreementUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            setAgreementUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetAgreementUri() {
            return getAgreementUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetAgreementUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getAgreementUri = str;
        }
    }
}
