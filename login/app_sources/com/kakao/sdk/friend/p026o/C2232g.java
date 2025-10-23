package com.kakao.sdk.friend.p026o;

import android.os.ResultReceiver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.DisableSelectReason;
import com.kakao.sdk.friend.network.model.PickerFriend;
import com.kakao.sdk.friend.network.model.PickerFriendRelation;
import com.kakao.sdk.friend.network.model.PickerRelation;
import com.kakao.sdk.friend.p015d.InterfaceC2137a;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p023l.C2196l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* renamed from: com.kakao.sdk.friend.o.g */
/* loaded from: classes3.dex */
public final class C2232g extends ViewModel {

    /* renamed from: a */
    public final InterfaceC2137a f959a;

    /* renamed from: b */
    public final boolean f960b;

    /* renamed from: c */
    public final C2171d f961c;

    /* renamed from: d */
    public final InternalFriendsParams f962d;

    /* renamed from: e */
    public final ResultReceiver f963e;

    /* renamed from: f */
    public final List<AbstractC2170c> f964f;

    /* renamed from: g */
    public final List<AbstractC2169b.a> f965g;

    /* renamed from: h */
    public final boolean f966h;

    /* renamed from: i */
    public final boolean f967i;

    /* renamed from: j */
    public final String f968j;

    /* renamed from: k */
    public final boolean f969k;

    /* renamed from: l */
    public final boolean f970l;

    /* renamed from: m */
    public final MutableLiveData<List<AbstractC2170c>> f971m;

    /* renamed from: n */
    public final MutableLiveData<Integer> f972n;

    /* renamed from: o */
    public final C2196l<AbstractC2182b> f973o;

    /* renamed from: p */
    public final MutableLiveData<AbstractC2181a> f974p;

    /* renamed from: q */
    public int f975q;

    /* renamed from: r */
    public boolean f976r;

    /* renamed from: s */
    public boolean f977s;

    /* renamed from: t */
    public String f978t;

    /* renamed from: u */
    public final Map<String, List<String>> f979u;

    /* renamed from: v */
    public Locale f980v;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2232g(InterfaceC2137a dataSource, boolean z) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.f959a = dataSource;
        this.f960b = z;
        C2171d m529a = C2171d.f793i.m529a();
        this.f961c = m529a;
        InternalFriendsParams m522a = m529a.m522a();
        if (m522a == null) {
            m522a = m529a.m524c();
            Intrinsics.checkNotNull(m522a);
        }
        this.f962d = m522a;
        this.f963e = m529a.m525d();
        this.f964f = new ArrayList();
        this.f965g = new ArrayList();
        boolean m528g = m529a.m528g();
        this.f966h = m528g;
        this.f967i = m529a.m527f();
        this.f968j = m522a.getTitle();
        this.f969k = m522a.getEnableSearch();
        this.f970l = !m528g && m522a.getShowPickedFriend();
        this.f971m = new MutableLiveData<>();
        this.f972n = new MutableLiveData<>();
        this.f973o = new C2196l<>();
        this.f974p = new MutableLiveData<>();
        this.f978t = "";
        List<DisableSelectOption> disableSelectOptions = m522a.getDisableSelectOptions();
        ArrayList<DisableSelectOption> arrayList = new ArrayList();
        for (Object obj : disableSelectOptions) {
            if (((DisableSelectOption) obj).getReason() == DisableSelectReason.CUSTOM) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (DisableSelectOption disableSelectOption : arrayList) {
            String message = disableSelectOption.getMessage();
            message = message == null ? "" : message;
            List<String> uuids = disableSelectOption.getUuids();
            if (uuids == null) {
                uuids = CollectionsKt.emptyList();
            }
            Pair m846to = TuplesKt.m846to(message, uuids);
            linkedHashMap.put(m846to.getFirst(), m846to.getSecond());
        }
        this.f979u = linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final AbstractC2182b.h m668a(AbstractC2169b.a aVar, boolean z) {
        int indexOf = this.f964f.indexOf(aVar);
        if (indexOf == -1) {
            return null;
        }
        return new AbstractC2182b.h((AbstractC2169b.a) this.f964f.get(indexOf), this.f964f.get(0) instanceof AbstractC2168a.b, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m671a(AbstractC2169b.a user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.f965g.remove(user);
        this.f972n.setValue(Integer.valueOf(this.f965g.size()));
        m674b(user, false);
        m676d();
        boolean z = !this.f969k && this.f970l && this.f965g.isEmpty();
        if (z) {
            this.f964f.remove(0);
            this.f975q--;
        }
        this.f973o.setValue(m668a(user, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m672a(PickerFriendRelation pickerFriendRelation) {
        PickerRelation m657b = pickerFriendRelation == null ? null : pickerFriendRelation.m657b();
        PickerRelation pickerRelation = PickerRelation.FRIEND;
        if (m657b != pickerRelation) {
            return (pickerFriendRelation != null ? pickerFriendRelation.m656a() : null) == pickerRelation;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final List<AbstractC2169b.a> m673b() {
        List<AbstractC2170c> list = this.f964f;
        return CollectionsKt.filterIsInstance(list.subList(this.f975q, list.size()), AbstractC2169b.a.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m670a() {
        Iterator<T> it = this.f965g.iterator();
        while (it.hasNext()) {
            ((AbstractC2169b.a) it.next()).f787g = false;
        }
        this.f965g.clear();
        this.f972n.setValue(Integer.valueOf(this.f965g.size()));
        m676d();
        this.f973o.setValue(AbstractC2182b.b.f812a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m674b(AbstractC2169b.a aVar, boolean z) {
        int i;
        Iterator<AbstractC2170c> it = this.f964f.iterator();
        int i2 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next(), aVar)) {
                break;
            } else {
                i2++;
            }
        }
        List<AbstractC2170c> list = this.f964f;
        ListIterator<AbstractC2170c> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            } else if (Intrinsics.areEqual(listIterator.previous(), aVar)) {
                i = listIterator.nextIndex();
                break;
            }
        }
        AbstractC2170c abstractC2170c = this.f964f.get(i2);
        AbstractC2169b.a aVar2 = abstractC2170c instanceof AbstractC2169b.a ? (AbstractC2169b.a) abstractC2170c : null;
        if (aVar2 != null) {
            aVar2.f787g = z;
        }
        if (i2 != i) {
            AbstractC2170c abstractC2170c2 = this.f964f.get(i);
            AbstractC2169b.a aVar3 = abstractC2170c2 instanceof AbstractC2169b.a ? (AbstractC2169b.a) abstractC2170c2 : null;
            if (aVar3 == null) {
                return;
            }
            aVar3.f787g = z;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final boolean m675c() {
        return (this.f961c.f801g == null || this.f960b) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final void m676d() {
        int size;
        Iterator<AbstractC2170c> it = this.f964f.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next() instanceof AbstractC2168a.b) {
                break;
            } else {
                i++;
            }
        }
        if (this.f962d.getDisableSelectOptions().isEmpty()) {
            size = m673b().size();
        } else {
            List<AbstractC2169b.a> m673b = m673b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : m673b) {
                if (((AbstractC2169b.a) obj).f785e == null) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        }
        boolean z = size == this.f965g.size();
        if (i != -1) {
            AbstractC2170c abstractC2170c = this.f964f.get(i);
            AbstractC2168a.b bVar = abstractC2170c instanceof AbstractC2168a.b ? (AbstractC2168a.b) abstractC2170c : null;
            if (bVar != null) {
                bVar.f780a = z;
            }
            this.f976r = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakao.sdk.friend.model.SelectedUser m669a(com.kakao.sdk.friend.p020i.AbstractC2169b.a r17, boolean r18, java.util.Map<java.lang.Long, com.kakao.sdk.friend.network.model.PickerUserScope> r19) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p026o.C2232g.m669a(com.kakao.sdk.friend.i.b$a, boolean, java.util.Map):com.kakao.sdk.friend.model.SelectedUser");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final AbstractC2169b.a m667a(PickerFriend pickerFriend) {
        Long m648e = pickerFriend.m648e();
        String m654k = pickerFriend.m654k();
        String m649f = pickerFriend.m649f();
        String m650g = pickerFriend.m650g();
        ArrayList arrayList = new ArrayList();
        for (DisableSelectOption disableSelectOption : this.f962d.getDisableSelectOptions()) {
            if (disableSelectOption.getReason() == DisableSelectReason.MSG_BLOCKED && Intrinsics.areEqual(pickerFriend.m645b(), Boolean.FALSE)) {
                arrayList.add(disableSelectOption);
            }
            if (disableSelectOption.getReason() == DisableSelectReason.REGISTERED && pickerFriend.m651h()) {
                arrayList.add(disableSelectOption);
            }
            if (disableSelectOption.getReason() == DisableSelectReason.UNREGISTERED && !pickerFriend.m651h()) {
                arrayList.add(disableSelectOption);
            }
            if (disableSelectOption.getReason() == DisableSelectReason.NOT_FRIEND && Intrinsics.areEqual(pickerFriend.m655l(), Boolean.FALSE)) {
                arrayList.add(disableSelectOption);
            }
            if (disableSelectOption.getReason() == DisableSelectReason.CUSTOM) {
                Map<String, List<String>> map = this.f979u;
                String message = disableSelectOption.getMessage();
                if (message == null) {
                    message = "";
                }
                List<String> list = map.get(message);
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                if (list.contains(pickerFriend.m654k())) {
                    arrayList.add(disableSelectOption);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new AbstractC2169b.a(m648e, m654k, m649f, m650g, arrayList, pickerFriend.m647d(), false, m672a(pickerFriend.m652i()), pickerFriend.m646c(), 64);
    }
}
