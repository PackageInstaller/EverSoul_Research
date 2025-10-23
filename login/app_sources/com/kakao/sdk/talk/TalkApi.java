package com.kakao.sdk.talk;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.talk.model.Channels;
import com.kakao.sdk.talk.model.Friend;
import com.kakao.sdk.talk.model.FriendOrder;
import com.kakao.sdk.talk.model.Friends;
import com.kakao.sdk.talk.model.MessageSendResult;
import com.kakao.sdk.talk.model.Order;
import com.kakao.sdk.talk.model.TalkProfile;
import com.kakao.sdk.template.model.DefaultTemplate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: TalkApi.kt */
@Metadata(m838d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'JI\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H'J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u00182\u0016\b\u0003\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH'J:\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u00182\u0016\b\u0003\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH'J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u001f\u001a\u00020 H'J\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020 H'JA\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010#\u001a\u00020\u00062\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0016\b\u0003\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH'¢\u0006\u0002\u0010$JK\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010#\u001a\u00020\u00062\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0016\b\u0003\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH'¢\u0006\u0002\u0010&¨\u0006'"}, m839d2 = {"Lcom/kakao/sdk/talk/TalkApi;", "", Constants.CHANNELS, "Lretrofit2/Call;", "Lcom/kakao/sdk/talk/model/Channels;", "channelIds", "", "channelIdType", NativeProtocol.AUDIENCE_FRIENDS, "Lcom/kakao/sdk/talk/model/Friends;", "Lcom/kakao/sdk/talk/model/Friend;", "offset", "", "limit", Constants.ORDER, "Lcom/kakao/sdk/talk/model/Order;", "friendOrder", "Lcom/kakao/sdk/talk/model/FriendOrder;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lcom/kakao/sdk/talk/model/FriendOrder;)Lretrofit2/Call;", "profile", "Lcom/kakao/sdk/talk/model/TalkProfile;", "sendCustomMemo", "", "templateId", "", "templateArgs", "", "sendCustomMessage", "Lcom/kakao/sdk/talk/model/MessageSendResult;", "receiverUuids", "sendDefaultMemo", SDKConstants.PARAM_UPDATE_TEMPLATE, "Lcom/kakao/sdk/template/model/DefaultTemplate;", "sendDefaultMessage", "sendScrapMemo", "requestUrl", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lretrofit2/Call;", "sendScrapMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lretrofit2/Call;", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface TalkApi {
    @GET(Constants.V2_CHANNELS_PATH)
    Call<Channels> channels(@Query("channel_ids") String channelIds, @Query("channel_id_type") String channelIdType);

    @GET(Constants.V1_FRIENDS_PATH)
    Call<Friends<Friend>> friends(@Query("offset") Integer offset, @Query("limit") Integer limit, @Query("order") Order order, @Query("friend_order") FriendOrder friendOrder);

    @GET(Constants.PROFILE_PATH)
    Call<TalkProfile> profile();

    @FormUrlEncoded
    @POST(Constants.V2_MEMO_PATH)
    Call<Unit> sendCustomMemo(@Field("template_id") long templateId, @Field("template_args") Map<String, String> templateArgs);

    @FormUrlEncoded
    @POST(Constants.V1_OPEN_TALK_MESSAGE_CUSTOM_PATH)
    Call<MessageSendResult> sendCustomMessage(@Field("receiver_uuids") String receiverUuids, @Field("template_id") long templateId, @Field("template_args") Map<String, String> templateArgs);

    @FormUrlEncoded
    @POST(Constants.V2_MEMO_DEFAULT_PATH)
    Call<Unit> sendDefaultMemo(@Field("template_object") DefaultTemplate template);

    @FormUrlEncoded
    @POST(Constants.V1_OPEN_TALK_MESSAGE_DEFAULT_PATH)
    Call<MessageSendResult> sendDefaultMessage(@Field("receiver_uuids") String receiverUuids, @Field("template_object") DefaultTemplate template);

    @FormUrlEncoded
    @POST(Constants.V2_MEMO_SCRAP_PATH)
    Call<Unit> sendScrapMemo(@Field("request_url") String requestUrl, @Field("template_id") Long templateId, @Field("template_args") Map<String, String> templateArgs);

    @FormUrlEncoded
    @POST(Constants.V1_OPEN_TALK_MESSAGE_SCRAP_PATH)
    Call<MessageSendResult> sendScrapMessage(@Field("receiver_uuids") String receiverUuids, @Field("request_url") String requestUrl, @Field("template_id") Long templateId, @Field("template_args") Map<String, String> templateArgs);

    /* compiled from: TalkApi.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call friends$default(TalkApi talkApi, Integer num, Integer num2, Order order, FriendOrder friendOrder, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: friends");
            }
            if ((i & 1) != 0) {
                num = null;
            }
            if ((i & 2) != 0) {
                num2 = null;
            }
            if ((i & 4) != 0) {
                order = null;
            }
            if ((i & 8) != 0) {
                friendOrder = null;
            }
            return talkApi.friends(num, num2, order, friendOrder);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendCustomMemo$default(TalkApi talkApi, long j, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCustomMemo");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return talkApi.sendCustomMemo(j, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendScrapMemo$default(TalkApi talkApi, String str, Long l, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendScrapMemo");
            }
            if ((i & 2) != 0) {
                l = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return talkApi.sendScrapMemo(str, l, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendCustomMessage$default(TalkApi talkApi, String str, long j, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCustomMessage");
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return talkApi.sendCustomMessage(str, j, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call sendScrapMessage$default(TalkApi talkApi, String str, String str2, Long l, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendScrapMessage");
            }
            if ((i & 8) != 0) {
                map = null;
            }
            return talkApi.sendScrapMessage(str, str2, l, map);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Call channels$default(TalkApi talkApi, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: channels");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = "channel_public_id";
            }
            return talkApi.channels(str, str2);
        }
    }
}
