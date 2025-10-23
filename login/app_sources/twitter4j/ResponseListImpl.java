package twitter4j;

import java.util.ArrayList;

/* loaded from: classes4.dex */
class ResponseListImpl<T> extends ArrayList<T> implements ResponseList<T> {
    private static final long serialVersionUID = 9105950888010803544L;
    private transient int accessLevel;
    private transient RateLimitStatus rateLimitStatus;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ResponseListImpl(HttpResponse httpResponse) {
        this.rateLimitStatus = null;
        init(httpResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ResponseListImpl(int i, HttpResponse httpResponse) {
        super(i);
        this.rateLimitStatus = null;
        init(httpResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ResponseListImpl(RateLimitStatus rateLimitStatus, int i) {
        this.rateLimitStatus = rateLimitStatus;
        this.accessLevel = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(HttpResponse httpResponse) {
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
        this.accessLevel = ParseUtil.toAccessLevel(httpResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ResponseList, twitter4j.TwitterResponse
    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponse
    public int getAccessLevel() {
        return this.accessLevel;
    }
}
