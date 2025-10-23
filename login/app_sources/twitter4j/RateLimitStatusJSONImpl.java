package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class RateLimitStatusJSONImpl implements RateLimitStatus, Serializable {
    private static final long serialVersionUID = 7790337632915862445L;
    private int limit;
    private int remaining;
    private int resetTimeInSeconds;
    private int secondsUntilReset;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        Map<String, RateLimitStatus> createRateLimitStatuses = createRateLimitStatuses(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(createRateLimitStatuses, asJSONObject);
        }
        return createRateLimitStatuses;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Map<String, RateLimitStatus> createRateLimitStatuses(JSONObject jSONObject) throws TwitterException {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("resources");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(keys.next());
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    hashMap.put(next, new RateLimitStatusJSONImpl(jSONObject3.getJSONObject(next)));
                }
            }
            return Collections.unmodifiableMap(hashMap);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RateLimitStatusJSONImpl(int i, int i2, int i3) {
        this.limit = i;
        this.remaining = i2;
        this.resetTimeInSeconds = i3;
        this.secondsUntilReset = (int) (((i3 * 1000) - System.currentTimeMillis()) / 1000);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RateLimitStatusJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void init(JSONObject jSONObject) throws TwitterException {
        this.limit = ParseUtil.getInt(y.ݮڮֲڭܩ(-628790308), jSONObject);
        this.remaining = ParseUtil.getInt(y.ݮڮֲڭܩ(-628142260), jSONObject);
        int i = ParseUtil.getInt(y.٬ݯح׭٩(576442950), jSONObject);
        this.resetTimeInSeconds = i;
        this.secondsUntilReset = (int) (((i * 1000) - System.currentTimeMillis()) / 1000);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static RateLimitStatus createFromResponseHeader(HttpResponse httpResponse) {
        String responseHeader;
        if (httpResponse == null || (responseHeader = httpResponse.getResponseHeader(y.ۮڭڭܬި(862916651))) == null) {
            return null;
        }
        int parseInt = Integer.parseInt(responseHeader);
        String responseHeader2 = httpResponse.getResponseHeader(y.دײܮڳܯ(2051177421));
        if (responseHeader2 == null) {
            return null;
        }
        int parseInt2 = Integer.parseInt(responseHeader2);
        String responseHeader3 = httpResponse.getResponseHeader(y.ٴسسݬߨ(1393261090));
        if (responseHeader3 != null) {
            return new RateLimitStatusJSONImpl(parseInt, parseInt2, (int) Long.parseLong(responseHeader3));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.RateLimitStatus
    public int getRemaining() {
        return this.remaining;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.RateLimitStatus
    public int getLimit() {
        return this.limit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.RateLimitStatus
    public int getResetTimeInSeconds() {
        return this.resetTimeInSeconds;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.RateLimitStatus
    public int getSecondsUntilReset() {
        return this.secondsUntilReset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RateLimitStatusJSONImpl rateLimitStatusJSONImpl = (RateLimitStatusJSONImpl) obj;
        return this.limit == rateLimitStatusJSONImpl.limit && this.remaining == rateLimitStatusJSONImpl.remaining && this.resetTimeInSeconds == rateLimitStatusJSONImpl.resetTimeInSeconds && this.secondsUntilReset == rateLimitStatusJSONImpl.secondsUntilReset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((this.remaining * 31) + this.limit) * 31) + this.resetTimeInSeconds) * 31) + this.secondsUntilReset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051176709) + this.remaining + y.ٲٴݴ״ٰ(1782475648) + this.limit + y.٬ݯح׭٩(576237782) + this.resetTimeInSeconds + y.ٲٴݴ״ٰ(1782475400) + this.secondsUntilReset + '}';
    }
}
