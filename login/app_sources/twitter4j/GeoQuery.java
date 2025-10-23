package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class GeoQuery implements Serializable {
    private static final long serialVersionUID = 5434503339001056634L;
    private String accuracy;
    private String granularity;

    /* renamed from: ip */
    private String f1562ip;
    private GeoLocation location;
    private int maxResults;
    private String query;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoQuery(GeoLocation geoLocation) {
        this.query = null;
        this.f1562ip = null;
        this.accuracy = null;
        this.granularity = null;
        this.maxResults = -1;
        this.location = geoLocation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoQuery(String str) {
        this.query = null;
        this.accuracy = null;
        this.granularity = null;
        this.maxResults = -1;
        this.f1562ip = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoQuery(String str, String str2, GeoLocation geoLocation) {
        this.accuracy = null;
        this.granularity = null;
        this.maxResults = -1;
        this.query = str;
        this.f1562ip = str2;
        this.location = geoLocation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoLocation getLocation() {
        return this.location;
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
    public String getIp() {
        return this.f1562ip;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAccuracy() {
        return this.accuracy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAccuracy(String str) {
        this.accuracy = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoQuery accuracy(String str) {
        setAccuracy(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getGranularity() {
        return this.granularity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGranularity(String str) {
        this.granularity = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoQuery granularity(String str) {
        setGranularity(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxResults() {
        return this.maxResults;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxResults(int i) {
        this.maxResults = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoQuery maxResults(int i) {
        setMaxResults(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        GeoLocation geoLocation = this.location;
        if (geoLocation != null) {
            appendParameter(y.֬ڱܱײٮ(-1158941183), geoLocation.getLatitude(), arrayList);
            appendParameter(y.֬ڱܱײٮ(-1159246383), this.location.getLongitude(), arrayList);
        }
        String str = this.f1562ip;
        if (str != null) {
            appendParameter(y.֬ڱܱײٮ(-1158941095), str, arrayList);
        }
        appendParameter(y.ٲٴݴ״ٰ(1782494352), this.accuracy, arrayList);
        appendParameter(y.ݮڮֲڭܩ(-628121724), this.query, arrayList);
        appendParameter(y.ٴسسݬߨ(1393271890), this.granularity, arrayList);
        appendParameter(y.دײܮڳܯ(2051188229), this.maxResults, (List<HttpParameter>) arrayList);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, int i, List<HttpParameter> list) {
        if (i > 0) {
            list.add(new HttpParameter(str, String.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, double d, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeoQuery geoQuery = (GeoQuery) obj;
        if (this.maxResults != geoQuery.maxResults) {
            return false;
        }
        String str = this.accuracy;
        if (str == null ? geoQuery.accuracy != null : !str.equals(geoQuery.accuracy)) {
            return false;
        }
        String str2 = this.granularity;
        if (str2 == null ? geoQuery.granularity != null : !str2.equals(geoQuery.granularity)) {
            return false;
        }
        String str3 = this.f1562ip;
        if (str3 == null ? geoQuery.f1562ip != null : !str3.equals(geoQuery.f1562ip)) {
            return false;
        }
        GeoLocation geoLocation = this.location;
        GeoLocation geoLocation2 = geoQuery.location;
        return geoLocation == null ? geoLocation2 == null : geoLocation.equals(geoLocation2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        GeoLocation geoLocation = this.location;
        int hashCode = (geoLocation != null ? geoLocation.hashCode() : 0) * 31;
        String str = this.f1562ip;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accuracy;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.granularity;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.maxResults;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051188397) + this.location + y.٬ݯح׭٩(576217422) + this.query + y.ݮڮֲڭܩ(-628125308) + this.f1562ip + y.ٲٴݴ״ٰ(1782495496) + this.accuracy + y.٬ݯح׭٩(576217766) + this.granularity + y.ٲٴݴ״ٰ(1782495280) + this.maxResults + '}';
    }
}
