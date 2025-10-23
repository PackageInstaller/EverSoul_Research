package dagger.internal;

import com.liapp.y;

/* loaded from: classes3.dex */
public final class Preconditions {
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
    public static <T> T checkNotNull(T t, String str, Object obj) {
        String valueOf;
        if (t != null) {
            return t;
        }
        if (!str.contains("%s")) {
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        }
        if (str.indexOf("%s") != str.lastIndexOf("%s")) {
            throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
        }
        if (obj instanceof Class) {
            valueOf = ((Class) obj).getCanonicalName();
        } else {
            valueOf = String.valueOf(obj);
        }
        throw new NullPointerException(str.replace("%s", valueOf));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void checkBuilderRequirement(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + y.ݬֲ֮ܲت(1512265855));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Preconditions() {
    }
}
