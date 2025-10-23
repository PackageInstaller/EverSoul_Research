package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class StatusJSONImpl extends TwitterResponseImpl implements Status, Serializable {
    private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
    private static final long serialVersionUID = -6461195536943679985L;
    private long[] contributorsIDs;
    private Date createdAt;
    private long currentUserRetweetId;
    private int displayTextRangeEnd;
    private int displayTextRangeStart;
    private int favoriteCount;
    private GeoLocation geoLocation;
    private HashtagEntity[] hashtagEntities;

    /* renamed from: id */
    private long f1572id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isPossiblySensitive;
    private boolean isRetweeted;
    private boolean isTruncated;
    private String lang;
    private MediaEntity[] mediaEntities;
    private Place place;
    private Status quotedStatus;
    private long quotedStatusId;
    private URLEntity quotedStatusPermalink;
    private long retweetCount;
    private Status retweetedStatus;
    private Scopes scopes;
    private String source;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private User user;
    private UserMentionEntity[] userMentionEntities;
    private String[] withheldInCountries;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StatusJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        this.displayTextRangeStart = -1;
        this.displayTextRangeEnd = -1;
        this.geoLocation = null;
        this.place = null;
        this.currentUserRetweetId = -1L;
        this.user = null;
        this.withheldInCountries = null;
        this.quotedStatusId = -1L;
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StatusJSONImpl(JSONObject jSONObject, Configuration configuration) throws TwitterException {
        this.displayTextRangeStart = -1;
        this.displayTextRangeEnd = -1;
        this.geoLocation = null;
        this.place = null;
        this.currentUserRetweetId = -1L;
        this.user = null;
        this.withheldInCountries = null;
        this.quotedStatusId = -1L;
        init(jSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StatusJSONImpl(JSONObject jSONObject) throws TwitterException {
        this.displayTextRangeStart = -1;
        this.displayTextRangeEnd = -1;
        this.geoLocation = null;
        this.place = null;
        this.currentUserRetweetId = -1L;
        this.user = null;
        this.withheldInCountries = null;
        this.quotedStatusId = -1L;
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StatusJSONImpl() {
        this.displayTextRangeStart = -1;
        this.displayTextRangeEnd = -1;
        this.geoLocation = null;
        this.place = null;
        this.currentUserRetweetId = -1L;
        this.user = null;
        this.withheldInCountries = null;
        this.quotedStatusId = -1L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ݮڮֲڭܩ(-628133412);
        String str2 = y.ٴسسݬߨ(1393247674);
        String str3 = y.٬ݯح׭٩(576533390);
        String str4 = y.٬ݯح׭٩(576655054);
        String str5 = y.ٴسسݬߨ(1393247938);
        String str6 = y.ٲٴݴ״ٰ(1782470744);
        String str7 = y.ݬֲ֮ܲت(1512205399);
        String str8 = y.ٲٴݴ״ٰ(1782384304);
        String str9 = y.ٴسسݬߨ(1393246330);
        String str10 = y.دײܮڳܯ(2051163717);
        String str11 = y.ٲٴݴ״ٰ(1782469800);
        String str12 = y.٬ݯح׭٩(576226550);
        String str13 = y.ٲٴݴ״ٰ(1782472224);
        String str14 = y.ٲٴݴ״ٰ(1782472400);
        String str15 = y.٬ݯح׭٩(575756878);
        String str16 = y.ٲٴݴ״ٰ(1781792816);
        this.f1572id = ParseUtil.getLong(str16, jSONObject);
        this.source = ParseUtil.getUnescapedString(y.ٴسسݬߨ(1392903434), jSONObject);
        this.createdAt = ParseUtil.getDate(y.ۮڭڭܬި(862635699), jSONObject);
        this.isTruncated = ParseUtil.getBoolean(y.ۮڭڭܬި(862922955), jSONObject);
        this.inReplyToStatusId = ParseUtil.getLong(y.֬ڱܱײٮ(-1158996119), jSONObject);
        this.inReplyToUserId = ParseUtil.getLong(y.ٲٴݴ״ٰ(1782471704), jSONObject);
        this.isFavorited = ParseUtil.getBoolean(y.دײܮڳܯ(2051162565), jSONObject);
        this.isRetweeted = ParseUtil.getBoolean(y.֬ڱܱײٮ(-1159003855), jSONObject);
        this.inReplyToScreenName = ParseUtil.getUnescapedString(y.ۮڭڭܬި(862926163), jSONObject);
        this.retweetCount = ParseUtil.getLong(y.دײܮڳܯ(2051170141), jSONObject);
        this.favoriteCount = ParseUtil.getInt(y.ٴسسݬߨ(1393253882), jSONObject);
        this.isPossiblySensitive = ParseUtil.getBoolean(y.ݬֲ֮ܲت(1512207807), jSONObject);
        try {
            if (!jSONObject.isNull(str15)) {
                this.user = new UserJSONImpl(jSONObject.getJSONObject(str15));
            }
            this.geoLocation = JSONImplFactory.createGeoLocation(jSONObject);
            if (!jSONObject.isNull(str14)) {
                this.place = new PlaceJSONImpl(jSONObject.getJSONObject(str14));
            }
            if (!jSONObject.isNull(str13)) {
                this.retweetedStatus = new StatusJSONImpl(jSONObject.getJSONObject(str13));
            }
            if (!jSONObject.isNull(str12)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str12);
                this.contributorsIDs = new long[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.contributorsIDs[i] = Long.parseLong(jSONArray.getString(i));
                }
            } else {
                this.contributorsIDs = new long[0];
            }
            collectEntities(jSONObject);
            mergeExtendedEntities(jSONObject);
            if (!jSONObject.isNull(str11)) {
                this.quotedStatus = new StatusJSONImpl(jSONObject.getJSONObject(str11));
            }
            if (!jSONObject.isNull(str10)) {
                this.quotedStatusId = ParseUtil.getLong(str10, jSONObject);
            }
            if (!jSONObject.isNull(str9)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(str9);
                this.displayTextRangeStart = jSONArray2.getInt(0);
                this.displayTextRangeEnd = jSONArray2.getInt(1);
            }
            UserMentionEntity[] userMentionEntityArr = this.userMentionEntities;
            if (userMentionEntityArr == null) {
                userMentionEntityArr = new UserMentionEntity[0];
            }
            this.userMentionEntities = userMentionEntityArr;
            URLEntity[] uRLEntityArr = this.urlEntities;
            if (uRLEntityArr == null) {
                uRLEntityArr = new URLEntity[0];
            }
            this.urlEntities = uRLEntityArr;
            HashtagEntity[] hashtagEntityArr = this.hashtagEntities;
            if (hashtagEntityArr == null) {
                hashtagEntityArr = new HashtagEntity[0];
            }
            this.hashtagEntities = hashtagEntityArr;
            SymbolEntity[] symbolEntityArr = this.symbolEntities;
            if (symbolEntityArr == null) {
                symbolEntityArr = new SymbolEntity[0];
            }
            this.symbolEntities = symbolEntityArr;
            MediaEntity[] mediaEntityArr = this.mediaEntities;
            if (mediaEntityArr == null) {
                mediaEntityArr = new MediaEntity[0];
            }
            this.mediaEntities = mediaEntityArr;
            if (!jSONObject.isNull(str8)) {
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString(str8), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            }
            if (!jSONObject.isNull(str7)) {
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString(str7), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            }
            if (!jSONObject.isNull(str6)) {
                mergeExtendedTweet(jSONObject.getJSONObject(str6));
            }
            if (!jSONObject.isNull(str5)) {
                this.currentUserRetweetId = jSONObject.getJSONObject(str5).getLong(str16);
            }
            if (!jSONObject.isNull(str4)) {
                this.lang = ParseUtil.getUnescapedString(str4, jSONObject);
            }
            if (!jSONObject.isNull(str3)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                if (!jSONObject2.isNull(str)) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray(str);
                    int length = jSONArray3.length();
                    String[] strArr = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        strArr[i2] = jSONArray3.getString(i2);
                    }
                    this.scopes = new ScopesImpl(strArr);
                }
            }
            if (jSONObject.isNull(str2)) {
                return;
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray(str2);
            int length2 = jSONArray4.length();
            this.withheldInCountries = new String[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.withheldInCountries[i3] = jSONArray4.getString(i3);
            }
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void collectEntities(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.ݮڮֲڭܩ(-628200156);
        if (!jSONObject.isNull(str)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            this.userMentionEntities = EntitiesParseUtil.getUserMentions(jSONObject2);
            this.urlEntities = EntitiesParseUtil.getUrls(jSONObject2);
            this.hashtagEntities = EntitiesParseUtil.getHashtags(jSONObject2);
            this.symbolEntities = EntitiesParseUtil.getSymbols(jSONObject2);
            this.mediaEntities = EntitiesParseUtil.getMedia(jSONObject2);
        }
        String str2 = y.ٲٴݴ״ٰ(1782469800);
        if (!jSONObject.isNull(str2)) {
            this.quotedStatus = new StatusJSONImpl(jSONObject.getJSONObject(str2));
        }
        String str3 = y.دײܮڳܯ(2051163717);
        if (!jSONObject.isNull(str3)) {
            this.quotedStatusId = ParseUtil.getLong(str3, jSONObject);
        }
        String str4 = y.ݬֲ֮ܲت(1512206175);
        if (jSONObject.isNull(str4)) {
            return;
        }
        this.quotedStatusPermalink = new QuotedStatusPermalinkJSONImpl(jSONObject.getJSONObject(str4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void mergeExtendedEntities(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.٬ݯح׭٩(576232182);
        if (jSONObject.isNull(str)) {
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        String str2 = y.ۮڭڭܬި(862094195);
        if (jSONObject2.isNull(str2)) {
            return;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray(str2);
        int length = jSONArray.length();
        this.mediaEntities = new MediaEntity[length];
        for (int i = 0; i < length; i++) {
            this.mediaEntities[i] = new MediaEntityJSONImpl(jSONArray.getJSONObject(i));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void mergeExtendedTweet(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("display_text_range");
            this.displayTextRangeStart = jSONArray.getInt(0);
            this.displayTextRangeEnd = jSONArray.getInt(1);
            collectEntities(jSONObject);
            UserMentionEntity[] userMentionEntityArr = this.userMentionEntities;
            if (userMentionEntityArr == null) {
                userMentionEntityArr = new UserMentionEntity[0];
            }
            this.userMentionEntities = userMentionEntityArr;
            URLEntity[] uRLEntityArr = this.urlEntities;
            if (uRLEntityArr == null) {
                uRLEntityArr = new URLEntity[0];
            }
            this.urlEntities = uRLEntityArr;
            HashtagEntity[] hashtagEntityArr = this.hashtagEntities;
            if (hashtagEntityArr == null) {
                hashtagEntityArr = new HashtagEntity[0];
            }
            this.hashtagEntities = hashtagEntityArr;
            SymbolEntity[] symbolEntityArr = this.symbolEntities;
            if (symbolEntityArr == null) {
                symbolEntityArr = new SymbolEntity[0];
            }
            this.symbolEntities = symbolEntityArr;
            MediaEntity[] mediaEntityArr = this.mediaEntities;
            if (mediaEntityArr == null) {
                mediaEntityArr = new MediaEntity[0];
            }
            this.mediaEntities = mediaEntityArr;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("full_text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(Status status) {
        long id = this.f1572id - status.getId();
        if (id < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (id > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public long getId() {
        return this.f1572id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public String getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public int getDisplayTextRangeStart() {
        return this.displayTextRangeStart;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public int getDisplayTextRangeEnd() {
        return this.displayTextRangeEnd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public String getSource() {
        return this.source;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public boolean isTruncated() {
        return this.isTruncated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public long getInReplyToUserId() {
        return this.inReplyToUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public String getInReplyToScreenName() {
        return this.inReplyToScreenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public Place getPlace() {
        return this.place;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public long[] getContributors() {
        return this.contributorsIDs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public boolean isFavorited() {
        return this.isFavorited;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public boolean isRetweeted() {
        return this.isRetweeted;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public User getUser() {
        return this.user;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public boolean isRetweet() {
        return this.retweetedStatus != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public Status getRetweetedStatus() {
        return this.retweetedStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public int getRetweetCount() {
        return (int) this.retweetCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public boolean isRetweetedByMe() {
        return this.currentUserRetweetId != -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public long getCurrentUserRetweetId() {
        return this.currentUserRetweetId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public boolean isPossiblySensitive() {
        return this.isPossiblySensitive;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public Scopes getScopes() {
        return this.scopes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public String[] getWithheldInCountries() {
        return this.withheldInCountries;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public long getQuotedStatusId() {
        return this.quotedStatusId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public Status getQuotedStatus() {
        return this.quotedStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public URLEntity getQuotedStatusPermalink() {
        return this.quotedStatusPermalink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Status
    public String getLang() {
        return this.lang;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Status> createStatusList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                StatusJSONImpl statusJSONImpl = new StatusJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(statusJSONImpl, jSONObject);
                }
                responseListImpl.add(statusJSONImpl);
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
        return (int) this.f1572id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Status) && ((Status) obj).getId() == this.f1572id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628135156) + this.createdAt + y.ٴسسݬߨ(1393252458) + this.f1572id + y.٬ݯح׭٩(576295678) + this.text + y.٬ݯح׭٩(576232542) + this.source + y.دײܮڳܯ(2051168933) + this.isTruncated + y.ۮڭڭܬި(862924907) + this.inReplyToStatusId + y.ݬֲ֮ܲت(1512206743) + this.inReplyToUserId + y.ݬֲ֮ܲت(1512206647) + this.isFavorited + y.ݬֲ֮ܲت(1512206519) + this.isRetweeted + y.֬ڱܱײٮ(-1159002479) + this.favoriteCount + y.ٲٴݴ״ٰ(1782467368) + this.inReplyToScreenName + y.ݮڮֲڭܩ(-628137644) + this.geoLocation + y.ٲٴݴ״ٰ(1782467224) + this.place + y.ݮڮֲڭܩ(-628137588) + this.retweetCount + y.ݬֲ֮ܲت(1512209919) + this.isPossiblySensitive + y.ݮڮֲڭܩ(-628151300) + this.lang + y.ٴسسݬߨ(1393252218) + Arrays.toString(this.contributorsIDs) + y.ݮڮֲڭܩ(-628137060) + this.retweetedStatus + y.ݬֲ֮ܲت(1512274919) + Arrays.toString(this.userMentionEntities) + y.ۮڭڭܬި(862861323) + Arrays.toString(this.urlEntities) + y.֬ڱܱײٮ(-1159066495) + Arrays.toString(this.hashtagEntities) + y.ݮڮֲڭܩ(-628201972) + Arrays.toString(this.mediaEntities) + y.دײܮڳܯ(2051231901) + Arrays.toString(this.symbolEntities) + y.٬ݯح׭٩(576230494) + this.currentUserRetweetId + y.ݮڮֲڭܩ(-628136604) + this.user + y.ٴسسݬߨ(1393250594) + Arrays.toString(this.withheldInCountries) + y.٬ݯح׭٩(576230926) + this.quotedStatusId + y.دײܮڳܯ(2051166373) + this.quotedStatus + '}';
    }
}
