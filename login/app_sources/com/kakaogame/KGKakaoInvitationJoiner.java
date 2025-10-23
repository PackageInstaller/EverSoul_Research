package com.kakaogame;

import android.app.Activity;
import com.kakao.sdk.talk.model.Friend;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.game.model.InvitationState;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoInvitationJoiner.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationJoiner;", "Lcom/kakaogame/KGObject;", "player", "Lcom/kakaogame/KGPlayer;", "state", "Lcom/kakaogame/game/model/InvitationState;", "(Lcom/kakaogame/KGPlayer;Lcom/kakaogame/game/model/InvitationState;)V", KGKakaoInvitationJoiner.KEY_HOST_REWARD_CODE, "", "getHostRewardCode", "()Ljava/lang/String;", KGKakaoInvitationJoiner.KEY_HOST_REWARD_STATE, "Lcom/kakaogame/KGKakaoInvitationJoiner$KGKakaoInvitationRewardState;", "getHostRewardState", "()Lcom/kakaogame/KGKakaoInvitationJoiner$KGKakaoInvitationRewardState;", KGKakaoInvitationJoiner.KEY_JOIN_REWARD_CODE, "getJoinRewardCode", KGKakaoInvitationJoiner.KEY_JOIN_REWARD_STATE, "getJoinRewardState", KGKakaoInvitationJoiner.KEY_JOIN_TIME, "", "getJoinTime", "()J", "getPlayer", "()Lcom/kakaogame/KGPlayer;", "Companion", "KGKakaoInvitationRewardState", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoInvitationJoiner extends KGObject {
    private static final String CLASS_NAME_KEY = "KGKakaoInvitationJoiner";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_HOST_REWARD_CODE = "hostRewardCode";
    private static final String KEY_HOST_REWARD_STATE = "hostRewardState";
    private static final String KEY_JOIN_REWARD_CODE = "joinRewardCode";
    private static final String KEY_JOIN_REWARD_STATE = "joinRewardState";
    private static final String KEY_JOIN_TIME = "joinTime";
    private static final String KEY_PLAYER = "player";
    private static final String TAG = "KGKakaoInvitationJoiner";
    private static final long serialVersionUID = -3418159848737337412L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KGKakaoInvitationJoiner(KGPlayer kGPlayer, InvitationState invitationState, DefaultConstructorMarker defaultConstructorMarker) {
        this(kGPlayer, invitationState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadInvitationJoiners(int i, KGResultCallback<List<KGKakaoInvitationJoiner>> kGResultCallback) {
        INSTANCE.loadInvitationJoiners(i, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoInvitationJoiner(KGPlayer kGPlayer, InvitationState invitationState) {
        super(null, 1, null);
        put(y.ۮڭڭܬި(862276451), kGPlayer);
        put(KEY_HOST_REWARD_CODE, invitationState.getSenderReward());
        String senderRewardState = invitationState.getSenderRewardState();
        for (KGKakaoInvitationRewardState kGKakaoInvitationRewardState : KGKakaoInvitationRewardState.values()) {
            if (StringsKt.equals(kGKakaoInvitationRewardState.getCode(), senderRewardState, true)) {
                put(y.֬ڱܱײٮ(-1159536879), kGKakaoInvitationRewardState.name());
            }
        }
        put(KEY_JOIN_REWARD_CODE, invitationState.getReceiverReward());
        String receiverRewardState = invitationState.getReceiverRewardState();
        for (KGKakaoInvitationRewardState kGKakaoInvitationRewardState2 : KGKakaoInvitationRewardState.values()) {
            if (StringsKt.equals(kGKakaoInvitationRewardState2.getCode(), receiverRewardState, true)) {
                put(y.ٴسسݬߨ(1392673514), kGKakaoInvitationRewardState2.name());
            }
        }
        put(y.ݮڮֲڭܩ(-628705428), Long.valueOf(KakaoUtil.parseInvitataionDateForJoiner(invitationState.getCreatedAt())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGPlayer getPlayer() {
        return (KGPlayer) get(y.ۮڭڭܬި(862276451));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getHostRewardCode() {
        return (String) get(y.֬ڱܱײٮ(-1159534711));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGKakaoInvitationRewardState getHostRewardState() {
        String str = (String) get(y.֬ڱܱײٮ(-1159536879));
        for (KGKakaoInvitationRewardState kGKakaoInvitationRewardState : KGKakaoInvitationRewardState.values()) {
            if (StringsKt.equals(kGKakaoInvitationRewardState.name(), str, true)) {
                return kGKakaoInvitationRewardState;
            }
        }
        return KGKakaoInvitationRewardState.NotRewarded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getJoinRewardCode() {
        return (String) get(y.٬ݯح׭٩(575766278));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGKakaoInvitationRewardState getJoinRewardState() {
        String str = (String) get(y.ٴسسݬߨ(1392673514));
        for (KGKakaoInvitationRewardState kGKakaoInvitationRewardState : KGKakaoInvitationRewardState.values()) {
            if (StringsKt.equals(kGKakaoInvitationRewardState.name(), str, true)) {
                return kGKakaoInvitationRewardState;
            }
        }
        return KGKakaoInvitationRewardState.NotRewarded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getJoinTime() {
        Object obj = get(y.ݮڮֲڭܩ(-628705428));
        Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
        return ((Long) obj).longValue();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGKakaoInvitationJoiner.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationJoiner$KGKakaoInvitationRewardState;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "NotRewarded", "Rewarded", "ExceedRewardCount", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGKakaoInvitationRewardState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGKakaoInvitationRewardState[] $VALUES;
        private final String code;
        public static final KGKakaoInvitationRewardState NotRewarded = new KGKakaoInvitationRewardState(y.֬ڱܱײٮ(-1159537159), 0, y.دײܮڳܯ(2051900013));
        public static final KGKakaoInvitationRewardState Rewarded = new KGKakaoInvitationRewardState(y.ٴسسݬߨ(1392673138), 1, y.ۮڭڭܬި(862235827));
        public static final KGKakaoInvitationRewardState ExceedRewardCount = new KGKakaoInvitationRewardState(y.֬ڱܱײٮ(-1159537495), 2, y.֬ڱܱײٮ(-1159537599));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGKakaoInvitationRewardState[] $values() {
            return new KGKakaoInvitationRewardState[]{NotRewarded, Rewarded, ExceedRewardCount};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGKakaoInvitationRewardState> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGKakaoInvitationRewardState valueOf(String str) {
            return (KGKakaoInvitationRewardState) Enum.valueOf(KGKakaoInvitationRewardState.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGKakaoInvitationRewardState[] values() {
            return (KGKakaoInvitationRewardState[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGKakaoInvitationRewardState(String str, int i, String str2) {
            this.code = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCode() {
            return this.code;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGKakaoInvitationRewardState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: KGKakaoInvitationJoiner.kt */
    @Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationJoiner$Companion;", "", "()V", "CLASS_NAME_KEY", "", "KEY_HOST_REWARD_CODE", "KEY_HOST_REWARD_STATE", "KEY_JOIN_REWARD_CODE", "KEY_JOIN_REWARD_STATE", "KEY_JOIN_TIME", "KEY_PLAYER", "TAG", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "loadInvitationJoiners", "Lcom/kakaogame/KGResult;", "", "Lcom/kakaogame/KGKakaoInvitationJoiner;", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "", "callback", "Lcom/kakaogame/KGResultCallback;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final void loadInvitationJoiners(int eventId, KGResultCallback<List<KGKakaoInvitationJoiner>> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitationJoiner$Companion$loadInvitationJoiners$1(eventId, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [com.kakaogame.KGIdpProfile$KGIdpCode] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<List<KGKakaoInvitationJoiner>> loadInvitationJoiners(int eventId) {
            KGResult<List<KGKakaoInvitationJoiner>> result;
            KGResult<List<InvitationState>> requestInvitationStates;
            KGIdpProfile idpProfile;
            KGIdpProfile idpProfile2;
            Logger logger = Logger.INSTANCE;
            String str = y.ٲٴݴ״ٰ(1782026392) + eventId;
            String str2 = y.ۮڭڭܬި(862383579);
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
            Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159538079));
            try {
                try {
                    requestInvitationStates = KakaoGameAPI.INSTANCE.requestInvitationStates(eventId);
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                }
                if (requestInvitationStates.isNotSuccess()) {
                    KGResult<List<KGKakaoInvitationJoiner>> result2 = KGResult.INSTANCE.getResult(requestInvitationStates);
                    start.stop();
                    KakaoUtil.convertResultCode(result2);
                    KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                    return result2;
                }
                ArrayList arrayList = new ArrayList();
                List<InvitationState> content = requestInvitationStates.getContent();
                if (content != null) {
                    for (InvitationState invitationState : content) {
                        Long userId = invitationState.getUserId();
                        Intrinsics.checkNotNull(userId);
                        String valueOf = String.valueOf(userId.longValue());
                        KGResult<KGPlayer> loadPlayer = KGPlayer.INSTANCE.loadPlayer(KGIdpProfile.KGIdpCode.Kakao.getCode(), valueOf);
                        if (loadPlayer.isNotSuccess()) {
                            KGResult<List<KGKakaoInvitationJoiner>> result3 = KGResult.INSTANCE.getResult(loadPlayer);
                            start.stop();
                            KakaoUtil.convertResultCode(result3);
                            KGResultUtil.writeClientApiCall(start.getName(), result3, start.getDurationMs());
                            return result3;
                        }
                        KGPlayer content2 = loadPlayer.getContent();
                        if (content2 != null) {
                            Friend gameFriendInfo = KakaoGameAPI.getGameFriendInfo(valueOf);
                            content2.setIdpProfile(gameFriendInfo != null ? new KGKakaoProfile(gameFriendInfo) : new KGKakaoProfile(valueOf, invitationState.getNickname(), invitationState.getProfileImageUrl()));
                            arrayList.add(new KGKakaoInvitationJoiner(content2, invitationState, defaultConstructorMarker));
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
            InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051770309), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitationJoiner$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult loadInvitationJoiners;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                    Intrinsics.checkNotNull(number);
                    loadInvitationJoiners = KGKakaoInvitationJoiner.INSTANCE.loadInvitationJoiners(number.intValue());
                    if (loadInvitationJoiners.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadInvitationJoiners);
                    }
                    List list = (List) loadInvitationJoiners.getContent();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ٲٴݴ״ٰ(1782027400), list);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }
    }
}
