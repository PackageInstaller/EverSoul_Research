package com.kakao.sdk.friend.p024m;

import android.content.Context;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p022k.EnumC2183c;
import com.kakao.sdk.friend.p023l.C2194j;
import com.kakao.sdk.friend.p026o.C2232g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.kakao.sdk.friend.m.q */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2214q extends FunctionReferenceImpl implements Function2<Context, String, Unit> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2214q(Object obj) {
        super(2, obj, C2232g.class, "searchFriends", "searchFriends(Landroid/content/Context;Ljava/lang/String;)V", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Context context, String str) {
        Context context2 = context;
        String searchText = str;
        Intrinsics.checkNotNullParameter(context2, "p0");
        Intrinsics.checkNotNullParameter(searchText, "p1");
        C2232g c2232g = (C2232g) this.receiver;
        c2232g.getClass();
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        if (!Intrinsics.areEqual(c2232g.f978t, searchText)) {
            c2232g.f978t = searchText;
            if (StringsKt.isBlank(searchText)) {
                c2232g.f973o.setValue(new AbstractC2182b.e(EnumC2183c.DONE));
                c2232g.f971m.setValue(c2232g.f964f);
            } else {
                c2232g.f973o.setValue(new AbstractC2182b.e(EnumC2183c.SEARCHING));
                String string = context2.getString(C2110R.string.search_result);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.search_result)");
                List<AbstractC2170c> mutableListOf = CollectionsKt.mutableListOf(new AbstractC2170c.c(string));
                List<AbstractC2169b.a> m673b = c2232g.m673b();
                ArrayList arrayList = new ArrayList();
                for (Object obj : m673b) {
                    String str2 = ((AbstractC2169b.a) obj).f783c;
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (C2194j.m554a(str2, searchText)) {
                        arrayList.add(obj);
                    }
                }
                mutableListOf.addAll(arrayList);
                if (mutableListOf.size() == 1) {
                    mutableListOf.clear();
                    mutableListOf.add(AbstractC2170c.b.f791a);
                }
                c2232g.f971m.setValue(mutableListOf);
            }
        }
        return Unit.INSTANCE;
    }
}
