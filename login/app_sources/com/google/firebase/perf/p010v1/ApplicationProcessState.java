package com.google.firebase.perf.p010v1;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum ApplicationProcessState implements Internal.EnumLite {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);

    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final int BACKGROUND_VALUE = 2;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final Internal.EnumLiteMap<ApplicationProcessState> internalValueMap = new Internal.EnumLiteMap<ApplicationProcessState>() { // from class: com.google.firebase.perf.v1.ApplicationProcessState.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ApplicationProcessState findValueByNumber(int i) {
            return ApplicationProcessState.forNumber(i);
        }
    };
    private final int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static ApplicationProcessState valueOf(int i) {
        return forNumber(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ApplicationProcessState forNumber(int i) {
        if (i == 0) {
            return APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        if (i == 1) {
            return FOREGROUND;
        }
        if (i == 2) {
            return BACKGROUND;
        }
        if (i != 3) {
            return null;
        }
        return FOREGROUND_BACKGROUND;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumLiteMap<ApplicationProcessState> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumVerifier internalGetVerifier() {
        return ApplicationProcessStateVerifier.INSTANCE;
    }

    private static final class ApplicationProcessStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ApplicationProcessStateVerifier();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ApplicationProcessStateVerifier() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ApplicationProcessState.forNumber(i) != null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ApplicationProcessState(int i) {
        this.value = i;
    }
}
