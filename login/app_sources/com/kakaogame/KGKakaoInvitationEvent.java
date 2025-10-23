package com.kakaogame;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.game.model.InvitationEvent;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoInvitationEvent.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\bR\u0011\u0010\u001a\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\b¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationEvent;", "Lcom/kakaogame/KGObject;", NotificationCompat.CATEGORY_EVENT, "Lcom/kakaogame/game/model/InvitationEvent;", "(Lcom/kakaogame/game/model/InvitationEvent;)V", "eventId", "", "getEventId", "()I", "finishTime", "", "getFinishTime", "()J", KGKakaoInvitationEvent.KEY_HOST_REWARD_CODE, "", "getHostRewardCode", "()Ljava/lang/String;", KGKakaoInvitationEvent.KEY_INVITATION_URL, "getInvitationUrl", KGKakaoInvitationEvent.KEY_EVENT_CARD_ENABLED, "", "()Z", KGKakaoInvitationEvent.KEY_JOIN_REWARD_CODE, "getJoinRewardCode", KGKakaoInvitationEvent.KEY_MAX_HOST_REWARD_COUNT, "getMaxHostRewardCount", "startTime", "getStartTime", KGKakaoInvitationEvent.KEY_TOTAL_JOINER_COUNT, "getTotalJoinerCount", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoInvitationEvent extends KGObject {
    private static final String CLASS_NAME_KEY = "KGKakaoInvitationEvent";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_EVENT_CARD_ENABLED = "isEventCardEnabled";
    private static final String KEY_EVENT_ID = "eventId";
    private static final String KEY_FINISH_TIME = "finishTime";
    private static final String KEY_HOST_REWARD_CODE = "hostRewardCode";
    private static final String KEY_INVITATION_URL = "invitationUrl";
    private static final String KEY_JOIN_REWARD_CODE = "joinRewardCode";
    private static final String KEY_MAX_HOST_REWARD_COUNT = "maxHostRewardCount";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_TOTAL_JOINER_COUNT = "totalJoinerCount";
    private static final String TAG = "KGKakaoInvitationEvent";
    private static final long serialVersionUID = 4679516182408282457L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KGKakaoInvitationEvent(InvitationEvent invitationEvent, DefaultConstructorMarker defaultConstructorMarker) {
        this(invitationEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadInvitationEvents(KGResultCallback<List<KGKakaoInvitationEvent>> kGResultCallback) {
        INSTANCE.loadInvitationEvents(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoInvitationEvent(InvitationEvent invitationEvent) {
        super(null, 1, null);
        Integer id = invitationEvent.getId();
        String str = y.ۮڭڭܬި(862267763);
        if (id != null) {
            put(str, invitationEvent.getId());
        } else {
            put(str, -1);
        }
        Boolean enabled = invitationEvent.getEnabled();
        String str2 = y.ۮڭڭܬި(862376003);
        if (enabled != null) {
            put(str2, invitationEvent.getEnabled());
        } else {
            put(str2, false);
        }
        put(y.ݮڮֲڭܩ(-628788004), Long.valueOf(KakaoUtil.parseInvitataionDate(invitationEvent.getStartsAt())));
        put(y.دײܮڳܯ(2051555989), Long.valueOf(KakaoUtil.parseInvitataionDate(invitationEvent.getEndsAt())));
        Integer maxSenderRewardsCount = invitationEvent.getMaxSenderRewardsCount();
        String str3 = y.ۮڭڭܬި(862376739);
        if (maxSenderRewardsCount != null) {
            put(str3, invitationEvent.getMaxSenderRewardsCount());
        } else {
            put(str3, 0);
        }
        put(y.֬ڱܱײٮ(-1159534711), invitationEvent.getSenderReward());
        put(y.٬ݯح׭٩(575766278), invitationEvent.getReceiverReward());
        put(y.ݮڮֲڭܩ(-628715548), invitationEvent.getInvitationUrl());
        Integer totalReceiversCount = invitationEvent.getTotalReceiversCount();
        String str4 = y.ۮڭڭܬި(862379291);
        if (totalReceiversCount != null) {
            put(str4, invitationEvent.getTotalReceiversCount());
        } else {
            put(str4, 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getEventId() {
        Object obj = get(y.ۮڭڭܬި(862267763));
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isEventCardEnabled() {
        Object obj = get(y.ۮڭڭܬި(862376003));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getStartTime() {
        Object obj = get(y.ݮڮֲڭܩ(-628788004));
        Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
        return ((Long) obj).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getFinishTime() {
        Object obj = get(y.دײܮڳܯ(2051555989));
        Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
        return ((Long) obj).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMaxHostRewardCount() {
        Object obj = get(y.ۮڭڭܬި(862376739));
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getHostRewardCode() {
        return (String) get(y.֬ڱܱײٮ(-1159534711));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getJoinRewardCode() {
        return (String) get(y.٬ݯح׭٩(575766278));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getInvitationUrl() {
        return (String) get(y.ݮڮֲڭܩ(-628715548));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTotalJoinerCount() {
        Object obj = get(y.ۮڭڭܬި(862379291));
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* compiled from: KGKakaoInvitationEvent.kt */
    @Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u0015H\u0002J \u0010\u0014\u001a\u00020\u00122\u0016\u0010\u0018\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0018\u00010\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationEvent$Companion;", "", "()V", "CLASS_NAME_KEY", "", "KEY_EVENT_CARD_ENABLED", "KEY_EVENT_ID", "KEY_FINISH_TIME", "KEY_HOST_REWARD_CODE", "KEY_INVITATION_URL", "KEY_JOIN_REWARD_CODE", "KEY_MAX_HOST_REWARD_COUNT", "KEY_START_TIME", "KEY_TOTAL_JOINER_COUNT", "TAG", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "loadInvitationEvents", "Lcom/kakaogame/KGResult;", "", "Lcom/kakaogame/KGKakaoInvitationEvent;", "callback", "Lcom/kakaogame/KGResultCallback;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadInvitationEvents(KGResultCallback<List<KGKakaoInvitationEvent>> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitationEvent$Companion$loadInvitationEvents$1(callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v4, types: [com.kakaogame.KGIdpProfile$KGIdpCode] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<List<KGKakaoInvitationEvent>> loadInvitationEvents() {
            KGResult<List<KGKakaoInvitationEvent>> result;
            KGResult<List<InvitationEvent>> requestInvitationEventList;
            KGIdpProfile idpProfile;
            KGIdpProfile idpProfile2;
            Logger logger = Logger.INSTANCE;
            String str = y.ٲٴݴ״ٰ(1782031056);
            String str2 = y.دײܮڳܯ(2051780269);
            logger.m699d(str2, str);
            KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            DefaultConstructorMarker defaultConstructorMarker = null;
            defaultConstructorMarker = null;
            if (kGIdpCode != ((currentPlayer == null || (idpProfile2 = currentPlayer.getIdpProfile()) == null) ? null : idpProfile2.getIdpCode())) {
                KGResult.Companion companion = KGResult.INSTANCE;
                StringBuilder sb = new StringBuilder(y.ٲٴݴ״ٰ(1782036808));
                KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                if (currentPlayer2 != null && (idpProfile = currentPlayer2.getIdpProfile()) != null) {
                    defaultConstructorMarker = idpProfile.getIdpCode();
                }
                return companion.getResult(5001, sb.append(defaultConstructorMarker).toString());
            }
            Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159535311));
            try {
                try {
                    requestInvitationEventList = KakaoGameAPI.INSTANCE.requestInvitationEventList();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                }
                if (requestInvitationEventList.isNotSuccess()) {
                    KGResult<List<KGKakaoInvitationEvent>> result2 = KGResult.INSTANCE.getResult(requestInvitationEventList);
                    start.stop();
                    KakaoUtil.convertResultCode(result2);
                    KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                    return result2;
                }
                ArrayList arrayList = new ArrayList();
                List<InvitationEvent> content = requestInvitationEventList.getContent();
                if (content != null) {
                    for (InvitationEvent invitationEvent : content) {
                        KakaoGameAPI kakaoGameAPI = KakaoGameAPI.INSTANCE;
                        Integer id = invitationEvent.getId();
                        Intrinsics.checkNotNull(id);
                        KGResult<InvitationEvent> requestInvitationEvent = kakaoGameAPI.requestInvitationEvent(id.intValue());
                        if (requestInvitationEvent.isNotSuccess()) {
                            KGResult<List<KGKakaoInvitationEvent>> result3 = KGResult.INSTANCE.getResult(requestInvitationEvent);
                            start.stop();
                            KakaoUtil.convertResultCode(null);
                            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                            return result3;
                        }
                        InvitationEvent content2 = requestInvitationEvent.getContent();
                        if (content2 != null) {
                            arrayList.add(new KGKakaoInvitationEvent(content2, defaultConstructorMarker));
                        }
                    }
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
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512805871), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitationEvent$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult loadInvitationEvents;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    loadInvitationEvents = KGKakaoInvitationEvent.INSTANCE.loadInvitationEvents();
                    if (loadInvitationEvents.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadInvitationEvents);
                    }
                    List list = (List) loadInvitationEvents.getContent();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ݮڮֲڭܩ(-628787420), list);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }
    }
}
