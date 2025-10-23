package com.kakao.sdk.friend.p013b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.model.PickerChatType;
import com.kakao.sdk.friend.p014c.C2127a;
import com.kakao.sdk.friend.p014c.C2128b;
import com.kakao.sdk.friend.p014c.C2129c;
import com.kakao.sdk.friend.p014c.C2130d;
import com.kakao.sdk.friend.p014c.C2131e;
import com.kakao.sdk.friend.p014c.C2132f;
import com.kakao.sdk.friend.p016e.C2142a;
import com.kakao.sdk.friend.p016e.C2144c;
import com.kakao.sdk.friend.p016e.C2150i;
import com.kakao.sdk.friend.p016e.C2151j;
import com.kakao.sdk.friend.p017f.C2157a;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p017f.C2160d;
import com.kakao.sdk.friend.p018g.RunnableC2161a;
import com.kakao.sdk.friend.p018g.RunnableC2162b;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p023l.C2185a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* renamed from: com.kakao.sdk.friend.b.a */
/* loaded from: classes3.dex */
public final class C2121a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    public final boolean f622a;

    /* renamed from: b */
    public final Function1<AbstractC2168a.a, Unit> f623b;

    /* renamed from: c */
    public final Function1<AbstractC2168a.a, Unit> f624c;

    /* renamed from: d */
    public List<? extends AbstractC2170c> f625d;

    /* renamed from: e */
    public final C2123c f626e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2121a(boolean z, Function1<? super AbstractC2168a.a, Unit> checkCallback, Function1<? super AbstractC2168a.a, Unit> uncheckCallback) {
        Intrinsics.checkNotNullParameter(checkCallback, "checkCallback");
        Intrinsics.checkNotNullParameter(uncheckCallback, "uncheckCallback");
        this.f622a = z;
        this.f623b = checkCallback;
        this.f624c = uncheckCallback;
        this.f625d = CollectionsKt.emptyList();
        this.f626e = new C2123c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f625d.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        AbstractC2170c abstractC2170c = this.f625d.get(i);
        if (abstractC2170c instanceof AbstractC2170c.c) {
            return 0;
        }
        if (abstractC2170c instanceof AbstractC2168a.a) {
            return 1;
        }
        if (abstractC2170c instanceof AbstractC2170c.a) {
            return 2;
        }
        if (abstractC2170c instanceof AbstractC2170c.b) {
            return 3;
        }
        throw new ClassCastException(Intrinsics.stringPlus("Unknown viewType ", this.f625d.get(i).getClass()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
    }

    /* renamed from: com.kakao.sdk.friend.b.a$a */
    public static final class a extends Lambda implements Function1<AbstractC2168a.a, Unit> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AbstractC2168a.a aVar) {
            AbstractC2168a.a it = aVar;
            Intrinsics.checkNotNullParameter(it, "it");
            C2121a.this.f623b.invoke(it);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.kakao.sdk.friend.b.a$b */
    public static final class b extends Lambda implements Function1<AbstractC2168a.a, Unit> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            super(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AbstractC2168a.a aVar) {
            AbstractC2168a.a it = aVar;
            Intrinsics.checkNotNullParameter(it, "it");
            C2121a.this.f624c.invoke(it);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AbstractC2170c abstractC2170c = this.f625d.get(i);
        if (holder instanceof C2132f) {
            C2132f c2132f = (C2132f) holder;
            AbstractC2170c.c header = (AbstractC2170c.c) abstractC2170c;
            c2132f.getClass();
            Intrinsics.checkNotNullParameter(header, "header");
            c2132f.f657a.f709b.setText(header.f792a);
            return;
        }
        if (holder instanceof C2129c) {
            C2129c c2129c = (C2129c) holder;
            AbstractC2168a.a chat = (AbstractC2168a.a) abstractC2170c;
            c2129c.getClass();
            Intrinsics.checkNotNullParameter(chat, "chat");
            c2129c.m483a(c2129c.f652b, chat);
            C2151j c2151j = c2129c.f652b;
            c2151j.f711b.setButtonDrawable(C2110R.drawable.kakao_sdk_daynight_radio);
            c2151j.f711b.setChecked(chat.f779h);
            c2129c.f652b.f715f.setText(chat.f773b);
            C2151j c2151j2 = c2129c.f652b;
            Integer num = chat.f776e;
            boolean z = true;
            if (num != null) {
                int intValue = num.intValue();
                c2151j2.f712c.setText(String.valueOf(intValue));
                c2151j2.f712c.setVisibility(intValue < 3 ? 8 : 0);
                c2151j2.f712c.setContentDescription(c2151j2.f710a.getContext().getString(C2110R.string.accessibility_member_count_unit, Integer.valueOf(Integer.parseInt(c2151j2.f712c.getText().toString()))));
            }
            C2151j c2151j3 = c2129c.f652b;
            Resources resources = c2151j3.f710a.getResources();
            boolean z2 = chat.f778g == PickerChatType.OPEN;
            c2151j3.f713d.setVisibility(z2 ? 0 : 8);
            boolean z3 = c2129c.f651a;
            int dimensionPixelSize = resources.getDimensionPixelSize(z2 ? z3 ? C2110R.dimen.popup_list_item_open_chat_title_margin_start : C2110R.dimen.list_item_open_chat_title_margin_start : z3 ? C2110R.dimen.popup_list_item_nickname_margin_start : C2110R.dimen.list_item_nickname_margin_start);
            ViewGroup.LayoutParams layoutParams = c2151j3.f715f.getLayoutParams();
            LruCache<Long, Bitmap> lruCache = null;
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.setMarginStart(dimensionPixelSize);
            }
            C2151j c2151j4 = c2129c.f652b;
            C2185a c2185a = C2185a.f829a;
            Context context = c2151j4.f710a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            long j = chat.f772a;
            Intrinsics.checkNotNullParameter(context, "context");
            if (C2185a.f833e == null) {
                C2185a.f833e = new LruCache<>(C2160d.m519a(context));
            }
            LruCache<Long, Bitmap> lruCache2 = C2185a.f833e;
            if (lruCache2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoryCache");
            } else {
                lruCache = lruCache2;
            }
            Bitmap bitmap = lruCache.get(Long.valueOf(j));
            if (bitmap == null) {
                String str = chat.f775d;
                if (str != null && (StringsKt.isBlank(str) ^ true)) {
                    C2159c.c cVar = C2159c.f746c;
                    Context context2 = c2151j4.f710a.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                    C2159c loader = cVar.m516a(context2);
                    List imageUrls = CollectionsKt.listOf(chat.f775d);
                    loader.getClass();
                    Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
                    C2157a downloader = loader.f752b;
                    Intrinsics.checkNotNullParameter(loader, "loader");
                    Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
                    Intrinsics.checkNotNullParameter(downloader, "downloader");
                    C2127a callback = new C2127a(c2151j4, chat);
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                        throw new IllegalStateException("Method call should happen from the main thread.");
                    }
                    String str2 = (String) imageUrls.get(0);
                    if (str2 == null) {
                        return;
                    }
                    Bitmap m514a = cVar.m514a(str2);
                    if (m514a == null) {
                        RunnableC2161a action = new RunnableC2161a(str2, downloader, callback);
                        Intrinsics.checkNotNullParameter(action, "action");
                        loader.f751a.submit(action);
                        return;
                    }
                    cVar.m518a(m514a, callback);
                    return;
                }
                List<String> list = chat.f777f;
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (z) {
                    Integer num2 = chat.f776e;
                    if (num2 == null) {
                        return;
                    }
                    num2.intValue();
                    Context context3 = c2151j4.f710a.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "root.context");
                    c2151j4.f714e.setImageBitmap(c2129c.m482a(context3, chat));
                    return;
                }
                ArrayList imageUrls2 = new ArrayList();
                imageUrls2.addAll(CollectionsKt.take(chat.f777f, 4));
                C2159c.c cVar2 = C2159c.f746c;
                Context context4 = c2151j4.f710a.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "root.context");
                C2159c loader2 = cVar2.m516a(context4);
                loader2.getClass();
                Intrinsics.checkNotNullParameter(imageUrls2, "imageUrls");
                C2157a downloader2 = loader2.f752b;
                Intrinsics.checkNotNullParameter(loader2, "loader");
                Intrinsics.checkNotNullParameter(imageUrls2, "imageUrls");
                Intrinsics.checkNotNullParameter(downloader2, "downloader");
                C2128b callback2 = new C2128b(c2151j4, c2129c, chat);
                Intrinsics.checkNotNullParameter(callback2, "callback");
                if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                    throw new IllegalStateException("Method call should happen from the main thread.");
                }
                if (imageUrls2.isEmpty()) {
                    return;
                }
                RunnableC2162b action2 = new RunnableC2162b(imageUrls2, downloader2, callback2);
                Intrinsics.checkNotNullParameter(action2, "action");
                loader2.f751a.submit(action2);
                return;
            }
            c2151j4.f714e.setImageBitmap(bitmap);
            return;
        }
        if (holder instanceof C2131e) {
            ((C2131e) holder).m484a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i == 0) {
            C2150i m505a = C2150i.m505a(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(m505a, "inflate(\n               …lse\n                    )");
            return new C2132f(m505a);
        }
        if (i != 1) {
            if (i == 2) {
                C2142a m500a = C2142a.m500a(from, parent, false);
                Intrinsics.checkNotNullExpressionValue(m500a, "inflate(\n               …lse\n                    )");
                return new C2130d(m500a);
            }
            if (i != 3) {
                throw new ClassCastException(Intrinsics.stringPlus("Unknown viewType ", Integer.valueOf(i)));
            }
            boolean z = this.f622a;
            C2144c m502a = C2144c.m502a(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(m502a, "inflate(inflater, parent, false)");
            return new C2131e(z, m502a);
        }
        boolean z2 = this.f622a;
        View inflate = from.inflate(C2110R.layout.kakao_sdk_item_chat_picker, parent, false);
        int i2 = C2110R.id.check_box;
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) ViewBindings.findChildViewById(inflate, i2);
        if (appCompatRadioButton != null) {
            i2 = C2110R.id.member_count_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, i2);
            if (textView != null) {
                i2 = C2110R.id.open_chat_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, i2);
                if (imageView != null) {
                    i2 = C2110R.id.profile_iv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, i2);
                    if (imageView2 != null) {
                        i2 = C2110R.id.title_tv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, i2);
                        if (textView2 != null) {
                            C2151j c2151j = new C2151j((ConstraintLayout) inflate, appCompatRadioButton, textView, imageView, imageView2, textView2);
                            Intrinsics.checkNotNullExpressionValue(c2151j, "inflate(inflater, parent, false)");
                            return new C2129c(z2, c2151j, new a(), new b());
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
