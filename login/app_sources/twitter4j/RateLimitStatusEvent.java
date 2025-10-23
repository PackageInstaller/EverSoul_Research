package twitter4j;

import java.util.EventObject;

/* loaded from: classes4.dex */
public final class RateLimitStatusEvent extends EventObject {
    private static final long serialVersionUID = 3749366911109722414L;
    private final boolean isAccountRateLimitStatus;
    private final RateLimitStatus rateLimitStatus;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RateLimitStatusEvent(Object obj, RateLimitStatus rateLimitStatus, boolean z) {
        super(obj);
        this.rateLimitStatus = rateLimitStatus;
        this.isAccountRateLimitStatus = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAccountRateLimitStatus() {
        return this.isAccountRateLimitStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isIPRateLimitStatus() {
        return !this.isAccountRateLimitStatus;
    }
}
