package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class Android {
    private static final boolean IS_ROBOLECTRIC;
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Android() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        IS_ROBOLECTRIC = getClassForName("org.robolectric.Robolectric") != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isOnAndroidDevice() {
        return (MEMORY_CLASS == null || IS_ROBOLECTRIC) ? false : true;
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
