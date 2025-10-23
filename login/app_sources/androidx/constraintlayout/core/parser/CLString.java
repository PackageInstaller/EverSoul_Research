package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLString extends CLElement {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CLString(char[] cArr) {
        super(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CLElement allocate(char[] cArr) {
        return new CLString(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        return "'" + content() + "'";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append("'");
        sb.append(content());
        sb.append("'");
        return sb.toString();
    }
}
