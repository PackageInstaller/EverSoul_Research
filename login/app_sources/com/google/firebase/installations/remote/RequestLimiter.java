package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isRetryableError(int i) {
        return i == 429 || (i >= 500 && i < 600);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isSuccessfulOrRequiresNewFidCreation(int i) {
        return (i >= 200 && i < 300) || i == 401 || i == 404;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestLimiter(Utils utils) {
        this.utils = utils;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestLimiter() {
        this.utils = Utils.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setNextRequestTime(int i) {
        if (isSuccessfulOrRequiresNewFidCreation(i)) {
            resetBackoffStrategy();
            return;
        }
        this.attemptCount++;
        this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized long getBackoffDuration(int i) {
        if (!isRetryableError(i)) {
            return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        }
        return (long) Math.min(Math.pow(2.0d, this.attemptCount) + this.utils.getRandomDelayForSyncPrevention(), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isRequestAllowed() {
        boolean z;
        if (this.attemptCount != 0) {
            z = this.utils.currentTimeInMillis() > this.nextRequestTime;
        }
        return z;
    }
}
