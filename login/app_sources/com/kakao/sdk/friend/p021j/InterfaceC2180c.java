package com.kakao.sdk.friend.p021j;

import com.kakao.sdk.friend.network.model.PickerScopeGroup;
import com.kakao.sdk.friend.network.model.PickerUserScope;
import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(m837bv = {}, m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/friend/j/c;", "", "Lcom/kakao/sdk/friend/network/model/PickerScopeGroup;", "scopeGroup", "", "targetIds", "Lretrofit2/Call;", "", "Lcom/kakao/sdk/friend/network/model/PickerUserScope;", "a", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.j.c */
/* loaded from: classes3.dex */
public interface InterfaceC2180c {
    @GET("v2/user/scopes/sdk")
    /* renamed from: a */
    Call<List<PickerUserScope>> m535a(@Query("scope_group") PickerScopeGroup scopeGroup, @Query("target_ids") String targetIds);
}
