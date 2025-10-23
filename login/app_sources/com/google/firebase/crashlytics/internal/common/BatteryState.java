package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes2.dex */
class BatteryState {
    static final int VELOCITY_CHARGING = 2;
    static final int VELOCITY_FULL = 3;
    static final int VELOCITY_UNPLUGGED = 1;
    private final Float level;
    private final boolean powerConnected;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BatteryState(Float f, boolean z) {
        this.powerConnected = z;
        this.level = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isPowerConnected() {
        return this.powerConnected;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Float getBatteryLevel() {
        return this.level;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getBatteryVelocity() {
        Float f;
        if (!this.powerConnected || (f = this.level) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BatteryState get(Context context) {
        boolean z = false;
        Float f = null;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z = isPowerConnected(registerReceiver);
                f = getLevel(registerReceiver);
            }
        } catch (IllegalStateException e) {
            Logger.getLogger().m393e("An error occurred getting battery state.", e);
        }
        return new BatteryState(f, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isPowerConnected(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Float getLevel(Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }
}
