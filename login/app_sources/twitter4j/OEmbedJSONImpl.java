package twitter4j;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.liapp.y;
import java.io.Serializable;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
public class OEmbedJSONImpl extends TwitterResponseImpl implements OEmbed, Serializable {
    private static final long serialVersionUID = -2207801480251709819L;
    private String authorName;
    private String authorURL;
    private long cacheAge;
    private String html;
    private String url;
    private String version;
    private int width;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponseImpl, twitter4j.TwitterResponse
    public /* bridge */ /* synthetic */ int getAccessLevel() {
        return super.getAccessLevel();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponseImpl, twitter4j.TwitterResponse
    public /* bridge */ /* synthetic */ RateLimitStatus getRateLimitStatus() {
        return super.getRateLimitStatus();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OEmbedJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OEmbedJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.html = jSONObject.getString("html");
            this.authorName = jSONObject.getString("author_name");
            this.url = jSONObject.getString("url");
            this.version = jSONObject.getString("version");
            this.cacheAge = jSONObject.getLong("cache_age");
            this.authorURL = jSONObject.getString("author_url");
            this.width = jSONObject.getInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public String getHtml() {
        return this.html;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public String getAuthorName() {
        return this.authorName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public String getVersion() {
        return this.version;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public long getCacheAge() {
        return this.cacheAge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public String getAuthorURL() {
        return this.authorURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.OEmbed
    public int getWidth() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OEmbedJSONImpl oEmbedJSONImpl = (OEmbedJSONImpl) obj;
        if (this.cacheAge != oEmbedJSONImpl.cacheAge || this.width != oEmbedJSONImpl.width) {
            return false;
        }
        String str = this.authorName;
        if (str == null ? oEmbedJSONImpl.authorName != null : !str.equals(oEmbedJSONImpl.authorName)) {
            return false;
        }
        String str2 = this.authorURL;
        if (str2 == null ? oEmbedJSONImpl.authorURL != null : !str2.equals(oEmbedJSONImpl.authorURL)) {
            return false;
        }
        String str3 = this.html;
        if (str3 == null ? oEmbedJSONImpl.html != null : !str3.equals(oEmbedJSONImpl.html)) {
            return false;
        }
        String str4 = this.url;
        if (str4 == null ? oEmbedJSONImpl.url != null : !str4.equals(oEmbedJSONImpl.url)) {
            return false;
        }
        String str5 = this.version;
        String str6 = oEmbedJSONImpl.version;
        return str5 == null ? str6 == null : str5.equals(str6);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.html;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.authorName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.version;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        long j = this.cacheAge;
        int i = (hashCode4 + ((int) (j ^ (j >>> 32)))) * 31;
        String str5 = this.authorURL;
        return ((i + (str5 != null ? str5.hashCode() : 0)) * 31) + this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ۮڭڭܬި(862940411) + this.html + y.ٴسسݬߨ(1393231578) + this.authorName + y.ۮڭڭܬި(862934675) + this.url + y.ٴسسݬߨ(1393231698) + this.version + y.ٲٴݴ״ٰ(1782454376) + this.cacheAge + y.٬ݯح׭٩(576242654) + this.authorURL + y.֬ڱܱײٮ(-1158980263) + this.width + '}';
    }
}
