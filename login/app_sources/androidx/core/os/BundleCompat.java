package androidx.core.os;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class BundleCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BundleCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T getParcelable(Bundle bundle, String str, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return (T) Api33Impl.getParcelable(bundle, str, cls);
        }
        T t = (T) bundle.getParcelable(str);
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parcelable[] getParcelableArray(Bundle bundle, String str, Class<? extends Parcelable> cls) {
        if (BuildCompat.isAtLeastU()) {
            return (Parcelable[]) Api33Impl.getParcelableArray(bundle, str, cls);
        }
        return bundle.getParcelableArray(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> ArrayList<T> getParcelableArrayList(Bundle bundle, String str, Class<? extends T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.getParcelableArrayList(bundle, str, cls);
        }
        return bundle.getParcelableArrayList(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> SparseArray<T> getSparseParcelableArray(Bundle bundle, String str, Class<? extends T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.getSparseParcelableArray(bundle, str, cls);
        }
        return bundle.getSparseParcelableArray(str);
    }

    static class Api33Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api33Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T getParcelable(Bundle bundle, String str, Class<T> cls) {
            return (T) bundle.getParcelable(str, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T[] getParcelableArray(Bundle bundle, String str, Class<T> cls) {
            return (T[]) bundle.getParcelableArray(str, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> ArrayList<T> getParcelableArrayList(Bundle bundle, String str, Class<? extends T> cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> SparseArray<T> getSparseParcelableArray(Bundle bundle, String str, Class<? extends T> cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }
}
