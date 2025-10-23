package twitter4j;

import com.liapp.y;
import java.util.Arrays;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class IDsJSONImpl extends TwitterResponseImpl implements IDs {
    private static final long serialVersionUID = 6999637496007165672L;
    private long[] ids;
    private long nextCursor;
    private long previousCursor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IDsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        this.previousCursor = -1L;
        this.nextCursor = -1L;
        String asString = httpResponse.asString();
        init(asString);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asString);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IDsJSONImpl(String str) throws TwitterException {
        this.previousCursor = -1L;
        this.nextCursor = -1L;
        init(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(String str) throws TwitterException {
        try {
            boolean startsWith = str.startsWith("{");
            String str2 = y.֬ڱܱײٮ(-1158965575);
            int i = 0;
            if (startsWith) {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("ids");
                this.ids = new long[jSONArray.length()];
                while (i < jSONArray.length()) {
                    try {
                        this.ids[i] = Long.parseLong(jSONArray.getString(i));
                        i++;
                    } catch (NumberFormatException e) {
                        throw new TwitterException(str2 + jSONObject, e);
                    }
                }
                this.previousCursor = ParseUtil.getLong("previous_cursor", jSONObject);
                this.nextCursor = ParseUtil.getLong("next_cursor", jSONObject);
                return;
            }
            JSONArray jSONArray2 = new JSONArray(str);
            this.ids = new long[jSONArray2.length()];
            while (i < jSONArray2.length()) {
                try {
                    this.ids[i] = Long.parseLong(jSONArray2.getString(i));
                    i++;
                } catch (NumberFormatException e2) {
                    throw new TwitterException(str2 + jSONArray2, e2);
                }
            }
            return;
        } catch (JSONException e3) {
            throw new TwitterException(e3);
        }
        throw new TwitterException(e3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.IDs
    public long[] getIDs() {
        return this.ids;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public boolean hasPrevious() {
        return 0 != this.previousCursor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public long getPreviousCursor() {
        return this.previousCursor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public boolean hasNext() {
        return 0 != this.nextCursor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public long getNextCursor() {
        return this.nextCursor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IDs) && Arrays.equals(this.ids, ((IDs) obj).getIDs());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long[] jArr = this.ids;
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1782504392) + Arrays.toString(this.ids) + y.ݮڮֲڭܩ(-628100804) + this.previousCursor + y.ۮڭڭܬި(862957363) + this.nextCursor + '}';
    }
}
