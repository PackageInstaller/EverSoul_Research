package com.kakaogame.broker;

import android.app.Activity;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.KGAgreement;
import com.kakaogame.KGApplication;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoAuthType;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGMarketRefundInfo;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.KGSession;
import com.kakaogame.KGSessionForCustomUI;
import com.kakaogame.KGSystem;
import com.kakaogame.KGTracer;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.auth.LoginData;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.infodesk.InfodeskNoticeManager;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.p029ui.PermissionManager;
import com.kakaogame.promotion.StartingPromotionManager;
import com.kakaogame.push.PushService;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.session.SessionUtil;
import com.kakaogame.util.Base64Util;
import com.kakaogame.util.DateUtil;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.FileUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: InterfaceBrokerManager.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001d\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J&\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00062\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0006H\u0007J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0006H\u0007J\b\u0010'\u001a\u00020\u0010H\u0007J\b\u0010(\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m839d2 = {"Lcom/kakaogame/broker/InterfaceBrokerManager;", "", "()V", "MAX_RESPONSE_SIZE", "", "TAG", "", "requestIdGenerator", "Ljava/util/Random;", "useBase64Response", "", "getResponseFilePath", "activity", "Landroid/app/Activity;", "responseString", "handleRequestInternal", "", "requestString", "initAgreementAPI", "initApplicationAPIs", "initInternalAPIs", "initNotis", "initSessionAPIs", "initSessionForCustomUIAPIs", "initSystemAPIs", "initialize", "requestAsync", "requestSync", "requestToUnity", "requestToUnreal", "sendMessage", "requestUri", "content", "", "sendResponse", "setEngine", "showCustomAlertViewOnUnity", "requestBody", "showCustomAlertViewOnUnreal", "takeScreenShotOnUnity", "takeScreenShotOnUnreal", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InterfaceBrokerManager {
    public static final InterfaceBrokerManager INSTANCE;
    private static final int MAX_RESPONSE_SIZE = 300000;
    private static final String TAG = "InterfaceBrokerManager";
    private static final Random requestIdGenerator;
    private static final boolean useBase64Response = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InterfaceBrokerManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        InterfaceBrokerManager interfaceBrokerManager = new InterfaceBrokerManager();
        INSTANCE = interfaceBrokerManager;
        requestIdGenerator = new Random(System.currentTimeMillis());
        interfaceBrokerManager.initialize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initialize() {
        setEngine();
        initInternalAPIs();
        initSessionAPIs();
        initSessionForCustomUIAPIs();
        initApplicationAPIs();
        initSystemAPIs();
        initNotis();
        initAgreementAPI();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setEngine() {
        CoreManager.INSTANCE.getInstance().setEngine();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String requestSync(Activity activity, String requestString) {
        String str = y.ݮڮֲڭܩ(-628604452);
        String str2 = y.ۮڭڭܬި(862581971);
        String str3 = y.٬ݯح׭٩(576608774);
        String str4 = y.֬ڱܱײٮ(-1158823031);
        Intrinsics.checkNotNullParameter(requestString, y.دײܮڳܯ(2051317533));
        try {
            Logger.INSTANCE.m706v(str, str4 + requestString);
            ServerResponse response = ServerResponse.INSTANCE.getResponse(requestString);
            String requestUri = response.getRequestUri();
            int transactionNo = response.getTransactionNo();
            JSONObject body = response.getBody();
            JSONArray jSONArray = new JSONArray();
            jSONArray.add(requestUri);
            jSONArray.add(body);
            Logger.INSTANCE.m706v(str, str3 + jSONArray.toJSONString());
            KGResult<?> request = InterfaceBrokerHandler.INSTANCE.request(activity, jSONArray.toJSONString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SessionUtil.TRANSACTION_NO, Integer.valueOf(transactionNo));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", Integer.valueOf(request.getCode()));
            jSONObject2.put("desc", request.getDescription());
            if (request.getContent() != null && (request.getContent() instanceof Map)) {
                jSONObject2.put("content", request.getContent());
            }
            jSONObject2.put("message", request.getMessage());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.add(requestUri);
            jSONArray2.add(jSONObject);
            jSONArray2.add(jSONObject2);
            String jSONString = jSONArray2.toJSONString();
            Logger.INSTANCE.m706v(str, str2 + jSONString);
            return Base64Util.getBase64encode(jSONString);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.add(4001);
            jSONArray3.add(e.toString());
            jSONArray3.add(new JSONObject());
            return jSONArray3.toJSONString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestAsync(Activity activity, String requestString) {
        String str = y.ݮڮֲڭܩ(-628604452);
        String str2 = y.֬ڱܱײٮ(-1158823471);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(requestString, y.دײܮڳܯ(2051317533));
        try {
            Logger.INSTANCE.m706v(str, str2 + requestString);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InterfaceBrokerManager$requestAsync$1(activity, requestString, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendMessage(String requestUri, Map<String, ? extends Object> content) {
        Intrinsics.checkNotNullParameter(requestUri, y.دײܮڳܯ(2051368157));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SessionUtil.TRANSACTION_NO, Integer.valueOf(requestIdGenerator.nextInt()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", 200);
            jSONObject2.put("desc", "");
            if (content != null) {
                jSONObject2.put("content", content);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.add(requestUri);
            jSONArray.add(jSONObject);
            jSONArray.add(jSONObject2);
            sendResponse(CoreManager.INSTANCE.getInstance().getActivity(), jSONArray.toJSONString());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628604452), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getResponseFilePath(Activity activity, String responseString) {
        try {
            return FileUtil.writeTmpFile(activity, "KGTransData", DateUtil.convertLongToFormattedString(CoreManager.INSTANCE.getInstance().currentTimeMillis()) + ".tmp", Base64Util.getBase64encode(responseString));
        } catch (Exception e) {
            Log.e(y.ݮڮֲڭܩ(-628604452), e.toString(), e);
            return "ERROR OCCURRED";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendResponse(Activity activity, String responseString) {
        Object invoke;
        Object invoke2;
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862582299) + responseString;
        String str2 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str2, str);
        boolean isUnity = CoreManager.INSTANCE.getInstance().isUnity();
        String str3 = y.دײܮڳܯ(2051317213);
        String str4 = y.ٴسسݬߨ(1393399922);
        String str5 = y.٬ݯح׭٩(576609422);
        String str6 = y.دײܮڳܯ(2051316573);
        String str7 = y.ۮڭڭܬި(862580819);
        String str8 = y.دײܮڳܯ(2051316637);
        String str9 = y.ۮڭڭܬި(862415259);
        if (isUnity) {
            try {
                Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
                Logger.INSTANCE.m706v(str2, str9 + cls);
                Method method = cls.getMethod("UnitySendMessage", String.class, String.class, String.class);
                Logger.INSTANCE.m706v(str2, str8 + method);
                Logger.INSTANCE.m706v(str2, str7 + responseString.length());
                if (responseString.length() > 300000) {
                    invoke = method.invoke(null, str5, str3, getResponseFilePath(activity, responseString));
                } else {
                    invoke = method.invoke(null, str5, str4, Base64Util.getBase64encode(responseString));
                }
                Logger.INSTANCE.m706v(str2, str6 + invoke);
                return;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                return;
            }
        }
        if (CoreManager.INSTANCE.getInstance().isUnreal()) {
            try {
                Class<?> cls2 = Class.forName("com.kakaogames.sdk.unreal.MessageSender");
                Logger.INSTANCE.m706v(str2, str9 + cls2);
                Method method2 = cls2.getMethod("UnrealSendMessage", String.class, String.class, String.class);
                Logger.INSTANCE.m706v(str2, str8 + method2);
                Logger.INSTANCE.m706v(str2, str7 + responseString.length());
                if (responseString.length() > 300000) {
                    invoke2 = method2.invoke(null, str5, str3, getResponseFilePath(activity, responseString));
                } else {
                    invoke2 = method2.invoke(null, str5, str4, Base64Util.getBase64encode(responseString));
                }
                Logger.INSTANCE.m706v(str2, str6 + invoke2);
            } catch (Exception e2) {
                Logger.INSTANCE.m702e(str2, e2.toString(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void handleRequestInternal(Activity activity, String requestString) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628588884) + requestString;
        String str2 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str2, str);
        try {
            ServerResponse response = ServerResponse.INSTANCE.getResponse(requestString);
            String requestUri = response.getRequestUri();
            int transactionNo = response.getTransactionNo();
            JSONObject body = response.getBody();
            JSONArray jSONArray = new JSONArray();
            jSONArray.add(requestUri);
            jSONArray.add(body);
            KGResult<?> request = InterfaceBrokerHandler.INSTANCE.request(activity, jSONArray.toJSONString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SessionUtil.TRANSACTION_NO, Integer.valueOf(transactionNo));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", Integer.valueOf(request.getCode()));
            jSONObject2.put("desc", request.getDescription());
            if (request.getContent() != null && (request.getContent() instanceof Map)) {
                jSONObject2.put("content", request.getContent());
            }
            jSONObject2.put("message", request.getMessage());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.add(requestUri);
            jSONArray2.add(jSONObject);
            jSONArray2.add(jSONObject2);
            sendResponse(activity, jSONArray2.toJSONString());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void requestToUnity(String requestString) {
        String str = y.دײܮڳܯ(2051316573);
        String str2 = y.دײܮڳܯ(2051316637);
        String str3 = y.ۮڭڭܬި(862415259);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ٴسسݬߨ(1393399386);
        String str5 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str5, str4);
        try {
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            Logger.INSTANCE.m706v(str5, str3 + cls);
            Method method = cls.getMethod("UnitySendMessage", String.class, String.class, String.class);
            Logger.INSTANCE.m706v(str5, str2 + method);
            Intrinsics.checkNotNull(requestString);
            Object invoke = method.invoke(null, "KakaoGameSDK", "RequestToUnity", Base64Util.getBase64encode(requestString));
            Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
            Logger.INSTANCE.m706v(str5, str + invoke);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void requestToUnreal(String requestString) {
        String str = y.دײܮڳܯ(2051316573);
        String str2 = y.دײܮڳܯ(2051316637);
        String str3 = y.ۮڭڭܬި(862415259);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ݮڮֲڭܩ(-628514092);
        String str5 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str5, str4);
        try {
            Class<?> cls = Class.forName("com.kakaogames.sdk.unreal.MessageSender");
            Logger.INSTANCE.m706v(str5, str3 + cls);
            Method method = cls.getMethod("UnrealSendMessage", String.class, String.class, String.class);
            Logger.INSTANCE.m706v(str5, str2 + method);
            Intrinsics.checkNotNull(requestString);
            Object invoke = method.invoke(null, "KakaoGameSDK", "RequestToUnreal", Base64Util.getBase64encode(requestString));
            Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
            Logger.INSTANCE.m706v(str5, str + invoke);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void takeScreenShotOnUnity() {
        String str = y.دײܮڳܯ(2051316573);
        String str2 = y.دײܮڳܯ(2051316637);
        String str3 = y.ۮڭڭܬި(862415259);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ݬֲ֮ܲت(1512357655);
        String str5 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str5, str4);
        try {
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            Logger.INSTANCE.m706v(str5, str3 + cls);
            Method method = cls.getMethod("UnitySendMessage", String.class, String.class, String.class);
            Logger.INSTANCE.m706v(str5, str2 + method);
            Logger.INSTANCE.m706v(str5, str + method.invoke(null, "KakaoGameSDK", "TakeScreenShotUnity", ""));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void takeScreenShotOnUnreal() {
        String str = y.دײܮڳܯ(2051316573);
        String str2 = y.دײܮڳܯ(2051316637);
        String str3 = y.ۮڭڭܬި(862415259);
        Logger logger = Logger.INSTANCE;
        String str4 = y.دײܮڳܯ(2051315509);
        String str5 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str5, str4);
        try {
            Class<?> cls = Class.forName("com.kakaogames.sdk.unreal.MessageSender");
            Logger.INSTANCE.m706v(str5, str3 + cls);
            Method method = cls.getMethod("UnrealSendMessage", String.class, String.class, String.class);
            Logger.INSTANCE.m706v(str5, str2 + method);
            Logger.INSTANCE.m706v(str5, str + method.invoke(null, "KakaoGameSDK", "TakeScreenShotUnreal", ""));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCustomAlertViewOnUnity(String requestBody) {
        String str = y.دײܮڳܯ(2051316573);
        String str2 = y.دײܮڳܯ(2051316637);
        String str3 = y.ۮڭڭܬި(862415259);
        Intrinsics.checkNotNullParameter(requestBody, y.ۮڭڭܬި(862581515));
        Logger logger = Logger.INSTANCE;
        String str4 = y.ۮڭڭܬި(862581651) + requestBody;
        String str5 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str5, str4);
        try {
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            Logger.INSTANCE.m706v(str5, str3 + cls);
            Method method = cls.getMethod("UnitySendMessage", String.class, String.class, String.class);
            Logger.INSTANCE.m706v(str5, str2 + method);
            Logger.INSTANCE.m706v(str5, str + method.invoke(null, "KakaoGameSDK", "ShowCustomUIUnity", requestBody));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCustomAlertViewOnUnreal(String requestBody) {
        String str = y.دײܮڳܯ(2051316573);
        String str2 = y.دײܮڳܯ(2051316637);
        String str3 = y.ۮڭڭܬި(862415259);
        Intrinsics.checkNotNullParameter(requestBody, y.ۮڭڭܬި(862581515));
        Logger logger = Logger.INSTANCE;
        String str4 = y.ٲٴݴ״ٰ(1782088832) + requestBody;
        String str5 = y.ݮڮֲڭܩ(-628604452);
        logger.m706v(str5, str4);
        try {
            Class<?> cls = Class.forName("com.kakaogames.sdk.unreal.MessageSender");
            Logger.INSTANCE.m706v(str5, str3 + cls);
            Method method = cls.getMethod("UnrealSendMessage", String.class, String.class, String.class);
            Logger.INSTANCE.m706v(str5, str2 + method);
            Logger.INSTANCE.m706v(str5, str + method.invoke(null, "KakaoGameSDK", "ShowCustomUIUnreal", requestBody));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInternalAPIs() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051365605), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                SdkManager.INSTANCE.setTestModeApp();
                Object parameter = request.getParameter(y.ٴسسݬߨ(1393326218));
                Intrinsics.checkNotNull(parameter, y.دײܮڳܯ(2051373885));
                CoreManager.INSTANCE.getInstance().setConfiguration(new Configuration(TypeIntrinsics.asMutableMap(parameter)));
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158937455), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, y.ݮڮֲڭܩ(-628603604));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628592900), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                StartingPromotionManager.clearPreference(activity);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862466763), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    return KGResult.INSTANCE.getResult(3002);
                }
                LoginData loginData = AuthDataManager.getLoginData();
                Intrinsics.checkNotNull(loginData);
                LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
                Intrinsics.checkNotNull(accessToken);
                long expiryTime = accessToken.getExpiryTime();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", Long.valueOf(expiryTime));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158936471), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.ݬֲ֮ܲت(1512397151));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                Locale locale = new Locale(str);
                boolean areEqual = Intrinsics.areEqual(str, y.ٲٴݴ״ٰ(1782148128));
                String str2 = y.٬ݯح׭٩(576698190);
                if (areEqual) {
                    locale = new Locale(str2, y.ٲٴݴ״ٰ(1782148232));
                }
                if (Intrinsics.areEqual(str, y.دײܮڳܯ(2051371469))) {
                    locale = new Locale(str2, "CN");
                }
                Locale.setDefault(locale);
                android.content.res.Configuration configuration = new android.content.res.Configuration();
                configuration.locale = locale;
                activity.getResources().updateConfiguration(configuration, activity.getResources().getDisplayMetrics());
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158935719), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.֬ڱܱײٮ(-1158934215));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                Locale locale = new Locale(Locale.getDefault().getLanguage(), str);
                Locale.setDefault(locale);
                android.content.res.Configuration configuration = new android.content.res.Configuration();
                configuration.locale = locale;
                activity.getResources().updateConfiguration(configuration, activity.getResources().getDisplayMetrics());
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
                PreferenceUtil.setString(activity, y.دײܮڳܯ(2051362333), y.دײܮڳܯ(2051393733), lowerCase);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628595908), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String fcmiid = PushService.getFCMIID();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), fcmiid);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576689342), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                CharSequence charSequence = null;
                Intrinsics.checkNotNull(null);
                charSequence.length();
                throw null;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576689502), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                DialogManager.INSTANCE.showProcessKillDialog(activity, "앱 아이디를 변경하면\n앱이 종료됩니다.\n다시 실행하면, 변경된 앱 아이디로\n시작이 가능합니다.", true);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862468971), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                DialogManager.INSTANCE.showProcessKillDialog(activity, "서버타입을 변경하면\n앱이 종료됩니다.\n다시 실행하면, 변경된 서버타입으로\n시작이 가능합니다.", true);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051363077), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$11
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.ۮڭڭܬި(862461307));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                InviteDataManager.saveReferrer(activity, (String) parameter);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158811231), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$12
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                InviteDataManager.removeUserInvitationData(activity);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512343151), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$13
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("imagePath");
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.String");
                CoreManager.INSTANCE.getInstance().requestSnsShare((String) parameter);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782100424), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$14
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("action");
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.String");
                CoreManager.INSTANCE.getInstance().onCustomUICallback((String) parameter);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782100168), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$15
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("response");
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.String");
                Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628604452), y.֬ڱܱײٮ(-1158927967) + ((String) parameter));
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051320501), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$16
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                boolean isWhitelist = InfodeskHelper.INSTANCE.isWhitelist();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(isWhitelist));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862568579), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$17
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                CoreManager.INSTANCE.getInstance().registerShowCustomAlertHandler(KGCustomUI.KGCustomAlertType.INSTANCE.getType((String) request.getParameter("type")), new KGCustomUI.KGShowCustomAlertHandler() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$17$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGCustomUI.KGShowCustomAlertHandler
                    public void onShow(Activity activity2, KGCustomUI.KGCustomAlert alert, KGCustomUI.KGCustomAlertCallback callback) {
                        Log.e("InterfaceBrokerManager", "Never get Here.");
                    }
                });
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158810111), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$18
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("name");
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                Object parameter2 = request.getParameter(y.֬ڱܱײٮ(-1158927503));
                Intrinsics.checkNotNull(parameter2, y.ݬֲ֮ܲت(1512398143));
                int startFirebaseTraceOnUnity = CoreManager.INSTANCE.getInstance().startFirebaseTraceOnUnity((String) parameter, (Map) parameter2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Integer.valueOf(startFirebaseTraceOnUnity));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051319309), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$19
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter(ServerConstants.HEADER_TRACE_ID);
                Intrinsics.checkNotNull(parameter, y.ٲٴݴ״ٰ(1782047088));
                int intValue = ((Number) parameter).intValue();
                Object parameter2 = request.getParameter(y.֬ڱܱײٮ(-1158927503));
                Intrinsics.checkNotNull(parameter2, y.ݬֲ֮ܲت(1512398143));
                CoreManager.INSTANCE.getInstance().stopFirebaseTraceOnUnity(intValue, (Map) parameter2);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512345135), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$20
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("code");
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.Number");
                int intValue = ((Number) parameter).intValue();
                if (intValue == 0) {
                    intValue = 200;
                }
                CoreManager.testKakaoErrorCode = intValue;
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051319165), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$21
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("code");
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.Number");
                int intValue = ((Number) parameter).intValue();
                if (intValue == 0) {
                    intValue = 200;
                }
                CoreManager.testGoogleErrorCode = intValue;
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576611422), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$22
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                StringBuilder append = new StringBuilder().append(CoreManager.INSTANCE.getInstance().getConfiguration().getAppId()).append('_');
                KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                Intrinsics.checkNotNull(currentPlayer);
                PreferenceUtil.removeKey(activity, y.٬ݯح׭٩(576697742), append.append(currentPlayer.getPlayerId()).toString());
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051318685), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$23
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.ٲٴݴ״ٰ(1781623392));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                int makeJob = KGTracer.makeJob(activity, (String) parameter, TypeIntrinsics.asMutableMap(request.getParameter(y.٬ݯح׭٩(576155478))));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Integer.valueOf(makeJob));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576611998), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$24
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("jobId");
                String str = y.ٲٴݴ״ٰ(1782047088);
                Intrinsics.checkNotNull(parameter, str);
                int intValue = ((Number) parameter).intValue();
                Object parameter2 = request.getParameter(y.٬ݯح׭٩(576697942));
                Intrinsics.checkNotNull(parameter2, str);
                int intValue2 = ((Number) parameter2).intValue();
                String str2 = (String) request.getParameter(y.ٴسسݬߨ(1392801274));
                if (str2 == null) {
                    str2 = y.٬ݯح׭٩(575705262) + intValue2;
                }
                KGTracer.finishJob(intValue, intValue2, str2, TypeIntrinsics.asMutableMap(request.getParameter(y.٬ݯح׭٩(576155478))));
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1393402658), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$25
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("jobId");
                Intrinsics.checkNotNull(parameter, y.ٲٴݴ״ٰ(1782047088));
                int intValue = ((Number) parameter).intValue();
                Object parameter2 = request.getParameter(y.֬ڱܱײٮ(-1159583711));
                Intrinsics.checkNotNull(parameter2, y.ݬֲ֮ܲت(1512814407));
                KGTracer.startAction(intValue, (String) parameter2);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628520948), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initInternalAPIs$26
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter("jobId");
                String str = y.ٲٴݴ״ٰ(1782047088);
                Intrinsics.checkNotNull(parameter, str);
                int intValue = ((Number) parameter).intValue();
                Object parameter2 = request.getParameter(y.֬ڱܱײٮ(-1159583711));
                Intrinsics.checkNotNull(parameter2, y.ݬֲ֮ܲت(1512814407));
                String str2 = (String) parameter2;
                Object parameter3 = request.getParameter(y.٬ݯح׭٩(576697942));
                Intrinsics.checkNotNull(parameter3, str);
                int intValue2 = ((Number) parameter3).intValue();
                String str3 = (String) request.getParameter(y.ٴسسݬߨ(1392801274));
                if (str3 == null) {
                    str3 = y.٬ݯح׭٩(575705262) + intValue2;
                }
                KGTracer.finishAction(intValue, str2, intValue2, str3, TypeIntrinsics.asMutableMap(request.getParameter(y.٬ݯح׭٩(576155478))));
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initSessionAPIs() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862573683), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.loadAppInfos(activity, new KGResultCallback<List<? extends KGSession.KGAppInfo>>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$1$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<List<? extends KGSession.KGAppInfo>> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                KGResult<?> kGResult = (KGResult) content;
                if (!kGResult.isSuccess()) {
                    return kGResult;
                }
                Object content2 = kGResult.getContent();
                Intrinsics.checkNotNull(content2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(576686558), (List) content2);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782096160), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.ۮڭڭܬި(862411867));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    KGSession.start(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$2$request$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<Void> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                } else {
                    KGSession.start(activity, str, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$2$request$2
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<Void> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                }
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                KGResult kGResult = (KGResult) content;
                boolean isSuccess = kGResult.isSuccess();
                String str3 = y.ݬֲ֮ܲت(1512400295);
                if (isSuccess) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(str3, Boolean.valueOf(SdkManager.INSTANCE.isTestMode(activity)));
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(str3, Boolean.valueOf(SdkManager.INSTANCE.isTestMode(activity)));
                return KGResult.INSTANCE.getResult(kGResult.getCode(), kGResult.getDescription(), linkedHashMap2);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862574555), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.resume(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$3$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051325405), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.pause(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$4$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628519884), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.login(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$5$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782097416), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.connect(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$6$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576617942), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.logout(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$7$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782097328), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSession.unregister(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$8$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862573235), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                boolean isAuthorized = CoreManager.INSTANCE.getInstance().isAuthorized();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(isAuthorized));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782098800), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionAPIs$10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String accessToken = KGSession.getAccessToken();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), accessToken);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initSessionForCustomUIAPIs() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158813607), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGIdpProfile.KGIdpCode kGIdpCode;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.دײܮڳܯ(2051564517));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                KGIdpProfile.KGIdpCode[] values = KGIdpProfile.KGIdpCode.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGIdpCode = null;
                        break;
                    }
                    kGIdpCode = values[i];
                    if (StringsKt.equals(kGIdpCode.name(), str, true)) {
                        break;
                    }
                    i++;
                }
                if (kGIdpCode == null) {
                    return KGResult.INSTANCE.getResult(4000, y.ٲٴݴ״ٰ(1782174280) + str);
                }
                KGSessionForCustomUI.login(activity, kGIdpCode, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$1$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512349167), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGIdpProfile.KGIdpCode kGIdpCode;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.دײܮڳܯ(2051564517));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                KGIdpProfile.KGIdpCode[] values = KGIdpProfile.KGIdpCode.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGIdpCode = null;
                        break;
                    }
                    kGIdpCode = values[i];
                    if (StringsKt.equals(kGIdpCode.name(), str, true)) {
                        break;
                    }
                    i++;
                }
                if (kGIdpCode == null) {
                    return KGResult.INSTANCE.getResult(4000, y.ٲٴݴ״ٰ(1782174280) + str);
                }
                KGSessionForCustomUI.connect(activity, kGIdpCode, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$2$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576615334), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGKakaoAuthType kGKakaoAuthType;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.ۮڭڭܬި(862463915));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                KGKakaoAuthType[] values = KGKakaoAuthType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGKakaoAuthType = null;
                        break;
                    }
                    kGKakaoAuthType = values[i];
                    if (StringsKt.equals(kGKakaoAuthType.name(), str, true)) {
                        break;
                    }
                    i++;
                }
                KGSessionForCustomUI.loginKakao(activity, kGKakaoAuthType, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$3$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782099928), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGKakaoAuthType kGKakaoAuthType;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.ۮڭڭܬި(862463915));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                KGKakaoAuthType[] values = KGKakaoAuthType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGKakaoAuthType = null;
                        break;
                    }
                    kGKakaoAuthType = values[i];
                    if (StringsKt.equals(kGKakaoAuthType.name(), str, true)) {
                        break;
                    }
                    i++;
                }
                KGSessionForCustomUI.connectKakao(activity, kGKakaoAuthType, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$4$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1393406538), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSessionForCustomUI.logout(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$5$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628521092), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSessionForCustomUI.logout(new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$6$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158819455), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSessionForCustomUI.unregister(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$7$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1393397162), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGIdpProfile.KGIdpCode kGIdpCode;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.دײܮڳܯ(2051564517));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                KGIdpProfile.KGIdpCode[] values = KGIdpProfile.KGIdpCode.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGIdpCode = null;
                        break;
                    }
                    kGIdpCode = values[i];
                    if (StringsKt.equals(kGIdpCode.name(), str, true)) {
                        break;
                    }
                    i++;
                }
                if (kGIdpCode == null) {
                    return KGResult.INSTANCE.getResult(4000, y.ٲٴݴ״ٰ(1782174280) + str);
                }
                KGSessionForCustomUI.connectIdpAccount(activity, kGIdpCode, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$8$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628507852), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGSessionForCustomUI.KGIdpChoiceMode kGIdpChoiceMode;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.ٴسسݬߨ(1393330282));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                String str = (String) parameter;
                if (StringsKt.equals(str, y.ݬֲ֮ܲت(1512719607), true)) {
                    kGIdpChoiceMode = KGSessionForCustomUI.KGIdpChoiceMode.CurrentAccount;
                } else {
                    kGIdpChoiceMode = StringsKt.equals(str, y.֬ڱܱײٮ(-1159514743), true) ? KGSessionForCustomUI.KGIdpChoiceMode.AlreadyConnectedAccount : null;
                }
                if (kGIdpChoiceMode == null) {
                    return KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628589892) + str);
                }
                KGSessionForCustomUI.chooseIdpAccount(activity, kGIdpChoiceMode, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSessionForCustomUIAPIs$9$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initApplicationAPIs() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158932231), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.֬ڱܱײٮ(-1159616063));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                KGResult<Boolean> requestPermission = PermissionManager.INSTANCE.requestPermission(activity, (String) parameter);
                if (!requestPermission.isSuccess()) {
                    return KGResult.INSTANCE.getResult(requestPermission);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628598956), requestPermission.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628591956), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.دײܮڳܯ(2051593325));
                Intrinsics.checkNotNull(parameter, y.ݮڮֲڭܩ(-628714340));
                KGResult<Boolean> requestPermissions = PermissionManager.requestPermissions(activity, (List) parameter);
                if (!requestPermissions.isSuccess()) {
                    return KGResult.INSTANCE.getResult(requestPermissions);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628598956), requestPermissions.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512401831), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.֬ڱܱײٮ(-1159616063));
                Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                KGResult<Boolean> checkPermission = PermissionManager.checkPermission(activity, (String) parameter);
                if (!checkPermission.isSuccess()) {
                    return KGResult.INSTANCE.getResult(checkPermission);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628598956), checkPermission.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051359509), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.دײܮڳܯ(2051593325));
                Intrinsics.checkNotNull(parameter, y.ݮڮֲڭܩ(-628714340));
                KGResult<Boolean> checkPermissions = PermissionManager.checkPermissions(activity, (List) parameter);
                if (!checkPermissions.isSuccess()) {
                    return KGResult.INSTANCE.getResult(checkPermissions);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628598956), checkPermissions.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576685734), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                boolean showUsePermissionsNotification;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.دײܮڳܯ(2051593325));
                String str = y.ݮڮֲڭܩ(-628714340);
                Intrinsics.checkNotNull(parameter, str);
                List list = (List) parameter;
                Object parameter2 = request.getParameter(y.ۮڭڭܬި(862456443));
                Intrinsics.checkNotNull(parameter2, str);
                List list2 = (List) parameter2;
                String str2 = y.֬ڱܱײٮ(-1158922551);
                if (request.containsParameterKey(str2)) {
                    Object parameter3 = request.getParameter(y.ݬֲ֮ܲت(1512396567));
                    Intrinsics.checkNotNull(parameter3, y.ٴسسݬߨ(1393327258));
                    KGApplication.KGPermissionTheme kGPermissionTheme = new KGApplication.KGPermissionTheme((Map<String, ? extends Object>) parameter3);
                    Object parameter4 = request.getParameter(str2);
                    Intrinsics.checkNotNull(parameter4, y.ٲٴݴ״ٰ(1782032576));
                    showUsePermissionsNotification = PermissionManager.showUsePermissionsNotification(activity, list, list2, ((Boolean) parameter4).booleanValue(), kGPermissionTheme);
                } else {
                    Object parameter5 = request.getParameter(y.٬ݯح׭٩(575807958));
                    Intrinsics.checkNotNull(parameter5, y.ݬֲ֮ܲت(1512814407));
                    int identifier = activity.getResources().getIdentifier((String) parameter5, y.ٴسسݬߨ(1393328082), activity.getPackageName());
                    if (identifier <= 0) {
                        identifier = -1;
                    }
                    showUsePermissionsNotification = PermissionManager.showUsePermissionsNotification(activity, list, list2, false, KGApplication.KGPermissionTheme.Builder.INSTANCE.createTheme().setIconResourceId(identifier).build());
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628598956), Boolean.valueOf(showUsePermissionsNotification));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576690246), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGApplication.requestMarketReviewPopup(activity);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1393319354), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to("result", Boolean.valueOf(KGApplication.isEvaluationState()))));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628593844), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initApplicationAPIs$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Boolean bool = (Boolean) request.getParameter(y.֬ڱܱײٮ(-1158929695));
                KGResult<KGApplication.KGGameServerMaintenanceResponse> gameServerMaintenance = InfodeskNoticeManager.INSTANCE.getGameServerMaintenance(activity, bool != null ? bool.booleanValue() : true, (String) request.getParameter(y.ۮڭڭܬި(862458155)));
                FirebaseEvent.INSTANCE.sendEvent(y.ݬֲ֮ܲت(1512625815), y.ٲٴݴ״ٰ(1781850512), gameServerMaintenance);
                if (gameServerMaintenance.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(gameServerMaintenance);
                }
                KGApplication.KGGameServerMaintenanceResponse content = gameServerMaintenance.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(content);
                linkedHashMap.put(y.֬ڱܱײٮ(-1159613431), content.getNotices());
                linkedHashMap.put(y.֬ڱܱײٮ(-1158929071), Boolean.valueOf(content.isWhitelist()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initSystemAPIs() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158818319), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String deviceId = KGSystem.getDeviceId();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.دײܮڳܯ(2051393261), deviceId);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512350263), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String networkType = KGSystem.getNetworkType();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.دײܮڳܯ(2051361453), networkType);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512350015), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                boolean isNetworkConnected = KGSystem.isNetworkConnected();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1393314074), Boolean.valueOf(isNetworkConnected));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1393396706), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String countryCode = KGSystem.getCountryCode();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(countryCode);
                linkedHashMap.put(y.֬ڱܱײٮ(-1158934215), countryCode);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628510492), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String geoCountryCode = KGSystem.getGeoCountryCode();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(geoCountryCode);
                linkedHashMap.put(y.֬ڱܱײٮ(-1158933271), geoCountryCode);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576602614), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String languageCode = KGSystem.getLanguageCode();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(languageCode);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512397151), languageCode);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512353119), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String languageTag = KGSystem.getLanguageTag();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٲٴݴ״ٰ(1782142272), languageTag);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1393395682), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String deviceModel = KGSystem.getDeviceModel();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݬֲ֮ܲت(1512431663), deviceModel);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862579075), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String oSName = KGSystem.getOSName();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628588820), oSName);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051310581), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String advertisingId = DeviceUtil.getAdvertisingId(activity);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ۮڭڭܬި(862463619), advertisingId);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628508964), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$11
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Object parameter = request.getParameter(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.String");
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSystem.updateLanguageCode((String) parameter, new KGResultCallback<Void>() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$11$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                return (KGResult) content;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782095024), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initSystemAPIs$12
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                List<KGMarketRefundInfo> marketRefundInfoList = KGSession.INSTANCE.getMarketRefundInfoList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(576687134), marketRefundInfoList);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initNotis() {
        KGSession.registerOnlineNotificationListener(new KGSession.KGOnlineNotificationListener() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initNotis$listener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGSession.KGOnlineNotificationListener
            public void onMessage(Map<String, ? extends Object> message) {
                InterfaceBrokerManager.INSTANCE.sendMessage(y.دײܮڳܯ(2051362525), MapsKt.mapOf(TuplesKt.m846to(y.دײܮڳܯ(2051551053), message)));
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initAgreementAPI() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1158932743), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initAgreementAPI$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.ݬֲ֮ܲت(1512616727));
                Intrinsics.checkNotNull(parameter, y.٬ݯح׭٩(576693270));
                KGAgreement.setAgreement(activity, (Map) parameter);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(576684278), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.broker.InterfaceBrokerManager$initAgreementAPI$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap agreement = KGAgreement.getAgreement(activity);
                if (agreement == null) {
                    agreement = new LinkedHashMap();
                }
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), agreement);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
