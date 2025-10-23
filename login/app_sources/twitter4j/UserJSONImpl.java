package twitter4j;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.game.StringSet;
import com.liapp.y;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class UserJSONImpl extends TwitterResponseImpl implements User, Serializable {
    private static final long serialVersionUID = -5448266606847617015L;
    private Date createdAt;
    private String description;
    private URLEntity[] descriptionURLEntities;
    private String email;
    private int favouritesCount;
    private int followersCount;
    private int friendsCount;

    /* renamed from: id */
    private long f1575id;
    private boolean isContributorsEnabled;
    private boolean isDefaultProfile;
    private boolean isDefaultProfileImage;
    private boolean isFollowRequestSent;
    private boolean isGeoEnabled;
    private boolean isProtected;
    private boolean isVerified;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTiled;
    private String profileBannerImageUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private String screenName;
    private boolean showAllInlineMedia;
    private Status status;
    private int statusesCount;
    private String timeZone;
    private boolean translator;
    private String url;
    private URLEntity urlEntity;
    private int utcOffset;
    private String[] withheldInCountries;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
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
    UserJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserJSONImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ٴسسݬߨ(1393247674);
        String str2 = y.ݮڮֲڭܩ(-628237012);
        String str3 = y.ݬֲ֮ܲت(1512934047);
        String str4 = y.ٴسسݬߨ(1392801274);
        try {
            this.f1575id = ParseUtil.getLong("id", jSONObject);
            this.name = ParseUtil.getRawString("name", jSONObject);
            this.email = ParseUtil.getRawString("email", jSONObject);
            this.screenName = ParseUtil.getRawString(FirebaseAnalytics.Param.SCREEN_NAME, jSONObject);
            this.location = ParseUtil.getRawString("location", jSONObject);
            this.descriptionURLEntities = getURLEntitiesFromJSON(jSONObject, str4);
            URLEntity[] uRLEntitiesFromJSON = getURLEntitiesFromJSON(jSONObject, str3);
            if (uRLEntitiesFromJSON.length > 0) {
                this.urlEntity = uRLEntitiesFromJSON[0];
            }
            String rawString = ParseUtil.getRawString(str4, jSONObject);
            this.description = rawString;
            if (rawString != null) {
                this.description = HTMLEntity.unescapeAndSlideEntityIncdices(rawString, null, this.descriptionURLEntities, null, null);
            }
            this.isContributorsEnabled = ParseUtil.getBoolean("contributors_enabled", jSONObject);
            this.profileImageUrl = ParseUtil.getRawString("profile_image_url", jSONObject);
            this.profileImageUrlHttps = ParseUtil.getRawString("profile_image_url_https", jSONObject);
            this.isDefaultProfileImage = ParseUtil.getBoolean("default_profile_image", jSONObject);
            this.url = ParseUtil.getRawString(str3, jSONObject);
            this.isProtected = ParseUtil.getBoolean("protected", jSONObject);
            this.isGeoEnabled = ParseUtil.getBoolean("geo_enabled", jSONObject);
            this.isVerified = ParseUtil.getBoolean("verified", jSONObject);
            this.translator = ParseUtil.getBoolean("is_translator", jSONObject);
            this.followersCount = ParseUtil.getInt("followers_count", jSONObject);
            this.profileBackgroundColor = ParseUtil.getRawString("profile_background_color", jSONObject);
            this.profileTextColor = ParseUtil.getRawString("profile_text_color", jSONObject);
            this.profileLinkColor = ParseUtil.getRawString("profile_link_color", jSONObject);
            this.profileSidebarFillColor = ParseUtil.getRawString("profile_sidebar_fill_color", jSONObject);
            this.profileSidebarBorderColor = ParseUtil.getRawString("profile_sidebar_border_color", jSONObject);
            this.profileUseBackgroundImage = ParseUtil.getBoolean("profile_use_background_image", jSONObject);
            this.isDefaultProfile = ParseUtil.getBoolean("default_profile", jSONObject);
            this.showAllInlineMedia = ParseUtil.getBoolean("show_all_inline_media", jSONObject);
            this.friendsCount = ParseUtil.getInt("friends_count", jSONObject);
            this.createdAt = ParseUtil.getDate(StringSet.created_at, jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
            this.favouritesCount = ParseUtil.getInt("favourites_count", jSONObject);
            this.utcOffset = ParseUtil.getInt("utc_offset", jSONObject);
            this.timeZone = ParseUtil.getRawString("time_zone", jSONObject);
            this.profileBackgroundImageUrl = ParseUtil.getRawString("profile_background_image_url", jSONObject);
            this.profileBackgroundImageUrlHttps = ParseUtil.getRawString("profile_background_image_url_https", jSONObject);
            this.profileBannerImageUrl = ParseUtil.getRawString("profile_banner_url", jSONObject);
            this.profileBackgroundTiled = ParseUtil.getBoolean("profile_background_tile", jSONObject);
            this.lang = ParseUtil.getRawString("lang", jSONObject);
            this.statusesCount = ParseUtil.getInt("statuses_count", jSONObject);
            this.listedCount = ParseUtil.getInt("listed_count", jSONObject);
            this.isFollowRequestSent = ParseUtil.getBoolean("follow_request_sent", jSONObject);
            if (!jSONObject.isNull(str2)) {
                this.status = new StatusJSONImpl(jSONObject.getJSONObject(str2));
            }
            if (jSONObject.isNull(str)) {
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            this.withheldInCountries = new String[length];
            for (int i = 0; i < length; i++) {
                this.withheldInCountries[i] = jSONArray.getString(i);
            }
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static URLEntity[] getURLEntitiesFromJSON(JSONObject jSONObject, String str) throws JSONException, TwitterException {
        String str2 = y.ݮڮֲڭܩ(-628200156);
        if (!jSONObject.isNull(str2)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (!jSONObject2.isNull(str)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
                if (!jSONObject3.isNull("urls")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("urls");
                    int length = jSONArray.length();
                    URLEntity[] uRLEntityArr = new URLEntity[length];
                    for (int i = 0; i < length; i++) {
                        uRLEntityArr[i] = new URLEntityJSONImpl(jSONArray.getJSONObject(i));
                    }
                    return uRLEntityArr;
                }
            }
        }
        return new URLEntity[0];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(User user) {
        return (int) (this.f1575id - user.getId());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public long getId() {
        return this.f1575id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getEmail() {
        return this.email;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getScreenName() {
        return this.screenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getLocation() {
        return this.location;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getDescription() {
        return this.description;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isContributorsEnabled() {
        return this.isContributorsEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileImageURL() {
        return this.profileImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getBiggerProfileImageURL() {
        return toResizedURL(this.profileImageUrl, y.֬ڱܱײٮ(-1158286551));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getMiniProfileImageURL() {
        return toResizedURL(this.profileImageUrl, y.دײܮڳܯ(2052893741));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getOriginalProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String get400x400ProfileImageURL() {
        return toResizedURL(this.profileImageUrl, y.٬ݯح׭٩(575039990));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String toResizedURL(String str, String str2) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(y.ٲٴݴ״ٰ(1781642144));
        int lastIndexOf2 = str.lastIndexOf(y.ݮڮֲڭܩ(-629059348));
        int lastIndexOf3 = str.lastIndexOf(y.ۮڭڭܬި(861981587));
        String str3 = str.substring(0, lastIndexOf) + str2;
        return lastIndexOf2 > lastIndexOf3 ? str3 + str.substring(lastIndexOf2) : str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileImageURLHttps() {
        return this.profileImageUrlHttps;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getBiggerProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, y.֬ڱܱײٮ(-1158286551));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getMiniProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, y.دײܮڳܯ(2052893741));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getOriginalProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String get400x400ProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, y.٬ݯح׭٩(575039990));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isDefaultProfileImage() {
        return this.isDefaultProfileImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isProtected() {
        return this.isProtected;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public int getFollowersCount() {
        return this.followersCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBackgroundColor() {
        return this.profileBackgroundColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileTextColor() {
        return this.profileTextColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileLinkColor() {
        return this.profileLinkColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileSidebarFillColor() {
        return this.profileSidebarFillColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileSidebarBorderColor() {
        return this.profileSidebarBorderColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isProfileUseBackgroundImage() {
        return this.profileUseBackgroundImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isDefaultProfile() {
        return this.isDefaultProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isShowAllInlineMedia() {
        return this.showAllInlineMedia;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public int getFriendsCount() {
        return this.friendsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public Status getStatus() {
        return this.status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public int getFavouritesCount() {
        return this.favouritesCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public int getUtcOffset() {
        return this.utcOffset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getTimeZone() {
        return this.timeZone;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBackgroundImageURL() {
        return this.profileBackgroundImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBackgroundImageUrlHttps() {
        return this.profileBackgroundImageUrlHttps;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBannerURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ٴسسݬߨ(1393928506);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBannerRetinaURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ۮڭڭܬި(863093195);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBannerIPadURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.دײܮڳܯ(2052894093);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBannerIPadRetinaURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ٴسسݬߨ(1393930194);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBannerMobileURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ݬֲ֮ܲت(1513915183);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBannerMobileRetinaURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ۮڭڭܬި(863092995);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBanner300x100URL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ݮڮֲڭܩ(-627991876);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBanner600x200URL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ٲٴݴ״ٰ(1780527144);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getProfileBanner1500x500URL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + y.ۮڭڭܬި(863094691);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isProfileBackgroundTiled() {
        return this.profileBackgroundTiled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String getLang() {
        return this.lang;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public int getStatusesCount() {
        return this.statusesCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isGeoEnabled() {
        return this.isGeoEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isVerified() {
        return this.isVerified;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isTranslator() {
        return this.translator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public int getListedCount() {
        return this.listedCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public boolean isFollowRequestSent() {
        return this.isFollowRequestSent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public URLEntity[] getDescriptionURLEntities() {
        return this.descriptionURLEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public URLEntity getURLEntity() {
        if (this.urlEntity == null) {
            String str = this.url;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            this.urlEntity = new URLEntityJSONImpl(0, str2.length(), str2, str2, str2);
        }
        return this.urlEntity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.User
    public String[] getWithheldInCountries() {
        return this.withheldInCountries;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static PagableResponseList<User> createPagableUserList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONObject asJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = asJSONObject.getJSONArray("users");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, asJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userJSONImpl, jSONObject);
                }
                pagableResponseListImpl.add(userJSONImpl);
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
    static ResponseList<User> createUserList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        return createUserList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<User> createUserList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                responseListImpl.add(userJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (int) this.f1575id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof User) && ((User) obj).getId() == this.f1575id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-627991100) + this.f1575id + y.ݬֲ֮ܲت(1512211415) + this.name + y.ۮڭڭܬި(863093523) + this.email + y.ٲٴݴ״ٰ(1782495112) + this.screenName + y.دײܮڳܯ(2052892917) + this.location + y.ݮڮֲڭܩ(-627990868) + this.description + y.ۮڭڭܬި(863093435) + this.isContributorsEnabled + y.دײܮڳܯ(2052892181) + this.profileImageUrl + y.ݬֲ֮ܲت(1513918103) + this.profileImageUrlHttps + y.ٲٴݴ״ٰ(1780529904) + this.isDefaultProfileImage + y.ٲٴݴ״ٰ(1782508648) + this.url + y.ݮڮֲڭܩ(-627993876) + this.isProtected + y.دײܮڳܯ(2052891957) + this.followersCount + y.ۮڭڭܬި(863096555) + this.status + y.ݬֲ֮ܲت(1513917359) + this.profileBackgroundColor + y.ۮڭڭܬި(863094819) + this.profileTextColor + y.ٴسسݬߨ(1393926546) + this.profileLinkColor + y.ݬֲ֮ܲت(1513916703) + this.profileSidebarFillColor + y.ݮڮֲڭܩ(-627992796) + this.profileSidebarBorderColor + y.٬ݯح׭٩(575043654) + this.profileUseBackgroundImage + y.ݬֲ֮ܲت(1513920247) + this.isDefaultProfile + y.ٴسسݬߨ(1393933898) + this.showAllInlineMedia + y.ݮڮֲڭܩ(-627996004) + this.friendsCount + y.ݮڮֲڭܩ(-628202404) + this.createdAt + y.ٲٴݴ״ٰ(1780523072) + this.favouritesCount + y.ݬֲ֮ܲت(1513919599) + this.utcOffset + y.ٲٴݴ״ٰ(1780524912) + this.timeZone + y.ݮڮֲڭܩ(-627995516) + this.profileBackgroundImageUrl + y.ݬֲ֮ܲت(1513919055) + this.profileBackgroundImageUrlHttps + y.ٴسسݬߨ(1393932962) + this.profileBackgroundTiled + y.ݮڮֲڭܩ(-628151300) + this.lang + y.ٴسسݬߨ(1393933186) + this.statusesCount + y.ٴسسݬߨ(1393931306) + this.isGeoEnabled + y.֬ڱܱײٮ(-1158288959) + this.isVerified + y.دײܮڳܯ(2052896517) + this.translator + y.ݮڮֲڭܩ(-627998276) + this.listedCount + y.دײܮڳܯ(2052895773) + this.isFollowRequestSent + y.֬ڱܱײٮ(-1158288879) + Arrays.toString(this.withheldInCountries) + '}';
    }
}
