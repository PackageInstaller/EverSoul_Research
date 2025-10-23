package twitter4j;

import com.liapp.y;
import twitter4j.api.HelpResources;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
public class LanguageJSONImpl implements HelpResources.Language {
    private static final long serialVersionUID = 7494362811767097342L;
    private String code;
    private String name;
    private String status;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LanguageJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.name = jSONObject.getString("name");
            this.code = jSONObject.getString("code");
            this.status = jSONObject.getString("status");
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + y.ݬֲ֮ܲت(1512942399) + jSONObject.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources.Language
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources.Language
    public String getCode() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources.Language
    public String getStatus() {
        return this.status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<HelpResources.Language> createLanguageList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        return createLanguageList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<HelpResources.Language> createLanguageList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                LanguageJSONImpl languageJSONImpl = new LanguageJSONImpl(jSONObject);
                responseListImpl.add(languageJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(languageJSONImpl, jSONObject);
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
}
