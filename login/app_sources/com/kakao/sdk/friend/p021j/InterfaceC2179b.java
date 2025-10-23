package com.kakao.sdk.friend.p021j;

import com.kakao.sdk.friend.model.PickerFriendFilter;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.network.model.PickerChatMemberInfo;
import com.kakao.sdk.friend.network.model.PickerChats;
import com.kakao.sdk.friend.network.model.PickerUsers;
import com.kakao.sdk.partner.talk.Constants;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(m837bv = {}, m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JE\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\f\u0010\rJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\b\b\u0001\u0010\u0012\u001a\u00020\u0011H'¨\u0006\u0014"}, m839d2 = {"Lcom/kakao/sdk/friend/j/b;", "", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "serviceTypeFilter", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "friendFilter", "", "limit", "", "countryCodes", "Lretrofit2/Call;", "Lcom/kakao/sdk/friend/network/model/PickerUsers;", "a", "(Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;Lcom/kakao/sdk/friend/model/PickerFriendFilter;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", Constants.FILTER, "Lcom/kakao/sdk/friend/network/model/PickerChats;", "(Ljava/lang/String;Ljava/lang/Integer;)Lretrofit2/Call;", "", "chatId", "Lcom/kakao/sdk/friend/network/model/PickerChatMemberInfo;", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.j.b */
/* loaded from: classes3.dex */
public interface InterfaceC2179b {
    @GET("/v1/api/talk/members/sdk")
    /* renamed from: a */
    Call<PickerChatMemberInfo> m532a(@Query("chat_id") long chatId);

    @GET("v1/friends/sdk")
    /* renamed from: a */
    Call<PickerUsers> m533a(@Query("friend_type") PickerServiceTypeFilter serviceTypeFilter, @Query("friend_filter") PickerFriendFilter friendFilter, @Query("limit") Integer limit, @Query("country_codes") String countryCodes);

    @GET("/v1/api/talk/chat/list/sdk")
    /* renamed from: a */
    Call<PickerChats> m534a(@Query("filter") String filter, @Query("limit") Integer limit);
}
