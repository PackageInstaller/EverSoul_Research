package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class WakeLockHolder {
    private static final String EXTRA_WAKEFUL_INTENT = "com.google.firebase.iid.WakeLockHolder.wakefulintent";
    static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    private static final Object syncObject = new Object();
    private static WakeLock wakeLock;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    WakeLockHolder() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void checkAndInitWakeLock(Context context) {
        if (wakeLock == null) {
            WakeLock wakeLock2 = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            wakeLock = wakeLock2;
            wakeLock2.setReferenceCounted(true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ComponentName startWakefulService(Context context, Intent intent) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
            boolean isWakefulIntent = isWakefulIntent(intent);
            setAsWakefulIntent(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!isWakefulIntent) {
                wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
            }
            return startService;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void sendWakefulServiceIntent(Context context, WithinAppServiceConnection withinAppServiceConnection, final Intent intent) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
            boolean isWakefulIntent = isWakefulIntent(intent);
            setAsWakefulIntent(intent, true);
            if (!isWakefulIntent) {
                wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
            }
            withinAppServiceConnection.sendIntent(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.WakeLockHolder$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WakeLockHolder.completeWakefulIntent(intent);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void setAsWakefulIntent(Intent intent, boolean z) {
        intent.putExtra(EXTRA_WAKEFUL_INTENT, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isWakefulIntent(Intent intent) {
        return intent.getBooleanExtra(EXTRA_WAKEFUL_INTENT, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void completeWakefulIntent(Intent intent) {
        synchronized (syncObject) {
            if (wakeLock != null && isWakefulIntent(intent)) {
                setAsWakefulIntent(intent, false);
                wakeLock.release();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void acquireWakeLock(Intent intent, long j) {
        synchronized (syncObject) {
            if (wakeLock != null) {
                setAsWakefulIntent(intent, true);
                wakeLock.acquire(j);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void initWakeLock(Context context) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void reset() {
        synchronized (syncObject) {
            wakeLock = null;
        }
    }
}
