package com.kakao.sdk.friend.p014c;

import android.content.Context;
import android.graphics.Bitmap;
import com.kakao.sdk.friend.p016e.C2151j;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p023l.C2185a;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.c.a */
/* loaded from: classes3.dex */
public final class C2127a extends Lambda implements Function1<Bitmap, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2151j f646a;

    /* renamed from: b */
    public final /* synthetic */ AbstractC2168a.a f647b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2127a(C2151j c2151j, AbstractC2168a.a aVar) {
        super(1);
        this.f646a = c2151j;
        this.f647b = aVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Bitmap bitmap) {
        List<Bitmap> mutableListOf = CollectionsKt.mutableListOf(bitmap);
        C2185a c2185a = C2185a.f829a;
        Context context = this.f646a.f710a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        this.f646a.f714e.setImageBitmap(c2185a.m537a(context, this.f647b.f772a, mutableListOf));
        return Unit.INSTANCE;
    }
}
