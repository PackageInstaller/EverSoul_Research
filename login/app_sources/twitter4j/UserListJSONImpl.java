package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class UserListJSONImpl extends TwitterResponseImpl implements UserList, Serializable {
    private static final long serialVersionUID = 449418980060197008L;
    private Date createdAt;
    private String description;
    private boolean following;
    private String fullName;

    /* renamed from: id */
    private long f1576id;
    private int memberCount;
    private boolean mode;
    private String name;
    private String slug;
    private int subscriberCount;
    private String uri;
    private User user;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserListJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserListJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.٬ݯح׭٩(575756878);
        this.f1576id = ParseUtil.getLong(y.ٲٴݴ״ٰ(1781792816), jSONObject);
        this.name = ParseUtil.getRawString(y.ٲٴݴ״ٰ(1781623392), jSONObject);
        this.fullName = ParseUtil.getRawString(y.֬ڱܱײٮ(-1158288687), jSONObject);
        this.slug = ParseUtil.getRawString(y.ۮڭڭܬި(862860915), jSONObject);
        this.description = ParseUtil.getRawString(y.ٴسسݬߨ(1392801274), jSONObject);
        this.subscriberCount = ParseUtil.getInt(y.֬ڱܱײٮ(-1158288007), jSONObject);
        this.memberCount = ParseUtil.getInt(y.ݮڮֲڭܩ(-627997564), jSONObject);
        this.uri = ParseUtil.getRawString(y.ۮڭڭܬި(862392755), jSONObject);
        this.mode = y.٬ݯح׭٩(575042934).equals(ParseUtil.getRawString(y.ٲٴݴ״ٰ(1780559616), jSONObject));
        this.following = ParseUtil.getBoolean(y.ٲٴݴ״ٰ(1780526736), jSONObject);
        this.createdAt = ParseUtil.getDate(y.ۮڭڭܬި(862635699), jSONObject);
        try {
            if (jSONObject.isNull(str)) {
                return;
            }
            this.user = new UserJSONImpl(jSONObject.getJSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(UserList userList) {
        long id = this.f1576id - userList.getId();
        if (id < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (id > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public long getId() {
        return this.f1576id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public String getFullName() {
        return this.fullName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public String getSlug() {
        return this.slug;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public String getDescription() {
        return this.description;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public int getMemberCount() {
        return this.memberCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public URI getURI() {
        try {
            return new URI(this.uri);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public boolean isPublic() {
        return this.mode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public boolean isFollowing() {
        return this.following;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.UserList
    public User getUser() {
        return this.user;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONObject asJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = asJSONObject.getJSONArray("lists");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, asJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserListJSONImpl userListJSONImpl = new UserListJSONImpl(jSONObject);
                pagableResponseListImpl.add(userListJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userListJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(pagableResponseListImpl, asJSONObject);
            }
            return pagableResponseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<UserList> createUserListList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                UserListJSONImpl userListJSONImpl = new UserListJSONImpl(jSONObject);
                responseListImpl.add(userListJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userListJSONImpl, jSONObject);
                }
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
    public int hashCode() {
        return (int) this.f1576id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserList) && ((UserList) obj).getId() == this.f1576id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-627997300) + this.f1576id + y.ݬֲ֮ܲت(1512211415) + this.name + y.ۮڭڭܬި(862914259) + this.fullName + y.٬ݯح׭٩(576298078) + this.slug + y.ݮڮֲڭܩ(-627990868) + this.description + y.ٴسسݬߨ(1393930962) + this.subscriberCount + y.دײܮڳܯ(2052895045) + this.memberCount + y.ݬֲ֮ܲت(1513920559) + this.uri + y.֬ڱܱײٮ(-1158287679) + this.mode + y.ݮڮֲڭܩ(-628136604) + this.user + y.ٲٴݴ״ٰ(1780519768) + this.following + '}';
    }
}
