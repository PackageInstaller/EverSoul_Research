package org.apache.commons.lang3.builder;

import com.liapp.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class DiffResult implements Iterable<Diff<?>> {
    private static final String DIFFERS_STRING = "differs from";
    public static final String OBJECTS_SAME_STRING = "";
    private final List<Diff<?>> diffs;
    private final Object lhs;
    private final Object rhs;
    private final ToStringStyle style;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DiffResult(Object obj, Object obj2, List<Diff<?>> list, ToStringStyle toStringStyle) {
        Validate.isTrue(obj != null, y.ٴسسݬߨ(1392542514), new Object[0]);
        Validate.isTrue(obj2 != null, y.ۮڭڭܬި(862254403), new Object[0]);
        Validate.isTrue(list != null, y.ݬֲ֮ܲت(1512683039), new Object[0]);
        this.diffs = list;
        this.lhs = obj;
        this.rhs = obj2;
        if (toStringStyle == null) {
            this.style = ToStringStyle.DEFAULT_STYLE;
        } else {
            this.style = toStringStyle;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Diff<?>> getDiffs() {
        return Collections.unmodifiableList(this.diffs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getNumberOfDiffs() {
        return this.diffs.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ToStringStyle getToStringStyle() {
        return this.style;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return toString(this.style);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString(ToStringStyle toStringStyle) {
        if (this.diffs.isEmpty()) {
            return "";
        }
        ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
        ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
        for (Diff<?> diff : this.diffs) {
            toStringBuilder.append(diff.getFieldName(), diff.getLeft());
            toStringBuilder2.append(diff.getFieldName(), diff.getRight());
        }
        return String.format(y.ٲٴݴ״ٰ(1781891072), toStringBuilder.build(), y.ٴسسݬߨ(1392549626), toStringBuilder2.build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public Iterator<Diff<?>> iterator() {
        return this.diffs.iterator();
    }
}
