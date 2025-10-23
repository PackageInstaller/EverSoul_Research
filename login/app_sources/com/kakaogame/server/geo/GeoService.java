package com.kakaogame.server.geo;

import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.ErrorLogManager;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: GeoService.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H\u0007J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/server/geo/GeoService;", "", "()V", "TAG", "", "requestCountry", "Lcom/kakaogame/KGResult;", "requestGeoCountry", "config", "Lcom/kakaogame/config/Configuration;", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GeoService {
    public static final GeoService INSTANCE = new GeoService();
    private static final String TAG = "GeoService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GeoService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> requestGeoCountry(Configuration config) {
        String str = y.ٲٴݴ״ٰ(1781559176);
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        String str2 = config.getServerInfo().getOpenApiUrl() + Settings.INSTANCE.getGetGeoIpCountryUri();
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String appId = config.getAppId();
            if (StringsKt.contains$default((CharSequence) appId, (CharSequence) str, false, 2, (Object) null)) {
                appId = ((String[]) new Regex(str).split(appId, 0).toArray(new String[0]))[0];
            }
            String appSecret = config.getAppSecret();
            if (StringsKt.contains$default((CharSequence) appSecret, (CharSequence) str, false, 2, (Object) null)) {
                appSecret = ((String[]) new Regex(str).split(appSecret, 0).toArray(new String[0]))[0];
            }
            linkedHashMap.put("appId", appId);
            linkedHashMap.put("appSecret", appSecret);
            linkedHashMap.put("Content-Type", ServerConstants.CONTENT_TYPE_VALUE_JSON_UTF8);
            linkedHashMap.put(ServerConstants.REQUESTED_BY, "android");
            KeyBaseResult<Object> requestPOST = HttpService.requestPOST(str2, linkedHashMap, null, HttpService.HttpContentType.STRING);
            if (requestPOST.isSuccess()) {
                String str3 = (String) requestPOST.getContent();
                if (TextUtils.isEmpty(str3)) {
                    return KGResult.INSTANCE.getResult(2003, "response is null");
                }
                Object parse = JSONValue.parse(str3);
                if (parse instanceof JSONObject) {
                    return KGResult.INSTANCE.getSuccessResult((String) ((JSONObject) parse).get((Object) "country"));
                }
                ErrorLogManager.INSTANCE.sendInfodeskError(2003, str2, str3, null, "response is not JSONObject");
                return KGResult.INSTANCE.getResult(2003, "response is not JSONObject");
            }
            return KGResult.INSTANCE.getResult(requestPOST);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576336854), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> requestCountry() {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetGeoIpCountryUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            ServerResult requestServerApi$default = OpenApiService.requestServerApi$default(serverRequest, 0, 2, null);
            if (!requestServerApi$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi$default);
            }
            JSONObject content = requestServerApi$default.getContent();
            Intrinsics.checkNotNull(content);
            return KGResult.INSTANCE.getSuccessResult((String) content.get((Object) "country"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576336854), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: GeoService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/server/geo/GeoService$Settings;", "", "()V", "getGeoIpCountryUri", "", "getGetGeoIpCountryUri", "()Ljava/lang/String;", "setGetGeoIpCountryUri", "(Ljava/lang/String;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getGeoIpCountryUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1159091343), y.ٲٴݴ״ٰ(1782376488));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetGeoIpCountryUri() {
            return getGeoIpCountryUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetGeoIpCountryUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getGeoIpCountryUri = str;
        }
    }
}
