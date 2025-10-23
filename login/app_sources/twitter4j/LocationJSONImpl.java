package twitter4j;

import com.liapp.y;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class LocationJSONImpl implements Location {
    private static final long serialVersionUID = -1312752311160422264L;
    private final String countryCode;
    private final String countryName;
    private final String name;
    private final int placeCode;
    private final String placeName;
    private final String url;
    private final int woeid;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LocationJSONImpl(JSONObject jSONObject) throws TwitterException {
        String str = y.ٲٴݴ״ٰ(1782457088);
        try {
            this.woeid = ParseUtil.getInt("woeid", jSONObject);
            this.countryName = ParseUtil.getUnescapedString("country", jSONObject);
            this.countryCode = ParseUtil.getRawString("countryCode", jSONObject);
            boolean isNull = jSONObject.isNull(str);
            String str2 = y.ٲٴݴ״ٰ(1781623392);
            if (!isNull) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                this.placeName = ParseUtil.getUnescapedString(str2, jSONObject2);
                this.placeCode = ParseUtil.getInt("code", jSONObject2);
            } else {
                this.placeName = null;
                this.placeCode = -1;
            }
            this.name = ParseUtil.getUnescapedString(str2, jSONObject);
            this.url = ParseUtil.getUnescapedString("url", jSONObject);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Location> createLocationList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        return createLocationList(httpResponse.asJSONArray(), configuration.isJSONStoreEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Location> createLocationList(JSONArray jSONArray, boolean z) throws TwitterException {
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, (HttpResponse) null);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                LocationJSONImpl locationJSONImpl = new LocationJSONImpl(jSONObject);
                responseListImpl.add(locationJSONImpl);
                if (z) {
                    TwitterObjectFactory.registerJSONObject(locationJSONImpl, jSONObject);
                }
            }
            if (z) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public int getWoeid() {
        return this.woeid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public String getCountryName() {
        return this.countryName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public String getCountryCode() {
        return this.countryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public String getPlaceName() {
        return this.placeName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public int getPlaceCode() {
        return this.placeCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Location
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocationJSONImpl) && this.woeid == ((LocationJSONImpl) obj).woeid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.woeid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628160452) + this.woeid + y.ݮڮֲڭܩ(-628160156) + this.countryName + y.دײܮڳܯ(2051162061) + this.countryCode + y.دײܮڳܯ(2051161149) + this.placeName + y.֬ڱܱײٮ(-1158978575) + this.placeCode + y.֬ڱܱײٮ(-1158978959) + this.name + y.ۮڭڭܬި(862934675) + this.url + y.ݮڮֲڭܩ(-628973388);
    }
}
