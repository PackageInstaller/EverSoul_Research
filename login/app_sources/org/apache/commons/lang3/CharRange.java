package org.apache.commons.lang3;

import com.liapp.y;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CharRange(char c, char c2, boolean z) {
        if (c > c2) {
            c2 = c;
            c = c2;
        }
        this.start = c;
        this.end = c2;
        this.negated = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: is */
    public static CharRange m883is(char c) {
        return new CharRange(c, c, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharRange isNot(char c) {
        return new CharRange(c, c, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharRange isIn(char c, char c2) {
        return new CharRange(c, c2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharRange isNotIn(char c, char c2) {
        return new CharRange(c, c2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char getStart() {
        return this.start;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char getEnd() {
        return this.end;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isNegated() {
        return this.negated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(char c) {
        return (c >= this.start && c <= this.end) != this.negated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(CharRange charRange) {
        Validate.isTrue(charRange != null, y.ݬֲ֮ܲت(1512977599), new Object[0]);
        return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb = new StringBuilder(4);
            if (isNegated()) {
                sb.append('^');
            }
            sb.append(this.start);
            if (this.start != this.end) {
                sb.append('-');
                sb.append(this.end);
            }
            this.iToString = sb.toString();
        }
        return this.iToString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    private static class CharacterIterator implements Iterator<Character> {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CharacterIterator(CharRange charRange) {
            this.range = charRange;
            this.hasNext = true;
            if (charRange.negated) {
                if (charRange.start == 0) {
                    if (charRange.end != 65535) {
                        this.current = (char) (charRange.end + 1);
                        return;
                    } else {
                        this.hasNext = false;
                        return;
                    }
                }
                this.current = (char) 0;
                return;
            }
            this.current = charRange.start;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void prepareNext() {
            if (!this.range.negated) {
                if (this.current < this.range.end) {
                    this.current = (char) (this.current + 1);
                    return;
                } else {
                    this.hasNext = false;
                    return;
                }
            }
            char c = this.current;
            if (c != 65535) {
                if (c + 1 == this.range.start) {
                    if (this.range.end != 65535) {
                        this.current = (char) (this.range.end + 1);
                        return;
                    } else {
                        this.hasNext = false;
                        return;
                    }
                }
                this.current = (char) (this.current + 1);
                return;
            }
            this.hasNext = false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public Character next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            char c = this.current;
            prepareNext();
            return Character.valueOf(c);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
