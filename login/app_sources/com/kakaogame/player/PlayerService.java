package com.kakaogame.player;

import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.agreement.AgreementService;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.player.profile.AppProfileService;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PlayerService.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0016H\u0007J:\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00140\t2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\t2\u0006\u0010\u001f\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m839d2 = {"Lcom/kakaogame/player/PlayerService;", "", "()V", "FIELD_KEY_CUSTOM_PROPERTY", "", "FIELD_KEY_IDP_ID", "FIELD_KEY_SECURE_PROPERTY", "TAG", "adAgreement", "Lcom/kakaogame/KGResult;", "", "getAdAgreement$annotations", "getAdAgreement", "()Lcom/kakaogame/KGResult;", "appId", "getListWithIdpId", "", "Lcom/kakaogame/player/Player;", "idpCode", "idpIds", "", "fields", "", "getPlayers", "playerIds", "initialize", "", "configuration", "Lcom/kakaogame/config/Configuration;", "setAdAgreement", "Ljava/lang/Void;", "enable", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PlayerService {
    public static final String FIELD_KEY_CUSTOM_PROPERTY = "customProperty";
    public static final String FIELD_KEY_IDP_ID = "idpId";
    public static final String FIELD_KEY_SECURE_PROPERTY = "secureProperty";
    public static final PlayerService INSTANCE = new PlayerService();
    private static final String TAG = "PlayerService";
    private static String appId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getAdAgreement$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PlayerService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1393326218));
        appId = configuration.getAppId();
        LocalPlayerService.initialize(configuration);
        AppProfileService.initialize(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:3:0x002f, B:5:0x0036, B:11:0x0044, B:14:0x004b, B:16:0x0050, B:21:0x005c, B:23:0x0063, B:25:0x0085, B:27:0x008d, B:28:0x0096, B:30:0x00a2, B:32:0x00ab, B:33:0x00ca, B:35:0x00d0, B:37:0x00e1), top: B:2:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:3:0x002f, B:5:0x0036, B:11:0x0044, B:14:0x004b, B:16:0x0050, B:21:0x005c, B:23:0x0063, B:25:0x0085, B:27:0x008d, B:28:0x0096, B:30:0x00a2, B:32:0x00ab, B:33:0x00ca, B:35:0x00d0, B:37:0x00e1), top: B:2:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:3:0x002f, B:5:0x0036, B:11:0x0044, B:14:0x004b, B:16:0x0050, B:21:0x005c, B:23:0x0063, B:25:0x0085, B:27:0x008d, B:28:0x0096, B:30:0x00a2, B:32:0x00ab, B:33:0x00ca, B:35:0x00d0, B:37:0x00e1), top: B:2:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:3:0x002f, B:5:0x0036, B:11:0x0044, B:14:0x004b, B:16:0x0050, B:21:0x005c, B:23:0x0063, B:25:0x0085, B:27:0x008d, B:28:0x0096, B:30:0x00a2, B:32:0x00ab, B:33:0x00ca, B:35:0x00d0, B:37:0x00e1), top: B:2:0x002f }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<java.util.List<com.kakaogame.player.Player>> getPlayers(java.util.List<java.lang.String> r6, java.util.List<java.lang.String> r7) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.player.PlayerService.getPlayers(java.util.List, java.util.List):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Map<String, Player>> getListWithIdpId(String idpCode, List<String> idpIds, List<String> fields) {
        String str = y.٬ݯح׭٩(576653590);
        String str2 = y.ۮڭڭܬި(862658331);
        String str3 = y.٬ݯح׭٩(576500366);
        String str4 = y.دײܮڳܯ(2051564517);
        Intrinsics.checkNotNullParameter(idpCode, str4);
        Logger logger = Logger.INSTANCE;
        String str5 = y.ݬֲ֮ܲت(1512463567) + idpCode + y.ݮڮֲڭܩ(-628756788) + idpIds;
        String str6 = y.ݬֲ֮ܲت(1512463919);
        logger.m699d(str6, str5);
        try {
            if (TextUtils.isEmpty(idpCode)) {
                return KGResult.INSTANCE.getResult(4000, str3 + idpIds);
            }
            if (idpIds != null && !idpIds.isEmpty()) {
                if (fields == null) {
                    fields = new ArrayList();
                }
                fields.add(str);
                ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetListWithIdpIdUri());
                serverRequest.putBody("appId", appId);
                serverRequest.putBody(str4, idpCode);
                serverRequest.putBody("idpIds", idpIds);
                serverRequest.putBody("fields", fields);
                if (ServerService.isUseSession() && InfodeskHelper.INSTANCE.isPlayerOnline()) {
                    serverRequest.putBody("fillInOnline", true);
                }
                ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
                if (!requestServer$default.isSuccess()) {
                    return KGResult.INSTANCE.getResult(requestServer$default);
                }
                JSONObject content = requestServer$default.getContent();
                Intrinsics.checkNotNull(content);
                JSONArray jSONArray = (JSONArray) content.get((Object) "players");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(jSONArray);
                Iterator<Object> it = jSONArray.iterator();
                while (it.hasNext()) {
                    Player player = new Player((JSONObject) it.next());
                    String str7 = (String) player.get(str);
                    if (str7 != null) {
                        linkedHashMap.put(str7, player);
                    }
                }
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
            return KGResult.INSTANCE.getResult(4000, str2 + idpIds);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str6, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<Boolean> getAdAgreement() {
        String str = y.٬ݯح׭٩(576715966);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٴسسݬߨ(1393522026);
        String str3 = y.ݬֲ֮ܲت(1512463919);
        logger.m699d(str3, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetAdAgreementUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            Logger.INSTANCE.m699d(str3, str + requestServer$default);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            return KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(StringsKt.equals(AgreementService.VALUE_YES, (String) content.get((Object) "agreementStatus"), true)));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> setAdAgreement(boolean enable) {
        ServerRequest serverRequest;
        String str = y.٬ݯح׭٩(576715966);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٴسسݬߨ(1393520690) + enable;
        String str3 = y.ݬֲ֮ܲت(1512463919);
        logger.m699d(str3, str2);
        try {
            if (enable) {
                serverRequest = new ServerRequest(Settings.INSTANCE.getEnableAdAgreementUri());
            } else {
                serverRequest = new ServerRequest(Settings.INSTANCE.getWithdrawAdAgreementUri());
            }
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            Logger.INSTANCE.m699d(str3, str + requestServer$default);
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: PlayerService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/player/PlayerService$Settings;", "", "()V", "enableAdAgreementUri", "", "getEnableAdAgreementUri", "()Ljava/lang/String;", "setEnableAdAgreementUri", "(Ljava/lang/String;)V", "getAdAgreementUri", "getGetAdAgreementUri", "setGetAdAgreementUri", "getListWithIdpIdUri", "getGetListWithIdpIdUri", "setGetListWithIdpIdUri", "getPlayersUri", "getGetPlayersUri", "setGetPlayersUri", "withdrawAdAgreementUri", "getWithdrawAdAgreementUri", "setWithdrawAdAgreementUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getPlayersUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512462223), y.ݬֲ֮ܲت(1512462183));
        private static String getListWithIdpIdUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051440613), y.دײܮڳܯ(2051439797));
        private static String getAdAgreementUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782210736), y.دײܮڳܯ(2051439285));
        private static String enableAdAgreementUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862654547), y.ۮڭڭܬި(862655411));
        private static String withdrawAdAgreementUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051438933), y.دײܮڳܯ(2051438109));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetPlayersUri() {
            return getPlayersUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetPlayersUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getPlayersUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetListWithIdpIdUri() {
            return getListWithIdpIdUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetListWithIdpIdUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getListWithIdpIdUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetAdAgreementUri() {
            return getAdAgreementUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetAdAgreementUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getAdAgreementUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getEnableAdAgreementUri() {
            return enableAdAgreementUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setEnableAdAgreementUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            enableAdAgreementUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWithdrawAdAgreementUri() {
            return withdrawAdAgreementUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWithdrawAdAgreementUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            withdrawAdAgreementUri = str;
        }
    }
}
