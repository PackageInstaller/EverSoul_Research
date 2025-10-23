package com.kakao.sdk.friend.p015d;

import com.kakao.sdk.friend.network.model.PickerChats;
import com.kakao.sdk.network.ApiCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* renamed from: com.kakao.sdk.friend.d.d */
/* loaded from: classes3.dex */
public final class C2140d extends ApiCallback<PickerChats> {

    /* renamed from: a */
    public final /* synthetic */ Function2<PickerChats, Throwable, Unit> f684a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2140d(Function2<? super PickerChats, ? super Throwable, Unit> function2) {
        super(false);
        this.f684a = function2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.network.ApiCallback
    public void onComplete(PickerChats pickerChats, Throwable th) {
        this.f684a.invoke(pickerChats, th);
    }
}
