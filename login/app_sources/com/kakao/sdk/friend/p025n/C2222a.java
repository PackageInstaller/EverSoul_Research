package com.kakao.sdk.friend.p025n;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p023l.C2191g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.n.a */
/* loaded from: classes3.dex */
public final class C2222a {

    /* renamed from: com.kakao.sdk.friend.n.a$a */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a */
        public final /* synthetic */ Function0<Unit> f930a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a(Function0<Unit> function0) {
            this.f930a = function0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            this.f930a.invoke();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m614a(RecyclerView recyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Function0<Unit> onScrollStateChanged) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(onScrollStateChanged, "onScrollStateChanged");
        recyclerView.setAdapter(adapter);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.addOnScrollListener(new a(onScrollStateChanged));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m613a(RecyclerView recyclerView) {
        Resources resources;
        int i;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        if (C2191g.f848c == 1) {
            resources = recyclerView.getResources();
            i = C2110R.dimen.popup_friends_list_padding_bottom;
        } else {
            resources = recyclerView.getResources();
            i = C2110R.dimen.popup_friends_list_padding_bottom_landscape;
        }
        recyclerView.setPadding(0, 0, 0, resources.getDimensionPixelSize(i));
    }
}
