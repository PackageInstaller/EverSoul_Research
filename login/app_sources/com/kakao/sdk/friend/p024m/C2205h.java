package com.kakao.sdk.friend.p024m;

import android.content.Context;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p022k.EnumC2183c;
import com.kakao.sdk.friend.p023l.C2194j;
import com.kakao.sdk.friend.p026o.C2227b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* renamed from: com.kakao.sdk.friend.m.h */
/* loaded from: classes3.dex */
public final class C2205h extends Lambda implements Function2<Context, String, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2199b f878a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2205h(C2199b c2199b) {
        super(2);
        this.f878a = c2199b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Context context, String str) {
        Context noName_0 = context;
        String searchText = str;
        Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
        Intrinsics.checkNotNullParameter(searchText, "text");
        C2199b c2199b = this.f878a;
        int i = C2199b.f862h;
        C2227b m574d = c2199b.m574d();
        m574d.getClass();
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        if (!Intrinsics.areEqual(m574d.f953p, searchText)) {
            m574d.f953p = searchText;
            if (StringsKt.isBlank(searchText)) {
                m574d.f951n.setValue(new AbstractC2182b.e(EnumC2183c.DONE));
                m574d.f944g.setValue(m574d.f941d);
            } else {
                m574d.f951n.setValue(new AbstractC2182b.e(EnumC2183c.SEARCHING));
                ArrayList arrayList = new ArrayList();
                List<AbstractC2168a.a> list = m574d.f942e;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    String str2 = ((AbstractC2168a.a) obj).f773b;
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (C2194j.m554a(str2, searchText)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList.addAll(arrayList2);
                if (arrayList.isEmpty()) {
                    arrayList.clear();
                    arrayList.add(AbstractC2170c.b.f791a);
                }
                m574d.f944g.setValue(arrayList);
            }
        }
        return Unit.INSTANCE;
    }
}
