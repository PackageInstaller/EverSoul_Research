package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class TrendsJSONImpl extends TwitterResponseImpl implements Trends, Serializable {
    private static final long serialVersionUID = 2054973282133379835L;
    private Date asOf;
    private Location location;
    private Date trendAt;
    private Trend[] trends;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(Trends trends) {
        return this.trendAt.compareTo(trends.getTrendAt());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrendsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        init(httpResponse.asString(), configuration.isJSONStoreEnabled());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrendsJSONImpl(String str) throws TwitterException {
        this(str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrendsJSONImpl(String str, boolean z) throws TwitterException {
        init(str, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void init(String str, boolean z) throws TwitterException {
        JSONObject jSONObject;
        try {
            if (str.startsWith("[")) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    jSONObject = jSONArray.getJSONObject(0);
                } else {
                    throw new TwitterException("No trends found on the specified woeid");
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            this.asOf = ParseUtil.parseTrendsDate(jSONObject.getString("as_of"));
            this.location = extractLocation(jSONObject, z);
            JSONArray jSONArray2 = jSONObject.getJSONArray("trends");
            this.trendAt = this.asOf;
            this.trends = jsonArrayToTrendArray(jSONArray2, z);
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrendsJSONImpl(Date date, Location location, Date date2, Trend[] trendArr) {
        this.asOf = date;
        this.location = location;
        this.trendAt = date2;
        this.trends = trendArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Trends> createTrendsList(HttpResponse httpResponse, boolean z) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        try {
            Date parseTrendsDate = ParseUtil.parseTrendsDate(asJSONObject.getString("as_of"));
            JSONObject jSONObject = asJSONObject.getJSONObject("trends");
            Location extractLocation = extractLocation(asJSONObject, z);
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONObject.length(), httpResponse);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Trend[] jsonArrayToTrendArray = jsonArrayToTrendArray(jSONObject.getJSONArray(next), z);
                if (next.length() == 19) {
                    responseListImpl.add(new TrendsJSONImpl(parseTrendsDate, extractLocation, ParseUtil.getDate(next, "yyyy-MM-dd HH:mm:ss"), jsonArrayToTrendArray));
                } else if (next.length() == 16) {
                    responseListImpl.add(new TrendsJSONImpl(parseTrendsDate, extractLocation, ParseUtil.getDate(next, "yyyy-MM-dd HH:mm"), jsonArrayToTrendArray));
                } else if (next.length() == 10) {
                    responseListImpl.add(new TrendsJSONImpl(parseTrendsDate, extractLocation, ParseUtil.getDate(next, "yyyy-MM-dd"), jsonArrayToTrendArray));
                }
            }
            Collections.sort(responseListImpl);
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + httpResponse.asString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Location extractLocation(JSONObject jSONObject, boolean z) throws TwitterException {
        String str = y.ٲٴݴ״ٰ(1780594784);
        if (jSONObject.isNull(str)) {
            return null;
        }
        try {
            ResponseList<Location> createLocationList = LocationJSONImpl.createLocationList(jSONObject.getJSONArray(str), z);
            if (createLocationList.size() != 0) {
                return createLocationList.get(0);
            }
            return null;
        } catch (JSONException unused) {
            throw new AssertionError("locations can't be null");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Trend[] jsonArrayToTrendArray(JSONArray jSONArray, boolean z) throws JSONException {
        Trend[] trendArr = new Trend[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            trendArr[i] = new TrendJSONImpl(jSONArray.getJSONObject(i), z);
        }
        return trendArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trends
    public Trend[] getTrends() {
        return this.trends;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trends
    public Location getLocation() {
        return this.location;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trends
    public Date getAsOf() {
        return this.asOf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Trends
    public Date getTrendAt() {
        return this.trendAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trends)) {
            return false;
        }
        Trends trends = (Trends) obj;
        Date date = this.asOf;
        if (date == null ? trends.getAsOf() != null : !date.equals(trends.getAsOf())) {
            return false;
        }
        Date date2 = this.trendAt;
        if (date2 == null ? trends.getTrendAt() == null : date2.equals(trends.getTrendAt())) {
            return Arrays.equals(this.trends, trends.getTrends());
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Date date = this.asOf;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.trendAt;
        int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        Trend[] trendArr = this.trends;
        return hashCode2 + (trendArr != null ? Arrays.hashCode(trendArr) : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.ٲٴݴ״ٰ(1780594904)).append(this.asOf).append(y.ݬֲ֮ܲت(1513982951)).append(this.trendAt).append(y.ݮڮֲڭܩ(-628058996));
        Trend[] trendArr = this.trends;
        return append.append(trendArr == null ? null : Arrays.asList(trendArr)).append('}').toString();
    }
}
