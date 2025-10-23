package com.kakao.sdk.partner.talk;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.auth.network.ApiFactoryKt;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.partner.talk.model.ChatFilter;
import com.kakao.sdk.partner.talk.model.ChatMembers;
import com.kakao.sdk.partner.talk.model.Chats;
import com.kakao.sdk.partner.talk.model.FriendFilter;
import com.kakao.sdk.partner.talk.model.FriendType;
import com.kakao.sdk.partner.talk.model.PartnerFriend;
import com.kakao.sdk.partner.talk.model.PartnerFriendsContext;
import com.kakao.sdk.partner.talk.model.PartnerMessageSendResult;
import com.kakao.sdk.talk.TalkApiClient;
import com.kakao.sdk.talk.model.FriendOrder;
import com.kakao.sdk.talk.model.Friends;
import com.kakao.sdk.talk.model.Order;
import com.kakao.sdk.template.model.DefaultTemplate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TalkApiClient.kt */
@Metadata(m838d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0083\u0001\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010\u0017\u001ay\u0010\u0018\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a2:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010 \u001a\u00ad\u0001\u0010!\u001a\u00020\u0006*\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\b2@\u0010\u000f\u001a<\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020+\u0018\u00010*¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010-\u001aV\u0010!\u001a\u00020\u0006*\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010/2@\u0010\u000f\u001a<\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020+\u0018\u00010*¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010\u001av\u00100\u001a\u00020\u0006*\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u00020)0\b2\u0006\u00102\u001a\u00020\u001a2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001042:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007\u001av\u00107\u001a\u00020\u0006*\u00020\u00022\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u00102\u001a\u00020\u001a2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001042:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007\u001a\\\u00109\u001a\u00020\u0006*\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u00020)0\b2\u0006\u0010:\u001a\u00020;2:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010\u001a\\\u0010<\u001a\u00020\u0006*\u00020\u00022\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010:\u001a\u00020;2:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010\u001a\u0087\u0001\u0010=\u001a\u00020\u0006*\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u00020)0\b2\u0006\u0010>\u001a\u00020)2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001042:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010?\u001a\u0087\u0001\u0010@\u001a\u00020\u0006*\u00020\u00022\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010>\u001a\u00020)2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001042:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010?\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006A"}, m839d2 = {"partnerApi", "Lcom/kakao/sdk/partner/talk/PartnerTalkApi;", "Lcom/kakao/sdk/talk/TalkApiClient;", "getPartnerApi", "(Lcom/kakao/sdk/talk/TalkApiClient;)Lcom/kakao/sdk/partner/talk/PartnerTalkApi;", "chatList", "", "filters", "", "Lcom/kakao/sdk/partner/talk/model/ChatFilter;", "offset", "", "limit", com.kakao.sdk.talk.Constants.ORDER, "Lcom/kakao/sdk/talk/model/Order;", "callback", "Lkotlin/Function2;", "Lcom/kakao/sdk/partner/talk/model/Chats;", "Lkotlin/ParameterName;", "name", "chats", "", "error", "(Lcom/kakao/sdk/talk/TalkApiClient;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lkotlin/jvm/functions/Function2;)V", "chatMembers", "chatId", "", "friendsOnly", "", "includeProfile", Constants.TOKEN, "Lcom/kakao/sdk/partner/talk/model/ChatMembers;", "(Lcom/kakao/sdk/talk/TalkApiClient;JLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "friendsForPartner", "friendType", "Lcom/kakao/sdk/partner/talk/model/FriendType;", "friendFilter", "Lcom/kakao/sdk/partner/talk/model/FriendFilter;", "friendOrder", "Lcom/kakao/sdk/talk/model/FriendOrder;", "countryCodes", "", "Lcom/kakao/sdk/talk/model/Friends;", "Lcom/kakao/sdk/partner/talk/model/PartnerFriend;", NativeProtocol.AUDIENCE_FRIENDS, "(Lcom/kakao/sdk/talk/TalkApiClient;Lcom/kakao/sdk/partner/talk/model/FriendType;Lcom/kakao/sdk/partner/talk/model/FriendFilter;Lcom/kakao/sdk/talk/model/FriendOrder;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "context", "Lcom/kakao/sdk/partner/talk/model/PartnerFriendsContext;", "sendCustomMessageForPartner", "receiverUuids", "templateId", "templateArgs", "", "Lcom/kakao/sdk/partner/talk/model/PartnerMessageSendResult;", "messageSendResult", "sendCustomMessageToChats", "receiverChatIds", "sendDefaultMessageForPartner", SDKConstants.PARAM_UPDATE_TEMPLATE, "Lcom/kakao/sdk/template/model/DefaultTemplate;", "sendDefaultMessageToChats", "sendScrapMessageForPartner", "requestUrl", "(Lcom/kakao/sdk/talk/TalkApiClient;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "sendScrapMessageToChats", "partner-talk_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TalkApiClientKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatList(TalkApiClient talkApiClient, List<? extends ChatFilter> list, Integer num, Integer num2, Function2<? super Chats, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatList$default(talkApiClient, list, num, num2, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatList(TalkApiClient talkApiClient, List<? extends ChatFilter> list, Integer num, Function2<? super Chats, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatList$default(talkApiClient, list, num, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatList(TalkApiClient talkApiClient, List<? extends ChatFilter> list, Function2<? super Chats, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatList$default(talkApiClient, list, null, null, null, callback, 14, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatList(TalkApiClient talkApiClient, Function2<? super Chats, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatList$default(talkApiClient, null, null, null, null, callback, 15, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatMembers(TalkApiClient talkApiClient, long j, Boolean bool, Boolean bool2, Function2<? super ChatMembers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatMembers$default(talkApiClient, j, bool, bool2, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatMembers(TalkApiClient talkApiClient, long j, Boolean bool, Function2<? super ChatMembers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatMembers$default(talkApiClient, j, bool, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatMembers(TalkApiClient talkApiClient, long j, Function2<? super ChatMembers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        chatMembers$default(talkApiClient, j, null, null, null, callback, 14, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Integer num, Integer num2, Order order, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, friendType, friendFilter, friendOrder, num, num2, order, null, callback, 64, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Integer num, Integer num2, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, friendType, friendFilter, friendOrder, num, num2, null, null, callback, 96, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Integer num, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, friendType, friendFilter, friendOrder, num, null, null, null, callback, 112, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, friendType, friendFilter, friendOrder, null, null, null, null, callback, 120, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, friendType, friendFilter, null, null, null, null, null, callback, 124, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, friendType, null, null, null, null, null, null, callback, 126, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        friendsForPartner$default(talkApiClient, null, null, null, null, null, null, null, callback, 127, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendCustomMessageForPartner(TalkApiClient talkApiClient, List<String> receiverUuids, long j, Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendCustomMessageForPartner$default(talkApiClient, receiverUuids, j, null, callback, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendCustomMessageToChats(TalkApiClient talkApiClient, List<Long> receiverChatIds, long j, Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverChatIds, "receiverChatIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendCustomMessageToChats$default(talkApiClient, receiverChatIds, j, null, callback, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendScrapMessageForPartner(TalkApiClient talkApiClient, List<String> receiverUuids, String requestUrl, Long l, Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMessageForPartner$default(talkApiClient, receiverUuids, requestUrl, l, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendScrapMessageForPartner(TalkApiClient talkApiClient, List<String> receiverUuids, String requestUrl, Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMessageForPartner$default(talkApiClient, receiverUuids, requestUrl, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendScrapMessageToChats(TalkApiClient talkApiClient, List<Long> receiverChatIds, String requestUrl, Long l, Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverChatIds, "receiverChatIds");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMessageToChats$default(talkApiClient, receiverChatIds, requestUrl, l, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendScrapMessageToChats(TalkApiClient talkApiClient, List<Long> receiverChatIds, String requestUrl, Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverChatIds, "receiverChatIds");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMessageToChats$default(talkApiClient, receiverChatIds, requestUrl, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final PartnerTalkApi getPartnerApi(TalkApiClient talkApiClient) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Object create = ApiFactoryKt.getKapiWithOAuth(ApiFactory.INSTANCE).create(PartnerTalkApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "ApiFactory.kapiWithOAuth…rtnerTalkApi::class.java)");
        return (PartnerTalkApi) create;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void friendsForPartner$default(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Integer num, Integer num2, Order order, List list, Function2 function2, int i, Object obj) {
        friendsForPartner(talkApiClient, (i & 1) != 0 ? null : friendType, (i & 2) != 0 ? null : friendFilter, (i & 4) != 0 ? null : friendOrder, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : order, (i & 64) != 0 ? null : list, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Integer num, Integer num2, Order order, List<String> list, final Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).friends(friendType, friendFilter, friendOrder, num, num2, order, list == null ? null : CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null)).enqueue(new ApiCallback<Friends<PartnerFriend>>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$friendsForPartner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Friends<PartnerFriend> model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void friendsForPartner(TalkApiClient talkApiClient, PartnerFriendsContext partnerFriendsContext, final Function2<? super Friends<PartnerFriend>, ? super Throwable, Unit> callback) {
        List<String> countryCodes;
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PartnerTalkApi partnerApi = getPartnerApi(talkApiClient);
        String str = null;
        FriendType friendType = partnerFriendsContext == null ? null : partnerFriendsContext.getFriendType();
        FriendFilter friendFilter = partnerFriendsContext == null ? null : partnerFriendsContext.getFriendFilter();
        FriendOrder friendOrder = partnerFriendsContext == null ? null : partnerFriendsContext.getFriendOrder();
        Integer offset = partnerFriendsContext == null ? null : partnerFriendsContext.getOffset();
        Integer limit = partnerFriendsContext == null ? null : partnerFriendsContext.getLimit();
        Order order = partnerFriendsContext == null ? null : partnerFriendsContext.getOrder();
        if (partnerFriendsContext != null && (countryCodes = partnerFriendsContext.getCountryCodes()) != null) {
            str = CollectionsKt.joinToString$default(countryCodes, ",", null, null, 0, null, null, 62, null);
        }
        partnerApi.friends(friendType, friendFilter, friendOrder, offset, limit, order, str).enqueue(new ApiCallback<Friends<PartnerFriend>>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$friendsForPartner$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Friends<PartnerFriend> model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void chatList$default(TalkApiClient talkApiClient, List list, Integer num, Integer num2, Order order, Function2 function2, int i, Object obj) {
        chatList(talkApiClient, (i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : order, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatList(TalkApiClient talkApiClient, List<? extends ChatFilter> list, Integer num, Integer num2, Order order, final Function2<? super Chats, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).chatList(list == null ? null : CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null), num, num2, order).enqueue(new ApiCallback<Chats>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$chatList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Chats model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void chatMembers$default(TalkApiClient talkApiClient, long j, Boolean bool, Boolean bool2, Long l, Function2 function2, int i, Object obj) {
        chatMembers(talkApiClient, j, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : l, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void chatMembers(TalkApiClient talkApiClient, long j, Boolean bool, Boolean bool2, Long l, final Function2<? super ChatMembers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).chatMembers(j, bool, bool2, l).enqueue(new ApiCallback<ChatMembers>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$chatMembers$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ChatMembers model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendCustomMessageForPartner$default(TalkApiClient talkApiClient, List list, long j, Map map, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        sendCustomMessageForPartner(talkApiClient, list, j, map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendCustomMessageForPartner(TalkApiClient talkApiClient, List<String> receiverUuids, long j, Map<String, String> map, final Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).sendMessage("uuid", KakaoJson.INSTANCE.toJson(receiverUuids), j, map).enqueue(new ApiCallback<PartnerMessageSendResult>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$sendCustomMessageForPartner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerMessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendCustomMessageToChats$default(TalkApiClient talkApiClient, List list, long j, Map map, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        sendCustomMessageToChats(talkApiClient, list, j, map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendCustomMessageToChats(TalkApiClient talkApiClient, List<Long> receiverChatIds, long j, Map<String, String> map, final Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverChatIds, "receiverChatIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).sendMessage(Constants.CHAT_ID, KakaoJson.INSTANCE.toJson(receiverChatIds), j, map).enqueue(new ApiCallback<PartnerMessageSendResult>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$sendCustomMessageToChats$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerMessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendDefaultMessageForPartner(TalkApiClient talkApiClient, List<String> receiverUuids, DefaultTemplate template, final Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).sendMessage("uuid", KakaoJson.INSTANCE.toJson(receiverUuids), template).enqueue(new ApiCallback<PartnerMessageSendResult>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$sendDefaultMessageForPartner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerMessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendDefaultMessageToChats(TalkApiClient talkApiClient, List<Long> receiverChatIds, DefaultTemplate template, final Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverChatIds, "receiverChatIds");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).sendMessage(Constants.CHAT_ID, KakaoJson.INSTANCE.toJson(receiverChatIds), template).enqueue(new ApiCallback<PartnerMessageSendResult>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$sendDefaultMessageToChats$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerMessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendScrapMessageForPartner$default(TalkApiClient talkApiClient, List list, String str, Long l, Map map, Function2 function2, int i, Object obj) {
        sendScrapMessageForPartner(talkApiClient, list, str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendScrapMessageForPartner(TalkApiClient talkApiClient, List<String> receiverUuids, String requestUrl, Long l, Map<String, String> map, final Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).sendMessage("uuid", KakaoJson.INSTANCE.toJson(receiverUuids), requestUrl, l, map).enqueue(new ApiCallback<PartnerMessageSendResult>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$sendScrapMessageForPartner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerMessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendScrapMessageToChats$default(TalkApiClient talkApiClient, List list, String str, Long l, Map map, Function2 function2, int i, Object obj) {
        sendScrapMessageToChats(talkApiClient, list, str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendScrapMessageToChats(TalkApiClient talkApiClient, List<Long> receiverChatIds, String requestUrl, Long l, Map<String, String> map, final Function2<? super PartnerMessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(talkApiClient, "<this>");
        Intrinsics.checkNotNullParameter(receiverChatIds, "receiverChatIds");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(talkApiClient).sendMessage(Constants.CHAT_ID, KakaoJson.INSTANCE.toJson(receiverChatIds), requestUrl, l, map).enqueue(new ApiCallback<PartnerMessageSendResult>() { // from class: com.kakao.sdk.partner.talk.TalkApiClientKt$sendScrapMessageToChats$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerMessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }
}
