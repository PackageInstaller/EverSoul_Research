package twitter4j;

import com.liapp.y;
import java.io.Serializable;

/* loaded from: classes4.dex */
public final class UploadedMedia implements Serializable {
    private static final long serialVersionUID = 5393092535610604718L;
    private int imageHeight;
    private String imageType;
    private int imageWidth;
    private long mediaId;
    private int processingCheckAfterSecs;
    private String processingState;
    private int progressPercent;
    private long size;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UploadedMedia(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getImageWidth() {
        return this.imageWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getImageHeight() {
        return this.imageHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getImageType() {
        return this.imageType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMediaId() {
        return this.mediaId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSize() {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getProcessingState() {
        return this.processingState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getProcessingCheckAfterSecs() {
        return this.processingCheckAfterSecs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getProgressPercent() {
        return this.progressPercent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ٲٴݴ״ٰ(1780567064);
        String str2 = y.֬ڱܱײٮ(-1159562919);
        this.mediaId = ParseUtil.getLong(y.ݮڮֲڭܩ(-628092044), jSONObject);
        this.size = ParseUtil.getLong(y.ݮڮֲڭܩ(-628200668), jSONObject);
        try {
            if (!jSONObject.isNull(str2)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                this.imageWidth = ParseUtil.getInt("w", jSONObject2);
                this.imageHeight = ParseUtil.getInt("h", jSONObject2);
                this.imageType = ParseUtil.getUnescapedString("image_type", jSONObject2);
            }
            if (jSONObject.isNull(str)) {
                return;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject(str);
            this.processingState = ParseUtil.getUnescapedString("state", jSONObject3);
            this.processingCheckAfterSecs = ParseUtil.getInt("check_after_secs", jSONObject3);
            this.progressPercent = ParseUtil.getInt("progress_percent", jSONObject3);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UploadedMedia uploadedMedia = (UploadedMedia) obj;
        return this.imageWidth == uploadedMedia.imageWidth && this.imageHeight == uploadedMedia.imageHeight && this.imageType == uploadedMedia.imageType && this.mediaId == uploadedMedia.mediaId && this.size == uploadedMedia.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.mediaId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31;
        String str = this.imageType;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.size;
        return ((i + hashCode) * 31) + ((int) ((j2 >>> 32) ^ j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1158410583) + this.mediaId + y.ݮڮֲڭܩ(-627992572) + this.imageWidth + y.ٲٴݴ״ٰ(1780528088) + this.imageHeight + y.دײܮڳܯ(2052894525) + this.imageType + y.دײܮڳܯ(2051234485) + this.size + '}';
    }
}
