package twitter4j;

/* loaded from: classes4.dex */
class DirectMessageListImpl extends ResponseListImpl<DirectMessage> implements DirectMessageList {
    private static final long serialVersionUID = 8150060768287194508L;
    private final String nextCursor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DirectMessageListImpl(RateLimitStatus rateLimitStatus, int i) {
        super(rateLimitStatus, i);
        this.nextCursor = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DirectMessageListImpl(int i, JSONObject jSONObject, HttpResponse httpResponse) {
        super(i, httpResponse);
        this.nextCursor = ParseUtil.getRawString("next_cursor", jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DirectMessageListImpl(int i, HttpResponse httpResponse) {
        super(i, httpResponse);
        this.nextCursor = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessageList
    public String getNextCursor() {
        return this.nextCursor;
    }
}
