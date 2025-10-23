package com.kakao.sdk.friend.p023l;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.l.f */
/* loaded from: classes3.dex */
public final class C2190f {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final void m548a(Context context, EditText editText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Object systemService = context.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
