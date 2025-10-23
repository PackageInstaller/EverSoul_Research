package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
final class URLEntityJSONImpl extends EntityIndex implements URLEntity {
    private static final long serialVersionUID = 7333552738058031524L;
    private String displayURL;
    private String expandedURL;
    private String url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    URLEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    URLEntityJSONImpl(int i, int i2, String str, String str2, String str3) {
        setStart(i);
        setEnd(i2);
        this.url = str;
        this.expandedURL = str2;
        this.displayURL = str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    URLEntityJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ۮڭڭܬި(862992475);
        String str2 = y.٬ݯح׭٩(575116774);
        String str3 = y.ݬֲ֮ܲت(1512934047);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull(str3)) {
                this.url = jSONObject.getString(str3);
            }
            if (!jSONObject.isNull(str2)) {
                this.expandedURL = jSONObject.getString(str2);
            } else {
                this.expandedURL = this.url;
            }
            if (!jSONObject.isNull(str)) {
                this.displayURL = jSONObject.getString(str);
            } else {
                this.displayURL = this.url;
            }
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.URLEntity, twitter4j.TweetEntity
    public String getText() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.URLEntity
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.URLEntity
    public String getExpandedURL() {
        return this.expandedURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.URLEntity
    public String getDisplayURL() {
        return this.displayURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntityIndex, twitter4j.HashtagEntity, twitter4j.TweetEntity
    public int getStart() {
        return super.getStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntityIndex, twitter4j.HashtagEntity, twitter4j.TweetEntity
    public int getEnd() {
        return super.getEnd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        URLEntityJSONImpl uRLEntityJSONImpl = (URLEntityJSONImpl) obj;
        String str = this.displayURL;
        if (str == null ? uRLEntityJSONImpl.displayURL != null : !str.equals(uRLEntityJSONImpl.displayURL)) {
            return false;
        }
        String str2 = this.expandedURL;
        if (str2 == null ? uRLEntityJSONImpl.expandedURL != null : !str2.equals(uRLEntityJSONImpl.expandedURL)) {
            return false;
        }
        String str3 = this.url;
        String str4 = uRLEntityJSONImpl.url;
        return str3 == null ? str4 == null : str3.equals(str4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expandedURL;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayURL;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݬֲ֮ܲت(1513978335) + this.url + y.ۮڭڭܬި(862937531) + this.expandedURL + y.֬ڱܱײٮ(-1158982623) + this.displayURL + y.ݮڮֲڭܩ(-628973388);
    }
}
