package org.apache.commons.lang3;

import com.liapp.y;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA;
    public static final CharSet ASCII_ALPHA_LOWER;
    public static final CharSet ASCII_ALPHA_UPPER;
    public static final CharSet ASCII_NUMERIC;
    protected static final Map<String, CharSet> COMMON;
    public static final CharSet EMPTY;
    private static final long serialVersionUID = 5947847346149275958L;
    private final Set<CharRange> set = Collections.synchronizedSet(new HashSet());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        CharSet charSet = new CharSet(null);
        EMPTY = charSet;
        String str = y.ٲٴݴ״ٰ(1781663504);
        CharSet charSet2 = new CharSet(str);
        ASCII_ALPHA = charSet2;
        String str2 = y.ݬֲ֮ܲت(1512977375);
        CharSet charSet3 = new CharSet(str2);
        ASCII_ALPHA_LOWER = charSet3;
        String str3 = y.ٲٴݴ״ٰ(1781663608);
        CharSet charSet4 = new CharSet(str3);
        ASCII_ALPHA_UPPER = charSet4;
        String str4 = y.֬ڱܱײٮ(-1159248471);
        CharSet charSet5 = new CharSet(str4);
        ASCII_NUMERIC = charSet5;
        Map<String, CharSet> synchronizedMap = Collections.synchronizedMap(new HashMap());
        COMMON = synchronizedMap;
        synchronizedMap.put(null, charSet);
        synchronizedMap.put("", charSet);
        synchronizedMap.put(str, charSet2);
        synchronizedMap.put(y.ݬֲ֮ܲت(1512977191), charSet2);
        synchronizedMap.put(str2, charSet3);
        synchronizedMap.put(str3, charSet4);
        synchronizedMap.put(str4, charSet5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSet getInstance(String... strArr) {
        CharSet charSet;
        if (strArr == null) {
            return null;
        }
        return (strArr.length != 1 || (charSet = COMMON.get(strArr[0])) == null) ? new CharSet(strArr) : charSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected CharSet(String... strArr) {
        for (String str : strArr) {
            add(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void add(String str) {
        if (str == null) {
            return;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            if (i2 >= 4 && str.charAt(i) == '^' && str.charAt(i + 2) == '-') {
                this.set.add(CharRange.isNotIn(str.charAt(i + 1), str.charAt(i + 3)));
                i += 4;
            } else if (i2 >= 3 && str.charAt(i + 1) == '-') {
                this.set.add(CharRange.isIn(str.charAt(i), str.charAt(i + 2)));
                i += 3;
            } else if (i2 >= 2 && str.charAt(i) == '^') {
                this.set.add(CharRange.isNot(str.charAt(i + 1)));
                i += 2;
            } else {
                this.set.add(CharRange.m883is(str.charAt(i)));
                i++;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CharRange[] getCharRanges() {
        Set<CharRange> set = this.set;
        return (CharRange[]) set.toArray(new CharRange[set.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(char c) {
        Iterator<CharRange> it = this.set.iterator();
        while (it.hasNext()) {
            if (it.next().contains(c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CharSet) {
            return this.set.equals(((CharSet) obj).set);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.set.toString();
    }
}
