package org.apache.commons.lang3.text;

import com.liapp.y;
import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

@Deprecated
/* loaded from: classes2.dex */
public class FormattableUtils {
    private static final String SIMPLEST_FORMAT = "%s";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Formattable formattable) {
        return String.format(SIMPLEST_FORMAT, formattable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i3) {
        return append(charSequence, formatter, i, i2, i3, ' ', null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, char c) {
        return append(charSequence, formatter, i, i2, i3, c, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, CharSequence charSequence2) {
        return append(charSequence, formatter, i, i2, i3, ' ', charSequence2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, char c, CharSequence charSequence2) {
        Validate.isTrue(charSequence2 == null || i3 < 0 || charSequence2.length() <= i3, y.٬ݯح׭٩(575929398), charSequence2, Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(charSequence);
        if (i3 >= 0 && i3 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.defaultIfNull(charSequence2, "");
            sb.replace(i3 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        boolean z = (i & 1) == 1;
        for (int length = sb.length(); length < i2; length++) {
            sb.insert(z ? length : 0, c);
        }
        formatter.format(sb.toString(), new Object[0]);
        return formatter;
    }
}
