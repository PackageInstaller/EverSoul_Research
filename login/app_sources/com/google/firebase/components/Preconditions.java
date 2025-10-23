package com.google.firebase.components;

/* loaded from: classes2.dex */
public final class Preconditions {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
