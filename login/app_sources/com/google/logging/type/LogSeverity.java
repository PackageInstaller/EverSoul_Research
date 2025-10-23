package com.google.logging.type;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum LogSeverity implements Internal.EnumLite {
    DEFAULT(0),
    DEBUG(100),
    INFO(200),
    NOTICE(300),
    WARNING(400),
    ERROR(500),
    CRITICAL(600),
    ALERT(700),
    EMERGENCY(EMERGENCY_VALUE),
    UNRECOGNIZED(-1);

    public static final int ALERT_VALUE = 700;
    public static final int CRITICAL_VALUE = 600;
    public static final int DEBUG_VALUE = 100;
    public static final int DEFAULT_VALUE = 0;
    public static final int EMERGENCY_VALUE = 800;
    public static final int ERROR_VALUE = 500;
    public static final int INFO_VALUE = 200;
    public static final int NOTICE_VALUE = 300;
    public static final int WARNING_VALUE = 400;
    private static final Internal.EnumLiteMap<LogSeverity> internalValueMap = new Internal.EnumLiteMap<LogSeverity>() { // from class: com.google.logging.type.LogSeverity.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public LogSeverity findValueByNumber(int i) {
            return LogSeverity.forNumber(i);
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
    public static LogSeverity valueOf(int i) {
        return forNumber(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LogSeverity forNumber(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 100) {
            return DEBUG;
        }
        if (i == 200) {
            return INFO;
        }
        if (i == 300) {
            return NOTICE;
        }
        if (i == 400) {
            return WARNING;
        }
        if (i == 500) {
            return ERROR;
        }
        if (i == 600) {
            return CRITICAL;
        }
        if (i == 700) {
            return ALERT;
        }
        if (i != 800) {
            return null;
        }
        return EMERGENCY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
        return internalValueMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Internal.EnumVerifier internalGetVerifier() {
        return LogSeverityVerifier.INSTANCE;
    }

    private static final class LogSeverityVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new LogSeverityVerifier();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LogSeverityVerifier() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return LogSeverity.forNumber(i) != null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LogSeverity(int i) {
        this.value = i;
    }
}
