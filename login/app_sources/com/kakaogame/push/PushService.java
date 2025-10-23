package com.kakaogame.push;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.player.LocalPlayer;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushService.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007J\u001a\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/push/PushService;", "", "()V", "FIELD_KEY_GCM_PROJECT_ID", "", "PREF_KEY_INSTANCE_ID", "TAG", "fCMIID", "getFCMIID$annotations", "getFCMIID", "()Ljava/lang/String;", PushService.FIELD_KEY_GCM_PROJECT_ID, "checkManifest", "", "context", "Landroid/content/Context;", "initialize", "", "register", "registerPushToken", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", LocalPlayerService.FIELD_KEY_PUSH_TOKEN, "registerPushTokenToProfileServer", "registerPushTokenToPushServer", "saveFCMIID", "iid", "sendByPlayerIds", SDKConstants.PARAM_A2U_BODY, "", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PushService {
    private static final String FIELD_KEY_GCM_PROJECT_ID = "gcmProjectId";
    public static final PushService INSTANCE = new PushService();
    private static final String PREF_KEY_INSTANCE_ID = "firebase_iid";
    private static final String TAG = "PushService";
    private static final String gcmProjectId = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getFCMIID$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PushService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        Logger.INSTANCE.m704i(y.دײܮڳܯ(2051135181), y.ٲٴݴ״ٰ(1781793120));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean checkManifest(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        int integer = context.getResources().getInteger(ResourceUtil.getResourceId(context, y.دײܮڳܯ(2051135493), y.ٴسسݬߨ(1393089338)));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393089522) + integer;
        String str2 = y.دײܮڳܯ(2051135181);
        logger.m704i(str2, str);
        if (integer < 7571000) {
            return false;
        }
        if (!SDKVersion.isPublishing) {
            return true;
        }
        boolean checkService = AndroidManifestUtil.INSTANCE.checkService(context, y.ٲٴݴ״ٰ(1782434352));
        Logger.INSTANCE.m704i(str2, y.ݬֲ֮ܲت(1512177143) + checkService);
        return checkService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveFCMIID(Context context, String iid) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNull(iid);
        String str = y.دײܮڳܯ(2051134805);
        PreferenceUtil.setString(context, str, str, iid);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getFCMIID() {
        Context context = CoreManager.INSTANCE.getInstance().getContext();
        String str = y.دײܮڳܯ(2051134805);
        String string = PreferenceUtil.getString(context, str, str);
        String str2 = string;
        if (str2 == null || str2.length() == 0) {
            try {
                String fCMToken = CoreManager.INSTANCE.getInstance().getFCMToken();
                if (fCMToken.length() > 0) {
                    saveFCMIID(context, fCMToken);
                    return fCMToken;
                }
            } catch (RuntimeException unused) {
                return "";
            }
        }
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> sendByPlayerIds(Map<String, ? extends Object> body) {
        KGResult<Void> successResult;
        Intrinsics.checkNotNullParameter(body, y.ۮڭڭܬި(862442651));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051133909) + body;
        String str2 = y.دײܮڳܯ(2051135181);
        logger.m699d(str2, str);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendByPlayerIdsUri());
            serverRequest.putAllBody(body);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestServer$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[Catch: Exception -> 0x0085, TryCatch #0 {Exception -> 0x0085, blocks: (B:3:0x0021, B:5:0x002c, B:10:0x0038, B:13:0x0040, B:15:0x004c, B:16:0x0054, B:18:0x005c, B:19:0x006e), top: B:2:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040 A[Catch: Exception -> 0x0085, TryCatch #0 {Exception -> 0x0085, blocks: (B:3:0x0021, B:5:0x002c, B:10:0x0038, B:13:0x0040, B:15:0x004c, B:16:0x0054, B:18:0x005c, B:19:0x006e), top: B:2:0x0021 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void register() {
        /*
            r0 = -1159165271(0xffffffffbae88aa9, float:-0.0017741519)
            java.lang.String r0 = com.liapp.y.֬ڱܱײٮ(r0)
            r1 = 576394366(0x225b147e, float:2.9690883E-18)
            java.lang.String r1 = com.liapp.y.٬ݯح׭٩(r1)
            com.kakaogame.Logger r2 = com.kakaogame.Logger.INSTANCE
            r3 = -1159164823(0xffffffffbae88c69, float:-0.0017742041)
            java.lang.String r3 = com.liapp.y.֬ڱܱײٮ(r3)
            r4 = 2051135181(0x7a41d6cd, float:2.516175E35)
            java.lang.String r4 = com.liapp.y.دײܮڳܯ(r4)
            r2.m704i(r4, r3)
            com.kakaogame.push.PushService r2 = com.kakaogame.push.PushService.INSTANCE     // Catch: java.lang.Exception -> L85
            java.lang.String r3 = getFCMIID()     // Catch: java.lang.Exception -> L85
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> L85
            if (r5 == 0) goto L35
            int r5 = r5.length()     // Catch: java.lang.Exception -> L85
            if (r5 != 0) goto L33
            goto L35
        L33:
            r5 = 0
            goto L36
        L35:
            r5 = 1
        L36:
            if (r5 == 0) goto L40
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L85
            java.lang.String r1 = "GCM Push Register Failed"
            r0.m708w(r4, r1)     // Catch: java.lang.Exception -> L85
            goto L91
        L40:
            com.kakaogame.core.CoreManager$Companion r5 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L85
            com.kakaogame.core.CoreManager r5 = r5.getInstance()     // Catch: java.lang.Exception -> L85
            com.kakaogame.player.LocalPlayer r5 = r5.getPlayer()     // Catch: java.lang.Exception -> L85
            if (r5 == 0) goto L53
            java.lang.String r6 = "pushToken"
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L85
            goto L54
        L53:
            r5 = 0
        L54:
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L85
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)     // Catch: java.lang.Exception -> L85
            if (r6 == 0) goto L6e
            com.kakaogame.Logger r6 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L85
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L85
            r7.<init>(r1)     // Catch: java.lang.Exception -> L85
            java.lang.StringBuilder r1 = r7.append(r5)     // Catch: java.lang.Exception -> L85
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L85
            r6.m706v(r4, r1)     // Catch: java.lang.Exception -> L85
        L6e:
            com.kakaogame.KGResult r1 = r2.registerPushToken(r3)     // Catch: java.lang.Exception -> L85
            com.kakaogame.Logger r2 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L85
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L85
            r3.<init>(r0)     // Catch: java.lang.Exception -> L85
            java.lang.StringBuilder r0 = r3.append(r1)     // Catch: java.lang.Exception -> L85
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L85
            r2.m704i(r4, r0)     // Catch: java.lang.Exception -> L85
            goto L91
        L85:
            r0 = move-exception
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            java.lang.String r2 = r0.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.m702e(r4, r2, r0)
        L91:
            return
            fill-array 0x0092: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.push.PushService.register():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> registerPushToken(String pushToken) {
        String str = y.دײܮڳܯ(2051135181);
        String str2 = y.ݮڮֲڭܩ(-628300300);
        String str3 = y.ٴسسݬߨ(1393086978);
        try {
            KGResult<Void> registerPushTokenToPushServer = registerPushTokenToPushServer(pushToken);
            Logger.INSTANCE.m704i(str, str3 + registerPushTokenToPushServer);
            if (!registerPushTokenToPushServer.isSuccess()) {
                KGResult<Void> registerPushTokenToProfileServer = registerPushTokenToProfileServer(pushToken);
                Logger.INSTANCE.m704i(str, str2 + registerPushTokenToProfileServer);
                if (!registerPushTokenToProfileServer.isSuccess()) {
                    return KGResult.INSTANCE.getResult(registerPushTokenToProfileServer);
                }
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> registerPushTokenToPushServer(String pushToken) {
        KGResult<Void> successResult;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getRegisterTokenUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("os", KGSystem.getOSName());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody(ServerConstants.TIMEZONE_OFFSET, Long.valueOf(LocaleManager.INSTANCE.getTimeZoneOffset()));
            serverRequest.putBody(LocalPlayerService.FIELD_KEY_PUSH_TOKEN, pushToken);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestServer$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051135181), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> registerPushTokenToProfileServer(String pushToken) {
        KGResult<Void> updatePlayer;
        String str = y.دײܮڳܯ(2051135181);
        try {
            Logger.INSTANCE.m704i(str, y.ۮڭڭܬި(862763979) + pushToken);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(LocalPlayerService.FIELD_KEY_PUSH_TOKEN, pushToken);
            linkedHashMap.put(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            LocalPlayer player = CoreManager.INSTANCE.getInstance().getPlayer();
            return (player == null || (updatePlayer = player.updatePlayer(linkedHashMap)) == null) ? KGResult.INSTANCE.getResult(4002) : updatePlayer;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: PushService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/push/PushService$Settings;", "", "()V", "registerTokenUri", "", "getRegisterTokenUri", "()Ljava/lang/String;", "setRegisterTokenUri", "(Ljava/lang/String;)V", "sendByPlayerIdsUri", "getSendByPlayerIdsUri", "setSendByPlayerIdsUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String sendByPlayerIdsUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576395934), y.ۮڭڭܬި(862762691));
        private static String registerTokenUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862761363), y.٬ݯح׭٩(576396678));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendByPlayerIdsUri() {
            return sendByPlayerIdsUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSendByPlayerIdsUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            sendByPlayerIdsUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRegisterTokenUri() {
            return registerTokenUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setRegisterTokenUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            registerTokenUri = str;
        }
    }
}
