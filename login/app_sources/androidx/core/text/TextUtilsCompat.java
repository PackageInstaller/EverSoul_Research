package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT = new Locale("", "");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String htmlEncode(String str) {
        return TextUtils.htmlEncode(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getLayoutDirectionFromLocale(Locale locale) {
        return Api17Impl.getLayoutDirectionFromLocale(locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TextUtilsCompat() {
    }

    static class Api17Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }
}
