package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
abstract class TwitterResponseImpl implements TwitterResponse, Serializable {
    private static final long serialVersionUID = 7422171124869859808L;
    private final transient int accessLevel;
    private transient RateLimitStatus rateLimitStatus;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterResponseImpl() {
        this.rateLimitStatus = null;
        this.accessLevel = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterResponseImpl(HttpResponse httpResponse) {
        this.rateLimitStatus = null;
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
        this.accessLevel = ParseUtil.toAccessLevel(httpResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponse
    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponse
    public int getAccessLevel() {
        return this.accessLevel;
    }
}
