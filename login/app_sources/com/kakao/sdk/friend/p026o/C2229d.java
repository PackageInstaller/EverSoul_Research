package com.kakao.sdk.friend.p026o;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.kakao.sdk.friend.network.model.PickerUserScope;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.o.d */
/* loaded from: classes3.dex */
public final class C2229d extends Lambda implements Function1<Map<Long, ? extends PickerUserScope>, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2232g f955a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2229d(C2232g c2232g) {
        super(1);
        this.f955a = c2232g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Map<Long, ? extends PickerUserScope> map) {
        Map<Long, ? extends PickerUserScope> scopeMap = map;
        Intrinsics.checkNotNullParameter(scopeMap, "scopeMap");
        C2232g c2232g = this.f955a;
        boolean displayAllProfile = c2232g.f962d.getDisplayAllProfile();
        List<AbstractC2169b.a> list = c2232g.f965g;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            AbstractC2169b.a aVar = (AbstractC2169b.a) it.next();
            if (c2232g.f959a.mo496b() && displayAllProfile) {
                z = true;
            }
            arrayList.add(c2232g.m669a(aVar, z, scopeMap));
        }
        ResultReceiver resultReceiver = c2232g.f963e;
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            Integer value = c2232g.f972n.getValue();
            if (value == null) {
                value = 0;
            }
            bundle.putInt("key.selected.totalcount", value.intValue());
            bundle.putParcelableArrayList("key.selected.friends", new ArrayList<>(arrayList));
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(-1, bundle);
        }
        this.f955a.f973o.setValue(AbstractC2182b.c.f813a);
        return Unit.INSTANCE;
    }
}
