package twitter4j;

import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import twitter4j.JSONObjectType;

/* loaded from: classes4.dex */
public final class TwitterObjectFactory {
    private static final ThreadLocal<Map> rawJsonMap = new ThreadLocal<Map>() { // from class: twitter4j.TwitterObjectFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.ThreadLocal
        public Map initialValue() {
            return new HashMap();
        }
    };
    private static boolean registeredAtleastOnce = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TwitterObjectFactory() {
        throw new AssertionError(y.دײܮڳܯ(2052936869));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getRawJSON(Object obj) {
        if (!registeredAtleastOnce) {
            throw new IllegalStateException(y.ٴسسݬߨ(1393842106));
        }
        Object obj2 = rawJsonMap.get().get(obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 != null) {
            return obj2.toString();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Status createStatus(String str) throws TwitterException {
        try {
            return new StatusJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static User createUser(String str) throws TwitterException {
        try {
            return new UserJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccountTotals createAccountTotals(String str) throws TwitterException {
        try {
            return new AccountTotalsJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Relationship createRelationship(String str) throws TwitterException {
        try {
            return new RelationshipJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Place createPlace(String str) throws TwitterException {
        try {
            return new PlaceJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SavedSearch createSavedSearch(String str) throws TwitterException {
        try {
            return new SavedSearchJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Trend createTrend(String str) throws TwitterException {
        try {
            return new TrendJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Trends createTrends(String str) throws TwitterException {
        return new TrendsJSONImpl(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static IDs createIDs(String str) throws TwitterException {
        return new IDsJSONImpl(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Map<String, RateLimitStatus> createRateLimitStatus(String str) throws TwitterException {
        try {
            return RateLimitStatusJSONImpl.createRateLimitStatuses(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Category createCategory(String str) throws TwitterException {
        try {
            return new CategoryJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DirectMessage createDirectMessage(String str) throws TwitterException {
        try {
            return new DirectMessageJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Location createLocation(String str) throws TwitterException {
        try {
            return new LocationJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UserList createUserList(String str) throws TwitterException {
        try {
            return new UserListJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static OEmbed createOEmbed(String str) throws TwitterException {
        try {
            return new OEmbedJSONImpl(new JSONObject(str));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createObject(String str) throws TwitterException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = C29472.$SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.determine(jSONObject).ordinal()];
            String str2 = y.ٴسسݬߨ(1393241282);
            if (i == 1) {
                return registerJSONObject(new DirectMessageJSONImpl(jSONObject.getJSONObject(str2)), jSONObject);
            }
            if (i == 2) {
                return registerJSONObject(new StatusJSONImpl(jSONObject), jSONObject);
            }
            if (i != 3) {
                return i != 4 ? jSONObject : registerJSONObject(new StatusDeletionNoticeImpl(jSONObject.getJSONObject("delete").getJSONObject("status")), jSONObject);
            }
            return registerJSONObject(new DirectMessageJSONImpl(jSONObject.getJSONObject(str2)), jSONObject);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* renamed from: twitter4j.TwitterObjectFactory$2 */
    static /* synthetic */ class C29472 {
        static final /* synthetic */ int[] $SwitchMap$twitter4j$JSONObjectType$Type;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[JSONObjectType.Type.values().length];
            $SwitchMap$twitter4j$JSONObjectType$Type = iArr;
            try {
                iArr[JSONObjectType.Type.SENDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.DIRECT_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$twitter4j$JSONObjectType$Type[JSONObjectType.Type.SCRUB_GEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void clearThreadLocalMap() {
        rawJsonMap.get().clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T registerJSONObject(T t, Object obj) {
        registeredAtleastOnce = true;
        rawJsonMap.get().put(t, obj);
        return t;
    }
}
