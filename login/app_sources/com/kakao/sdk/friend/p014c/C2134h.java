package com.kakao.sdk.friend.p014c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p016e.C2154m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.c.h */
/* loaded from: classes3.dex */
public final class C2134h extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public final C2154m f660a;

    /* renamed from: b */
    public Function0<Unit> f661b;

    /* renamed from: c */
    public Function0<Unit> f662c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2134h(C2154m binding, Function0<Unit> selectAllCallback, Function0<Unit> deselectAllCallback) {
        super(binding.m510a());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(selectAllCallback, "selectAllCallback");
        Intrinsics.checkNotNullParameter(deselectAllCallback, "deselectAllCallback");
        this.f660a = binding;
        this.f661b = selectAllCallback;
        this.f662c = deselectAllCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m487a(boolean z, C2134h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        (z ? this$0.f662c : this$0.f661b).invoke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m488a(final boolean z) {
        String string;
        C2154m c2154m = this.f660a;
        TextView textView = c2154m.f726c;
        if (z) {
            string = c2154m.f724a.getContext().getString(C2110R.string.deselect_all);
        } else {
            string = c2154m.f724a.getContext().getString(C2110R.string.select_all);
        }
        textView.setText(string);
        c2154m.f725b.setChecked(z);
        this.f660a.f724a.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.sdk.friend.c.h$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2134h.m487a(z, this, view);
            }
        });
    }
}
