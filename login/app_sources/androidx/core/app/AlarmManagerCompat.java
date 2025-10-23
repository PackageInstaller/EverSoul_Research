package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;

/* loaded from: classes.dex */
public final class AlarmManagerCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAlarmClock(AlarmManager alarmManager, long j, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(j, pendingIntent), pendingIntent2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Api23Impl.setAndAllowWhileIdle(alarmManager, i, j, pendingIntent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setExact(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Api19Impl.setExact(alarmManager, i, j, pendingIntent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager, i, j, pendingIntent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AlarmManagerCompat() {
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAlarmClock(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long j, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j, pendingIntent);
        }
    }

    static class Api23Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api23Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i, j, pendingIntent);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
        }
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setExact(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setExact(i, j, pendingIntent);
        }
    }
}
