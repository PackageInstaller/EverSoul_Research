package com.google.common.base;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class CommonPattern {
    public abstract int flags();

    public abstract CommonMatcher matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CommonPattern() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CommonPattern compile(String str) {
        return Platform.compilePattern(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isPcreLike() {
        return Platform.patternCompilerIsPcreLike();
    }
}
