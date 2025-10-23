package com.kakaogame.player.profile;

import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppProfileService.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b0\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/player/profile/AppProfileService;", "", "()V", "TAG", "", "appId", "getAppInfo", "Lcom/kakaogame/KGResult;", "", "fieldList", "", "initialize", "", "configuration", "Lcom/kakaogame/config/Configuration;", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AppProfileService {
    public static final AppProfileService INSTANCE = new AppProfileService();
    private static final String TAG = "AppProfileService";
    private static String appId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AppProfileService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1393326218));
        appId = configuration.getAppId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Map<String, Object>> getAppInfo(List<String> fieldList) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393521266) + fieldList;
        String str2 = y.ٴسسݬߨ(1393521346);
        logger.m699d(str2, str);
        if (fieldList != null) {
            try {
                if (!fieldList.isEmpty()) {
                    ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetAppInfoUri());
                    serverRequest.putBody("appId", appId);
                    serverRequest.putBody("fields", fieldList);
                    ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
                    if (requestServer$default.isSuccess()) {
                        JSONObject content = requestServer$default.getContent();
                        Intrinsics.checkNotNull(content);
                        JSONObject jSONObject = (JSONObject) content.get((Object) "appInfo");
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (String str3 : fieldList) {
                            Intrinsics.checkNotNull(jSONObject);
                            linkedHashMap.put(str3, jSONObject.get((Object) str3));
                        }
                        return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                    }
                    return KGResult.INSTANCE.getResult(requestServer$default);
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }
        return KGResult.INSTANCE.getResult(4000);
    }

    /* compiled from: AppProfileService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/player/profile/AppProfileService$Settings;", "", "()V", "getAppInfoUri", "", "getGetAppInfoUri", "()Ljava/lang/String;", "setGetAppInfoUri", "(Ljava/lang/String;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getAppInfoUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862656971), y.ٴسسݬߨ(1393521138));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetAppInfoUri() {
            return getAppInfoUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetAppInfoUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getAppInfoUri = str;
        }
    }
}
