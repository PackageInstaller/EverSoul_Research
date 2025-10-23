package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

/* loaded from: classes.dex */
final class ProtobufLists {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ProtobufLists() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.BooleanList newBooleanList() {
        return new BooleanArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.IntList newIntList() {
        return new IntArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.LongList newLongList() {
        return new LongArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.FloatList newFloatList() {
        return new FloatArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.DoubleList newDoubleList() {
        return new DoubleArrayList();
    }
}
