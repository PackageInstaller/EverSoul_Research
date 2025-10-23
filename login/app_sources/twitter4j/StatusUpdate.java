package twitter4j;

import com.liapp.y;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class StatusUpdate implements Serializable {
    private static final long serialVersionUID = 7422094739799350035L;
    private boolean autoPopulateReplyMetadata;
    private transient InputStream mediaBody;
    private File mediaFile;
    private long[] mediaIds;
    private String mediaName;
    private boolean possiblySensitive;
    private final String status;
    private long inReplyToStatusId = -1;
    private GeoLocation location = null;
    private String placeId = null;
    private boolean displayCoordinates = true;
    private String attachmentUrl = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate(String str) {
        this.status = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getStatus() {
        return this.status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInReplyToStatusId(long j) {
        this.inReplyToStatusId = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate inReplyToStatusId(long j) {
        setInReplyToStatusId(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoLocation getLocation() {
        return this.location;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLocation(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate location(GeoLocation geoLocation) {
        setLocation(geoLocation);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPlaceId() {
        return this.placeId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPlaceId(String str) {
        this.placeId = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate placeId(String str) {
        setPlaceId(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDisplayCoordinates() {
        return this.displayCoordinates;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDisplayCoordinates(boolean z) {
        this.displayCoordinates = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate displayCoordinates(boolean z) {
        setDisplayCoordinates(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMedia(File file) {
        this.mediaFile = file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate media(File file) {
        setMedia(file);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMedia(String str, InputStream inputStream) {
        this.mediaName = str;
        this.mediaBody = inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMediaIds(long... jArr) {
        this.mediaIds = jArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAttachmentUrl() {
        return this.attachmentUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAttachmentUrl(String str) {
        this.attachmentUrl = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate attachmentUrl(String str) {
        setAttachmentUrl(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isForUpdateWithMedia() {
        return (this.mediaFile == null && this.mediaName == null) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate media(String str, InputStream inputStream) {
        setMedia(str, inputStream);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPossiblySensitive(boolean z) {
        this.possiblySensitive = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate possiblySensitive(boolean z) {
        setPossiblySensitive(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPossiblySensitive() {
        return this.possiblySensitive;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAutoPopulateReplyMetadata() {
        return this.autoPopulateReplyMetadata;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAutoPopulateReplyMetadata(boolean z) {
        this.autoPopulateReplyMetadata = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusUpdate autoPopulateReplyMetadata(boolean z) {
        setAutoPopulateReplyMetadata(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        appendParameter(y.ݮڮֲڭܩ(-628237012), this.status, arrayList);
        long j = this.inReplyToStatusId;
        if (-1 != j) {
            appendParameter(y.֬ڱܱײٮ(-1158996119), j, (List<HttpParameter>) arrayList);
        }
        GeoLocation geoLocation = this.location;
        if (geoLocation != null) {
            appendParameter(y.֬ڱܱײٮ(-1158941183), geoLocation.getLatitude(), arrayList);
            appendParameter(y.֬ڱܱײٮ(-1159246383), this.location.getLongitude(), arrayList);
        }
        appendParameter(y.دײܮڳܯ(2051166509), this.placeId, arrayList);
        if (!this.displayCoordinates) {
            appendParameter(y.ٲٴݴ״ٰ(1782467768), y.ٲٴݴ״ٰ(1781635312), arrayList);
        }
        File file = this.mediaFile;
        String str = y.ݬֲ֮ܲت(1512207807);
        String str2 = y.دײܮڳܯ(2052959781);
        if (file != null) {
            arrayList.add(new HttpParameter(str2, this.mediaFile));
            arrayList.add(new HttpParameter(str, this.possiblySensitive));
        } else if (this.mediaName != null && this.mediaBody != null) {
            arrayList.add(new HttpParameter(str2, this.mediaName, this.mediaBody));
            arrayList.add(new HttpParameter(str, this.possiblySensitive));
        } else {
            long[] jArr = this.mediaIds;
            if (jArr != null && jArr.length >= 1) {
                arrayList.add(new HttpParameter(y.ٴسسݬߨ(1393863874), StringUtil.join(this.mediaIds)));
            }
        }
        if (this.autoPopulateReplyMetadata) {
            appendParameter(y.֬ڱܱײٮ(-1158352439), y.دײܮڳܯ(2051939573), arrayList);
        }
        appendParameter(y.֬ڱܱײٮ(-1158352679), this.attachmentUrl, arrayList);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, double d, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendParameter(String str, long j, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusUpdate statusUpdate = (StatusUpdate) obj;
        if (this.inReplyToStatusId != statusUpdate.inReplyToStatusId || this.displayCoordinates != statusUpdate.displayCoordinates || this.possiblySensitive != statusUpdate.possiblySensitive || this.autoPopulateReplyMetadata != statusUpdate.autoPopulateReplyMetadata) {
            return false;
        }
        String str = this.status;
        if (str == null ? statusUpdate.status != null : !str.equals(statusUpdate.status)) {
            return false;
        }
        GeoLocation geoLocation = this.location;
        if (geoLocation == null ? statusUpdate.location != null : !geoLocation.equals(statusUpdate.location)) {
            return false;
        }
        String str2 = this.placeId;
        if (str2 == null ? statusUpdate.placeId != null : !str2.equals(statusUpdate.placeId)) {
            return false;
        }
        String str3 = this.mediaName;
        if (str3 == null ? statusUpdate.mediaName != null : !str3.equals(statusUpdate.mediaName)) {
            return false;
        }
        InputStream inputStream = this.mediaBody;
        if (inputStream == null ? statusUpdate.mediaBody != null : !inputStream.equals(statusUpdate.mediaBody)) {
            return false;
        }
        File file = this.mediaFile;
        if (file == null ? statusUpdate.mediaFile != null : !file.equals(statusUpdate.mediaFile)) {
            return false;
        }
        if (!Arrays.equals(this.mediaIds, statusUpdate.mediaIds)) {
            return false;
        }
        String str4 = this.attachmentUrl;
        String str5 = statusUpdate.attachmentUrl;
        return str4 != null ? str4.equals(str5) : str5 == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.status;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.inReplyToStatusId;
        int i = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        GeoLocation geoLocation = this.location;
        int hashCode2 = (i + (geoLocation != null ? geoLocation.hashCode() : 0)) * 31;
        String str2 = this.placeId;
        int hashCode3 = (((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.displayCoordinates ? 1 : 0)) * 31) + (this.possiblySensitive ? 1 : 0)) * 31;
        String str3 = this.mediaName;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        InputStream inputStream = this.mediaBody;
        int hashCode5 = (hashCode4 + (inputStream != null ? inputStream.hashCode() : 0)) * 31;
        File file = this.mediaFile;
        int hashCode6 = (((((hashCode5 + (file != null ? file.hashCode() : 0)) * 31) + Arrays.hashCode(this.mediaIds)) * 31) + (this.autoPopulateReplyMetadata ? 1 : 0)) * 31;
        String str4 = this.attachmentUrl;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1780593008) + this.status + y.ۮڭڭܬި(863028779) + this.inReplyToStatusId + y.ٲٴݴ״ٰ(1780592832) + this.location + y.٬ݯح׭٩(575106062) + this.placeId + y.ݬֲ֮ܲت(1513980735) + this.displayCoordinates + y.ٴسسݬߨ(1393862970) + this.possiblySensitive + y.ݮڮֲڭܩ(-628056508) + this.mediaName + y.ݮڮֲڭܩ(-628056356) + this.mediaBody + y.دײܮڳܯ(2052958581) + this.mediaFile + y.ۮڭڭܬި(863027779) + Arrays.toString(this.mediaIds) + y.ݮڮֲڭܩ(-628056180) + this.autoPopulateReplyMetadata + y.دײܮڳܯ(2052957885) + this.attachmentUrl + y.ݮڮֲڭܩ(-628973388);
    }
}
