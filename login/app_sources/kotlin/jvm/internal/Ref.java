package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Ref {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Ref() {
    }

    public static final class ObjectRef<T> implements Serializable {
        public T element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ByteRef implements Serializable {
        public byte element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf((int) this.element);
        }
    }

    public static final class ShortRef implements Serializable {
        public short element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf((int) this.element);
        }
    }

    public static final class IntRef implements Serializable {
        public int element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class LongRef implements Serializable {
        public long element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class FloatRef implements Serializable {
        public float element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class DoubleRef implements Serializable {
        public double element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class CharRef implements Serializable {
        public char element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class BooleanRef implements Serializable {
        public boolean element;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.valueOf(this.element);
        }
    }
}
