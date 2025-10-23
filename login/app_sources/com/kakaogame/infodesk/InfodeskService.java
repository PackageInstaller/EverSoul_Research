package com.kakaogame.infodesk;

import android.content.Context;
import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.StringUtil;
import com.kakaogame.util.VersionUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfodeskService.kt */
@Metadata(m838d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J&\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\b2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007J(\u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u001b0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J \u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskService;", "", "()V", "TAG", "", "configuration", "Lcom/kakaogame/config/Configuration;", "createUploadUrl", "Lcom/kakaogame/KGResult;", "folderKey", "fileName", "getAppGroupParamMap", "", "context", "Landroid/content/Context;", "config", "getGameMaintenanceParamMap", "gameServerId", "getInfodeskParamMap", "handleGetInfodeskResult", "Lcom/kakaogame/infodesk/InfodeskData;", "result", "Lcom/kakaogame/server/KeyBaseResult;", "Lcom/kakaogame/util/json/JSONObject;", "initialize", "", "loadAppInfoList", "", "loadGameServerMaintenance", "loadInfodeskByHttp", "activity", "Landroid/app/Activity;", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InfodeskService {
    public static final InfodeskService INSTANCE = new InfodeskService();
    private static final String TAG = "InfodeskService";
    private static Configuration configuration;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InfodeskService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration config) {
        configuration = config;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[Catch: Exception -> 0x00fe, TryCatch #0 {Exception -> 0x00fe, blocks: (B:3:0x004e, B:5:0x0067, B:7:0x0074, B:13:0x0082, B:16:0x008b, B:18:0x00ab, B:19:0x00b1, B:21:0x00b9, B:23:0x00c6, B:26:0x00da, B:30:0x00ea), top: B:2:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[Catch: Exception -> 0x00fe, TryCatch #0 {Exception -> 0x00fe, blocks: (B:3:0x004e, B:5:0x0067, B:7:0x0074, B:13:0x0082, B:16:0x008b, B:18:0x00ab, B:19:0x00b1, B:21:0x00b9, B:23:0x00c6, B:26:0x00da, B:30:0x00ea), top: B:2:0x004e }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<com.kakaogame.infodesk.InfodeskData> loadInfodeskByHttp(android.app.Activity r11) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.infodesk.InfodeskService.loadInfodeskByHttp(android.app.Activity):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<List<JSONObject>> loadAppInfoList(Context context, Configuration config) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        try {
            KeyBaseResult<Object> requestGET = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), StringUtil.makeRequestUrl(config.getServerInfo().getInfodeskUrl() + Settings.INSTANCE.getHttpAppGroupUri(), INSTANCE.getAppGroupParamMap(context, config)), (Map<String, String>) null, HttpService.HttpContentType.STRING);
            if (requestGET.isSuccess()) {
                String str = (String) requestGET.getContent();
                if (TextUtils.isEmpty(str)) {
                    return KGResult.INSTANCE.getResult(2003, "response is null");
                }
                Object parse = JSONValue.parse(str);
                if (parse instanceof JSONObject) {
                    KeyBaseResult<JSONObject> result = ServerResponse.INSTANCE.getResult((JSONObject) parse);
                    if (!result.isSuccess()) {
                        return KGResult.INSTANCE.getResult(result);
                    }
                    JSONObject content = result.getContent();
                    if (content == null) {
                        return KGResult.INSTANCE.getResult(2003, "content is null");
                    }
                    JSONArray jSONArray = (JSONArray) content.get((Object) "apps");
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNull(jSONArray);
                    int size = jSONArray.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add((JSONObject) jSONArray.get(i));
                    }
                    return KGResult.INSTANCE.getSuccessResult(arrayList);
                }
                return KGResult.INSTANCE.getResult(2003, "response is not JSONObject");
            }
            return KGResult.INSTANCE.getResult(requestGET);
        } catch (Exception e) {
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:3:0x0036, B:5:0x004f, B:7:0x005a, B:13:0x0068, B:16:0x0071, B:18:0x0079, B:20:0x0087, B:22:0x0090, B:24:0x0098, B:26:0x00a1, B:28:0x00a8, B:31:0x00b1), top: B:2:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:3:0x0036, B:5:0x004f, B:7:0x005a, B:13:0x0068, B:16:0x0071, B:18:0x0079, B:20:0x0087, B:22:0x0090, B:24:0x0098, B:26:0x00a1, B:28:0x00a8, B:31:0x00b1), top: B:2:0x0036 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<com.kakaogame.util.json.JSONObject> loadGameServerMaintenance(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 1512979991(0x5a2e3e17, float:1.2261229E16)
            java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.kakaogame.config.Configuration r1 = com.kakaogame.infodesk.InfodeskService.configuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.kakaogame.server.ServerInfo r1 = r1.getServerInfo()
            java.lang.String r1 = r1.getInfodeskUrl()
            java.lang.StringBuilder r0 = r0.append(r1)
            com.kakaogame.infodesk.InfodeskService$Settings r1 = com.kakaogame.infodesk.InfodeskService.Settings.INSTANCE
            java.lang.String r1 = r1.getHttpGameMaintenanceUri()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.Map r4 = r3.getGameMaintenanceParamMap(r4, r5)
            java.lang.String r4 = com.kakaogame.util.StringUtil.makeRequestUrl(r0, r4)
            com.kakaogame.server.http.HttpService r5 = com.kakaogame.server.http.HttpService.INSTANCE     // Catch: java.lang.Exception -> Lba
            com.kakaogame.core.CoreManager$Companion r0 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> Lba
            com.kakaogame.core.CoreManager r0 = r0.getInstance()     // Catch: java.lang.Exception -> Lba
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> Lba
            com.kakaogame.server.http.HttpService$HttpContentType r1 = com.kakaogame.server.http.HttpService.HttpContentType.STRING     // Catch: java.lang.Exception -> Lba
            r2 = 0
            com.kakaogame.server.KeyBaseResult r4 = r5.requestGET(r0, r4, r2, r1)     // Catch: java.lang.Exception -> Lba
            boolean r5 = r4.isSuccess()     // Catch: java.lang.Exception -> Lba
            if (r5 == 0) goto Lb1
            java.lang.Object r4 = r4.getContent()     // Catch: java.lang.Exception -> Lba
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> Lba
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> Lba
            if (r5 == 0) goto L63
            int r5 = r5.length()     // Catch: java.lang.Exception -> Lba
            if (r5 != 0) goto L61
            goto L63
        L61:
            r5 = 0
            goto L64
        L63:
            r5 = 1
        L64:
            r0 = 2003(0x7d3, float:2.807E-42)
            if (r5 == 0) goto L71
            com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lba
            java.lang.String r5 = "response is null"
            com.kakaogame.KGResult r4 = r4.getResult(r0, r5)     // Catch: java.lang.Exception -> Lba
            return r4
        L71:
            java.lang.Object r4 = com.kakaogame.util.json.JSONValue.parse(r4)     // Catch: java.lang.Exception -> Lba
            boolean r5 = r4 instanceof com.kakaogame.util.json.JSONObject     // Catch: java.lang.Exception -> Lba
            if (r5 == 0) goto La8
            com.kakaogame.server.ServerResponse$Companion r5 = com.kakaogame.server.ServerResponse.INSTANCE     // Catch: java.lang.Exception -> Lba
            com.kakaogame.util.json.JSONObject r4 = (com.kakaogame.util.json.JSONObject) r4     // Catch: java.lang.Exception -> Lba
            com.kakaogame.server.KeyBaseResult r4 = r5.getResult(r4)     // Catch: java.lang.Exception -> Lba
            boolean r5 = r4.isSuccess()     // Catch: java.lang.Exception -> Lba
            if (r5 != 0) goto L90
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lba
            java.util.Map r4 = (java.util.Map) r4     // Catch: java.lang.Exception -> Lba
            com.kakaogame.KGResult r4 = r5.getResult(r4)     // Catch: java.lang.Exception -> Lba
            return r4
        L90:
            java.lang.Object r4 = r4.getContent()     // Catch: java.lang.Exception -> Lba
            com.kakaogame.util.json.JSONObject r4 = (com.kakaogame.util.json.JSONObject) r4     // Catch: java.lang.Exception -> Lba
            if (r4 != 0) goto La1
            com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lba
            java.lang.String r5 = "content is null"
            com.kakaogame.KGResult r4 = r4.getResult(r0, r5)     // Catch: java.lang.Exception -> Lba
            return r4
        La1:
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lba
            com.kakaogame.KGResult r4 = r5.getSuccessResult(r4)     // Catch: java.lang.Exception -> Lba
            goto Lc7
        La8:
            com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lba
            java.lang.String r5 = "response is not JSONObject"
            com.kakaogame.KGResult r4 = r4.getResult(r0, r5)     // Catch: java.lang.Exception -> Lba
            goto Lc7
        Lb1:
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lba
            java.util.Map r4 = (java.util.Map) r4     // Catch: java.lang.Exception -> Lba
            com.kakaogame.KGResult r4 = r5.getResult(r4)     // Catch: java.lang.Exception -> Lba
            goto Lc7
        Lba:
            r4 = move-exception
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE
            r0 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r4 = r4.toString()
            com.kakaogame.KGResult r4 = r5.getResult(r0, r4)
        Lc7:
            return r4
            fill-array 0x00c8: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.infodesk.InfodeskService.loadGameServerMaintenance(android.content.Context, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<InfodeskData> handleGetInfodeskResult(KeyBaseResult<JSONObject> result) {
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576559134), y.ݮڮֲڭܩ(-628463068) + result);
        if (result == null) {
            return KGResult.INSTANCE.getResult(2001);
        }
        if (result.isSuccess()) {
            JSONObject content = result.getContent();
            if (content == null) {
                return KGResult.INSTANCE.getResult(2003, y.ٲٴݴ״ٰ(1782267992));
            }
            return KGResult.INSTANCE.getSuccessResult(new InfodeskData(content));
        }
        return KGResult.INSTANCE.getResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> createUploadUrl(String folderKey, String fileName) {
        String str = y.٬ݯح׭٩(576559134);
        String str2 = y.ݮڮֲڭܩ(-628463388);
        Intrinsics.checkNotNullParameter(folderKey, y.٬ݯح׭٩(576559438));
        Intrinsics.checkNotNullParameter(fileName, y.ٴسسݬߨ(1393450378));
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getCreateUploadUri());
            serverRequest.putHeader("Content-Type", ServerConstants.CONTENT_TYPE_VALUE_JSON_UTF8);
            Configuration configuration2 = configuration;
            Intrinsics.checkNotNull(configuration2);
            serverRequest.putHeader("appId", configuration2.getAppId());
            Configuration configuration3 = configuration;
            Intrinsics.checkNotNull(configuration3);
            serverRequest.putBody("appSecret", configuration3.getAppSecret());
            serverRequest.putHeader("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("objectKey", folderKey + File.separator + fileName);
            ServerResult requestServerApi$default = OpenApiService.requestServerApi$default(serverRequest, 0, 2, null);
            Logger.INSTANCE.m706v(str, str2 + requestServerApi$default.getContent());
            if (!requestServerApi$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi$default);
            }
            JSONObject content = requestServerApi$default.getContent();
            Intrinsics.checkNotNull(content);
            return KGResult.INSTANCE.getSuccessResult((String) content.get((Object) "url"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, Object> getGameMaintenanceParamMap(Context context, String gameServerId) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Configuration configuration2 = configuration;
        Intrinsics.checkNotNull(configuration2);
        linkedHashMap.put(y.ۮڭڭܬި(862411867), configuration2.getAppId());
        Configuration configuration3 = configuration;
        Intrinsics.checkNotNull(configuration3);
        linkedHashMap.put(y.دײܮڳܯ(2051758173), configuration3.getMarket());
        linkedHashMap.put(y.٬ݯح׭٩(576655054), LocaleManager.INSTANCE.getSDKLanguageCode());
        linkedHashMap.put(y.دײܮڳܯ(2051393261), DeviceUtil.getDeviceId(context));
        String str = gameServerId;
        if (!(str == null || str.length() == 0)) {
            linkedHashMap.put(y.ۮڭڭܬި(862458155), gameServerId);
        }
        try {
            String whiteKey = DeviceUtil.getWhiteKey(context);
            if (!Intrinsics.areEqual(whiteKey, "")) {
                linkedHashMap.put(ServerConstants.WHITEKEY, whiteKey);
            }
        } catch (RuntimeException e) {
            Logger.INSTANCE.m699d(y.٬ݯح׭٩(576559134), y.٬ݯح׭٩(576651774) + e);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, Object> getInfodeskParamMap(Context context) {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Configuration configuration2 = configuration;
        Intrinsics.checkNotNull(configuration2);
        linkedHashMap.put(y.ۮڭڭܬި(862411867), configuration2.getAppId());
        Configuration configuration3 = configuration;
        Intrinsics.checkNotNull(configuration3);
        linkedHashMap.put(y.֬ڱܱײٮ(-1158899895), configuration3.getAppVersion());
        Configuration configuration4 = configuration;
        Intrinsics.checkNotNull(configuration4);
        linkedHashMap.put(y.دײܮڳܯ(2051758173), configuration4.getMarket());
        linkedHashMap.put(y.٬ݯح׭٩(576655134), SdkManager.INSTANCE.getSdkVersion());
        linkedHashMap.put(y.ݮڮֲڭܩ(-628723908), KGSystem.getOSName());
        linkedHashMap.put(y.٬ݯح׭٩(576655054), LocaleManager.INSTANCE.getSDKLanguageCode());
        linkedHashMap.put(y.دײܮڳܯ(2051393261), DeviceUtil.getDeviceId(context));
        linkedHashMap.put(y.٬ݯح׭٩(576651310), VersionUtil.getOSVersion());
        linkedHashMap.put(y.دײܮڳܯ(2051393733), KGSystem.getCountryCode());
        if (CoreManager.INSTANCE.getInstance().isGetFirstInfodesk()) {
            obj = y.֬ڱܱײٮ(-1158846575);
        } else {
            obj = CoreManager.INSTANCE.getInstance().isAuthorized() ? SdkState.AFTER_LOGIN : SdkState.BEFORE_LOGIN;
        }
        linkedHashMap.put(y.ٲٴݴ״ٰ(1782268208), obj);
        try {
            String whiteKey = DeviceUtil.getWhiteKey(context);
            if (!Intrinsics.areEqual(whiteKey, "")) {
                linkedHashMap.put(ServerConstants.WHITEKEY, whiteKey);
            }
        } catch (RuntimeException e) {
            Logger.INSTANCE.m699d(y.٬ݯح׭٩(576559134), y.٬ݯح׭٩(576651774) + e);
        }
        linkedHashMap.putAll(Settings.INSTANCE.getGetInfodeskParamMap());
        return linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, Object> getAppGroupParamMap(Context context, Configuration config) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ݮڮֲڭܩ(-628493652), config.getAppGroupId());
        linkedHashMap.put(y.֬ڱܱײٮ(-1158899895), config.getAppVersion());
        linkedHashMap.put(y.دײܮڳܯ(2051758173), config.getMarket());
        linkedHashMap.put(ServerConstants.SDK_VERSION, y.ݮڮֲڭܩ(-628603604));
        linkedHashMap.put("os", KGSystem.getOSName());
        linkedHashMap.put(y.٬ݯح׭٩(576655054), LocaleManager.INSTANCE.getSDKLanguageCode());
        linkedHashMap.put(ServerConstants.DEVICE_ID, DeviceUtil.getDeviceId(context));
        linkedHashMap.put(ServerConstants.OS_VERSION, VersionUtil.getOSVersion());
        linkedHashMap.put("country", KGSystem.getCountryCode());
        try {
            String whiteKey = DeviceUtil.getWhiteKey(context);
            if (!Intrinsics.areEqual(whiteKey, "")) {
                linkedHashMap.put(ServerConstants.WHITEKEY, whiteKey);
            }
        } catch (RuntimeException e) {
            Logger.INSTANCE.m699d(y.٬ݯح׭٩(576559134), y.٬ݯح׭٩(576651774) + e);
        }
        linkedHashMap.putAll(Settings.INSTANCE.getGetInfodeskParamMap());
        return linkedHashMap;
    }

    /* compiled from: InfodeskService.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskService$Settings;", "", "()V", "createUploadUri", "", "getCreateUploadUri", "()Ljava/lang/String;", "setCreateUploadUri", "(Ljava/lang/String;)V", "getInfodeskParamMap", "", "getGetInfodeskParamMap", "()Ljava/util/Map;", "getInfodeskUri", "getGetInfodeskUri", "setGetInfodeskUri", "httpAppGroupUri", "getHttpAppGroupUri", "setHttpAppGroupUri", "httpGameMaintenanceUri", "getHttpGameMaintenanceUri", "setHttpGameMaintenanceUri", "httpInfodeskUri", "getHttpInfodeskUri", "setHttpInfodeskUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        private static String createUploadUri;
        private static final Map<String, Object> getInfodeskParamMap;
        private static String httpAppGroupUri;
        private static String httpGameMaintenanceUri;
        private static String httpInfodeskUri;
        public static final Settings INSTANCE = new Settings();
        private static String getInfodeskUri = y.ٴسسݬߨ(1393442946);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            OpenApiService openApiService = OpenApiService.INSTANCE;
            String str = y.ٴسسݬߨ(1393443298);
            createUploadUri = openApiService.setOpenApiUri(str, str);
            httpInfodeskUri = y.ٴسسݬߨ(1393443530);
            httpAppGroupUri = y.ݮڮֲڭܩ(-628459892);
            httpGameMaintenanceUri = y.دײܮڳܯ(2051490109);
            getInfodeskParamMap = new LinkedHashMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInfodeskUri() {
            return getInfodeskUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInfodeskUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInfodeskUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCreateUploadUri() {
            return createUploadUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCreateUploadUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            createUploadUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getHttpInfodeskUri() {
            return httpInfodeskUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setHttpInfodeskUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            httpInfodeskUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getHttpAppGroupUri() {
            return httpAppGroupUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setHttpAppGroupUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            httpAppGroupUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getHttpGameMaintenanceUri() {
            return httpGameMaintenanceUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setHttpGameMaintenanceUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            httpGameMaintenanceUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> getGetInfodeskParamMap() {
            return getInfodeskParamMap;
        }
    }
}
