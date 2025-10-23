package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class OEmbedRequest implements Serializable {
    private static final long serialVersionUID = 7454130135274547901L;
    private String lang;
    private int maxWidth;
    private final long statusId;
    private final String url;
    private boolean hideMedia = true;
    private boolean hideThread = true;
    private boolean omitScript = false;
    private Align align = Align.NONE;
    private String[] related = new String[0];
    private WidgetType widgetType = WidgetType.NONE;
    private boolean hideTweet = false;

    public enum Align {
        LEFT,
        CENTER,
        RIGHT,
        NONE
    }

    public enum WidgetType {
        VIDEO,
        NONE
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest(long j, String str) {
        this.statusId = j;
        this.url = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest MaxWidth(int i) {
        this.maxWidth = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideMedia(boolean z) {
        this.hideMedia = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest HideMedia(boolean z) {
        this.hideMedia = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideThread(boolean z) {
        this.hideThread = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest HideThread(boolean z) {
        this.hideThread = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOmitScript(boolean z) {
        this.omitScript = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest omitScript(boolean z) {
        this.omitScript = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAlign(Align align) {
        this.align = align;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest align(Align align) {
        this.align = align;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRelated(String[] strArr) {
        this.related = strArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest related(String[] strArr) {
        this.related = strArr;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLang(String str) {
        this.lang = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest lang(String str) {
        this.lang = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setWidgetType(WidgetType widgetType) {
        this.widgetType = widgetType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest widgetType(WidgetType widgetType) {
        this.widgetType = widgetType;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideTweet(boolean z) {
        this.hideTweet = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OEmbedRequest hideTweet(boolean z) {
        this.hideTweet = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList(12);
        appendParameter(y.ٲٴݴ״ٰ(1781792816), this.statusId, arrayList);
        appendParameter(y.ݬֲ֮ܲت(1512934047), this.url, arrayList);
        appendParameter(y.֬ڱܱײٮ(-1158980447), this.maxWidth, arrayList);
        arrayList.add(new HttpParameter(y.ݬֲ֮ܲت(1512188535), this.hideMedia));
        arrayList.add(new HttpParameter(y.٬ݯح׭٩(576243326), this.hideThread));
        arrayList.add(new HttpParameter(y.֬ڱܱײٮ(-1158979703), this.omitScript));
        arrayList.add(new HttpParameter(y.ݬֲ֮ܲت(1512188039), this.align.name().toLowerCase()));
        String[] strArr = this.related;
        if (strArr.length > 0) {
            appendParameter(y.ݮڮֲڭܩ(-628148476), StringUtil.join(strArr), arrayList);
        }
        appendParameter(y.٬ݯح׭٩(576655054), this.lang, arrayList);
        if (this.widgetType != WidgetType.NONE) {
            arrayList.add(new HttpParameter(y.ۮڭڭܬި(862939819), this.widgetType.name().toLowerCase()));
            arrayList.add(new HttpParameter(y.ٴسسݬߨ(1393237082), this.hideTweet));
        }
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OEmbedRequest oEmbedRequest = (OEmbedRequest) obj;
        if (this.hideMedia != oEmbedRequest.hideMedia || this.hideThread != oEmbedRequest.hideThread || this.maxWidth != oEmbedRequest.maxWidth || this.omitScript != oEmbedRequest.omitScript || this.statusId != oEmbedRequest.statusId || this.align != oEmbedRequest.align) {
            return false;
        }
        String str = this.lang;
        if (str == null ? oEmbedRequest.lang != null : !str.equals(oEmbedRequest.lang)) {
            return false;
        }
        if (!Arrays.equals(this.related, oEmbedRequest.related)) {
            return false;
        }
        String str2 = this.url;
        if (str2 == null ? oEmbedRequest.url == null : str2.equals(oEmbedRequest.url)) {
            return this.widgetType == oEmbedRequest.widgetType && this.hideTweet == oEmbedRequest.hideTweet;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.statusId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.url;
        int hashCode = (((((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.maxWidth) * 31) + (this.hideMedia ? 1 : 0)) * 31) + (this.hideThread ? 1 : 0)) * 31) + (this.omitScript ? 1 : 0)) * 31;
        Align align = this.align;
        int hashCode2 = (hashCode + (align != null ? align.hashCode() : 0)) * 31;
        String[] strArr = this.related;
        int hashCode3 = (hashCode2 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String str2 = this.lang;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        WidgetType widgetType = this.widgetType;
        return ((hashCode4 + (widgetType != null ? widgetType.hashCode() : 0)) * 31) + (this.hideTweet ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.ٴسسݬߨ(1393237050)).append(this.statusId).append(y.ٲٴݴ״ٰ(1782508648)).append(this.url).append(y.ٴسسݬߨ(1393237362)).append(this.maxWidth).append(y.֬ڱܱײٮ(-1158987615)).append(this.hideMedia).append(y.دײܮڳܯ(2051153021)).append(this.hideThread).append(y.دײܮڳܯ(2051153141)).append(this.omitScript).append(y.ٴسسݬߨ(1393237666)).append(this.align).append(y.ٴسسݬߨ(1393237778));
        String[] strArr = this.related;
        return append.append(strArr == null ? null : Arrays.asList(strArr)).append(y.ݮڮֲڭܩ(-628151300)).append(this.lang).append(y.ٴسسݬߨ(1393237922)).append(this.widgetType).append(y.دײܮڳܯ(2051152397)).append(this.hideTweet).append('}').toString();
    }
}
