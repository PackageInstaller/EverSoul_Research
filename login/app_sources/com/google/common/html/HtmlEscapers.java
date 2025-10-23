package com.google.common.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape(Typography.quote, "&quot;").addEscape('\'', "&#39;").addEscape(Typography.amp, "&amp;").addEscape(Typography.less, "&lt;").addEscape(Typography.greater, "&gt;").build();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HtmlEscapers() {
    }
}
