package twitter4j.json;

import com.liapp.y;
import java.util.Map;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Relationship;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.UserList;

/* loaded from: classes4.dex */
public final class DataObjectFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DataObjectFactory() {
        throw new AssertionError(y.دײܮڳܯ(2052936869));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getRawJSON(Object obj) {
        return TwitterObjectFactory.getRawJSON(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Status createStatus(String str) throws TwitterException {
        return TwitterObjectFactory.createStatus(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static User createUser(String str) throws TwitterException {
        return TwitterObjectFactory.createUser(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccountTotals createAccountTotals(String str) throws TwitterException {
        return TwitterObjectFactory.createAccountTotals(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Relationship createRelationship(String str) throws TwitterException {
        return TwitterObjectFactory.createRelationship(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Place createPlace(String str) throws TwitterException {
        return TwitterObjectFactory.createPlace(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SavedSearch createSavedSearch(String str) throws TwitterException {
        return TwitterObjectFactory.createSavedSearch(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Trend createTrend(String str) throws TwitterException {
        return TwitterObjectFactory.createTrend(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Trends createTrends(String str) throws TwitterException {
        return TwitterObjectFactory.createTrends(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static IDs createIDs(String str) throws TwitterException {
        return TwitterObjectFactory.createIDs(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Map<String, RateLimitStatus> createRateLimitStatus(String str) throws TwitterException {
        return TwitterObjectFactory.createRateLimitStatus(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Category createCategory(String str) throws TwitterException {
        return TwitterObjectFactory.createCategory(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Location createLocation(String str) throws TwitterException {
        return TwitterObjectFactory.createLocation(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UserList createUserList(String str) throws TwitterException {
        return TwitterObjectFactory.createUserList(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static OEmbed createOEmbed(String str) throws TwitterException {
        return TwitterObjectFactory.createOEmbed(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createObject(String str) throws TwitterException {
        return TwitterObjectFactory.createObject(str);
    }
}
