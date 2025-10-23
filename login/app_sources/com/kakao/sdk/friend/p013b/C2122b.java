package com.kakao.sdk.friend.p013b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.DisableSelectReason;
import com.kakao.sdk.friend.p014c.C2130d;
import com.kakao.sdk.friend.p014c.C2131e;
import com.kakao.sdk.friend.p014c.C2132f;
import com.kakao.sdk.friend.p014c.C2134h;
import com.kakao.sdk.friend.p014c.C2135i;
import com.kakao.sdk.friend.p016e.C2142a;
import com.kakao.sdk.friend.p016e.C2144c;
import com.kakao.sdk.friend.p016e.C2150i;
import com.kakao.sdk.friend.p016e.C2152k;
import com.kakao.sdk.friend.p016e.C2154m;
import com.kakao.sdk.friend.p017f.C2157a;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p018g.RunnableC2164d;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p023l.C2195k;
import com.kakao.sdk.friend.view.SquircleImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* renamed from: com.kakao.sdk.friend.b.b */
/* loaded from: classes3.dex */
public final class C2122b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    public final boolean f629a;

    /* renamed from: b */
    public final boolean f630b;

    /* renamed from: c */
    public final Function1<AbstractC2169b.a, Unit> f631c;

    /* renamed from: d */
    public final Function1<AbstractC2169b.a, Unit> f632d;

    /* renamed from: e */
    public final Function0<Unit> f633e;

    /* renamed from: f */
    public final Function0<Unit> f634f;

    /* renamed from: g */
    public List<AbstractC2170c> f635g;

    /* renamed from: h */
    public RecyclerView f636h;

    /* renamed from: i */
    public final C2123c f637i;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2122b(boolean z, boolean z2, Function1<? super AbstractC2169b.a, Unit> checkCallback, Function1<? super AbstractC2169b.a, Unit> uncheckCallback, Function0<Unit> selectAllCallback, Function0<Unit> deselectAllCallback) {
        Intrinsics.checkNotNullParameter(checkCallback, "checkCallback");
        Intrinsics.checkNotNullParameter(uncheckCallback, "uncheckCallback");
        Intrinsics.checkNotNullParameter(selectAllCallback, "selectAllCallback");
        Intrinsics.checkNotNullParameter(deselectAllCallback, "deselectAllCallback");
        this.f629a = z;
        this.f630b = z2;
        this.f631c = checkCallback;
        this.f632d = uncheckCallback;
        this.f633e = selectAllCallback;
        this.f634f = deselectAllCallback;
        this.f635g = new ArrayList();
        this.f637i = new C2123c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f635g.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        AbstractC2170c abstractC2170c = this.f635g.get(i);
        if (abstractC2170c instanceof AbstractC2170c.c) {
            return 0;
        }
        if (abstractC2170c instanceof AbstractC2169b.a) {
            return 1;
        }
        if (abstractC2170c instanceof AbstractC2170c.a) {
            return 2;
        }
        if (abstractC2170c instanceof AbstractC2170c.b) {
            return 3;
        }
        if (abstractC2170c instanceof AbstractC2168a.b) {
            return 4;
        }
        throw new ClassCastException(Intrinsics.stringPlus("Unknown viewType ", abstractC2170c.getClass()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.f636h = recyclerView;
    }

    /* renamed from: com.kakao.sdk.friend.b.b$a */
    public static final class a extends Lambda implements Function1<AbstractC2169b.a, Unit> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AbstractC2169b.a aVar) {
            AbstractC2169b.a it = aVar;
            Intrinsics.checkNotNullParameter(it, "it");
            C2122b.this.f631c.invoke(it);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.kakao.sdk.friend.b.b$b */
    public static final class b extends Lambda implements Function1<AbstractC2169b.a, Unit> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            super(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AbstractC2169b.a aVar) {
            AbstractC2169b.a it = aVar;
            Intrinsics.checkNotNullParameter(it, "it");
            C2122b.this.f632d.invoke(it);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        AbstractC2170c abstractC2170c = this.f635g.get(i);
        if (holder instanceof C2132f) {
            C2132f c2132f = (C2132f) holder;
            AbstractC2170c.c header = (AbstractC2170c.c) abstractC2170c;
            c2132f.getClass();
            Intrinsics.checkNotNullParameter(header, "header");
            c2132f.f657a.f709b.setText(header.f792a);
            return;
        }
        if (holder instanceof C2135i) {
            C2135i c2135i = (C2135i) holder;
            AbstractC2169b.a user = (AbstractC2169b.a) abstractC2170c;
            boolean z = this.f630b;
            c2135i.getClass();
            Intrinsics.checkNotNullParameter(user, "user");
            c2135i.m490a(c2135i.f664b, user);
            C2152k c2152k = c2135i.f664b;
            Integer valueOf = Integer.valueOf(user.f782b.hashCode());
            Context context = c2152k.f716a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            int i2 = C2195k.m562a(valueOf, context).resourceId;
            String str = user.f784d;
            if (str == null || StringsKt.isBlank(str)) {
                c2152k.f719d.setImageResource(i2);
            } else {
                C2159c.c cVar = C2159c.f746c;
                Context context2 = c2135i.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                C2159c loader = cVar.m516a(context2);
                String str2 = user.f784d;
                loader.getClass();
                List imageUrls = CollectionsKt.listOf(str2);
                C2157a downloader = loader.f752b;
                Intrinsics.checkNotNullParameter(loader, "loader");
                Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
                Intrinsics.checkNotNullParameter(downloader, "downloader");
                SquircleImageView target = c2152k.f719d;
                Intrinsics.checkNotNullExpressionValue(target, "profileIv");
                Intrinsics.checkNotNullParameter(target, "target");
                if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                    throw new IllegalStateException("Method call should happen from the main thread.");
                }
                if (i2 != 0) {
                    target.setImageDrawable(ContextCompat.getDrawable(target.getContext(), i2));
                }
                String str3 = (String) imageUrls.get(0);
                if (str3 != null) {
                    Bitmap m514a = cVar.m514a(str3);
                    if (m514a == null) {
                        RunnableC2164d action = new RunnableC2164d(target, str3, downloader);
                        Intrinsics.checkNotNullParameter(action, "action");
                        loader.f751a.submit(action);
                    } else if (target != null) {
                        target.setImageBitmap(m514a);
                    } else {
                        throw new NullPointerException("target view is null");
                    }
                }
            }
            C2152k c2152k2 = c2135i.f664b;
            Resources resources = c2152k2.f716a.getResources();
            if (c2135i.f663a) {
                List<DisableSelectOption> list = user.f785e;
                dimensionPixelSize = list == null || list.isEmpty() ? c2152k2.f716a.getResources().getDimensionPixelSize(C2110R.dimen.popup_list_item_nickname_margin_top) : resources.getDimensionPixelSize(C2110R.dimen.popup_list_item_nickname_reject_margin_top);
            } else {
                List<DisableSelectOption> list2 = user.f785e;
                dimensionPixelSize = resources.getDimensionPixelSize(list2 == null || list2.isEmpty() ? C2110R.dimen.list_item_nickname_margin_top : C2110R.dimen.list_item_nickname_reject_margin_top);
            }
            int i3 = dimensionPixelSize;
            if (c2135i.f663a) {
                List<DisableSelectOption> list3 = user.f785e;
                dimensionPixelSize2 = resources.getDimensionPixelSize(list3 == null || list3.isEmpty() ? C2110R.dimen.popup_list_item_nickname_margin_bottom : C2110R.dimen.popup_list_item_nickname_reject_margin_bottom);
            } else {
                List<DisableSelectOption> list4 = user.f785e;
                dimensionPixelSize2 = resources.getDimensionPixelSize(list4 == null || list4.isEmpty() ? C2110R.dimen.list_item_nickname_margin_bottom : C2110R.dimen.list_item_nickname_reject_margin_bottom);
            }
            int i4 = dimensionPixelSize2;
            c2152k2.f718c.setText(user.f783c);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(c2152k2.f716a);
            constraintSet.connect(c2152k2.f718c.getId(), 3, 0, 3, i3);
            constraintSet.connect(c2152k2.f718c.getId(), 4, 0, 4, i4);
            constraintSet.applyTo(c2152k2.f716a);
            C2152k c2152k3 = c2135i.f664b;
            List<DisableSelectOption> list5 = user.f785e;
            if (list5 == null || list5.isEmpty()) {
                c2152k3.f720e.setVisibility(8);
            } else {
                ArrayList arrayList = new ArrayList();
                for (DisableSelectOption disableSelectOption : user.f785e) {
                    if (disableSelectOption.getReason() == DisableSelectReason.MSG_BLOCKED || disableSelectOption.getReason() == DisableSelectReason.REGISTERED || disableSelectOption.getReason() == DisableSelectReason.UNREGISTERED || disableSelectOption.getReason() == DisableSelectReason.NOT_FRIEND) {
                        String string = c2152k3.f716a.getContext().getString(disableSelectOption.getReason().getResId());
                        Intrinsics.checkNotNullExpressionValue(string, "root.context.getString(it.reason.resId)");
                        arrayList.add(string);
                    }
                }
                List<DisableSelectOption> list6 = user.f785e;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list6) {
                    if (((DisableSelectOption) obj).getReason() == DisableSelectReason.CUSTOM) {
                        arrayList2.add(obj);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    arrayList.clear();
                    String message = ((DisableSelectOption) arrayList2.get(0)).getMessage();
                    if (message == null) {
                        message = "";
                    }
                    arrayList.add(message);
                }
                c2152k3.f720e.setText(CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null));
                c2152k3.f720e.setVisibility(0);
            }
            C2152k c2152k4 = c2135i.f664b;
            c2152k4.f717b.setButtonDrawable(z ? C2110R.drawable.kakao_sdk_daynight_radio : C2110R.drawable.kakao_sdk_daynight_checkbox);
            c2152k4.f717b.setChecked(user.f787g);
            return;
        }
        if (holder instanceof C2131e) {
            ((C2131e) holder).m484a();
        } else if (holder instanceof C2134h) {
            ((C2134h) holder).m488a(((AbstractC2168a.b) abstractC2170c).f780a);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i == 0) {
            C2150i m505a = C2150i.m505a(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(m505a, "inflate(inflater, parent, false)");
            return new C2132f(m505a);
        }
        if (i == 1) {
            boolean z = this.f629a;
            View inflate = from.inflate(C2110R.layout.kakao_sdk_item_friend_picker, parent, false);
            int i2 = C2110R.id.check_box;
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) ViewBindings.findChildViewById(inflate, i2);
            if (appCompatRadioButton != null) {
                i2 = C2110R.id.nickname_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, i2);
                if (textView != null) {
                    i2 = C2110R.id.profile_iv;
                    SquircleImageView squircleImageView = (SquircleImageView) ViewBindings.findChildViewById(inflate, i2);
                    if (squircleImageView != null) {
                        i2 = C2110R.id.reject_tv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, i2);
                        if (textView2 != null) {
                            C2152k c2152k = new C2152k((ConstraintLayout) inflate, appCompatRadioButton, textView, squircleImageView, textView2);
                            Intrinsics.checkNotNullExpressionValue(c2152k, "inflate(inflater, parent, false)");
                            return new C2135i(z, c2152k, new a(), new b());
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
        }
        if (i == 2) {
            C2142a m500a = C2142a.m500a(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(m500a, "inflate(inflater, parent, false)");
            return new C2130d(m500a);
        }
        if (i == 3) {
            boolean z2 = this.f629a;
            C2144c m502a = C2144c.m502a(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(m502a, "inflate(inflater, parent, false)");
            return new C2131e(z2, m502a);
        }
        if (i != 4) {
            throw new ClassCastException(Intrinsics.stringPlus("Unknown viewType ", Integer.valueOf(i)));
        }
        View inflate2 = from.inflate(C2110R.layout.kakao_sdk_item_select_all, parent, false);
        int i3 = C2110R.id.check_box;
        AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) ViewBindings.findChildViewById(inflate2, i3);
        if (appCompatRadioButton2 != null) {
            i3 = C2110R.id.check_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate2, i3);
            if (imageView != null) {
                i3 = C2110R.id.select_all_text;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate2, i3);
                if (textView3 != null) {
                    C2154m c2154m = new C2154m((ConstraintLayout) inflate2, appCompatRadioButton2, imageView, textView3);
                    Intrinsics.checkNotNullExpressionValue(c2154m, "inflate(inflater, parent, false)");
                    return new C2134h(c2154m, this.f633e, this.f634f);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i3)));
    }
}
