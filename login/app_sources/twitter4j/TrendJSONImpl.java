package twitter4j;

import com.liapp.y;
import java.io.Serializable;

/* loaded from: classes4.dex */
final class TrendJSONImpl implements Trend, Serializable {
    private static final long serialVersionUID = -4353426776065521132L;
    private final String name;
    private String query;
    private int tweetVolume;
    private String url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrendJSONImpl(JSONObject jSONObject, boolean z) {
        this.url = null;
        this.query = null;
        this.tweetVolume = -1;
        this.name = ParseUtil.getRawString(y.ٲٴݴ״ٰ(1781623392), jSONObject);
        this.url = ParseUtil.getRawString(y.ݬֲ֮ܲت(1512934047), jSONObject);
        this.query = ParseUtil.getRawString(y.ݮڮֲڭܩ(-628121724), jSONObject);
        this.tweetVolume = ParseUtil.getInt(y.ݮڮֲڭܩ(-628059852), jSONObject);
        if (z) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrendJSONImpl(JSONObject jSONObject) {
        this(jSONObject, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trend
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trend
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trend
    public String getQuery() {
        return this.query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trend
    public int getTweetVolume() {
        return this.tweetVolume;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trend)) {
            return false;
        }
        Trend trend = (Trend) obj;
        if (!this.name.equals(trend.getName())) {
            return false;
        }
        String str = this.query;
        if (str == null ? trend.getQuery() != null : !str.equals(trend.getQuery())) {
            return false;
        }
        String str2 = this.url;
        if (str2 == null ? trend.getURL() == null : str2.equals(trend.getURL())) {
            return this.tweetVolume == trend.getTweetVolume();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.query;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.tweetVolume;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628059772) + this.name + y.ۮڭڭܬި(862934675) + this.url + y.֬ڱܱײٮ(-1158349895) + this.query + y.دײܮڳܯ(2052957333) + this.tweetVolume + '}';
    }
}
