package com.kakao.sdk.friend.p026o;

import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.friend.network.model.PickerUserScope;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* renamed from: com.kakao.sdk.friend.o.f */
/* loaded from: classes3.dex */
public final class C2231f extends Lambda implements Function2<List<? extends PickerUserScope>, Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function1<Throwable, Unit> f957a;

    /* renamed from: b */
    public final /* synthetic */ Function1<Map<Long, PickerUserScope>, Unit> f958b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2231f(Function1<? super Throwable, Unit> function1, Function1<? super Map<Long, PickerUserScope>, Unit> function12) {
        super(2);
        this.f957a = function1;
        this.f958b = function12;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(List<? extends PickerUserScope> list, Throwable th) {
        Map<Long, PickerUserScope> map;
        List<? extends PickerUserScope> list2 = list;
        Throwable th2 = th;
        if (th2 != null) {
            SdkLog.INSTANCE.m470e(Intrinsics.stringPlus("동의 항목 체크 에러: ", th2));
            this.f957a.invoke(th2);
        } else {
            Function1<Map<Long, PickerUserScope>, Unit> function1 = this.f958b;
            if (list2 == null) {
                map = null;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                for (PickerUserScope pickerUserScope : list2) {
                    Pair m846to = TuplesKt.m846to(Long.valueOf(pickerUserScope.m660b()), pickerUserScope);
                    linkedHashMap.put(m846to.getFirst(), m846to.getSecond());
                }
                map = linkedHashMap;
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            function1.invoke(map);
        }
        return Unit.INSTANCE;
    }
}
