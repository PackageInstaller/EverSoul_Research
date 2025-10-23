package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
class UserMentionEntityJSONImpl extends EntityIndex implements UserMentionEntity {
    private static final long serialVersionUID = 6060510953676673013L;

    /* renamed from: id */
    private long f1577id;
    private String name;
    private String screenName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserMentionEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserMentionEntityJSONImpl(int i, int i2, String str, String str2, long j) {
        setStart(i);
        setEnd(i2);
        this.name = str;
        this.screenName = str2;
        this.f1577id = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserMentionEntityJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.٬ݯح׭٩(576238206);
        String str2 = y.ٲٴݴ״ٰ(1781623392);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull(str2)) {
                this.name = jSONObject.getString(str2);
            }
            if (!jSONObject.isNull(str)) {
                this.screenName = jSONObject.getString(str);
            }
            this.f1577id = ParseUtil.getLong("id", jSONObject);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserMentionEntity, twitter4j.TweetEntity
    public String getText() {
        return this.screenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserMentionEntity
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserMentionEntity
    public String getScreenName() {
        return this.screenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserMentionEntity
    public long getId() {
        return this.f1577id;
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
        UserMentionEntityJSONImpl userMentionEntityJSONImpl = (UserMentionEntityJSONImpl) obj;
        if (this.f1577id != userMentionEntityJSONImpl.f1577id) {
            return false;
        }
        String str = this.name;
        if (str == null ? userMentionEntityJSONImpl.name != null : !str.equals(userMentionEntityJSONImpl.name)) {
            return false;
        }
        String str2 = this.screenName;
        String str3 = userMentionEntityJSONImpl.screenName;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.screenName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.f1577id;
        return hashCode2 + ((int) (j ^ (j >>> 32)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1158295167) + this.name + y.ٲٴݴ״ٰ(1782495112) + this.screenName + y.ٴسسݬߨ(1393248858) + this.f1577id + '}';
    }
}
