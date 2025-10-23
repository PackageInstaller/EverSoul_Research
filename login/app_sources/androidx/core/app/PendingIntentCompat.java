package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class PendingIntentCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle, boolean z) {
        return Api16Impl.getActivities(context, i, intentArr, addMutabilityFlags(z, i2), bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, boolean z) {
        return PendingIntent.getActivities(context, i, intentArr, addMutabilityFlags(z, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, boolean z) {
        return PendingIntent.getActivity(context, i, intent, addMutabilityFlags(z, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle, boolean z) {
        return Api16Impl.getActivity(context, i, intent, addMutabilityFlags(z, i2), bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int i2, boolean z) {
        return PendingIntent.getBroadcast(context, i, intent, addMutabilityFlags(z, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i2, boolean z) {
        return Api26Impl.getForegroundService(context, i, intent, addMutabilityFlags(z, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getService(Context context, int i, Intent intent, int i2, boolean z) {
        return PendingIntent.getService(context, i, intent, addMutabilityFlags(z, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int addMutabilityFlags(boolean z, int i) {
        int i2;
        if (!z) {
            i2 = 67108864;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i;
            }
            i2 = 33554432;
        }
        return i | i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PendingIntentCompat() {
    }

    private static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle) {
            return PendingIntent.getActivities(context, i, intentArr, i2, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle) {
            return PendingIntent.getActivity(context, i, intent, i2, bundle);
        }
    }

    private static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i2) {
            return PendingIntent.getForegroundService(context, i, intent, i2);
        }
    }
}
