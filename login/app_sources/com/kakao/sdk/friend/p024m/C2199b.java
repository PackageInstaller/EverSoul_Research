package com.kakao.sdk.friend.p024m;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.network.model.PickerChat;
import com.kakao.sdk.friend.p012a.C2120j;
import com.kakao.sdk.friend.p013b.C2121a;
import com.kakao.sdk.friend.p013b.C2123c;
import com.kakao.sdk.friend.p016e.C2143b;
import com.kakao.sdk.friend.p016e.C2145d;
import com.kakao.sdk.friend.p016e.C2146e;
import com.kakao.sdk.friend.p016e.C2156o;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p022k.EnumC2183c;
import com.kakao.sdk.friend.p022k.EnumC2184d;
import com.kakao.sdk.friend.p023l.C2190f;
import com.kakao.sdk.friend.p025n.C2222a;
import com.kakao.sdk.friend.p025n.C2223b;
import com.kakao.sdk.friend.p025n.C2224c;
import com.kakao.sdk.friend.p026o.C2226a;
import com.kakao.sdk.friend.p026o.C2227b;
import com.kakao.sdk.friend.p026o.C2228c;
import com.kakao.sdk.friend.p026o.C2234i;
import com.kakao.sdk.friend.view.EmptyView;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(m837bv = {}, m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m839d2 = {"Lcom/kakao/sdk/friend/m/b;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* renamed from: com.kakao.sdk.friend.m.b */
/* loaded from: classes3.dex */
public final class C2199b extends Fragment {

    /* renamed from: h */
    public static final /* synthetic */ int f862h = 0;

    /* renamed from: a */
    public C2146e f863a;

    /* renamed from: b */
    public C2156o f864b;

    /* renamed from: c */
    public C2218u f865c;

    /* renamed from: d */
    public C2143b f866d;

    /* renamed from: e */
    public final Lazy f867e = LazyKt.lazy(new b());

    /* renamed from: f */
    public final Lazy f868f = LazyKt.lazy(new c());

    /* renamed from: g */
    public C2234i f869g;

    /* renamed from: com.kakao.sdk.friend.m.b$a */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f870a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[EnumC2184d.values().length];
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
            f870a = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m567a(C2199b this$0, EnumC2184d enumC2184d) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = enumC2184d == null ? -1 : a.f870a[enumC2184d.ordinal()];
        if (i == 1) {
            this$0.m570a();
            return;
        }
        if (i == 2) {
            this$0.m571a(new ClientError(ClientErrorCause.Cancelled, "cancelled."));
            return;
        }
        if (i != 3) {
            return;
        }
        C2218u c2218u = this$0.f865c;
        if (c2218u != null) {
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            C2190f.m548a(requireContext, c2218u.getEditText());
        }
        this$0.m574d().m666a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final C2121a m573c() {
        return (C2121a) this.f867e.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final C2227b m574d() {
        return (C2227b) this.f868f.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f863a = null;
    }

    /* renamed from: com.kakao.sdk.friend.m.b$b */
    public static final class b extends Lambda implements Function0<C2121a> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public C2121a invoke() {
            C2199b c2199b = C2199b.this;
            int i = C2199b.f862h;
            return new C2121a(c2199b.m574d().f945h, new C2200c(C2199b.this), new C2201d(C2199b.this));
        }
    }

    /* renamed from: com.kakao.sdk.friend.m.b$c */
    public static final class c extends Lambda implements Function0<C2227b> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public c() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public C2227b invoke() {
            ViewModel viewModel = new ViewModelProvider(C2199b.this, new C2228c(C2120j.f620a.m478b())).get(C2227b.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     …hatViewModel::class.java]");
            return (C2227b) viewModel;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m570a() {
        ResultReceiver resultReceiver;
        if (!m574d().f946i) {
            C2227b m574d = m574d();
            AbstractC2168a.a aVar = m574d.f943f;
            if (aVar != null && (resultReceiver = m574d.f939b) != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("key.selected.chat", new SelectedChat(aVar.f772a, aVar.f776e, aVar.f774c, aVar.f775d, aVar.f778g));
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(-1, bundle);
            }
            m574d.f951n.setValue(AbstractC2182b.c.f813a);
            return;
        }
        C2227b m574d2 = m574d();
        AbstractC2168a.a aVar2 = m574d2.f943f;
        if (aVar2 == null) {
            return;
        }
        m574d2.f938a.mo492a(aVar2.f772a, new C2226a(m574d2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m572b() {
        Unit unit;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            unit = null;
        } else {
            activity.finish();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SdkLog.INSTANCE.m470e("ChatPickerFragment not attached to an activity.");
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
    /* renamed from: e */
    public final void m575e() {
        MutableLiveData<EnumC2184d> mutableLiveData;
        m574d().f944g.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.b$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2199b.m568a(C2199b.this, (List) obj);
            }
        });
        m574d().f950m.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.b$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2199b.m566a(C2199b.this, (AbstractC2182b) obj);
            }
        });
        m574d().f951n.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.b$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2199b.m569b(C2199b.this, (AbstractC2182b) obj);
            }
        });
        m574d().f952o.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.b$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2199b.m565a(C2199b.this, (AbstractC2181a) obj);
            }
        });
        C2234i c2234i = this.f869g;
        if (c2234i == null || (mutableLiveData = c2234i.f990h) == null) {
            return;
        }
        mutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.kakao.sdk.friend.m.b$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2199b.m567a(C2199b.this, (EnumC2184d) obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View findChildViewById;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(C2110R.layout.kakao_sdk_fragment_chat_picker, viewGroup, false);
        int i = C2110R.id.empty_chat_view;
        EmptyView emptyView = (EmptyView) ViewBindings.findChildViewById(inflate, i);
        if (emptyView != null && (findChildViewById = ViewBindings.findChildViewById(inflate, (i = C2110R.id.error_retry_view))) != null) {
            C2145d m504a = C2145d.m504a(findChildViewById);
            int i2 = C2110R.id.main_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, i2);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                C2146e c2146e = new C2146e(constraintLayout, emptyView, m504a, linearLayout);
                this.f863a = c2146e;
                Intrinsics.checkNotNull(c2146e);
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
        RecyclerView recyclerView2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (!m574d().f947j) {
            C2146e c2146e = this.f863a;
            Intrinsics.checkNotNull(c2146e);
            LinearLayout linearLayout = c2146e.f694c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mainLayout");
            LayoutInflater layoutInflater = getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
            String str = m574d().f948k;
            if (str == null) {
                str = getString(C2110R.string.select_chat);
                Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.select_chat)");
            }
            this.f864b = C2224c.m616a(linearLayout, layoutInflater, str, false, m574d().f946i);
        }
        if (m574d().f949l) {
            C2146e c2146e2 = this.f863a;
            Intrinsics.checkNotNull(c2146e2);
            LinearLayout linearLayout2 = c2146e2.f694c;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.mainLayout");
            String string = getString(C2110R.string.search_chat_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.search_chat_hint)");
            this.f865c = C2223b.m615a(linearLayout2, string);
        }
        C2146e c2146e3 = this.f863a;
        Intrinsics.checkNotNull(c2146e3);
        LinearLayout linearLayout3 = c2146e3.f694c;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.mainLayout");
        LayoutInflater layoutInflater2 = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater2, "layoutInflater");
        Intrinsics.checkNotNullParameter(linearLayout3, "<this>");
        Intrinsics.checkNotNullParameter(layoutInflater2, "layoutInflater");
        View inflate = layoutInflater2.inflate(C2110R.layout.kakao_sdk_chats_list, (ViewGroup) linearLayout3, false);
        int i = C2110R.id.chats_list;
        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(inflate, i);
        if (recyclerView3 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            C2143b c2143b = new C2143b(constraintLayout, recyclerView3);
            Intrinsics.checkNotNullExpressionValue(c2143b, "inflate(layoutInflater, this, false)");
            linearLayout3.addView(constraintLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f866d = c2143b;
            if (m574d().f945h) {
                C2156o c2156o = this.f864b;
                if (c2156o != null) {
                    C2224c.m618a(c2156o, false);
                }
                C2143b c2143b2 = this.f866d;
                if (c2143b2 != null && (recyclerView2 = c2143b2.f688b) != null) {
                    C2222a.m613a(recyclerView2);
                }
            }
            if (m574d().f947j) {
                try {
                    this.f869g = (C2234i) new ViewModelProvider(requireActivity(), new ViewModelProvider.NewInstanceFactory()).get(C2234i.class);
                } catch (IllegalStateException e) {
                    ClientErrorCause clientErrorCause = ClientErrorCause.IllegalState;
                    String message = e.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    m571a(new ClientError(clientErrorCause, message));
                }
            }
            C2227b m574d = m574d();
            if (!(!m574d.f942e.isEmpty())) {
                List<AbstractC2168a.a> list = m574d.f942e;
                List<PickerChat> mo497c = m574d.f938a.mo497c();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mo497c, 10));
                for (Iterator it = mo497c.iterator(); it.hasNext(); it = it) {
                    PickerChat pickerChat = (PickerChat) it.next();
                    arrayList.add(new AbstractC2168a.a(pickerChat.m627c(), pickerChat.m630f(), pickerChat.m631g(), pickerChat.m628d(), pickerChat.m629e(), pickerChat.m626b(), pickerChat.m625a(), false));
                }
                list.addAll(arrayList);
                if (m574d.f942e.isEmpty()) {
                    m574d.f944g.setValue(m574d.f941d);
                    m574d.f952o.setValue(AbstractC2181a.d.f810a);
                } else {
                    m574d.f941d.addAll(m574d.f942e);
                    m574d.f944g.setValue(m574d.f941d);
                }
            }
            C2143b c2143b3 = this.f866d;
            if (c2143b3 != null && (recyclerView = c2143b3.f688b) != null) {
                C2222a.m614a(recyclerView, m573c(), new C2202e(this));
            }
            C2156o c2156o2 = this.f864b;
            if (c2156o2 != null) {
                C2224c.m620b(c2156o2, new C2203f(this));
                C2224c.m617a(c2156o2, new C2204g(this));
            }
            C2218u c2218u = this.f865c;
            if (c2218u != null) {
                c2218u.setSearchAction(new C2205h(this));
            }
            m575e();
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static final void m569b(C2199b this$0, AbstractC2182b it) {
        C2143b c2143b;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.getClass();
        if (it instanceof AbstractC2182b.e) {
            EnumC2183c enumC2183c = ((AbstractC2182b.e) it).f815a;
            if ((enumC2183c != EnumC2183c.SEARCHING && enumC2183c != EnumC2183c.DONE) || (c2143b = this$0.f866d) == null || (recyclerView = c2143b.f688b) == null) {
                return;
            }
            recyclerView.scrollToPosition(0);
            return;
        }
        if (it instanceof AbstractC2182b.d) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key.chat.member.picker", true);
            C2206i c2206i = new C2206i();
            c2206i.setArguments(bundle);
            try {
                this$0.requireActivity().getSupportFragmentManager().beginTransaction().replace(C2110R.id.fragment_container, c2206i).addToBackStack(null).commit();
                return;
            } catch (IllegalStateException e) {
                SdkLog.INSTANCE.m470e("ChatPickerFragment not attached to an activity.");
                ClientErrorCause clientErrorCause = ClientErrorCause.IllegalState;
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                this$0.m571a(new ClientError(clientErrorCause, message));
                return;
            }
        }
        if (it instanceof AbstractC2182b.c) {
            this$0.m572b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m568a(C2199b this$0, List newList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2121a m573c = this$0.m573c();
        Intrinsics.checkNotNullExpressionValue(newList, "it");
        m573c.getClass();
        Intrinsics.checkNotNullParameter(newList, "items");
        C2123c c2123c = m573c.f626e;
        List<? extends AbstractC2170c> oldList = m573c.f625d;
        c2123c.getClass();
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        c2123c.f640a = oldList;
        c2123c.f641b = newList;
        DiffUtil.calculateDiff(m573c.f626e).dispatchUpdatesTo(m573c);
        m573c.f625d = newList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m566a(C2199b this$0, AbstractC2182b it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.getClass();
        if (it instanceof AbstractC2182b.a) {
            C2121a m573c = this$0.m573c();
            AbstractC2182b.a event = (AbstractC2182b.a) it;
            m573c.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            int indexOf = m573c.f625d.indexOf(event.f811a);
            if (indexOf > -1) {
                m573c.notifyItemChanged(indexOf);
            }
            C2156o c2156o = this$0.f864b;
            if (c2156o != null) {
                C2224c.m619a(c2156o, true, 1);
            }
            C2234i c2234i = this$0.f869g;
            if (c2234i != null && c2234i.f983a == 1) {
                c2234i.f988f.setValue(Boolean.TRUE);
                return;
            }
            return;
        }
        if (it instanceof AbstractC2182b.g) {
            C2121a m573c2 = this$0.m573c();
            AbstractC2182b.g event2 = (AbstractC2182b.g) it;
            m573c2.getClass();
            Intrinsics.checkNotNullParameter(event2, "event");
            int indexOf2 = m573c2.f625d.indexOf(event2.f817a);
            if (indexOf2 > -1) {
                m573c2.notifyItemChanged(indexOf2);
            }
            C2156o c2156o2 = this$0.f864b;
            if (c2156o2 != null) {
                C2224c.m619a(c2156o2, true, 0);
            }
            C2234i c2234i2 = this$0.f869g;
            if (c2234i2 != null && c2234i2.f983a == 1) {
                c2234i2.f988f.setValue(Boolean.FALSE);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m565a(C2199b this$0, AbstractC2181a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.getClass();
        if (it instanceof AbstractC2181a.d) {
            C2156o c2156o = this$0.f864b;
            TextView textView = c2156o == null ? null : c2156o.f731c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            C2218u c2218u = this$0.f865c;
            if (c2218u != null) {
                c2218u.setVisibility(8);
            }
            if (!this$0.m574d().f947j) {
                C2146e c2146e = this$0.f863a;
                Intrinsics.checkNotNull(c2146e);
                c2146e.f693b.setVisibility(0);
                return;
            } else {
                C2234i c2234i = this$0.f869g;
                if (c2234i == null) {
                    return;
                }
                c2234i.f992j.setValue(AbstractC2181a.d.f810a);
                return;
            }
        }
        if (it instanceof AbstractC2181a.a) {
            Toast makeText = Toast.makeText(this$0.requireContext(), this$0.getString(C2110R.string.unexpected_error_message), 0);
            y.٬خݮ۳ݯ();
            makeText.show();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m571a(KakaoSdkError kakaoSdkError) {
        ResultReceiver resultReceiver = m574d().f939b;
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_EXCEPTION, kakaoSdkError);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(0, bundle);
        }
        m572b();
    }
}
