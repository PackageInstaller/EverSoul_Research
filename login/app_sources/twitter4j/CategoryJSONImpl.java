package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class CategoryJSONImpl implements Category, Serializable {
    private static final long serialVersionUID = 3811335888122469876L;
    private String name;
    private int size;
    private String slug;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CategoryJSONImpl(JSONObject jSONObject) throws JSONException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void init(JSONObject jSONObject) throws JSONException {
        this.name = jSONObject.getString(y.ٲٴݴ״ٰ(1781623392));
        this.slug = jSONObject.getString(y.ۮڭڭܬި(862860915));
        this.size = ParseUtil.getInt(y.ݮڮֲڭܩ(-628200668), jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Category> createCategoriesList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        return createCategoriesList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ResponseList<Category> createCategoriesList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArray.length(), httpResponse);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CategoryJSONImpl categoryJSONImpl = new CategoryJSONImpl(jSONObject);
                responseListImpl.add(categoryJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(categoryJSONImpl, jSONObject);
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
    @Override // twitter4j.Category
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Category
    public String getSlug() {
        return this.slug;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Category
    public int getSize() {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CategoryJSONImpl categoryJSONImpl = (CategoryJSONImpl) obj;
        if (this.size != categoryJSONImpl.size) {
            return false;
        }
        String str = this.name;
        if (str == null ? categoryJSONImpl.name != null : !str.equals(categoryJSONImpl.name)) {
            return false;
        }
        String str2 = this.slug;
        String str3 = categoryJSONImpl.slug;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.slug;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628200460) + this.name + y.٬ݯح׭٩(576298078) + this.slug + y.دײܮڳܯ(2051234485) + this.size + '}';
    }
}
