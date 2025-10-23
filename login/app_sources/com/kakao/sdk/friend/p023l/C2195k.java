package com.kakao.sdk.friend.p023l;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.kakao.sdk.friend.C2110R;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.l.k */
/* loaded from: classes3.dex */
public final class C2195k {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final TypedValue m562a(Integer num, Context context) {
        Resources.Theme theme;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        int abs = Math.abs(num == null ? 0 : num.intValue() % 3);
        if (abs == 0) {
            theme = context.getTheme();
            i = C2110R.attr.default_profile_image1;
        } else {
            if (abs != 1) {
                if (abs == 2) {
                    theme = context.getTheme();
                    i = C2110R.attr.default_profile_image3;
                }
                return typedValue;
            }
            theme = context.getTheme();
            i = C2110R.attr.default_profile_image2;
        }
        theme.resolveAttribute(i, typedValue, true);
        return typedValue;
    }
}
