package com.kakaogame.promotion;

import android.content.Context;
import android.text.TextUtils;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGMessage;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.addon.KGService;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.promotion.SNSShareData;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PromotionService.kt */
@Metadata(m838d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\b2\u0006\u0010!\u001a\u00020\"H\u0007J*\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\b2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\b2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0015H\u0002J \u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c0\b2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c0\bJ\u0010\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\bH\u0007J\u0018\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\b2\u0006\u00104\u001a\u00020\"H\u0007J\u0018\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\b2\u0006\u00104\u001a\u00020\"H\u0007J\u0018\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\b2\u0006\u00104\u001a\u00020\"H\u0007J\u0018\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\b2\u0006\u00104\u001a\u00020\"H\u0007J\u0010\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\bH\u0007J\u0010\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\bH\u0007J\u0010\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\bH\u0007J*\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\b2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\fR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\fR\"\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\fR(\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c0\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\f¨\u0006?"}, m839d2 = {"Lcom/kakaogame/promotion/PromotionService;", "", "()V", "TAG", "", "TYPE_ENDING", "TYPE_OPENING", "endingPopupPromotion", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/promotion/PromotionData;", "getEndingPopupPromotion$annotations", "getEndingPopupPromotion", "()Lcom/kakaogame/KGResult;", "invitationCount", "", "getInvitationCount$annotations", "getInvitationCount", "playerReferrer", "getPlayerReferrer$annotations", "getPlayerReferrer", "playerReward", "", "getPlayerReward$annotations", "getPlayerReward", "sNSShareJoinerCount", "getSNSShareJoinerCount$annotations", "getSNSShareJoinerCount", "startingPopupPromotions", "", "getStartingPopupPromotions$annotations", "getStartingPopupPromotions", "applyPromotion", "Ljava/lang/Void;", "sequence", "", "checkSNSShareRewarded", ServerConstants.SEQ, "type", "Lcom/kakaogame/promotion/SNSShareData$SNSShareType;", "code", "checkUrlPromotion", "referrer", "clickPromotion", "getIPAddress", "useIPv4", "getPopupPromotionsforV4", "getReferrerFromFingerPrint", ServerConstants.USER_AGENT, "initialize", "loadInvitationEvents", "Lcom/kakaogame/util/json/JSONObject;", "loadInvitationReceivers", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "loadInvitationReceiversCount", "loadInvitationSenders", "loadInvitationSendersCount", "loadSNSShareInfo", "Lcom/kakaogame/promotion/SNSShareData;", "removeUserInvitationData", "requestInvitationCheckIn", "sendRequestSNSShareReward", "sendSavedRequestSNSShareReward", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PromotionService {
    public static final PromotionService INSTANCE = new PromotionService();
    private static final String TAG = "PromotionService";
    public static final String TYPE_ENDING = "closing";
    public static final String TYPE_OPENING = "opening";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getEndingPopupPromotion$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getInvitationCount$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getPlayerReferrer$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getPlayerReward$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getSNSShareJoinerCount$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getStartingPopupPromotions$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PromotionService() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00bb A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:3:0x000e, B:5:0x0063, B:6:0x0076, B:8:0x00af, B:13:0x00bb, B:14:0x00c0, B:16:0x00d5, B:19:0x00de, B:21:0x00f1, B:22:0x0104, B:24:0x010a, B:26:0x011b, B:27:0x011e), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5 A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:3:0x000e, B:5:0x0063, B:6:0x0076, B:8:0x00af, B:13:0x00bb, B:14:0x00c0, B:16:0x00d5, B:19:0x00de, B:21:0x00f1, B:22:0x0104, B:24:0x010a, B:26:0x011b, B:27:0x011e), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00de A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:3:0x000e, B:5:0x0063, B:6:0x0076, B:8:0x00af, B:13:0x00bb, B:14:0x00c0, B:16:0x00d5, B:19:0x00de, B:21:0x00f1, B:22:0x0104, B:24:0x010a, B:26:0x011b, B:27:0x011e), top: B:2:0x000e }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.util.List<com.kakaogame.promotion.PromotionData>> initialize() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.promotion.PromotionService.initialize():com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<List<PromotionData>> getStartingPopupPromotions() {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetStartingPromotionsUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            if (!Intrinsics.areEqual(DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()), "")) {
                serverRequest.putBody(ServerConstants.ADID, DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()));
            }
            ArrayList arrayList = null;
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                JSONObject content = requestServer$default.getContent();
                Intrinsics.checkNotNull(content);
                JSONArray jSONArray = (JSONArray) content.get((Object) "promotions");
                if (jSONArray != null) {
                    JSONArray jSONArray2 = jSONArray;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
                    Iterator<Object> it = jSONArray2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new PromotionData((JSONObject) it.next(), 3));
                    }
                    arrayList = arrayList2;
                }
                return KGResult.INSTANCE.getSuccessResult(arrayList);
            }
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<List<PromotionData>> getPopupPromotionsforV4(String type) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetStartingPromotionsV4Uri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            serverRequest.putBody(ServerConstants.POP_UP_TYPE, type);
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            if (!Intrinsics.areEqual(DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()), "")) {
                serverRequest.putBody(ServerConstants.ADID, DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()));
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            ArrayList arrayList = new ArrayList();
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONArray jSONArray = (JSONArray) content.get((Object) "popups");
            if (jSONArray != null) {
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    PromotionData promotionData = new PromotionData((JSONObject) jSONArray.get(i));
                    promotionData.put("version", 4);
                    promotionData.put("applyType", "CLICK");
                    arrayList.add(promotionData);
                }
            }
            return KGResult.INSTANCE.getSuccessResult(arrayList);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<PromotionData> getEndingPopupPromotion() {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetEndingPromotionUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            if (!Intrinsics.areEqual(DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()), "")) {
                serverRequest.putBody(ServerConstants.ADID, DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()));
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                JSONObject content = requestServer$default.getContent();
                Intrinsics.checkNotNull(content);
                JSONObject jSONObject = (JSONObject) content.get((Object) KGMessage.SENDER_ID_PROMOTION);
                return KGResult.INSTANCE.getSuccessResult(jSONObject != null ? new PromotionData(jSONObject) : null);
            }
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> applyPromotion(int sequence) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getApplyPromotionUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            serverRequest.putBody(ServerConstants.SEQ, Integer.valueOf(sequence));
            if (!Intrinsics.areEqual(DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()), "")) {
                serverRequest.putBody(ServerConstants.ADID, DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()));
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> clickPromotion(int sequence) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getPopupClickUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            serverRequest.putBody("popupSeq", Integer.valueOf(sequence));
            if (!Intrinsics.areEqual(DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()), "")) {
                serverRequest.putBody(ServerConstants.ADID, DeviceUtil.getAdvertisingId(CoreManager.INSTANCE.getInstance().getContext()));
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> checkUrlPromotion(String referrer) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getCheckUrlPromotionUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("referrer", referrer);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            if (content != null) {
                KGResult<String> successResult = KGResult.INSTANCE.getSuccessResult((String) content.get((Object) "result"));
                if (successResult != null) {
                    return successResult;
                }
            }
            return KGResult.INSTANCE.getResult(2003, "content is null");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<Long> getInvitationCount() {
        KGResult<Long> result;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getCountChildrenUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                LinkedHashMap result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                LinkedHashMap linkedHashMap = (JSONObject) requestServer$default.getContent();
                if (linkedHashMap != null) {
                    result2 = linkedHashMap;
                }
                LinkedHashMap linkedHashMap2 = result2;
                Object obj = result2.get(KGService.COUNT);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                result = KGResult.INSTANCE.getSuccessResult(Long.valueOf(((Long) obj).longValue()));
            } else {
                result = KGResult.INSTANCE.getResult(requestServer$default);
            }
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<Long> getSNSShareJoinerCount() {
        KGResult<Long> result;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getCountSNSJoinerUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                LinkedHashMap result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                LinkedHashMap linkedHashMap = (JSONObject) requestServer$default.getContent();
                if (linkedHashMap != null) {
                    result2 = linkedHashMap;
                }
                LinkedHashMap linkedHashMap2 = result2;
                Object obj = result2.get("value");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                result = KGResult.INSTANCE.getSuccessResult(Long.valueOf(((Long) obj).longValue()));
            } else {
                result = KGResult.INSTANCE.getResult(requestServer$default);
            }
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getIPAddress(boolean useIPv4) {
        String upperCase;
        String str = y.ݬֲ֮ܲت(1512156399);
        try {
            ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Intrinsics.checkNotNullExpressionValue(list, str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ArrayList<InetAddress> list2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses());
                Intrinsics.checkNotNullExpressionValue(list2, str);
                for (InetAddress inetAddress : list2) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        Intrinsics.checkNotNull(hostAddress);
                        boolean z = StringsKt.indexOf$default((CharSequence) hostAddress, ':', 0, false, 6, (Object) null) < 0;
                        if (useIPv4) {
                            if (z) {
                                return hostAddress;
                            }
                        } else if (!z) {
                            int indexOf$default = StringsKt.indexOf$default((CharSequence) hostAddress, '%', 0, false, 6, (Object) null);
                            String str2 = y.ݬֲ֮ܲت(1512156247);
                            if (indexOf$default < 0) {
                                upperCase = hostAddress.toUpperCase(Locale.ROOT);
                            } else {
                                String substring = hostAddress.substring(0, indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                upperCase = substring.toUpperCase(Locale.ROOT);
                            }
                            Intrinsics.checkNotNullExpressionValue(upperCase, str2);
                            return upperCase;
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> getReferrerFromFingerPrint(String userAgent) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetReferrerFromFingerPrintUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody(ServerConstants.USER_AGENT, userAgent);
            ServerResult requestServerApi$default = OpenApiService.requestServerApi$default(serverRequest, 0, 2, null);
            if (!requestServerApi$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi$default);
            }
            JSONObject content = requestServerApi$default.getContent();
            if (content == null) {
                return KGResult.INSTANCE.getResult(2003, "content is null");
            }
            return KGResult.INSTANCE.getSuccessResult((String) content.get((Object) "referrer"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<Boolean> getPlayerReward() {
        KGResult<Boolean> result;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.isChildUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                LinkedHashMap result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                LinkedHashMap linkedHashMap = (JSONObject) requestServer$default.getContent();
                if (linkedHashMap != null) {
                    result2 = linkedHashMap;
                }
                LinkedHashMap linkedHashMap2 = result2;
                Object obj = result2.get("child");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(((Boolean) obj).booleanValue()));
            } else {
                result = KGResult.INSTANCE.getResult(requestServer$default);
            }
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> removeUserInvitationData() {
        KGResult<Void> successResult;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getRemoveUserInvitationDataUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                return (requestServer$default == null || (successResult = KGResult.INSTANCE.getSuccessResult()) == null) ? KGResult.INSTANCE.getResult(2003, "content is null") : successResult;
            }
            return KGResult.INSTANCE.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGResult<String> getPlayerReferrer() {
        KGResult<String> result;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getMakeReferrerUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                LinkedHashMap result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                LinkedHashMap linkedHashMap = (JSONObject) requestServer$default.getContent();
                if (linkedHashMap != null) {
                    result2 = linkedHashMap;
                }
                LinkedHashMap linkedHashMap2 = result2;
                result = KGResult.INSTANCE.getSuccessResult((String) result2.get("referrer"));
            } else {
                result = KGResult.INSTANCE.getResult(requestServer$default);
            }
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:2:0x0000, B:4:0x0041, B:9:0x004d, B:10:0x0052, B:12:0x005e, B:15:0x0067), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[Catch: Exception -> 0x006e, TRY_LEAVE, TryCatch #0 {Exception -> 0x006e, blocks: (B:2:0x0000, B:4:0x0041, B:9:0x004d, B:10:0x0052, B:12:0x005e, B:15:0x0067), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:2:0x0000, B:4:0x0041, B:9:0x004d, B:10:0x0052, B:12:0x005e, B:15:0x0067), top: B:1:0x0000 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<java.lang.Void> requestInvitationCheckIn() {
        /*
            com.kakaogame.server.ServerRequest r0 = new com.kakaogame.server.ServerRequest     // Catch: java.lang.Exception -> L6e
            com.kakaogame.promotion.PromotionService$Settings r1 = com.kakaogame.promotion.PromotionService.Settings.INSTANCE     // Catch: java.lang.Exception -> L6e
            java.lang.String r1 = r1.getInvitationCheckInUri()     // Catch: java.lang.Exception -> L6e
            r0.<init>(r1)     // Catch: java.lang.Exception -> L6e
            java.lang.String r1 = "appId"
            com.kakaogame.core.CoreManager$Companion r2 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L6e
            com.kakaogame.core.CoreManager r2 = r2.getInstance()     // Catch: java.lang.Exception -> L6e
            com.kakaogame.config.Configuration r2 = r2.getConfiguration()     // Catch: java.lang.Exception -> L6e
            java.lang.String r2 = r2.getAppId()     // Catch: java.lang.Exception -> L6e
            r0.putBody(r1, r2)     // Catch: java.lang.Exception -> L6e
            java.lang.String r1 = "playerId"
            com.kakaogame.core.CoreManager$Companion r2 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L6e
            com.kakaogame.core.CoreManager r2 = r2.getInstance()     // Catch: java.lang.Exception -> L6e
            java.lang.String r2 = r2.getPlayerId()     // Catch: java.lang.Exception -> L6e
            r0.putBody(r1, r2)     // Catch: java.lang.Exception -> L6e
            com.kakaogame.core.CoreManager$Companion r1 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L6e
            com.kakaogame.core.CoreManager r1 = r1.getInstance()     // Catch: java.lang.Exception -> L6e
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Exception -> L6e
            java.lang.String r1 = com.kakaogame.invite.InviteDataManager.loadReferrer(r1)     // Catch: java.lang.Exception -> L6e
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L6e
            r3 = 0
            if (r2 == 0) goto L4a
            int r2 = r2.length()     // Catch: java.lang.Exception -> L6e
            if (r2 != 0) goto L48
            goto L4a
        L48:
            r2 = r3
            goto L4b
        L4a:
            r2 = 1
        L4b:
            if (r2 != 0) goto L52
            java.lang.String r2 = "hostKey"
            r0.putBody(r2, r1)     // Catch: java.lang.Exception -> L6e
        L52:
            r1 = 2
            r2 = 0
            com.kakaogame.server.ServerResult r0 = com.kakaogame.server.ServerService.requestServer$default(r0, r3, r1, r2)     // Catch: java.lang.Exception -> L6e
            boolean r1 = r0.isSuccess()     // Catch: java.lang.Exception -> L6e
            if (r1 != 0) goto L67
            com.kakaogame.KGResult$Companion r1 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L6e
            java.util.Map r0 = (java.util.Map) r0     // Catch: java.lang.Exception -> L6e
            com.kakaogame.KGResult r0 = r1.getResult(r0)     // Catch: java.lang.Exception -> L6e
            goto L8e
        L67:
            com.kakaogame.KGResult$Companion r0 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L6e
            com.kakaogame.KGResult r0 = r0.getSuccessResult()     // Catch: java.lang.Exception -> L6e
            goto L8e
        L6e:
            r0 = move-exception
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            java.lang.String r2 = r0.toString()
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r4 = -628313420(0xffffffffda8cb2b4, float:-1.9801491E16)
            java.lang.String r4 = com.liapp.y.ݮڮֲڭܩ(r4)
            r1.m702e(r4, r2, r3)
            com.kakaogame.KGResult$Companion r1 = com.kakaogame.KGResult.INSTANCE
            r2 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r0 = r0.toString()
            com.kakaogame.KGResult r0 = r1.getResult(r2, r0)
        L8e:
            return r0
            fill-array 0x0090: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.promotion.PromotionService.requestInvitationCheckIn():com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> loadInvitationEvents() {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitationEventUri());
            serverRequest.setMethod("GET");
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> loadInvitationSendersCount(int eventId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitationSendersCountUri());
            serverRequest.setMethod("GET");
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("userId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("invitationEventId", Integer.valueOf(eventId));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> loadInvitationReceiversCount(int eventId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitationReceiversCountUri());
            serverRequest.setMethod("GET");
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("userId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("invitationEventId", Integer.valueOf(eventId));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> loadInvitationSenders(int eventId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitationSendersUri());
            serverRequest.setMethod("GET");
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("userId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("invitationEventId", Integer.valueOf(eventId));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> loadInvitationReceivers(int eventId) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetInvitationReceiversUri());
            serverRequest.setMethod("GET");
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("userId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("invitationEventId", Integer.valueOf(eventId));
            serverRequest.putBody(ServerConstants.IS_REGISTERED, false);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<SNSShareData> loadSNSShareInfo() {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetSNSShareInfoUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            if (content != null && !content.isEmpty()) {
                return KGResult.INSTANCE.getSuccessResult(new SNSShareData(content));
            }
            return KGResult.INSTANCE.getResult(2003);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Boolean> checkSNSShareRewarded(long seq, SNSShareData.SNSShareType type, String code) {
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.isSNSShareRewardUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody(ServerConstants.SEQ, Long.valueOf(seq));
            serverRequest.putBody(ServerConstants.SHARE_TYPE, type.name());
            if (!TextUtils.isEmpty(code)) {
                serverRequest.putBody("code", code);
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            Object obj = content.get((Object) "exists");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(((Boolean) obj).booleanValue()));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> sendRequestSNSShareReward(long seq, SNSShareData.SNSShareType type, String code) {
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getRequestSNSShareRewardUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putBody(ServerConstants.SEQ, Long.valueOf(seq));
            serverRequest.putBody(ServerConstants.SHARE_TYPE, type.name());
            if (!TextUtils.isEmpty(code)) {
                serverRequest.putBody("code", code);
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            if (requestServer$default.getCode() == 406) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            KGResult<Void> result = KGResult.INSTANCE.getResult(requestServer$default);
            if (!result.isNetworkError()) {
                return result;
            }
            InviteDataManager.INSTANCE.saveRewardRequest(CoreManager.INSTANCE.getInstance().getContext(), CoreManager.INSTANCE.getInstance().getPlayerId(), serverRequest);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628313420), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> sendSavedRequestSNSShareReward() {
        String str = y.ݮڮֲڭܩ(-628313420);
        String str2 = y.֬ڱܱײٮ(-1159144095);
        try {
            Context context = CoreManager.INSTANCE.getInstance().getContext();
            String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
            List<ServerRequest> loadRewardRequest = InviteDataManager.INSTANCE.loadRewardRequest(context, playerId);
            KGResult<Void> successResult = KGResult.INSTANCE.getSuccessResult();
            if (loadRewardRequest != null && !loadRewardRequest.isEmpty()) {
                Logger.INSTANCE.m699d(str, str2 + loadRewardRequest.size());
                int i = 0;
                while (true) {
                    if (i >= loadRewardRequest.size()) {
                        break;
                    }
                    ServerResult requestServer$default = ServerService.requestServer$default(loadRewardRequest.get(i), 0, 2, null);
                    if (!requestServer$default.isSuccess() && successResult.isNetworkError()) {
                        successResult = KGResult.INSTANCE.getResult(requestServer$default);
                        break;
                    }
                    i++;
                }
                if (i >= loadRewardRequest.size()) {
                    return successResult;
                }
                InviteDataManager.INSTANCE.saveRewardRequests(context, playerId, loadRewardRequest.subList(i, loadRewardRequest.size()));
                return successResult;
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getSuccessResult();
        }
    }

    /* compiled from: PromotionService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bH\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001a\u00109\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001a\u0010I\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\b¨\u0006L"}, m839d2 = {"Lcom/kakaogame/promotion/PromotionService$Settings;", "", "()V", "applyPromotionUri", "", "getApplyPromotionUri", "()Ljava/lang/String;", "setApplyPromotionUri", "(Ljava/lang/String;)V", "checkUrlPromotionUri", "getCheckUrlPromotionUri", "setCheckUrlPromotionUri", "countChildrenUri", "getCountChildrenUri", "setCountChildrenUri", "countSNSJoinerUri", "getCountSNSJoinerUri", "setCountSNSJoinerUri", "getEndingPromotionUri", "getGetEndingPromotionUri", "setGetEndingPromotionUri", "getHiddenPromotionsUri", "getGetHiddenPromotionsUri", "setGetHiddenPromotionsUri", "getInvitationEventUri", "getGetInvitationEventUri", "setGetInvitationEventUri", "getInvitationReceiversCountUri", "getGetInvitationReceiversCountUri", "setGetInvitationReceiversCountUri", "getInvitationReceiversUri", "getGetInvitationReceiversUri", "setGetInvitationReceiversUri", "getInvitationSendersCountUri", "getGetInvitationSendersCountUri", "setGetInvitationSendersCountUri", "getInvitationSendersUri", "getGetInvitationSendersUri", "setGetInvitationSendersUri", "getReferrerFromFingerPrintUri", "getGetReferrerFromFingerPrintUri", "setGetReferrerFromFingerPrintUri", "getSNSShareInfoUri", "getGetSNSShareInfoUri", "setGetSNSShareInfoUri", "getStartingPromotionsUri", "getGetStartingPromotionsUri", "setGetStartingPromotionsUri", "getStartingPromotionsV4Uri", "getGetStartingPromotionsV4Uri", "setGetStartingPromotionsV4Uri", "initializeUri", "getInitializeUri", "setInitializeUri", "invitationCheckInUri", "getInvitationCheckInUri", "setInvitationCheckInUri", "isChildUri", "setChildUri", "isSNSShareRewardUri", "setSNSShareRewardUri", "makeReferrerUri", "getMakeReferrerUri", "setMakeReferrerUri", "popupClickUri", "getPopupClickUri", "setPopupClickUri", "progressBoardRecordUri", "getProgressBoardRecordUri", "setProgressBoardRecordUri", "removeUserInvitationDataUri", "getRemoveUserInvitationDataUri", "setRemoveUserInvitationDataUri", "requestSNSShareRewardUri", "getRequestSNSShareRewardUri", "setRequestSNSShareRewardUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String initializeUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051424581), y.֬ڱܱײٮ(-1158741711));
        private static String getStartingPromotionsUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1158741527), y.٬ݯح׭٩(576494110));
        private static String getEndingPromotionUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1158741487), y.ݮڮֲڭܩ(-628396996));
        private static String getHiddenPromotionsUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782203968), y.ٲٴݴ״ٰ(1782203744));
        private static String applyPromotionUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1158740375), y.ݮڮֲڭܩ(-628400100));
        private static String checkUrlPromotionUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862666203), y.ۮڭڭܬި(862666555));
        private static String countChildrenUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393514322), y.ݮڮֲڭܩ(-628399100));
        private static String countSNSJoinerUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628398628), y.دײܮڳܯ(2051428629));
        private static String isChildUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862766107), y.٬ݯح׭٩(576416374));
        private static String getReferrerFromFingerPrintUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576416638), y.دײܮڳܯ(2051123853));
        private static String removeUserInvitationDataUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862765995), "");
        private static String makeReferrerUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862765819), y.ݮڮֲڭܩ(-628321956));
        private static String invitationCheckInUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393075810), y.ٲٴݴ״ٰ(1782429936));
        private static String getInvitationEventUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576415054), y.ݬֲ֮ܲت(1512147255));
        private static String getInvitationSendersCountUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628320356), y.ٴسسݬߨ(1393081626));
        private static String getInvitationReceiversCountUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576420510), y.ۮڭڭܬި(862769411));
        private static String getInvitationSendersUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512149559), y.ݬֲ֮ܲت(1512149127));
        private static String getInvitationReceiversUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628326356), y.دײܮڳܯ(2051127181));
        private static String getSNSShareInfoUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782425720), y.ٲٴݴ״ٰ(1782427552));
        private static String isSNSShareRewardUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576419294), y.֬ڱܱײٮ(-1159139767));
        private static String requestSNSShareRewardUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1159147055), y.ٴسسݬߨ(1393069618));
        private static String progressBoardRecordUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628311156), y.ݮڮֲڭܩ(-628310564));
        private static String getStartingPromotionsV4Uri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628310380), y.ٲٴݴ״ٰ(1782422288));
        private static String popupClickUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1159144999), y.֬ڱܱײٮ(-1159144663));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getInitializeUri() {
            return initializeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setInitializeUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            initializeUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetStartingPromotionsUri() {
            return getStartingPromotionsUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetStartingPromotionsUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getStartingPromotionsUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetEndingPromotionUri() {
            return getEndingPromotionUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetEndingPromotionUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getEndingPromotionUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetHiddenPromotionsUri() {
            return getHiddenPromotionsUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetHiddenPromotionsUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getHiddenPromotionsUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getApplyPromotionUri() {
            return applyPromotionUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setApplyPromotionUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            applyPromotionUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCheckUrlPromotionUri() {
            return checkUrlPromotionUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCheckUrlPromotionUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            checkUrlPromotionUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCountChildrenUri() {
            return countChildrenUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCountChildrenUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            countChildrenUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCountSNSJoinerUri() {
            return countSNSJoinerUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCountSNSJoinerUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            countSNSJoinerUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String isChildUri() {
            return isChildUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setChildUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            isChildUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetReferrerFromFingerPrintUri() {
            return getReferrerFromFingerPrintUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetReferrerFromFingerPrintUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getReferrerFromFingerPrintUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRemoveUserInvitationDataUri() {
            return removeUserInvitationDataUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setRemoveUserInvitationDataUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            removeUserInvitationDataUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMakeReferrerUri() {
            return makeReferrerUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setMakeReferrerUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            makeReferrerUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getInvitationCheckInUri() {
            return invitationCheckInUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setInvitationCheckInUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            invitationCheckInUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitationEventUri() {
            return getInvitationEventUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitationEventUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitationEventUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitationSendersCountUri() {
            return getInvitationSendersCountUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitationSendersCountUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitationSendersCountUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitationReceiversCountUri() {
            return getInvitationReceiversCountUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitationReceiversCountUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitationReceiversCountUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitationSendersUri() {
            return getInvitationSendersUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitationSendersUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitationSendersUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetInvitationReceiversUri() {
            return getInvitationReceiversUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetInvitationReceiversUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getInvitationReceiversUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetSNSShareInfoUri() {
            return getSNSShareInfoUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetSNSShareInfoUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getSNSShareInfoUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String isSNSShareRewardUri() {
            return isSNSShareRewardUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSNSShareRewardUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            isSNSShareRewardUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRequestSNSShareRewardUri() {
            return requestSNSShareRewardUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setRequestSNSShareRewardUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            requestSNSShareRewardUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getProgressBoardRecordUri() {
            return progressBoardRecordUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setProgressBoardRecordUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            progressBoardRecordUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetStartingPromotionsV4Uri() {
            return getStartingPromotionsV4Uri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetStartingPromotionsV4Uri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getStartingPromotionsV4Uri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getPopupClickUri() {
            return popupClickUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPopupClickUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            popupClickUri = str;
        }
    }
}
