package com.kakaogame.kakao;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import android.widget.Toast;
import com.facebook.share.internal.ShareInternalUtility;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.partner.talk.TalkApiClientKt;
import com.kakao.sdk.partner.talk.model.Chat;
import com.kakao.sdk.partner.talk.model.ChatFilter;
import com.kakao.sdk.partner.talk.model.Chats;
import com.kakao.sdk.partner.talk.model.FriendFilter;
import com.kakao.sdk.partner.talk.model.FriendType;
import com.kakao.sdk.partner.talk.model.PartnerFriend;
import com.kakao.sdk.share.ShareClient;
import com.kakao.sdk.share.model.ImageUploadResult;
import com.kakao.sdk.talk.Constants;
import com.kakao.sdk.talk.TalkApiClient;
import com.kakao.sdk.talk.model.Friend;
import com.kakao.sdk.talk.model.FriendOrder;
import com.kakao.sdk.talk.model.Friends;
import com.kakao.sdk.talk.model.Order;
import com.kakao.sdk.talk.model.TalkProfile;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGKakaoProfile;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.game.GameServerProtocol;
import com.kakaogame.game.StringSet;
import com.kakaogame.game.model.InvitationEvent;
import com.kakaogame.game.model.InvitationSender;
import com.kakaogame.game.model.InvitationState;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.server.InhouseGWService;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;

/* compiled from: KakaoGameAPI.kt */
@Metadata(m838d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J&\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001dJ\u001a\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J$\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"0\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00162\u0006\u0010\u0013\u001a\u00020\u0019J\u0014\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020$\u0018\u00010&0\u0016J\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u00162\u0006\u0010)\u001a\u00020\u0019J\u001c\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010&0\u00162\u0006\u0010)\u001a\u00020\u0019J\u001c\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010&0\u00162\u0006\u0010)\u001a\u00020\u0019J \u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0007J&\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J$\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"0\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u0016H\u0086@¢\u0006\u0002\u00103J\u0018\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00162\u0006\u00106\u001a\u000207H\u0002J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0087@¢\u0006\u0002\u0010<R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, m839d2 = {"Lcom/kakaogame/kakao/KakaoGameAPI;", "", "()V", "TAG", "", "chatInfoMap", "", "", "Lcom/kakao/sdk/partner/talk/model/Chat;", "extendedFriendInfoMap", "gameFriendInfoMap", "Lcom/kakao/sdk/talk/model/Friend;", "invitableFriendInfoMap", "Lcom/kakao/sdk/partner/talk/model/PartnerFriend;", "getChatInfo", "chatId", "getExtendedFriendInfo", "uuid", "getGameFriendInfo", "id", "getInvitableFriendInfo", "loadInvitableFriendProfilesV4", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse;", ServerConstants.RECOMMEND_LIMIT, "", "offset", "limit", "makeHeader", "", "requestGameImageUpload", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "requestInvitableFriends", "Lcom/kakao/sdk/talk/model/Friends;", "requestInvitationEvent", "Lcom/kakaogame/game/model/InvitationEvent;", "requestInvitationEventList", "", "requestInvitationSender", "Lcom/kakaogame/game/model/InvitationSender;", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "requestInvitationSenderList", "requestInvitationStates", "Lcom/kakaogame/game/model/InvitationState;", "requestMultiChatList", "Lcom/kakao/sdk/partner/talk/model/Chats;", "requestRecommendedInvitableFriends", "requestRegisteredFriends", "requestTalkProfile", "Lcom/kakao/sdk/talk/model/TalkProfile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRequestWithScope", "Lcom/kakaogame/util/json/JSONObject;", "requestData", "Lcom/kakaogame/server/ServerRequest;", "showMessageBlockDialog", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoGameAPI {
    private static final String TAG = "KakaoGameAPI";
    public static final KakaoGameAPI INSTANCE = new KakaoGameAPI();
    private static final Map<String, Friend> gameFriendInfoMap = new LinkedHashMap();
    private static final Map<String, PartnerFriend> invitableFriendInfoMap = new LinkedHashMap();
    private static final Map<String, String> extendedFriendInfoMap = new LinkedHashMap();
    private static final Map<Long, Chat> chatInfoMap = new LinkedHashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameAPI() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Friend getGameFriendInfo(String id) {
        Intrinsics.checkNotNullParameter(id, y.ٲٴݴ״ٰ(1781792816));
        return gameFriendInfoMap.get(id);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final PartnerFriend getInvitableFriendInfo(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, y.ٴسسݬߨ(1392679994));
        return invitableFriendInfoMap.get(uuid);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getExtendedFriendInfo(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, y.ٴسسݬߨ(1392679994));
        return extendedFriendInfoMap.get(uuid);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Chat getChatInfo(long chatId) {
        return chatInfoMap.get(Long.valueOf(chatId));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Friends<PartnerFriend>> requestInvitableFriends(int offset, int limit) {
        String str = y.٬ݯح׭٩(575746614);
        String str2 = y.ۮڭڭܬި(862363619);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ٴسسݬߨ(1393539290) + offset + y.ݮڮֲڭܩ(-628756788) + limit;
        String str4 = y.دײܮڳܯ(2051449597);
        logger.m699d(str4, str3);
        try {
            if (offset < 0) {
                return KGResult.INSTANCE.getResult(4000, str2 + offset);
            }
            if (limit <= 0) {
                return KGResult.INSTANCE.getResult(4000, str + limit);
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            TalkApiClientKt.friendsForPartner$default(TalkApiClient.INSTANCE.getInstance(), FriendType.KAKAO_TALK, FriendFilter.INVITABLE, FriendOrder.NICKNAME, Integer.valueOf(offset), Integer.valueOf(limit), Order.ASC, null, new Function2<Friends<PartnerFriend>, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoGameAPI$requestInvitableFriends$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Friends<PartnerFriend> friends, Throwable th) {
                    invoke2(friends, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Friends<PartnerFriend> friends, Throwable th) {
                    if (th != null) {
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        createLock.setContent(companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second));
                        createLock.unlock();
                        return;
                    }
                    createLock.setContent(KGResult.INSTANCE.getSuccessResult(friends));
                    createLock.unlock();
                }
            }, 64, null);
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            Friends friends = (Friends) content2;
            if (friends.getElements() != null) {
                List<PartnerFriend> elements = friends.getElements();
                Intrinsics.checkNotNull(elements);
                for (PartnerFriend partnerFriend : elements) {
                    invitableFriendInfoMap.put(partnerFriend.getUuid(), partnerFriend);
                }
            }
            return KGResult.INSTANCE.getSuccessResult(friends);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Friends<Friend>> requestRegisteredFriends(int offset, int limit) {
        String str = y.٬ݯح׭٩(575746614);
        String str2 = y.ۮڭڭܬި(862363619);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ٴسسݬߨ(1393537642) + offset + y.ݮڮֲڭܩ(-628756788) + limit;
        String str4 = y.دײܮڳܯ(2051449597);
        logger.m699d(str4, str3);
        try {
            if (offset < 0) {
                return KGResult.INSTANCE.getResult(4000, str2 + offset);
            }
            if (limit <= 0) {
                return KGResult.INSTANCE.getResult(4000, str + limit);
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            TalkApiClient.INSTANCE.getInstance().friends(Integer.valueOf(offset), Integer.valueOf(limit), Order.ASC, FriendOrder.NICKNAME, new Function2<Friends<Friend>, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoGameAPI$requestRegisteredFriends$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Friends<Friend> friends, Throwable th) {
                    invoke2(friends, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Friends<Friend> friends, Throwable th) {
                    if (th != null) {
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        createLock.setContent(companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second));
                        createLock.unlock();
                        return;
                    }
                    createLock.setContent(KGResult.INSTANCE.getSuccessResult(friends));
                    createLock.unlock();
                }
            });
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            Friends friends = (Friends) content2;
            if (friends.getElements() != null) {
                List<Friend> elements = friends.getElements();
                Intrinsics.checkNotNull(elements);
                for (Friend friend : elements) {
                    Map<String, Friend> map = gameFriendInfoMap;
                    Long id = friend.getId();
                    Intrinsics.checkNotNull(id);
                    map.put(String.valueOf(id.longValue()), friend);
                }
            }
            KakaoCache.saveRegisteredFriends(CoreManager.INSTANCE.getInstance().getContext(), gameFriendInfoMap);
            return KGResult.INSTANCE.getSuccessResult(friends);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Chats> requestMultiChatList(int offset, int limit) {
        String str = y.٬ݯح׭٩(575746614);
        String str2 = y.ۮڭڭܬި(862363619);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ݬֲ֮ܲت(1512474799) + offset + y.ݮڮֲڭܩ(-628756788) + limit;
        String str4 = y.دײܮڳܯ(2051449597);
        logger.m699d(str4, str3);
        try {
            if (offset < 0) {
                return KGResult.INSTANCE.getResult(4000, str2 + offset);
            }
            if (limit <= 0) {
                return KGResult.INSTANCE.getResult(4000, str + limit);
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            TalkApiClientKt.chatList(TalkApiClient.INSTANCE.getInstance(), CollectionsKt.listOf(ChatFilter.MULTI), Integer.valueOf(offset), Integer.valueOf(limit), Order.ASC, new Function2<Chats, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoGameAPI$requestMultiChatList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Chats chats, Throwable th) {
                    invoke2(chats, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Chats chats, Throwable th) {
                    if (th != null) {
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        createLock.setContent(companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second));
                        createLock.unlock();
                        return;
                    }
                    createLock.setContent(KGResult.INSTANCE.getSuccessResult(chats));
                    createLock.unlock();
                }
            });
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Chats chats = (Chats) kGResult.getContent();
            Intrinsics.checkNotNull(chats);
            if (chats.getElements() != null) {
                List<Chat> elements = chats.getElements();
                Intrinsics.checkNotNull(elements);
                for (Chat chat : elements) {
                    chatInfoMap.put(Long.valueOf(chat.getId()), chat);
                }
            }
            return KGResult.INSTANCE.getSuccessResult(chats);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object showMessageBlockDialog(Activity activity, Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051449597), y.ݬֲ֮ܲت(1512478719));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoGameAPI$showMessageBlockDialog$2$1(activity, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object requestTalkProfile(Continuation<? super KGResult<TalkProfile>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782230016);
        String str2 = y.دײܮڳܯ(2051449597);
        logger.m699d(str2, str);
        try {
            TalkApiClient.INSTANCE.getInstance().profile(new Function2<TalkProfile, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoGameAPI$requestTalkProfile$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(TalkProfile talkProfile, Throwable th) {
                    invoke2(talkProfile, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TalkProfile talkProfile, Throwable th) {
                    if (th != null) {
                        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051449597), y.ۮڭڭܬި(862702027) + th);
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        KGResult result = companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                        Continuation<KGResult<TalkProfile>> continuation2 = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m1440constructorimpl(result));
                        return;
                    }
                    KGResult successResult = KGResult.INSTANCE.getSuccessResult(talkProfile);
                    Continuation<KGResult<TalkProfile>> continuation3 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(successResult));
                }
            });
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<JSONObject> sendRequestWithScope(ServerRequest requestData) {
        ServerResult requestServer$default = ServerService.requestServer$default(requestData, 0, 2, null);
        if (!requestServer$default.isSuccess()) {
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            String str = y.دײܮڳܯ(2051777077);
            if (content.containsKey((Object) str)) {
                List<String> asMutableList = TypeIntrinsics.asMutableList(content.get((Object) str));
                Intrinsics.checkNotNull(asMutableList);
                asMutableList.add(y.ٴسسݬߨ(1393533866));
                Logger logger = Logger.INSTANCE;
                String str2 = y.٬ݯح׭٩(575760134) + asMutableList;
                String str3 = y.دײܮڳܯ(2051449597);
                logger.m699d(str3, str2);
                KGResult<String> updateScope = KGKakao2Auth.INSTANCE.updateScope(CoreManager.INSTANCE.getInstance().getActivity(), asMutableList);
                if (updateScope.isSuccess()) {
                    requestServer$default = ServerService.requestServer$default(requestData, 0, 2, null);
                    if (!requestServer$default.isSuccess()) {
                        return KGResult.INSTANCE.getResult(requestServer$default);
                    }
                } else {
                    Logger.INSTANCE.m699d(str3, y.ݮڮֲڭܩ(-628713572) + updateScope);
                    return KGResult.INSTANCE.getResult(9001, y.ٲٴݴ״ٰ(1782031224), requestServer$default.getContent());
                }
            } else {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
        }
        return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGKakaoProfile.KGKakaoFriendsResponse> requestRecommendedInvitableFriends(int recommendLimit, int offset, int limit) {
        String str = y.ݮڮֲڭܩ(-628391156);
        String str2 = y.ٴسسݬߨ(1393538970);
        String str3 = y.٬ݯح׭٩(575746614);
        String str4 = y.ۮڭڭܬި(862363619);
        Logger logger = Logger.INSTANCE;
        String str5 = y.٬ݯح׭٩(576484662) + offset + y.ݮڮֲڭܩ(-628756788) + limit;
        String str6 = y.دײܮڳܯ(2051449597);
        logger.m699d(str6, str5);
        try {
            if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode() && !CoreManager.INSTANCE.getInstance().tryKakaoReConnect().isSuccess()) {
                final Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
                activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.kakao.KakaoGameAPI$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        KakaoGameAPI.requestRecommendedInvitableFriends$lambda$2(activity);
                    }
                });
                return KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(0, new ArrayList()));
            }
            if (offset < 0) {
                return KGResult.INSTANCE.getResult(4000, str4 + offset);
            }
            if (limit <= 0) {
                return KGResult.INSTANCE.getResult(4000, str3 + limit);
            }
            KGResult<JSONObject> sendRequestWithScope = sendRequestWithScope(InhouseGWService.getRecommendedInvitableFriendsRequest(recommendLimit, offset, limit));
            Logger.INSTANCE.m706v(str6, str2 + sendRequestWithScope.getContent());
            if (sendRequestWithScope.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(sendRequestWithScope);
            }
            JSONObject content = sendRequestWithScope.getContent();
            Intrinsics.checkNotNull(content);
            if (content.containsKey((Object) str)) {
                Number number = (Number) content.get((Object) str);
                Intrinsics.checkNotNull(number);
                int intValue = number.intValue();
                JSONArray jSONArray = (JSONArray) content.get((Object) Constants.ELEMENTS);
                if (jSONArray == null) {
                    return KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(intValue, new ArrayList()));
                }
                JSONArray jSONArray2 = jSONArray;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
                Iterator<Object> it = jSONArray2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new KGKakaoProfile((JSONObject) it.next()));
                }
                ArrayList<KGKakaoProfile> arrayList2 = arrayList;
                for (KGKakaoProfile kGKakaoProfile : arrayList2) {
                    String uuid = kGKakaoProfile.getUUID();
                    if (uuid != null) {
                        extendedFriendInfoMap.put(uuid, kGKakaoProfile.getImpressionId());
                    }
                }
                return KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(intValue, arrayList2));
            }
            return KGResult.INSTANCE.getResult(4001, "No friends list");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str6, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void requestRecommendedInvitableFriends$lambda$2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Activity activity2 = activity;
        Toast makeText = Toast.makeText(activity2, ResourceUtil.getString(activity2, y.ݮڮֲڭܩ(-628701596)), 1);
        makeText.setGravity(81, 0, 0);
        y.٬خݮ۳ݯ();
        makeText.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGKakaoProfile.KGKakaoFriendsResponse> loadInvitableFriendProfilesV4(int recommendLimit, int offset, int limit) {
        KGResult<KGKakaoProfile.KGKakaoFriendsResponse> result;
        KGResult<JSONObject> sendRequestWithScope;
        String str = y.ۮڭڭܬި(862269467);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٲٴݴ״ٰ(1782048912) + recommendLimit;
        String str3 = y.دײܮڳܯ(2051449597);
        logger.m699d(str3, str2);
        if (!KakaoManager.isTalkUser()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, "onNotKakaoTalkUser");
        }
        if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode() && !CoreManager.INSTANCE.getInstance().tryKakaoReConnect().isSuccess()) {
            final Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.kakao.KakaoGameAPI$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    KakaoGameAPI.loadInvitableFriendProfilesV4$lambda$5(activity);
                }
            });
            return KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(0, new ArrayList()));
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.ۮڭڭܬި(862704659));
        try {
            try {
                sendRequestWithScope = sendRequestWithScope(InhouseGWService.getInvitableFriendsV4Request(recommendLimit, offset, limit));
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str3, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
            }
            if (sendRequestWithScope.isNotSuccess()) {
                KakaoUtil.convertResultCode(sendRequestWithScope);
                KGResult<KGKakaoProfile.KGKakaoFriendsResponse> result2 = KGResult.INSTANCE.getResult(sendRequestWithScope);
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                return result2;
            }
            JSONObject content = sendRequestWithScope.getContent();
            Intrinsics.checkNotNull(content);
            if (content.containsKey((Object) str)) {
                Number number = (Number) content.get((Object) str);
                Intrinsics.checkNotNull(number);
                int intValue = number.intValue();
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = (JSONArray) content.get((Object) Constants.ELEMENTS);
                if (jSONArray == null) {
                    KGResult<KGKakaoProfile.KGKakaoFriendsResponse> successResult = KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(intValue, new ArrayList()));
                    start.stop();
                    KakaoUtil.convertResultCode(null);
                    KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                    return successResult;
                }
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    Intrinsics.checkNotNull(jSONObject);
                    arrayList.add(new KGKakaoProfile(4, jSONObject));
                }
                result = KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(intValue, arrayList));
            } else {
                result = KGResult.INSTANCE.getSuccessResult(new KGKakaoProfile.KGKakaoFriendsResponse(0, new ArrayList()));
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loadInvitableFriendProfilesV4$lambda$5(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Activity activity2 = activity;
        Toast makeText = Toast.makeText(activity2, ResourceUtil.getString(activity2, y.ݮڮֲڭܩ(-628701596)), 1);
        makeText.setGravity(81, 0, 0);
        y.٬خݮ۳ݯ();
        makeText.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<List<InvitationEvent>> requestInvitationEventList() {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782228216);
        String str2 = y.دײܮڳܯ(2051449597);
        logger.m699d(str2, str);
        try {
            MutexLock createLock = MutexLock.INSTANCE.createLock();
            String builder = new Uri.Builder().scheme("https").authority(GameServerProtocol.GAME_API_AUTHORITY).path(GameServerProtocol.GET_INVITATION_EVENTS_PATH).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "toString(...)");
            KeyBaseResult<Object> requestGET = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), builder, makeHeader(), HttpService.HttpContentType.STRING);
            if (requestGET.getCode() == 200) {
                ArrayList arrayList = new ArrayList();
                try {
                    Object parse = JSONValue.parse((String) requestGET.getContent());
                    Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                    List list = (List) ((JSONObject) parse).get((Object) StringSet.invitation_events);
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new InvitationEvent(new org.json.JSONObject(((JSONObject) it.next()).toString())));
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                createLock.setContent(KGResult.INSTANCE.getSuccessResult(arrayList));
                createLock.unlock();
            } else {
                createLock.setContent(KGResult.INSTANCE.getResult(4001, requestGET.getCode() + " : " + requestGET.getDescription()));
                createLock.unlock();
            }
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            List list2 = (List) content2;
            Logger.INSTANCE.m706v(str2, "InvitationEventListResponse: " + list2);
            return KGResult.INSTANCE.getSuccessResult(list2);
        } catch (Exception e3) {
            Logger.INSTANCE.m702e(str2, e3.toString(), e3);
            return KGResult.INSTANCE.getResult(4001, e3.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<InvitationEvent> requestInvitationEvent(int id) {
        InvitationEvent invitationEvent;
        JSONObject jSONObject;
        String str = y.دײܮڳܯ(2051455789);
        String str2 = y.֬ڱܱײٮ(-1158682871);
        Logger logger = Logger.INSTANCE;
        String str3 = y.֬ڱܱײٮ(-1158683119);
        String str4 = y.دײܮڳܯ(2051449597);
        logger.m699d(str4, str3);
        try {
            MutexLock createLock = MutexLock.INSTANCE.createLock();
            String builder = new Uri.Builder().scheme("https").authority(GameServerProtocol.GAME_API_AUTHORITY).path(str2 + id).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "toString(...)");
            KeyBaseResult<Object> requestGET = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), builder, makeHeader(), HttpService.HttpContentType.STRING);
            if (requestGET.getCode() == 200) {
                try {
                    try {
                        Object parse = JSONValue.parse((String) requestGET.getContent());
                        Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                        jSONObject = (JSONObject) ((JSONObject) parse).get((Object) StringSet.invitation_event);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                if (jSONObject != null) {
                    invitationEvent = new InvitationEvent(new org.json.JSONObject(jSONObject.toString()));
                    createLock.setContent(KGResult.INSTANCE.getSuccessResult(invitationEvent));
                    createLock.unlock();
                }
                invitationEvent = null;
                createLock.setContent(KGResult.INSTANCE.getSuccessResult(invitationEvent));
                createLock.unlock();
            } else {
                createLock.setContent(KGResult.INSTANCE.getResult(4001, requestGET.getCode() + " : " + requestGET.getDescription()));
                createLock.unlock();
            }
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            InvitationEvent invitationEvent2 = (InvitationEvent) kGResult.getContent();
            Logger.INSTANCE.m706v(str4, str + invitationEvent2);
            return KGResult.INSTANCE.getSuccessResult(invitationEvent2);
        } catch (Exception e3) {
            Logger.INSTANCE.m702e(str4, e3.toString(), e3);
            return KGResult.INSTANCE.getResult(4001, e3.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<List<InvitationState>> requestInvitationStates(int eventId) {
        String str = y.֬ڱܱײٮ(-1158682871);
        Logger logger = Logger.INSTANCE;
        String str2 = y.٬ݯح׭٩(576484022) + eventId;
        String str3 = y.دײܮڳܯ(2051449597);
        logger.m699d(str3, str2);
        try {
            MutexLock createLock = MutexLock.INSTANCE.createLock();
            String builder = new Uri.Builder().scheme("https").authority(GameServerProtocol.GAME_API_AUTHORITY).path(str + eventId + GameServerProtocol.GET_INVITATION_STATES_PATH).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "toString(...)");
            KeyBaseResult<Object> requestGET = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), builder, makeHeader(), HttpService.HttpContentType.STRING);
            if (requestGET.getCode() == 200) {
                ArrayList arrayList = new ArrayList();
                try {
                    Object parse = JSONValue.parse((String) requestGET.getContent());
                    Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                    List list = (List) ((JSONObject) parse).get((Object) StringSet.invitation_states);
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new InvitationState(new org.json.JSONObject(((JSONObject) it.next()).toString())));
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                createLock.setContent(KGResult.INSTANCE.getSuccessResult(arrayList));
                createLock.unlock();
            } else {
                createLock.setContent(KGResult.INSTANCE.getResult(4001, requestGET.getCode() + " : " + requestGET.getDescription()));
                createLock.unlock();
            }
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            List list2 = (List) content2;
            Logger.INSTANCE.m706v(str3, "InvitationStatesResponse: " + list2);
            return KGResult.INSTANCE.getSuccessResult(list2);
        } catch (Exception e3) {
            Logger.INSTANCE.m702e(str3, e3.toString(), e3);
            return KGResult.INSTANCE.getResult(4001, e3.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<InvitationSender> requestInvitationSender(int eventId) {
        InvitationSender invitationSender;
        List list;
        String str = y.ٴسسݬߨ(1393538194);
        String str2 = y.֬ڱܱײٮ(-1158682871);
        Logger logger = Logger.INSTANCE;
        String str3 = y.֬ڱܱײٮ(-1158682479) + eventId;
        String str4 = y.دײܮڳܯ(2051449597);
        logger.m699d(str4, str3);
        try {
            MutexLock createLock = MutexLock.INSTANCE.createLock();
            String builder = new Uri.Builder().scheme("https").authority(GameServerProtocol.GAME_API_AUTHORITY).path(str2 + eventId + GameServerProtocol.GET_INVITATION_SENDER_PATH).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "toString(...)");
            KeyBaseResult<Object> requestGET = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), builder, makeHeader(), HttpService.HttpContentType.STRING);
            if (requestGET.getCode() == 200) {
                try {
                    try {
                        Object parse = JSONValue.parse((String) requestGET.getContent());
                        Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                        list = (List) ((JSONObject) parse).get((Object) StringSet.invitation_sender);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                if (list != null) {
                    invitationSender = new InvitationSender(new org.json.JSONObject(list.toString()));
                    createLock.setContent(KGResult.INSTANCE.getSuccessResult(invitationSender));
                    createLock.unlock();
                }
                invitationSender = null;
                createLock.setContent(KGResult.INSTANCE.getSuccessResult(invitationSender));
                createLock.unlock();
            } else {
                createLock.setContent(KGResult.INSTANCE.getResult(4001, requestGET.getCode() + " : " + requestGET.getDescription()));
                createLock.unlock();
            }
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            InvitationSender invitationSender2 = (InvitationSender) kGResult.getContent();
            Logger.INSTANCE.m706v(str4, str + invitationSender2);
            return KGResult.INSTANCE.getSuccessResult(invitationSender2);
        } catch (Exception e3) {
            Logger.INSTANCE.m702e(str4, e3.toString(), e3);
            return KGResult.INSTANCE.getResult(4001, e3.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<List<InvitationSender>> requestInvitationSenderList(int eventId) {
        String str = y.֬ڱܱײٮ(-1158682871);
        Logger logger = Logger.INSTANCE;
        String str2 = y.֬ڱܱײٮ(-1158682479) + eventId;
        String str3 = y.دײܮڳܯ(2051449597);
        logger.m699d(str3, str2);
        try {
            MutexLock createLock = MutexLock.INSTANCE.createLock();
            String builder = new Uri.Builder().scheme("https").authority(GameServerProtocol.GAME_API_AUTHORITY).path(str + eventId + GameServerProtocol.GET_INVITATION_SENDER_LIST_PATH).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "toString(...)");
            KeyBaseResult<Object> requestGET = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), builder, makeHeader(), HttpService.HttpContentType.STRING);
            if (requestGET.getCode() == 200) {
                ArrayList arrayList = new ArrayList();
                try {
                    Object parse = JSONValue.parse((String) requestGET.getContent());
                    Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                    List list = (List) ((JSONObject) parse).get((Object) "invitation_senders");
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new InvitationSender(new org.json.JSONObject(((JSONObject) it.next()).toString())));
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                createLock.setContent(KGResult.INSTANCE.getSuccessResult(arrayList));
                createLock.unlock();
            } else {
                createLock.setContent(KGResult.INSTANCE.getResult(4001, requestGET.getCode() + " : " + requestGET.getDescription()));
                createLock.unlock();
            }
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            KGResult kGResult = (KGResult) content;
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            List list2 = (List) content2;
            Logger.INSTANCE.m706v(str3, "InvitationSenderResponse: " + list2);
            return KGResult.INSTANCE.getSuccessResult(list2);
        } catch (Exception e3) {
            Logger.INSTANCE.m702e(str3, e3.toString(), e3);
            return KGResult.INSTANCE.getResult(4001, e3.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> requestGameImageUpload(File file) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862702443) + (file != null ? file.getName() : null);
        String str2 = y.دײܮڳܯ(2051449597);
        logger.m704i(str2, str);
        try {
            if (file == null) {
                return KGResult.INSTANCE.getResult(9999, "file is null");
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            ShareClient.uploadImage$default(ShareClient.INSTANCE.getInstance(), file, false, new Function2<ImageUploadResult, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoGameAPI$requestGameImageUpload$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ImageUploadResult imageUploadResult, Throwable th) {
                    invoke2(imageUploadResult, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ImageUploadResult imageUploadResult, Throwable th) {
                    if (th != null) {
                        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051449597), y.دײܮڳܯ(2051450341) + th);
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        createLock.setContent(companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second));
                        createLock.unlock();
                        return;
                    }
                    KGResult.Companion companion2 = KGResult.INSTANCE;
                    Intrinsics.checkNotNull(imageUploadResult);
                    createLock.setContent(companion2.getSuccessResult(imageUploadResult.getInfos().getOriginal().getUrl()));
                    createLock.unlock();
                }
            }, 2, null);
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            return (KGResult) content;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> makeHeader() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = y.ٲٴݴ״ٰ(1781552064);
        if (!linkedHashMap.containsKey(str)) {
            linkedHashMap.put(str, y.֬ڱܱײٮ(-1158683743));
        }
        String str2 = y.٬ݯح׭٩(576486278);
        if (!linkedHashMap.containsKey(str2)) {
            linkedHashMap.put(str2, y.֬ڱܱײٮ(-1158683959));
        }
        String str3 = y.ݮڮֲڭܩ(-629002692);
        if (!linkedHashMap.containsKey(str3)) {
            linkedHashMap.put(str3, y.ٴسسݬߨ(1393539138) + Build.VERSION.SDK_INT);
        }
        StringBuilder sb = new StringBuilder(y.دײܮڳܯ(2051293517));
        OAuthToken token = TokenManager.INSTANCE.getInstance().getToken();
        Intrinsics.checkNotNull(token);
        linkedHashMap.put(y.ٲٴݴ״ٰ(1782078608), sb.append(token.getAccessToken()).toString());
        return linkedHashMap;
    }
}
