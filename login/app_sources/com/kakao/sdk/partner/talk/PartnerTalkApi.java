package com.kakao.sdk.partner.talk;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.partner.talk.model.ChatMembers;
import com.kakao.sdk.partner.talk.model.Chats;
import com.kakao.sdk.partner.talk.model.FriendFilter;
import com.kakao.sdk.partner.talk.model.FriendType;
import com.kakao.sdk.partner.talk.model.PartnerFriend;
import com.kakao.sdk.partner.talk.model.PartnerMessageSendResult;
import com.kakao.sdk.talk.model.FriendOrder;
import com.kakao.sdk.talk.model.Friends;
import com.kakao.sdk.talk.model.Order;
import com.kakao.sdk.template.model.DefaultTemplate;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: PartnerTalkApi.kt */
@Metadata(m838d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0002\u0010\fJA\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0002\u0010\u0015Jm\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010 J.\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010$\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020&H'JF\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010$\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\u00102\u0016\b\u0003\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010)H'JW\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010$\u001a\u00020\u00062\b\b\u0001\u0010*\u001a\u00020\u00062\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00102\u0016\b\u0003\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010)H'¢\u0006\u0002\u0010+¨\u0006,"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/PartnerTalkApi;", "", "chatList", "Lretrofit2/Call;", "Lcom/kakao/sdk/partner/talk/model/Chats;", Constants.FILTER, "", "offset", "", "limit", com.kakao.sdk.talk.Constants.ORDER, "Lcom/kakao/sdk/talk/model/Order;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;)Lretrofit2/Call;", "chatMembers", "Lcom/kakao/sdk/partner/talk/model/ChatMembers;", "chatId", "", "friendsOnly", "", "includeProfile", Constants.TOKEN, "(JLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)Lretrofit2/Call;", NativeProtocol.AUDIENCE_FRIENDS, "Lcom/kakao/sdk/talk/model/Friends;", "Lcom/kakao/sdk/partner/talk/model/PartnerFriend;", "friendType", "Lcom/kakao/sdk/partner/talk/model/FriendType;", "friendFilter", "Lcom/kakao/sdk/partner/talk/model/FriendFilter;", "friendOrder", "Lcom/kakao/sdk/talk/model/FriendOrder;", "countryCodes", "(Lcom/kakao/sdk/partner/talk/model/FriendType;Lcom/kakao/sdk/partner/talk/model/FriendFilter;Lcom/kakao/sdk/talk/model/FriendOrder;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Ljava/lang/String;)Lretrofit2/Call;", "sendMessage", "Lcom/kakao/sdk/partner/talk/model/PartnerMessageSendResult;", "receiverIdType", "receiverIds", SDKConstants.PARAM_UPDATE_TEMPLATE, "Lcom/kakao/sdk/template/model/DefaultTemplate;", "templateId", "templateArgs", "", "requestUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lretrofit2/Call;", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface PartnerTalkApi {
    @GET(Constants.V1_CHATS_PATH)
    Call<Chats> chatList(@Query("filter") String filter, @Query("offset") Integer offset, @Query("limit") Integer limit, @Query("order") Order order);

    @GET(Constants.V1_CHAT_MEMBERS_PATH)
    Call<ChatMembers> chatMembers(@Query("chat_id") long chatId, @Query("friends_only") Boolean friendsOnly, @Query("include_profile") Boolean includeProfile, @Query("token") Long token);

    @GET(com.kakao.sdk.talk.Constants.V1_FRIENDS_PATH)
    Call<Friends<PartnerFriend>> friends(@Query("friend_type") FriendType friendType, @Query("friend_filter") FriendFilter friendFilter, @Query("friend_order") FriendOrder friendOrder, @Query("offset") Integer offset, @Query("limit") Integer limit, @Query("order") Order order, @Query("country_codes") String countryCodes);

    @FormUrlEncoded
    @POST(Constants.V2_MESSAGE_PATH)
    Call<PartnerMessageSendResult> sendMessage(@Field("receiver_id_type") String receiverIdType, @Field("receiver_ids") String receiverIds, @Field("template_id") long templateId, @Field("template_args") Map<String, String> templateArgs);

    @FormUrlEncoded
    @POST(Constants.V2_MESSAGE_DEFAULT_PATH)
    Call<PartnerMessageSendResult> sendMessage(@Field("receiver_id_type") String receiverIdType, @Field("receiver_ids") String receiverIds, @Field("template_object") DefaultTemplate template);

    @FormUrlEncoded
    @POST(Constants.V2_MESSAGE_SCRAP_PATH)
    Call<PartnerMessageSendResult> sendMessage(@Field("receiver_id_type") String receiverIdType, @Field("receiver_ids") String receiverIds, @Field("request_url") String requestUrl, @Field("template_id") Long templateId, @Field("template_args") Map<String, String> templateArgs);

    /* compiled from: PartnerTalkApi.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call friends$default(PartnerTalkApi partnerTalkApi, FriendType friendType, FriendFilter friendFilter, FriendOrder friendOrder, Integer num, Integer num2, Order order, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: friends");
            }
            if ((i & 1) != 0) {
                friendType = null;
            }
            if ((i & 2) != 0) {
                friendFilter = null;
            }
            if ((i & 4) != 0) {
                friendOrder = null;
            }
            if ((i & 8) != 0) {
                num = null;
            }
            if ((i & 16) != 0) {
                num2 = null;
            }
            if ((i & 32) != 0) {
                order = null;
            }
            if ((i & 64) != 0) {
                str = null;
            }
            return partnerTalkApi.friends(friendType, friendFilter, friendOrder, num, num2, order, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call chatList$default(PartnerTalkApi partnerTalkApi, String str, Integer num, Integer num2, Order order, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chatList");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                num2 = null;
            }
            if ((i & 8) != 0) {
                order = null;
            }
            return partnerTalkApi.chatList(str, num, num2, order);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call chatMembers$default(PartnerTalkApi partnerTalkApi, long j, Boolean bool, Boolean bool2, Long l, int i, Object obj) {
            if (obj == null) {
                return partnerTalkApi.chatMembers(j, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chatMembers");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendMessage$default(PartnerTalkApi partnerTalkApi, String str, String str2, long j, Map map, int i, Object obj) {
            if (obj == null) {
                return partnerTalkApi.sendMessage((i & 1) != 0 ? null : str, str2, j, (i & 8) != 0 ? null : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendMessage$default(PartnerTalkApi partnerTalkApi, String str, String str2, DefaultTemplate defaultTemplate, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return partnerTalkApi.sendMessage(str, str2, defaultTemplate);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendMessage$default(PartnerTalkApi partnerTalkApi, String str, String str2, String str3, Long l, Map map, int i, Object obj) {
            if (obj == null) {
                return partnerTalkApi.sendMessage((i & 1) != 0 ? null : str, str2, str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
        }
    }
}
