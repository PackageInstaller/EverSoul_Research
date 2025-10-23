package twitter4j;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.liapp.y;
import java.io.Serializable;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class RelationshipJSONImpl extends TwitterResponseImpl implements Relationship, Serializable {
    private static final long serialVersionUID = -2001484553401916448L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceCanDm;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceMutingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;
    private boolean wantRetweets;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RelationshipJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RelationshipJSONImpl(JSONObject jSONObject) throws TwitterException {
        this((HttpResponse) null, jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RelationshipJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws TwitterException {
        super(httpResponse);
        String str = y.٬ݯح׭٩(576238206);
        String str2 = y.ٲٴݴ״ٰ(1781792816);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("relationship");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("source");
            JSONObject jSONObject4 = jSONObject2.getJSONObject(TypedValues.AttributesType.S_TARGET);
            this.sourceUserId = ParseUtil.getLong(str2, jSONObject3);
            this.targetUserId = ParseUtil.getLong(str2, jSONObject4);
            this.sourceUserScreenName = ParseUtil.getUnescapedString(str, jSONObject3);
            this.targetUserScreenName = ParseUtil.getUnescapedString(str, jSONObject4);
            this.sourceBlockingTarget = ParseUtil.getBoolean("blocking", jSONObject3);
            this.sourceFollowingTarget = ParseUtil.getBoolean("following", jSONObject3);
            this.sourceFollowedByTarget = ParseUtil.getBoolean("followed_by", jSONObject3);
            this.sourceCanDm = ParseUtil.getBoolean("can_dm", jSONObject3);
            this.sourceMutingTarget = ParseUtil.getBoolean("muting", jSONObject3);
            this.sourceNotificationsEnabled = ParseUtil.getBoolean("notifications_enabled", jSONObject3);
            this.wantRetweets = ParseUtil.getBoolean("want_retweets", jSONObject3);
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Relationship> createRelationshipList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                RelationshipJSONImpl relationshipJSONImpl = new RelationshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(relationshipJSONImpl, jSONObject);
                }
                responseListImpl.add(relationshipJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public long getSourceUserId() {
        return this.sourceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public long getTargetUserId() {
        return this.targetUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isSourceBlockingTarget() {
        return this.sourceBlockingTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public String getSourceUserScreenName() {
        return this.sourceUserScreenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public String getTargetUserScreenName() {
        return this.targetUserScreenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isSourceFollowingTarget() {
        return this.sourceFollowingTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isTargetFollowingSource() {
        return this.sourceFollowedByTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isSourceFollowedByTarget() {
        return this.sourceFollowedByTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isTargetFollowedBySource() {
        return this.sourceFollowingTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean canSourceDm() {
        return this.sourceCanDm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isSourceMutingTarget() {
        return this.sourceMutingTarget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isSourceNotificationsEnabled() {
        return this.sourceNotificationsEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Relationship
    public boolean isSourceWantRetweets() {
        return this.wantRetweets;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RelationshipJSONImpl relationshipJSONImpl = (RelationshipJSONImpl) obj;
        if (this.sourceBlockingTarget != relationshipJSONImpl.sourceBlockingTarget || this.sourceCanDm != relationshipJSONImpl.sourceCanDm || this.sourceFollowedByTarget != relationshipJSONImpl.sourceFollowedByTarget || this.sourceFollowingTarget != relationshipJSONImpl.sourceFollowingTarget || this.sourceMutingTarget != relationshipJSONImpl.sourceMutingTarget || this.sourceNotificationsEnabled != relationshipJSONImpl.sourceNotificationsEnabled || this.sourceUserId != relationshipJSONImpl.sourceUserId || this.targetUserId != relationshipJSONImpl.targetUserId || this.wantRetweets != relationshipJSONImpl.wantRetweets) {
            return false;
        }
        String str = this.sourceUserScreenName;
        if (str == null ? relationshipJSONImpl.sourceUserScreenName != null : !str.equals(relationshipJSONImpl.sourceUserScreenName)) {
            return false;
        }
        String str2 = this.targetUserScreenName;
        String str3 = relationshipJSONImpl.targetUserScreenName;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.targetUserId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.targetUserScreenName;
        int hashCode = (((((((((((((i + (str != null ? str.hashCode() : 0)) * 31) + (this.sourceBlockingTarget ? 1 : 0)) * 31) + (this.sourceNotificationsEnabled ? 1 : 0)) * 31) + (this.sourceFollowingTarget ? 1 : 0)) * 31) + (this.sourceFollowedByTarget ? 1 : 0)) * 31) + (this.sourceCanDm ? 1 : 0)) * 31) + (this.sourceMutingTarget ? 1 : 0)) * 31;
        long j2 = this.sourceUserId;
        int i2 = (hashCode + ((int) ((j2 >>> 32) ^ j2))) * 31;
        String str2 = this.sourceUserScreenName;
        return ((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.wantRetweets ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051175621) + this.targetUserId + y.֬ڱܱײٮ(-1158993175) + this.targetUserScreenName + y.ٲٴݴ״ٰ(1782476720) + this.sourceBlockingTarget + y.ٴسسݬߨ(1393258794) + this.sourceNotificationsEnabled + y.ݬֲ֮ܲت(1512200695) + this.sourceFollowingTarget + y.ۮڭڭܬި(862919179) + this.sourceFollowedByTarget + y.ٲٴݴ״ٰ(1782469376) + this.sourceCanDm + y.֬ڱܱײٮ(-1158999639) + this.sourceMutingTarget + y.ۮڭڭܬި(862921851) + this.sourceUserId + y.֬ڱܱײٮ(-1158999831) + this.sourceUserScreenName + y.֬ڱܱײٮ(-1158999143) + this.wantRetweets + '}';
    }
}
