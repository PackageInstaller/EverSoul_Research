package com.kakao.sdk.friend.p015d;

import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.PickerFriendFilter;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.network.model.C2225Me;
import com.kakao.sdk.friend.network.model.PickerChat;
import com.kakao.sdk.friend.network.model.PickerChatMembers;
import com.kakao.sdk.friend.network.model.PickerFriend;
import com.kakao.sdk.friend.network.model.PickerScopeGroup;
import com.kakao.sdk.friend.network.model.PickerUserScope;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* renamed from: com.kakao.sdk.friend.d.a */
/* loaded from: classes3.dex */
public interface InterfaceC2137a {
    /* renamed from: a */
    C2225Me mo491a();

    /* renamed from: a */
    void mo492a(long j, Function1<? super Throwable, Unit> function1);

    /* renamed from: a */
    void mo493a(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, Function1<? super Throwable, Unit> function1);

    /* renamed from: a */
    void mo494a(PickerScopeGroup pickerScopeGroup, List<Long> list, Function2<? super List<PickerUserScope>, ? super Throwable, Unit> function2);

    /* renamed from: a */
    void mo495a(List<? extends PickerChatFilter> list, Function1<? super Throwable, Unit> function1);

    /* renamed from: b */
    boolean mo496b();

    /* renamed from: c */
    List<PickerChat> mo497c();

    /* renamed from: d */
    PickerChatMembers mo498d();

    /* renamed from: e */
    List<PickerFriend> mo499e();
}
