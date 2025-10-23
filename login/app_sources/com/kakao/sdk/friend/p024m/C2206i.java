package com.kakao.sdk.friend.p024m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.auth.Constants;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.model.PickerUsingOsFilter;
import com.kakao.sdk.friend.network.model.C2225Me;
import com.kakao.sdk.friend.network.model.PickerChatMember;
import com.kakao.sdk.friend.network.model.PickerChatMembers;
import com.kakao.sdk.friend.network.model.PickerFriend;
import com.kakao.sdk.friend.network.model.PickerScopeGroup;
import com.kakao.sdk.friend.p012a.C2120j;
import com.kakao.sdk.friend.p013b.C2122b;
import com.kakao.sdk.friend.p013b.C2123c;
import com.kakao.sdk.friend.p013b.C2125e;
import com.kakao.sdk.friend.p016e.C2145d;
import com.kakao.sdk.friend.p016e.C2147f;
import com.kakao.sdk.friend.p016e.C2149h;
import com.kakao.sdk.friend.p016e.C2155n;
import com.kakao.sdk.friend.p016e.C2156o;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p022k.EnumC2183c;
import com.kakao.sdk.friend.p022k.EnumC2184d;
import com.kakao.sdk.friend.p023l.C2187c;
import com.kakao.sdk.friend.p025n.C2222a;
import com.kakao.sdk.friend.p025n.C2223b;
import com.kakao.sdk.friend.p025n.C2224c;
import com.kakao.sdk.friend.p026o.C2229d;
import com.kakao.sdk.friend.p026o.C2230e;
import com.kakao.sdk.friend.p026o.C2231f;
import com.kakao.sdk.friend.p026o.C2232g;
import com.kakao.sdk.friend.p026o.C2233h;
import com.kakao.sdk.friend.p026o.C2234i;
import com.kakao.sdk.friend.view.EmptyView;
import com.kakao.sdk.friend.view.NestedScrollableHost;
import com.kakao.sdk.friend.view.SideIndexView;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(m837bv = {}, m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m839d2 = {"Lcom/kakao/sdk/friend/m/i;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.m.i */
/* loaded from: classes3.dex */
public final class C2206i extends Fragment {

    /* renamed from: j */
    public static final /* synthetic */ int f879j = 0;

    /* renamed from: a */
    public C2147f f880a;

    /* renamed from: b */
    public C2156o f881b;

    /* renamed from: c */
    public C2155n f882c;

    /* renamed from: d */
    public C2218u f883d;

    /* renamed from: e */
    public C2149h f884e;

    /* renamed from: f */
    public final Lazy f885f = LazyKt.lazy(new c());

    /* renamed from: g */
    public final Lazy f886g = LazyKt.lazy(new b());

    /* renamed from: h */
    public final Lazy f887h = LazyKt.lazy(new d());

    /* renamed from: i */
    public C2234i f888i;

    /* renamed from: com.kakao.sdk.friend.m.i$a */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f889a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[EnumC2184d.values().length];
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
            f889a = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m578a(C2206i this$0, EnumC2184d enumC2184d) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = enumC2184d == null ? -1 : a.f889a[enumC2184d.ordinal()];
        if (i == 1) {
            this$0.m588g();
            return;
        }
        if (i == 2) {
            this$0.m581a();
        } else {
            if (i != 3) {
                return;
            }
            C2218u c2218u = this$0.f883d;
            if (c2218u != null) {
                c2218u.m592a();
            }
            this$0.m586e().m670a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m581a() {
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager2 = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager2.popBackStack();
        }
        FragmentActivity activity2 = getActivity();
        if ((activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || supportFragmentManager.getBackStackEntryCount() != 0) ? false : true) {
            m582a(new ClientError(ClientErrorCause.Cancelled, "cancelled."));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final C2122b m584c() {
        return (C2122b) this.f886g.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final C2125e m585d() {
        return (C2125e) this.f885f.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public final C2232g m586e() {
        return (C2232g) this.f887h.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f880a = null;
    }

    /* renamed from: com.kakao.sdk.friend.m.i$b */
    public static final class b extends Lambda implements Function0<C2122b> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public C2122b invoke() {
            C2206i c2206i = C2206i.this;
            int i = C2206i.f879j;
            return new C2122b(c2206i.m586e().f967i, C2206i.this.m586e().f966h, new C2207j(C2206i.this), new C2208k(C2206i.this), new C2209l(C2206i.this), new C2210m(C2206i.this));
        }
    }

    /* renamed from: com.kakao.sdk.friend.m.i$c */
    public static final class c extends Lambda implements Function0<C2125e> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public c() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public C2125e invoke() {
            C2206i c2206i = C2206i.this;
            int i = C2206i.f879j;
            if (c2206i.m586e().f970l) {
                return new C2125e(CollectionsKt.toMutableList((Collection) C2206i.this.m586e().f965g), new C2215r(C2206i.this));
            }
            return null;
        }
    }

    /* renamed from: com.kakao.sdk.friend.m.i$d */
    public static final class d extends Lambda implements Function0<C2232g> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public d() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public C2232g invoke() {
            Bundle arguments = C2206i.this.getArguments();
            ViewModel viewModel = new ViewModelProvider(C2206i.this, new C2233h(C2120j.f620a.m478b(), arguments == null ? false : arguments.getBoolean("key.chat.member.picker"))).get(C2232g.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     …endViewModel::class.java]");
            return (C2232g) viewModel;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m577a(C2206i this$0, AbstractC2182b it) {
        int i;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.getClass();
        if (it instanceof AbstractC2182b.h) {
            C2122b m584c = this$0.m584c();
            AbstractC2182b.h event = (AbstractC2182b.h) it;
            m584c.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.f819b) {
                m584c.notifyItemChanged(0);
            }
            if (event.f820c) {
                if (m584c.f635g.get(0) instanceof AbstractC2170c.a) {
                    m584c.f635g.remove(0);
                    m584c.notifyItemRemoved(0);
                } else {
                    m584c.f635g.add(0, AbstractC2170c.a.f790a);
                    m584c.notifyItemInserted(0);
                    RecyclerView recyclerView = m584c.f636h;
                    RecyclerView recyclerView2 = null;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                        recyclerView = null;
                    }
                    if (recyclerView.computeVerticalScrollOffset() == 0) {
                        RecyclerView recyclerView3 = m584c.f636h;
                        if (recyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                        } else {
                            recyclerView2 = recyclerView3;
                        }
                        recyclerView2.scrollToPosition(0);
                    }
                }
            }
            Iterator<AbstractC2170c> it2 = m584c.f635g.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                } else if (Intrinsics.areEqual(it2.next(), event.f818a)) {
                    break;
                } else {
                    i2++;
                }
            }
            List<AbstractC2170c> list = m584c.f635g;
            ListIterator<AbstractC2170c> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(listIterator.previous(), event.f818a)) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
            if (i2 != -1) {
                m584c.notifyItemChanged(i2);
                if (i2 != i) {
                    m584c.notifyItemChanged(i);
                }
            }
            C2125e m585d = this$0.m585d();
            if (m585d == null) {
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            AbstractC2169b.a aVar = event.f818a;
            if (m585d.f643a.contains(aVar)) {
                int indexOf = m585d.f643a.indexOf(aVar);
                if (indexOf > -1) {
                    m585d.f643a.remove(indexOf);
                    m585d.notifyItemRemoved(indexOf);
                    return;
                }
                return;
            }
            boolean isEmpty = m585d.f643a.isEmpty();
            m585d.f643a.add(0, aVar);
            if (isEmpty) {
                m585d.notifyDataSetChanged();
            } else {
                m585d.notifyItemInserted(0);
            }
            RecyclerView recyclerView4 = m585d.f645c;
            if (recyclerView4 == null) {
                return;
            }
            recyclerView4.scrollToPosition(0);
            return;
        }
        if (it instanceof AbstractC2182b.f) {
            this$0.m584c().notifyDataSetChanged();
            C2125e m585d2 = this$0.m585d();
            if (m585d2 == null) {
                return;
            }
            AbstractC2182b.f event2 = (AbstractC2182b.f) it;
            Intrinsics.checkNotNullParameter(event2, "event");
            List<AbstractC2169b.a> list2 = event2.f816a;
            m585d2.f643a.addAll(0, list2);
            m585d2.notifyItemRangeInserted(0, list2.size());
            RecyclerView recyclerView5 = m585d2.f645c;
            if (recyclerView5 == null) {
                return;
            }
            recyclerView5.scrollToPosition(0);
            return;
        }
        if (it instanceof AbstractC2182b.b) {
            this$0.m584c().notifyDataSetChanged();
            C2125e m585d3 = this$0.m585d();
            if (m585d3 == null) {
                return;
            }
            m585d3.f643a.clear();
            m585d3.notifyDataSetChanged();
            return;
        }
        if (it instanceof AbstractC2182b.e) {
            EnumC2183c status = ((AbstractC2182b.e) it).f815a;
            C2149h c2149h = this$0.f884e;
            if (c2149h == null) {
                return;
            }
            Intrinsics.checkNotNullParameter(c2149h, "<this>");
            Intrinsics.checkNotNullParameter(status, "status");
            c2149h.f706b.scrollToPosition(0);
            if (status == EnumC2183c.SEARCHING) {
                c2149h.f706b.removeOnScrollListener(c2149h.f707c.getOnScrollListener());
                return;
            } else {
                if (status == EnumC2183c.DONE) {
                    c2149h.f706b.addOnScrollListener(c2149h.f707c.getOnScrollListener());
                    return;
                }
                return;
            }
        }
        if (it instanceof AbstractC2182b.c) {
            this$0.m583b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m583b() {
        Unit unit;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            unit = null;
        } else {
            activity.finish();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SdkLog.INSTANCE.m470e("FriendPickerFragment not attached to an activity.");
            C2120j.f621b = null;
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d);
            c2171d.getClass();
            C2171d.f794j = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f */
    public final void m587f() {
        MutableLiveData<EnumC2184d> mutableLiveData;
        m586e().f973o.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.i$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2206i.m577a(C2206i.this, (AbstractC2182b) obj);
            }
        });
        m586e().f974p.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.i$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2206i.m576a(C2206i.this, (AbstractC2181a) obj);
            }
        });
        m586e().f971m.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.i$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2206i.m580a(C2206i.this, (List) obj);
            }
        });
        m586e().f972n.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.i$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2206i.m579a(C2206i.this, (Integer) obj);
            }
        });
        C2234i c2234i = this.f888i;
        if (c2234i == null || (mutableLiveData = c2234i.f989g) == null) {
            return;
        }
        mutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.i$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2206i.m578a(C2206i.this, (EnumC2184d) obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: g */
    public final void m588g() {
        C2232g m586e = m586e();
        int minPickableCount = m586e.f966h ? 1 : m586e.f962d.getMinPickableCount();
        int maxPickableCount = m586e.f966h ? 1 : m586e.f962d.getMaxPickableCount();
        int size = m586e.f965g.size();
        AbstractC2181a cVar = size < minPickableCount ? new AbstractC2181a.c(minPickableCount) : size > maxPickableCount ? new AbstractC2181a.b(maxPickableCount) : null;
        if (cVar == null) {
            C2229d c2229d = new C2229d(m586e);
            C2230e c2230e = new C2230e(m586e);
            PickerScopeGroup pickerScopeGroup = m586e.f961c.f799e != null ? PickerScopeGroup.CHAT_MEMBER : PickerScopeGroup.FRIEND;
            List<AbstractC2169b.a> list = m586e.f965g;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((AbstractC2169b.a) obj).f781a != null) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Long l = ((AbstractC2169b.a) it.next()).f781a;
                if (l != null) {
                    arrayList2.add(l);
                }
            }
            m586e.f959a.mo494a(pickerScopeGroup, arrayList2, new C2231f(c2230e, c2229d));
            return;
        }
        m586e.f974p.setValue(cVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View findChildViewById;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(C2110R.layout.kakao_sdk_fragment_friend_picker, viewGroup, false);
        int i = C2110R.id.empty_friend_view;
        EmptyView emptyView = (EmptyView) ViewBindings.findChildViewById(inflate, i);
        if (emptyView != null && (findChildViewById = ViewBindings.findChildViewById(inflate, (i = C2110R.id.error_retry_view))) != null) {
            C2145d m504a = C2145d.m504a(findChildViewById);
            int i2 = C2110R.id.main_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, i2);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                C2147f c2147f = new C2147f(constraintLayout, emptyView, m504a, linearLayout);
                this.f880a = c2147f;
                Intrinsics.checkNotNull(c2147f);
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.root");
                return constraintLayout;
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        RecyclerView recyclerView;
        boolean z;
        List<PickerChatMember> m642b;
        Boolean bool;
        RecyclerView recyclerView2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        boolean z2 = m586e().f966h;
        boolean z3 = m586e().f967i;
        boolean z4 = false;
        if (!m586e().m675c()) {
            C2147f c2147f = this.f880a;
            Intrinsics.checkNotNull(c2147f);
            LinearLayout linearLayout = c2147f.f697c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mainLayout");
            LayoutInflater layoutInflater = getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
            String str = m586e().f968j;
            if (str == null) {
                str = getString(C2110R.string.select_friend);
                Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.select_friend)");
            }
            this.f881b = C2224c.m616a(linearLayout, layoutInflater, str, !z2, false);
        }
        if (!z2 && m586e().f970l) {
            C2147f c2147f2 = this.f880a;
            Intrinsics.checkNotNull(c2147f2);
            LinearLayout linearLayout2 = c2147f2.f697c;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.mainLayout");
            LayoutInflater layoutInflater2 = getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater2, "layoutInflater");
            Intrinsics.checkNotNullParameter(linearLayout2, "<this>");
            Intrinsics.checkNotNullParameter(layoutInflater2, "layoutInflater");
            View inflate = layoutInflater2.inflate(C2110R.layout.kakao_sdk_picked_friends_view, (ViewGroup) linearLayout2, false);
            int i = C2110R.id.picked_friends_rv;
            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(inflate, i);
            if (recyclerView3 != null) {
                NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) inflate;
                C2155n c2155n = new C2155n(nestedScrollableHost, recyclerView3);
                Intrinsics.checkNotNullExpressionValue(c2155n, "inflate(layoutInflater, this, false)");
                linearLayout2.addView(nestedScrollableHost);
                this.f882c = c2155n;
            } else {
                throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
            }
        }
        if (m586e().f969k) {
            C2147f c2147f3 = this.f880a;
            Intrinsics.checkNotNull(c2147f3);
            LinearLayout linearLayout3 = c2147f3.f697c;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.mainLayout");
            String string = getString(C2110R.string.search_bar_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.search_bar_hint)");
            this.f883d = C2223b.m615a(linearLayout3, string);
        }
        C2147f c2147f4 = this.f880a;
        Intrinsics.checkNotNull(c2147f4);
        LinearLayout linearLayout4 = c2147f4.f697c;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.mainLayout");
        LayoutInflater layoutInflater3 = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater3, "layoutInflater");
        C2232g m586e = m586e();
        boolean z5 = m586e.f962d.getEnableIndex() && !m586e.f977s;
        Intrinsics.checkNotNullParameter(linearLayout4, "<this>");
        Intrinsics.checkNotNullParameter(layoutInflater3, "layoutInflater");
        View inflate2 = layoutInflater3.inflate(C2110R.layout.kakao_sdk_friends_list, (ViewGroup) linearLayout4, false);
        int i2 = C2110R.id.friends_list;
        RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(inflate2, i2);
        if (recyclerView4 != null) {
            i2 = C2110R.id.sideIv;
            SideIndexView sideIndexView = (SideIndexView) ViewBindings.findChildViewById(inflate2, i2);
            if (sideIndexView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate2;
                C2149h c2149h = new C2149h(constraintLayout, recyclerView4, sideIndexView);
                Intrinsics.checkNotNullExpressionValue(c2149h, "inflate(layoutInflater, this, false)");
                linearLayout4.addView(constraintLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                if (z5) {
                    sideIndexView.setRecyclerView(recyclerView4);
                    Drawable wrap = DrawableCompat.wrap(sideIndexView.getBackground());
                    TypedValue typedValue = new TypedValue();
                    linearLayout4.getContext().getTheme().resolveAttribute(C2110R.attr.gray050s, typedValue, true);
                    DrawableCompat.setTint(wrap.mutate(), typedValue.data);
                    recyclerView4.addOnScrollListener(sideIndexView.getOnScrollListener());
                }
                this.f884e = c2149h;
                if (z3) {
                    C2156o c2156o = this.f881b;
                    if (c2156o != null) {
                        C2224c.m618a(c2156o, m586e().f960b);
                    }
                    C2149h c2149h2 = this.f884e;
                    if (c2149h2 != null && (recyclerView2 = c2149h2.f706b) != null) {
                        C2222a.m613a(recyclerView2);
                    }
                }
                if (m586e().m675c()) {
                    try {
                        this.f888i = (C2234i) new ViewModelProvider(requireActivity(), new ViewModelProvider.NewInstanceFactory()).get(C2234i.class);
                    } catch (IllegalStateException e) {
                        ClientErrorCause clientErrorCause = ClientErrorCause.IllegalState;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        m582a(new ClientError(clientErrorCause, message));
                    }
                }
                C2232g m586e2 = m586e();
                Context context = requireContext();
                Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
                m586e2.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                Locale currentLocale = context.getResources().getConfiguration().getLocales().get(0);
                Intrinsics.checkNotNullExpressionValue(currentLocale, "currentLocale");
                if (!Intrinsics.areEqual(m586e2.f980v, currentLocale)) {
                    m586e2.f980v = currentLocale;
                    z4 = true;
                }
                if (z4) {
                    m586e2.f964f.clear();
                    if (m586e2.f960b) {
                        PickerChatMembers mo498d = m586e2.f959a.mo498d();
                        Integer m641a = mo498d == null ? null : mo498d.m641a();
                        ArrayList arrayList = new ArrayList();
                        PickerChatMembers mo498d2 = m586e2.f959a.mo498d();
                        if (mo498d2 != null && (m642b = mo498d2.m642b()) != null) {
                            for (PickerChatMember pickerChatMember : m642b) {
                                Boolean m634c = pickerChatMember.m634c();
                                Boolean bool2 = Boolean.TRUE;
                                if (Intrinsics.areEqual(m634c, bool2)) {
                                    bool2 = Boolean.FALSE;
                                } else if (!Intrinsics.areEqual(m634c, Boolean.FALSE)) {
                                    bool = null;
                                    arrayList.add(m586e2.m667a(new PickerFriend(pickerChatMember.m633b(), pickerChatMember.m637f(), pickerChatMember.m635d(), pickerChatMember.m636e(), null, null, pickerChatMember.m632a(), null, null, bool, pickerChatMember.m638g(), null)));
                                }
                                bool = bool2;
                                arrayList.add(m586e2.m667a(new PickerFriend(pickerChatMember.m633b(), pickerChatMember.m637f(), pickerChatMember.m635d(), pickerChatMember.m636e(), null, null, pickerChatMember.m632a(), null, null, bool, pickerChatMember.m638g(), null)));
                            }
                        }
                        if ((m641a != null && m641a.intValue() == 0) || arrayList.isEmpty()) {
                            m586e2.f974p.setValue(AbstractC2181a.d.f810a);
                        } else {
                            m586e2.f964f.add(new AbstractC2168a.b(m586e2.f976r));
                            m586e2.f975q = m586e2.f964f.size();
                            m586e2.f964f.addAll(arrayList);
                        }
                    } else {
                        PickerUsingOsFilter usingOsFilter = m586e2.f962d.getUsingOsFilter();
                        List<PickerFriend> mo499e = m586e2.f959a.mo499e();
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : mo499e) {
                            PickerFriend pickerFriend = (PickerFriend) obj;
                            if (m586e2.m672a(pickerFriend.m652i()) || pickerFriend.m653j() == null || usingOsFilter == PickerUsingOsFilter.ALL) {
                                z = true;
                            } else {
                                String m653j = pickerFriend.m653j();
                                String name = usingOsFilter.name();
                                Locale ENGLISH = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                                String lowerCase = name.toLowerCase(ENGLISH);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                z = Intrinsics.areEqual(m653j, lowerCase);
                            }
                            if (z) {
                                arrayList2.add(obj);
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            PickerFriend pickerFriend2 = (PickerFriend) it.next();
                            AbstractC2169b.a m667a = m586e2.m667a(pickerFriend2);
                            if (Intrinsics.areEqual(pickerFriend2.m644a(), Boolean.TRUE)) {
                                arrayList3.add(m667a);
                                m586e2.f977s = true;
                            } else {
                                arrayList4.add(m667a);
                            }
                        }
                        C2187c c2187c = new C2187c();
                        CollectionsKt.sortWith(arrayList3, c2187c);
                        CollectionsKt.sortWith(arrayList4, c2187c);
                        List plus = CollectionsKt.plus((Collection) arrayList3, (Iterable) arrayList4);
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj2 : plus) {
                            if (Intrinsics.areEqual(((AbstractC2169b.a) obj2).f786f, Boolean.TRUE)) {
                                arrayList5.add(obj2);
                            }
                        }
                        boolean showMyProfile = m586e2.f962d.getShowMyProfile();
                        boolean showFavorite = m586e2.f962d.getShowFavorite();
                        if (showMyProfile) {
                            List<AbstractC2170c> list = m586e2.f964f;
                            String string2 = context.getString(C2110R.string.my_profile);
                            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.my_profile)");
                            list.add(new AbstractC2170c.c(string2));
                            List<AbstractC2170c> list2 = m586e2.f964f;
                            C2225Me mo491a = m586e2.f959a.mo491a();
                            AbstractC2169b.a aVar = mo491a != null ? new AbstractC2169b.a(Long.valueOf(mo491a.m621a()), mo491a.m624d(), mo491a.m622b(), mo491a.m623c(), null, null, false, false, null, 496) : null;
                            Intrinsics.checkNotNull(aVar);
                            list2.add(aVar);
                            if (!plus.isEmpty()) {
                                m586e2.f964f.add(AbstractC2170c.a.f790a);
                            }
                        }
                        if (plus.isEmpty()) {
                            m586e2.f971m.setValue(m586e2.f964f);
                            if (!showMyProfile) {
                                m586e2.f974p.setValue(AbstractC2181a.d.f810a);
                            }
                            m586e2.f975q = m586e2.f964f.size();
                        } else {
                            if (showFavorite && (!arrayList5.isEmpty())) {
                                List<AbstractC2170c> list3 = m586e2.f964f;
                                String string3 = context.getString(C2110R.string.favorite);
                                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.favorite)");
                                list3.add(new AbstractC2170c.c(string3));
                                m586e2.f964f.addAll(arrayList5);
                                m586e2.f964f.add(AbstractC2170c.a.f790a);
                            }
                            List<AbstractC2170c> list4 = m586e2.f964f;
                            String string4 = context.getString(C2110R.string.friend);
                            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.friend)");
                            list4.add(new AbstractC2170c.c(string4));
                            m586e2.f975q = m586e2.f964f.size();
                            m586e2.f964f.addAll(plus);
                        }
                    }
                    List<AbstractC2169b.a> list5 = m586e2.f965g;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    Iterator<T> it2 = list5.iterator();
                    while (it2.hasNext()) {
                        arrayList6.add(((AbstractC2169b.a) it2.next()).f782b);
                    }
                    HashSet hashSet = CollectionsKt.toHashSet(arrayList6);
                    for (AbstractC2170c abstractC2170c : m586e2.f964f) {
                        if (abstractC2170c instanceof AbstractC2169b.a) {
                            AbstractC2169b.a aVar2 = (AbstractC2169b.a) abstractC2170c;
                            if (hashSet.contains(aVar2.f782b)) {
                                aVar2.f787g = true;
                            }
                        }
                    }
                    m586e2.f971m.setValue(m586e2.f964f);
                }
                C2155n c2155n2 = this.f882c;
                if (c2155n2 != null) {
                    C2125e m585d = m585d();
                    Intrinsics.checkNotNullParameter(c2155n2, "<this>");
                    c2155n2.f728b.setAdapter(m585d);
                }
                C2149h c2149h3 = this.f884e;
                if (c2149h3 != null && (recyclerView = c2149h3.f706b) != null) {
                    C2222a.m614a(recyclerView, m584c(), new C2211n(this));
                }
                C2156o c2156o2 = this.f881b;
                if (c2156o2 != null) {
                    C2224c.m620b(c2156o2, new C2212o(this));
                    C2224c.m617a(c2156o2, new C2213p(this));
                }
                C2218u c2218u = this.f883d;
                if (c2218u != null) {
                    c2218u.setSearchAction(new C2214q(m586e()));
                }
                m587f();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m576a(C2206i this$0, AbstractC2181a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.getClass();
        if (it instanceof AbstractC2181a.b) {
            Toast makeText = Toast.makeText(this$0.requireContext(), this$0.getString(C2110R.string.max_pickable_count_message, Integer.valueOf(((AbstractC2181a.b) it).f808a)), 0);
            y.٬خݮ۳ݯ();
            makeText.show();
            return;
        }
        if (it instanceof AbstractC2181a.c) {
            Toast makeText2 = Toast.makeText(this$0.requireContext(), this$0.getString(C2110R.string.min_pickable_count_message, Integer.valueOf(((AbstractC2181a.c) it).f809a)), 0);
            y.٬خݮ۳ݯ();
            makeText2.show();
            return;
        }
        if (!(it instanceof AbstractC2181a.d)) {
            if (it instanceof AbstractC2181a.a) {
                Toast makeText3 = Toast.makeText(this$0.requireContext(), this$0.getString(C2110R.string.unexpected_error_message), 0);
                y.٬خݮ۳ݯ();
                makeText3.show();
                return;
            }
            return;
        }
        C2156o c2156o = this$0.f881b;
        TextView textView = c2156o == null ? null : c2156o.f731c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        C2218u c2218u = this$0.f883d;
        if (c2218u != null) {
            c2218u.setVisibility(8);
        }
        if (!this$0.m586e().m675c()) {
            C2147f c2147f = this$0.f880a;
            Intrinsics.checkNotNull(c2147f);
            c2147f.f696b.setVisibility(0);
        } else {
            C2234i c2234i = this$0.f888i;
            if (c2234i == null) {
                return;
            }
            c2234i.f991i.setValue(AbstractC2181a.d.f810a);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m580a(C2206i this$0, List pickerList) {
        C2149h c2149h;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2122b m584c = this$0.m584c();
        Intrinsics.checkNotNullExpressionValue(pickerList, "it");
        m584c.getClass();
        Intrinsics.checkNotNullParameter(pickerList, "items");
        C2123c c2123c = m584c.f637i;
        List<AbstractC2170c> oldList = m584c.f635g;
        c2123c.getClass();
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(pickerList, "newList");
        c2123c.f640a = oldList;
        c2123c.f641b = pickerList;
        DiffUtil.calculateDiff(m584c.f637i).dispatchUpdatesTo(m584c);
        m584c.f635g = CollectionsKt.toMutableList((Collection) pickerList);
        C2232g m586e = this$0.m586e();
        int i = 0;
        if (!(m586e.f962d.getEnableIndex() && !m586e.f977s) || (c2149h = this$0.f884e) == null) {
            return;
        }
        boolean z = this$0.m586e().f967i;
        List<AbstractC2169b.a> friendList = this$0.m586e().m673b();
        Intrinsics.checkNotNullParameter(c2149h, "<this>");
        Intrinsics.checkNotNullParameter(friendList, "friendList");
        Intrinsics.checkNotNullParameter(pickerList, "pickerList");
        Iterator it = pickerList.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            AbstractC2170c abstractC2170c = (AbstractC2170c) it.next();
            i++;
            if ((abstractC2170c instanceof AbstractC2170c.c) && Intrinsics.areEqual(((AbstractC2170c.c) abstractC2170c).f792a, c2149h.f705a.getContext().getString(C2110R.string.favorite))) {
                i2 = i - 1;
            }
        }
        c2149h.f707c.m684a(friendList, friendList.size(), i2, (pickerList.size() - friendList.size()) - i2);
        c2149h.f707c.m683a(z ? C2110R.array.popup_side_indexer : C2110R.array.side_indexer, z ? C2110R.array.popup_side_indexer_landscape : C2110R.array.side_indexer_landscape);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m579a(C2206i this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2155n c2155n = this$0.f882c;
        NestedScrollableHost nestedScrollableHost = c2155n == null ? null : c2155n.f727a;
        if (nestedScrollableHost != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            nestedScrollableHost.setVisibility(it.intValue() > 0 ? 0 : 8);
        }
        C2156o c2156o = this$0.f881b;
        if (c2156o != null) {
            boolean z = this$0.m586e().f966h;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            C2224c.m619a(c2156o, z, it.intValue());
        }
        C2234i c2234i = this$0.f888i;
        if (c2234i == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        int intValue = it.intValue();
        if (c2234i.f983a == 0) {
            c2234i.f988f.setValue(Boolean.valueOf(intValue > 0));
        }
        c2234i.f987e.setValue(Integer.valueOf(intValue));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m582a(KakaoSdkError kakaoSdkError) {
        ResultReceiver resultReceiver = m586e().f963e;
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_EXCEPTION, kakaoSdkError);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(0, bundle);
        }
        m583b();
    }
}
