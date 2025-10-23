package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGKakaoProfile;
import com.kakaogame.KGResult;
import com.kakaogame.addon.KGService;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.server.InhouseGWService;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoInvitation.kt */
@Metadata(m838d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003)*+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\fH\u0002J \u0010\u000b\u001a\u00020\t2\u0016\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0018\u00010\u0010H\u0007J2\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0010H\u0007J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\"\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00132\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0010H\u0007J\u0018\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\f2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\"\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00132\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0010H\u0007J\u001e\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r0\f2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00132\u0016\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r\u0018\u00010\u0010H\u0007J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\"\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00132\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0010H\u0007JF\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0018\u0010$\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010%H\u0002JP\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0018\u0010$\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010%2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u0010H\u0007J\u0018\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\f2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitation;", "Lcom/kakaogame/KGObject;", "()V", "CLASS_NAME_KEY", "", "TAG", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "loadEvents", "Lcom/kakaogame/KGResult;", "", "Lcom/kakaogame/KGKakaoInvitation$KGKakaoEvent;", "callback", "Lcom/kakaogame/KGResultCallback;", "loadInvitableFriendProfiles", ServerConstants.RECOMMEND_LIMIT, "", "offset", "limit", "Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse;", "loadReceivers", "Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersResponse;", KGKakaoEvent.UNUTY_EVENT_ID, "loadReceiversCount", "Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersCountResponse;", "loadSenders", "Lcom/kakaogame/KGPlayer;", "loadSendersCount", "sendInviteMessage", "Ljava/lang/Void;", "kakaoProfile", "Lcom/kakaogame/KGKakaoProfile;", "templateId", "args", "", "sendRequestWithScope", "requestData", "Lcom/kakaogame/server/ServerRequest;", "KGInvitationReceviersCountResponse", "KGInvitationReceviersResponse", "KGKakaoEvent", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoInvitation extends KGObject {
    private static final String CLASS_NAME_KEY = "KGKakaoInvitation";
    public static final KGKakaoInvitation INSTANCE = new KGKakaoInvitation();
    private static final String TAG = "KGKakaoInvitationEvent";
    private static final long serialVersionUID = 4679516182408282459L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoInvitation() {
        super(null, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadEvents(KGResultCallback<List<KGKakaoEvent>> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$loadEvents$1(callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<List<KGKakaoEvent>> loadEvents() {
        KGResult<List<KGKakaoEvent>> result;
        KGResult<JSONObject> loadInvitationEvents;
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862267939);
        String str2 = y.دײܮڳܯ(2051780269);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1392684482));
        try {
            try {
                loadInvitationEvents = PromotionService.loadInvitationEvents();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
            }
            if (!loadInvitationEvents.isSuccess()) {
                KGResult<List<KGKakaoEvent>> result2 = KGResult.INSTANCE.getResult(loadInvitationEvents);
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                return result2;
            }
            ArrayList arrayList = new ArrayList();
            JSONObject content = loadInvitationEvents.getContent();
            Intrinsics.checkNotNull(content);
            JSONArray jSONArray = (JSONArray) content.get((Object) "invitationEvents");
            Intrinsics.checkNotNull(jSONArray);
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                KGKakaoEvent kGKakaoEvent = new KGKakaoEvent((JSONObject) next);
                Logger.INSTANCE.m699d(str2, "event: " + kGKakaoEvent);
                arrayList.add(kGKakaoEvent);
            }
            result = KGResult.INSTANCE.getSuccessResult(arrayList);
            start.stop();
            KakaoUtil.convertResultCode(result);
            KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadSendersCount(int eventId, KGResultCallback<Integer> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$loadSendersCount$1(eventId, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Integer> loadSendersCount(int eventId) {
        KGResult<Integer> result;
        KGResult<JSONObject> loadInvitationSendersCount;
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575758510) + eventId;
        String str2 = y.دײܮڳܯ(2051780269);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159530495));
        try {
            try {
                loadInvitationSendersCount = PromotionService.loadInvitationSendersCount(eventId);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                KakaoUtil.convertResultCode(result);
                KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
            }
            if (!loadInvitationSendersCount.isSuccess()) {
                KGResult<Integer> result2 = KGResult.INSTANCE.getResult(loadInvitationSendersCount);
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                return result2;
            }
            JSONObject content = loadInvitationSendersCount.getContent();
            Intrinsics.checkNotNull(content);
            Number number = (Number) content.get((Object) KGService.COUNT);
            Intrinsics.checkNotNull(number);
            result = KGResult.INSTANCE.getSuccessResult(Integer.valueOf(number.intValue()));
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadSenders(int eventId, KGResultCallback<List<KGPlayer>> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$loadSenders$1(eventId, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<List<KGPlayer>> loadSenders(int eventId) {
        KGResult<List<KGPlayer>> result;
        KGResult<JSONObject> loadInvitationSenders;
        String str;
        boolean z;
        String str2 = y.٬ݯح׭٩(575761086);
        Logger logger = Logger.INSTANCE;
        String str3 = y.دײܮڳܯ(2051778909) + eventId;
        String str4 = y.دײܮڳܯ(2051780269);
        logger.m699d(str4, str3);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1392684026));
        try {
            try {
                loadInvitationSenders = PromotionService.loadInvitationSenders(eventId);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str4, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
            }
            if (!loadInvitationSenders.isSuccess()) {
                KGResult<List<KGPlayer>> result2 = KGResult.INSTANCE.getResult(loadInvitationSenders);
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                return result2;
            }
            ArrayList arrayList = new ArrayList();
            JSONObject content = loadInvitationSenders.getContent();
            Intrinsics.checkNotNull(content);
            JSONArray jSONArray = (JSONArray) content.get((Object) "records");
            Intrinsics.checkNotNull(jSONArray);
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                JSONObject jSONObject = (JSONObject) next;
                HashMap hashMap = new HashMap();
                hashMap.put("playerId", jSONObject.get((Object) "senderUserId"));
                JSONObject jSONObject2 = (JSONObject) jSONObject.get((Object) "kakaoProfile");
                String str5 = y.٬ݯح׭٩(576019982);
                if (jSONObject2 == null) {
                    str = str5;
                } else {
                    String str6 = (String) jSONObject2.get((Object) "nickname");
                    Intrinsics.checkNotNull(str6);
                    str = str6;
                }
                if (jSONObject2 != null) {
                    str5 = (String) jSONObject2.get((Object) "profileImage");
                    Intrinsics.checkNotNull(str5);
                }
                String str7 = str5;
                boolean z2 = false;
                if (jSONObject.containsKey((Object) str2)) {
                    Boolean bool = (Boolean) jSONObject.get((Object) str2);
                    Intrinsics.checkNotNull(bool);
                    z = bool.booleanValue();
                } else {
                    z = false;
                }
                if (!z) {
                    z2 = true;
                }
                hashMap.put(KGPlayer.KEY_IDP_PROFILE, new KGKakaoProfile("", str, str7, z2, z));
                arrayList.add(new KGPlayer(hashMap));
                Logger.INSTANCE.m699d(str4, "player: " + jSONObject);
            }
            result = KGResult.INSTANCE.getSuccessResult(arrayList);
            start.stop();
            KakaoUtil.convertResultCode(result);
            KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadReceiversCount(int eventId, KGResultCallback<KGInvitationReceviersCountResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$loadReceiversCount$1(eventId, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGInvitationReceviersCountResponse> loadReceiversCount(int eventId) {
        KGResult<KGInvitationReceviersCountResponse> result;
        KGResult<JSONObject> loadInvitationReceiversCount;
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628712164) + eventId;
        String str2 = y.دײܮڳܯ(2051780269);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٲٴݴ״ٰ(1782036200));
        try {
            try {
                loadInvitationReceiversCount = PromotionService.loadInvitationReceiversCount(eventId);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                KakaoUtil.convertResultCode(result);
                KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
            }
            if (!loadInvitationReceiversCount.isSuccess()) {
                KGResult<KGInvitationReceviersCountResponse> result2 = KGResult.INSTANCE.getResult(loadInvitationReceiversCount);
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                return result2;
            }
            JSONObject content = loadInvitationReceiversCount.getContent();
            Intrinsics.checkNotNull(content);
            Number number = (Number) content.get((Object) "totalCount");
            Intrinsics.checkNotNull(number);
            int intValue = number.intValue();
            Number number2 = (Number) content.get((Object) "registeredCount");
            Intrinsics.checkNotNull(number2);
            result = KGResult.INSTANCE.getSuccessResult(new KGInvitationReceviersCountResponse(intValue, number2.intValue()));
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadReceivers(int eventId, KGResultCallback<KGInvitationReceviersResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$loadReceivers$1(eventId, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0151 A[Catch: all -> 0x018f, Exception -> 0x0191, TryCatch #0 {Exception -> 0x0191, blocks: (B:4:0x0037, B:6:0x0041, B:10:0x005b, B:11:0x0081, B:13:0x0087, B:46:0x00d8, B:52:0x00fc, B:54:0x00f2, B:58:0x00e4, B:17:0x010c, B:23:0x014b, B:25:0x0151, B:27:0x0159, B:29:0x0164, B:32:0x016d, B:37:0x0140, B:41:0x0130, B:63:0x0180), top: B:3:0x0037, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0162  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<com.kakaogame.KGKakaoInvitation.KGInvitationReceviersResponse> loadReceivers(int r21) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoInvitation.loadReceivers(int):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadInvitableFriendProfiles(int recommendLimit, int offset, int limit, KGResultCallback<KGKakaoProfile.KGKakaoFriendsResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$loadInvitableFriendProfiles$1(recommendLimit, offset, limit, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendInviteMessage(int eventId, KGKakaoProfile kakaoProfile, String templateId, Map<String, String> args, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitation$sendInviteMessage$1(eventId, kakaoProfile, templateId, args, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> sendInviteMessage(int eventId, KGKakaoProfile kakaoProfile, String templateId, Map<String, String> args) {
        KGResult<Void> result;
        KGResult<Void> result2;
        String str = y.ٲٴݴ״ٰ(1782036808);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ݮڮֲڭܩ(-628714836));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                result2 = KGResult.INSTANCE.getResult(3002);
            } else {
                KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                Intrinsics.checkNotNull(currentPlayer);
                KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
                Intrinsics.checkNotNull(idpProfile);
                if (idpProfile.getIdpCode() != KGIdpProfile.KGIdpCode.Kakao) {
                    KGResult.Companion companion = KGResult.INSTANCE;
                    StringBuilder sb = new StringBuilder(str);
                    KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    Intrinsics.checkNotNull(currentPlayer2);
                    KGIdpProfile idpProfile2 = currentPlayer2.getIdpProfile();
                    Intrinsics.checkNotNull(idpProfile2);
                    result2 = companion.getResult(5001, sb.append(idpProfile2.getIdpCode()).toString());
                } else if (kakaoProfile == null) {
                    result2 = KGResult.INSTANCE.getResult(4000, "kakaoProfile is null");
                } else {
                    if (!TextUtils.isEmpty(templateId)) {
                        String memberKey = kakaoProfile.getMemberKey();
                        String impressionId = kakaoProfile.getImpressionId();
                        Intrinsics.checkNotNull(args);
                        result = sendRequestWithScope(InhouseGWService.getSendInvitationTalkMessageRequest(eventId, memberKey, impressionId, templateId, args));
                        KakaoUtil.convertResultCode(result);
                        start.stop();
                        KakaoUtil.convertResultCode(result);
                        KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
                        return result;
                    }
                    result2 = KGResult.INSTANCE.getResult(4000, "templateId is null");
                }
            }
            start.stop();
            KakaoUtil.convertResultCode(result2);
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KakaoUtil.convertResultCode(null);
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> sendRequestWithScope(ServerRequest requestData) {
        ServerResult requestServer$default = ServerService.requestServer$default(requestData, 0, 2, null);
        if (!requestServer$default.isSuccess()) {
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            String str = y.دײܮڳܯ(2051777077);
            if (content.containsKey((Object) str)) {
                Object obj = content.get((Object) str);
                Intrinsics.checkNotNull(obj, y.ݮڮֲڭܩ(-628714340));
                List<String> list = (List) obj;
                Logger logger = Logger.INSTANCE;
                String str2 = y.٬ݯح׭٩(575760134) + list;
                String str3 = y.دײܮڳܯ(2051780269);
                logger.m699d(str3, str2);
                KGResult<String> updateScope = KGKakao2Auth.INSTANCE.updateScope(CoreManager.INSTANCE.getInstance().getActivity(), list);
                if (updateScope.isSuccess()) {
                    ServerResult requestServer$default2 = ServerService.requestServer$default(requestData, 0, 2, null);
                    if (!requestServer$default2.isSuccess()) {
                        return KGResult.INSTANCE.getResult(requestServer$default2);
                    }
                } else {
                    Logger.INSTANCE.m699d(str3, y.ݮڮֲڭܩ(-628713572) + updateScope);
                    return KGResult.INSTANCE.getResult(9001, y.ٲٴݴ״ٰ(1782031224));
                }
            } else {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862270107), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadEvents;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                loadEvents = KGKakaoInvitation.INSTANCE.loadEvents();
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.ۮڭڭܬި(862267939), loadEvents);
                if (loadEvents.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadEvents);
                }
                List list = (List) loadEvents.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628787420), list);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781812184), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadSendersCount;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                Intrinsics.checkNotNull(number);
                loadSendersCount = KGKakaoInvitation.INSTANCE.loadSendersCount(number.intValue());
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.ݬֲ֮ܲت(1512601503), loadSendersCount);
                if (loadSendersCount.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadSendersCount);
                }
                Object content = loadSendersCount.getContent();
                Intrinsics.checkNotNull(content);
                int intValue = ((Number) content).intValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575838374), Integer.valueOf(intValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392596546), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadReceiversCount;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                Intrinsics.checkNotNull(number);
                loadReceiversCount = KGKakaoInvitation.INSTANCE.loadReceiversCount(number.intValue());
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.دײܮڳܯ(2051563197), loadReceiversCount);
                if (loadReceiversCount.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadReceiversCount);
                }
                KGKakaoInvitation.KGInvitationReceviersCountResponse kGInvitationReceviersCountResponse = (KGKakaoInvitation.KGInvitationReceviersCountResponse) loadReceiversCount.getContent();
                Intrinsics.checkNotNull(kGInvitationReceviersCountResponse);
                int totalReceiversCount = kGInvitationReceviersCountResponse.getTotalReceiversCount();
                int joinersCount = kGInvitationReceviersCountResponse.getJoinersCount();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݮڮֲڭܩ(-628790980), Integer.valueOf(totalReceiversCount));
                linkedHashMap.put("joinersCount", Integer.valueOf(joinersCount));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159656895), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadSenders;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                Intrinsics.checkNotNull(number);
                loadSenders = KGKakaoInvitation.INSTANCE.loadSenders(number.intValue());
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.٬ݯح׭٩(575838758), loadSenders);
                if (loadSenders.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadSenders);
                }
                List list = (List) loadSenders.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575838798), list);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392595194), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadReceivers;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                Intrinsics.checkNotNull(number);
                loadReceivers = KGKakaoInvitation.INSTANCE.loadReceivers(number.intValue());
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.ݮڮֲڭܩ(-628790460), loadReceivers);
                if (loadReceivers.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadReceivers);
                }
                KGKakaoInvitation.KGInvitationReceviersResponse kGInvitationReceviersResponse = (KGKakaoInvitation.KGInvitationReceviersResponse) loadReceivers.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGInvitationReceviersResponse);
                linkedHashMap.put(y.ۮڭڭܬި(862269083), kGInvitationReceviersResponse.getJoiners());
                linkedHashMap.put(y.ݬֲ֮ܲت(1512598639), kGInvitationReceviersResponse.getInvitees());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051560365), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter("offset");
                Intrinsics.checkNotNull(number);
                int intValue = number.intValue();
                Number number2 = (Number) request.getParameter(y.ݮڮֲڭܩ(-628790308));
                Intrinsics.checkNotNull(number2);
                int intValue2 = number2.intValue();
                Number number3 = (Number) request.getParameter(y.֬ڱܱײٮ(-1159658759));
                Intrinsics.checkNotNull(number3);
                KGResult<KGKakaoProfile.KGKakaoFriendsResponse> loadInvitableFriendProfilesV4 = KakaoGameAPI.INSTANCE.loadInvitableFriendProfilesV4(number3.intValue(), intValue, intValue2);
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.ݬֲ֮ܲت(1512600543), loadInvitableFriendProfilesV4);
                if (!loadInvitableFriendProfilesV4.isSuccess()) {
                    return KGResult.INSTANCE.getResult(loadInvitableFriendProfilesV4);
                }
                KGKakaoProfile.KGKakaoFriendsResponse content = loadInvitableFriendProfilesV4.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(content);
                linkedHashMap.put(y.ۮڭڭܬި(862269467), Integer.valueOf(content.getTotalCount()));
                linkedHashMap.put(y.ٴسسݬߨ(1392597458), content.getFriendList());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159655751), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitation$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> sendInviteMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                Intrinsics.checkNotNull(number);
                sendInviteMessage = KGKakaoInvitation.INSTANCE.sendInviteMessage(number.intValue(), new KGKakaoProfile((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.ۮڭڭܬި(862270259)))), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                FirebaseEvent.INSTANCE.sendEvent(y.ٴسسݬߨ(1392591394), y.֬ڱܱײٮ(-1159657655), sendInviteMessage);
                return sendInviteMessage;
            }
        });
    }

    /* compiled from: KGKakaoInvitation.kt */
    @Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitation$KGKakaoEvent;", "Lcom/kakaogame/KGObject;", NotificationCompat.CATEGORY_EVENT, "", "", "", "(Ljava/util/Map;)V", KGKakaoEvent.UNUTY_DESCRIPTION, "getEventDescription", "()Ljava/lang/String;", KGKakaoEvent.UNUTY_EVENT_ID, "", "getEventId", "()I", KGKakaoEvent.UNUTY_FINISH_TIME, "", "getFinishTime", "()J", "startTime", "getStartTime", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGKakaoEvent extends KGObject {
        public static final String DESCRIPTION = "description";
        public static final String EVENT_ID = "invitationEventId";
        public static final String FINISH_TIME = "endTime";
        public static final String START_TIME = "beginTime";
        public static final String UNUTY_DESCRIPTION = "eventDescription";
        public static final String UNUTY_EVENT_ID = "eventId";
        public static final String UNUTY_FINISH_TIME = "finishTime";
        public static final String UNUTY_START_TIME = "startTime";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGKakaoEvent(Map<String, Object> map) {
            super(map);
            put(y.ۮڭڭܬި(862267763), Integer.valueOf(getEventId()));
            put(y.ݮڮֲڭܩ(-628788004), Long.valueOf(getStartTime()));
            put(y.دײܮڳܯ(2051555989), Long.valueOf(getFinishTime()));
            put(UNUTY_DESCRIPTION, getEventDescription());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getEventId() {
            String str = y.٬ݯح׭٩(575833462);
            if (!containsKey(str)) {
                return -1;
            }
            Number number = (Number) get(str);
            if (number == null) {
                number = (Number) (-1);
            }
            return number.intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getStartTime() {
            String str = y.٬ݯح׭٩(575833622);
            if (!containsKey(str)) {
                return 0L;
            }
            Number number = (Number) get(str);
            if (number == null) {
                number = (Number) 0L;
            }
            return number.longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getFinishTime() {
            String str = y.٬ݯح׭٩(575833582);
            if (!containsKey(str)) {
                return 0L;
            }
            Number number = (Number) get(str);
            if (number == null) {
                number = (Number) 0L;
            }
            return number.longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getEventDescription() {
            return (String) get(y.ٴسسݬߨ(1392801274));
        }
    }

    /* compiled from: KGKakaoInvitation.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersCountResponse;", "", "totalReceiversCount", "", "joinersCount", "(II)V", "getJoinersCount", "()I", "getTotalReceiversCount", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGInvitationReceviersCountResponse {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int joinersCount;
        private final int totalReceiversCount;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGInvitationReceviersCountResponse(int i, int i2) {
            this.totalReceiversCount = i;
            this.joinersCount = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalReceiversCount() {
            return this.totalReceiversCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getJoinersCount() {
            return this.joinersCount;
        }

        /* compiled from: KGKakaoInvitation.kt */
        @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersCountResponse$Companion;", "", "()V", "emptyResponse", "Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersCountResponse;", "getEmptyResponse", "()Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersCountResponse;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private final KGInvitationReceviersCountResponse getEmptyResponse() {
                return new KGInvitationReceviersCountResponse(0, 0);
            }
        }
    }

    /* compiled from: KGKakaoInvitation.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersResponse;", "", "joiners", "", "Lcom/kakaogame/KGPlayer;", "invitees", "Lcom/kakaogame/KGKakaoProfile;", "(Ljava/util/List;Ljava/util/List;)V", "getInvitees", "()Ljava/util/List;", "getJoiners", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGInvitationReceviersResponse {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<KGKakaoProfile> invitees;
        private final List<KGPlayer> joiners;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGInvitationReceviersResponse(List<? extends KGPlayer> list, List<KGKakaoProfile> list2) {
            Intrinsics.checkNotNullParameter(list, y.ۮڭڭܬި(862269083));
            Intrinsics.checkNotNullParameter(list2, y.ݬֲ֮ܲت(1512598639));
            this.joiners = list;
            this.invitees = list2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGPlayer> getJoiners() {
            return this.joiners;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGKakaoProfile> getInvitees() {
            return this.invitees;
        }

        /* compiled from: KGKakaoInvitation.kt */
        @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersResponse$Companion;", "", "()V", "emptyResponse", "Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersResponse;", "getEmptyResponse", "()Lcom/kakaogame/KGKakaoInvitation$KGInvitationReceviersResponse;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private final KGInvitationReceviersResponse getEmptyResponse() {
                return new KGInvitationReceviersResponse(new ArrayList(), new ArrayList());
            }
        }
    }
}
