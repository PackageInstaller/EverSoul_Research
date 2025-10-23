package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CLObject(char[] cArr) {
        super(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(getDebugName());
        sb.append("{\n");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(",\n");
            }
            sb.append(next.toFormattedJSON(BASE_INDENT + i, i2 - 1));
        }
        sb.append(StringUtils.f1524LF);
        addIndent(sb, i);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    private class CLObjectIterator implements Iterator {
        int index = 0;
        CLObject myObject;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CLObjectIterator(CLObject cLObject) {
            this.myObject = cLObject;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.myObject.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Iterator
        public Object next() {
            CLKey cLKey = (CLKey) this.myObject.mElements.get(this.index);
            this.index++;
            return cLKey;
        }
    }
}
