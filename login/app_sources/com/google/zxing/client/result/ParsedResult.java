package com.google.zxing.client.result;

/* loaded from: classes3.dex */
public abstract class ParsedResult {
    private final ParsedResultType type;

    public abstract String getDisplayResult();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ParsedResult(ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ParsedResultType getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return getDisplayResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void maybeAppend(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                maybeAppend(str, sb);
            }
        }
    }
}
