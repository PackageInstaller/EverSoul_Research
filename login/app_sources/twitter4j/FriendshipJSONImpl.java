package twitter4j;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.liapp.y;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class FriendshipJSONImpl implements Friendship {
    private static final long serialVersionUID = 6847273186993125826L;
    private boolean followedBy;
    private boolean following;

    /* renamed from: id */
    private final long f1561id;
    private final String name;
    private final String screenName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FriendshipJSONImpl(JSONObject jSONObject) throws TwitterException {
        this.following = false;
        this.followedBy = false;
        try {
            this.f1561id = ParseUtil.getLong("id", jSONObject);
            this.name = jSONObject.getString("name");
            this.screenName = jSONObject.getString(FirebaseAnalytics.Param.SCREEN_NAME);
            JSONArray jSONArray = jSONObject.getJSONArray("connections");
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if ("following".equals(string)) {
                    this.following = true;
                } else if ("followed_by".equals(string)) {
                    this.followedBy = true;
                }
            }
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Friendship> createFriendshipList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                FriendshipJSONImpl friendshipJSONImpl = new FriendshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(friendshipJSONImpl, jSONObject);
                }
                responseListImpl.add(friendshipJSONImpl);
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
    @Override // twitter4j.Friendship
    public long getId() {
        return this.f1561id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Friendship
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Friendship
    public String getScreenName() {
        return this.screenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Friendship
    public boolean isFollowing() {
        return this.following;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Friendship
    public boolean isFollowedBy() {
        return this.followedBy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FriendshipJSONImpl friendshipJSONImpl = (FriendshipJSONImpl) obj;
        return this.followedBy == friendshipJSONImpl.followedBy && this.following == friendshipJSONImpl.following && this.f1561id == friendshipJSONImpl.f1561id && this.name.equals(friendshipJSONImpl.name) && this.screenName.equals(friendshipJSONImpl.screenName);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.f1561id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.screenName;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.following ? 1 : 0)) * 31) + (this.followedBy ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٴسسݬߨ(1393274834) + this.f1561id + y.ݬֲ֮ܲت(1512211415) + this.name + y.ٲٴݴ״ٰ(1782495112) + this.screenName + y.دײܮڳܯ(2051189589) + this.following + y.ۮڭڭܬި(862961835) + this.followedBy + '}';
    }
}
