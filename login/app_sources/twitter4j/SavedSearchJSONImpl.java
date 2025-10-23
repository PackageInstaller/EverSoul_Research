package twitter4j;

import com.liapp.y;
import java.util.Date;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class SavedSearchJSONImpl extends TwitterResponseImpl implements SavedSearch {
    private static final long serialVersionUID = -2281949861485441692L;
    private Date createdAt;

    /* renamed from: id */
    private long f1571id;
    private String name;
    private int position;
    private String query;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SavedSearchJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SavedSearchJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONArray asJSONArray = httpResponse.asJSONArray();
        try {
            ResponseListImpl responseListImpl = new ResponseListImpl(asJSONArray.length(), httpResponse);
            for (int i = 0; i < asJSONArray.length(); i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                SavedSearchJSONImpl savedSearchJSONImpl = new SavedSearchJSONImpl(jSONObject);
                responseListImpl.add(savedSearchJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(savedSearchJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + httpResponse.asString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        this.createdAt = ParseUtil.getDate(y.ۮڭڭܬި(862635699), jSONObject, y.ݬֲ֮ܲت(1512203519));
        this.query = ParseUtil.getUnescapedString(y.ݮڮֲڭܩ(-628121724), jSONObject);
        this.position = ParseUtil.getInt(y.֬ڱܱײٮ(-1158998663), jSONObject);
        this.name = ParseUtil.getUnescapedString(y.ٲٴݴ״ٰ(1781623392), jSONObject);
        this.f1571id = ParseUtil.getLong(y.ٲٴݴ״ٰ(1781792816), jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(SavedSearch savedSearch) {
        return (int) (this.f1571id - savedSearch.getId());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.SavedSearch
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.SavedSearch
    public String getQuery() {
        return this.query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.SavedSearch
    public int getPosition() {
        return this.position;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.SavedSearch
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.SavedSearch
    public long getId() {
        return this.f1571id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SavedSearch) && this.f1571id == ((SavedSearch) obj).getId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((((this.createdAt.hashCode() * 31) + this.query.hashCode()) * 31) + this.position) * 31) + this.name.hashCode()) * 31) + ((int) this.f1571id);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1782470528) + this.createdAt + y.٬ݯح׭٩(576217422) + this.query + y.֬ڱܱײٮ(-1158998871) + this.position + y.ݬֲ֮ܲت(1512211415) + this.name + y.ٴسسݬߨ(1393248858) + this.f1571id + '}';
    }
}
