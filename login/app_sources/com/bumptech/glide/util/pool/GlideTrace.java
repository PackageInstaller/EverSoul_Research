package com.bumptech.glide.util.pool;

/* loaded from: classes.dex */
public final class GlideTrace {
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beginSection(String str) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beginSectionFormat(String str, Object obj) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beginSectionFormat(String str, Object obj, Object obj2) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void beginSectionFormat(String str, Object obj, Object obj2, Object obj3) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void endSection() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GlideTrace() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String truncateTag(String str) {
        return str.length() > 127 ? str.substring(0, 126) : str;
    }
}
