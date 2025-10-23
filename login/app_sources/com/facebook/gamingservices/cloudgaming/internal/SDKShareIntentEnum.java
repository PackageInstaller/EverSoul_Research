package com.facebook.gamingservices.cloudgaming.internal;

/* loaded from: classes.dex */
public enum SDKShareIntentEnum {
    INVITE("INVITE"),
    REQUEST("REQUEST"),
    CHALLENGE("CHALLENGE"),
    SHARE("SHARE");

    private final String mStringValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SDKShareIntentEnum(String stringValue) {
        this.mStringValue = stringValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    public String toString() {
        return this.mStringValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String validate(String intentType) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(intentType)) {
                return intentType;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SDKShareIntentEnum fromString(String intentType) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(intentType)) {
                return sDKShareIntentEnum;
            }
        }
        return null;
    }
}
