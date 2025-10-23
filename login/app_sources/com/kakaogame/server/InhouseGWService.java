package com.kakaogame.server;

import com.kakao.sdk.partner.talk.Constants;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InhouseGWService.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J,\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0007J4\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00112\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0007J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0007J\u0016\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010$0\u0011H\u0007J\"\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0007J \u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0007J4\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010+H\u0007JF\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0016\u0010*\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040+H\u0007J@\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+H\u0007JB\u00102\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010+H\u0007JR\u00103\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010+2\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0002J8\u00106\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010+H\u0007J8\u00107\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010+H\u0007J\u001a\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007J0\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010+2\u0006\u0010\u0019\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006<"}, m839d2 = {"Lcom/kakaogame/server/InhouseGWService;", "", "()V", "ACCESS_TOKEN", "", "IMPRESSION_ID", "INVITATION_EVENT_ID", "RECEIVER_ID", "RECEIVER_ID_TYPE", "RECEIVER_MEMBER_KEY", "RECEIVER_UUID", "SENDER_PLAYER_ID", "TAG", "TEMPLATE_ARGS", "TEMPLATE_ID", "TEMPLATE_VER", "addPlusFriend", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "plusFriendId", "", "getForConnect", "Lcom/kakaogame/util/json/JSONObject;", "connectIdpCode", "connectIdpId", "traceJobId", "getForLogin", "idpCode", "idpId", "accessToken", "getInvitableFriendsV4Request", "Lcom/kakaogame/server/ServerRequest;", ServerConstants.RECOMMEND_LIMIT, "offset", "limit", "getInvitationHistory", "", "getKakaoUserInfo", "getRecommendedInvitableFriendsRequest", "getSendInvitationMessageRequest", InhouseGWService.RECEIVER_UUID, InhouseGWService.TEMPLATE_ID, InhouseGWService.TEMPLATE_ARGS, "", "getSendInvitationTalkMessageRequest", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, InhouseGWService.RECEIVER_ID, "impressionId", "getSendRecommendTalkMessageV3Request", InhouseGWService.RECEIVER_ID_TYPE, "getSendRecommendTalkMessageV4Request", "getSendTalkMessageRequest", "uri", InhouseGWService.TEMPLATE_VER, "getSendTalkMessageV3Request", "getSendTalkMessageV4Request", "getTgtToken", "set", "agreementMap", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InhouseGWService {
    private static final String ACCESS_TOKEN = "capriAccessToken";
    private static final String IMPRESSION_ID = "impressionId";
    public static final InhouseGWService INSTANCE = new InhouseGWService();
    private static final String INVITATION_EVENT_ID = "invitationEventId";
    private static final String RECEIVER_ID = "receiverId";
    private static final String RECEIVER_ID_TYPE = "receiverIdType";
    private static final String RECEIVER_MEMBER_KEY = "receiverMemberKey";
    private static final String RECEIVER_UUID = "receiverUuid";
    private static final String SENDER_PLAYER_ID = "senderPlayerId";
    private static final String TAG = "AgreementService";
    private static final String TEMPLATE_ARGS = "templateArgs";
    private static final String TEMPLATE_ID = "templateId";
    private static final String TEMPLATE_VER = "templateVer";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InhouseGWService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> set(Map<String, ? extends Object> agreementMap, int traceJobId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSetAgreementUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            if (agreementMap != null) {
                for (Map.Entry<String, ? extends Object> entry : agreementMap.entrySet()) {
                    serverRequest.putBody(entry.getKey(), entry.getValue());
                }
            }
            ServerResult requestServer = ServerService.requestServer(serverRequest, traceJobId);
            if (!requestServer.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512379111), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getForLogin(String idpCode, String idpId, String accessToken, int traceJobId) {
        ServerRequest serverRequest;
        String str = y.ݮڮֲڭܩ(-628796260);
        String str2 = y.دײܮڳܯ(2051564517);
        Intrinsics.checkNotNullParameter(idpCode, str2);
        try {
            if (StringsKt.equals(idpCode, str, true)) {
                serverRequest = new ServerRequest(Settings.INSTANCE.getGetAgreementForLoginGamaniaUri());
            } else {
                serverRequest = new ServerRequest(Settings.INSTANCE.getGetAgreementForLoginUri());
            }
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody(str2, idpCode);
            if (StringsKt.equals(idpCode, str, true)) {
                serverRequest.putBody("accessToken", accessToken);
            } else {
                serverRequest.putBody("idpId", idpId);
            }
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            serverRequest.putBody(ServerConstants.SERIAL_NUMBER, KGSystem.getOSName());
            serverRequest.putBody("os", KGSystem.getOSName());
            ServerResult requestServerApi = OpenApiService.requestServerApi(serverRequest, traceJobId);
            if (!requestServerApi.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServerApi.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512379111), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getForConnect(String connectIdpCode, String connectIdpId, int traceJobId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetAgreementForConnectUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("country", LocaleManager.INSTANCE.getCountryCode());
            serverRequest.putBody("connectIdpCode", connectIdpCode);
            serverRequest.putBody("connectIdpId", connectIdpId);
            ServerResult requestServerApi = OpenApiService.requestServerApi(serverRequest, traceJobId);
            if (!requestServerApi.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServerApi.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512379111), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getKakaoUserInfo(String accessToken, int traceJobId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetTokenInfoUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("accessToken", accessToken);
            ServerResult requestServerApi = OpenApiService.requestServerApi(serverRequest, traceJobId);
            if (!requestServerApi.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServerApi.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512379111), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> addPlusFriend(int plusFriendId) {
        KGResult<Void> successResult;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getAddPlusFriendUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("plusFriendId", Integer.valueOf(plusFriendId));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestServer$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512379111), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getRecommendedInvitableFriendsRequest(int recommendLimit, int offset, int limit) {
        ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetRecommendedInvitableFriendsUri());
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        serverRequest.putBody(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        if (recommendLimit > -1) {
            serverRequest.putBody(y.֬ڱܱײٮ(-1159658759), Integer.valueOf(recommendLimit));
        }
        serverRequest.putBody("offset", Integer.valueOf(offset));
        serverRequest.putBody("limit", Integer.valueOf(limit));
        return serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getInvitableFriendsV4Request(int recommendLimit, int offset, int limit) {
        ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitableFriendsV4Uri());
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        serverRequest.putBody(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        if (recommendLimit > -1) {
            serverRequest.putBody(y.֬ڱܱײٮ(-1159658759), Integer.valueOf(recommendLimit));
        }
        serverRequest.putBody("offset", Integer.valueOf(offset));
        serverRequest.putBody("limit", Integer.valueOf(limit));
        return serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getSendTalkMessageV3Request(String receiverIdType, String receiverId, String templateId, Map<String, String> templateArgs) {
        Intrinsics.checkNotNullParameter(receiverIdType, y.ۮڭڭܬި(862841899));
        Intrinsics.checkNotNullParameter(receiverId, y.ٲٴݴ״ٰ(1782356616));
        Intrinsics.checkNotNullParameter(templateId, y.ۮڭڭܬި(862266835));
        return INSTANCE.getSendTalkMessageRequest(receiverIdType, receiverId, null, templateId, templateArgs, Settings.INSTANCE.getSendTalkMessageUri(), y.֬ڱܱײٮ(-1159079743));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getSendTalkMessageV4Request(String receiverIdType, String receiverId, String templateId, Map<String, String> templateArgs) {
        Intrinsics.checkNotNullParameter(receiverIdType, y.ۮڭڭܬި(862841899));
        Intrinsics.checkNotNullParameter(receiverId, y.ٲٴݴ״ٰ(1782356616));
        Intrinsics.checkNotNullParameter(templateId, y.ۮڭڭܬި(862266835));
        return INSTANCE.getSendTalkMessageRequest(receiverIdType, receiverId, null, templateId, templateArgs, Settings.INSTANCE.getSendTalkMessageUri(), y.ٲٴݴ״ٰ(1782356272));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getSendRecommendTalkMessageV3Request(String receiverIdType, String receiverId, String impressionId, String templateId, Map<String, String> templateArgs) {
        Intrinsics.checkNotNullParameter(receiverIdType, y.ۮڭڭܬި(862841899));
        Intrinsics.checkNotNullParameter(receiverId, y.ٲٴݴ״ٰ(1782356616));
        Intrinsics.checkNotNullParameter(templateId, y.ۮڭڭܬި(862266835));
        return INSTANCE.getSendTalkMessageRequest(receiverIdType, receiverId, impressionId, templateId, templateArgs, Settings.INSTANCE.getSendRecommendFriendMessageUri(), y.֬ڱܱײٮ(-1159079743));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getSendRecommendTalkMessageV4Request(String receiverIdType, String receiverId, String impressionId, String templateId, Map<String, String> templateArgs) {
        Intrinsics.checkNotNullParameter(receiverIdType, y.ۮڭڭܬި(862841899));
        Intrinsics.checkNotNullParameter(receiverId, y.ٲٴݴ״ٰ(1782356616));
        Intrinsics.checkNotNullParameter(templateId, y.ۮڭڭܬި(862266835));
        return INSTANCE.getSendTalkMessageRequest(receiverIdType, receiverId, impressionId, templateId, templateArgs, Settings.INSTANCE.getSendRecommendFriendMessageUri(), y.ٲٴݴ״ٰ(1782356272));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ServerRequest getSendTalkMessageRequest(String receiverIdType, String receiverId, String impressionId, String templateId, Map<String, String> templateArgs, String uri, String templateVer) {
        ServerRequest serverRequest = new ServerRequest(uri);
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        serverRequest.putBody(y.ۮڭڭܬި(862839315), CoreManager.INSTANCE.getInstance().getPlayerId());
        serverRequest.putBody(RECEIVER_ID_TYPE, receiverIdType);
        serverRequest.putBody(RECEIVER_ID, receiverId);
        if (impressionId != null) {
            serverRequest.putBody("impressionId", impressionId);
        }
        serverRequest.putBody(TEMPLATE_VER, templateVer);
        serverRequest.putBody(TEMPLATE_ID, templateId);
        serverRequest.putBody(TEMPLATE_ARGS, templateArgs);
        Logger.INSTANCE.m699d(TAG, "templateArgs ==> " + templateArgs);
        return serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getSendInvitationTalkMessageRequest(int eventId, String receiverId, String impressionId, String templateId, Map<String, String> templateArgs) {
        String str = y.֬ڱܱײٮ(-1159079535);
        Intrinsics.checkNotNullParameter(templateArgs, str);
        ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendInviteMessageV4Uri());
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        serverRequest.putBody(y.ۮڭڭܬި(862839315), CoreManager.INSTANCE.getInstance().getPlayerId());
        serverRequest.putBody(y.٬ݯح׭٩(575833462), Integer.valueOf(eventId));
        serverRequest.putBody(RECEIVER_MEMBER_KEY, receiverId);
        if (impressionId != null) {
            serverRequest.putBody("impressionId", impressionId);
        }
        serverRequest.putBody(TEMPLATE_ID, templateId);
        serverRequest.putBody(str, templateArgs);
        Logger.INSTANCE.m699d(TAG, "templateArgs ==> " + templateArgs);
        return serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest getSendInvitationMessageRequest(String receiverUuid, String templateId, Map<String, String> templateArgs) {
        ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendInvitationMessage());
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        serverRequest.putBody(y.ۮڭڭܬި(862839315), CoreManager.INSTANCE.getInstance().getPlayerId());
        serverRequest.putBody(y.ٲٴݴ״ٰ(1782355120), receiverUuid);
        serverRequest.putBody(TEMPLATE_ID, templateId);
        serverRequest.putBody(TEMPLATE_ARGS, templateArgs);
        Logger.INSTANCE.m699d(TAG, y.دײܮڳܯ(2051049061) + templateArgs);
        return serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<List<String>> getInvitationHistory() {
        ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitationHistory());
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        serverRequest.putBody(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
        if (requestServer$default.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(requestServer$default);
        }
        JSONObject content = requestServer$default.getContent();
        Intrinsics.checkNotNull(content);
        JSONArray jSONArray = (JSONArray) content.get((Object) y.دײܮڳܯ(2051049693));
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                Object obj = jSONArray.get(i);
                Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
                arrayList.add((String) obj);
            }
        }
        return KGResult.INSTANCE.getSuccessResult(arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> getTgtToken(String accessToken) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetTgtTokenUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getAppId());
            serverRequest.putBody(ACCESS_TOKEN, accessToken);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            return KGResult.INSTANCE.getSuccessResult((String) content.get((Object) Constants.TOKEN));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512379111), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: InhouseGWService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00060"}, m839d2 = {"Lcom/kakaogame/server/InhouseGWService$Settings;", "", "()V", "addPlusFriendUri", "", "getAddPlusFriendUri", "()Ljava/lang/String;", "setAddPlusFriendUri", "(Ljava/lang/String;)V", "getAgreementForConnectUri", "getGetAgreementForConnectUri", "setGetAgreementForConnectUri", "getAgreementForLoginGamaniaUri", "getGetAgreementForLoginGamaniaUri", "setGetAgreementForLoginGamaniaUri", "getAgreementForLoginUri", "getGetAgreementForLoginUri", "setGetAgreementForLoginUri", "getInvitableFriendsV4Uri", "getGetInvitableFriendsV4Uri", "setGetInvitableFriendsV4Uri", "getInvitationHistory", "getGetInvitationHistory", "setGetInvitationHistory", "getRecommendedInvitableFriendsUri", "getGetRecommendedInvitableFriendsUri", "setGetRecommendedInvitableFriendsUri", "getTgtTokenUri", "getGetTgtTokenUri", "setGetTgtTokenUri", "getTokenInfoUri", "getGetTokenInfoUri", "setGetTokenInfoUri", "sendInvitationMessage", "getSendInvitationMessage", "setSendInvitationMessage", "sendInviteMessageV4Uri", "getSendInviteMessageV4Uri", "setSendInviteMessageV4Uri", "sendRecommendFriendMessageUri", "getSendRecommendFriendMessageUri", "setSendRecommendFriendMessageUri", "sendTalkMessageUri", "getSendTalkMessageUri", "setSendTalkMessageUri", "setAgreementUri", "getSetAgreementUri", "setSetAgreementUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getTokenInfoUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512079783), y.٬ݯح׭٩(576352166));
        private static String setAgreementUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862834019), y.ۮڭڭܬި(862833739));
        private static String getAgreementForLoginUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512082839), y.ݮڮֲڭܩ(-628255964));
        private static String getAgreementForLoginGamaniaUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862833011), y.ۮڭڭܬި(862832851));
        private static String getAgreementForConnectUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1159069743), y.٬ݯح׭٩(576354390));
        private static String addPlusFriendUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576354678), y.ٲٴݴ״ٰ(1782358384));
        private static String sendTalkMessageUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628258132), y.ۮڭڭܬި(862835003));
        private static String getTgtTokenUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576355470), y.ۮڭڭܬި(862834835));
        private static String getRecommendedInvitableFriendsUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1159076079), y.֬ڱܱײٮ(-1159076287));
        private static String sendRecommendFriendMessageUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628260804), y.دײܮڳܯ(2051061645));
        private static String getInvitableFriendsV4Uri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393145714), y.٬ݯح׭٩(576353446));
        private static String sendInviteMessageV4Uri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862836907), y.֬ڱܱײٮ(-1159074287));
        private static String getInvitationHistory = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576342126), y.ݬֲ֮ܲت(1512088967));
        private static String sendInvitationMessage = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512088807), y.ݬֲ֮ܲت(1512088287));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetTokenInfoUri() {
            return getTokenInfoUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetTokenInfoUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getTokenInfoUri = str;
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
        public final String getGetAgreementForLoginUri() {
            return getAgreementForLoginUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetAgreementForLoginUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getAgreementForLoginUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetAgreementForLoginGamaniaUri() {
            return getAgreementForLoginGamaniaUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetAgreementForLoginGamaniaUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getAgreementForLoginGamaniaUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetAgreementForConnectUri() {
            return getAgreementForConnectUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetAgreementForConnectUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getAgreementForConnectUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getAddPlusFriendUri() {
            return addPlusFriendUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setAddPlusFriendUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            addPlusFriendUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendTalkMessageUri() {
            return sendTalkMessageUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSendTalkMessageUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            sendTalkMessageUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetTgtTokenUri() {
            return getTgtTokenUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetTgtTokenUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getTgtTokenUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetRecommendedInvitableFriendsUri() {
            return getRecommendedInvitableFriendsUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetRecommendedInvitableFriendsUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getRecommendedInvitableFriendsUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendRecommendFriendMessageUri() {
            return sendRecommendFriendMessageUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSendRecommendFriendMessageUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            sendRecommendFriendMessageUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitableFriendsV4Uri() {
            return getInvitableFriendsV4Uri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitableFriendsV4Uri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitableFriendsV4Uri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendInviteMessageV4Uri() {
            return sendInviteMessageV4Uri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSendInviteMessageV4Uri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            sendInviteMessageV4Uri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitationHistory() {
            return getInvitationHistory;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitationHistory(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitationHistory = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendInvitationMessage() {
            return sendInvitationMessage;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSendInvitationMessage(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            sendInvitationMessage = str;
        }
    }
}
