package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Locale.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m839d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes.dex */
public final class LocaleKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int getLayoutDirection(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
