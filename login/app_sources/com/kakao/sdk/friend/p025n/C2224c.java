package com.kakao.sdk.friend.p025n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p016e.C2156o;
import com.kakao.sdk.friend.p023l.C2191g;
import com.kakao.sdk.friend.p024m.C2217t;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.n.c */
/* loaded from: classes3.dex */
public final class C2224c {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m617a(C2156o c2156o, Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(c2156o, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ImageButton backBtn = c2156o.f730b;
        Intrinsics.checkNotNullExpressionValue(backBtn, "backBtn");
        C2217t.m589a(backBtn, listener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m619a(C2156o c2156o, boolean z, int i) {
        Intrinsics.checkNotNullParameter(c2156o, "<this>");
        c2156o.f733e.setText(String.valueOf(i));
        c2156o.f733e.setVisibility((z || i <= 0) ? 4 : 0);
        c2156o.f731c.setEnabled(i > 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static final void m620b(C2156o c2156o, Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(c2156o, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView doneBtn = c2156o.f731c;
        Intrinsics.checkNotNullExpressionValue(doneBtn, "doneBtn");
        C2217t.m589a(doneBtn, listener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final C2156o m616a(ViewGroup viewGroup, LayoutInflater layoutInflater, String title, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics.checkNotNullParameter(title, "title");
        C2156o m511a = C2156o.m511a(layoutInflater.inflate(C2110R.layout.kakao_sdk_title_bar, viewGroup, false));
        Intrinsics.checkNotNullExpressionValue(m511a, "inflate(layoutInflater, this, false)");
        m511a.f734f.setText(title);
        if (!z) {
            m511a.f733e.setVisibility(4);
        }
        if (z2) {
            m511a.f731c.setText(viewGroup.getContext().getString(C2110R.string.next));
        }
        viewGroup.addView(m511a.f729a);
        return m511a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m618a(C2156o c2156o, boolean z) {
        int dimensionPixelSize;
        String string;
        Intrinsics.checkNotNullParameter(c2156o, "<this>");
        if (C2191g.f848c == 1) {
            dimensionPixelSize = c2156o.f729a.getResources().getDimensionPixelSize(C2110R.dimen.popup_title_bar_padding_top);
        } else {
            dimensionPixelSize = c2156o.f729a.getResources().getDimensionPixelSize(C2110R.dimen.popup_title_bar_padding_top_landscape);
        }
        if (z) {
            c2156o.f730b.setImageResource(C2110R.drawable.kakao_sdk_btn_back);
        }
        ImageButton imageButton = c2156o.f730b;
        if (z) {
            string = c2156o.f729a.getResources().getString(C2110R.string.accessibility_back);
        } else {
            string = c2156o.f729a.getResources().getString(C2110R.string.accessibility_close);
        }
        imageButton.setContentDescription(string);
        c2156o.f729a.setPadding(0, dimensionPixelSize, 0, 0);
        c2156o.f730b.measure(0, 0);
        c2156o.f732d.measure(0, 0);
        int max = Math.max(c2156o.f730b.getMeasuredWidth(), c2156o.f732d.getMeasuredWidth()) + c2156o.f729a.getResources().getDimensionPixelSize(C2110R.dimen.popup_title_bar_text_margin_start);
        c2156o.f734f.setGravity(17);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(c2156o.f729a);
        constraintSet.connect(c2156o.f734f.getId(), 6, 0, 6, max);
        constraintSet.connect(c2156o.f734f.getId(), 7, 0, 7, max);
        constraintSet.applyTo(c2156o.f729a);
    }
}
