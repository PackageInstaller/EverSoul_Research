package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

/* loaded from: classes.dex */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    public static final int NULL_VALUE_VALUE = 0;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = new Internal.EnumLiteMap<NullValue>() { // from class: androidx.datastore.preferences.protobuf.NullValue.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
        public NullValue findValueByNumber(int i) {
            return NullValue.forNumber(i);
        }
    };
    private final int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static NullValue valueOf(int i) {
        return forNumber(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NullValue forNumber(int i) {
        if (i != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumVerifier internalGetVerifier() {
        return NullValueVerifier.INSTANCE;
    }

    private static final class NullValueVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new NullValueVerifier();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NullValueVerifier() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return NullValue.forNumber(i) != null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NullValue(int i) {
        this.value = i;
    }
}
