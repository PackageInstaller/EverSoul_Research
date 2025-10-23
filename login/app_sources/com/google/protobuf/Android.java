package com.google.protobuf;

/* loaded from: classes3.dex */
final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC;
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Android() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        IS_ROBOLECTRIC = (ASSUME_ANDROID || getClassForName("org.robolectric.Robolectric") == null) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isOnAndroidDevice() {
        return ASSUME_ANDROID || !(MEMORY_CLASS == null || IS_ROBOLECTRIC);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> Class<T> getClassForName(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
