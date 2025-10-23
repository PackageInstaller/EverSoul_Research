package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ParcelCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void readList(Parcel parcel, List<? super T> list, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            Api33Impl.readList(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.readArrayList(parcel, classLoader, cls);
        }
        return parcel.readArrayList(classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Object[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.readArray(parcel, classLoader, cls);
        }
        return parcel.readArray(classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.readSparseArray(parcel, classLoader, cls);
        }
        return parcel.readSparseArray(classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
        if (BuildCompat.isAtLeastU()) {
            Api33Impl.readMap(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.readHashMap(parcel, classLoader, cls, cls2);
        }
        return parcel.readHashMap(classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Parcelable> T readParcelable(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return (T) Api33Impl.readParcelable(parcel, classLoader, cls);
        }
        T t = (T) parcel.readParcelable(classLoader);
        if (cls.isInstance(t)) {
            return t;
        }
        throw new BadParcelableException("Parcelable " + t.getClass() + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.readParcelableCreator(parcel, classLoader, cls);
        }
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(parcel, classLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <T> T[] readParcelableArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return (T[]) Api33Impl.readParcelableArray(parcel, classLoader, cls);
        }
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        if (cls.isAssignableFrom(Parcelable.class)) {
            return (T[]) readParcelableArray;
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, readParcelableArray.length));
        for (int i = 0; i < readParcelableArray.length; i++) {
            try {
                tArr[i] = cls.cast(readParcelableArray[i]);
            } catch (ClassCastException unused) {
                throw new BadParcelableException("Parcelable at index " + i + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
            }
        }
        return tArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Parcelable[] readParcelableArrayTyped(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return (Parcelable[]) Api33Impl.readParcelableArray(parcel, classLoader, cls);
        }
        return parcel.readParcelableArray(classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> List<T> readParcelableList(Parcel parcel, List<T> list, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastU()) {
            return Api33Impl.readParcelableList(parcel, list, classLoader, cls);
        }
        return Api29Impl.readParcelableList(parcel, list, classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Serializable> T readSerializable(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        if (BuildCompat.isAtLeastT()) {
            return (T) Api33Impl.readSerializable(parcel, classLoader, cls);
        }
        return (T) parcel.readSerializable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ParcelCompat() {
    }

    static class Api29Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api29Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T extends Parcelable> List<T> readParcelableList(Parcel parcel, List<T> list, ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    static class Api30Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api30Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Parcelable.Creator<?> readParcelableCreator(Parcel parcel, ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    static class Api33Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api33Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T extends Serializable> T readSerializable(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return (T) parcel.readSerializable(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T extends Parcelable> T readParcelable(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return (T) parcel.readParcelable(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableCreator(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T[] readParcelableArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return (T[]) parcel.readParcelableArray(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> List<T> readParcelableList(Parcel parcel, List<T> list, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableList(list, classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> void readList(Parcel parcel, List<? super T> list, ClassLoader classLoader, Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readArrayList(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return (T[]) parcel.readArray(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readSparseArray(classLoader, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <V, K> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            return parcel.readHashMap(classLoader, cls, cls2);
        }
    }
}
