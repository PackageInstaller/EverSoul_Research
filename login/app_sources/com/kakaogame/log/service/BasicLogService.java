package com.kakaogame.log.service;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.NetworkUtil;
import com.kakaogame.util.TelephonyUtil;
import com.kakaogame.util.VersionUtil;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BasicLogService.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0007JX\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007JB\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019H\u0007Jd\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019\u0018\u00010\u001bH\u0007J@\u0010\u0014\u001a\u00020\u00062\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\u001e\u0010\u001a\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019\u0018\u00010\u001bH\u0007J&\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002J&\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/log/service/BasicLogService;", "", "()V", "TAG", "", "fillLogBody", "", "context", "Landroid/content/Context;", "logBodyMap", "", "initialize", "writeBasicActionLog", "category", "action", Constants.ScionAnalytics.PARAM_LABEL, "valueStr", "actionAttr1", "actionAttr2", "actionAttr3", "writeBasicLog", "code", "tag1", "tag2", "logBody", "", "callback", "Lcom/kakaogame/KGResultCallback;", SDKConstants.PARAM_A2U_BODY, "writeBasicLogUsingOpenApi", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "writeBasicLogUsingSession", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class BasicLogService {
    public static final BasicLogService INSTANCE = new BasicLogService();
    private static final String TAG = "BasicLogService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BasicLogService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeBasicLog(Context context, String code, String tag1, String tag2, Map<String, ? extends Object> logBody) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(code, y.دײܮڳܯ(2051571757));
        writeBasicLog(context, code, tag1, tag2, logBody, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void writeBasicLog$default(Context context, String str, String str2, String str3, Map map, KGResultCallback kGResultCallback, int i, Object obj) {
        if ((i & 32) != 0) {
            kGResultCallback = null;
        }
        writeBasicLog(context, str, str2, str3, map, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeBasicLog(Context context, String code, String tag1, String tag2, Map<String, ? extends Object> logBody, KGResultCallback<Map<String, Object>> callback) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        String str = y.دײܮڳܯ(2051571757);
        Intrinsics.checkNotNullParameter(code, str);
        boolean containsKey = InfodeskHelper.INSTANCE.containsKey(y.ۮڭڭܬި(862699443));
        String str2 = y.ݮڮֲڭܩ(-628366932);
        if (containsKey) {
            Logger.INSTANCE.m699d(str2, "Infodesk appOption has 'stopSendBasicLog' key. Not send Basic log.");
            return;
        }
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1158706647)).append(code);
        String str3 = y.ݮڮֲڭܩ(-628756788);
        logger.m706v(str2, append.append(str3).append(tag1).append(str3).append(tag2).append(str3).append(logBody).toString());
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (logBody != null) {
                linkedHashMap.putAll(logBody);
            }
            INSTANCE.fillLogBody(context, linkedHashMap);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(str, code);
            if (tag1 != null) {
                linkedHashMap2.put("tag1", tag1);
            }
            if (tag2 != null) {
                linkedHashMap2.put("tag2", tag2);
            }
            linkedHashMap2.put("logBody", linkedHashMap);
            linkedHashMap2.put("ttl", -1616567296);
            writeBasicLog(linkedHashMap2, callback);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeBasicLog(Map<String, ? extends Object> body, KGResultCallback<Map<String, Object>> callback) {
        boolean containsKey = InfodeskHelper.INSTANCE.containsKey(y.ۮڭڭܬި(862699443));
        String str = y.ݮڮֲڭܩ(-628366932);
        if (containsKey) {
            Logger.INSTANCE.m699d(str, "Infodesk appOption has 'stopSendBasicLog' key. Not send Basic log.");
            return;
        }
        if (body == null || body.isEmpty() || !body.containsKey(y.دײܮڳܯ(2051571757))) {
            return;
        }
        try {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BasicLogService$writeBasicLog$1(body, callback, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeBasicLogUsingSession(Map<String, ? extends Object> body) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862697907) + body;
        String str2 = y.ݮڮֲڭܩ(-628366932);
        logger.m699d(str2, str);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteBasicLogUri());
            serverRequest.putAllBody(body);
            serverRequest.setIgnoreTimeout(true);
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeBasicLogUsingOpenApi(Map<String, ? extends Object> body) {
        KGResult<Void> successResult;
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512504327) + body;
        String str2 = y.ݮڮֲڭܩ(-628366932);
        logger.m706v(str2, str);
        try {
            KGResult requestOpenApi$default = OpenApiService.requestOpenApi$default(OpenApiService.INSTANCE, OpenApiService.INSTANCE.getOpenApiUri(Settings.INSTANCE.getWriteBasicLogUri()), (String) null, (Map) null, body, (HttpService.HttpContentType) null, 0, 54, (Object) null);
            if (!requestOpenApi$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestOpenApi$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeBasicActionLog(Context context, String category, String action, String label, String valueStr, String actionAttr1, String actionAttr2, String actionAttr3) {
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(576459126)).append(category);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(action).append(str).append(label).append(str).append(valueStr).append(str).append(actionAttr1).append(str).append(actionAttr2).append(str).append(actionAttr3).toString();
        String str2 = y.ݮڮֲڭܩ(-628366932);
        logger.m704i(str2, sb);
        if (context == null) {
            Logger.INSTANCE.m701e(str2, "context is null");
            return;
        }
        String str3 = category;
        if (str3 == null || str3.length() == 0) {
            Logger.INSTANCE.m701e(str2, "category is null");
            return;
        }
        String str4 = action;
        if (str4 == null || str4.length() == 0) {
            Logger.INSTANCE.m701e(str2, "action is null");
            return;
        }
        Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
        Intrinsics.checkNotNull(configuration);
        String appId = configuration.getAppId();
        String appSecret = configuration.getAppSecret();
        String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
        String str5 = playerId;
        if (str5 == null || str5.length() == 0) {
            playerId = AuthDataManager.INSTANCE.getLastPlayerId(context);
        }
        String str6 = playerId;
        if (str6 == null || str6.length() == 0) {
            Logger.INSTANCE.m701e(str2, "player id is null");
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str7 = y.ۮڭڭܬި(862411867);
        linkedHashMap.put(str7, appId);
        linkedHashMap.put(y.ۮڭڭܬި(862506555), appSecret);
        String str8 = y.ݬֲ֮ܲت(1512589743);
        linkedHashMap.put(str8, playerId);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(str7, appId);
        linkedHashMap2.put(str8, playerId);
        linkedHashMap2.put(y.ۮڭڭܬި(862689795), category);
        linkedHashMap2.put("action", action);
        if (label != null) {
            linkedHashMap2.put(Constants.ScionAnalytics.PARAM_LABEL, label);
        }
        if (valueStr != null) {
            linkedHashMap2.put("valueStr", valueStr);
        }
        if (actionAttr1 != null) {
            linkedHashMap2.put("actionAttr1", actionAttr1);
        }
        if (actionAttr2 != null) {
            linkedHashMap2.put("actionAttr2", actionAttr2);
        }
        if (actionAttr3 != null) {
            linkedHashMap2.put("actionAttr3", actionAttr3);
        }
        linkedHashMap2.put("os", KGSystem.getOSName());
        linkedHashMap2.put("modTime", Long.valueOf(System.currentTimeMillis()));
        Logger.INSTANCE.m704i(str2, "OpenApiService.requestOpenApi: " + OpenApiService.requestOpenApi(OpenApiService.INSTANCE.getOpenApiUri(Settings.INSTANCE.getWriteBasicActionLogUri()), linkedHashMap, linkedHashMap2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void fillLogBody(Context context, Map<String, Object> logBodyMap) {
        logBodyMap.put(y.دײܮڳܯ(2051393733), KGSystem.getCountryCode());
        logBodyMap.put(y.٬ݯح׭٩(576655054), KGSystem.getLanguageCode());
        logBodyMap.put(y.٬ݯح׭٩(576655198), TelephonyUtil.getNetworkOperatorName(context));
        logBodyMap.put(y.ٴسسݬߨ(1393345546), NetworkUtil.getNetworkType(context));
        logBodyMap.put(ServerConstants.DEVICE_MODEL, DeviceUtil.getDeviceModel());
        logBodyMap.put("os", KGSystem.getOSName());
        logBodyMap.put(ServerConstants.OS_VERSION, VersionUtil.getOSVersion());
        logBodyMap.put(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
        logBodyMap.put(y.٬ݯح׭٩(576655134), SdkManager.INSTANCE.getSdkVersion());
        logBodyMap.put(y.֬ڱܱײٮ(-1158899247), Long.valueOf(CoreManager.INSTANCE.getInstance().currentTimeMillis()));
        Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
        if (configuration != null) {
            logBodyMap.put(y.ۮڭڭܬި(862411867), configuration.getAppId());
            logBodyMap.put(y.֬ڱܱײٮ(-1158899895), configuration.getAppVersion());
            logBodyMap.put(y.دײܮڳܯ(2051758173), configuration.getMarket());
        }
        if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
            logBodyMap.put(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        }
    }

    /* compiled from: BasicLogService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/log/service/BasicLogService$Settings;", "", "()V", "writeBasicActionLogUri", "", "getWriteBasicActionLogUri", "()Ljava/lang/String;", "setWriteBasicActionLogUri", "(Ljava/lang/String;)V", "writeBasicLogUri", "getWriteBasicLogUri", "setWriteBasicLogUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String writeBasicLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576462246), y.ۮڭڭܬި(862696379));
        private static String writeBasicActionLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051463461), y.֬ڱܱײٮ(-1158706855));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteBasicLogUri() {
            return writeBasicLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteBasicLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeBasicLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteBasicActionLogUri() {
            return writeBasicActionLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteBasicActionLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeBasicActionLogUri = str;
        }
    }
}
