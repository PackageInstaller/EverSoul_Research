package com.kakao.sdk.friend.p012a;

import android.content.Context;
import android.os.ResultReceiver;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.p020i.C2171d;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.a.b */
/* loaded from: classes3.dex */
public final class C2112b extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function3<SelectedUsers, SelectedChat, Throwable, Unit> f593a;

    /* renamed from: b */
    public final /* synthetic */ InternalTabParams f594b;

    /* renamed from: c */
    public final /* synthetic */ Context f595c;

    /* renamed from: d */
    public final /* synthetic */ boolean f596d;

    /* renamed from: e */
    public final /* synthetic */ boolean f597e;

    /* renamed from: f */
    public final /* synthetic */ ResultReceiver f598f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2112b(Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> function3, InternalTabParams internalTabParams, Context context, boolean z, boolean z2, ResultReceiver resultReceiver) {
        super(1);
        this.f593a = function3;
        this.f594b = internalTabParams;
        this.f595c = context;
        this.f596d = z;
        this.f597e = z2;
        this.f598f = resultReceiver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        if (th2 != null) {
            C2120j.f621b = null;
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d);
            c2171d.getClass();
            C2171d.f794j = null;
            this.f593a.invoke(null, null, th2);
        } else {
            List<PickerChatFilter> chatFilters = this.f594b.getChatParams().getChatFilters();
            if (chatFilters == null || chatFilters.isEmpty()) {
                chatFilters = CollectionsKt.listOf(PickerChatFilter.REGULAR);
            }
            C2120j.f620a.m478b().mo495a(chatFilters, new C2111a(this.f593a, this.f595c, this.f596d, this.f597e, this.f594b, this.f598f));
        }
        return Unit.INSTANCE;
    }
}
