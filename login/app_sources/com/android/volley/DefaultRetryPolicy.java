package com.android.volley;

/* loaded from: classes.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 0;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 0, 1.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DefaultRetryPolicy(int i, int i2, float f) {
        this.mCurrentTimeoutMs = i;
        this.mMaxNumRetries = i2;
        this.mBackoffMultiplier = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getBackoffMultiplier() {
        return this.mBackoffMultiplier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.mCurrentTimeoutMs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean hasAttemptRemaining() {
        return this.mCurrentRetryCount <= this.mMaxNumRetries;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.RetryPolicy
    public void retry(VolleyError volleyError) {
        this.mCurrentRetryCount++;
        float f = this.mCurrentTimeoutMs;
        this.mCurrentTimeoutMs = (int) (f + (this.mBackoffMultiplier * f));
        if (!hasAttemptRemaining()) {
            throw volleyError;
        }
    }
}
