package com.kakao.sdk.friend.p015d;

import com.kakao.sdk.friend.network.model.PickerUsers;
import com.kakao.sdk.network.ApiCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* renamed from: com.kakao.sdk.friend.d.e */
/* loaded from: classes3.dex */
public final class C2141e extends ApiCallback<PickerUsers> {

    /* renamed from: a */
    public final /* synthetic */ Function2<PickerUsers, Throwable, Unit> f685a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2141e(Function2<? super PickerUsers, ? super Throwable, Unit> function2) {
        super(false);
        this.f685a = function2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.network.ApiCallback
    public void onComplete(PickerUsers pickerUsers, Throwable th) {
        this.f685a.invoke(pickerUsers, th);
    }
}
