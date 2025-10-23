package twitter4j;

import com.liapp.y;
import java.util.Map;
import twitter4j.api.HelpResources;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class JSONImplFactory implements ObjectFactory {
    private static final long serialVersionUID = -1853541456182663343L;
    private final Configuration conf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONImplFactory(Configuration configuration) {
        this.conf = configuration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public Status createStatus(JSONObject jSONObject) throws TwitterException {
        return new StatusJSONImpl(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public User createUser(JSONObject jSONObject) throws TwitterException {
        return new UserJSONImpl(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public UserList createAUserList(JSONObject jSONObject) throws TwitterException {
        return new UserListJSONImpl(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse httpResponse) throws TwitterException {
        return RateLimitStatusJSONImpl.createRateLimitStatuses(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public Status createStatus(HttpResponse httpResponse) throws TwitterException {
        return new StatusJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<Status> createStatusList(HttpResponse httpResponse) throws TwitterException {
        return StatusJSONImpl.createStatusList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static GeoLocation createGeoLocation(JSONObject jSONObject) throws TwitterException {
        String str = y.٬ݯح׭٩(576194518);
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            String string = jSONObject.getJSONObject(str).getString(str);
            String[] split = string.substring(1, string.length() - 1).split(",");
            return new GeoLocation(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static GeoLocation[][] coordinatesAsGeoLocationArray(JSONArray jSONArray) throws TwitterException {
        try {
            GeoLocation[][] geoLocationArr = new GeoLocation[jSONArray.length()][];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                geoLocationArr[i] = new GeoLocation[jSONArray2.length()];
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                    geoLocationArr[i][i2] = new GeoLocation(jSONArray3.getDouble(1), jSONArray3.getDouble(0));
                }
            }
            return geoLocationArr;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RateLimitStatus createRateLimitStatusFromResponseHeader(HttpResponse httpResponse) {
        return RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public Trends createTrends(HttpResponse httpResponse) throws TwitterException {
        return new TrendsJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public User createUser(HttpResponse httpResponse) throws TwitterException {
        return new UserJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<User> createUserList(HttpResponse httpResponse) throws TwitterException {
        return UserJSONImpl.createUserList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<User> createUserListFromJSONArray(HttpResponse httpResponse) throws TwitterException {
        return UserJSONImpl.createUserList(httpResponse.asJSONArray(), httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<User> createUserListFromJSONArray_Users(HttpResponse httpResponse) throws TwitterException {
        try {
            return UserJSONImpl.createUserList(httpResponse.asJSONObject().getJSONArray("users"), httpResponse, this.conf);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public QueryResult createQueryResult(HttpResponse httpResponse, Query query) throws TwitterException {
        try {
            return new QueryResultJSONImpl(httpResponse, this.conf);
        } catch (TwitterException e) {
            if (404 == e.getStatusCode()) {
                return new QueryResultJSONImpl(query);
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public IDs createIDs(HttpResponse httpResponse) throws TwitterException {
        return new IDsJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public PagableResponseList<User> createPagableUserList(HttpResponse httpResponse) throws TwitterException {
        return UserJSONImpl.createPagableUserList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public UserList createAUserList(HttpResponse httpResponse) throws TwitterException {
        return new UserListJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse) throws TwitterException {
        return UserListJSONImpl.createPagableUserListList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<UserList> createUserListList(HttpResponse httpResponse) throws TwitterException {
        return UserListJSONImpl.createUserListList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<Category> createCategoryList(HttpResponse httpResponse) throws TwitterException {
        return CategoryJSONImpl.createCategoriesList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public DirectMessage createDirectMessage(HttpResponse httpResponse) throws TwitterException {
        return new DirectMessageJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public DirectMessageList createDirectMessageList(HttpResponse httpResponse) throws TwitterException {
        return DirectMessageJSONImpl.createDirectMessageList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public Relationship createRelationship(HttpResponse httpResponse) throws TwitterException {
        return new RelationshipJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<Friendship> createFriendshipList(HttpResponse httpResponse) throws TwitterException {
        return FriendshipJSONImpl.createFriendshipList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public AccountTotals createAccountTotals(HttpResponse httpResponse) throws TwitterException {
        return new AccountTotalsJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public AccountSettings createAccountSettings(HttpResponse httpResponse) throws TwitterException {
        return new AccountSettingsJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public SavedSearch createSavedSearch(HttpResponse httpResponse) throws TwitterException {
        return new SavedSearchJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse) throws TwitterException {
        return SavedSearchJSONImpl.createSavedSearchList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<Location> createLocationList(HttpResponse httpResponse) throws TwitterException {
        return LocationJSONImpl.createLocationList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public Place createPlace(HttpResponse httpResponse) throws TwitterException {
        return new PlaceJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<Place> createPlaceList(HttpResponse httpResponse) throws TwitterException {
        try {
            return PlaceJSONImpl.createPlaceList(httpResponse, this.conf);
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return new ResponseListImpl(0, (HttpResponse) null);
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse httpResponse) throws TwitterException {
        return new TwitterAPIConfigurationJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public ResponseList<HelpResources.Language> createLanguageList(HttpResponse httpResponse) throws TwitterException {
        return LanguageJSONImpl.createLanguageList(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public <T> ResponseList<T> createEmptyResponseList() {
        return new ResponseListImpl(0, (HttpResponse) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.ObjectFactory
    public OEmbed createOEmbed(HttpResponse httpResponse) throws TwitterException {
        return new OEmbedJSONImpl(httpResponse, this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashtagEntity createHashtagEntity(int i, int i2, String str) {
        return new HashtagEntityJSONImpl(i, i2, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UserMentionEntity createUserMentionEntity(int i, int i2, String str, String str2, long j) {
        return new UserMentionEntityJSONImpl(i, i2, str, str2, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static URLEntity createUrlEntity(int i, int i2, String str, String str2, String str3) {
        return new URLEntityJSONImpl(i, i2, str, str2, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JSONImplFactory)) {
            return false;
        }
        Configuration configuration = this.conf;
        Configuration configuration2 = ((JSONImplFactory) obj).conf;
        return configuration == null ? configuration2 == null : configuration.equals(configuration2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Configuration configuration = this.conf;
        if (configuration != null) {
            return configuration.hashCode();
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628103140) + this.conf + '}';
    }
}
