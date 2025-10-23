package com.google.firebase.perf.p010v1;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum SessionVerbosity implements Internal.EnumLite {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);

    public static final int GAUGES_AND_SYSTEM_EVENTS_VALUE = 1;
    public static final int SESSION_VERBOSITY_NONE_VALUE = 0;
    private static final Internal.EnumLiteMap<SessionVerbosity> internalValueMap = new Internal.EnumLiteMap<SessionVerbosity>() { // from class: com.google.firebase.perf.v1.SessionVerbosity.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public SessionVerbosity findValueByNumber(int i) {
            return SessionVerbosity.forNumber(i);
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
    public static SessionVerbosity valueOf(int i) {
        return forNumber(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SessionVerbosity forNumber(int i) {
        if (i == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumLiteMap<SessionVerbosity> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumVerifier internalGetVerifier() {
        return SessionVerbosityVerifier.INSTANCE;
    }

    private static final class SessionVerbosityVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SessionVerbosityVerifier();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionVerbosityVerifier() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SessionVerbosity.forNumber(i) != null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SessionVerbosity(int i) {
        this.value = i;
    }
}
