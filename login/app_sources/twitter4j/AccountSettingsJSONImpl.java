package twitter4j;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.game.StringSet;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.io.Serializable;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class AccountSettingsJSONImpl extends TwitterResponseImpl implements AccountSettings, Serializable {
    private static final long serialVersionUID = 603189815663175766L;
    private final String ALLOW_DMS_FROM;
    private final boolean ALWAYS_USE_HTTPS;
    private final boolean DISCOVERABLE_BY_EMAIL;
    private final boolean GEO_ENABLED;
    private final String LANGUAGE;
    private final String SCREEN_NAME;
    private final String SLEEP_END_TIME;
    private final String SLEEP_START_TIME;
    private final boolean SLEEP_TIME_ENABLED;
    private final TimeZone TIMEZONE;
    private final Location[] TREND_LOCATION;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AccountSettingsJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws TwitterException {
        super(httpResponse);
        String str = y.دײܮڳܯ(2051227709);
        String str2 = y.ٴسسݬߨ(1393181434);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("sleep_time");
            this.SLEEP_TIME_ENABLED = ParseUtil.getBoolean(StringSet.enabled, jSONObject2);
            this.SLEEP_START_TIME = jSONObject2.getString("start_time");
            this.SLEEP_END_TIME = jSONObject2.getString(SDKConstants.PARAM_TOURNAMENTS_END_TIME);
            if (jSONObject.isNull(str2)) {
                this.TREND_LOCATION = new Location[0];
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray(str2);
                this.TREND_LOCATION = new Location[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.TREND_LOCATION[i] = new LocationJSONImpl(jSONArray.getJSONObject(i));
                }
            }
            this.GEO_ENABLED = ParseUtil.getBoolean("geo_enabled", jSONObject);
            this.LANGUAGE = jSONObject.getString(ServerConstants.LANGUAGE_CODE);
            this.ALWAYS_USE_HTTPS = ParseUtil.getBoolean("always_use_https", jSONObject);
            this.DISCOVERABLE_BY_EMAIL = ParseUtil.getBoolean("discoverable_by_email", jSONObject);
            if (jSONObject.isNull(str)) {
                this.TIMEZONE = null;
            } else {
                this.TIMEZONE = new TimeZoneJSONImpl(jSONObject.getJSONObject(str));
            }
            this.SCREEN_NAME = jSONObject.getString(FirebaseAnalytics.Param.SCREEN_NAME);
            this.ALLOW_DMS_FROM = jSONObject.getString("allow_dms_from");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccountSettingsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccountSettingsJSONImpl(JSONObject jSONObject) throws TwitterException {
        this((HttpResponse) null, jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public boolean isSleepTimeEnabled() {
        return this.SLEEP_TIME_ENABLED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public String getSleepStartTime() {
        return this.SLEEP_START_TIME;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public String getSleepEndTime() {
        return this.SLEEP_END_TIME;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public Location[] getTrendLocations() {
        return this.TREND_LOCATION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public boolean isGeoEnabled() {
        return this.GEO_ENABLED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public boolean isDiscoverableByEmail() {
        return this.DISCOVERABLE_BY_EMAIL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public boolean isAlwaysUseHttps() {
        return this.ALWAYS_USE_HTTPS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public String getScreenName() {
        return this.SCREEN_NAME;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public String getLanguage() {
        return this.LANGUAGE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public TimeZone getTimeZone() {
        return this.TIMEZONE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountSettings
    public String getAllowDmsFrom() {
        return this.ALLOW_DMS_FROM;
    }
}
