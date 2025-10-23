package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* renamed from: id */
    private final int f425id;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DeliveryMechanism(int i) {
        this.f425id = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getId() {
        return this.f425id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f425id);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
