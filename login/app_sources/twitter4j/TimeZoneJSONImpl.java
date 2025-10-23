package twitter4j;

/* loaded from: classes4.dex */
public class TimeZoneJSONImpl implements TimeZone {
    private static final long serialVersionUID = 81958969762484144L;
    private final String NAME;
    private final String TZINFO_NAME;
    private final int UTC_OFFSET;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TimeZoneJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            this.UTC_OFFSET = ParseUtil.getInt("utc_offset", jSONObject);
            this.NAME = jSONObject.getString("name");
            this.TZINFO_NAME = jSONObject.getString("tzinfo_name");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TimeZone
    public String getName() {
        return this.NAME;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TimeZone
    public String tzinfoName() {
        return this.TZINFO_NAME;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TimeZone
    public int utcOffset() {
        return this.UTC_OFFSET;
    }
}
