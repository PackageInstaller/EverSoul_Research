package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class CharEscaperBuilder {
    private int max = -1;
    private final Map<Character, String> map = new HashMap();

    private static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CharArrayDecorator(char[][] cArr) {
            this.replacements = cArr;
            this.replaceLength = cArr.length;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i);
                }
            }
            return str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        protected char[] escape(char c) {
            if (c < this.replaceLength) {
                return this.replacements[c];
            }
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharEscaperBuilder addEscape(char c, String str) {
        this.map.put(Character.valueOf(c), (String) Preconditions.checkNotNull(str));
        if (c > this.max) {
            this.max = c;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char c : cArr) {
            addEscape(c, str);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char[][] toArray() {
        char[][] cArr = new char[this.max + 1][];
        for (Map.Entry<Character, String> entry : this.map.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
