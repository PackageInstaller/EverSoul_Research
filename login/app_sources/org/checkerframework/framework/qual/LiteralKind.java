package org.checkerframework.framework.qual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public enum LiteralKind {
    NULL,
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    BOOLEAN,
    CHAR,
    STRING,
    ALL,
    PRIMITIVE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<LiteralKind> allLiteralKinds() {
        ArrayList arrayList = new ArrayList(Arrays.asList(values()));
        arrayList.remove(ALL);
        arrayList.remove(PRIMITIVE);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<LiteralKind> primitiveLiteralKinds() {
        return Arrays.asList(INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR);
    }
}
