package org.intellij.lang.annotations;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* compiled from: PrintFormat.java */
/* loaded from: classes4.dex */
class PrintFormatPattern {
    private static final String ARG_INDEX = "(?:\\d+\\$)?";
    private static final String CONVERSION = "(?:[tT])?(?:[a-zA-Z%])";
    private static final String FLAGS = "(?:[-#+ 0,(<]*)?";
    private static final String PRECISION = "(?:\\.\\d+)?";
    static final String PRINT_FORMAT = "(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*";
    private static final String TEXT = "[^%]|%%";
    private static final String WIDTH = "(?:\\d+)?";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PrintFormatPattern() {
    }
}
