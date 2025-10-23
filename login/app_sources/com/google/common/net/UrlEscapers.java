package com.google.common.net;

import com.google.common.escape.Escaper;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class UrlEscapers {
    static final String URL_PATH_OTHER_SAFE_CHARS_LACKING_PLUS = "-._~!$'()*,;&=@:";
    static final String URL_FORM_PARAMETER_OTHER_SAFE_CHARS = "-_.*";
    private static final Escaper URL_FORM_PARAMETER_ESCAPER = new PercentEscaper(URL_FORM_PARAMETER_OTHER_SAFE_CHARS, true);
    private static final Escaper URL_PATH_SEGMENT_ESCAPER = new PercentEscaper("-._~!$'()*,;&=@:+", false);
    private static final Escaper URL_FRAGMENT_ESCAPER = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UrlEscapers() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Escaper urlFormParameterEscaper() {
        return URL_FORM_PARAMETER_ESCAPER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Escaper urlPathSegmentEscaper() {
        return URL_PATH_SEGMENT_ESCAPER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Escaper urlFragmentEscaper() {
        return URL_FRAGMENT_ESCAPER;
    }
}
