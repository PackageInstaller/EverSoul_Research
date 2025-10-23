package com.kakao.sdk.friend.p018g;

import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0007"}, m839d2 = {"Lcom/kakao/sdk/friend/g/c;", "", "", "imageUrl", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "a", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.g.c */
/* loaded from: classes3.dex */
public interface InterfaceC2163c {
    @GET
    /* renamed from: a */
    Call<ResponseBody> m520a(@Url String imageUrl);
}
