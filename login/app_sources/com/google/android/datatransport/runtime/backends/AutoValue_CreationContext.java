package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes.dex */
final class AutoValue_CreationContext extends CreationContext {
    private final Context applicationContext;
    private final String backendName;
    private final Clock monotonicClock;
    private final Clock wallClock;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.applicationContext = context;
        if (clock == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.wallClock = clock;
        if (clock2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.monotonicClock = clock2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.backendName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context getApplicationContext() {
        return this.applicationContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getWallClock() {
        return this.wallClock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getMonotonicClock() {
        return this.monotonicClock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public String getBackendName() {
        return this.backendName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "CreationContext{applicationContext=" + this.applicationContext + ", wallClock=" + this.wallClock + ", monotonicClock=" + this.monotonicClock + ", backendName=" + this.backendName + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        return this.applicationContext.equals(creationContext.getApplicationContext()) && this.wallClock.equals(creationContext.getWallClock()) && this.monotonicClock.equals(creationContext.getMonotonicClock()) && this.backendName.equals(creationContext.getBackendName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return ((((((this.applicationContext.hashCode() ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003) ^ this.backendName.hashCode();
    }
}
