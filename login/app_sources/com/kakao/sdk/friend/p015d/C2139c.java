package com.kakao.sdk.friend.p015d;

import com.kakao.sdk.friend.network.model.PickerChatMemberInfo;
import com.kakao.sdk.friend.network.model.PickerChatMembers;
import com.kakao.sdk.network.ApiCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* renamed from: com.kakao.sdk.friend.d.c */
/* loaded from: classes3.dex */
public final class C2139c extends ApiCallback<PickerChatMemberInfo> {

    /* renamed from: a */
    public final /* synthetic */ C2138b f682a;

    /* renamed from: b */
    public final /* synthetic */ Function2<PickerChatMembers, Throwable, Unit> f683b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2139c(C2138b c2138b, Function2<? super PickerChatMembers, ? super Throwable, Unit> function2) {
        super(false);
        this.f682a = c2138b;
        this.f683b = function2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.network.ApiCallback
    public void onComplete(PickerChatMemberInfo pickerChatMemberInfo, Throwable th) {
        PickerChatMemberInfo pickerChatMemberInfo2 = pickerChatMemberInfo;
        this.f682a.f674g = pickerChatMemberInfo2 == null ? false : pickerChatMemberInfo2.m640b();
        this.f683b.invoke(pickerChatMemberInfo2 == null ? null : pickerChatMemberInfo2.m639a(), th);
    }
}
