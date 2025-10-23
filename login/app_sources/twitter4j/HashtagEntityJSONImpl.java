package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
class HashtagEntityJSONImpl extends EntityIndex implements HashtagEntity, SymbolEntity {
    private static final long serialVersionUID = -5317828991902848906L;
    private String text;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HashtagEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HashtagEntityJSONImpl(int i, int i2, String str) {
        setStart(i);
        setEnd(i2);
        this.text = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HashtagEntityJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ٲٴݴ״ٰ(1782384304);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (jSONObject.isNull(str)) {
                return;
            }
            this.text = jSONObject.getString(str);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HashtagEntity, twitter4j.TweetEntity
    public String getText() {
        return this.text;
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
        String str = this.text;
        String str2 = ((HashtagEntityJSONImpl) obj).text;
        return str == null ? str2 == null : str.equals(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1158955999) + this.text + y.ݮڮֲڭܩ(-628973388);
    }
}
