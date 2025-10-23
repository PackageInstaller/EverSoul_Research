package twitter4j;

import com.kakao.sdk.talk.Constants;
import com.liapp.y;

/* loaded from: classes4.dex */
public final class JSONObjectType {
    private static final Logger logger = Logger.getLogger(JSONObjectType.class);

    public enum Type {
        SENDER,
        STATUS,
        DIRECT_MESSAGE,
        DELETE,
        LIMIT,
        STALL_WARNING,
        SCRUB_GEO,
        FRIENDS,
        FAVORITE,
        UNFAVORITE,
        FOLLOW,
        UNFOLLOW,
        USER_LIST_MEMBER_ADDED,
        USER_LIST_MEMBER_DELETED,
        USER_LIST_SUBSCRIBED,
        USER_LIST_UNSUBSCRIBED,
        USER_LIST_CREATED,
        USER_LIST_UPDATED,
        USER_LIST_DESTROYED,
        USER_UPDATE,
        USER_DELETE,
        USER_SUSPEND,
        BLOCK,
        UNBLOCK,
        DISCONNECTION,
        RETWEETED_RETWEET,
        FAVORITED_RETWEET,
        QUOTED_TWEET,
        MUTE,
        UNMUTE,
        UNKNOWN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Type determine(JSONObject jSONObject) {
        if (!jSONObject.isNull(y.ݬֲ֮ܲت(1512179655))) {
            return Type.SENDER;
        }
        if (!jSONObject.isNull(y.ٲٴݴ״ٰ(1782384304))) {
            return Type.STATUS;
        }
        if (!jSONObject.isNull(y.ٴسسݬߨ(1393241282))) {
            return Type.DIRECT_MESSAGE;
        }
        if (!jSONObject.isNull(y.֬ڱܱײٮ(-1158975455))) {
            return Type.DELETE;
        }
        if (!jSONObject.isNull(y.ݮڮֲڭܩ(-628790308))) {
            return Type.LIMIT;
        }
        if (!jSONObject.isNull(y.دײܮڳܯ(2051157805))) {
            return Type.STALL_WARNING;
        }
        if (!jSONObject.isNull(y.ٲٴݴ״ٰ(1782461104))) {
            return Type.SCRUB_GEO;
        }
        if (!jSONObject.isNull(y.دײܮڳܯ(2051157901))) {
            return Type.FRIENDS;
        }
        String str = y.ٲٴݴ״ٰ(1782060104);
        if (!jSONObject.isNull(str)) {
            try {
                try {
                    String string = jSONObject.getString(str);
                    if (Constants.FAVORITE.equals(string)) {
                        return Type.FAVORITE;
                    }
                    if ("unfavorite".equals(string)) {
                        return Type.UNFAVORITE;
                    }
                    if ("follow".equals(string)) {
                        return Type.FOLLOW;
                    }
                    if ("unfollow".equals(string)) {
                        return Type.UNFOLLOW;
                    }
                    if (string.startsWith(com.kakao.sdk.template.Constants.TYPE_LIST)) {
                        if ("list_member_added".equals(string)) {
                            return Type.USER_LIST_MEMBER_ADDED;
                        }
                        if ("list_member_removed".equals(string)) {
                            return Type.USER_LIST_MEMBER_DELETED;
                        }
                        if ("list_user_subscribed".equals(string)) {
                            return Type.USER_LIST_SUBSCRIBED;
                        }
                        if ("list_user_unsubscribed".equals(string)) {
                            return Type.USER_LIST_UNSUBSCRIBED;
                        }
                        if ("list_created".equals(string)) {
                            return Type.USER_LIST_CREATED;
                        }
                        if ("list_updated".equals(string)) {
                            return Type.USER_LIST_UPDATED;
                        }
                        if ("list_destroyed".equals(string)) {
                            return Type.USER_LIST_DESTROYED;
                        }
                    } else {
                        if ("user_update".equals(string)) {
                            return Type.USER_UPDATE;
                        }
                        if ("user_delete".equals(string)) {
                            return Type.USER_DELETE;
                        }
                        if ("user_suspend".equals(string)) {
                            return Type.USER_SUSPEND;
                        }
                        if ("block".equals(string)) {
                            return Type.BLOCK;
                        }
                        if ("unblock".equals(string)) {
                            return Type.UNBLOCK;
                        }
                        if ("retweeted_retweet".equals(string)) {
                            return Type.RETWEETED_RETWEET;
                        }
                        if ("favorited_retweet".equals(string)) {
                            return Type.FAVORITED_RETWEET;
                        }
                        if ("quoted_tweet".equals(string)) {
                            return Type.QUOTED_TWEET;
                        }
                        if ("mute".equals(string)) {
                            return Type.MUTE;
                        }
                        if ("unmute".equals(string)) {
                            return Type.UNMUTE;
                        }
                    }
                } catch (JSONException unused) {
                    logger.warn("Failed to get event element: ", jSONObject.toString(2));
                }
            } catch (JSONException unused2) {
            }
        } else if (!jSONObject.isNull(y.ٲٴݴ״ٰ(1782293856))) {
            return Type.DISCONNECTION;
        }
        return Type.UNKNOWN;
    }
}
