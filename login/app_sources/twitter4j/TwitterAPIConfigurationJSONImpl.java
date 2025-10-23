package twitter4j;

import com.liapp.y;
import com.singular.sdk.internal.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import twitter4j.MediaEntity;
import twitter4j.MediaEntityJSONImpl;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl implements TwitterAPIConfiguration {
    private static final long serialVersionUID = -3588904550808591686L;
    private int charactersReservedPerMedia;
    private int dmTextCharacterLimit;
    private int maxMediaPerUpload;
    private String[] nonUsernamePaths;
    private int photoSizeLimit;
    private Map<Integer, MediaEntity.Size> photoSizes;
    private int shortURLLength;
    private int shortURLLengthHttps;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TwitterAPIConfigurationJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject jSONObject;
        String str = y.ݬֲ֮ܲت(1513982639);
        try {
            JSONObject asJSONObject = httpResponse.asJSONObject();
            this.photoSizeLimit = ParseUtil.getInt("photo_size_limit", asJSONObject);
            this.shortURLLength = ParseUtil.getInt("short_url_length", asJSONObject);
            this.shortURLLengthHttps = ParseUtil.getInt("short_url_length_https", asJSONObject);
            this.charactersReservedPerMedia = ParseUtil.getInt("characters_reserved_per_media", asJSONObject);
            this.dmTextCharacterLimit = ParseUtil.getInt("dm_text_character_limit", asJSONObject);
            JSONObject jSONObject2 = asJSONObject.getJSONObject("photo_sizes");
            HashMap hashMap = new HashMap(4);
            this.photoSizes = hashMap;
            hashMap.put(MediaEntity.Size.LARGE, new MediaEntityJSONImpl.Size(jSONObject2.getJSONObject(Constants.LARGE)));
            if (jSONObject2.isNull(str)) {
                jSONObject = jSONObject2.getJSONObject("medium");
            } else {
                jSONObject = jSONObject2.getJSONObject(str);
            }
            this.photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(jSONObject));
            this.photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(jSONObject2.getJSONObject(Constants.SMALL)));
            this.photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(jSONObject2.getJSONObject("thumb")));
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
            }
            JSONArray jSONArray = asJSONObject.getJSONArray("non_username_paths");
            this.nonUsernamePaths = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nonUsernamePaths[i] = jSONArray.getString(i);
            }
            this.maxMediaPerUpload = ParseUtil.getInt("max_media_per_upload", asJSONObject);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public int getPhotoSizeLimit() {
        return this.photoSizeLimit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public int getShortURLLength() {
        return this.shortURLLength;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public int getShortURLLengthHttps() {
        return this.shortURLLengthHttps;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public int getCharactersReservedPerMedia() {
        return this.charactersReservedPerMedia;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public int getDmTextCharacterLimit() {
        return this.dmTextCharacterLimit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public Map<Integer, MediaEntity.Size> getPhotoSizes() {
        return this.photoSizes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public String[] getNonUsernamePaths() {
        return this.nonUsernamePaths;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterAPIConfiguration
    public int getMaxMediaPerUpload() {
        return this.maxMediaPerUpload;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterAPIConfigurationJSONImpl)) {
            return false;
        }
        TwitterAPIConfigurationJSONImpl twitterAPIConfigurationJSONImpl = (TwitterAPIConfigurationJSONImpl) obj;
        if (this.charactersReservedPerMedia != twitterAPIConfigurationJSONImpl.charactersReservedPerMedia || this.dmTextCharacterLimit != twitterAPIConfigurationJSONImpl.dmTextCharacterLimit || this.maxMediaPerUpload != twitterAPIConfigurationJSONImpl.maxMediaPerUpload || this.photoSizeLimit != twitterAPIConfigurationJSONImpl.photoSizeLimit || this.shortURLLength != twitterAPIConfigurationJSONImpl.shortURLLength || this.shortURLLengthHttps != twitterAPIConfigurationJSONImpl.shortURLLengthHttps || !Arrays.equals(this.nonUsernamePaths, twitterAPIConfigurationJSONImpl.nonUsernamePaths)) {
            return false;
        }
        Map<Integer, MediaEntity.Size> map = this.photoSizes;
        Map<Integer, MediaEntity.Size> map2 = twitterAPIConfigurationJSONImpl.photoSizes;
        return map == null ? map2 == null : map.equals(map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int i = ((((((((this.photoSizeLimit * 31) + this.shortURLLength) * 31) + this.shortURLLengthHttps) * 31) + this.charactersReservedPerMedia) * 32) + this.dmTextCharacterLimit) * 31;
        Map<Integer, MediaEntity.Size> map = this.photoSizes;
        int hashCode = (i + (map != null ? map.hashCode() : 0)) * 31;
        String[] strArr = this.nonUsernamePaths;
        return ((hashCode + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31) + this.maxMediaPerUpload;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.ݮڮֲڭܩ(-628058868)).append(this.photoSizeLimit).append(y.٬ݯح׭٩(575104726)).append(this.shortURLLength).append(y.دײܮڳܯ(2052956429)).append(this.shortURLLengthHttps).append(y.֬ڱܱײٮ(-1158356735)).append(this.charactersReservedPerMedia).append(y.ۮڭڭܬި(863032323)).append(this.dmTextCharacterLimit).append(y.دײܮڳܯ(2052964237)).append(this.photoSizes).append(y.٬ݯح׭٩(575109702));
        String[] strArr = this.nonUsernamePaths;
        return append.append(strArr == null ? null : Arrays.asList(strArr)).append(y.دײܮڳܯ(2052963693)).append(this.maxMediaPerUpload).append('}').toString();
    }
}
