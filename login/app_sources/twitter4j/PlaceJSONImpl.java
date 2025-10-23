package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class PlaceJSONImpl extends TwitterResponseImpl implements Place, Serializable {
    private static final long serialVersionUID = -6368276880878829754L;
    private GeoLocation[][] boundingBoxCoordinates;
    private String boundingBoxType;
    private Place[] containedWithIn;
    private String country;
    private String countryCode;
    private String fullName;
    private GeoLocation[][] geometryCoordinates;
    private String geometryType;

    /* renamed from: id */
    private String f1568id;
    private String name;
    private String placeType;
    private String streetAddress;
    private String url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PlaceJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PlaceJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PlaceJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ٲٴݴ״ٰ(1782451384);
        String str2 = y.ݮڮֲڭܩ(-628139924);
        String str3 = y.دײܮڳܯ(2051174141);
        String str4 = y.ۮڭڭܬި(862913995);
        try {
            this.name = ParseUtil.getUnescapedString("name", jSONObject);
            this.streetAddress = ParseUtil.getUnescapedString("street_address", jSONObject);
            this.countryCode = ParseUtil.getRawString("country_code", jSONObject);
            this.f1568id = ParseUtil.getRawString("id", jSONObject);
            this.country = ParseUtil.getRawString("country", jSONObject);
            boolean isNull = jSONObject.isNull(str4);
            String str5 = y.ٲٴݴ״ٰ(1781623144);
            if (!isNull) {
                this.placeType = ParseUtil.getRawString(str4, jSONObject);
            } else {
                this.placeType = ParseUtil.getRawString(str5, jSONObject);
            }
            this.url = ParseUtil.getRawString("url", jSONObject);
            this.fullName = ParseUtil.getRawString("full_name", jSONObject);
            boolean isNull2 = jSONObject.isNull(str3);
            String str6 = y.٬ݯح׭٩(576194518);
            if (!isNull2) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                this.boundingBoxType = ParseUtil.getRawString(str5, jSONObject2);
                this.boundingBoxCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONObject2.getJSONArray(str6));
            } else {
                this.boundingBoxType = null;
                this.boundingBoxCoordinates = null;
            }
            if (!jSONObject.isNull(str2)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(str2);
                this.geometryType = ParseUtil.getRawString(str5, jSONObject3);
                JSONArray jSONArray = jSONObject3.getJSONArray(str6);
                if (this.geometryType.equals("Point")) {
                    GeoLocation[][] geoLocationArr = (GeoLocation[][]) Array.newInstance((Class<?>) GeoLocation.class, 1, 1);
                    this.geometryCoordinates = geoLocationArr;
                    geoLocationArr[0][0] = new GeoLocation(jSONArray.getDouble(1), jSONArray.getDouble(0));
                } else if (this.geometryType.equals("Polygon")) {
                    this.geometryCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONArray);
                } else {
                    this.geometryType = null;
                    this.geometryCoordinates = null;
                }
            } else {
                this.geometryType = null;
                this.geometryCoordinates = null;
            }
            if (!jSONObject.isNull(str)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(str);
                this.containedWithIn = new Place[jSONArray2.length()];
                for (int i = 0; i < jSONArray2.length(); i++) {
                    this.containedWithIn[i] = new PlaceJSONImpl(jSONArray2.getJSONObject(i));
                }
                return;
            }
            this.containedWithIn = null;
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(Place place) {
        return this.f1568id.compareTo(place.getId());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Place> createPlaceList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject jSONObject;
        try {
            jSONObject = httpResponse.asJSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            return createPlaceList(jSONObject.getJSONObject("result").getJSONArray("places"), httpResponse, configuration);
        } catch (JSONException e2) {
            e = e2;
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Place> createPlaceList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                PlaceJSONImpl placeJSONImpl = new PlaceJSONImpl(jSONObject);
                responseListImpl.add(placeJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(placeJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getStreetAddress() {
        return this.streetAddress;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getCountryCode() {
        return this.countryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getId() {
        return this.f1568id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getCountry() {
        return this.country;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getPlaceType() {
        return this.placeType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getFullName() {
        return this.fullName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getBoundingBoxType() {
        return this.boundingBoxType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public GeoLocation[][] getBoundingBoxCoordinates() {
        return this.boundingBoxCoordinates;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public String getGeometryType() {
        return this.geometryType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public GeoLocation[][] getGeometryCoordinates() {
        return this.geometryCoordinates;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Place
    public Place[] getContainedWithIn() {
        return this.containedWithIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Place) && ((Place) obj).getId().equals(this.f1568id);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.f1568id.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(576235886)).append(this.name).append(y.ݬֲ֮ܲت(1512195479)).append(this.streetAddress).append(y.دײܮڳܯ(2051162061)).append(this.countryCode).append(y.دײܮڳܯ(2051173597)).append(this.f1568id).append(y.ݬֲ֮ܲت(1512195439)).append(this.country).append(y.دײܮڳܯ(2051173653)).append(this.placeType).append(y.ۮڭڭܬި(862934675)).append(this.url).append(y.ۮڭڭܬި(862914259)).append(this.fullName).append(y.ٴسسݬߨ(1393256450)).append(this.boundingBoxType).append(y.ݬֲ֮ܲت(1512194711));
        GeoLocation[][] geoLocationArr = this.boundingBoxCoordinates;
        StringBuilder append2 = append.append(geoLocationArr == null ? null : Arrays.asList(geoLocationArr)).append(y.ݬֲ֮ܲت(1512194679)).append(this.geometryType).append(y.ݮڮֲڭܩ(-628138452));
        GeoLocation[][] geoLocationArr2 = this.geometryCoordinates;
        StringBuilder append3 = append2.append(geoLocationArr2 == null ? null : Arrays.asList(geoLocationArr2)).append(y.ݮڮֲڭܩ(-628138220));
        Place[] placeArr = this.containedWithIn;
        return append3.append(placeArr != null ? Arrays.asList(placeArr) : null).append('}').toString();
    }
}
