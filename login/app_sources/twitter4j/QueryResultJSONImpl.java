package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import com.kakaogame.addon.KGService;
import com.liapp.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class QueryResultJSONImpl extends TwitterResponseImpl implements QueryResult, Serializable {
    private static final long serialVersionUID = -5359566235429947156L;
    private double completedIn;
    private int count;
    private long maxId;
    private String nextResults;
    private String query;
    private String refreshUrl;
    private long sinceId;
    private List<Status> tweets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    QueryResultJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        String str = y.ݬֲ֮ܲت(1512200159);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        try {
            JSONObject jSONObject = asJSONObject.getJSONObject("search_metadata");
            this.completedIn = ParseUtil.getDouble("completed_in", jSONObject);
            this.count = ParseUtil.getInt(KGService.COUNT, jSONObject);
            this.maxId = ParseUtil.getLong("max_id", jSONObject);
            this.nextResults = jSONObject.has(str) ? jSONObject.getString(str) : null;
            this.query = ParseUtil.getURLDecodedString(SearchIntents.EXTRA_QUERY, jSONObject);
            this.refreshUrl = ParseUtil.getUnescapedString("refresh_url", jSONObject);
            this.sinceId = ParseUtil.getLong("since_id", jSONObject);
            JSONArray jSONArray = asJSONObject.getJSONArray("statuses");
            this.tweets = new ArrayList(jSONArray.length());
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                this.tweets.add(new StatusJSONImpl(jSONArray.getJSONObject(i), configuration));
            }
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + asJSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    QueryResultJSONImpl(Query query) {
        this.sinceId = query.getSinceId();
        this.count = query.getCount();
        this.tweets = new ArrayList(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public long getSinceId() {
        return this.sinceId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public long getMaxId() {
        return this.maxId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public String getRefreshURL() {
        return this.refreshUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public int getCount() {
        return this.count;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public double getCompletedIn() {
        return this.completedIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public String getQuery() {
        return this.query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public List<Status> getTweets() {
        return this.tweets;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public Query nextQuery() {
        String str = this.nextResults;
        if (str == null) {
            return null;
        }
        return Query.createWithNextPageQuery(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.QueryResult
    public boolean hasNext() {
        return this.nextResults != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QueryResult queryResult = (QueryResult) obj;
        if (Double.compare(queryResult.getCompletedIn(), this.completedIn) != 0 || this.maxId != queryResult.getMaxId() || this.count != queryResult.getCount() || this.sinceId != queryResult.getSinceId() || !this.query.equals(queryResult.getQuery())) {
            return false;
        }
        String str = this.refreshUrl;
        if (str == null ? queryResult.getRefreshURL() != null : !str.equals(queryResult.getRefreshURL())) {
            return false;
        }
        List<Status> list = this.tweets;
        List<Status> tweets = queryResult.getTweets();
        return list == null ? tweets == null : list.equals(tweets);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.sinceId;
        long j2 = this.maxId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.refreshUrl;
        int hashCode = ((i + (str != null ? str.hashCode() : 0)) * 31) + this.count;
        double d = this.completedIn;
        long doubleToLongBits = d != 0.0d ? Double.doubleToLongBits(d) : 0L;
        int hashCode2 = ((((hashCode * 31) + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits))) * 31) + this.query.hashCode()) * 31;
        List<Status> list = this.tweets;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051178181) + this.sinceId + y.دײܮڳܯ(2051150389) + this.maxId + y.֬ڱܱײٮ(-1158995815) + this.refreshUrl + y.֬ڱܱײٮ(-1158995175) + this.count + y.ݮڮֲڭܩ(-628143572) + this.completedIn + y.٬ݯح׭٩(576217422) + this.query + y.֬ڱܱײٮ(-1158995007) + this.tweets + '}';
    }
}
