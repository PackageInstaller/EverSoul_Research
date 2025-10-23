package com.kakao.sdk.friend.p014c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kakao.sdk.friend.p016e.C2151j;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p023l.C2185a;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.c.b */
/* loaded from: classes3.dex */
public final class C2128b extends Lambda implements Function1<List<? extends Bitmap>, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2151j f648a;

    /* renamed from: b */
    public final /* synthetic */ C2129c f649b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC2168a.a f650c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2128b(C2151j c2151j, C2129c c2129c, AbstractC2168a.a aVar) {
        super(1);
        this.f648a = c2151j;
        this.f649b = c2129c;
        this.f650c = aVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends Bitmap> list) {
        List<? extends Bitmap> list2 = list;
        int i = 0;
        if (list2 == null || list2.isEmpty()) {
            C2151j c2151j = this.f648a;
            ImageView imageView = c2151j.f714e;
            C2129c c2129c = this.f649b;
            Context context = c2151j.f710a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            imageView.setImageBitmap(c2129c.m482a(context, this.f650c));
        } else {
            List mutableList = CollectionsKt.toMutableList((Collection) list2);
            int m480a = this.f649b.m480a(this.f650c, list2.size());
            C2129c c2129c2 = this.f649b;
            C2151j c2151j2 = this.f648a;
            while (i < m480a) {
                i++;
                Context context2 = c2151j2.f710a.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                mutableList.add(c2129c2.m481a(context2));
            }
            C2185a c2185a = C2185a.f829a;
            Context context3 = this.f648a.f710a.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "root.context");
            this.f648a.f714e.setImageBitmap(c2185a.m537a(context3, this.f650c.f772a, CollectionsKt.toMutableList((Collection) mutableList)));
        }
        return Unit.INSTANCE;
    }
}
