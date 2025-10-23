package com.kakaogame;

import android.app.Activity;
import com.kakao.sdk.talk.model.Friend;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.game.model.InvitationSender;
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

/* compiled from: KGKakaoInvitationHost.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationHost;", "Lcom/kakaogame/KGObject;", "player", "Lcom/kakaogame/KGPlayer;", KGKakaoInvitationHost.KEY_TOTAL_JOINER_COUNT, "", "(Lcom/kakaogame/KGPlayer;Ljava/lang/Integer;)V", "getPlayer", "()Lcom/kakaogame/KGPlayer;", "getTotalJoinerCount", "()I", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoInvitationHost extends KGObject {
    private static final String CLASS_NAME_KEY = "KGKakaoInvitationHost";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_PLAYER = "player";
    private static final String KEY_TOTAL_JOINER_COUNT = "totalJoinerCount";
    private static final String TAG = "KGKakaoInvitationHost";
    private static final long serialVersionUID = -1340302978732568119L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KGKakaoInvitationHost(KGPlayer kGPlayer, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(kGPlayer, num);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadInvitationHost(int i, KGResultCallback<KGKakaoInvitationHost> kGResultCallback) {
        INSTANCE.loadInvitationHost(i, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadInvitationHosts(int i, KGResultCallback<List<KGKakaoInvitationHost>> kGResultCallback) {
        INSTANCE.loadInvitationHosts(i, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoInvitationHost(KGPlayer kGPlayer, Integer num) {
        super(null, 1, null);
        put(y.ۮڭڭܬި(862276451), kGPlayer);
        if (num != null) {
            put(KEY_TOTAL_JOINER_COUNT, num);
        } else {
            put(KEY_TOTAL_JOINER_COUNT, 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGPlayer getPlayer() {
        return (KGPlayer) get(y.ۮڭڭܬި(862276451));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTotalJoinerCount() {
        Object obj = get(y.ۮڭڭܬި(862379291));
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* compiled from: KGKakaoInvitationHost.kt */
    @Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0013H\u0007J\u001e\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00150\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015\u0018\u00010\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/KGKakaoInvitationHost$Companion;", "", "()V", "CLASS_NAME_KEY", "", "KEY_PLAYER", "KEY_TOTAL_JOINER_COUNT", "TAG", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "loadInvitationHost", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/KGKakaoInvitationHost;", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "", "callback", "Lcom/kakaogame/KGResultCallback;", "loadInvitationHosts", "", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final void loadInvitationHost(int eventId, KGResultCallback<KGKakaoInvitationHost> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitationHost$Companion$loadInvitationHost$1(eventId, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [com.kakaogame.KGIdpProfile$KGIdpCode] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<KGKakaoInvitationHost> loadInvitationHost(int eventId) {
            KGResult<KGKakaoInvitationHost> result;
            KGResult<InvitationSender> requestInvitationSender;
            KGIdpProfile idpProfile;
            KGIdpProfile idpProfile2;
            Logger logger = Logger.INSTANCE;
            String str = y.ٲٴݴ״ٰ(1782026392) + eventId;
            String str2 = y.٬ݯح׭٩(575764246);
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
            Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575753230));
            try {
                try {
                    requestInvitationSender = KakaoGameAPI.INSTANCE.requestInvitationSender(eventId);
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                }
                if (requestInvitationSender.isNotSuccess()) {
                    KGResult<KGKakaoInvitationHost> result2 = KGResult.INSTANCE.getResult(requestInvitationSender);
                    start.stop();
                    KakaoUtil.convertResultCode(result2);
                    KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                    return result2;
                }
                InvitationSender content = requestInvitationSender.getContent();
                if (content == null) {
                    KGResult<KGKakaoInvitationHost> successResult = KGResult.INSTANCE.getSuccessResult(null);
                    start.stop();
                    KakaoUtil.convertResultCode(successResult);
                    KGResultUtil.writeClientApiCall(start.getName(), successResult, start.getDurationMs());
                    return successResult;
                }
                Long userId = content.getUserId();
                Intrinsics.checkNotNull(userId);
                String valueOf = String.valueOf(userId.longValue());
                KGResult<KGPlayer> loadPlayer = KGPlayer.INSTANCE.loadPlayer(KGIdpProfile.KGIdpCode.Kakao.getCode(), valueOf);
                if (loadPlayer.isNotSuccess()) {
                    KGResult<KGKakaoInvitationHost> result3 = KGResult.INSTANCE.getResult(loadPlayer);
                    start.stop();
                    KakaoUtil.convertResultCode(result3);
                    KGResultUtil.writeClientApiCall(start.getName(), result3, start.getDurationMs());
                    return result3;
                }
                KGPlayer content2 = loadPlayer.getContent();
                if (content2 == null) {
                    KGResult<KGKakaoInvitationHost> successResult2 = KGResult.INSTANCE.getSuccessResult(null);
                    start.stop();
                    KakaoUtil.convertResultCode(successResult2);
                    KGResultUtil.writeClientApiCall(start.getName(), successResult2, start.getDurationMs());
                    return successResult2;
                }
                Friend gameFriendInfo = KakaoGameAPI.getGameFriendInfo(valueOf);
                content2.setIdpProfile(gameFriendInfo != null ? new KGKakaoProfile(gameFriendInfo) : new KGKakaoProfile(valueOf, content.getNickname(), content.getProfileImageUrl()));
                result = KGResult.INSTANCE.getSuccessResult(new KGKakaoInvitationHost(content2, content.getTotalReceiversCount(), defaultConstructorMarker));
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
        public final void loadInvitationHosts(int eventId, KGResultCallback<List<KGKakaoInvitationHost>> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoInvitationHost$Companion$loadInvitationHosts$1(eventId, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.kakaogame.KGIdpProfile$KGIdpCode] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<List<KGKakaoInvitationHost>> loadInvitationHosts(int eventId) {
            KGResult<List<KGKakaoInvitationHost>> result;
            KGResult<List<InvitationSender>> requestInvitationSenderList;
            KGIdpProfile idpProfile;
            KGIdpProfile idpProfile2;
            Logger logger = Logger.INSTANCE;
            String str = y.ݮڮֲڭܩ(-628703780);
            String str2 = y.٬ݯح׭٩(575764246);
            logger.m699d(str2, str + eventId);
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
            Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575753846));
            try {
                try {
                    requestInvitationSenderList = KakaoGameAPI.INSTANCE.requestInvitationSenderList(eventId);
                    Logger.INSTANCE.m699d(str2, str + requestInvitationSenderList);
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                }
                if (requestInvitationSenderList.isNotSuccess()) {
                    KGResult<List<KGKakaoInvitationHost>> result2 = KGResult.INSTANCE.getResult(requestInvitationSenderList);
                    start.stop();
                    KakaoUtil.convertResultCode(result2);
                    KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                    return result2;
                }
                List<InvitationSender> content = requestInvitationSenderList.getContent();
                Intrinsics.checkNotNull(content);
                ArrayList arrayList = new ArrayList();
                for (InvitationSender invitationSender : content) {
                    Long userId = invitationSender.getUserId();
                    Intrinsics.checkNotNull(userId);
                    String valueOf = String.valueOf(userId.longValue());
                    KGResult<KGPlayer> loadPlayer = KGPlayer.INSTANCE.loadPlayer(KGIdpProfile.KGIdpCode.Kakao.getCode(), valueOf);
                    if (loadPlayer.isNotSuccess()) {
                        KGResult<List<KGKakaoInvitationHost>> result3 = KGResult.INSTANCE.getResult(loadPlayer);
                        start.stop();
                        KakaoUtil.convertResultCode(result3);
                        KGResultUtil.writeClientApiCall(start.getName(), result3, start.getDurationMs());
                        return result3;
                    }
                    KGPlayer content2 = loadPlayer.getContent();
                    if (content2 != null) {
                        Friend gameFriendInfo = KakaoGameAPI.getGameFriendInfo(valueOf);
                        content2.setIdpProfile(gameFriendInfo != null ? new KGKakaoProfile(gameFriendInfo) : new KGKakaoProfile(valueOf, invitationSender.getNickname(), invitationSender.getProfileImageUrl()));
                        arrayList.add(new KGKakaoInvitationHost(content2, invitationSender.getTotalReceiversCount(), defaultConstructorMarker));
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
            InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159540295), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitationHost$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult loadInvitationHost;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                    Intrinsics.checkNotNull(number);
                    loadInvitationHost = KGKakaoInvitationHost.INSTANCE.loadInvitationHost(number.intValue());
                    if (loadInvitationHost.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadInvitationHost);
                    }
                    KGKakaoInvitationHost kGKakaoInvitationHost = (KGKakaoInvitationHost) loadInvitationHost.getContent();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.دײܮڳܯ(2051781389), kGKakaoInvitationHost);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392676442), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoInvitationHost$Companion$initInterfaceBroker$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult loadInvitationHosts;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Number number = (Number) request.getParameter(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID);
                    Intrinsics.checkNotNull(number);
                    loadInvitationHosts = KGKakaoInvitationHost.INSTANCE.loadInvitationHosts(number.intValue());
                    if (loadInvitationHosts.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadInvitationHosts);
                    }
                    List list = (List) loadInvitationHosts.getContent();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ۮڭڭܬި(862378187), list);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }
    }
}
