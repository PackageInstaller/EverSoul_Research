package twitter4j;

import com.liapp.y;
import com.singular.sdk.internal.Constants;
import java.util.HashMap;
import java.util.Map;
import twitter4j.MediaEntity;

/* loaded from: classes4.dex */
public class MediaEntityJSONImpl extends EntityIndex implements MediaEntity {
    private static final long serialVersionUID = 1571961225214439778L;
    private String displayURL;
    private String expandedURL;
    private String extAltText;

    /* renamed from: id */
    protected long f1566id;
    private String mediaURL;
    private String mediaURLHttps;
    private Map<Integer, MediaEntity.Size> sizes;
    protected String type;
    protected String url;
    private int videoAspectRatioHeight;
    private int videoAspectRatioWidth;
    private long videoDurationMillis;
    private Variant[] videoVariants;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntityIndex
    public /* bridge */ /* synthetic */ int compareTo(EntityIndex entityIndex) {
        return super.compareTo(entityIndex);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MediaEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        String str = y.ٴسسݬߨ(1393233162);
        String str2 = y.ۮڭڭܬި(862938347);
        String str3 = y.٬ݯح׭٩(576244350);
        String str4 = y.ٲٴݴ״ٰ(1781623144);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            this.f1566id = ParseUtil.getLong("id", jSONObject);
            this.url = jSONObject.getString("url");
            this.expandedURL = jSONObject.getString("expanded_url");
            this.mediaURL = jSONObject.getString("media_url");
            this.mediaURLHttps = jSONObject.getString("media_url_https");
            this.displayURL = jSONObject.getString("display_url");
            JSONObject jSONObject2 = jSONObject.getJSONObject("sizes");
            HashMap hashMap = new HashMap(4);
            this.sizes = hashMap;
            addMediaEntitySizeIfNotNull(hashMap, jSONObject2, MediaEntity.Size.LARGE, Constants.LARGE);
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.MEDIUM, "medium");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.SMALL, Constants.SMALL);
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.THUMB, "thumb");
            if (!jSONObject.isNull(str4)) {
                this.type = jSONObject.getString(str4);
            }
            if (jSONObject.has(str3)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(str3);
                JSONArray jSONArray2 = jSONObject3.getJSONArray("aspect_ratio");
                this.videoAspectRatioWidth = jSONArray2.getInt(0);
                this.videoAspectRatioHeight = jSONArray2.getInt(1);
                if (!jSONObject3.isNull(str)) {
                    this.videoDurationMillis = jSONObject3.getLong(str);
                }
                JSONArray jSONArray3 = jSONObject3.getJSONArray("variants");
                this.videoVariants = new Variant[jSONArray3.length()];
                for (int i = 0; i < jSONArray3.length(); i++) {
                    this.videoVariants[i] = new Variant(jSONArray3.getJSONObject(i));
                }
            } else {
                this.videoVariants = new Variant[0];
            }
            if (jSONObject.has(str2)) {
                this.extAltText = jSONObject.getString(str2);
            }
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addMediaEntitySizeIfNotNull(Map<Integer, MediaEntity.Size> map, JSONObject jSONObject, Integer num, String str) throws JSONException {
        if (jSONObject.isNull(str)) {
            return;
        }
        map.put(num, new Size(jSONObject.getJSONObject(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MediaEntityJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public long getId() {
        return this.f1566id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public String getMediaURL() {
        return this.mediaURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public String getMediaURLHttps() {
        return this.mediaURLHttps;
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
    public String getDisplayURL() {
        return this.displayURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.URLEntity
    public String getExpandedURL() {
        return this.expandedURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public Map<Integer, MediaEntity.Size> getSizes() {
        return this.sizes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public String getType() {
        return this.type;
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

    static class Size implements MediaEntity.Size {
        private static final long serialVersionUID = -2515842281909325169L;
        int height;
        int resize;
        int width;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Size() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Size(JSONObject jSONObject) throws JSONException {
            this.width = jSONObject.getInt(y.ݬֲ֮ܲت(1512184431));
            this.height = jSONObject.getInt(y.ٲٴݴ״ٰ(1782459672));
            this.resize = y.ٲٴݴ״ٰ(1782459760).equals(jSONObject.getString(y.دײܮڳܯ(2051158101))) ? 100 : 101;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.MediaEntity.Size
        public int getWidth() {
            return this.width;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.MediaEntity.Size
        public int getHeight() {
            return this.height;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.MediaEntity.Size
        public int getResize() {
            return this.resize;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.height == size.height && this.resize == size.resize && this.width == size.width;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return (((this.width * 31) + this.height) * 31) + this.resize;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.֬ڱܱײٮ(-1158975567) + this.width + y.ۮڭڭܬި(862104747) + this.height + y.٬ݯح׭٩(576255686) + this.resize + '}';
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public int getVideoAspectRatioWidth() {
        return this.videoAspectRatioWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public int getVideoAspectRatioHeight() {
        return this.videoAspectRatioHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public long getVideoDurationMillis() {
        return this.videoDurationMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public String getExtAltText() {
        return this.extAltText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.MediaEntity
    public MediaEntity.Variant[] getVideoVariants() {
        return this.videoVariants;
    }

    static class Variant implements MediaEntity.Variant {
        private static final long serialVersionUID = 1027236588556797980L;
        int bitrate;
        String contentType;
        String url;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Variant(JSONObject jSONObject) throws JSONException {
            String str = y.٬ݯح׭٩(576255870);
            this.bitrate = jSONObject.has(str) ? jSONObject.getInt(str) : 0;
            this.contentType = jSONObject.getString(y.ݮڮֲڭܩ(-628160572));
            this.url = jSONObject.getString(y.ݬֲ֮ܲت(1512934047));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Variant() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.MediaEntity.Variant
        public int getBitrate() {
            return this.bitrate;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.MediaEntity.Variant
        public String getContentType() {
            return this.contentType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.MediaEntity.Variant
        public String getUrl() {
            return this.url;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Variant)) {
                return false;
            }
            Variant variant = (Variant) obj;
            return this.bitrate == variant.bitrate && this.contentType.equals(variant.contentType) && this.url.equals(variant.url);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            int i = this.bitrate * 31;
            String str = this.contentType;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.url;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.ٲٴݴ״ٰ(1782453008) + this.bitrate + y.ݬֲ֮ܲت(1512187663) + this.contentType + y.دײܮڳܯ(2051149669) + this.url + '}';
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MediaEntityJSONImpl) && this.f1566id == ((MediaEntityJSONImpl) obj).f1566id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.f1566id;
        return (int) (j ^ (j >>> 32));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576244382) + this.f1566id + y.ٲٴݴ״ٰ(1782508648) + this.url + y.ݬֲ֮ܲت(1512187119) + this.mediaURL + y.ۮڭڭܬި(862938843) + this.mediaURLHttps + y.ۮڭڭܬި(862937531) + this.expandedURL + y.֬ڱܱײٮ(-1158982623) + this.displayURL + y.ݮڮֲڭܩ(-628146700) + this.sizes + y.ݬֲ֮ܲت(1512186471) + this.type + y.ٲٴݴ״ٰ(1782453592) + this.videoAspectRatioWidth + y.ۮڭڭܬި(862937619) + this.videoAspectRatioHeight + y.ٲٴݴ״ٰ(1782453480) + this.videoDurationMillis + y.٬ݯح׭٩(576241806) + this.videoVariants.length + y.ۮڭڭܬި(862940283) + this.extAltText + y.ݮڮֲڭܩ(-628973388);
    }
}
