package com.kakao.sdk.friend.p012a;

import android.content.Context;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.KakaoResultReceiver;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUsers;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.a.e */
/* loaded from: classes3.dex */
public final class C2115e extends Lambda implements Function2<OAuthToken, Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function3<SelectedUsers, SelectedChat, Throwable, Unit> f608a;

    /* renamed from: b */
    public final /* synthetic */ Context f609b;

    /* renamed from: c */
    public final /* synthetic */ boolean f610c;

    /* renamed from: d */
    public final /* synthetic */ boolean f611d;

    /* renamed from: e */
    public final /* synthetic */ InternalTabParams f612e;

    /* renamed from: f */
    public final /* synthetic */ KakaoResultReceiver<Function3<SelectedUsers, SelectedChat, Throwable, Unit>> f613f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2115e(Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> function3, Context context, boolean z, boolean z2, InternalTabParams internalTabParams, KakaoResultReceiver<Function3<SelectedUsers, SelectedChat, Throwable, Unit>> kakaoResultReceiver) {
        super(2);
        this.f608a = function3;
        this.f609b = context;
        this.f610c = z;
        this.f611d = z2;
        this.f612e = internalTabParams;
        this.f613f = kakaoResultReceiver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(OAuthToken oAuthToken, Throwable th) {
        Throwable th2 = th;
        if (th2 != null) {
            this.f608a.invoke(null, null, th2);
        } else {
            C2119i.m474a(C2119i.f619a, this.f609b, this.f610c, this.f611d, this.f612e, this.f613f, this.f608a);
        }
        return Unit.INSTANCE;
    }
}
