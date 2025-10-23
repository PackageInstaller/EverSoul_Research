package twitter4j;

import com.kakaogame.addon.KGService;
import com.liapp.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class Query implements Serializable {
    private static final long serialVersionUID = 7196404519192910019L;
    private int count;
    private String geocode;
    private String lang;
    private String locale;
    private long maxId;
    private String nextPageQuery;
    private String query;
    private ResultType resultType;
    private String since;
    private long sinceId;
    private String until;
    public static final Unit MILES = Unit.f1570mi;
    public static final Unit KILOMETERS = Unit.f1569km;
    public static final ResultType MIXED = ResultType.mixed;
    public static final ResultType POPULAR = ResultType.popular;
    public static final ResultType RECENT = ResultType.recent;
    private static final HttpParameter WITH_TWITTER_USER_ID = new HttpParameter(y.ݬֲ֮ܲت(1512198015), y.دײܮڳܯ(2051939573));

    public enum ResultType {
        popular,
        mixed,
        recent
    }

    public enum Unit {
        f1570mi,
        f1569km
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query() {
        this.query = null;
        this.lang = null;
        this.locale = null;
        this.maxId = -1L;
        this.count = -1;
        this.since = null;
        this.sinceId = -1L;
        this.geocode = null;
        this.until = null;
        this.resultType = null;
        this.nextPageQuery = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query(String str) {
        this.lang = null;
        this.locale = null;
        this.maxId = -1L;
        this.count = -1;
        this.since = null;
        this.sinceId = -1L;
        this.geocode = null;
        this.until = null;
        this.resultType = null;
        this.nextPageQuery = null;
        this.query = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Query createWithNextPageQuery(String str) {
        double d;
        Unit unit;
        Query query = new Query();
        query.nextPageQuery = str;
        if (str != null) {
            String substring = str.substring(1, str.length());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (HttpParameter httpParameter : HttpParameter.decodeParameters(substring)) {
                linkedHashMap.put(httpParameter.getName(), httpParameter.getValue());
            }
            if (linkedHashMap.containsKey("q")) {
                query.setQuery((String) linkedHashMap.get("q"));
            }
            if (linkedHashMap.containsKey("lang")) {
                query.setLang((String) linkedHashMap.get("lang"));
            }
            if (linkedHashMap.containsKey("locale")) {
                query.setLocale((String) linkedHashMap.get("locale"));
            }
            if (linkedHashMap.containsKey("max_id")) {
                query.setMaxId(Long.parseLong((String) linkedHashMap.get("max_id")));
            }
            if (linkedHashMap.containsKey(KGService.COUNT)) {
                query.setCount(Integer.parseInt((String) linkedHashMap.get(KGService.COUNT)));
            }
            if (linkedHashMap.containsKey("geocode")) {
                String[] split = ((String) linkedHashMap.get("geocode")).split(y.ٲٴݴ״ٰ(1781559176));
                double parseDouble = Double.parseDouble(split[0]);
                double parseDouble2 = Double.parseDouble(split[1]);
                String str2 = split[2];
                Unit[] values = Unit.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        d = 0.0d;
                        unit = null;
                        break;
                    }
                    unit = values[i];
                    if (str2.endsWith(unit.name())) {
                        d = Double.parseDouble(str2.substring(0, str2.length() - 2));
                        break;
                    }
                    i++;
                }
                if (unit == null) {
                    throw new IllegalArgumentException(y.دײܮڳܯ(2051172325) + str2);
                }
                query.setGeoCode(new GeoLocation(parseDouble, parseDouble2), d, unit);
            }
            if (linkedHashMap.containsKey("result_type")) {
                query.setResultType(ResultType.valueOf((String) linkedHashMap.get("result_type")));
            }
        }
        return query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getQuery() {
        return this.query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setQuery(String str) {
        this.query = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query query(String str) {
        setQuery(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLang() {
        return this.lang;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLang(String str) {
        this.lang = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query lang(String str) {
        setLang(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLocale() {
        return this.locale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLocale(String str) {
        this.locale = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query locale(String str) {
        setLocale(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMaxId() {
        return this.maxId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxId(long j) {
        this.maxId = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query maxId(long j) {
        setMaxId(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCount() {
        return this.count;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCount(int i) {
        this.count = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query count(int i) {
        setCount(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSince() {
        return this.since;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSince(String str) {
        this.since = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query since(String str) {
        setSince(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSinceId() {
        return this.sinceId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSinceId(long j) {
        this.sinceId = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query sinceId(long j) {
        setSinceId(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getGeocode() {
        return this.geocode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGeoCode(GeoLocation geoLocation, double d, Unit unit) {
        StringBuilder append = new StringBuilder().append(geoLocation.getLatitude());
        String str = y.ٲٴݴ״ٰ(1781559176);
        this.geocode = append.append(str).append(geoLocation.getLongitude()).append(str).append(d).append(unit.name()).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGeoCode(GeoLocation geoLocation, double d, String str) {
        StringBuilder append = new StringBuilder().append(geoLocation.getLatitude());
        String str2 = y.ٲٴݴ״ٰ(1781559176);
        this.geocode = append.append(str2).append(geoLocation.getLongitude()).append(str2).append(d).append(str).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query geoCode(GeoLocation geoLocation, double d, Unit unit) {
        setGeoCode(geoLocation, d, unit);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query geoCode(GeoLocation geoLocation, double d, String str) {
        setGeoCode(geoLocation, d, str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUntil() {
        return this.until;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUntil(String str) {
        this.until = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query until(String str) {
        setUntil(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResultType getResultType() {
        return this.resultType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Query resultType(ResultType resultType) {
        setResultType(resultType);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList(12);
        appendParameter(y.ٴسسݬߨ(1393256146), this.query, arrayList);
        appendParameter(y.٬ݯح׭٩(576655054), this.lang, arrayList);
        appendParameter(y.ۮڭڭܬި(862916499), this.locale, arrayList);
        appendParameter(y.֬ڱܱײٮ(-1158986751), this.maxId, arrayList);
        appendParameter(y.٬ݯح׭٩(575838374), this.count, arrayList);
        appendParameter(y.٬ݯح׭٩(576234198), this.since, arrayList);
        appendParameter(y.دײܮڳܯ(2051152541), this.sinceId, arrayList);
        appendParameter(y.ݬֲ֮ܲت(1512197255), this.geocode, arrayList);
        appendParameter(y.֬ڱܱײٮ(-1158989223), this.until, arrayList);
        if (this.resultType != null) {
            arrayList.add(new HttpParameter(y.֬ڱܱײٮ(-1158989151), this.resultType.name()));
        }
        arrayList.add(WITH_TWITTER_USER_ID);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, long j, List<HttpParameter> list) {
        if (0 <= j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String nextPage() {
        return this.nextPageQuery;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Query query = (Query) obj;
        if (this.maxId != query.maxId || this.count != query.count || this.sinceId != query.sinceId) {
            return false;
        }
        String str = this.geocode;
        if (str == null ? query.geocode != null : !str.equals(query.geocode)) {
            return false;
        }
        String str2 = this.lang;
        if (str2 == null ? query.lang != null : !str2.equals(query.lang)) {
            return false;
        }
        String str3 = this.locale;
        if (str3 == null ? query.locale != null : !str3.equals(query.locale)) {
            return false;
        }
        String str4 = this.nextPageQuery;
        if (str4 == null ? query.nextPageQuery != null : !str4.equals(query.nextPageQuery)) {
            return false;
        }
        String str5 = this.query;
        if (str5 == null ? query.query != null : !str5.equals(query.query)) {
            return false;
        }
        ResultType resultType = this.resultType;
        if (resultType == null ? query.resultType != null : !resultType.equals(query.resultType)) {
            return false;
        }
        String str6 = this.since;
        if (str6 == null ? query.since != null : !str6.equals(query.since)) {
            return false;
        }
        String str7 = this.until;
        String str8 = query.until;
        return str7 == null ? str8 == null : str7.equals(str8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.query;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lang;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.locale;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j = this.maxId;
        int i = (((hashCode3 + ((int) (j ^ (j >>> 32)))) * 31) + this.count) * 31;
        String str4 = this.since;
        int hashCode4 = (i + (str4 != null ? str4.hashCode() : 0)) * 31;
        long j2 = this.sinceId;
        int i2 = (hashCode4 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str5 = this.geocode;
        int hashCode5 = (i2 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.until;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ResultType resultType = this.resultType;
        int hashCode7 = (hashCode6 + (resultType != null ? resultType.hashCode() : 0)) * 31;
        String str7 = this.nextPageQuery;
        return hashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051170933) + this.query + y.٬ݯح׭٩(576234574) + this.lang + y.ۮڭڭܬި(862915043) + this.locale + y.دײܮڳܯ(2051171149) + this.maxId + y.ݮڮֲڭܩ(-628153404) + this.count + y.ٴسسݬߨ(1393254858) + this.since + y.ٲٴݴ״ٰ(1782480632) + this.sinceId + y.֬ڱܱײٮ(-1158987927) + this.geocode + y.ٲٴݴ״ٰ(1782480296) + this.until + y.ٲٴݴ״ٰ(1782479880) + this.resultType + y.٬ݯح׭٩(576235414) + this.nextPageQuery + y.ݮڮֲڭܩ(-628973388);
    }
}
