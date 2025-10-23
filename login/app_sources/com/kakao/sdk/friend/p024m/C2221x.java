package com.kakao.sdk.friend.p024m;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p013b.C2126f;
import com.kakao.sdk.friend.p016e.C2148g;
import com.kakao.sdk.friend.p016e.C2156o;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.EnumC2184d;
import com.kakao.sdk.friend.p025n.C2224c;
import com.kakao.sdk.friend.p026o.C2234i;
import com.kakao.sdk.friend.view.EmptyView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(m837bv = {}, m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m839d2 = {"Lcom/kakao/sdk/friend/m/x;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.m.x */
/* loaded from: classes3.dex */
public final class C2221x extends Fragment {

    /* renamed from: c */
    public static final /* synthetic */ int f921c = 0;

    /* renamed from: a */
    public C2148g f922a;

    /* renamed from: b */
    public C2234i f923b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m600a(TabLayout.Tab noName_0, int i) {
        Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m610a(TextView textView, boolean z) {
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(C2110R.attr.gray900s, typedValue, true);
        TypedValue typedValue2 = new TypedValue();
        requireContext().getTheme().resolveAttribute(C2110R.attr.gray500s, typedValue2, true);
        textView.setTypeface(null, z ? 1 : 0);
        textView.setTextColor(z ? typedValue.data : typedValue2.data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f922a = null;
    }

    /* renamed from: com.kakao.sdk.friend.m.x$a */
    public static final class a extends Lambda implements Function1<View, Unit> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            MutableLiveData<EnumC2184d> mutableLiveData;
            View it = view;
            Intrinsics.checkNotNullParameter(it, "it");
            C2234i c2234i = C2221x.this.f923b;
            if (c2234i == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                c2234i = null;
            }
            if (c2234i.f983a == 0) {
                c2234i.f989g.setValue(EnumC2184d.DONE);
                mutableLiveData = c2234i.f989g;
            } else {
                c2234i.f990h.setValue(EnumC2184d.DONE);
                mutableLiveData = c2234i.f990h;
            }
            mutableLiveData.setValue(EnumC2184d.READY);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.kakao.sdk.friend.m.x$b */
    public static final class b extends Lambda implements Function1<View, Unit> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            super(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View it = view;
            Intrinsics.checkNotNullParameter(it, "it");
            C2234i c2234i = C2221x.this.f923b;
            if (c2234i == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                c2234i = null;
            }
            (c2234i.f983a == 0 ? c2234i.f989g : c2234i.f990h).setValue(EnumC2184d.CANCELED);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.kakao.sdk.friend.m.x$c */
    public static final class c implements TabLayout.OnTabSelectedListener {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public c() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            C2221x c2221x = C2221x.this;
            int position = tab.getPosition();
            int i = C2221x.f921c;
            c2221x.m608a(position);
        }
    }

    /* renamed from: com.kakao.sdk.friend.m.x$d */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public d() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            MutableLiveData<EnumC2184d> mutableLiveData;
            C2221x c2221x = C2221x.this;
            C2234i c2234i = c2221x.f923b;
            Unit unit = null;
            if (c2234i == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                c2234i = null;
            }
            if (i != c2234i.f983a) {
                c2234i.f988f.setValue(Boolean.FALSE);
                c2234i.f983a = i;
            }
            if (i == 0) {
                c2234i.f990h.setValue(EnumC2184d.CLEARED);
                mutableLiveData = c2234i.f990h;
            } else {
                c2234i.f989g.setValue(EnumC2184d.CLEARED);
                mutableLiveData = c2234i.f989g;
            }
            mutableLiveData.setValue(EnumC2184d.READY);
            if (i == 0) {
                C2148g c2148g = c2221x.f922a;
                Intrinsics.checkNotNull(c2148g);
                C2156o c2156o = c2148g.f704g;
                c2156o.f731c.setText(c2221x.getString(C2110R.string.f561ok));
                c2156o.f733e.setVisibility(c2156o.f731c.isEnabled() ? 0 : 8);
                C2234i c2234i2 = c2221x.f923b;
                if (c2234i2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    c2234i2 = null;
                }
                if (c2234i2.f991i.getValue() != null) {
                    String string = c2221x.getString(C2110R.string.empty_friend_message);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.empty_friend_message)");
                    c2221x.m609a(0, string);
                    unit = Unit.INSTANCE;
                }
                if (unit != null) {
                    return;
                }
            } else {
                C2148g c2148g2 = c2221x.f922a;
                Intrinsics.checkNotNull(c2148g2);
                C2156o c2156o2 = c2148g2.f704g;
                C2234i c2234i3 = c2221x.f923b;
                if (c2234i3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    c2234i3 = null;
                }
                c2156o2.f731c.setText(c2221x.getString(c2234i3.f986d ? C2110R.string.next : C2110R.string.f561ok));
                c2156o2.f733e.setVisibility(8);
                C2234i c2234i4 = c2221x.f923b;
                if (c2234i4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    c2234i4 = null;
                }
                if (c2234i4.f992j.getValue() != null) {
                    String string2 = c2221x.getString(C2110R.string.empty_chat_message);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.empty_chat_message)");
                    c2221x.m609a(0, string2);
                    unit = Unit.INSTANCE;
                }
                if (unit != null) {
                    return;
                }
            }
            c2221x.m609a(8, "");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static final void m605b(C2221x this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2148g c2148g = this$0.f922a;
        Intrinsics.checkNotNull(c2148g);
        TabLayout tabLayout = c2148g.f703f;
        C2148g c2148g2 = this$0.f922a;
        Intrinsics.checkNotNull(c2148g2);
        tabLayout.selectTab(c2148g2.f703f.getTabAt(1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m607a() {
        m612c();
        m608a(0);
        C2148g c2148g = this.f922a;
        Intrinsics.checkNotNull(c2148g);
        C2156o c2156o = c2148g.f704g;
        TextView textView = c2156o.f734f;
        C2234i c2234i = this.f923b;
        C2234i c2234i2 = null;
        if (c2234i == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            c2234i = null;
        }
        String str = c2234i.f984b;
        if (str == null) {
            str = getString(C2110R.string.select_friend);
        }
        textView.setText(str);
        Intrinsics.checkNotNullExpressionValue(c2156o, "");
        C2224c.m620b(c2156o, new a());
        C2224c.m617a(c2156o, new b());
        C2148g c2148g2 = this.f922a;
        Intrinsics.checkNotNull(c2148g2);
        c2148g2.f701d.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2221x.m601a(C2221x.this, view);
            }
        });
        C2148g c2148g3 = this.f922a;
        Intrinsics.checkNotNull(c2148g3);
        c2148g3.f699b.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2221x.m605b(C2221x.this, view);
            }
        });
        C2148g c2148g4 = this.f922a;
        Intrinsics.checkNotNull(c2148g4);
        c2148g4.f703f.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
        C2234i c2234i3 = this.f923b;
        if (c2234i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            c2234i2 = c2234i3;
        }
        if (c2234i2.f985c) {
            C2148g c2148g5 = this.f922a;
            Intrinsics.checkNotNull(c2148g5);
            C2156o c2156o2 = c2148g5.f704g;
            Intrinsics.checkNotNullExpressionValue(c2156o2, "binding.titleLayout");
            C2224c.m618a(c2156o2, false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final void m612c() {
        C2148g c2148g = this.f922a;
        Intrinsics.checkNotNull(c2148g);
        c2148g.f702e.setOffscreenPageLimit(1);
        C2148g c2148g2 = this.f922a;
        Intrinsics.checkNotNull(c2148g2);
        ViewPager2 viewPager2 = c2148g2.f702e;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        viewPager2.setAdapter(new C2126f(childFragmentManager, lifecycle));
        C2148g c2148g3 = this.f922a;
        Intrinsics.checkNotNull(c2148g3);
        TabLayout tabLayout = c2148g3.f703f;
        C2148g c2148g4 = this.f922a;
        Intrinsics.checkNotNull(c2148g4);
        new TabLayoutMediator(tabLayout, c2148g4.f702e, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                C2221x.m600a(tab, i);
            }
        }).attach();
        C2148g c2148g5 = this.f922a;
        Intrinsics.checkNotNull(c2148g5);
        c2148g5.f702e.registerOnPageChangeCallback(new d());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View findChildViewById;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C2110R.layout.kakao_sdk_fragment_tab, viewGroup, false);
        int i = C2110R.id.chat_tab;
        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, i);
        if (textView != null) {
            i = C2110R.id.empty_view;
            EmptyView emptyView = (EmptyView) ViewBindings.findChildViewById(inflate, i);
            if (emptyView != null) {
                i = C2110R.id.friend_tab;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, i);
                if (textView2 != null) {
                    i = C2110R.id.pager;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(inflate, i);
                    if (viewPager2 != null) {
                        i = C2110R.id.tab_layout;
                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(inflate, i);
                        if (tabLayout != null && (findChildViewById = ViewBindings.findChildViewById(inflate, (i = C2110R.id.title_layout))) != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                            C2148g c2148g = new C2148g(constraintLayout, textView, emptyView, textView2, viewPager2, tabLayout, C2156o.m511a(findChildViewById));
                            this.f922a = c2148g;
                            Intrinsics.checkNotNull(c2148g);
                            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.root");
                            return constraintLayout;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModel viewModel = new ViewModelProvider(activity, new ViewModelProvider.NewInstanceFactory()).get(C2234i.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     …TabViewModel::class.java]");
            this.f923b = (C2234i) viewModel;
        }
        m607a();
        m611b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m611b() {
        C2234i c2234i = this.f923b;
        C2234i c2234i2 = null;
        if (c2234i == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            c2234i = null;
        }
        c2234i.f987e.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2221x.m604a(C2221x.this, (Integer) obj);
            }
        });
        C2234i c2234i3 = this.f923b;
        if (c2234i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            c2234i3 = null;
        }
        c2234i3.f988f.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2221x.m603a(C2221x.this, (Boolean) obj);
            }
        });
        C2234i c2234i4 = this.f923b;
        if (c2234i4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            c2234i4 = null;
        }
        c2234i4.f991i.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2221x.m602a(C2221x.this, (AbstractC2181a.d) obj);
            }
        });
        C2234i c2234i5 = this.f923b;
        if (c2234i5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            c2234i2 = c2234i5;
        }
        c2234i2.f992j.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.x$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2221x.m606b(C2221x.this, (AbstractC2181a.d) obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static final void m606b(C2221x this$0, AbstractC2181a.d dVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dVar == null) {
            unit = null;
        } else {
            String string = this$0.getString(C2110R.string.empty_chat_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.empty_chat_message)");
            this$0.m609a(0, string);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this$0.m609a(8, "");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m601a(C2221x this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2148g c2148g = this$0.f922a;
        Intrinsics.checkNotNull(c2148g);
        TabLayout tabLayout = c2148g.f703f;
        C2148g c2148g2 = this$0.f922a;
        Intrinsics.checkNotNull(c2148g2);
        tabLayout.selectTab(c2148g2.f703f.getTabAt(0));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m603a(C2221x this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2148g c2148g = this$0.f922a;
        Intrinsics.checkNotNull(c2148g);
        TextView textView = c2148g.f704g.f731c;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m602a(C2221x this$0, AbstractC2181a.d dVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dVar == null) {
            unit = null;
        } else {
            String string = this$0.getString(C2110R.string.empty_friend_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.empty_friend_message)");
            this$0.m609a(0, string);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this$0.m609a(8, "");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m604a(C2221x this$0, Integer count) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2234i c2234i = this$0.f923b;
        if (c2234i == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            c2234i = null;
        }
        if (c2234i.f983a == 1) {
            return;
        }
        C2148g c2148g = this$0.f922a;
        Intrinsics.checkNotNull(c2148g);
        c2148g.f704g.f733e.setText(String.valueOf(count));
        C2148g c2148g2 = this$0.f922a;
        Intrinsics.checkNotNull(c2148g2);
        TextView textView = c2148g2.f704g.f733e;
        Intrinsics.checkNotNullExpressionValue(count, "count");
        textView.setVisibility(count.intValue() > 0 ? 0 : 8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m609a(int i, String str) {
        if (i != 0) {
            if (i != 8) {
                return;
            }
            C2148g c2148g = this.f922a;
            Intrinsics.checkNotNull(c2148g);
            c2148g.f700c.setVisibility(8);
            return;
        }
        C2148g c2148g2 = this.f922a;
        Intrinsics.checkNotNull(c2148g2);
        c2148g2.f700c.setVisibility(0);
        C2148g c2148g3 = this.f922a;
        Intrinsics.checkNotNull(c2148g3);
        c2148g3.f700c.setErrorMessage(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m608a(int i) {
        C2148g c2148g = this.f922a;
        Intrinsics.checkNotNull(c2148g);
        TextView textView = c2148g.f701d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.friendTab");
        m610a(textView, i == 0);
        C2148g c2148g2 = this.f922a;
        Intrinsics.checkNotNull(c2148g2);
        TextView textView2 = c2148g2.f699b;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.chatTab");
        m610a(textView2, i == 1);
    }
}
