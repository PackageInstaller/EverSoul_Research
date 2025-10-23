package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
final class QuotedStatusPermalinkJSONImpl extends EntityIndex implements URLEntity {
    private static final long serialVersionUID = -9029983811168784541L;
    private String displayURL;
    private String expandedURL;
    private String url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    QuotedStatusPermalinkJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    QuotedStatusPermalinkJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.٬ݯح׭٩(576240494);
        String str2 = y.ٲٴݴ״ٰ(1782472880);
        String str3 = y.ݬֲ֮ܲت(1512934047);
        try {
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
        QuotedStatusPermalinkJSONImpl quotedStatusPermalinkJSONImpl = (QuotedStatusPermalinkJSONImpl) obj;
        String str = this.url;
        if (str == null ? quotedStatusPermalinkJSONImpl.url != null : !str.equals(quotedStatusPermalinkJSONImpl.url)) {
            return false;
        }
        String str2 = this.expandedURL;
        if (str2 == null ? quotedStatusPermalinkJSONImpl.expandedURL != null : !str2.equals(quotedStatusPermalinkJSONImpl.expandedURL)) {
            return false;
        }
        String str3 = this.displayURL;
        String str4 = quotedStatusPermalinkJSONImpl.displayURL;
        return str3 != null ? str3.equals(str4) : str4 == null;
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
        return y.دײܮڳܯ(2051177861) + this.url + y.ۮڭڭܬި(862937531) + this.expandedURL + y.֬ڱܱײٮ(-1158982623) + this.displayURL + y.ݮڮֲڭܩ(-628973388);
    }
}
