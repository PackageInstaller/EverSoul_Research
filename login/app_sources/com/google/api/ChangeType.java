package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum ChangeType implements Internal.EnumLite {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);

    public static final int ADDED_VALUE = 1;
    public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int MODIFIED_VALUE = 3;
    public static final int REMOVED_VALUE = 2;
    private static final Internal.EnumLiteMap<ChangeType> internalValueMap = new Internal.EnumLiteMap<ChangeType>() { // from class: com.google.api.ChangeType.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ChangeType findValueByNumber(int i) {
            return ChangeType.forNumber(i);
        }
    };
    private final int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static ChangeType valueOf(int i) {
        return forNumber(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ChangeType forNumber(int i) {
        if (i == 0) {
            return CHANGE_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return ADDED;
        }
        if (i == 2) {
            return REMOVED;
        }
        if (i != 3) {
            return null;
        }
        return MODIFIED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumVerifier internalGetVerifier() {
        return ChangeTypeVerifier.INSTANCE;
    }

    private static final class ChangeTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ChangeTypeVerifier();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ChangeTypeVerifier() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ChangeType.forNumber(i) != null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ChangeType(int i) {
        this.value = i;
    }
}
