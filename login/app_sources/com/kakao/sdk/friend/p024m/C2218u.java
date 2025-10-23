package com.kakao.sdk.friend.p024m;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p023l.C2190f;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.m.u */
/* loaded from: classes3.dex */
public final class C2218u extends ConstraintLayout implements TextWatcher {

    /* renamed from: a */
    public EditText f903a;

    /* renamed from: b */
    public ViewGroup f904b;

    /* renamed from: c */
    public View f905c;

    /* renamed from: d */
    public Function2<? super Context, ? super String, Unit> f906d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2218u(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        m593a(context2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m591a(C2218u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getEditText().getText().clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m592a() {
        getEditText().clearFocus();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        C2190f.m548a(context, getEditText());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m593a(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        View inflate = ((LayoutInflater) systemService).inflate(C2110R.layout.kakao_sdk_search_bar, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(C2110R.id.search_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.search_bar)");
        setEditText((EditText) findViewById);
        View findViewById2 = inflate.findViewById(C2110R.id.search_bar_delete_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.search_bar_delete_btn)");
        this.f904b = (ViewGroup) findViewById2;
        View findViewById3 = inflate.findViewById(C2110R.id.placeholder_margin_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.placeholder_margin_view)");
        this.f905c = findViewById3;
        getEditText().addTextChangedListener(this);
        ViewGroup viewGroup = this.f904b;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.sdk.friend.m.u$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2218u.m591a(C2218u.this, view);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        View view = null;
        if (editable == null || editable.length() == 0) {
            ViewGroup viewGroup = this.f904b;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
                viewGroup = null;
            }
            viewGroup.setVisibility(8);
            View view2 = this.f905c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholderMarginView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
        } else {
            ViewGroup viewGroup2 = this.f904b;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            View view3 = this.f905c;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholderMarginView");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        }
        Function2<? super Context, ? super String, Unit> function2 = this.f906d;
        if (function2 == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        function2.invoke(context, String.valueOf(editable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final EditText getEditText() {
        EditText editText = this.f903a;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editText");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setEditText(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.f903a = editText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setPlaceholderText(String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        getEditText().setHint(placeholder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSearchAction(Function2<? super Context, ? super String, Unit> searchAction) {
        Intrinsics.checkNotNullParameter(searchAction, "searchAction");
        this.f906d = searchAction;
    }
}
