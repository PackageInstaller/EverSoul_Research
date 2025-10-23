package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* loaded from: classes.dex */
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Spanned fromHtml(String str, int i) {
        return Api24Impl.fromHtml(str, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Spanned fromHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Api24Impl.fromHtml(str, i, imageGetter, tagHandler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toHtml(Spanned spanned, int i) {
        return Api24Impl.toHtml(spanned, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HtmlCompat() {
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Spanned fromHtml(String str, int i) {
            return Html.fromHtml(str, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Spanned fromHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i, imageGetter, tagHandler);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String toHtml(Spanned spanned, int i) {
            return Html.toHtml(spanned, i);
        }
    }
}
