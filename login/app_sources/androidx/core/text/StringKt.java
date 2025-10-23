package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: String.kt */
@Metadata(m838d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, m839d2 = {"htmlEncode", "", "core-ktx_release"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes.dex */
public final class StringKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String htmlEncode(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String htmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.checkNotNullExpressionValue(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
